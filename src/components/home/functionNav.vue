<template>
    <div class="functionNav">
        <div class="functionNavContent">
            <div class="menuLists">
                <el-button class="menuList" type="warning" round @click="goProduct">手机</el-button>
                <el-button class="menuList" type="warning" round @click="goProduct">电脑</el-button>
                <el-button class="menuList" type="warning" round @click="goProduct">平板</el-button>
            </div>

            <div class="search">
                <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    maxlength="1">
                </el-input>
            </div>

            <div class="login">
                <div v-if="AvatarType ===  'unlogined'"><el-button type="primary" round @click="toLogin()">登陆 / 注册</el-button></div>
                <div v-else-if="AvatarType ===  'logined'" style="cursor: pointer;" @mouseover="selectLogin ()" @mouseout="outSelect ()">
                    <el-avatar :size="size" :src="imgSrc"></el-avatar>
                    <span class="name-span">{{user_name}}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'functionNav',
  data: function () {
    return {
      size: 'medium',
      AvatarType: 'unlogined'
    }
  },
  computed: {
    imgSrc () { return this.$store.state.user.user_image },
    user_name () { return this.$store.state.user.user_name }
  },
  methods: {
    selectLogin () {
      this.size = 53
    },
    outSelect () {
      this.size = 'medium'
    },
    goProduct () {
      this.$router.push('/products')
    },
    setLoginAvatar () {
      if (window.sessionStorage.getItem('token')) {
        this.AvatarType = 'logined'
      } else {
        console.log(window.sessionStorage.getItem('token'))
        this.AvatarType = 'unlogined'
      }
    },
    toLogin () {
      this.$router.push('/login')
    }
  },
  created () {
    this.setLoginAvatar()
  }
}
</script>

<style scoped>
    .functionNavContent{
        background-color:#232322;
        width: 100%;
        height: 60px;
        margin: 0 auto;
        display: grid;
        grid-template-columns: 2fr 2fr 1fr;
        padding: 10px 0;
    }
    .menuLists{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        place-items: center center;
    }
    .menuLists .menuList{
        color: black;
        font-weight: 800;
        background-color: #BD9764;
        border: #BD9764;
    }
    .menuLists .menuList:hover{
        background-color: darkorange;
    }
    .search{
        display: grid;
        place-items: center center;
        margin: 0 20px;
    }
    .login{
        display: grid;
        place-items: center center;
    }
    .name-span{
        display: inline-block;
        color:  white;
    }

</style>
