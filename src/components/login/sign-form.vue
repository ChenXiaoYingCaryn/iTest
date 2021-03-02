<template>
  <div>
    <div class="title">注册</div>
    <el-form  class="sign-rule-form" :model="SignForm" status-icon :rules="rules" ref="SignForm" label-width="auto" label-position="right">
      <el-form-item>
          <el-input type="text" placeholder="用户名" v-model="SignForm.user_id" maxlength="20" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" placeholder="密码" v-model="SignForm.user_pwd" maxlength="20" autocomplete="off" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" placeholder="确认密码" v-model="SignForm.upass" maxlength="20" autocomplete="off" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('SignForm')">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'sign-form',
  data () {
    var validateuser = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      } else {
        if (this.SignForm.checkuser !== '') {
          this.$refs.SignForm.validateField('checkuser')
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
    var validateUpass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.SignForm.user_pwd) {
        callback(new Error('两次输入的密码不一致哦!'))
      } else {
        callback()
      }
    }
    return {
      SignForm: {
        user_id: '',
        user_pwd: '',
        upass: ''
      },
      rules: {
        user_id: [
          { validator: validateuser, trigger: 'blur' }
        ],
        user_pwd: [
          { validator: validateUpassword, trigger: 'blur' }
        ],
        upass: [
          { validator: validateUpass, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          const user = { user_id: this.SignForm.user_id, user_pwd: this.SignForm.user_pwd }
          console.log(user)
          await this.$http({
            url: '/login/userRegister',
            method: 'post',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' },
            data: this.$qs.stringify(user)
          })
            .then(
              res => {
                if (res.data.code !== 200) {
                  console.log(res)
                  console.log(res.data.code)
                  return this.$message.error('注册失败，请尝试更换账号名称！')
                }
                console.log(res.data.code)
                this.$message.success('注册成功！欢迎加入Itest的大家庭！')
                this.$parent.updateRotate()
              },
              res => {
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
.sign-rule-form {
  margin: 0 20%;
  text-align: center;
}
.sign-rule-form .el-button {
  background-color: Transparent;
}
.el-form-item >>> .el-input__inner {
  background-color: transparent;
}

@media screen and (max-width:600px) {
  .sign-rule-form {
    margin: 0 10%;
  }
}
</style>
