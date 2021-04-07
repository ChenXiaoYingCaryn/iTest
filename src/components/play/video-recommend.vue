<template>
  <div class="container">
    <div class="movie-item" @click="changeMovie">
      <div class="cover">
        <img :src="item.video_img" alt="" />
        <div class="duration">{{item.duration}}</div>
      </div>
      <div class="detail">
        <div class="title">{{item.video_title}}</div>
        <div class="author">{{item.user_name}}</div>
        <div class="info">{{view_counts}}</div>
        <div class="info">{{this.calculateTimeDiff(item.create_time)}}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    item: Object
  },
  data () {
    return {
      view_counts: '100万次观看'
    }
  },
  name: 'video-recommend',
  methods: {
    showItem: function () {
      console.log(this.item)
    },
    changeMovie: function () {
      this.$router.push({
        path: '/play',
        query: {
          dogv: this.item.video_id
        }
      })
      // this.$store.state.playInfo.video_id = this.item.video_id
      this.$router.go(0)
    }
  },
  created () {
    this.showItem()
  }

}
</script>

<style scoped>
  .container:first-child{
    margin-top: 76px;
  }

  .movie-item {
    cursor: pointer;
    display: flex;
    margin-bottom: 20px;
    margin-left: 10px;
  }
  .movie-item .cover {
    position: relative;
    max-width: 165px;
    min-width: 165px;
    overflow: hidden;
    background: #000;
  }
  .movie-item:hover .cover img {
    opacity: .7;
    transform: scale(1.25, 1.25);
  }
  .movie-item .cover img {
    width: 100%;
    height: 100%;
    transition: transform ease .25s;
  }
  .movie-item .cover .duration {
    position: absolute;
    right: 5px;
    bottom: 5px;
    padding: 3px 6px;
    line-height: 1.2em;
    background-color: rgba(0,0,0, .65);
    color: #fff;
    font-size: 12px;
    border-radius: 2px;
  }
   .movie-item .detail {
    padding-left: 10px;
    font-size: 14px;
    color: rgba(0,0,0, .45);
  }
  .movie-item .detail .title {
    max-width: 150px;
    color: #000;
    font-size: 16px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    -moz-box-orient: vertical;
  }
  .movie-item .detail .author{
    font-size: 14px;
    line-height: 1em;
  }
  .movie-item .detail .info {
    display: block;
    line-height: 1em;
    font-size: 12px;
    border-radius: 2px;
    padding-top: 5px;
  }
  .movie-item .detail .data.hot {
    background-color: #ff6060;
  }

  @media screen and (max-width: 1120px) {
    .movie-item .detail .title {
      max-width: 100%;
      color: #000;
      font-size: 16px;
      overflow: hidden;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      -moz-box-orient: vertical;
    }

    .container:first-child{
      margin-top: 20px;
    }
  }
</style>
