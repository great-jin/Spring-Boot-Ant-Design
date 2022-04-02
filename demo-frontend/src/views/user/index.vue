<template>
  <div id="app">
    <a-form
      :form="form"
      style="width: 50%; margin: 0 auto;"
    >
      <a-form-item
        label="账号"
        :label-col="formItemLayout.labelCol"
        :wrapper-col="formItemLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input account"
          v-decorator="['accountCode', { rules: [{ required: true, message: '账号不能为空!' }] }]"
        />
      </a-form-item>
      <a-form-item
        label="用户名"
        :label-col="formItemLayout.labelCol"
        :wrapper-col="formItemLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input user name"
          v-decorator="['userName', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
        />
      </a-form-item>
      <a-form-item
        label="密码"
        :label-col="formItemLayout.labelCol"
        :wrapper-col="formItemLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input password"
          v-decorator="['password', { rules: [{ required: true, message: '密码不能为空!' }] }]"
        />
      </a-form-item>

      <a-form-item>
        <a-button type="primary" @click="operationFun('add')" style="margin: 0 25px">注册</a-button>
        <a-button type="primary" @click="operationFun('login')" style="margin: 0 25px">登录</a-button>
        <a-button type="primary" @click="clear()" style="margin: 0 25px">Clear</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { Login, addUser } from '@/api/user.js';
export default {
  name: 'User',
  data() {
    return {
      backResult: '',
      accountCode: '',
      formItemLayout: {
      labelCol: { span: 7 },
      wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    operationFun(type) {
      this.form.validateFields((errors, values) => {
          if (!errors) {
            switch (type) {
              case 'login':
                Login(values).then(res =>{
                  switch (res) {
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
                break
              case 'add':
                addUser(values).then(res =>{
                  switch (res) {
                    case 1 :
                      this.$message.success('新增成功')
                      break
                    case 2 :
                      this.$message.error('账号重复')
                      break
                    case 0 :
                      this.$message.error('新增失败')
                      break
                  }
                })
                break
            }
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
  #app {
    width: 1000px;
    margin: 20px auto;
    text-align: center;
    color: #2c3e50;
  }
</style>
