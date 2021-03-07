import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
//导入全局样式表
import './assets/css/global.css'
import axios from 'axios'
Vue.config.productionTip = false

//配置请求根路径
axios.defaults.baseURL = 'http://106.53.135.86:10000/'
Vue.prototype.$http = axios
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
