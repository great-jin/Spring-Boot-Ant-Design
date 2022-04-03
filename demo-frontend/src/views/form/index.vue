<template>
  <div style="padding-top: 30px">
    <a-form
      :form="form"
    >
      <a-form-item
        label="账  号"
        :label-col="formLayout.labelCol"
        :wrapper-col="formLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input account"
          v-decorator="[
            'accountCode',
            { rules: [{ required: true, message: '账号不能为空!' }] }
          ]"
        />
      </a-form-item>
      <a-form-item
        label="用户名"
        :label-col="formLayout.labelCol"
        :wrapper-col="formLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input user name"
          v-decorator="[
            'userName',
            { rules: [{ required: true, message: '用户名不能为空!' }] }
          ]"
        />
      </a-form-item>
      <a-form-item
        label="密  码"
        :label-col="formLayout.labelCol"
        :wrapper-col="formLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input password"
          v-decorator="[
            'password',
            { rules: [{ required: true, message: '密码不能为空!' }] }
          ]"
        />
      </a-form-item>

      <a-form-item>
        <a-row style="text-align: center">
          <a-button type="primary"
                    @click="login"
                    style="margin: 0 25px">登录</a-button>
          <a-button type="primary"
                    @click="clear"
                    style="margin: 0 25px">取消</a-button>
        </a-row>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { Login } from '@/api/user.js';
export default {
  name: 'User',
  data() {
    return {
      backResult: '',
      formLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    login() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          Login(values).then(res =>{
            switch (res.data) {
              case 1 :
                this.$message.success('登录成功')
                break
              case 2 :
                this.$message.error('账号密码错误')
                break
              case 0 :
                this.$message.error('登录失败')
                break
            }
          })
          this.clear()
        }
      })
    },
    clear() {
      this.form.resetFields()
    }
  },
}
</script>

<style scoped>
</style>
