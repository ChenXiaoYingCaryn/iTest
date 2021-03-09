<template>
  <div class="wrapper">
    <h1 class="title" style="font-size:30px;">{{productInfo.type_name}}</h1>
    <el-row :gutter="10">

      <el-col :xs="12" :sm="8" :md="8">
        <!-- 产品图片 -->
        <img src="./marking-img/K30U.jpg" alt="" class="product-img">
      </el-col>

      <el-col :xs="12" :sm="8" :md="8">
        <!-- 产品参数 -->
        <div class="grid-content parm">
          <ul>
            <li class="parm-item"><span class="label">首发起步价格</span>&emsp;:&emsp;<span>{{productInfo.type_price}}</span></li>
            <li class="parm-item"><span class="label">型号</span>&emsp;:&emsp;<span>{{productInfo.type_type}}</span></li>
            <li class="parm-item"><span class="label">发售日期</span>&emsp;:&emsp;<span>{{productInfo.data}}</span></li>
            <li class="parm-item"><span class="label">基础配置</span>&emsp;:&emsp;<span>{{productInfo.type_config}}</span></li>
            <li class="parm-item"><span class="label">内存版本</span>&emsp;:&emsp;<span>{{productInfo.type_version}}</span></li>
            <li class="parm-item"><span class="label">参数亮点</span>&emsp;:&emsp;<span>{{productInfo.type_hightlights}}</span></li>
          </ul>
        </div>
      </el-col>

      <el-col :xs="24" :sm="8" :md="8" class="right-box">
        <!-- 产品评分 -->
        <div class="grid-content count">
          <h2 class="title">Itest评分</h2>
          <div class="chart-box">
            <el-progress type="circle" :percentage="percentage" :color="colors" :width="dashWidth" :format="format">
            </el-progress>
            <div class="chart-right">
              <h1 class="score">{{value}}</h1>
              <el-rate v-model="value" disabled :colors="colors" show-text=""></el-rate>
              <p style="text-align:center;">{{person}}人评分</p>
            </div>
          </div>
        </div>

        <div class="grid-content">
          <el-divider></el-divider>
          <div class="count-box">
            <el-button class="box-btn" @click="toFollowed">{{followed}}</el-button>
            <el-button class="box-btn"><a href="#review">发布评价</a></el-button>
            <el-button class="box-btn">发布视频</el-button>
          </div>
          <div class="info-box" style="margin-top: 10px;">
            <span>参数解读：</span>
            <p>{{productInfo.type_Interpretation}}</p>
          </div>
        </div>
      </el-col>

    </el-row>
  </div>
</template>

<script>
export default {
  name: 'marking-indent',
  data () {
    return {
      productInfo: {
        type_name: '红米Redmi K30至尊纪念版',
        type_price: '1999',
        type_type: 'Redmin k30u',
        data: '2021-08-14',
        type_config: '天玑1000Plus 4500mAh电池 33W有线闪充',
        type_version: '最高达8GB+256GB',
        type_hightlights: '2020年度性价比之王',
        type_Interpretation: '手机中的Redmi K30至尊纪念版是目前市面上用户数量和好评数量都非常多的一款产品。它使用体验非常好，性价比极高，适合各个年龄段的用户选择来满足办公或者家用或者娱乐等不同方面的需求。'
      },
      auto: false,
      value: 4.3,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
      texts: ['极差', '失望', '一般', '满意', '惊喜'],
      dashWidth: 100,
      person: 9999,
      form: {
        desc: ''
      },
      followed: '关注'
    }
  },
  computed: {
    percentage: function () {
      return this.value / 5 * 100
    }
  },
  methods: {
    format (percentage) {
      return '好评率:' + this.percentage + '%'
    },
    onSubmit () {
      console.log('submit!')
    },
    toFollowed () {
      this.followed = '已关注'
      this.$message.success('关注成功！')
    }
  }
}
</script>

<style scoped>
.wrapper {
  width: auto;
  background-color: rgba(255, 255, 255, 0.5);
  /* margin: 0 10vw; */
  padding: 0 5%;
}

.title {
  padding: 20px 0;
  /* text-align: center; */
  color: #EFCD6D;
}

.grid-content {
  border-radius: 5px;
  height: auto;
}

@media screen and (max-width: 768px) {
  .right-box {
    display: flex;
    justify-content: space-around;
  }
}

/* 产品图 */
.product-img {
  /* height: 450px; */
  width: 350px;
  /* background-color: pink; */
}

.product-img img {
  max-height: 100%;
}

/* 产品参数 */
.parm-item {
  /* height: 50px; */
  line-height: 50px;
  margin-top: 5px;
  padding-left: 30px;
  /* background-color: yellow; */
}

.right-box {
  /* background-color: #EFCD6D; */
}

/* 产品评分 */
.score {
  font-size: 50px;
  font-family: DINCond-Bold;
  text-align: center;
}

.chart-box {
  display: flex;
  justify-content: space-evenly;
}

.count-box {
  display: flex;
  justify-content: center;
  /* margin: 10px auto; */
}

</style>
