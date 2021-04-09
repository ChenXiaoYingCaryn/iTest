<template>

    <div class="products">
        <!-- 顶部栏 -->
        <!-- <top-nav></top-nav> -->
        <new-top-nav></new-top-nav>
        <div class="productsTab">
             <!-- 选项卡 -->
            <el-tabs v-model="activeName" @tab-click="handleClick" class="tabs">
                <el-tab-pane label="手机" name="active">
                    <product v-bind:picSrc="item.type_image" v-bind:productName="item.type_name" v-bind:productPrice="item.type_price" v-for="item in phonePic" :key="item.type_id"></product>
                </el-tab-pane>
                <el-tab-pane label="电脑" name="">
                    <product v-bind:picSrc="item.type_image" v-bind:productName="item.type_name" v-bind:productPrice="item.type_price" v-for="item in computerPic" :key="item.type_id"></product>
                </el-tab-pane>
                <el-tab-pane label="平板" name="">
                <product v-bind:picSrc="item.type_image" v-bind:productName="item.type_name" v-bind:productPrice="item.type_price" v-for="item in padPic" :key="item.type_id"></product>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
import NewTopNav from '../components/home/new-top-nav.vue'
import Product from '../components/products/product.vue'
// import productBlock from '../components/products/productBlock'
// import TopNav from '../components/topNav.vue'

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
  props: ['picSrc', 'productName', 'productPrice'],
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
    Product, NewTopNav
  }
}
</script>

<style>
    .products{
        background-color: #fff;
        height: 100%;
        width: 100%;
    }
    .productsTab{
        width: 1440px;
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
        color: black !important;

    }
    .el-tab-pane{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
        place-items: center center;
    }
    .el-tabs__active-bar{
      background-color: #7c7a7a !important;
    }
</style>
