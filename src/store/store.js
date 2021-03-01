import Vue from 'vue'
import Vuex from 'vuex'

import state from './state'
import mutations from './mutations'
import actions from './actions'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  // 要写的放在对应的文件夹中
  state, // 存放状态
  mutations, // 模块化状态管理，对数据进行处理
  actions, // 执行异步操作
  getters // 加工state成员 ，相当于计算属性
})
