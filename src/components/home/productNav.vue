<template>
    <div class="proNav">
        <div><el-button @click="all"><img src="./home-img/手机.png" alt="" width="100%"></el-button></div>
        <div><el-button @click="all"><img src="./home-img/平板.png" alt="" width="100%"></el-button></div>
        <div><el-button @click="all"><img src="./home-img/电脑.png" alt="" width="100%"></el-button></div>
        <div><el-button @click="all"><img src="./home-img/手机.png" alt="" width="100%"></el-button></div>
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
        width: 1200px;
        margin: 30px auto;
        display: grid;
        grid-template-columns: 310px 310px 310px 310px ;
        background-color: #fff;
    }
    .proNav div{
      justify-self: center;
      background-origin: content-box;
      background-size: contain;
      background-color: #fff;

    }
    .proNav div:nth-child(1){
      background-image: url('./home-img/3.png');
    }
    .proNav div:nth-child(2){
      background-image: url('./home-img/4.png');
    }
    .proNav div:nth-child(3){
      background-image: url('./home-img/5.png');
    }
    .el-button{
        background-color: #fff;
        border: none;
        transition: all 0.5s;
        transform-origin: 30px 30px;
    }
   .el-button:hover{
    transform: translateX(-60px);
    background-color: transparent;
   }
</style>
