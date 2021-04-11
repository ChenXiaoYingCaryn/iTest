<template>
    <div class="fish-top-nav">
        <div class="container">
            <div class="logo" @click="toFishHome">
                <a href="#"><img src="./海智科技鱼病检测.png" alt="logo" width="100%" height="100%"></a>
            </div>
            <div class="button">
                <div @click="toFishVideo" style="cursor: pointer;">视频</div>
                <div @click="toFishArticle" style="cursor: pointer;">文章</div>
                <div @click="toFishPhotoWall" style="cursor: pointer;">图片</div>
                <a href="http://192.168.43.165:8080"><div style="cursor: pointer;">鱼病检测</div></a>
            </div>
            <div class="search">
                <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    maxlength="1">
                </el-input>
            </div>
            <div class="login">
                <!-- <div @click="toLogin" style="cursor: pointer;">登录 / 注册</div> -->
                <!-- <div class="had-login">
                    <el-avatar :size="size" :src="avatarSrc">Bear</el-avatar>
                    <span>动态</span>
                    <span>收藏</span>
                </div> -->
                <div style="cursor: pointer;" class="avatar">
                    <img src="../home/home-img/Bear.jpg" alt="">
                </div>
            </div>
            <div class="update">
                <el-button type="primary" icon="el-icon-upload2">鱼病检测</el-button>
                <!-- <el-button type="primary" icon="el-icon-search">搜索</el-button> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'fish-top-nav',
  data () {
    return {
      size: 'medium',
      avatarSrc: './home-img/Bear.jpg'
    }
  },
  methods: {
    toFishHome () {
      this.$router.push('/fishHome')
    },
    toFishVideo () {
      this.$router.push('/fishVideo')
    },
    toFishArticle () {
      this.$router.push('/fishArticle')
    },
    toFishPhotoWall () {
      this.$router.push('/fishPhotoWall')
    }
  }
}
</script>
<style scoped>
    .new-top-nav{
        margin: 10px auto;
        padding-bottom: 10px;
        min-width: 980px;
        height: 56px;
        display: grid;
        align-items: center;
        background-color: #fff;
    }
    .container{
        margin: 0 auto;
        box-sizing: border-box;
        width: 98%;
        display: grid;
        grid-template-columns: 2fr 4fr 4fr 2fr 2fr;
    }
    .logo{
        align-self: center;
        height: 56px;
    }
    .logo a img{
        object-fit: contain;
    }
    .login div img{
        width: 56px;
        object-fit: contain;
        border-radius: 100%;
    }
    .button{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        align-self: center;
    }
    .button div{
        margin: 0 auto;
        font-size: 18px;
        font-weight: 700;
        text-shadow: 0px 0px 6px rgba(255, 255, 255, 1);
    }
    .search{
        display: grid;
        place-items: center center;
        margin: 0 20px;
    }
    .login{
        display: grid;
        align-self: center;
    }
    .login div{
        margin: 0 auto;
        font-size: 18px;
        font-weight: 700;
    }
    .login .el-avatar{
        object-fit: contain;
    }
    .had-login{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        column-gap: 8px;
    }
    .had-login span{
        align-self: center;
    }
    .update{
        display: grid;
        align-self: center;
    }
    .update .el-button{
        max-width: 120px;
        background-color: #ccc8c8;
        border: none;
        color: black;
        font-weight: 700;
    }
    .avatar{
        padding-top: 5px;
    }
</style>
