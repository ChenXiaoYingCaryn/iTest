<template>
    <div class="functionNav">
        <div class="functionNavContent">
            <div class="menuLists">
                <el-button class="menuList" type="warning" @click="products">手机</el-button>
                <el-button class="menuList" type="warning" @click="products">电脑</el-button>
                <el-button class="menuList" type="warning" @click="products">平板</el-button>
                <!-- <el-button class="menuList" type="warning" round>所有游戏</el-button> -->
            </div>

            <div class="search">
                <el-input
                    placeholder="请输入内容"
                    prefix-icon="el-icon-search"
                    maxlength="1">
                </el-input>
            </div>

            <div class="login">
                <!-- <el-button type="primary" round>登陆 / 注册</el-button> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'functionNav',
  methods: {
    products () {
      this.$router.push('/products')
    }
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
        grid-template-columns: 3fr 2fr 2fr;
        padding: 10px 0;
        /* place-items: center center; */
    }
    .menuLists{
        /* background-color: snow; */
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

</style>
