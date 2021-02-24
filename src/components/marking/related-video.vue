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
        <video-item></video-item>
        <video-item></video-item>
        <video-item></video-item>
        <video-item></video-item>
      </div>

    </div>

  </div>
</template>

<script>
import videoItem from '../video-item.vue'
export default {
  components: { videoItem },
  name: 'related-video',
  data () {
    return {
    }
  },
  methods: {
    function () {
    }
  },
  created: function () {
  },
  mounted: {
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

</style>
