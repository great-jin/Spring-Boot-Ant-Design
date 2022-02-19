<template>
  <div id="app">
    <h1>This is Vue Demo</h1>

    <div class="trans">
      <router-link to="/" style="margin-right: 20px">
        <a-button>Home</a-button>
      </router-link>
      <router-link to="/user" style="margin-right: 20px">
        <a-button>User</a-button>
      </router-link>
      <router-link to="/page" style="margin-right: 20px">
        <a-button>Page</a-button>
      </router-link>
      <router-link to="/table" style="margin-right: 20px">
        <a-button>Table</a-button>
      </router-link>
      <router-link to="/modal" style="margin-bottom: 20px">
        <a-button>Modal</a-button>
      </router-link>
    </div>

    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style scoped>
  #app {
    width: 500px;
    margin: 20px auto;
    text-align: center;
    color: #2c3e50;
  }
  .trans{
    margin-bottom: 15px;
  }
</style>