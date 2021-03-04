import Vue from 'vue'
import VueRouter from 'vue-router'

const home = () => import('../views/home.vue')
const login = () => import('../views/login.vue')
const test = () => import('../views/test.vue')
const marking = () => import('../views/marking.vue')
const play = () => import('../views/play.vue')
const error = () => import('../components/error/error.vue')
const search = () => import('../views/search.vue')

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: '',
      component: login
    },
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/marking',
      name: 'marking',
      component: marking
    },
    {
      path: '/play',
      name: 'play',
      component: play
    },
    {
      path: '/search',
      name: 'search',
      component: search
    },
    {
      path: '/*',
      name: 'error',
      component: error
    }
  ]
})

// 路由守卫
router.beforeEach((to, from, next) => {
  // to:要去的地方；from:来的地方；next:函数，表示放行；
  if (to.path === '/login') { return next() }

  const tokenStr = window.sessionStorage.getItem('token')
  if (!tokenStr) { return next('/login') }
  next()
})

export default router
