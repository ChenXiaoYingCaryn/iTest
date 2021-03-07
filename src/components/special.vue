<template>
    <div class="specialArea">
        <!-- 手机 -->
        <div class="videoAdvise">
            <div class="specialTitle">
                <a @click="more"><span style="cursor:pointer">{{this.videoPartName}}</span></a>
                <a @click="more"><span style="cursor:pointer">更多>></span></a>
            </div>
            <div class="specialVideo">
                <div class="related-video-item" v-for="item in videoPhoneList" :key="item.video_id">
                    <div class="top-img">
                        <a href="#"><img v-bind:src="item.video_img"></a>
                    </div>
                    <div class="video-content">
                        <a href='#' class="video-title">{{item.video_title}}</a>
                        <div class="content-bottom">
                            <div class="content-left">
                                <img  v-bind:src="item.user_image" alt="">
                            </div>
                            <div class="content-right">
                                <a href="#" class="video-up">{{item.user_name}}</a>
                                <div class="video-uptime">{{videoTimeDiff}}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="gameRanking">
            <div class="gameRankingTitle">
                <span>排行榜</span>
            </div>
            <div class="Rankingpic">
                <div class="block">
                    <el-carousel height="500px">
                        <el-carousel-item v-for="item in rankingPhoneList" :key="item.type_id">
                            <div><img v-bind:src="item.type_image" width="100%"></div>   
                        </el-carousel-item>
                    </el-carousel>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
// import videoItem from '../components/video-item'
export default {
    name: "special",
    props: {
        videoPartName:'',

        videoPhoneList:{},
        videoPadList:{},
        videoLaptopList: {},

        rankingPhoneList: {},
        rankingPadList: {},
        rankingLaptopList: {},

    },
    data(){
        return{
            // videoPic: [],
            // RankingBox: [],
            // videoPhoneList: [],
            // videoLaptopBox: [],
            // videoName: [],
            videoTime: '4:17',
            // videoTitle: '[MV]なんでもないや Cover (nandemonaiya) - radwimps Cover by yurisa [君の名はost]',
            // videoUpdater: 'yurisa',
            videoUpdateTime: '2019/4/21 10:08:33',
            videoViews: 2212294,
            videoTimeDiff: ''
        }
    },
    created () {
        // this.getPhoneVideoInfo(),
        // this.getRankingPic(),
        this.simplifyViews(),
        this.calculateTimeDiff()
        // this.getVideoName()
    },
    methods: {
        more () {
            this.$router.push('/partition')
        },
        // async getPhoneVideoInfo () {
        //     const { data: res } = await this.$http.get('index/video/queryPhoneVideo/0/6')
        //     this.videoPhoneBox = res.data
        // },

        // async getRankingPic () {
        //     const { data: res } = await this.$http.get('score/rankingPhoneList')
        //     this.RankingBox = res.data
        // },
        // async getVideoName() {
        //     const { data: res } = await this.$http.get('index/video/queryPhoneVideo/0/6')
        //     this.videoName = res.msg
        //     console.log(res.msg)
        // },
        simplifyViews: function () {
      if (this.videoViews > 9999) { this.videoViews = Math.floor(this.videoViews / 10000) + '万' }
        },
    calculateTimeDiff: function () {
      const newTime = new Date()
      const updateTime = new Date(this.videoUpdateTime)
      const timeDiff = newTime.getTime() - updateTime.getTime()
      const secondDiff = timeDiff / 1000
      console.log(secondDiff + '秒')
      const dayDiff = timeDiff / (24 * 3600 * 1000)
      console.log(dayDiff + '天')
      console.log('success2')

      if (dayDiff >= 7) {
        const weekDiff = dayDiff / 7
        console.log(weekDiff + '周')
        if (weekDiff >= 4) {
          const monthDiff = dayDiff / 30
          console.log(monthDiff + '月')
          if (monthDiff >= 12) {
            this.videoTimeDiff = Math.floor(monthDiff / 12) + '年前'
            return
          }
          this.videoTimeDiff = Math.floor(monthDiff) + '个月前'
          return
        }
        this.videoTimeDiff = Math.floor(weekDiff) + '周前'
      } else if (dayDiff < 1) {
        const hourDiff = dayDiff * 24
        console.log(hourDiff + '时')
        if (hourDiff < 1) {
          const minuteDiff = hourDiff * 60
          console.log(minuteDiff + '分')
          if (minuteDiff < 3) {
            this.videoTimeDiff = '刚刚'
            return
          }
          this.videoTimeDiff = Math.floor(minuteDiff) + '分钟前'
          return
        }
        this.videoTimeDiff = Math.floor(hourDiff) + '小时前'
      } else {
        this.videoTimeDiff = Math.floor(dayDiff) + '天前'
      }
    }
    },
    components: {
        // videoItem,
    }
}
</script>

