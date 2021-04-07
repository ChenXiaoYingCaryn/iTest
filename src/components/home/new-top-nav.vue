<template>
    <div class="new-top-nav">
        <div class="container">
            <div class="logo" @click="toHome">
                <a href="#"><img src="./home-img/newT3.png" alt="logo" width="100%" height="100%"></a>
            </div>
            <div class="button">
                <div @click="toProducts" style="cursor: pointer;">手机</div>
                <div @click="toProducts" style="cursor: pointer;">电脑</div>
                <div @click="toProducts" style="cursor: pointer;">平板</div>
                <div @click="toProducts" style="cursor: pointer;">全部产品</div>
            </div>
            <div class="search">
                <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    maxlength="1">
                </el-input>
            </div>
            <div class="login">
                <div @click="toLogin" style="cursor: pointer;">登录 / 注册</div>
                <!-- <div class="had-login">
                    <el-avatar :size="size" :src="avatarSrc">Bear</el-avatar>
                    <span>动态</span>
                    <span>收藏</span>
                </div> -->
            </div>
            <div class="update">
                <el-button type="primary" icon="el-icon-upload2">发布动态</el-button>
                <!-- <el-button type="primary" icon="el-icon-search">搜索</el-button> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'new-top-nav',
  data () {
    return {
      size: 'medium',
      avatarSrc: './home-img/Bear.jpg'
    }
  },
  methods: {
    toHome () {
      this.$router.push('/home')
    },
    toProducts () {
      this.$router.push('/products')
    },
    toLogin () {
      this.$router.push('/login')
    }
  }
}
</script>
<style scoped>
    .new-top-nav{
        margin: 10px auto;
        min-width: 980px;
        height: 56px;
        display: grid;
        align-items: center;
        background-color: white;
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
    .button{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        align-self: center;
    }
    .button div{
        margin: 0 auto;
        font-size: 18px;
        font-weight: 700;
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
</style>
