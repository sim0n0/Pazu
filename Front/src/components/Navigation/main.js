/* eslint-disable no-console */
export default {
    name: 'Navigation',
    data: function() {
        return {

        }
    },
    computed: {

    },
    methods: {
        logout(){
            this.$session.remove('token')
            this.$store.commit("setAuth",false)
            this.$forceUpdate()
        },

    },
    components: {

    },
    mounted: function(){

    }
}