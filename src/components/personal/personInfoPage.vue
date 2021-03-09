<template>
    <div class="personInfoPage">
        <span>个人资料</span>

        <el-divider></el-divider>
        <span class="list">用户名</span>
        <span>{{user_name}}</span>
        <i class="fa fa-pencil tubiao"></i>
        <el-divider></el-divider>

        <span class="list">邮 箱</span>
        <span>{{user_email}}</span>
        <i class="fa fa-pencil tubiao"></i>
        <el-divider></el-divider>

        <span class="list">性 别</span>
        <span>{{user_sex}}</span>
        <i class="fa fa-pencil tubiao"></i>

    </div>

</template>

<script>
export default {
  name: 'personInfoPage',
  computed: {
    user_sex () { return this.$store.user.user_sex },
    user_email () { return this.$store.user.user_email },
    user_name () { return this.$store.user.user_name }

  }
}
</script>

<style scoped>
    .personInfoPage{
        width: 750px;
        margin: 20px auto;
    }
    .list{
        margin-right: 100px;
    }
    .personInfoPage span:nth-child(1){
        font-weight: 700;
        font-size: 26px;
    }
    .tubiao{
        float: right;
    }
    .tubiao:hover{
        color: #006CFF;
    }
</style>
