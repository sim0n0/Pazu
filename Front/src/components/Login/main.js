export default {
    name: 'Login',
    data: function() {
        return {
            tmp:false,
            username:''
            ,password:''
        }
    },
    computed: {

    },
    methods: {
        onSubmit(){
            console.log(this.username)
            console.log(this.password)
            this.$axios({
                method:"post",
                url:"/api/user/login",
                data:{
                    "userName":this.username,
                    "password":this.password
                }
                //headers:{
                //    "Authorization":"Bearer "+this.$session.get("token")
               // }
            }).then((respond)=>{
                console.log(respond.data)
                this.$session.set("token",respond.data.token)
                this.$store.commit("setAuth",true)
                this.$router.push('/')
            }).catch((error)=>{
                console.log(error.data)
            })
        }
    },
    components: {

    },
    mounted: function(){

    }
}