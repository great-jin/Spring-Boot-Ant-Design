<template>
  <div>
    <a-divider orientation="center">
      页内弹窗
    </a-divider>
    <a-row style="text-align: center">
      <a-button
        type="primary"
        @click="clickModal('add', '123')"
        style="margin-right: 20px"
      >新增</a-button>
      <a-button
        type="primary"
        @click="clickModal('detail', '456')"
      >详情</a-button>

      <showModal ref="showModal"></showModal>
    </a-row>
    <br/><br/><br/>
    <a-divider orientation="center">
      右侧抽屉
    </a-divider>
    <a-row style="text-align: center">
      <a-button
        type="primary"
        @click="clickDrawer('add', '123')"
        style="margin-right: 20px"
      >新增</a-button>
      <a-button
        type="primary"
        @click="clickDrawer('detail', '456')"
      >详情</a-button>

      <showDrawer ref="showDrawer"></showDrawer>
    </a-row>

  </div>
</template>

<script>
import showModal from './modal'
import showDrawer from "./drawer";

export default {
  components: {
    // 声明组件
    showModal,
    showDrawer
  },
  methods: {
    clickModal (type, data) {
      switch (type) {
        case 'add':
          // 点击按钮传入参数并显示 Modal 页面
          this.$refs.showModal.paramReceive(type, data)
          break
        case 'detail':
          // 点击按钮传入参数并显示 Modal 页面
          this.$refs.showModal.paramReceive(type, data)
          break
      }
    },
    clickDrawer (type, data) {
      switch (type) {
        case 'add':
          // 点击按钮传入参数并显示 Modal 页面
          this.$refs.showDrawer.paramReceive(type, data)
          break
        case 'detail':
          // 点击按钮传入参数并显示 Modal 页面
          this.$refs.showDrawer.paramReceive(type, data)
          break
      }
    }
  }
}
</script>

<style scoped>

</style>
