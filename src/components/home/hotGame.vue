<template>
    <div class="hotGame">
        <!-- 游戏推荐 -->
        <div class="gameAdvise">
            <!-- 标题 -->
            <div class="title">
                <span>人气产品</span>
            </div>
            <!-- 游戏推荐 -->
            <div class="games">
                <div class="gamesBox">
                    <div v-for="item in productsNavBox" @click="goMarking(item.type_id)" :key="item.type_id">
                        <a href="#"><img v-bind:src="item.type_image" width="100%"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'hotGame',
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
      const { data: res } = await this.$http.get('score/rankingList/0/8')
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
    .hotGame{
        height: 100%;
        width: 80%;
        margin: 0 auto;
        display: grid;
        grid-column-gap: 3%;
    }
    .gameAdvise{
        width: 100%;
        display: grid;
        grid-auto-rows: 1fr 3fr;
        background-color: #E1E2E2;

    }
    .title{
        display: grid;
        place-items: center center;
    }
    .title span{
        border: #232322 solid 2px;
        border-radius: 15px;
        font-size: 24px;
        font-weight: 600;
        padding: 10px 150px;
        margin: 30px 0;
        background-color: #BD9764;
    }
    .games{
        display: grid;
        place-items: center center;
    }
    .gamesBox{
        width: 95%;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
        place-items: center center;
        grid-row-gap: 10px;
        grid-column-gap: 25px;
    }
  .gamesBox div a img{
        width: 100%;
        height: 400px;
        overflow: hidden;
        object-fit: scale-down;
    }
    .gamesBox div{
        border: 0;
        background: none;
        text-transform: uppercase;
        color: #4361ee;
        font-weight: bold;
        position: relative;
        outline: none;
        padding: 10px 20px;
        box-sizing: border-box;
    }
    .gamesBox div::before, .gamesBox div::after {
        box-sizing: inherit;
        position: absolute;
        content: '';
        border: 2px solid transparent;
        width: 0;
        height: 0;
        }
        .gamesBox div::after {
        bottom: 0;
        right: 0;
        }
        .gamesBox div::before {
        top: 0;
        left: 0;
        }
        .gamesBox div:hover::before, .gamesBox div:hover::after {
        width: 100%;
        height: 100%;
        }
        .gamesBox div:hover::before {
        border-top-color: #BD9764;
        border-right-color: #BD9764;
        transition: width 0.3s ease-out, height 0.3s ease-out 0.3s;
        }
        .gamesBox div:hover::after {
        border-bottom-color: #BD9764;
        border-left-color: #BD9764;
        transition: border-color 0s ease-out 0.6s, width 0.3s ease-out 0.6s, height 0.3s ease-out 1s;
        }
</style>
