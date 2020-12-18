export default {
    name: 'HomePage',
    data: function() {
        return {
            title:'',
            place:'',
            propositions:[],
            list:[]
        }
    },
    computed: {

    },
    methods: {
        sondage(){
                    this.$axios({
                                    method:"post",
                                    url:"/api/sondage/create",
                                    data:{
                                        "title":this.title,
                                        "place":this.place,
                                        "propositions":this.propositions
                                    },
                                    headers:{
                                        "Authorization":"Bearer "+this.$session.get("token")
                                    }
                                }).then(()=>{
                                    this.refresh()
                                }).catch((error)=>{
                                    console.log(error.data)
                                })
                },
                refresh(){
                    this.$axios({
                        method:"get",
                        url:"/api/sondage/",
                        headers:{
                             "Authorization":"Bearer "+this.$session.get("token")
                        }
                    }).then((respond)=>{
                        this.list=respond.data
                    })
                },
                reset(){
                    this.title=""
                    this.place=""
                    this.date=""
                    this.start=""
                    this.finish=""
                },
                addProposition(){
                    this.propositions.push({
                        "date":this.date,
                        "start":this.start,
                        "finish":this.finish
                    })
                },
                async vote(action, id){
                    await this.$axios({
                        method:"patch",
                        url:"/api/vote/"+id+"/vote"+action,
                        headers:{
                            "Authorization":"Bearer "+this.$session.get("token")
                        }
                    })
                    this.refresh()
                },

    },
    components: {

    },
    mounted: function(){
        if(this.$store.state.auth){
            this.refresh()
        }

    }
}