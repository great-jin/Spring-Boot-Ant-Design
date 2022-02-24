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
      <router-link to="/table" style="margin-right: 20px">
        <a-button>Table</a-button>
      </router-link>
      <router-link to="/file" style="margin-right: 20px">
        <a-button>Upload</a-button>
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
    width: 1000px;
    margin: 20px auto;
    text-align: center;
    color: #2c3e50;
  }
  .trans{
    margin-bottom: 15px;
  }
</style>
