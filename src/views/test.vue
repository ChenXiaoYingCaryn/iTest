 <template>
  <div>
    <div class="testbase" @click="change(videoData,$event)" :class="videoData.testa?'a':'b'"></div>
  </div>
</template>
<script>
export default {
  name: 'test',
  data () {
    return {
      videoData: {
        testa: true
      }
    }
  },
  methods: {
    change: function (te) {
      console.log(te.testa)
      console.log(te)
      te.testa = !te.testa
      // console.log(this.testa)
      // console.log(te)
      // e.srcElement.style.backgroundColor = 'yellow'
    }
  }
}
</script>
 <style lang="css" scoped>
.testbase {
  height: 100px;
   width: 100px;
}

 .a {
   background-color: burlywood;
 }

 .b {
   background-color: pink;
 }
</style>
