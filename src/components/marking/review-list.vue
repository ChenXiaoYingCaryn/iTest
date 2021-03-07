<template>
  <div class="container">
    <!-- 评分输入模块 -->
    <div v-clickoutside="hideReplyBtn" class="my-reply" :class="btnShow?'reply-after':'reply-before'">
      <div :class="btnShow?'top-input':'top-btn'"  @click="showReplyBtn"><span v-show="!btnShow">我也要评分！</span></div>
      <el-collapse-transition>
        <div class="reply-btn-box" v-show="btnShow">
          <div class="mark-star">
            <span>我的评分：</span>
            <el-rate v-model="myrate" show-text allow-half color="yellow"></el-rate>
          </div>
          <div class="reply-info">
            <div tabindex="0" contenteditable="true" id="replyInput" spellcheck="false" placeholder="请输入评论..."
              class="reply-input" @focus="showReplyBtn" @input="onDivInput($event)">
            </div>
          </div>
          <el-button class="reply-btn" size="medium" @click="sendComment" type="primary">发表评论</el-button>
        </div>
      </el-collapse-transition>
    </div>

    <div v-for="(item,i) in comments" :key="i" class="author-title reply-father">
      <!-- 评论者信息 -->
      <el-avatar class="header-img" :size="40" :src="item.headImg"></el-avatar>
      <div class="author-info">
        <span class="author-name">{{item.name}}</span>
        <span class="author-time">{{item.time}}</span>
      </div>
      <!-- 显示评分 -->
      <div class="star">
        <el-rate v-model="item.rate" disabled show-score text-color="#ff9900"></el-rate>
      </div>
      <!-- 评论操作图标 -->
      <div class="icon-btn">
        <i class="iconfont fa fa-thumbs-o-up"></i>{{item.like}}
        <i class="iconfont fa fa-thumbs-o-down"></i>
      </div>
      <div class="talk-box">
        <p>
          <span class="reply">{{item.comment}}</span>
        </p>
      </div>
    </div>
    <el-pagination background layout="prev, pager, next" :total="1">
    </el-pagination>
  </div>
</template>

<script>

const clickoutside = {
  // 初始化指令
  bind (el, binding, vnode) {
    function documentHandler (e) {
      // 这里判断点击的元素是否是本身，是本身，则返回
      if (el.contains(e.target)) {
        return false
      }
      // 判断指令中是否绑定了函数
      if (binding.expression) {
        // 如果绑定了函数 则调用那个函数，此处binding.value就是handleClose方法
        binding.value(e)
      }
    }
    // 给当前元素绑定个私有变量，方便在unbind中可以解除事件监听
    el.vueClickOutside = documentHandler
    document.addEventListener('click', documentHandler)
  },
  update () {},
  unbind (el, binding) {
    // 解除事件监听
    document.removeEventListener('click', el.vueClickOutside)
    delete el.vueClickOutside
  }
}
export default {
  name: 'review-list',
  data () {
    return {
      btnShow: false,
      index: '0',
      replyComment: '',
      myName: 'Lana Del Rey',
      myHeader: 'https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg',
      myId: 19870621,
      myrate: null,
      to: '',
      toId: -1,
      comments: [{
        name: 'Lana Del Rey',
        id: 19870621,
        headImg: 'https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg',
        comment: '手机很不错！很好用！！',
        time: '2019年9月16日 18:43',
        like: 15,
        rate: 5.0,
        inputShow: false
      },
      {
        name: 'Taylor Swift',
        id: 19891221,
        headImg: 'https://ae01.alicdn.com/kf/H94c78935ffa64e7e977544d19ecebf06L.jpg',
        comment: '我发行了我的新专辑Lover',
        time: '2019年9月16日 18:43',
        like: 5,
        rate: 4.5,
        inputShow: false
      },
      {
        name: 'Norman Fucking Rockwell',
        id: 20190830,
        headImg: 'https://ae01.alicdn.com/kf/Hdd856ae4c81545d2b51fa0c209f7aa28Z.jpg',
        comment: 'Plz buy Norman Fucking Rockwell on everywhere',
        time: '2019年9月16日 18:43',
        like: 5,
        rate: 5.0,
        inputShow: false
      }
      ]
    }
  },
  directives: {
    clickoutside
  },
  methods: {
    inputFocus () {
      var replyInput = document.getElementById('replyInput')
      replyInput.focus()
    },
    showReplyBtn () {
      this.btnShow = true
    },
    hideReplyBtn () {
      this.btnShow = false
    },
    _inputShow (i) {
      return this.comments[i].inputShow
    },
    sendComment () {
      if (!this.replyComment) {
        this.$message.warning('评论不能为空哦!')
      } else if (!this.myrate) {
        this.$message.warning('别忘了评分哦！')
      } else {
        const replyInfo = {}
        const input = document.getElementById('replyInput')
        const timeNow = new Date().getTime()
        const time = this.dateStr(timeNow)
        replyInfo.name = this.myName
        replyInfo.comment = this.replyComment
        replyInfo.headImg = this.myHeader
        replyInfo.rate = this.myrate
        replyInfo.time = time
        replyInfo.commentNum = 0
        replyInfo.like = 0
        this.comments.push(replyInfo)
        this.replyComment = ''
        input.innerHTML = ''
        console.log(this.rate)
      }
    },
    onDivInput: function (e) {
      this.replyComment = e.target.innerHTML
    },
    dateStr (date) {
      // 获取js 时间戳
      var time = new Date().getTime()
      time = parseInt((time - date) / 1000)
      // 存储转换值
      var s
      if (time < 60 * 10) { // 十分钟内
        return '刚刚'
      } else if ((time < 60 * 60) && (time >= 60 * 10)) {
        // 超过十分钟少于1小时
        s = Math.floor(time / 60)
        return s + '分钟前'
      } else if ((time < 60 * 60 * 24) && (time >= 60 * 60)) {
        // 超过1小时少于24小时
        s = Math.floor(time / 60 / 60)
        return s + '小时前'
      } else if ((time < 60 * 60 * 24 * 30) && (time >= 60 * 60 * 24)) {
        // 超过1天少于30天内
        s = Math.floor(time / 60 / 60 / 24)
        return s + '天前'
      } else {
        // 超过30天ddd
        // var date = new Date(parseInt(date))
        return date.getFullYear() + '/' + (date.getMonth() + 1) + '/' + date.getDate()
      }
    }
  }
}
</script>

