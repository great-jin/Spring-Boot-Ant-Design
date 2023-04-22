<template>
  <div id="app">
    <div>
      <a-row :style="{padding: '15px 25px', textAlign: 'center'}">
        <a-button type="primary"
                  @click="showUpload()"
                  :style="{marginRight: '25px'}"
        >上传</a-button>
        <a-button type="primary"
                  @click="download('txt')"
                  :style="{marginRight: '25px'}"
        >Txt下载</a-button>
        <a-button type="primary"
                  @click="download('excel')"
        >Excel下载</a-button>

        <uploadModal ref="uploadModal"/>
      </a-row>
    </div>
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
