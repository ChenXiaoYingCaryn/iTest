<template>
    <div class="changeinfo">
        <top-nav></top-nav>
        <personal-info></personal-info>
        <person-info-page></person-info-page>
    </div>
</template>

<script>
import PersonalInfo from '../components/personal/personalInfo.vue'
import PersonInfoPage from '../components/personal/personInfoPage.vue'
import TopNav from '../components/topNav.vue'
export default {
  name: 'changeInfo',
  components: { PersonInfoPage, TopNav, PersonalInfo }
}
</script>

    <style scoped>

</style>