<style scoped>
.my-reply {
  padding: 10px;
  border-radius: 10px;
  overflow: hidden;
}

.reply-before {
  background-color: #FFCF40;
}

.reply-afer {
  border: solid 1px #ccc;
}

.my-reply .top-btn {
  text-align: center;
  cursor: pointer;
}

.my-reply .top-input {
  border-block-color: pink;
}

.my-reply .mark-star {
  margin-bottom: 10px;
}

.my-reply .header-img {
  display: inline-block;
  vertical-align: top;
}

.my-reply .reply-info {
  display: inline-block;
  margin-left: 5px;
  width: 98%;
}

@media screen and (max-width: 1200px) {
  .my-reply .reply-info {
    width: 80%;
  }
}

.my-reply .reply-info .reply-input {
  min-height: 100px;
  line-height: 22px;
  padding: 10px 10px;
  color: #ccc;
  background-color: #fff;
  border-radius: 5px;
}

.my-reply .reply-info .reply-input:empty:before {
  content: attr(placeholder);
}

.my-reply .reply-info .reply-input:focus:before {
  content: none;
}

.my-reply .reply-info .reply-input:focus {
  padding: 8px 8px;
  border: 2px solid #FFCF40;
  box-shadow: none;
  outline: none;
}

.my-reply .reply-btn-box {
  height: 200px;
  margin: 10px 0;
}

.my-reply .reply-btn-box .reply-btn {
  position: relative;
  float: right;
  margin-right: 15px;
}

.my-comment-reply {
  margin-left: 50px;
}

.my-comment-reply .reply-input {
  width: flex;
}

.author-title:not(:last-child) {
  border-bottom: 1px solid rgba(178,186,194,0.3);
}

.author-title {
  padding: 10px;
}

.author-title .header-img {
  cursor: pointer;
  display: inline-block;
  vertical-align: top;
}

.author-title .author-info {
  display: inline-block;
  margin-left: 5px;
  width: 60%;
  height: 40px;
  line-height: 20px;
}

.author-title .author-info >span {
  display: block;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.author-title .author-info .author-name {
  color: #000;
  font-size: 18px;
  font-weight: bold;
}
.author-title .author-info .author-time {
  font-size: 14px;
}

.star {
  margin: 0 50px;
}

.author-title .icon-btn {
  /* cursor: pointer; */
  width: 30%;
  padding: 0 !important;
  float: right;
}

@media screen and (max-width: 1200px) {
  .author-title .icon-btn {
    width: 20%;
    padding: 7px;
  }
}

.author-title .icon-btn >span {
  cursor: pointer;
}

.author-title .icon-btn .iconfont {
  margin: 0 5px;
}

.author-title .talk-box {
  margin: 0 50px;
}

.author-title .talk-box >p {
  margin: 0;
}

.author-title .talk-box .reply {
  font-size: 16px;
  color: #000;
}

.el-pagination {
  text-align: center;
}
</style>
