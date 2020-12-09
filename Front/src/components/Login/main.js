/* eslint-disable no-console */
export default {
    name: 'Login',
    data: function() {
        return {
            tmp:false,
            username:''
        }
    },
    computed: {

    },
    methods: {
        onSubmit(){
            console.log(this.username)
        }
    },
    components: {

    },
    mounted: function(){

    }
}