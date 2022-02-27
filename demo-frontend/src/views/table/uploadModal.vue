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
      <a-upload :file-list="fileList" :remove="handleRemove" :before-upload="beforeUpload">
        <a-button> <a-icon type="upload" /> Select File </a-button>
      </a-upload>
    </a-spin>
  </a-modal>
</template>

<script>
import { TableUpload } from '@/api/files.js';
export default {
  name: "UserModal",
  data() {
    return {
      type: '',
      visible: false,
      loading: false,
      fileList: [],
      uploading: false,
      userID: ''
    }
  },
  methods: {
    cancel() {
      this.visible = false
      this.form.resetFields()
    },
    paramReceive (data) {
      this.visible = true
      this.loading = false
      this.userID = data
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
      const { fileList } = this;
      const formData = new FormData();
      fileList.forEach(file => {
        formData.append('multipartFile', file);
      });
      formData.append('userID', this.userID)
      this.uploading = true;

      TableUpload(formData).then(res => {
        if (res) {
          this.fileList = [];
          this.uploading = false;
          this.$message.success('上传成功');
        } else {
          this.uploading = false;
          this.$message.error('上传失败');
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
