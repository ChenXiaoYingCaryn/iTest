<template>
    <div class="hotVideo">
        <div class="videos">
            <div class="title">热门视频</div>
            <div class="video">
                <!-- <div><a href="#"><img src="../assets/picture/1.jpg" width="100%" height="100%"></a></div>
                <div><a href="#"><img src="../assets/picture/1.jpg" width="100%" height="100%"></a></div>
                <div><a href="#"><img src="../assets/picture/1.jpg" width="100%" height="100%"></a></div>
                <div><a href="#"><img src="../assets/picture/1.jpg" width="100%" height="100%"></a></div>
                <div><a href="#"><img src="../assets/picture/1.jpg" width="100%" height="100%"></a></div>
                <div><a href="#"><img src="../assets/picture/1.jpg" width="100%" height="100%"></a></div> -->
                <videoItem></videoItem>
                <videoItem></videoItem>
                <videoItem></videoItem>
                <videoItem></videoItem>
                <videoItem></videoItem>
                <videoItem></videoItem>

            </div>
        </div>
        <div class="news">
            <div class="newsTitle">热点文章</div>
            <div class="newsLists">
                <div class="newsList">
                    <div class="newsPic"><img src="../assets/picture/4.jpg" alt="" width="100%" height="100%"></div>
                    <div class="newsTxt">1231</div>
                </div>
                <div class="newsList">
                    <div class="newsPic"><img src="../assets/picture/4.jpg" alt="" width="100%" height="100%"></div>
                    <div class="newsTxt">1231</div>
                </div>
                <div class="newsList">
                    <div class="newsPic"><img src="../assets/picture/4.jpg" alt="" width="100%" height="100%"></div>
                    <div class="newsTxt">1231</div>
                </div>
                <div class="newsList">
                    <div class="newsPic"><img src="../assets/picture/4.jpg" alt="" width="100%" height="100%"></div>
                    <div class="newsTxt">1231</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import videoItem from '../components/video-item'
// import VideoItem from './video-item.vue'
export default {
    name: 'hotVideo',
    components: {
        videoItem,
    }
}
</script>

<style scoped>
    .hotVideo{
        width: 80%;
        margin: 0 auto;
        display: grid;
        grid-template-columns: 5fr 2fr;
        grid-column-gap: 2%;
    }
    .hotVideo .videos{
        display: grid;
        grid-template-rows: 1fr 5fr;
        place-items: center start;
    }
    .hotVideo .videos .title{
        font-size: 30px;
        font-weight: 600;
        color: #EFCD6D;
    }
    .hotVideo .videos .video{
        width: 95%;
        margin: 0 0 20px 0;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
        place-items: center center;
        grid-row-gap: 3%;
        grid-column-gap: 2%;
    }
    .video div a img{
        border-radius: 15px;
    }
    .news{
        display: grid;
        grid-template-rows: 1fr 5fr;
        place-items: center start;
    }
    .news .newsTitle{
        font-size: 30px;
        font-weight: 600;
        color: #EFCD6D;
    }
    .newsLists{
        display: grid;
        grid-template-rows: 1fr 1fr 1fr 1fr;
    }
    .newsList{
        padding: 15px 20px;
        display: grid;
        grid-template-columns: 1fr 4fr;
        background-color: #302F2D;
        color: ivory;
        grid-column-gap: 15px;
    }
    .newsPic{
        background-size: cover;
        /* 大屏幕 */
        width: 110px;
        height: 85px;
        /* 小屏幕 */
        /* width: 100px;
        height: 70px; */
    }
</style>