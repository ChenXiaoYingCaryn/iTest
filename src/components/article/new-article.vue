<template>
    <div class="new-article">
        <div class="left-article">
            <div class="button">
                <el-button type="primary" icon="el-icon-edit" circle class="left-button"></el-button>
                <el-button type="success" icon="el-icon-check" circle class="left-button"></el-button>
                <el-button type="primary" icon="el-icon-edit" circle class="left-button"></el-button>
            </div>
        </div>
        <div class="mid-article">
            <div class="writer">
                <el-avatar class="creator-avatar" :size="50" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-avatar>
                <div class="info">
                    <span class="author">Bear</span>
                    <span class="time">2021.04.09</span>
                </div>
                <el-button>关注</el-button>
            </div>
            <div class="article">
                <h1 class="title">{{art_data.art_title}}</h1>
                 <!-- <el-divider></el-divider> -->
                <div class="body">
                    {{art_data.art_text}}
                    <div><img :src="art_data.art_image" alt=""></div>
                </div>
            </div>
        </div>
        <div class="right-article">
            <div class="author-info">
                <div class="right-info">
                    <el-avatar class="creator-avatar" :size="60" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-avatar>
                <div class="right-big-info">
                    <span class="right-author">Bear</span>
                    <span class="intro">小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字</span>
                </div>
                </div>

                <div class="record">
                    <i class="el-icon-s-opportunity"></i><span>获得点赞：111</span>
                </div>
                <div class="record">
                    <i class="el-icon-star-on"></i><span>获得关注：121</span>
                </div>

            </div>
            <div class="iTest">
                <img src="../home/home-img/article-right2.gif" alt="">
                <img src="../home/home-img/article-right.gif" alt="">
                <img src="../home/home-img/article-right3.gif" alt="">
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'new_article',
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
    .new-article{
        width: 1200px;
        margin: 0 auto;
        display: grid;
        /* height: 1000px; */
        grid-template-columns: 240px 720px 240px;
        column-gap: 15px;
    }
    .mid-article{
        background: #fff;
    }
    .writer{
        height: 60px;
        display: grid;
        grid-template-columns: 80px 520px 120px;
        place-items: center;
    }
    .el-avatar{
        justify-self: end;
        margin-right: 10px;
    }
    .info{
        justify-self: start;
        display: inline-grid;
        grid-template-rows: 1fr 1fr;
        font-size: 14px;
    }
    .author{
        font-weight: 600;
    }
    .time{
        color: #909090;
    }
    .title{
        height: 44px;
        font-weight: 600;
        margin-left: 20px;
        line-height: 44px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }
    .body{
        margin: 20px 20px;
    }
    .body img{
        display: block;
        margin: 10px auto;
        width: 350px;
    }
    .right-article{
        background-color: #F4F5F5;
        display: grid;
        grid-template-rows: 180px;
        row-gap: 10px;
    }
    .author-info{
        background-color: #fff;
        border-radius: 5px;
        height: 180px;
        display: grid;
        grid-template-rows: 100px 40px 40px;
        place-items: center;
    }
    .right-info{
        display: grid;
        grid-template-columns: 80px 160px;
    }
    .right-big-info{
        display: grid;
        grid-template-rows: 1fr 1fr;
    }
    .right-author{
        font-size: 16px;
        font-weight: 600;
        align-self: end;
    }
    .intro{
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        font-size: 14px;
        color: #909090;
    }
    .author-info .record{
        place-self: start;
        margin: 0 20px;
    }
    .record i{
        margin-right: 5px;
    }
    .iTest{
        background-color: #F4F5F5;
    }
    .iTest img{
        margin-top: 10px;
        width: 240px;
    }
    .left-article{
        display: grid;
        align-items: center;
    }
    .button{
        display: grid;
        grid-template-rows: 42px 42px 42px;
        row-gap: 10px;
    }
    .left-button{
        width: 42px;
        place-self: center;
        margin: 10px 10px;
    }
</style>
