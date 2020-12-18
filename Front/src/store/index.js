import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    auth:false
  },
  mutations: {
    setAuth(state,value){
        state.auth=value
    }

  },
  actions: {
  },
  modules: {
  },
  getters: {
    auth:state=>state.auth
  }
})