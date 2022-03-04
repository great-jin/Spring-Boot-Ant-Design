<template>
    <div>
      <router-link to="/user" style="margin: 0 20px">
        <a-button>User</a-button>
      </router-link>
      <router-link to="/table" style="margin: 0 20px">
        <a-button>Table</a-button>
      </router-link>
      <router-link to="/file" style="margin: 0 20px">
        <a-button>Upload</a-button>
      </router-link>
      <router-link to="/auto" style="margin: 0 20px">
        <a-button>AutoList</a-button>
      </router-link>

      <router-view />
    </div>
</template>

<script>
</script>

<style>
</style>
