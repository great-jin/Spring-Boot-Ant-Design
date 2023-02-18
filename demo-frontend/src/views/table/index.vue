<template>
  <a-tabs type="card" :style="{margin: '10px 30px'}">
    <a-tab-pane key="1" tab="Tab 1">
      <tab-one />
    </a-tab-pane>
    <a-tab-pane key="2" tab="Tab 2">
      <tab-two />
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import tabOne from './tabs/tabOne.vue'
import tabTwo from './tabs/tabTwo.vue'

export default {
  inject: ['reload'],
  components: {
    tabOne,
    tabTwo
  }
}
</script>

<style scoped>
</style>
