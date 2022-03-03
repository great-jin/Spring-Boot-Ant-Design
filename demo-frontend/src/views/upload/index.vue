<template>
  <div id="app">
    <div class="upload">
      <a-button type="primary" @click="showUpload()">上传</a-button>
      <uploadModal ref="uploadModal"></uploadModal>
    </div>

    <div style="margin-top: 50px">
      <a-input
        v-model="fileID"
        style="width: 40%"
        placeholder="请输入文件编号"
      />
      <a-button type="primary" @click="download()">下载</a-button>
    </div>

  </div>
</template>

<script>
import uploadModal from './uploadModal'
import { DownloadFile } from '@/api/files.js';
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
    showUpload(){
      this.$refs.uploadModal.paramReceive()
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
