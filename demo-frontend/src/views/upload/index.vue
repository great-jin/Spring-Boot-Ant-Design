<template>
  <div id="app">
    <div class="upload">
      <a-button type="primary" @click="showUpload()">上传</a-button>
      <uploadModal ref="uploadModal"></uploadModal>
    </div>

    <a-input
      v-model="fileID"
      placeholder="请输入文件编号"
      style="width: 10%;margin: 50px 0 20px 0"
    />
    <br/>
    <a-button type="primary" @click="download('txt')">Txt 下载</a-button>
    <a-button type="primary" @click="download('minio')">MinIO 下载</a-button>
    <a-button type="primary" @click="download('excel')">Excel 下载</a-button>
  </div>
</template>

<script>
import uploadModal from './uploadModal'
import {downloadTxt} from '@/api/files.js';
import {downloadExcel} from '@/api/files.js';
import {downloadFile} from '@/api/minioFile.js';

export default {
  components: {
    uploadModal
  },
  data() {
    return {
      fileID: '',
      fileList: [],
      uploading: false,
    }
  },
  methods: {
    showUpload() {
      this.$refs.uploadModal.paramReceive()
    },
    download(type) {
      switch (type) {
        case 'minio':
          if (this.fileID !== '') {
            const formData = new FormData()
            formData.append("fileID", this.fileID)
            downloadFile(formData).then(res => {
              console.log(res.data)
            })
          } else {
            this.$message.error('文件编号不能为空！')
          }
          break;
        case 'excel':
          downloadExcel()
          break;
        case 'txt':
          downloadTxt({Info: '222'})
          break;
      }
    }
  }
}
</script>

<style scoped>
</style>
