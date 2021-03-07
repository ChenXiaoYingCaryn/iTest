<template>
    <div class="partition">
        <!-- 导航栏 -->
        <top-nav></top-nav>
        <!-- 专区宣传背景图 -->

        <div class="banner">
          <div class="top-img">
              <!-- <img src="../assets/picture/redmik30u.jpg" alt=""> -->
          </div>
        </div>

        <!-- 专区 -->
        <hot-video></hot-video>
        <!-- 页脚 -->
        <foot></foot>
    </div>
</template>

<script>
import Foot from '../components/foot.vue'
import HotVideo from '../components/partition/hotVideo.vue'
import TopNav from '../components/topNav.vue'
export default {
  name: 'partition',
  components: {
    Foot,
    TopNav,
    HotVideo
    // ProductBlock,
  },
  data () {
    return {

    }
  }
}
</script>

<style scoped>
    .partition{
        width: 100%;
        height: auto;
        margin: 0 auto;
        background-color: #302F2D;
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
</style>
