<template>
  <div class="home">
    <h1 class="center">Welcome to Itest</h1>
  </div>
</template>

<script>

export default {
  name: 'home',
  components: {
  }
}
</script>

<style scoped>
.home {
  background-color: #FFCF40;
  width: 100vw;
  height: 100vh;
  position: relative;
}

.center {
  position: absolute;
  top: 50%; left: 50%;
  transform: translate(-50%, -50%);
  font-size: 5vw;
  color: #909090;
}
</style>
