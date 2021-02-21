<template>
  <div>
    <div class="container_header_root">
      <div class="container_header_title_large">相關影片</div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'related-vedio'
}
</script>

<style scoped>
.container_header_root {
    padding: 0px 0px;
    text-align: left;
}
.container_header_title_large {
    color: #EFCD6D;
    font-size: 30px;
    font-weight: bold;
    margin-bottom: 15px;
    margin-left: 15px;
    line-height: 50px;
}
@media only screen and (max-width: 768px) {
    .container_header_root {
        padding: 0px 0px 10px;
    }

    .container_header_title_large {
        font-size: 20px;
        margin-left: 10px;
        margin-bottom: 10px;
        line-height: 40px;
    }
}

</style>
