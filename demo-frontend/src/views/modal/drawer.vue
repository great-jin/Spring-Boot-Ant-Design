<template>
  <a-drawer
    :title="type === 'add' ? '新增' : '详情'"
    width="55%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <div>
      Put content in here
    </div>
  </a-drawer>
</template>

<script>
export default {
  name: "InfoDrawer",
  data() {
    return {
      type: '',
      visible: false
    }
  },
  methods: {
    // 接收 Index 页面传来的参数
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      console.log(data)
    },
    cancel() {
      this.visible = false
      this.$message.success('关闭页面')
    }
  }
}
</script>

<style scoped>

</style>
