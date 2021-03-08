<template>
    <div class="specialArea">
        <!-- 手机 -->
        <div class="videoAdvise">
            <div class="specialTitle">
                <a @click="more"><span style="cursor:pointer">{{this.videoPartName}}</span></a>
                <a @click="more"><span style="cursor:pointer">更多>></span></a>
            </div>
            <div class="specialVideo">
                <div class="related-video-item" v-for="item in videoPhoneList" :key="item.video_id">
                    <video-item :item="item"></video-item>
                </div>
            </div>
        </div>
        <div class="gameRanking">
            <div class="gameRankingTitle">
                <span>排行榜</span>
            </div>
            <div class="Rankingpic">
                <div class="block">
                    <el-carousel height="500px">
                        <el-carousel-item v-for="item in rankingPhoneList" :key="item.type_id">
                            <div><img v-bind:src="item.type_image" width="100%"></div>
                        </el-carousel-item>
                    </el-carousel>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import videoItem from './video-item.vue'
// import videoItem from '../components/video-item'
export default {
  components: { videoItem },
  name: 'special',
  props: {
    videoPartName: {},
    videoPhoneList: {},
    videoPadList: {},
    videoLaptopList: {},
    rankingPhoneList: {},
    rankingPadList: {},
    rankingLaptopList: {}

  },
  data () {
    return {
      videoTime: '4:17',
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
    more () {
      this.$router.push('/partition')
    },
    simplifyViews: function () {
      if (this.videoViews > 9999) { this.videoViews = Math.floor(this.videoViews / 10000) + '万' }
    }
  }
}
</script>

<style scoped>
    .specialArea{
        width: 80%;
        margin: 0 auto;
        display: grid;
        grid-template-columns: 3fr 1fr;
        grid-column-gap: 3%;

    }
    .videoAdvise{
        display: grid;
        grid-template-rows: 1fr 5fr;
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
        grid-template-columns: 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
        place-items: center center;
        grid-row-gap: 3%;
        grid-column-gap: 2%;
    }
    .specialVideo div a img{
        border-radius: 15px;
    }
    .gameRanking{
        display: grid;
        grid-template-rows: 1fr 5fr;
        background-color: #E1E2E2;

        place-items: center center;
    }
    .gameRankingTitle{
        width: 95%;
        color: #99a9bf;
        font-weight: 900;
        font-size: 26px;
        margin: 5px 0;
    }
    .Rankingpic{
        width: 90%;
        display: grid;
    }
    .el-carousel-item{
        display: grid;
        place-items: center center;
    }
    .el-carousel-item h3{
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
   }

   .el-carousel-item:nth-child(2n) {
    background-color: #99a9bf;
   }

  .el-carousel-item:nth-child(2n+1) {
    background-color: #d3dce6;
   }
   /* .el-carousel-item img{

   } */
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
