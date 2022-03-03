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
        <a-button type="primary" @click="login()" style="margin-right: 100px">Login</a-button>
        <a-button type="primary" @click="clear()">Clear</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { Login, addUser, updateUser} from '@/api/user.js';
export default {
  name: 'User',
  data() {
    return {
      backResult: '',
      accountCode: '',
      form: this.$form.createForm(this),
      formItemLayout: {
      labelCol: { span: 7 },
      wrapperCol: { span: 14 }
    }
    }
  },
  methods: {
    add() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
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
        }
        this.clear()
      })
    },
    update() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          updateUser(values).then(res =>{
            if (res === 1){
              this.$message.success('更新成功')
            } else {
              this.$message.error('更新失败')
            }
          })
        }
        this.clear()
      })
    },
    login() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
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
        }
        this.clear()
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
