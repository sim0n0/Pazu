import Vue from 'vue'
// import App from './App.vue'
import router from './router'
import store from './store'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Pazi from './components/Navigation/component.vue'
import VueSession from 'vue-session'
import axios from 'axios'
import Navigation from './components/Navigation/component.vue'
import HomePage from './components/HomePage/component.vue'

Vue.use(BootstrapVue)
Vue.use(VueSession)
axios.defaults.baseURL='http://localhost:8081'
Vue.prototype.$axios=axios
Vue.config.productionTip = false

new Vue({
  router,
  store,
  Navigation,
  HomePage,
  render: h => h(Pazi)
}).$mount('#app')