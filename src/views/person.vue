<template>
    <div class="person">
        <personal-info></personal-info>

        <person-func></person-func>

        <person-info-page></person-info-page>
    </div>
</template>

<script>
import PersonalInfo from '../components/personal/personalInfo.vue'
import PersonFunc from '../components/personal/personFunc.vue'
import PersonInfoPage from '../components/personal/personInfoPage.vue'
export default {
  name: 'person',
  components: { PersonalInfo, PersonFunc, PersonInfoPage }
}
</script>

<style scoped>

</style>
