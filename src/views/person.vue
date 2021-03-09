<template>
    <div class="person">
        <personal-info></personal-info>

        <person-func></person-func>

        <dynamics></dynamics>
        <dynamics></dynamics>
        <dynamics></dynamics>
        <dynamics></dynamics>
        <dynamics></dynamics>
        <dynamics></dynamics>
        <dynamics></dynamics>
        <dynamics></dynamics>
    </div>
</template>

<script>
import Dynamics from '../components/personal/dynamics.vue'
import PersonalInfo from '../components/personal/personalInfo.vue'
import PersonFunc from '../components/personal/personFunc.vue'
export default {
  name: 'person',
  components: { PersonalInfo, PersonFunc, Dynamics }
}
</script>

<style scoped>

</style>
