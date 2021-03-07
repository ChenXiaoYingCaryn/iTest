<template>

    <div class="products">
        <!-- 顶部栏 -->
        <div class="productsTab">
             <!-- 选项卡 -->
            <el-tabs v-model="activeName" @tab-click="handleClick" class="tabs">
                <el-tab-pane label="手机" name="active">
                    <productBlock v-bind:picSrc="item.type_image" v-for="item in phonePic" :key="item.type_id"></productBlock>
                </el-tab-pane>
                <el-tab-pane label="电脑" name="">
                    <productBlock v-bind:picSrc="item.type_image" v-for="item in computerPic" :key="item.type_id"></productBlock>
                </el-tab-pane>
                <el-tab-pane label="平板" name="">
                    <productBlock v-bind:picSrc="item.type_image" v-for="item in padPic" :key="item.type_id"></productBlock>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
import productBlock from '../components/products/productBlock'

export default {
  name: 'products',
  data () {
    return {
      activeName: 'active',
      phonePic: [],
      computerPic: [],
      padPic: []
    }
  },
  props: ['picSrc'],
  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    },
    async getPhonePic () {
      const { data: res } = await this.$http.get('index/type/phone/0/12')
      this.phonePic = res.data
    },
    async getComputerPic () {
      const { data: res } = await this.$http.get('index/type/laptop/0/12')
      this.computerPic = res.data
    },
    async getpadPic () {
      const { data: res } = await this.$http.get('index/type/pad/0/12')
      this.padPic = res.data
    }
  },
  created () {
    this.getPhonePic()
    this.getComputerPic()
    this.getpadPic()
  },
  components: {
    productBlock
  }
}
</script>

<style>
    .products{
        background-color: aliceblue;
        height: 100%;
        width: 100%;
    }
    .productsTab{
        width: 80%;
        margin: 0 auto;
    }
    .el-tabs{
        display: grid;
        /* grid-template-columns: 1fr 1fr 1fr; */
    }
    .el-tabs__item{
        padding-top: 5px !important;
        padding-bottom: 5px !important;
        height: 50px !important;
        font-size: 22px !important;
        font-weight: 700 !important;
        color: #EFCD6D !important;

    }
    .el-tab-pane{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
        place-items: center center;
    }
</style>
