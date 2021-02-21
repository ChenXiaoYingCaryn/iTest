import Vue from 'vue'
import itest from './itest.vue'
import './plugins/element.js'
import './assets/css/global.css'
import router from './router'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(itest)
}).$mount('#app')
