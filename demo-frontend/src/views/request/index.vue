<template>
  <a-tabs type="card" :style="{margin: '10px 30px'}">
    <a-tab-pane key="1" tab="Basic Request">
      <basic-request />
    </a-tab-pane>
    <a-tab-pane key="2" tab="File Request">
      <file-request />
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import basicRequest from './tab1/basicRequest.vue'
import fileRequest from './tab2/fileRequest.vue'

export default {
  inject: ['reload'],
  components: {
    basicRequest,
    fileRequest
  }
}
</script>

<style scoped>
</style>
