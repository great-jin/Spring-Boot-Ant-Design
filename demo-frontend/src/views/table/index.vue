<template>
  <div>
    <a-row style="margin: 10px 0 20px 0">
      <a-button
        type="primary"
        style="float: left; z-index: 1"
        @click="clickOption('add', null)"
      >新增</a-button>
      <a-input-search
        v-model="accountCode"
        placeholder="输入账号进行查询"
        style="width: 200px; float: right; z-index: 1"
        @search="onSearch()"
      />
    </a-row>

    <a-config-provider :locale="zhCN">
      <a-table
        :columns="columns"
        :data-source="data"
        :pagination="pagination"
        :bordered="false"
        :customRow="customRow"
      >
        <template slot="operation" slot-scope="text, record, index">
          <a-button type="link" @click="clickOption('detail', record)">详情</a-button>
          <a-button type="link" @click="clickOption('edit', record)" >修改 </a-button>
        </template>
      </a-table>
    </a-config-provider>

    <userModal ref="userModal"></userModal>
  </div>
</template>

<script>
import { columns } from "./const";
import userModal from './userModal'
import { List, getUser } from '@/api/user.js';
import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN'

export default {
  inject: ['reload'],
  components: {
    userModal
  },
  data() {
    return {
      zhCN,
      data: [],
      tableData: [],
      accountCode: '',
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      }
    }
  },
  computed: {
    columns () {
      return columns(this)
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    getData(){
      // 获取表格数据
      List().then(res =>{
        this.data = res.data
      })
    },
    onSearch() {
      this.data = []
      const code = this.accountCode
      if (code !== ''){
        getUser(code).then(res =>{
          if(res.data.id != null){
            this.data.push(res.data)
          } else {
            this.$message.error('未查询到结果')
            this.reload()
          }
        })
      } else {
        this.reload()
      }
    },
    clickOption (type, record) {
      switch (type) {
        case 'reset':
          this.reload()
          break
        case 'add':
          this.$refs.userModal.paramReceive(type, null)
          break
        case 'edit':
          this.$refs.userModal.paramReceive(type, record.accountCode)
          break
        case 'detail':
          this.$refs.userModal.paramReceive(type, record.accountCode)
          break
      }
    },
    customRow(record){
      return {
        on:{
          click: () => {
            this.$message.success('Click record ' + record.userName)
          },
          dblclick: () => {
            this.$message.success('Double click record ' +record.userName)
          }
        }
      }
    }
  }
}
</script>

<style scoped>
</style>
