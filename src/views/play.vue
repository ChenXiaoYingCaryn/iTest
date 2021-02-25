<template>
    <div class="container">
        <top-nav></top-nav>
        <div class="wrapper">
            <div class="video-play"><video-play></video-play></div>
            <div class="video-recommend"><div class="b">推荐模块</div></div>
            <div class="video-comment"><div class="c">评论模块</div></div>
        </div>
    </div>
</template>

<script>
import VideoPlay from '../components/play/video-play.vue'
import topNav from '../components/topNav.vue'
export default {
  components: { topNav, VideoPlay },
  name: 'play'
}
</script>

<style scoped>
.container {
    background-color: #302f2d;
}

.wrapper {
    margin: 0 auto;
    width: 1200px;
    background-color: aqua;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 600px 600px;
}

.video-play {
    grid-column-start: 1;
    grid-column-end: 3;
    grid-row-start: 1;
    grid-row-end: 2;
    background-color: pink;
}
.video-comment {
    grid-column-start: 1;
    grid-column-end: 3;
    grid-row-start: 2;
    grid-row-end: 3;
    background-color: sandybrown;
}

.video-recommend {
    grid-column-start: 3;
    grid-column-end: 4;
    grid-row-start: 1;
    grid-row-end: 2;
    background-color: aqua;
}

.video-comment,.video-play,.video-recommend {
    display: inline-block;
}

@media screen and (max-width: 1200px) {
    .wrapper {
        grid-template-rows: auto;
    }
    .video-play {
        grid-column-end: 4;
        grid-row-start: 1;
        grid-row-end: 2;
    }
    .video-comment {
        grid-column-end: 4;
        grid-row-start: 3;
        grid-row-end: 4;
    }

    .video-recommend {
        grid-column-start: 1;
        grid-column-end: 4;
        grid-row-start: 2;
        grid-row-end: 3;
    }
}
.a {
    height: 200px;
}
.b {
    height: 400px;
}
.c {
    height: 200px;
}
</style>
