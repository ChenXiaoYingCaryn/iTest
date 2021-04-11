<template>
  <div id="article-wrapper">
    <fish-top-nav></fish-top-nav>
    <new-article :art_data="art_data"></new-article>
    <foot></foot>
  </div>
</template>

<script>
import Foot from '../components/foot.vue'
import NewArticle from '../components/article/new-article.vue'
import FishTopNav from '../components/fish/fish-top-nav.vue'
export default {
  components: { Foot, NewArticle, FishTopNav },
  name: 'fishText',
  props: {
  },
  data () {
    return {
      art_data: {
        art_title: '前端新手入门必读！入行Web前端的学习方法有哪些?',
        art_text: `在开始学习之前你需要知道以下4点：
第一：需要达到什么样的技术水平才能就业？
既然是为了就业，你就要知道学习web前端编程技术需要达到什么样的技术水平，才能获得一份web前端开发的工作。就好比高考的一个分数线，你是否能被大学录取，要看你能不能过分数线。软件公司录用你，也是有一个标准，所以首先你要知道学习web前端编程技术应该能达到什么样的水平才能就业。
目前行业就业标准：需要有项目开发的经验，一年经验web前端开发项目经验以上，进公司一周后可以参加项目模块的开发。`,
        art_image: '',
        art_like: '',
        art_forward: '',
        art_comment: '',
        tag_id: '',
        user_id: '',
        type_id: '',
        create_time: ''
      }
    }
  },
  mounted () {
    this.getAriticleInfo()
  },
  methods: {
    getAriticleInfo () {
      this.$http({
        method: 'get',
        url: '/index/fishText/searchArticleById/' + this.$route.query.it // 将传进来的文章号进行拼串并发送请求
      }).then(
        ({ data: res }) => {
          this.art_data = res.data
          console.log(this.art_data)
        },
        ({ data: res }) => {
          console.log('网络错误!')
        }
      )
    }
  }
}
</script>

<style scoped>
#article-wrapper {
  margin: 0 auto;
  width: 100%;
  height: auto;
  background-color: #F4F5F5;
}

/* 标题 */
#article-title {
  position: sticky;
  position: -webket-sticky;
  top: 0;
  box-sizing: border-box;
  width: 100%;
  line-height: 56px;
  padding-left: 10px;
  border-bottom: 1px solid #edeef2;
  background-color: white;

  /* overflow: hidden; */
  /* 解决文字溢出 */
  /* display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
  -moz-box-orient: vertical; */
}

#article-title .title-btn {
  position: absolute;
  right: 0;
  bottom: 0;
}

@media screen and (max-width: 768px) {
  #article-wrapper {
    width: 95%;
  }
}
</style>
