<template>
    <div id="layer-wrapper">
        <div id="article-creator">
            <el-avatar class="creator-avatar" shape="square" :size="80" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-avatar>
            <span class="name">CuiFlower</span>
            <span class="create-time">{{this.calculateTimeDiff(art_data.create_time)}}</span>
            <el-button size="small" class="creator-btn">关注</el-button>
        </div>
        <div id="article-content">
          {{art_data.art_text}}
          <div><img :src="art_data.art_image" alt=""></div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'article-layer',
  props: {
    art_data: {
      art_title: '',
      art_text: '',
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
}
</script>

<style scoped>
#layer-wrapper{
  display: grid;
  grid-template-columns: 1fr 7fr;
  grid-template-rows: 1fr auto;
  /* background-color: aqua; */
}

/* 发布者信息 */
#article-creator {
  background-color: #fafbfc;

  grid-column-start: 1;
  grid-column-end: 2;
  grid-row-start: 1;
  grid-row-end: 3;

  display: flex;
  flex-direction: column;
  align-items: center;
  /* background-color: pink; */
}

/* 文章内容 */
#article-content {
  padding: 20px;
  border-left: 1px solid #edeef2;
  border-right: 1px solid #edeef2;

  grid-column-start: 2;
  grid-column-end: 3;
  grid-row-start: 1;
  grid-row-end: 3;
  /* background-color: yellow; */
}

/* 发布者头像 */
#article-creator .creator-avatar {
    margin: 10px;
}

/* 名字 */
#article-creator .name {
  font-size: 14px;
}

/* 发布时间 */
#article-creator .create-time {
  color: #999;
  font-size: 12px;
}

#article-content div{
  margin: 30px auto;
  width: 500px;
}
#article-content div img{
  width: 500px;
}
@media screen and (max-width: 1440px) {
    #article-creator {
        grid-column-start: 1;
        grid-column-end: 3;
        grid-row-start: 1;
        grid-row-end: 2;
    }

    #article-content {
        grid-column-start: 1;
        grid-column-end: 3;
        grid-row-start: 2;
        grid-row-end: 3;
    }

    #article-creator {
        flex-direction: row;
        align-items: center;
    }

    #article-creator .create-time {
        margin-right: auto;
    }

    #article-creator .creator-avatar {
        size: 100;
    }

    #article-creator .creator-btn {
        margin: 0 10px;
    }
}

</style>
