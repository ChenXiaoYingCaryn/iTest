<template>
  <div class="containers">
    <top-nav></top-nav>
    <div class="wrapper">
      <!-- 顶部图片 -->
      <div class="banner">
        <div class="top-img"></div>
      </div>
      <div class="content">
        <!-- 评分系统 -->
        <marking-indent></marking-indent>
        <!-- 相关视频 -->
        <related-vedio></related-vedio>
        <!-- 评价列表 -->
        <review-list></review-list>
        <!-- 推荐产品 -->
        <recommendations></recommendations>
      </div>
      <div class="footer"></div>
    </div>
  </div>
</template>

<script>
import MarkingIndent from '../components/marking/marking-indent.vue'
import Recommendations from '../components/marking/recommendations.vue'
import RelatedVedio from '../components/marking/related-vedio.vue'
import ReviewList from '../components/marking/review-list.vue'
import topNav from '../components/topNav.vue'
export default {
  components: { topNav, RelatedVedio, ReviewList, Recommendations, MarkingIndent },
  name: 'marking',
  data () {
    return {
    }
  }
}
</script>

<style scoped>
.containers {
  background-color: #302f2d;
  width: 100%;
  height: 1000px;
}

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
  background-image: url(../components/marking/marking-img/iPhone12.jpg);
  box-shadow:0 0 1px 1px #232322 inset;
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
  background-image:  url(../components/marking/marking-img/iPhone12.jpg);
  z-index: -1;
  filter: blur(8px);
}

</style>
