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
        :hidden="isDetail"
      >确定</a-button>
    </template>

    <a-spin :spinning="loading">
      <a-form-model
        ref="ruleForm"
        :rules="rules"
        :model="User"
      >
        <a-form-model-item
          label="账号"
          prop="accountCode"
        >
          <a-input
            placeholder="Account Code"
            v-model="User.accountCode"
            :disabled="isDetail"
          />
        </a-form-model-item>

        <a-form-model-item
          label="用户名"
          prop="userName"
        >
          <a-input
            placeholder="UserName"
            v-model="User.userName"
            :disabled="isDetail"
            />
        </a-form-model-item>

        <a-form-model-item
          label="密码"
          prop="password"
        >
          <a-input
            v-model="User.password"
            placeholder="Password"
            :disabled="isDetail"
            type="password"
            />
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
      visible: false,
      confirmLoading: false,
      loading: false,
      isDetail: false,
      User: {
        accountCode: '',
        userName: '',
        password: ''
      },
      rules: {
        accountCode: [{ required: true, message: '账号不能输入为空' }],
        userName: [{ required: true, message: '用户名不能输入为空' }],
        password: [{ required: true, message: '密码不能输入为空' }]
      }
    }
  },
  methods: {
    cancel() {
      this.visible = false
      this.$refs.ruleForm.resetFields()
    },
    ok() {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          console.log(this.User)
        } else {
          return false
        }
      })
    },
    paramReceive (type, data, IsDetail) {
      this.type = type
      this.visible = true
      console.log(data)
      this.isDetail = IsDetail
      if (this.type === 'add') {
        this.loading = false
      }
    }
  }
}
</script>

<style scoped>

</style>
