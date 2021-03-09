export default {
  setUser (state, res) {
    // state.user.user_id = res.data.data.user_id
    // state.user.user_sex = res.data.data.user_sex
    // state.user.user_email = res.data.data.user_email
    // state.user.user_image = res.data.data.user_image
    console.log(res.data.data.user_name)
    console.log(state.user)
    // console.log('ergou')
  },
  // 存入用户信息
  setUserInfo (state, data) {
    alert('success')
    state.user = data
    console.log(state.user.user_name)
  },
  // video-item调用
  setVideoInfo (state, item) {
    state.playInfo = item
    console.log(state.playInfo)
  }
}
