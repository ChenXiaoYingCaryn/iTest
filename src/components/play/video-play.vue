<template>
  <div>
    <!-- 视频标题 -->
    <h2 class="title">{{videoInfo.video_title}}</h2>
    <div class="video-info">
      <span>{{videoInfo.videoViews}}播放</span>
      <span>{{videoInfo.create_time}}</span>
    </div>
    <!-- 播放器 -->
    <vue-core-video-player id="player"
      :src="$store.state.video_url">
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
      <div class="avatar"><img :src="upInfo.avatarSrc" alt=""></div>
      <span>{{upInfo.upName}}</span>
    </div>
    <div class="video-text-box">
      <p>
        <el-collapse>
          <el-collapse-item title="展开查看视频简介">
            {{videoInfo.video_introduction}}
          </el-collapse-item>
        </el-collapse>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      videoId: '',
      videoInfo: {
        video_title: 'aaa',
        create_time: '2019/4/21 10:08:33',
        videoViews: '221万',
        video_introduction: ''
      },
      upInfo: {
        avatarSrc: '../marking/marking-img/upimg.jpg',
        upName: 'yurisa'
      },
      isAgree: false,
      isDisagree: false,
      isClicked: false,
      isCollect: false
    }
  },
  created () {
    this.getVideoId()
    this.getVideoInfo()
  },
  methods: {
    getVideoId: function () {
      this.videoId = this.$store.state.playInfo.video_id
      console.log('video_id is' + this.videoId)
      console.log('video_title is' + this.video)
    },
    getVideoInfo: function () {
      this.$http({
        method: 'get',
        url: '/index/video/queryById/' + this.videoId
      }).then(
        ({ data: res }) => {
          console.log(res.data)
          this.productList = res.data
          this.videoInfo.video_title = this.productList.video_title
          this.videoInfo.create_time = this.productList.create_time
          this.videoInfo.video_introduction = this.productList.video_introduction
          this.upInfo.avatarSrc = this.productList.user_image
          this.upInfo.upName = this.productList.user_name
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
  font-size: 18px;
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

@media screen and (max-width:1200px) {
  #player {
    height: 300px;
  }
}
</style>
