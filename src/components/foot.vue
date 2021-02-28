<template>
  <div class="footer">
    <el-row class="wrapper" type="flex" justify="center">
      <el-col>
        <p>
          <img height="150px" alt="logo" src="../assets/Itest2.png" />
        </p>
      </el-col>
      <el-col>
        <p class="title">Itest</p>
        <p><a href="#" @click="warn">关于我们</a></p>
        <p><a href="#" @click="warn">联系我们</a></p>
        <p><a href="#" @click="warn">服务条款</a></p>
        <p><a href="#" @click="warn">用户协议</a></p>
        <p><a href="#" @click="warn">隐私政策</a></p>
        <p><a href="#" @click="warn">加入我们</a></p>
      </el-col>
      <el-col>
        <p class="title">服务</p>
        <p><a href="#" @click="warn">客服</a></p>
        <p><a href="#" @click="warn">用户反馈</a></p>
        <p><a href="#" @click="warn">举报申诉</a></p>
        <p><a href="#" @click="warn">广告合作</a></p>
      </el-col>
      <el-col>
        <p class="title">传送门</p>
        <p><a href="#" @click="warn">活动中心</a></p>
        <p><a href="#" @click="warn">协议汇总</a></p>
        <p><a href="#" @click="warn">友情链接</a></p>
        <p><a href="#" @click="warn">网站导航</a></p>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'foot',
  methods: {
    warn: function () {
      this.$message.warning('此功能正在施工！')
    }
  }
}
</script>

<style scoped>
.footer {
  padding-top: 20px;
  padding-bottom: 60px;
  background: #171920;
  color: rgba(255,255,255, .25);
  font-size: 14px;
  display: flex;
  justify-content: center;
}

.footer .wrapper {
  width: 1200px;
}

.footer .title {
  color: rgba(255,255,255, .25);
  font-size: 20px;
  font-weight: bold;
  padding-bottom: 10px;
}

.footer a {
  color: rgba(255,255,255, .85);
}

.footer a:hover{
  color: rgba(255,255,255, 1);
}

.footer p {
  margin-bottom: 10px;
}
</style>
