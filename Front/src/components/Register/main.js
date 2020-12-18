export default {
    name: 'Register',
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
                url:"/api/user/register",
                data:{
                    "userName":this.username,
                    "password":this.password
                }
                //headers:{
                //    "Authorization":"Bearer "+this.$session.get("token")
               // }
            }).then(()=>{
                this.$router.push('/login')
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