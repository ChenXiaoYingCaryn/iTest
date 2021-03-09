<template>
    <div class="container">
        <top-nav></top-nav>
        <div class="wrapper">
            <!-- 播放模块 -->
            <div class="video-play"><video-play :videoId="videoId"></video-play></div>
            <!-- 视频推荐模块 -->
            <div class="video-recommend"><video-recommend v-for="(item,index) in videoList" :key="index" :item='item'></video-recommend></div>
            <!-- 评论模块 -->
            <div class="video-comment"><video-comment></video-comment></div>
        </div>
        <foot></foot>
    </div>
</template>

<script>
import Foot from '../components/foot.vue'
import VideoComment from '../components/play/video-comment.vue'
import VideoPlay from '../components/play/video-play.vue'
import VideoRecommend from '../components/play/video-recommend.vue'
import topNav from '../components/topNav.vue'

export default {
  components: { VideoPlay, VideoRecommend, Foot, VideoComment, topNav },
  name: 'play',
  data () {
    return {
      videoList: {},
      videoId: ''
    }
  },
  methods: {
    getVideoList: function () {
      this.$http({
        method: 'get',
        url: '/index/video/queryVideo/0/4'
      }).then(
        ({ data: res }) => {
          this.videoList = res.data
        },
        ({ data: res }) => {
          console.log('网络错误！')
        }
      )
    },
    getVideoId () {
      this.videoId = this.$route.query.dogv
      console.log('dogv is' + this.videoId)
    }
  },
  created () {
    this.getVideoList()
    this.getVideoId()
  }
}
</script>

<style scoped>
/* grid布局，在页面缩小后，推荐模块移动到播放模块下面 */
.container {
    /* background-color: #302f2d; */
}

.wrapper {
    margin: 0 auto;
    width: 1200px;
    /* background-color: aqua; */
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: auto auto;
}

.video-play {
    grid-column-start: 1;
    grid-column-end: 3;
    grid-row-start: 1;
    grid-row-end: 2;
    /* background-color: pink; */
}
.video-comment {
    grid-column-start: 1;
    grid-column-end: 3;
    grid-row-start: 2;
    grid-row-end: 3;
    /* background-color: sandybrown; */
}

.video-recommend {
    grid-column-start: 3;
    grid-column-end: 4;
    grid-row-start: 1;
    grid-row-end: 2;
    /* background-color: aqua; */
}

.video-comment,.video-play,.video-recommend {
    display: inline-block;
}

@media screen and (max-width: 1200px) {
    .wrapper {
        width: 90%;
        grid-template-rows: auto;
    }
    .video-play {
        grid-column-end: 4;
        grid-row-start: 1;
        grid-row-end: 2;
    }
    .video-comment {
        grid-column-end: 4;
        grid-row-start: 3;
        grid-row-end: 4;
    }

    .video-recommend {
        grid-column-start: 1;
        grid-column-end: 4;
        grid-row-start: 2;
        grid-row-end: 3;
    }
}
</style>
