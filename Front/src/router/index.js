import Vue from 'vue'
import VueRouter from 'vue-router'
//import Home from '../views/Home.vue'
import Login from '../components/Login/component.vue'
import Register from '../components/Register/component.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
      path: '/register',
      name: 'Register',
      component: Register
    },
]

const router = new VueRouter({
  routes
})

export default router