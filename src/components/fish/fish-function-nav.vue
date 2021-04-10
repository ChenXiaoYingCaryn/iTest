<template>
    <div class="fish-function-nav">
        <div class="nav-center">
            <div class="title">
                <img src="./海智科技.png" alt="" width="100%">
                <img src="./to.png" alt="" width="70%" class="to">
            </div>
            <div class="function">
                <a href="http://192.168.43.165:8080"><img src="./fish-test.png" alt=""></a>
            </div>
            <div class="function" @click="toFishVideo">
                <img src="./fish-video.png" alt="">
            </div>
            <div class="function" @click="toFishArticle">
                <img src="./fish-article.png" alt="">
            </div>
            <div class="function" @click="toFishPhotoWall">
                <img src="./fish-photo.png" alt="">
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'fish-function-nav',
  methods: {
    toFishVideo () {
      this.$router.push('/fishVideo')
    },
    toFishArticle () {
      this.$router.push('/fishArticle')
    },
    toFishPhotoWall () {
      this.$router.push('/fishPhotoWall')
    },
    toTest () {
      this.$router.push('https://www.bilibili.com/')
    }
  }
}
</script>

<style scoped>
    .fish-function-nav{
        width: 100%;
        height: 100%;
    }
    .nav-center{
        margin: 30px auto;
        width: 1200px;
        height: 610px;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
        column-gap: 8px;
        perspective: 500px;
    }
    .function{
        border-radius: 10px;
    }
    .nav-center .function img{
        transition: all 0.7s;
        overflow: hidden;
        width: 100%;
        border-radius: 10px;
    }
    .nav-center .function img:hover{
        transform: translateZ(10px);
    }
    .title{
        font-size: 36px;
    }
    .to{
        transition: all 0.7s;
    }
    .to:hover{
        transform: translateX(50px);
    }
</style>
