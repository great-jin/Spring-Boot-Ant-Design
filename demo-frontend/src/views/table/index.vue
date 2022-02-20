<template>
  <a-table
    :columns="columns"
    :data-source="data"
    :pagination="{ pageSize: 5 }"
    :bordered="false"
  >
    <template slot="status" slot-scope="text">
      <span v-if="text === 0"><a-tag  color="cyan">在线</a-tag></span>
      <span v-else><a-tag >注销</a-tag></span>
    </template>

  </a-table>
</template>

<script>
import { List } from '@/api/user.js';
import { tableColumns, tableData } from "./const";

export default {
  data() {
    return {
      data: [],
      columns: []
    }
  },
  created() {
    /*
    // 后端数据库
    List().then(res =>{
      for(let i in res){
        this.data.push(res[i])
      }
    })
    */
    // 测试数据
    this.data = tableData
    this.columns = tableColumns
  }
}
</script>

<style scoped>
</style>
