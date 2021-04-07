<template>
    <div class="personal">
         <div class="userImage">
             <img src="./bear.jpg" width="80%">
         </div>

         <div class="userName">
             <span>Bear</span>
             <p class="intro">Bear Two</p>
         </div>

         <div class="changeInfo">
             <el-button @click="changeInfo"><span>编辑个人资料</span></el-button>
         </div>
    </div>
</template>

<script>
export default {
  name: 'personalInfo',
  methods: {
    changeInfo: function () {
      this.$router.push('/changeInfo')
    }
  }
}
</script>

<style scoped>
    .personal{
        background-color: #fff;
        width: 750px;
        height: 150px;
        display: grid;
        grid-template-columns: 1fr 4fr 1fr;
        margin:  10px auto;
    }
    .userImage{
        width: 100%;
        display: grid;
        place-items: center center;
    }
    .userImage img{
        border-radius: 50%;
        object-fit: cover;
    }
    .userName{
        padding: 20px 0 0 10px;
    }
    .userName span{
        font-weight: 700;
        font-size: 30px;
    }
    .userName p{
        color: #687885;
    }
    .changeInfo{
        position: relative;
    }
    .changeInfo .el-button{
        position: absolute;
        bottom: 20px;
        right: 20px;
    }
    .el-button{
        color: #006CFF;
        background-color: #fff;
        border-color:#006CFF;
    }
    .el-button {
        background: transparent;
        border: 0;
        border-radius: 0;
        text-transform: uppercase;
        font-size: 20px;
        padding: 15px 30px;
        position: relative;
    }
    .el-button:before {
        transition: all 0.8s cubic-bezier(0.7, -0.5, 0.2, 2);
        content: '';
        width: 1%;
        height: 100%;
        background: #84b0ec;;
        position: absolute;
        top: 0;
        left: 0;
    }
    .el-button span {
        mix-blend-mode: darken;
    }

    .el-button:hover:before {
        background: #84b0ec;;
        width: 100%;
    }
</style>
