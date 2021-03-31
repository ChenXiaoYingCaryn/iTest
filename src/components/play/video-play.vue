<template>
  <div>
    <!-- 视频标题 -->
    <h2 class="title">{{this.videoInfo.video_title}}</h2>
    <div class="video-info">
      <span>{{this.videoInfo.videoViews}}播放</span>
      <span>{{this.calculateTimeDiff(videoInfo.create_time)}}</span>
    </div>
    <!-- 播放器 -->
    <vue-core-video-player id="player" :src="this.productList.video_url">
    </vue-core-video-player>
    <!-- 点赞反对转发 -->
    <div class="tool-bar">
      <a class="tool-item" :class="this.isAgree?'clicked-style':''" @click="clickedAgree"><i
          class="fa fa-thumbs-up fa-2x"></i>&nbsp;1.2万</a>
      <div class="tool-item" :class="this.isDisagree?'clicked-style':''" @click="clickedDisagree"><i
          class="fa fa-thumbs-down fa-2x"></i>&nbsp;反对</div>
      <div class="tool-item" :class="this.isCollect?'clicked-style':''" @click="clickedCollect"><i
          class="fa fa-bookmark fa-2x"></i>&nbsp;收藏</div>
      <div class="tool-item" @click="clickedForward" style="border-bottom: 3px solid Transparent;"><i
          class="fa fa-share-alt fa-2x"></i>转发</div>
    </div>
    <!-- up主信息 -->
    <div class="up">
      <div class="avatar"><img :src="this.videoInfo.user_image" alt=""></div>
      <span>{{this.videoInfo.user_name}}</span>
    </div>
    <div class="video-text-box">
      <p>
        <el-collapse>
          <el-collapse-item title="展开查看视频简介">
            {{this.videoInfo.video_introduction}}
          </el-collapse-item>
        </el-collapse>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'video-play',
  props: {
    videoId: String
  },
  data () {
    return {
      videoViews: '221万',
      url: '',
      videoInfo: {
        create_time: '2019/4/21 10:08:33',
        user_image: '',
        user_name: '',
        video_id: '',
        video_img: '',
        video_introduction: '',
        video_title: 'aaa',
        video_url: ' '
      },
      isAgree: false,
      isDisagree: false,
      isClicked: false,
      isCollect: false
    }
  },
  mounted () {
    this.getVideoInfo()
  },
  methods: {
    getVideoInfo () {
      console.log('videoId is' + this.videoId)
      this.$http({
        method: 'get',
        url: '/index/video/queryById/' + this.videoId
      }).then(
        ({ data: res }) => {
          this.url = res.data.video_url
          this.productList = res.data
          this.videoInfo = res.data
        },
        ({ data: res }) => {
          console.log('网络错误!')
        }
      )
    },
    clickedAgree: function () {
      if (this.isDisagree) { this.isDisagree = !this.isDisagree }
      this.isAgree = !this.isAgree
    },
    clickedDisagree: function () {
      if (this.isAgree) { this.isAgree = !this.isAgree }
      this.isDisagree = !this.isDisagree
    },
    clickedForward: function () {
      this.isForward = !this.isForward
    },
    clickedCollect: function () {
      this.isCollect = !this.isCollect
    }
  }
}
</script>

<style scoped>
.title {
  overflow: hidden;
  margin: 15px 0 1px 0;
  /* 解决文字溢出 */
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
  -moz-box-orient: vertical;
}

.video-info {
  color: #999;
  display: flex;
  margin-bottom: 10px;
}

.video-info span {
  margin-right: 10px;
}

#player {
  height: 450px;
}

.tool-bar {
  display: flex;
  margin: 10px auto;
  border-bottom: 1px solid #EBEEF5;
  /* background-color: white; */
}

.tool-bar .tool-item {
  margin-right: 5%;
  cursor: pointer;
  color: #909090;
}

.tool-bar .clicked-style {
  border-bottom: 3px solid #FFCF40;
  color: #FFCF40;
}

.up {
  display: flex;
}

.up span {
  color: #909090;
  font-size: 16px;
  align-items: center;
  margin-left: 5px;
}

.up .avatar {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  overflow: hidden;
}

.up .avatar img {
  max-width: 100%;
  max-height: 100%;
}

.video-text-box {
  padding-left: 55px;
}

.video-text-box >>> .el-collapse-item__wrap {
  border-top-color: #FFCF40 !important;
}

@media screen and (max-width:768px) {
  #player {
    height: 300px;
  }
}
</style>
