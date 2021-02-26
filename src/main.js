import Vue from 'vue'
import itest from './itest.vue'
import './plugins/element.js'
import './assets/css/global.css'
import router from './router'
import axios from 'axios'
import qs from 'qs'
import VueCoreVideoPlayer from 'vue-core-video-player'

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
