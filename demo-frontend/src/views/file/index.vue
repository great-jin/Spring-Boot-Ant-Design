<template>
  <div id="app">
    <div class="upload">
      <a-button type="primary" @click="showUpload()">上传</a-button>
      <uploadModal ref="uploadModal" />
    </div>

    <a-input
      v-model="fileID"
      placeholder="请输入文件编号"
      style="width: 10%;margin: 50px 0 20px 0"
    />
    <br/><br/>

    <a-button type="primary" @click="download('txt')">Txt 下载</a-button>
    <a-button type="primary" @click="download('excel')">Excel 下载</a-button>
  </div>
</template>

<script>
import uploadModal from './uploadModal'
import {downloadFile} from '@/api/files.js';
import {downloadExcel} from '@/api/files.js';

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
        case 'txt':
          downloadFile({Info: '222'})
          break
        case 'excel':
          downloadExcel()
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