<style scoped>
    .specialArea{
        width: 80%;
        margin: 0 auto;
        display: grid;
        grid-template-columns: 3fr 1fr;
        /* place-items: center center; */
        grid-column-gap: 3%;

    }
    .videoAdvise{
        display: grid;
        grid-template-rows: 1fr 5fr;
        /* background-color: #302F2D; */
        place-items: center center;
    }
    .specialTitle{
        width: 95%;
        /* color: #BD9764; */
        font-weight: 900;
        font-size: 26px;
        margin: 5px 0;
    }
    .specialTitle a:nth-child(2) span{
        float: right;
        /* color: #EFCD6D; */
    }
    .specialVideo{
        width: 95%;
        margin: 0 0 20px 0;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
        place-items: center center;
        /* grid-row-gap: 30px; */
        grid-row-gap: 3%;
        /* grid-column-gap: 65px; */
        grid-column-gap: 2%;
    }
    .specialVideo div a img{
        border-radius: 15px;
    }
    .gameRanking{
        display: grid;
        grid-template-rows: 1fr 5fr;
        /* background-color: #302F2D; */
        background-color: #E1E2E2;

        place-items: center center;
    }
    .gameRankingTitle{
        width: 95%;
        color: #99a9bf;
        font-weight: 900;
        font-size: 26px;
        margin: 5px 0;
    }
    .Rankingpic{
        width: 90%;
        display: grid;
        /* place-items: center center; */
    }
    .el-carousel-item{
        display: grid;
        place-items: center center;
    }
    .el-carousel-item h3{
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
   }

   .el-carousel-item:nth-child(2n) {
    background-color: #99a9bf;
   }
  
  .el-carousel-item:nth-child(2n+1) {
    background-color: #d3dce6;
   }
   /* .el-carousel-item img{


   } */
   a {
  color: #999;
    }
    a:hover{
    color: #686464;
    }
    .related-video-item {
    width: 280px;
    }

    /* 视频推荐图片和上面的参数 */
    .top-img {
    cursor: pointer;
    position: relative;
    height: 157.5px;
    overflow: hidden;
    }

    .top-img img:hover {
    transform: scale(1.5);
    transition: .5s;
    animation-direction:alternate;
    }

    .top-img img, .video-content .content-left img {
    max-width: 100%;
    max-height: 100%;
    }

    .top-img .top-video-label {
    position: absolute;
    color: #ffffff;
    font-size: 12px;
    text-shadow: 0px 0px 7px rgba(0, 0, 0, .9);
    }

    .top-img .top-video-time {
    right: 10px;
    bottom: 5px;
    }

    .top-img .top-video-audience {
    left: 10px;
    bottom: 5px;
    }

    .video-content a {
    display: block;
    margin: 0 auto;
    }

    .video-content .video-title {
    height: 45px;
    overflow: hidden;
    margin: 5px 0 8px;

    /* 解决文字溢出 */
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    -moz-box-orient: vertical;
    }

    .video-content .content-bottom {
    display: flex;
    }

    .video-content .content-bottom .content-left {
    width: 36px;
    height: 36px;
    border-radius: 50%;
    background-color: aqua;
    overflow: hidden;
    }

    .video-content .content-bottom .content-right {
    margin-left: 10px;
    }

    .video-content .content-bottom .content-right .video-up,
    .video-uptime {
    font-size: 14px;
    color: #999;
    }
</style>