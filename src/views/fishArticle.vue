<template>
    <div class="fishArticle">
        <!-- 顶部栏 -->
        <fish-top-nav></fish-top-nav>

        <!-- 文章部分 -->
        <fish-info></fish-info>
    </div>
</template>

<script>
import FishInfo from '../components/fish/fish-info.vue'
import fishTopNav from '../components/fish/fish-top-nav.vue'
export default {
  components: { fishTopNav, FishInfo },
  name: 'fishArticle'
}
</script>

<style scoped>

</style>
