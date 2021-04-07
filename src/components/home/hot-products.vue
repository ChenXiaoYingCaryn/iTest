<template>
    <div class="hot-products">
        <div class="title">热门产品</div>
        <div class="products">
            <div class="product">
                <img src="./home-img/cxy.jpg" alt="">
                <p>🙈</p>
            </div>
            <div class="product hottest">
                <img src="./home-img/newT3.png" alt="">
                <p>iTest,有温度的个人科技测评社区</p>
            </div>
            <div class="product">
                <img src="./home-img/aw.jpg" alt="">
                <p>夏天夏天悄悄过去留下小秘密</p>
            </div>
            <div class="product">
                <img src="./home-img/Bear.jpg" alt="">
                <p>Bear</p>
            </div>
            <div class="product">
                <img src="./home-img/ly.jpg" alt="">
                <p>YC°</p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'hot-products'
}
</script>

<style scoped>
    .hot-products{
        width: 1440px;
        margin: 0 auto;
        display: grid;
        grid-template-rows: 70px 690px;
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
    .hottest{
        grid-row: 1 / span 2;
        grid-column: 2 / span 1;
        width: 684px;
        height: 670px;
    }
    .product img{
        width: 230px;
        place-self: center;
        transition: all 0.3s;
        border-radius: 25px;
    }
    .product img:hover{
        transform: translateZ(30px);
    }
    .hottest img{
        width: 400px;
    }
    .product p{
        height: 20px;
        margin: 0 auto;
        font-size: 18px;
        font-weight: 700;
    }
</style>
