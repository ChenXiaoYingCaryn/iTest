<template>
    <div class="topNav">
        <div class="wrapper">
            <el-container class="navContent">
                <!-- logo区域 -->
                <div class="logo">
                    <a href="#" @click="toHome"><img src="../assets/Itest.png" alt="logo"></a>
                </div>
                <!-- 菜单区域 -->
                <div class="menuList">
                    <a href="#"><span class="list">产品</span></a>
                    <a href="#"><span class="list">资讯</span></a>
                    <a href="#"><span class="list">关于我们</span></a>
                    <a href="#"><span class="list">帮助反馈</span></a>
                </div>
            </el-container>
        </div>
    </div>
</template>

<script>

export default {
  name: 'topNav',
  methods: {
    toHome: function () {
      this.$router.push('/home')
    }
  }
}
</script>

<style scoped>
a,a:hover,a:active,a:link,a:focus,a:visited {
    text-decoration: none;
}

.topNav {
    background-color: black;
    color: rgb(119, 126, 133);
}

.wrapper {
    width: 80%;
    margin: 0 auto;
}

.navContent {
    display:grid;
    grid-template-columns: 1fr 3fr;
}

.logo img {
    height: 8vh;
}

.logo span{
    font-size: 18px;
    position: absolute;
    top: 35px;
}
.menuList{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    place-items: center center;
    font-size: 18px;
}
.menuList a span{
    color: rgb(119, 126, 133);
    font-weight: 800;
}
</style>
