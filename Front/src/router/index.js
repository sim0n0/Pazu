import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login/component.vue'
import Register from '../components/Register/component.vue'
import HomePage from '../components/HomePage/component.vue'


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
  {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },

]

const router = new VueRouter({
  routes
})

export default router