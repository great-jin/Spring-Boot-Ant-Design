<template>
  <a-tabs type="card" :style="{margin: '10px 30px'}">
    <a-tab-pane key="1" tab="Basic Form">
      <basic-form />
    </a-tab-pane>
    <a-tab-pane key="2" tab="Model Form">
      <model-form />
    </a-tab-pane>
    <a-tab-pane key="3" tab="Dynamic Form">
      <auto-form />
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import basicForm from './tabs/basicForm.vue'
import modelForm from './tabs/modelForm.vue'
import autoForm from './tabs/autoForm.vue'

export default {
  inject: ['reload'],
  components: {
    basicForm,
    modelForm,
    autoForm
  }
}
</script>

<style scoped>
</style>
