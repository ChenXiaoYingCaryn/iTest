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
                <!-- <a href="#" v-for="item in gamesBox" :key="item.id">
                    <img :src="item.url">
                </a> -->
                <div class="gamesBox">
                    <div v-for="item in productsNavBox" :key="item.type_id"><a href="#"><img v-bind:src="item.type_image" width="100%"></a></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "hotGame",
    data () {
        return {
            productsNavBox: [],
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
    }
}
</script>

<style scoped>
    .hotGame{
        height: 100%;
        width: 80%;
        margin: 0 auto;
        /* background-color: silver; */
        display: grid;
        grid-column-gap: 3%;
    }
    .gameAdvise{
        width: 100%;
        /* height: 400px; */
        display: grid;
        grid-auto-rows: 1fr 3fr;
        /* background-color: #302F2D; */
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
        grid-column-gap: 15px;
    }
    .gamesBox div{
        background-color: #E1E2E2;
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
    .gamesBox div::before, .gamesBox div::after{
        box-sizing: inherit;
        position: absolute;
        content: '';
        border: 2px solid transparent;
        width: 0;
        height: 0;
    }
    .gamesBox div::after{
        bottom: 0;
        right: 0;
    }
    .gamesBox div::before{
        top: 0;
        left: 0;
    }
    .gamesBox div:hover::before, .gamesBox div:hover::after {
    width: 100%;
    height: 100%;
    }

    .gamesBox div:hover::before {
    border-top-color: #4361ee;
    border-right-color: #4361ee;
    transition: width 0.3s ease-out, height 0.3s ease-out 0.3s;
    }

    .gamesBox div:hover::after {
    border-bottom-color: #4361ee;
    border-left-color: #4361ee;
    transition: border-color 0s ease-out 0.6s, width 0.3s ease-out 0.6s, height 0.3s ease-out 1s;
    }
    .gamepart-box {
    width: 85%; 
    height: 80%;
    /* background-color: aqua; */
    margin: 0 auto;
    position: relative;
    overflow: hidden;
    top: 10%;
    }
    .box-top {
    position: absolute;
    top: 0;
    width: 100%;
    height: 50%;
    clip-path: polygon(0 0,100% 0,50% 100%);
    background: url("../assets/picture/8.webp") top right / cover no-repeat;
    }

    .box-right {
        position: absolute;
        right: 0;
        width: 100%;
        height: 100%;
        clip-path: polygon(100% 0,50% 50%,100% 100%);
        background-color: yellow;
        background: url("../assets/picture/7.webp") top right / cover no-repeat;
    }

    .box-bottom {
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 50%;
        clip-path: polygon(0 100%,50% 0,100% 100%);
        background-color: pink;
        background: url("../assets/picture/9.webp") bottom right / cover no-repeat;
    }

    .box-left {
        position: absolute;
        left: 0;
        width: 50%;
        height: 100%;
        clip-path: polygon(0 0,100% 50%,0 100%);
        background-color: red;
        background: url("../assets/picture/7.webp") bottom left / cover no-repeat;
    }

    .box-span {
        font-size: 30px;
        font-weight: bold;
        color: #fff;
        text-shadow: 0px 0px 7px rgba(0, 0, 0, .8);
        position: absolute;
        top: 50%;
        left: 50%;
    }
</style>