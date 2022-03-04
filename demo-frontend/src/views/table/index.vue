<template>
  <div>
    <div>
      <a-button
        type="primary"
        style="float: left; z-index: 1"
        @click="operationClick('add', null)"
      >新增</a-button>

      <a-input-search
        v-model="accountCode"
        placeholder="输入账号进行查询"
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
        <a-button type="link" @click="operationClick('edit', record.key)" >修改 </a-button>
      </template>
    </a-table>

    <userModal ref="userModal"></userModal>
  </div>
</template>

<script>
import userModal from './userModal'
import { List, getUser } from '@/api/user.js';
import { tableColumns } from "./const";

export default {
  inject: ['reload'],
  components: {
    userModal
  },
  data() {
    return {
      data: [],
      tableData: [],
      columns: [],
      accountCode: ''
    }
  },
  created() {
    // 接口数据填充
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
      this.data = []
      const code = this.accountCode
      if (code != ''){
        getUser(code).then(res =>{
          if(res.id != null){
            this.data.push(res)
          } else {
            this.$message.error('未查询到结果')
            this.reload()
          }
        })
      } else {
        this.reload()
      }
    },
    async refresh () {
      await this.operationClick('reset')
    },
    async operationClick (type, record) {
      switch (type) {
        case 'reset':
          this.reload()
          break
        case 'add':
          this.$refs.userModal.paramReceive(type, record)
          break
        case 'edit':
          this.$refs.userModal.paramReceive(type, record)
          break
        case 'detail':
          this.$refs.userModal.paramReceive(type, record)
          break
      }
    },
    customRow(record){
      return {
        on:{
          dblclick: (event) => {
            console.log(record)
            this.$message.success('你双击了表格')
          }
        }
      }
    }
  }
}
</script>

<style scoped>
</style>
