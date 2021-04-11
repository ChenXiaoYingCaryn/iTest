<template>
    <div class="fish-video-com">
        <!-- 手机 -->
        <div class="videoAdvise">
            <div class="specialTitle">
                <a><span style="cursor:pointer">鱼病相关视频</span></a>
                <a><span style="cursor:pointer">更多>></span></a>
            </div>
            <div class="specialVideo">
                <div class="related-video-item" v-for="item in fishVideoList" :key="item.video_id">
                    <video-item :item="item"></video-item>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import videoItem from '../video-item'
export default {
  components: { videoItem },
  name: 'fish-video-com',
  props: {
    fishVideoList: {}
  },
  data () {
    return {
      videoTime: '4:17',
      videoUpdateTime: '2019/4/21 10:08:33',
      videoViews: 2212294,
      videoTimeDiff: '',
      activeName: '1'
    }
  }
}
</script>

<style scoped>
    .fish-video-com{
        width: 1200px;
        margin: 0 auto;
        display: grid;
    }
    .videoAdvise{
        display: grid;
        height: 660px;
        grid-template-rows: 110px 550px;
        place-items: center center;
    }
    .specialTitle{
        width: 95%;
        font-weight: 900;
        font-size: 26px;
        margin: 5px 0;
    }
    .specialTitle a:nth-child(2) span{
        float: right;
    }
    .specialVideo{
        width: 95%;
        margin: 0 0 20px 0;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr ;
        place-items: center center;
        grid-row-gap: 3%;
        grid-column-gap: 2%;
    }
    .specialVideo div a img{
        border-radius: 15px;
    }
   a {
  color: #999;
    }
    a:hover{
    color: #686464;
    }
    .related-video-item {
    width: 280px;
    }

</style>
