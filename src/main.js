import Vue from 'vue'
import itest from './itest.vue'
import router from './router'

// 引入axios并挂载
import axios from 'axios'

// 引入qs,qs用于解决前端发送json后端时x-www-form的格式问题
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

// 引入上传组件
import uploader from 'vue-simple-uploader'
Vue.prototype.$http = axios
Vue.prototype.$qs = qs
Vue.use(uploader)

Vue.use(VueCoreVideoPlayer, {
  lang: 'zh-CN'
})

// 接口地址
axios.defaults.baseURL = 'http://106.53.135.86:10000/'

Vue.prototype.calculateTimeDiff = function (createTime) {
  let videoTimeDiff = ''
  const newTime = new Date() // 获取现在的时间
  var updateTime = new Date(Date.parse(createTime)) // 转换上传时间字符串为date
  const timeDiff = newTime.getTime() - updateTime.getTime() // 现在时间距离上传时间的时间差（毫秒）
  const dayDiff = timeDiff / (24 * 3600 * 1000) // 天数差

  if (dayDiff >= 7) {
    const weekDiff = dayDiff / 7
    if (weekDiff >= 4) {
      const monthDiff = dayDiff / 30
      if (monthDiff >= 12) {
        videoTimeDiff = Math.floor(monthDiff / 12) + '年前'
        return videoTimeDiff
      }
      videoTimeDiff = Math.floor(monthDiff) + '个月前'
      return videoTimeDiff
    }
    videoTimeDiff = Math.floor(weekDiff) + '周前'
    return videoTimeDiff
  } else if (dayDiff < 1) {
    const hourDiff = dayDiff * 24
    if (hourDiff < 1) {
      const minuteDiff = hourDiff * 60
      if (minuteDiff < 3) {
        videoTimeDiff = '刚刚'
        return videoTimeDiff
      }
      videoTimeDiff = Math.floor(minuteDiff) + '分钟前'
      return videoTimeDiff
    }
    videoTimeDiff = Math.floor(hourDiff) + '小时前'
    return videoTimeDiff
  } else {
    videoTimeDiff = Math.floor(dayDiff) + '天前'
    return videoTimeDiff
  }
}

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(itest)
}).$mount('#app')
