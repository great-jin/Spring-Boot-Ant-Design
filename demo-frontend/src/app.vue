<template>
  <div id="app">
    <div class="trans">
      <router-link to="/" style="margin-right: 20px">
        <a-button type="primary" style="width: 60%">首页</a-button>
      </router-link>
    </div>

    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide() {
    return {
      // 页面刷新
      reload: this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
}
</script>

<style scoped>
  #app {
    width: 70%;
    margin: 20px auto;
    text-align: center;
    color: #2c3e50;
  }
  .trans{
    margin-bottom: 15px;
  }
</style>
