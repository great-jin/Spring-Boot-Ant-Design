<template>
  <div class="clearfix">
    <a-upload :file-list="fileList" :remove="handleRemove" :before-upload="beforeUpload">
      <a-button> <a-icon type="upload" /> Select File </a-button>
    </a-upload>

    <a-button
      type="primary"
      :disabled="fileList.length === 0"
      :loading="uploading"
      style="margin-top: 16px"
      @click="handleUpload"
    >
      {{ uploading ? 'Uploading' : 'Start Upload' }}
    </a-button>

    <div>
      <a-input v-model="fileID"/>
      <a-button @click="download()">下载</a-button>
    </div>
  </div>

</template>

<script>
import { UploadFile, DownloadFile } from '@/api/files.js';
export default {
  data() {
    return {
      fileList: [],
      uploading: false,
      fileID: ''
    }
  },
  methods: {
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
        formData.append('files', file);
      });
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
    },
    download(){
      const formData = new FormData()
      formData.append("fileID", this.fileID)
      DownloadFile(formData).then(res => {
        console.log(res)
      })
    }
  }
}
</script>

<style scoped>
</style>
