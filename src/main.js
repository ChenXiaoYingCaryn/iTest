import Vue from 'vue'
import itest from './itest.vue'
import router from './router'
import axios from 'axios'
import qs from 'qs'

// 装载vuex
import store from './store'

import './plugins/element.js'
import './assets/css/global.css'

// 引入font-awesome图标库
import 'font-awesome/css/font-awesome.min.css'

// 更换主题色为#FFCF40
import './assets/css/element-#FFCF40/index.css'

// 引入播放器组件
import VueCoreVideoPlayer from 'vue-core-video-player'

Vue.prototype.$http = axios

// 引入qs,qs用于解决前端发送json后端时x-www-form的格式问题
Vue.prototype.$qs = qs
Vue.use(VueCoreVideoPlayer, {
  lang: 'zh-CN'
})

// 接口地址
axios.defaults.baseURL = 'http://106.53.135.86:10000/'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(itest)
}).$mount('#app')
