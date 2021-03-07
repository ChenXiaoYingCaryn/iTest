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
                                <div class="itemTxt">{{item.art_title}}</div>
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
                                <div class="itemTxt">{{item.art_title}}</div>
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
                                <div class="itemTxt">{{item.art_title}}</div>
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
        width: 80%;
        margin: 0 auto;
        display: grid;
        grid-template-rows: 1fr 5fr;
        /* place-items: center center; */
        /* background-color: #302F2D; */
        background-color: #E1E2E2;
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
        /* border: #EFCD6D solid 2px; */
        padding: 15px 20px;
        /* border-radius: 10px; */
    }
    .infoTitle a span{
        float: right;
        color: #999999;
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
        /* border: #EFCD6D solid 2px; */
        padding: 15px 20px;
        border-radius: 10px;
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
        background-color: #BD9764;
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
        /* background-color: #302F2D; */
        background-color: #E1E2E2;
        color: #686464;
        grid-column-gap: 15px;
        /* background-size: contain; */
    }
    .itemPic{
        background-size: cover;
        width: 110px;
        height: 85px;
    }
</style>
