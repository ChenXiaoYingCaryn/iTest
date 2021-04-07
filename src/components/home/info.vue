<template>
    <div class="infoContainer">
        <div class="infoTitleContainer">
            <div class="infoTitle">
                <span>资讯专栏</span>
                <a href="#"><span>更多>></span></a>
            </div>
         </div>
        <div class="infoContentContainer">
            <div class="infoContent">
                <div class="specialInfo">
                    <div class="specialInfoTitle"><span>手机</span></div>
                    <div class="specialInfoContent">
                        <a href="#" v-for="item in phoneArtBox" :key="item.art_id">
                            <div class="infoItem" >
                                <div class="itemPic">
                                    <img v-bind:src="item.art_image" width="100%" height="100%">
                                </div>
                                <div class="itemTxt"><span class="twoRow">{{item.art_title}}</span></div>
                            </div>
                        </a>
                    </div>
                </div>
                 <div class="specialInfo">
                    <div class="specialInfoTitle"><span>电脑</span></div>
                    <div class="specialInfoContent">
                        <a href="#" v-for="item in computerArtBox" :key="item.art_id">
                            <div class="infoItem">
                                <div class="itemPic">
                                    <img v-bind:src="item.art_image" width="100%" height="100%" >
                                </div>
                                <div class="itemTxt"><span class="twoRow">{{item.art_title}}</span></div>
                            </div>
                        </a>
                    </div>
                </div>
                 <div class="specialInfo">
                    <div class="specialInfoTitle"><span>平板</span></div>
                    <div class="specialInfoContent">
                        <a href="#" v-for="item in padArtBox" :key="item.art_id">
                            <div class="infoItem">
                                <div class="itemPic"><img v-bind:src="item.art_image" width="100%" height="100%"></div>
                                <div class="itemTxt"><span class="twoRow">{{item.art_title}}</span></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'info',
  data () {
    return {
      phoneArtBox: [],
      computerArtBox: [],
      padArtBox: []
    }
  },
  created () {
    this.getPhoneArt()
    this.getComputerArt()
    this.getPadArt()
  },
  methods: {
    async getPhoneArt () {
      const { data: res } = await this.$http.get('index/article/phone/query/0/3')
      this.phoneArtBox = res.data
    },
    async getComputerArt () {
      const { data: res } = await this.$http.get('index/article/laptop/query/0/3')
      this.computerArtBox = res.data
    },
    async getPadArt () {
      const { data: res } = await this.$http.get('index/article/pad/query/0/3')
      this.padArtBox = res.data
    }
  }
}
</script>

<style scoped>
    .infoContainer{
        width: 1440px;
        margin: 0 auto;
        display: grid;
        grid-template-rows: 1fr 5fr;
        grid-row-gap: 10px;
    }
    .infoTitleContainer{
        display: grid;
        place-items: center center;
    }
    .infoTitle{
        width: 95%;
        color: #999999;
        font-weight: 900;
        font-size: 26px;
        margin: 5px 0;
        padding: 15px 20px;
    }
    .infoTitle a span{
        float: right;
    }
    .infoTitle a span:hover{
        color: #686464;

    }
    .infoContentContainer{
        width: 95%;
        margin: 0 auto;
    }
    .infoContent{
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        grid-column-gap: 10px;
    }
    .specialInfo{
        display: grid;
        grid-template-rows: 1fr 4fr;
        padding: 15px 20px;
        border: none;
        /* border-radius: 10px; */
        place-items: center center;
        grid-row-gap: 10px;

    }
    .specialInfoTitle span{
        border: #232322 solid 2px;
        border-radius: 10px;
        font-size: 24px;
        font-weight: 600;
        padding: 10px 60px;
        margin: 30px 0;
        /* background-color: #BD9764; */
    }
    .specialInfoContent{
        display: grid;
        grid-template-rows: 1fr 1fr 1fr;
        width: 98%;
        grid-row-gap: 10px;
    }
    .infoItem{
        padding: 15px 20px;
        display: grid;
        grid-template-columns: 1fr 4fr;
        background-color: #F5F5F5;
        color: #686464;
        border-radius: 15px;
        grid-column-gap: 15px;
        transition: all 0.4s;
    }
    .infoItem:hover{
        background-color: blanchedalmond;
        color: black;
    }
    .itemPic{
        width: 110px;
        height: 85px;
    }
    .twoRow{
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }

</style>
