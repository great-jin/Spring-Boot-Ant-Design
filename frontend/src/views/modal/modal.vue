<template>
  <a-modal
    :title="type === 'add' ? '新增' : '详情'"
    :visible="visible"
    width="50%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>
    <div>
      Put content in here
    </div>
  </a-modal>
</template>

<script>
export default {
  name: "InfoModal",
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
    ok() {
      this.visible = false
      this.$message.success('关闭页面')
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
