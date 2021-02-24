<template>
  <div>
    <div class="container">
      <div class="related-top">
        <div class="container-title-large">相关视频</div>
        <div class="more-btn">
          <el-button plain type="mini">换一换<span class="el-icon-refresh"></span></el-button>
          <el-button plain type="mini">更多<span class="el-icon-arrow-right"></span></el-button>
        </div>
      </div>
      <div class="related-video-list">
        <div class="related-video-item">
          <div class="top-img">
            <img src="./marking-img/beauty.jpg" alt="">
            <span class="top-video-label top-video-audience el-icon-view">{{videoViews}}</span>
            <span class="top-video-label top-video-time">{{videoTime}}</span>
          </div>
          <div class="video-content">
            <a href="#" class="video-title" :title="videoTitle">{{videoTitle}}</a>
            <a href="#" class="video-up" >{{videoUpdater}}</a>
            <div>{{videoUpdateTime}}</div>
          </div>
        </div>
        <div class="related-video-item"></div>
        <div class="related-video-item"></div>
        <div class="related-video-item"></div>
      </div>

    </div>

  </div>
</template>

<script>
export default {
  name: 'related-video',
  data () {
    return {
      videoTime: '4:17',
      videoTitle: '[MV]なんでもないや Cover (nandemonaiya) - radwimps Cover by yurisa [君の名はost]',
      videoUpdater: 'yurisa',
      videoUpdateTime: '2018/2/21 10:08:33',
      videoViews: '10万'
    }
  },
  methods: {
    function () {
    }
  },
  created: function () {
  },
  mounted: {
    calculateTimeDiff () {
      var newTime = new Date()
      var updateTime = new Date(this.videoUpdateTime)
      var timeDiff = newTime.getTime() - updateTime.getTime()
      var dayDiff = Math.floor(timeDiff / (24 * 3600 * 1000))
      console.log(dayDiff + '天')
      var weekDiff = dayDiff / 7
      console.log(weekDiff + '周')
      var monthDiff = dayDiff / 30
      console.log(monthDiff + '月')
      var yearDiff = monthDiff / 12
      console.log(yearDiff + '年')
    }
  }
}
</script>

<style scoped>
*{
  box-sizing: border-box;
}
.container {
    /* margin: 10px 10vw; */
    /* margin: 0 10vw; */
    background-color: bisque;
}

/* 标题及按钮 */
.related-top {
  position: relative;
}

.more-btn {
  position: absolute;
  top: 50%;right: 0;
  transform: translateY(-50%);
  display: flex;
  background-color: green;
}

.el-button {
  padding-left: 8px;
  padding-right: 5px;
}

.container-title-large {
    color: #EFCD6D;
    font-size: 30px;
    font-weight: bold;
    margin-bottom: 15px;
    margin-left: 15px;
    line-height: 50px;
}

/* 视频推荐块布局 */
.related-video-list {
  display: flex;
  justify-content: space-between;
}

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
}

.related-video-item .top-img:hover {

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
  right: 0;bottom: 0;
}

.related-video-item .top-img .top-video-audience {
  left: 0;bottom: 0;
}

.related-video-item .video-content a{
  display: block;
  margin: 0 auto;
}

.related-video-item .video-content .video-title {
  height: 38px;
  overflow: hidden;
  margin: 10px 0 8px;

  /* 解决文字溢出 */
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}

.related-video-item .video-content .video-up {
  font-size: 14px;
  color: #999;
}

</style>
