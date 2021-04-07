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
            <!-- <div class="Rankingpic">
                <div class="block">
                    <el-carousel height="500px">
                        <el-carousel-item v-for="item in rankingPhoneList" :key="item.type_id">
                                <img v-bind:src="item.type_image" width="100%">
                        </el-carousel-item>
                    </el-carousel>
                </div>
            </div> -->
            <el-collapse v-model="activeName" accordion>
                <el-collapse-item title="一致性 Consistency" name="1">
                    <div>与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；</div>
                    <div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>
                </el-collapse-item>
                <el-collapse-item title="反馈 Feedback" name="2">
                    <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
                    <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
                </el-collapse-item>
                <el-collapse-item title="效率 Efficiency" name="3">
                    <div>简化流程：设计简洁直观的操作流程；</div>
                    <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
                    <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
                </el-collapse-item>
                <el-collapse-item title="可控 Controllability" name="4">
                    <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
                    <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
                </el-collapse-item>
                <el-collapse-item title="可控 Controllability" name="5">
                    <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
                    <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
                </el-collapse-item>
                <el-collapse-item title="可控 Controllability" name="6">
                    <div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
                    <div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
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
    rankingPhoneList: {}
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
  },
  methods: {
    more () {
      this.$router.push('/partition')
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
    /* .Rankingpic{
        width: 90%;
        display: grid;
    } */
    /* .el-carousel-item{
        display: grid;
        place-items: center center;
    }
    .el-carousel-item img{
        object-fit: contain;
    }
   .el-carousel-item:nth-child(2n) {
    background-color: #99a9bf;
   }

  .el-carousel-item:nth-child(2n+1) {
    background-color: #d3dce6;
   } */
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
