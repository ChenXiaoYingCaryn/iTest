<template>
    <div class="product">
        <img src="../home/home-img/手机.png" alt="">
        <div class="product-info">
            <p class="product-name"> SamSung TabS7+</p>
            <p class="product-price">￥6999</p>
        </div>
    </div>
</template>

<script>
export default {
  name: 'product'
}
</script>

<style scoped>
    .product{
        background-color: #e5e5e5;
        width: 234px;
        height: 300px;
        border-radius: 15px;
        display: grid;
        place-items: center;
        margin: 20px 0;
        perspective: 500px;
        transition: all .6s;
    }
    .product:hover{
        background-color: #cac8c8;
        transform: translateY(-10px);
    }
    .product img{
        width: 150px;
        transition: all .4s;
    }
    .product img:hover{
        /* transform: rotateZ(360deg); */
        transform: translateZ(35px);
    }
    .product-info{
        align-self: flex-start;
        display: grid;
    }
    .product-price{
        color: #FF6700;
        padding: 3px 0;
        justify-self: center;
    }
</style>
