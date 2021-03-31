<template>
    <div class="dynamics">
        <div class="userImage">
            <img src="./bear.jpg" width="40%">
        </div>
        <div class="dynamicsContent">
            <span class="userName">Bear</span>
            <span>点赞了</span>
            <span class="userName">iTest</span>
        </div>
    </div>
</template>

<script>
export default {
  name: 'dynamics'
}
</script>

<style scoped>
    .dynamics{
        margin: 3px auto;
        width: 750px;
        height: 75px;
        background-color: #e1e2e2;
        display: grid;
        grid-template-columns: 1fr 5fr;
    }
    .userImage{
        width: 100%;
        display: grid;
        place-items: center center;
    }
    .userImage img{
        border-radius: 50%;
        object-fit: cover;
    }
    .userName{
        font-weight: 700;
        font-size: 20px;
        padding-left: 3px;
        padding-right: 3px;
    }
    .dynamicsContent{
        display: flex;
        align-items: center;
    }
</style>
