<template>
    <div class="changeinfo">
        <new-top-nav></new-top-nav>
        <personal-info></personal-info>
        <person-info-page></person-info-page>
    </div>
</template>

<script>
import PersonalInfo from '../components/personal/personalInfo.vue'
import PersonInfoPage from '../components/personal/personInfoPage.vue'
import NewTopNav from '../components/home/new-top-nav'
// import TopNav from '../components/topNav.vue'

export default {
  name: 'changeInfo',
  components: { PersonInfoPage, PersonalInfo, NewTopNav }
}
</script>,
    <style scoped>

</style>
