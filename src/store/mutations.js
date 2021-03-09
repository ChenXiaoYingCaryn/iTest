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
  // video-item调用
  setVideoInfo (state, item) {
    state.playInfo = item
    console.log(state.playInfo)
  },
  setProductInfo (state, item) {
    state.productInfo = item
    console.log(state.productInfo)
  }
}
