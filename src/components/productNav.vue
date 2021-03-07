<template>
    <div class="proNav">
        <el-button @click="all"><img src="../assets/picture/手机.png" alt="" width="100%"></el-button>
        <el-button @click="all"><img src="../assets/picture/电脑.png" alt="" width="100%"></el-button>
        <el-button @click="all"><img src="../assets/picture/平板.png" alt="" width="100%"></el-button>
        <el-button @click="all"><img src="../assets/团队logo.png" alt="" width="100%"></el-button>
    </div>
</template>

<script>
export default {
    name: 'proNav',
    methods: {
        all () {
            this.$router.push('/products')
        }
    }
}
</script>

<style scoped>
    .proNav{
        width: 80%;
        margin: 2% auto;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        background-color: #E1E2E2;
    }
    .el-button{
        background-color: #E1E2E2;
        border: none;
    }
   .el-button:hover{
    border: none;
    background-color: #E1E2E2;
    -webkit-transform: translateY(-5px);
    -ms-transform: translateY(-5px);
    transform: translateY(-5px);
    /* -webkit-box-shadow: 0 0 6px #999; */
    /* box-shadow: 0 0 6px #999; */
    -webkit-transition: all .5s ease-out;
    transition: all .5s ease-out;
   }
</style>