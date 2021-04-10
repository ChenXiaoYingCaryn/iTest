<template>
    <div class="fish-doctor">
        <div class="back">
            <el-button><span>进入鱼病检测</span></el-button>
        </div>
    </div>
</template>

<script>
export default {
  name: 'fish-doctor'
}
</script>

<style scoped>
    .fish-doctor{
        margin: 0 auto;
        width: 1200px;
        height: 400px;
        background-repeat:no-repeat;
        background-size:100% 100%;
        -moz-background-size:100% 100%;
        display: grid;
        place-items: center;
    }
    .el-button{
        background-color: rgba(204, 200, 200, .5);
    }
    .back span{
        font-size: 34px;
        font-weight: 600;
    }
    .el-button:hover{
        color: black;
        transform: translateZ(10px);
        background-color: rgba(245, 245, 245, .7);
    }
</style>
