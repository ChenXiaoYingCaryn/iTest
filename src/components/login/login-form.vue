<template>
  <div>
    <div class="title">登录</div>
    <el-form  class="login-rule-form" :model="loginForm" status-icon :rules="rules" ref="loginForm" label-width="auto" label-position="right">
      <el-form-item>
          <el-input type="text" placeholder="用户名" v-model="loginForm.user_id" maxlength="20" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" placeholder="密码" v-model="loginForm.user_pwd" maxlength="20" autocomplete="off" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('loginForm')">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'login-form',
  data () {
    var validateUname = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      } else {
        if (this.loginForm.checkUname !== '') {
          this.$refs.loginForm.validateField('checkUname')
        }
        callback()
      }
    }
    var validateUpassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        user_id: '',
        user_pwd: ''
      },
      rules: {
        user_id: [{
          validator: validateUname,
          trigger: 'blur'
        }],
        user_pwd: [{
          validator: validateUpassword,
          trigger: 'blur'
        }]
      }
    }
  },
  mounted: function () {

  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          const user = this.loginForm
          console.log(user)
          await this.$http({
            url: '/login/userLogin',
            method: 'post',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            data: this.$qs.stringify(user)
          })
            .then(
              ({ data: res }) => {
                if (res.code !== 200) {
                  console.log(res.code)
                  return this.$message.error('登录失败，请检查账号或密码！')
                }
                console.log(res)
                console.log(res.data)
                const test = res.data.user_sex
                console.log(test)
                this.$message.success('登录成功！欢迎回到Itest！')
                window.sessionStorage.setItem('token', res.msg)
                this.$router.push('/home')
              },
              ({ data: res }) => {
                this.$message.warning('网络错误，请稍后重试！')
                return false
              }
            )
        }
      })
    }
  }
}
</script>

<style scoped>
.title {
  margin: 30px auto;
  font-size: 30px;
  text-align: center;
  color: white;
}
.login-rule-form {
  margin: 0 20%;
  text-align: center;
}
.login-rule-form .el-button {
  background-color: Transparent;
}
.el-form-item >>> .el-input__inner {
  background-color: transparent;
}

@media screen and (max-width:600px) {
  .login-rule-form {
    margin: 0 10%;
  }
}
</style>
