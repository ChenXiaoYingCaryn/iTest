<template>
  <div class="related-video-item">
    <div class="top-img">
      <img src="./marking/marking-img/beauty.jpg" alt="">
      <span class="top-video-label top-video-audience el-icon-view">{{videoViews}}</span>
      <span class="top-video-label top-video-time">{{videoTime}}</span>
    </div>
    <div class="video-content">
      <a href="#" class="video-title" :title="videoTitle">{{videoTitle}}</a>
      <div class="content-bottom">
        <div class="content-left">
          <img src="./marking/marking-img/upimg.jpg" alt="">
        </div>
        <div class="content-right">
          <a href="#" class="video-up">{{videoUpdater}}</a>
          <div class="video-uptime">{{videoTimeDiff}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'video-item',
  data () {
    return {
      videoTime: '4:17',
      videoTitle: '[MV]なんでもないや Cover (nandemonaiya) - radwimps Cover by yurisa [君の名はost]',
      videoUpdater: 'yurisa',
      videoUpdateTime: '2019/4/21 10:08:33',
      videoViews: 2212294,
      videoTimeDiff: ''
    }
  },
  created () {
    this.simplifyViews()
    this.calculateTimeDiff()
  },
  methods: {
    simplifyViews: function () {
      if (this.videoViews > 9999) { this.videoViews = Math.floor(this.videoViews / 10000) + '万' }
    },
    calculateTimeDiff: function () {
      const newTime = new Date()
      const updateTime = new Date(this.videoUpdateTime)
      const timeDiff = newTime.getTime() - updateTime.getTime()
      const secondDiff = timeDiff / 1000
      console.log(secondDiff + '秒')
      const dayDiff = timeDiff / (24 * 3600 * 1000)
      console.log(dayDiff + '天')
      console.log('success2')

      if (dayDiff >= 7) {
        const weekDiff = dayDiff / 7
        console.log(weekDiff + '周')
        if (weekDiff >= 4) {
          const monthDiff = dayDiff / 30
          console.log(monthDiff + '月')
          if (monthDiff >= 12) {
            this.videoTimeDiff = Math.floor(monthDiff / 12) + '年前'
            return
          }
          this.videoTimeDiff = Math.floor(monthDiff) + '个月前'
          return
        }
        this.videoTimeDiff = Math.floor(weekDiff) + '周前'
      } else if (dayDiff < 1) {
        const hourDiff = dayDiff * 24
        console.log(hourDiff + '时')
        if (hourDiff < 1) {
          const minuteDiff = hourDiff * 60
          console.log(minuteDiff + '分')
          if (minuteDiff < 3) {
            this.videoTimeDiff = '刚刚'
            return
          }
          this.videoTimeDiff = Math.floor(minuteDiff) + '分钟前'
          return
        }
        this.videoTimeDiff = Math.floor(hourDiff) + '小时前'
      } else {
        this.videoTimeDiff = Math.floor(dayDiff) + '天前'
      }
    }
  }
}

</script>

<style scoped>
.related-video-item {
  width: 280px;
}

/* 视频推荐图片和上面的参数 */
.top-img {
  cursor: pointer;
  position: relative;
  height: 157.5px;
  overflow: hidden;
}

.top-img img:hover {
  transform: scale(1.5);
  transition: .5s;
  animation-direction:alternate;
}

.top-img img, .video-content .content-left img {
  max-width: 100%;
  max-height: 100%;
}

.top-img .top-video-label {
  position: absolute;
  color: #ffffff;
  font-size: 12px;
  text-shadow: 0px 0px 7px rgba(0, 0, 0, .9);
}

.top-img .top-video-time {
  right: 10px;
  bottom: 5px;
}

.top-img .top-video-audience {
  left: 10px;
  bottom: 5px;
}

.video-content a {
  display: block;
  margin: 0 auto;
}

.video-content .video-title {
  height: 45px;
  overflow: hidden;
  margin: 5px 0 8px;

  /* 解决文字溢出 */
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  -moz-box-orient: vertical;
}

.video-content .content-bottom {
  display: flex;
}

.video-content .content-bottom .content-left {
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background-color: aqua;
  overflow: hidden;
}

.video-content .content-bottom .content-right {
  margin-left: 10px;
}

.video-content .content-bottom .content-right .video-up,
.video-uptime {
  font-size: 14px;
  color: #999;
}

</style>
