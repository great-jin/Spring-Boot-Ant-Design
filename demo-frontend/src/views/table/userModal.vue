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
        :hidden="isDetail"
        :loading="confirmLoading"
        @click="ok()"
      >确定</a-button>
    </template>

    <a-spin :spinning="loading">
      <a-form :form="form">
        <a-form-item label="账号">
          <a-input
            placeholder="Account Code"
            :disabled="isDetail || isEdit"
            v-decorator="['accountCode', { rules: [{ required: true, message: '账号不能为空!' }] }]"
          />
        </a-form-item>

        <a-form-item label="用户名">
          <a-input
            placeholder="UserName"
            :disabled="isDetail"
            v-decorator="['userName', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
            />
        </a-form-item>

        <a-form-item label="密码">
          <a-input
            placeholder="Password"
            :disabled="isDetail"
            v-decorator="['password', { rules: [{ required: true, message: '密码不能为空!' }] }]"
            />
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
import { getUser, addUser, updateUser} from '@/api/user.js';
export default {
  name: "UserModal",
  data() {
    return {
      type: '',
      visible: false,
      confirmLoading: false,
      loading: false,
      isDetail: false,
      isEdit: false,
      form: this.$form.createForm(this)
    }
  },
  methods: {
    cancel() {
      this.visible = false
      this.form.resetFields()
    },
    ok() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          const { type } = this
          switch (type) {
            case 'edit':
              updateUser(values).then(res =>{
                if (res === 1){
                  this.$message.success('更新成功')
                } else {
                  this.$message.error('更新失败')
                }
              })
              break
          }
        } else {
          return false
        }
      })
    },
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      this.loading = false
      if (this.type === 'add') {
        this.isDetail = false
        this.isEdit = false
      }
      if (this.type === 'detail') {
        this.isDetail = true
        this.isEdit = false
        this.setFormValue(data)
      }
      if (this.type === 'edit') {
        this.isEdit = true
        this.isDetail = false
        this.setFormValue(data)
      }
    },
    setFormValue(data) {
      const code = data
      if(code !== '') {
        getUser(code).then(res =>{
          console.log(res)
          this.form.setFieldsValue({
            accountCode: res.accountCode,
            userName: res.userName,
            password: res.password
          })
        })
      }
    }
  }
}
</script>

<style scoped>

</style>
