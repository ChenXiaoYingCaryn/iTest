<template>
  <div class="container">
    <top-nav></top-nav>
    <!-- 顶部图片 -->
    <div class="banner">
      <div class="top-img"></div>
    </div>
    <div class="content">
      <!-- 评分系统 -->
      <marking-indent :productId="productId"></marking-indent>
      <!-- 相关视频 -->
      <relatedvideo></relatedvideo>
      <!-- 评价列表 -->
      <div id="review"><review-list></review-list></div>
      <!-- 推荐产品 -->
      <recommendations></recommendations>
    </div>
    <foot></foot>
  </div>
</template>

<script>
import Foot from '../components/foot.vue'
import MarkingIndent from '../components/marking/marking-indent.vue'
import Recommendations from '../components/marking/recommendations.vue'
import Relatedvideo from '../components/marking/related-video.vue'
import ReviewList from '../components/marking/review-list.vue'
import topNav from '../components/topNav.vue'
export default {
  components: { topNav, Relatedvideo, ReviewList, Recommendations, MarkingIndent, Foot },
  name: 'marking',
  data () {
    return {
      productId: ''
    }
  },
  methods: {
    getProductId () {
      this.productId = this.$route.query.id
      console.log('productId is' + this.productId)
    }
  },
  created () {
    this.getProductId()
  }

}
</script>

<style scoped>
.banner {
  position: relative;
  z-index: 1;
  overflow: hidden;
}

.top-img {
  width: 100%;
  height: 440px;
  background-position: center center;
  background-repeat: no-repeat;
  background-size: contain;
  background-image: url(../components/marking/marking-img/redmik30u.jpg);
  box-shadow:0 0 5px 5px #232322 inset;
}
.top-img::before{
  content: '';
  display: block;
  position: absolute;
  top: 0; bottom: 0; left: 0; right: 0;
  width: 100%;
  height: 440px;
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
  background-image:  url(../components/marking/marking-img/redmik30u.jpg);
  z-index: -1;
  filter: blur(8px);
}

.content {
  margin: 0 auto;
  width: 1200px;
  /* margin: 0 10vw; */
}
</style>
