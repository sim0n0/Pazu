export default {
    name: 'HomePage',
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
                method:"get",
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