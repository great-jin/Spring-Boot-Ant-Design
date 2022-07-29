<template>
  <a-config-provider :locale="zhCN">
    <div id="home">
      <a-layout id="top-banner">
        <a-layout-header>
          <div class="logo">Vue Demo</div>
        </a-layout-header>
      </a-layout>

      <a-layout class="side-bar">
        <a-layout-sider
          v-model="collapsed"
          :trigger="null"
          style="background-color: white"
          collapsible
        >
          <a-menu
            theme="light"
            mode="inline"
            :default-selected-keys="['0']"
          >
            <a-icon
              class="trigger"
              :type="collapsed ? 'menu-unfold' : 'menu-fold'"
              @click="() => (collapsed = !collapsed)"
            />
            <a-menu-item
              v-for="(item, index) in menuData"
              :key="index"
              @click="routePage(item.key)"
            >
              <a-icon type="user-add"/>
              <span>{{ item.title }}</span>
            </a-menu-item>
          </a-menu>
        </a-layout-sider>
        <a-layout style="height: 94%; padding: 20px 0">
          <a-layout-content class="layout-content">
            <router-view v-if="isRouterAlive"/>
          </a-layout-content>
        </a-layout>
      </a-layout>
    </div>
  </a-config-provider>
</template>

<script>
import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN'

export default {
  name: 'Home',
  data() {
    return {
      zhCN,
      collapsed: false,
      isRouterAlive: true,
      menuData: [
        {
          key: 'show',
          title: '页面弹窗'
        }, {
          key: 'form',
          title: 'Form表单'
        }, {
          key: 'auto',
          title: '动态表单'
        }, {
          key: 'formModel',
          title: 'Model表单'
        }, {
          key: 'table',
          title: 'Table表格'
        }, {
          key: 'file',
          title: '文件上传'
        }
      ]
    }
  },
  provide() {
    return {
      // 路由刷新方法
      reload: this.reload
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    routePage(data) {
      this.$router.push(`/${data}`)
    }
  }
}
</script>

<style scoped>
#home {
  width: 100%;
  height: 100%;
  position: absolute;
  overflow: hidden;
}

#top-banner .logo {
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

.side-bar {
  height: 100%;
}

.side-bar .trigger {
  font-size: 18px;
  line-height: 64px;
  padding: 0 30px;
  cursor: pointer;
  transition: color 0.3s;
}

.side-bar .trigger:hover {
  color: #1890ff;
}

.layout-content {
  margin: 0px 16px 24px 16px;
  padding: 15px;
  background: #fff;
  overflow-x: hidden;
  overflow-y: auto;
}
</style>
