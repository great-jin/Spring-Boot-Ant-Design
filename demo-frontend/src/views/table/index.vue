<template>
  <div>
    <div>
      <a-button
        type="primary"
        style="float: left; z-index: 1"
        @click="operationClick('add', null)"
      >新增</a-button>

      <a-input-search
        placeholder="input search text"
        style="width: 200px; float: right; z-index: 1"
        @search="onSearch()"
      />
    </div>

    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="{ pageSize: 5 }"
      :bordered="false"
      :customRow="customRow"
    >
      <template slot="status" slot-scope="text">
        <span v-if="text === 0"><a-tag  color="cyan">启用</a-tag></span>
        <span v-else><a-tag >注销</a-tag></span>
      </template>

      <template slot="operation" slot-scope="text, record, index">
        <a-button type="link" @click="operationClick('detail', record.key)">详情</a-button>
        <a-button type="link" @click="operationClick('edit', record.key)">修改</a-button>
      </template>
    </a-table>

    <userModal ref="userModal"></userModal>
  </div>
</template>

<script>
import userModal from './userModal'
import { List } from '@/api/user.js';
import { tableColumns } from "./const";

export default {
  components: {
    userModal
  },
  data() {
    return {
      data: [],
      columns: []
    }
  },
  created() {
    // 后端数据库
    List().then(res =>{
      for(let i in res){
        this.data.push({
          key: res[i].accountCode,
          id: res[i].id,
          accountCode: res[i].accountCode,
          userName: res[i].userName,
          password: res[i].password,
          isDelete: res[i].isDelete
        });
      }
    })
    this.columns = tableColumns
  },
  methods: {
    onSearch() {
      // do search
    },
    async refresh () {
      await this.operationClick('reset')
    },
    async operationClick (type, record) {
      switch (type) {
        case 'reset':
          break
        case 'add':
          console.log('add')
          this.$refs.userModal.paramReceive(type, record, false)
          break
        case 'edit':
          console.log('edit')
          this.$refs.userModal.paramReceive(type, record)
          break
        case 'detail':
          console.log('detail')
          this.$refs.userModal.paramReceive(type, record)
          break
      }
    },
    customRow(record){
      return {
        on:{
          dblclick: (event) => {
            console.log(record)
            this.$refs.userModal.paramReceive('add', null)
          }
        }
      }
    }
  }
}
</script>

<style scoped>
</style>
