<template>
  <div style="padding: 0px 15px">
    <a-form-model
      ref="ruleForm"
      :model="form"
    >
      <div>
        <a-row style="margin-bottom: 15px">
          <a-col :span="12">
            <a-button type="primary" @click="addContact" >新增</a-button>
          </a-col>
          <a-col :span="12">
            <a-button
              type="primary"
              :style="{ marginLeft: '20px' }"
              style="float: right; z-index: 1"
              @click="cancel"
            >取消</a-button>
            <a-button
              type="primary"
              @click="ok"
              style="float: right; z-index: 1"
            >保存</a-button>
          </a-col>
          </a-row>
        <a-row
          :gutter="2"
          v-for="(item, index) in form.contactList"
          :key="index"
          style="margin-bottom: 15px"
        >
          <a-col :span="11">
            <a-form-model-item
              label="联系人"
              :prop="`contactList.${index}.contactName`"
              :rules="[{ required: true, message: '联系人不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.contactName"
                placeholder="请输入联系人"
                :allowClear="true"
                :maxLength="25"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="11">
            <a-form-model-item
              label="联系方式"
              :prop="`contactList.${index}.contactPhone`"
              :rules="[{ required: true, message: '联系方式不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.contactPhone"
                placeholder="请输入联系方式"
                :allowClear="true"
                :maxLength="25"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="2">
            <a-icon
              type="minus-circle-o"
              @click="() => remove(item)"
              class="dynamic-delete-button"
            />
          </a-col>
        </a-row>
      </div>
      <div :style="{ marginTop: '40px' }">
        <a-row>
          <a-col :span="24" :style="{ textAlign: 'center' }">
            </a-col>
        </a-row>
      </div>
    </a-form-model>
  </div>
</template>

<script>
export default {
  name: 'accessForm',
  data () {
    return {
      type: 'add',
      form: {
        contactList: []
      },
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      }
    }
  },
  methods: {
    ok () {
      const _len = this.form.contactList.length
      if (_len > 0) {
        this.$refs.ruleForm.validate(valid => {
          if (valid) {
            console.log(this.form.contactList)
            this.$message.success('提交表单')
            this.cancel()
          }
        })
      } else {
        this.$message.error('至少添加一个联系人')
      }
    },
    cancel () {
      this.$refs.ruleForm.resetFields()
      this.form.contactList = []
    },
    addContact () {
      this.form.contactList.push({
        uuid: this.guid(),
        contactName: '',
        contactPhone: ''
      })
    },
    remove (item) {
      this.form.contactList = this.form.contactList.filter(op => (op.uuid !== item.uuid))
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        const r = Math.random() * 16 | 0
        const v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    }
  }
}
</script>

<style scoped>
</style>
