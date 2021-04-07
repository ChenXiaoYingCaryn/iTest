<template>
    <div class="person">
        <new-top-nav></new-top-nav>

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
import NewTopNav from '../components/home/new-top-nav.vue'
import Dynamics from '../components/personal/dynamics.vue'
import PersonalInfo from '../components/personal/personalInfo.vue'
import PersonFunc from '../components/personal/personFunc.vue'
export default {
  name: 'person',
  components: { PersonalInfo, PersonFunc, Dynamics, NewTopNav }
}
</script>

<style scoped>
  .person{
    background-color: #F4F5F5;
    height: auto;
  }
</style>
