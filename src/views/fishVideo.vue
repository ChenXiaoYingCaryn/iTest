<template>
    <div class="fishVideo">
        <!-- 顶部栏 -->
        <fish-top-nav></fish-top-nav>

        <!-- 鱼类视频 -->
        <fish-video-com :fishVideoList='fishVideoList'></fish-video-com>
    </div>
</template>

<script>
import fishTopNav from '../components/fish/fish-top-nav.vue'
import FishVideoCom from '../components/fish/fish-video-com.vue'
export default {
  components: { fishTopNav, FishVideoCom },
  name: 'fishVideo',
  data () {
    return {
      fishVideoList: {}
    }
  },
  created () {
    this.getFishVideo()
  },
  methods: {
    async getFishVideo () {
      const { data: res } = await this.$http.get('index/video/queryPhoneVideo/2/8')
      this.fishVideoList = res.data
    }
  }
}
</script>

<style scoped>

</style>
