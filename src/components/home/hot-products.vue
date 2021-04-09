<template>
    <div class="hot-products">
        <div class="title">热门产品</div>
        <div class="products">
            <!-- <div class="product" style="cursor: pointer;">
                <img src="./home-img/cxy.jpg" alt="">
                <p>🙈</p>
            </div>
            <div class="product hottest" style="cursor: pointer;">
                <img src="./home-img/newT3.png" alt="">
                <p>iTest,有温度的个人科技测评社区</p>
            </div>
            <div class="product" style="cursor: pointer;">
                <img src="./home-img/aw.jpg" alt="">
                <p>夏天夏天悄悄过去留下小秘密</p>
            </div>
            <div class="product" style="cursor: pointer;">
                <img src="./home-img/Bear.jpg" alt="">
                <p>Bear</p>
            </div>
            <div class="product" style="cursor: pointer;">
                <img src="./home-img/ly.jpg" alt="">
                <p>YC°</p>
            </div> -->
            <div v-for="item in productsNavBox" @click="goMarking(item.type_id)" :key="item.type_id" class="product" style="cursor: pointer;">
                <img v-bind:src="item.type_image" alt="">
                <p v-text="item.type_name"></p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'hot-products',
  data () {
    return {
      productsNavBox: []
    }
  },
  created () {
    this.getProductsNav()
  },
  methods: {
    async getProductsNav () {
      const { data: res } = await this.$http.get('score/rankingList/0/5')
      this.productsNavBox = res.data
    },
    goMarking (typeId) {
      this.$router.push({
        path: '/marking',
        query: {
          id: typeId
        }
      })
    }
  }
}
</script>

<style scoped>
    .hot-products{
        width: 1440px;
        margin: 0 auto;
        display: grid;
        grid-template-rows: 70px 690px;
        place-items: center;
    }
    .title{
        margin: 0px auto;
        font-size: 30px;
        font-weight: 700;
        color: black;
    }
    .products{
        margin: 0 auto;
        display: grid;
        justify-items: center;
        grid-template-columns: 330px 684px 330px;
        grid-template-rows: 330px 330px;
        grid-gap: 10px;
    }
    .product{
        display: grid;
        background-color: #F5F5F5;
        width: 330px;
        height: 330px;
        border-radius: 25px;
        perspective: 500px;
    }
    .product:nth-child(2){
        grid-row: 1 / span 2;
        grid-column: 2 / span 1;
        width: 684px;
        height: 670px;
    }
    .product img{
        width: 130px;
        place-self: center;
        transition: all 0.3s;
        /* border-radius: 25px; */
    }
    .product img:hover{
        transform: translateZ(30px);
    }
    .product:nth-child(2) img{
        width: 300px;
    }
    .product p{
        height: 20px;
        margin: 0 auto;
        font-size: 18px;
        font-weight: 700;
        transition: all 0.4s;
        color: #646363;
    }
    .product p:hover{
        /* text-shadow:0px 5px 5px black; */
        color:#000;
    }
</style>
