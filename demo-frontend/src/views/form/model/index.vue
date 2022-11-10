<template>
  <div style="padding: 0px 15px">
    <a-form-model
      ref="ruleForm"
      :model="form"
      :rules="rules"
    >
      <a-divider orientation="center">
        基本信息
      </a-divider>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="姓名"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.userName"
              placeholder="请输入姓名"
              :maxLength="25"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="性别"
            prop="userGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="form.userGender"
              placeholder="请选择性别"
              :default-value="undefined"
              :allowClear="true"
              style="width: 100%"
            >
              <a-select-option value="男">男</a-select-option>
              <a-select-option value="女">女</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="年龄"
            prop="userAge"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-number
              v-model="form.userAge"
              placeholder="请输入年龄"
              :min="1"
              :max="100"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="身高"
            prop="userHeight"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.userHeight"
              placeholder="请输入身高"
              suffix="CM"
              :allowClear="true"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="体重"
            prop="userWeight"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.userWeight"
              placeholder="请输入体重"
              suffix="KG"
              :allowClear="true"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="时间"
            prop="inTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="form.inTime"
              placeholder="请选择登记时间"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="备注"
            prop="comment"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.comment"
              type="text"
              :rows="4"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <div :style="{ marginTop: '40px' }">
        <a-row>
          <a-col :span="24" :style="{ textAlign: 'center' }">
            <a-button type="primary" @click="ok">保存</a-button>
            <a-button type="primary" :style="{ marginLeft: '50px' }" @click="cancel">取消</a-button>
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
        userName: '',
        userGender: undefined,
        userAge: '',
        userHeight: '',
        userWeight: '',
        inTime: '',
        comment: ''
      },
      rules: {
        userName: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        userGender: [
          { required: true, message: '请输入性别', trigger: 'change' }
        ],
        userAge: [
          { required: true, message: '请输入年龄', trigger: 'change' }
        ],
        userHeight: [
          { required: true, message: '请输入身高', trigger: 'change' }
        ],
        userWeight: [
          { required: true, message: '请输入体重', trigger: 'change' }
        ],
        inTime: [
          { required: true, message: '请输入体重', trigger: 'change' }
        ],
        userPhone: [
          { required: true, message: '请输入联系电话', trigger: 'change' }
        ],
        userAddress: [
          { required: true, message: '请输入籍贯住址', trigger: 'change' }
        ]
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
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          this.$message.success('提交表单')
        }
      })
    },
    cancel () {
      this.$refs.ruleForm.resetFields()
    }
  }
}
</script>

<style scoped>
</style>
