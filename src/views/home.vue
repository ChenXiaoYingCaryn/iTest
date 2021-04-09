<template>
    <div class="home">
        <!-- 导航栏 -->
        <!-- 第一版 -->
        <!-- <top-nav></top-nav>
        <functionNav></functionNav> -->

        <!-- 第二版 -->
        <new-top-nav></new-top-nav>

        <!-- 轮播图 -->
        <div class="block">
            <!-- <span class="demonstration">默认 Hover 指示器触发</span> -->
            <el-carousel height="600px">
                <el-carousel-item v-for="item in bannerBox" :key="item.image_id">
                    <img v-bind:src="item.image_url" width="100%">
                </el-carousel-item>
            </el-carousel>
        </div>

        <!-- 产品类别导航 -->
        <product-nav></product-nav>

        <!-- 热门产品推荐 -->
        <!-- 第一版 -->
        <!-- <hot-game></hot-game> -->

        <!-- 第二版 -->
        <hot-products></hot-products>

        <!-- 专区 -->
        <special :videoPhoneList="videoPhoneList" :rankingList="rankingPhoneList" :videoPartName="videoPhoneName"></special>
        <special :videoPhoneList="videoPadList" :rankingList="rankingPadList" :videoPartName="videoPadName"></special>
        <special :videoPhoneList="videoLaptopList" :rankingList="rankingLaptopList" :videoPartName="videoLaptopName"></special>
        <!-- 资讯专栏 -->
        <info></info>

        <!-- 页脚 -->
        <foot></foot>
    </div>
</template>

<script>
// import functionNav from '../components/home/functionNav.vue'
// import HotGame from '../components/home/hotGame.vue'
import special from '../components/special.vue'
import info from '../components/home/info.vue'
import productNav from '../components/home/productNav'
// import TopNav from '../components/topNav.vue'
import foot from '../components/foot.vue'
import NewTopNav from '../components/home/new-top-nav.vue'
import HotProducts from '../components/home/hot-products.vue'

export default {
  name: 'home',
  components: { special, info, productNav, foot, NewTopNav, HotProducts },
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

    this.getRankingPhone()
    this.getRankingPad()
    this.getRankingLaptop()
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
    },
    async getPadVideo () {
      const { data: res } = await this.$http.get('index/video/queryPadVideo/0/6')
      this.videoPadList = res.data
      this.videoPadName = res.msg
    },
    async getLaptopVideo () {
      const { data: res } = await this.$http.get('index/video/queryLaptopVideo/0/6')
      this.videoLaptopList = res.data
      this.videoLaptopName = res.msg
    },

    async getRankingPhone () {
      const { data: res } = await this.$http.get('score/rankingPhoneList')
      this.rankingPhoneList = res.data
    },
    async getRankingPad () {
      const { data: res } = await this.$http.get('score/rankingPadList')
      this.rankingPadList = res.data
    },
    async getRankingLaptop () {
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
      background-color: #fff;

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
  .block{
    z-index: 1;
  }
</style>
