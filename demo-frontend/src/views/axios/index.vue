<template>
  <div>
    <a-button @click="okError">Error</a-button>
    <a-button @click="okSuccess">Success</a-button>
  </div>
</template>

<script>
import {demo1, demo4} from '@/api/test.js'

export default {
  name: "axios",
  methods: {
    okError() {
      demo1().then(res => {
        console.log(res)
      })
    },
    okSuccess() {
      demo4().then(res => {
        console.log(res)
      })
    }
  }
}
</script>

<style scoped>

</style>
