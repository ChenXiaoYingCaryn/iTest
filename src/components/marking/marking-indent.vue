<template>
  <div class="wrapper">
    <h1 class="title" style="font-size:30px;">{{this.pname}}</h1>
    <el-row :gutter="10">

      <el-col :xs="12" :sm="8" :md="8">
        <!-- 产品图片 -->
        <div class="grid-content picture">
          <el-carousel indicator-position="outside" :autoplay="auto" height="400px">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3>{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-col>

      <el-col :xs="12" :sm="8" :md="8">
        <!-- 产品参数 -->
        <div class="grid-content parm">
          <ul>
            <li class="parm-item"><span class="label">首发起步价格</span>&emsp;:&emsp;<span>1999</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>2020-8-11</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>2020-8-11</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>2020-8-11</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>2020-8-11</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>2020-8-11</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>2020-8-11</span></li>
          </ul>
        </div>
      </el-col>

      <el-col :xs="24" :sm="8" :md="8">
        <!-- 产品评分 -->
        <div class="grid-content count">
          <h2 class="title">Itest评分</h2>
          <div class="chart-box">
            <el-progress type="dashboard" :percentage="percentage" :color="colors" :width="dashWidth"></el-progress>
            <div class="chart-right">
              <h1 class="score">{{value}}</h1>
              <el-rate v-model="value" disabled :colors="colors" show-text=""></el-rate>
              <p>{{person}}人评分</p>
            </div>
          </div>
        </div>
      </el-col>

    </el-row>
  </div>
</template>

<script>
export default {
  name: 'marking-indent',
  data() {
    return {
      pname: '红米Redmi K30至尊纪念版',
      auto: false,
      value: 4.5,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
      texts: ['极差', '失望', '一般', '满意', '惊喜'],
      dashWidth: 100,
      person: 9999
    }
  },
  computed: {
    percentage: function() {
      return this.value/5*100;
    }
  }
}
</script>

<style scoped>
.wrapper {
  width: auto;
  background-color: rgba(255, 255, 255, 0.5);
  margin: 0 10vw;
}

.title {
  padding: 20px 0;
  text-align: center;
  color: #EFCD6D;
}

.grid-content {
  border-radius: 5px;
  height: auto;
}

.picture {
  background-color: aqua;
  /* height: 500px; */
}

.parm {
  background-color: pink;
}

.count {
  background-color: greenyellow;
}

/* 产品轮播图 */
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

/* 产品参数 */
.parm-item {
  height: 50px;
  line-height: 50px;
  margin-top: 10px;
  padding-left: 50px;
  background-color: yellow;
}

/* 产品评分 */
.score {
  font-size: 50px;
  font-family: DINCond-Bold;
}

.chart-box {
  display: flex;

}

</style>
