<template>
  <div class="full-page" ref="fullPage"
  @mousewheel="mouseWheelHandle" @DOMMouseScroll="mouseWheelHandle">
  <!-- 全屏滚动区域 -->
    <div class="page-item" ref="headerPage">
      <div class="first">
        <div class="block">
          <!-- <span class="demonstration">Click 指示器触发</span> -->
          <el-carousel trigger="click" height="100vh">
            <el-carousel-item v-for="item in bannerBox" :key="item.image_id">
              <img v-bind:src="item.image_url" width="100%" height="100%">
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
    </div>

    <!-- 非全屏滚动区域页面 -->
    <div class="page-content">
        <fish-top-nav></fish-top-nav>
        <fish-function-nav></fish-function-nav>
    </div>
  </div>
</template>

<script>
import FishFunctionNav from '../components/fish/fish-function-nav.vue'
import FishTopNav from '../components/fish/fish-top-nav.vue'

export default {
  name: 'fishHome',
  data () {
    return {
      bannerBox: [],
      isHidden: false,
      fullpage: {
        current: 1, // 当前的页面编号
        isScrolling: false, // 是否在滚动,是为了防止滚动多页，需要通过一个变量来控制是否滚动
        deltaY: 0 // 返回鼠标滚轮的垂直滚动量，保存的鼠标滚动事件的deleteY,用来判断是往下还是往上滚
      }
    }
  },
  components: {
    FishFunctionNav,
    FishTopNav
  },
  methods: {
    async getSlideImges () {
      const { data: res } = await this.$http.get('index/slideshow/query/4/4')
      this.bannerBox = res.data
    },
    next () { // 往下切换
      const pages = 2 // 页面的个数，最小写2（有
      if (this.fullpage.current + 1 <= pages) { // 如果当前页面编号+1 小于总个数，则可以执行向下滑动
        this.fullpage.current += 1 // 页面+1
        this.move(this.fullpage.current) // 执行切换
      }
    },
    pre () { // 往上切换
      if (this.fullpage.current - 1 > 0) { // 如果当前页面编号-1 大于0，则可以执行向上滑动
        this.fullpage.current -= 1// 页面+1
        this.move(this.fullpage.current)// 执行切换
      }
    },
    move (index) {
      this.fullpage.isScrolling = true // 为了防止滚动多页，需要通过一个变量来控制是否滚动
      this.directToMove(index) // 执行滚动
      setTimeout(() => { // 这里的动画是1s执行完，使用setTimeout延迟1s后解锁
        this.fullpage.isScrolling = false
      }, 500)
    },
    directToMove (index) {
      // let height = this.$refs["fullPage"].clientHeight;  //获取屏幕的宽度
      const scrollPage = this.$refs.fullPage // 获取第一个需要执行tarnsform的元素
      const scrollHeight = -(index - 1) * 100 + 'vh' // 计算滚动，是往上滚还往下滚
      scrollPage.style.marginTop = `${scrollHeight}`
      this.fullpage.current = index
    },
    mouseWheelHandle (event) { // 监听鼠标监听
      // 第一屏阻止滚动默认状态
      if (this.fullpage.current === 1) {
        event.preventDefault()
      }
      // 添加冒泡阻止
      const evt = event || window.event
      if (evt.stopPropagation) {
        evt.stopPropagation()
      } else {
        evt.returnValue = false
      }
      if (this.fullpage.isScrolling) { // 判断是否可以滚动
        return false
      }
      const e = event.originalEvent || event
      this.fullpage.deltaY = e.deltaY || e.detail // Firefox使用detail
      if (this.fullpage.deltaY > 0) {
        this.next()
      } else if (this.fullpage.deltaY < 0 && document.documentElement.scrollTop === 0) {
        this.pre()
      }
    }
  },
  created () {
    this.getSlideImges()
  }
}
</script>

<style scope>
/* 全屏滚动的样式 */

* {
  margin: 0 auto;
  /* background-color: #F7FAFF; */
}

.full-page {
  height: 100vh;
  width: 100vw;
  transition: all ease-in .5s;
  -webkit-transition: all ease-in .5s;

}

.page-item {
  height: 100%;
}

.page-content {
  width: 100vw;
}

/* 内容页的样式 */
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
     background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }

</style>
