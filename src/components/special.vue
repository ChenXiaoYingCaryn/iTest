<template>
    <div class="specialArea">
        <!-- 手机 -->
        <div class="videoAdvise">
            <div class="specialTitle">
                <a><span style="cursor:pointer">{{this.videoPartName}}</span></a>
                <a><span style="cursor:pointer">更多>></span></a>
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
            <el-collapse v-model="activeName" accordion>
                <el-collapse-item v-for="item in rankingList" :key="item.type_id" :title="item.type_name" :name="item.type_id">
                    <div v-text="item.type_highlights"></div>
                    <div></div>
                </el-collapse-item>
            </el-collapse>
        </div>
    </div>
</template>

<script>
import videoItem from './video-item.vue'
export default {
  components: { videoItem },
  name: 'special',
  props: {
    videoPartName: {},
    videoPhoneList: {},
    rankingList: {}
  },
  data () {
    return {
      videoTime: '4:17',
      videoUpdateTime: '2019/4/21 10:08:33',
      videoViews: 2212294,
      videoTimeDiff: '',
      activeName: '1'
    }
  },
  created () {
    this.showData()
    // this.getRankingPhone()
  },
  methods: {
    more () {
      this.$router.push('/article')
    },
    showData () {
      console.log(this.videoPhoneList)
    }
  }
}
</script>

<style scoped>
    .specialArea{
        width: 1440px;
        margin: 0 auto;
        display: grid;
        grid-template-columns: 1080px 200px;
        grid-column-gap: 3%;

    }
    .videoAdvise{
        display: grid;
        height: 660px;
        grid-template-rows: 110px 550px;
        /* grid-template-rows: 1fr 5fr; */
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
        height: 660px;
        grid-template-rows: 110px 550px;
        background-color: #fff;
        /* place-items: center center; */
    }
    .gameRankingTitle{
        width: 95%;
        color: #99a9bf;
        font-weight: 900;
        font-size: 26px;
        margin: 5px 0;
        align-self: center;
    }
    .el-collapse{
        width: 270px;
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
