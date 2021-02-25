import Vue from 'vue'
import itest from './itest.vue'
import './plugins/element.js'
import './assets/css/global.css'
import router from './router'
import axios from 'axios'

Vue.prototype.$http = axios
axios.defaults.baseURL = 'http://159.75.110.59:10000/'
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(itest)
}).$mount('#app')
