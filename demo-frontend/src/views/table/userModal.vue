<template>
  <a-modal
    :title="type === 'add' ? '新增' : type === 'edit'? '编辑' : '详情'"
    :visible="visible"
    width="40%"
    @cancel="cancel()">

    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        :loading="confirmLoading"
        @click="ok()"
      >确定</a-button>
    </template>

    <a-spin :spinning="loading">
      <a-form-model>
        <a-form-model-item>
          <a-input placeholder="请输入单位名称" />
        </a-form-model-item>
      </a-form-model>
    </a-spin>
  </a-modal>
</template>

<script>
export default {
  name: "UserModal",
  data() {
    return {
      type: '',
      visible: true,
      confirmLoading: false,
      loading: false
    }
  },
  methods: {
    cancel() {
      this.visible = false
    },
    ok() {
      this.visible = false
    },
    paramReceive (type, data, isSelected) {
      this.type = type
      this.visible = true
      if (this.type === 'add') {
        this.loading = false
      }
      if (this.type === 'detail') {

      }
    }
  }
}
</script>

<style scoped>

</style>
