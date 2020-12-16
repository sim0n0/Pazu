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
            }).then((respond)=>{
                console.log(respond.data)
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