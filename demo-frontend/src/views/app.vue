<template>
  <div id="home">
    <a-layout id="topBanner">
      <a-layout-header>
        <div class="logo">Vue Demo</div>
      </a-layout-header>
    </a-layout>

    <a-layout class="sideBar">
      <a-layout-sider
        v-model="collapsed"
        :trigger="null"
        style="background-color: white"
        collapsible
      >
        <a-menu theme="light" mode="inline" :default-selected-keys="['1']">
          <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
          />
          <a-menu-item key="5" @click="routePage('show')">
            <a-icon type="user-add" />
            <span>页面弹窗</span>
          </a-menu-item>
          <a-menu-item key="1" @click="routePage('form')">
            <a-icon type="user-add" />
            <span>Form表单</span>
          </a-menu-item>
          <a-menu-item key="6" @click="routePage('auto')">
            <a-icon type="user-add" />
            <span>动态表单</span>
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('formModel')">
            <a-icon type="user-add" />
            <span>Model表单</span>
          </a-menu-item>
          <a-menu-item key="3" @click="routePage('table')">
            <a-icon type="user-add" />
            <span>Table表格</span>
          </a-menu-item>
          <a-menu-item key="4" @click="routePage('file')">
            <a-icon type="user-add" />
            <span>文件上传</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="height: 94%; padding: 20px 0">
        <a-layout-content
          :style="{ margin: '0px 16px 24px 16px', padding: '15px', background: '#fff'}"
          style="overflow-x: hidden; overflow-y: auto; "
        >
          <router-view v-if="isRouterAlive"/>
        </a-layout-content>
      </a-layout>
    </a-layout>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      collapsed: false,
      isRouterAlive: true
    }
  },
  provide () {
    return {
      // 路由刷新方法
      reload: this.reload
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    routePage (data) {
      this.$router.push(`/${data}`)
    },
  }
}
</script>

<style scoped>
  #home{
    width: 100%;
    height: 100%;
    position: absolute;
    overflow: hidden;
  }
  #topBanner .logo {
    width: 120px;
    height: 31px;
    line-height: 31px;
    font-weight: bold;
    color: lightgray;
    font-size: 18px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px 28px 16px 0;
    padding-left: 7px;
    float: left;
  }
  .sideBar{
    height: 100%;
  }
  .sideBar .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 30px;
    cursor: pointer;
    transition: color 0.3s;
  }
  .sideBar .trigger:hover {
    color: #1890ff;
  }
</style>
