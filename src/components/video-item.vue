<template>
  <div class="related-video-item">
    <div class="top-img" @click="goPlay(item.video_id)">
      <img :src="item.video_img" alt="">
    </div>
    <div class="video-content">
      <a href="#" class="video-title" :title="item.video_title">{{item.video_title}}</a>
      <div class="content-bottom">
        <div class="content-left">
          <img :src="item.user_image" alt="">
        </div>
        <div class="content-right">
          <a href="#" class="video-up">{{item.user_name}}</a>
          <div class="video-uptime">{{item.create_time}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'video-item',
  props: {
    item: Object
  },
  data () {
    return {
      video_title: '',
      user_id: '',
      create_time: '',
      videoTimeDiff: ''
    }
  },
  created () {
    this.simplifyViews()
    // this.calculateTimeDiff()
  },
  methods: {
    simplifyViews: function () {
      if (this.videoViews > 9999) { this.videoViews = Math.floor(this.videoViews / 10000) + '万' }
    },
    calculateTimeDiff: function () {
      const newTime = new Date()
      const updateTime = new Date(this.create_time)
      const timeDiff = newTime.getTime() - updateTime.getTime()
      const dayDiff = timeDiff / (24 * 3600 * 1000)

      if (dayDiff >= 7) {
        const weekDiff = dayDiff / 7
        if (weekDiff >= 4) {
          const monthDiff = dayDiff / 30
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
        if (hourDiff < 1) {
          const minuteDiff = hourDiff * 60
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
    },
    goPlay (videoId) {
      this.$router.push({
        path: '/play',
        query: {
          dogv: videoId
        }
      })
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
  border-radius: 5px;
}

.top-img img:hover {
  transform: scale(1.5);
  transition: .5s;
  animation-direction:alternate;
}

.top-img img, .video-content .content-left img {
  max-width: 100%;
}

.top-img .top-video-label {
  position: absolute;
  color: #ffffff;
  font-size: 12px;
  text-shadow: 0px 0px 7px rgba(0, 0, 0, .9);
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
