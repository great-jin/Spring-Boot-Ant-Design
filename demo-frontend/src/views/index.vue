<template>
  <div id="app">
    <div class="trans">
      <router-link to='/table' style="margin-right: 60px">
        <a-button>Table</a-button>
      </router-link>
      <router-link to='/page'>
        <a-button>Second Page</a-button>
      </router-link>
    </div>

    <a-input v-model="accountCode" placeholder="Account Code" style="margin-bottom: 10px"/>
    <textarea v-model="backResult"
              placeholder="Result"
              disabled="disabled"
              style="width:500px; height: 100px; margin-bottom: 5px"/>
    <a-button @click="get()" style="margin-right: 120px">Get</a-button>
    <a-button @click="remove()">Delete</a-button>

    <a-form :form="form">
      <a-form-item>
          <a-input
            placeholder="Account Code"
            v-decorator="['accountCode', { rules: [{ required: true, message: '账号不能为空!' }] }]"
          />
      </a-form-item>
      <a-form-item>
        <a-input
          placeholder="UserName"
          v-decorator="['userName', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
        />
      </a-form-item>
      <a-form-item>
        <a-input
          placeholder="Password"
          v-decorator="['password', { rules: [{ required: true, message: '密码不能为空!' }] }]"
        />
      </a-form-item>

      <a-form-item>
        <a-button @click="list()" style="margin-right: 5px">List</a-button>
        <a-button @click="add()" style="margin-right: 5px">Add</a-button>
        <a-button @click="login()" style="margin-right: 5px">Login</a-button>
        <a-button @click="update()" style="margin-right: 100px">Update</a-button>
        <a-button @click="clear()">Clear</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { List, Login, getUser, addUser, updateUser, deleteUser} from '@/api/user.js';
export default {
  name: 'Home',
  data() {
    return {
      backResult: '',
      accountCode: '',
      form: this.$form.createForm(this)
    }
  },
  methods: {
    list() {
      List().then(res =>{
        this.$message.success('获取成功')
        this.backResult = res
      })
    },
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
    get() {
      const code = this.accountCode
      if(code !== '') {
        getUser(code).then(res =>{
          if (res === '用户不存在' ) {
            this.$message.error('用户不存在')
          } else {
            this.$message.success('获取成功')
            this.accountCode = ''
          }
          this.backResult = res
        })
      } else {
        this.$message.error('不能为空')
      }
    },
    remove() {
      const code = this.accountCode
      if(code !== '') {
        deleteUser(code).then(res =>{
          if (res === 1){
            this.$message.success('删除成功')
            this.accountCode = ''
          } else {
            this.$message.error('删除失败')
            this.accountCode = ''
          }
        })
      } else {
        this.$message.error('账号不能为空')
      }
    },
    clear() {
      this.form.resetFields()
    }
  },
}
</script>

<style scoped>
  #app {
    width: 500px;
    margin: 20px auto;
    text-align: center;
    color: #2c3e50;
  }
  .trans{
    margin-bottom: 15px;
  }
</style>
