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
        return{
            // picSrc: '',
        }
    },
    props:["picSrc"]
}
</script>

<style scoped>
    .productBlock{
        width: 234px;
        height: 300px;
        display: grid;
        place-items: center center;
    }
</style>