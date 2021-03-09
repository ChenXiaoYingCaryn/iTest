<template>
    <div class="personInfoPage">
        <span>个人资料</span>

        <el-divider></el-divider>
        <span class="list">用户名</span>
        <span>Bear</span>
        <i class="fa fa-pencil tubiao"></i>
        <el-divider></el-divider>

        <span class="list">邮 箱</span>
        <span>17817680324@163.com</span>
        <i class="fa fa-pencil tubiao"></i>
        <el-divider></el-divider>

        <span class="list">性 别</span>
        <span>男</span>
        <i class="fa fa-pencil tubiao"></i>

    </div>

</template>

<script>
export default {
  name: 'personInfoPage'
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
