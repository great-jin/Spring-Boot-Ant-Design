<template>
  <a-tabs type="card" :style="{margin: '10px 30px'}">
    <a-tab-pane key="1" tab="Basic Table">
      <basic-table />
    </a-tab-pane>
    <a-tab-pane key="2" tab="Pagination Table">
      <page-table />
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import basicTable from './tabs/basicTable.vue'
import pageTable from './tabs/pageTable.vue'

export default {
  inject: ['reload'],
  components: {
    basicTable,
    pageTable
  }
}
</script>

<style scoped>
</style>
