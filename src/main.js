import Vue from 'vue'
import itest from './itest.vue'
import './plugins/element.js'
import './assets/css/global.css'
import router from './router'
import axios from 'axios'
import qs from 'qs'
import VueCoreVideoPlayer from 'vue-core-video-player'

// 引入font-awesome图标库
import 'font-awesome/css/font-awesome.min.css'

// 更换主题
import './assets/css/element-#FFCF40/index.css'

Vue.use(VueCoreVideoPlayer, {
  lang: 'zh-CN'
})

Vue.prototype.$http = axios
Vue.prototype.$qs = qs
axios.defaults.baseURL = 'http://159.75.110.59:10001/'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(itest)
}).$mount('#app')
