<template>
    <div class="productBlock">
        <el-button>
          <img v-bind:src="picSrc" width="100%">
        <!-- <span>产品名</span> -->
        </el-button>
    </div>
</template>

<script>
export default {
  name: 'productBlock',
  data () {
    return {
      // picSrc: '',
    }
  },
  props: ['picSrc']
}
</script>

<style scoped>
    .productBlock{
        width: 234px;
        height: 300px;
        display: grid;
        place-items: center center;
    }
    .el-button{
      background-color: #E1E2E2;
      border-color: #E1E2E2;
    }
    .el-button:hover{
    -webkit-transform: translateY(-3px);
    -ms-transform: translateY(-3px);
    transform: translateY(-3px);
    -webkit-box-shadow: 0 0 6px #999;
    box-shadow: 0 0 6px #999;
    -webkit-transition: all .5s ease-out;
    transition: all .5s ease-out;
    }

</style>
