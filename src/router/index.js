import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '../views/home.vue' 
import partition from '../views/partition.vue'
import products from '../views/products.vue'
// import topNav from '../components/topNav.vue'
// import functionNav from '../components/functionNav.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    // {path: '/', redirect:'/home'},
    {path: '/home', component: home},
    {path: '/partition', component: partition},
    {path: '/products', component: products}
  ]
})

export default router
