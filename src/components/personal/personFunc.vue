<template>
    <div class="personFunc">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1">动态</el-menu-item>
            <el-menu-item index="2">视频</el-menu-item>
            <el-menu-item index="3">文章</el-menu-item>
            <el-menu-item index="4">点赞</el-menu-item>
            <el-menu-item index="5">关注</el-menu-item>
        </el-menu>
    </div>
</template>

<script>
export default {
  name: 'personFunc',
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
    .personFunc{
        background-color:#fff ;
        width: 750px;
        height: auto;
        margin: 6px auto;
    }
    .el-menu{
        background-color: #fff ;
    }
</style>
