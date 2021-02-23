<template>
  <div class="related-video-item">
    <div class="top-img">
      <img src="./marking/marking-img/beauty.jpg" alt="">
      <span class="top-video-label top-video-audience el-icon-view">{{videoViews}}</span>
      <span class="top-video-label top-video-time">{{videoTime}}</span>
    </div>
    <div class="video-content">
      <a href="#" class="video-title" :title="videoTitle">{{videoTitle}}</a>
      <a href="#" class="video-up">{{videoUpdater}}</a>
      <div class="video-uptime">{{videoTimeDiff}}</div>
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
      videoUpdateTime: '2021/2/20 00:35:33',
      videoViews: '10万',
      videoTimeDiff: ''
    }
  },
  created () {
    this.calculateTimeDiff()
  },
  methods: {
    calculateTimeDiff: function () {
      console.log('success')
      const that = this
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
          const monthDiff = weekDiff / 7
          console.log(monthDiff + '月')
          if (monthDiff >= 12) {
            that.videoTimeDiff = Math.floor(monthDiff / 12) + '年前'
            return
          }
          that.videoTimeDiff = Math.floor(monthDiff) + '个月前'
          return
        }
        that.videoTimeDiff = Math.floor(weekDiff) + '周前'
      } else if (dayDiff < 1) {
        const hourDiff = dayDiff / 24
        console.log(hourDiff + '时')
        if (hourDiff < 1) {
          const minuteDiff = hourDiff / 60
          console.log(minuteDiff)
          if (minuteDiff < 3) {
            that.videoTimeDiff = '刚刚'
            return
          }
          that.videoTimeDiff = Math.floor(minuteDiff) + '分钟前'
          return
        }
        that.videoTimeDiff = Math.floor(hourDiff) + '小时前'
      } else {
        that.videoTimeDiff = Math.floor(dayDiff) + '天前'
      }
    }
  }
}

</script>

<style scoped>
.related-video-item {
  width: 280px;
  /* height: 260px; */
  background-color: pink;
}

/* 视频推荐图片和上面的参数 */
.related-video-item .top-img {
  cursor: pointer;
  position: relative;
  height: 157.5px;
  overflow: hidden;
}

.related-video-item .top-img img:hover {
  transform: scale(1.5);
  transition: .5s;
  animation-direction:alternate;
}

.related-video-item .top-img img {
  /* width: auto;
  height: auto; */
  max-width: 100%;
  max-height: 100%;
}

.related-video-item .top-img .top-video-label {
  background-color: #EFCD6D;
  position: absolute;
}

.related-video-item .top-img .top-video-time {
  right: 0;
  bottom: 0;
}

.related-video-item .top-img .top-video-audience {
  left: 0;
  bottom: 0;
}

.related-video-item .video-content a {
  display: block;
  margin: 0 auto;
}

.related-video-item .video-content .video-title {
  height: 40px;
  overflow: hidden;
  margin: 5px 0 8px;

  /* 解决文字溢出 */
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}

.related-video-item .video-content .video-up,
.video-uptime {
  font-size: 14px;
  color: #999;
}

</style>
