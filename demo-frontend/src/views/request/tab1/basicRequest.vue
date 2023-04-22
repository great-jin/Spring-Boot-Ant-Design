<template>
  <div>
    <a-row :style="{padding: '15px 25px', textAlign: 'center'}">
      <a-button type="primary"
                @click="request('success')"
                :style="{marginRight: '25px'}"
      >Success</a-button>
      <a-button type="danger"
                @click="request('error')"
      >Exception</a-button>
    </a-row>
  </div>
</template>

<script>
import {demo1, demo2} from '@/api/files.js'

export default {
  name: "axios",
  methods: {
    request(type) {
      switch (type) {
        case 'error':
          demo1().then(res => {
            console.log(res)
          })
          break
        case 'success':
          demo2().then(res => {
            console.log(res)
          })
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
