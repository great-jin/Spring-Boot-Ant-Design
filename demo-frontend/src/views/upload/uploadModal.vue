<template>
  <a-modal
    title="上传"
    :visible="visible"
    width="40%"
    @cancel="cancel()">

    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        style="margin-top: 16px"
        :loading="uploading"
        :disabled="fileList.length === 0"
        @click="handleUpload"
      >{{ uploading ? '上传中' : '上传' }}</a-button>
    </template>

    <a-spin :spinning="loading">
      <a-input
        v-model="userID"
        placeholder="请输入用户 ID"
        rules="rules"
      />
      <a-upload
        style="margin-top: 5px"
        :file-list="fileList"
        :remove="handleRemove"
        :before-upload="beforeUpload">
        <a-button> <a-icon type="upload" /> Select File </a-button>
      </a-upload>
    </a-spin>
  </a-modal>
</template>

<script>
import { UploadFile } from '@/api/files.js';
export default {
  name: "UserModal",
  data() {
    return {
      visible: false,
      loading: false,
      uploading: false,
      userID: '',
      fileList: [],
      rules: {
        userID: [{ required: true, message: '不能输入为空' }]
      }
    }
  },
  methods: {
    paramReceive () {
      this.visible = true
      this.loading = false
    },
    cancel() {
      this.visible = false
    },
    handleRemove(file) {
      const index = this.fileList.indexOf(file);
      const newFileList = this.fileList.slice();
      newFileList.splice(index, 1);
      this.fileList = newFileList;
    },
    beforeUpload(file) {
      this.fileList = [...this.fileList, file];
      return false;
    },
    handleUpload() {
      if (this.userID !== ''){
        const { fileList } = this;
        const formData = new FormData();
        fileList.forEach(file => {
          formData.append('files', file);
        });
        formData.append('ID', this.userID)
        this.uploading = true;

        UploadFile(formData).then(res => {
          if (res) {
            this.fileList = [];
            this.uploading = false;
            this.$message.success('上传成功');
          } else {
            this.uploading = false;
            this.$message.error('上传失败');
          }
        })
      } else {
        this.$message.error('ID 不能为空')
      }
    }
  }
}
</script>

<style scoped>
</style>
