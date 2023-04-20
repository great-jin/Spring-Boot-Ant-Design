<template>
  <div style="padding-top: 30px">
    <a-form :form="form">
      <a-form-item
        label="账  号"
        :label-col="formLayout.labelCol"
        :wrapper-col="formLayout.wrapperCol"
      >
        <a-input
          placeholder="Please input account"
          v-decorator="[
            'id',
            { rules: [{ required: true, message: '账号不能为空!' }] },
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
            { rules: [{ required: true, message: '用户名不能为空!' }] },
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
            { rules: [{ required: true, message: '密码不能为空!' }] },
          ]"
        />
      </a-form-item>

      <a-form-item>
        <a-row style="text-align: center">
          <a-button type="primary" @click="verify" style="margin: 0 25px"
            >登录</a-button
          >
          <a-button type="primary" @click="clear" style="margin: 0 25px"
            >取消</a-button
          >
        </a-row>
      </a-form-item>
    </a-form>

    <a-row style="text-align: center; margin-top: 20px">
      <a-button type="primary" @click="resource('user')" style="margin: 0 25px"
        >User</a-button
      >
      <a-button type="primary" @click="resource('admin')" style="margin: 0 25px"
        >Admin</a-button
      >
    </a-row>
  </div>
</template>

<script>
import { authVerify } from "@/api/auth.js";
import { user, admin } from "@/api/resource.js";

export default {
  name: "User",
  data() {
    return {
      formLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 },
      },
      form: this.$form.createForm(this),
    };
  },
  methods: {
    verify() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          authVerify(values).then((res) => {
            if (res.data) {
              this.$message.success("Login successful.");
            } else {
              this.$message.error("Login faild.");
            }
          });
          this.clear();
        }
      });
    },
    resource(type) {
      switch (type) {
        case "user":
          user().then((res) => {
            this.$message.success(res.data);
          });
          break;
        case "admin":
          admin().then((res) => {
            this.$message.success(res.data);
          });
          break;
      }
    },
    clear() {
      this.form.resetFields()
    }
  },
}
</script>

<style scoped>
</style>
