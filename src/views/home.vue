<template>
    <div class="home">
        <!-- 导航栏 -->
        <top-nav></top-nav>
        <functionNav></functionNav>

        <!-- 轮播图 -->
        <div class="block">
            <!-- <span class="demonstration">默认 Hover 指示器触发</span> -->
            <el-carousel height="570px">
                <el-carousel-item v-for="item in bannerBox" :key="item.image_id">
                    <!-- <h3 class="small">{{ item }}</h3> -->
                    <img v-bind:src="item.image_url" width="100%">
                </el-carousel-item>
            </el-carousel>
        </div>

        <!-- 产品类别导航 -->
        <product-nav></product-nav>

        <!-- 热门游戏推荐 -->
        <hot-game></hot-game>

        <!-- 专区 -->
        <special :videoPhoneList="videoPhoneList" :rankingPhoneList="rankingPhoneList" :videoPartName="videoPhoneName"></special>
        <special :videoPhoneList="videoPadList" :rankingPhoneList="rankingPadList" :videoPartName="videoPadName"></special>
        <special :videoPhoneList="videoLaptopList" :rankingPhoneList="rankingLaptopList" :videoPartName="videoLaptopName"></special>
        <!-- 资讯专栏 -->
        <info></info>

        <!-- 页脚 -->
        <foot></foot>
    </div>
</template>

<script>
import functionNav from '../components/home/functionNav.vue'
import HotGame from '../components/home/hotGame.vue'
import special from '../components/special.vue'
import info from '../components/home/info.vue'
import productNav from '../components/home/productNav'
import TopNav from '../components/topNav.vue'
import foot from '../components/foot.vue'

export default {
  name: 'home',
  components: { functionNav, HotGame, special, info, productNav, TopNav, foot },
  data () {
    return {
      bannerBox: [],

      videoPhoneName: '',
      videoPadName: '',
      videoLaptopName: '',

      videoPhoneList: {},
      rankingPhoneList: {},

      videoPadList: {},
      rankingPadList: {},

      videoLaptopList: {},
      rankingLaptopList: {}

    }
  },
  created () {
    this.getSlideImges()

    this.getPhoneVideo()
    this.getPadVideo()
    this.getLaptopVideo()

    this.getRankingPhonePic()
    this.getRankingPadPic()
    this.getRankingLaptopPic()
  },
  methods: {
    async getSlideImges () {
      const { data: res } = await this.$http.get('index/slideshow/query/0/4')
      this.bannerBox = res.data
    },

    async getPhoneVideo () {
      const { data: res } = await this.$http.get('index/video/queryPhoneVideo/0/6')
      this.videoPhoneList = res.data
      this.videoPhoneName = res.msg
      console.log(res.data)
      // console.log(this.videoPartName)
    },
    async getPadVideo () {
      const { data: res } = await this.$http.get('index/video/queryPadVideo/0/6')
      this.videoPadList = res.data
      this.videoPadName = res.msg
      console.log(res.msg)
      // console.log(this.videoPartName)
    },
    async getLaptopVideo () {
      const { data: res } = await this.$http.get('index/video/queryLaptopVideo/0/6')
      this.videoLaptopList = res.data
      this.videoLaptopName = res.msg
      console.log(res.msg)
      // console.log(this.videoPartName)
    },

    async getRankingPhonePic () {
      const { data: res } = await this.$http.get('score/rankingPhoneList')
      this.rankingPhoneList = res.data
    },
    async getRankingPadPic () {
      const { data: res } = await this.$http.get('score/rankingPadList')
      this.rankingPadList = res.data
    },
    async getRankingLaptopPic () {
      const { data: res } = await this.$http.get('score/rankingLaptopList')
      this.rankingLaptopList = res.data
    }
  }
}
</script>

<style scoped>
  .home{
      width: 100%;
      margin: 0 auto;
      /* background-color: #302F2D; */
      background-color: #E1E2E2;

  }
  .el-carousel-item h3 {
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
</style>
