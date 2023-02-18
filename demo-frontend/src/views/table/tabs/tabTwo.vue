<template>
  <div>
    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="pagination"
      :bordered="false"
    >
      <template slot="operation" slot-scope="text, record, index">
        <a-button type="link" @click="clickOption('detail', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">修改</a-button>
      </template>
    </a-table>

    <userModal ref="userModal"></userModal>
  </div>
</template>

<script>
import {columns} from "./const";
import userModal from './userModal'
import {listUser, getPage} from "@/api/sysUsers";

export default {
  inject: ['reload'],
  components: {
    userModal
  },
  data() {
    return {
      data: [],
      tableData: [],
      pageRequest: {
        offset: 1,
        limit: 5
      },
      pagination: {
        total: 0, // 总数，必须先有
        defaultCurrent: 1, // 默认当前页数
        defaultPageSize: 5, // 默认当前页显示数据的大小
        showSizeChanger: true,
        showQuickJumper: true,
        pageSizeOptions: ["5", "10", "15", "20"],
        showTotal: (total) => `共 ${total} 条`, // 显示总数
        // 改变每页数量
        onShowSizeChange: (current, pageSize) => {
          this.pagination.defaultCurrent = 1
          this.pagination.defaultPageSize = pageSize
          this.updatePage(current, pageSize)
        },
        // 点击页数
        onChange: (current, size) => {
          this.pagination.defaultCurrent = current
          this.pagination.defaultPageSize = size
          this.updatePage(current, size)
        }
      }
    }
  },
  computed: {
    columns() {
      return columns(this)
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    getData() {
      getPage(this.pageRequest).then(res => {
        const _data = res.data
        this.data = _data.content
        this.pagination.total = _data.totalElements
        this.pagination.defaultCurrent = 1
        this.pagination.defaultPageSize = 5
      })
    },
    updatePage(offset, limit) {
      this.pageRequest.offset = offset - 1
      this.pageRequest.limit = limit
      getPage(this.pageRequest).then(res => {
        const _data = res.data
        this.data = _data.content
        this.pagination.total = _data.totalElements
        this.pagination.defaultCurrent = offset
        this.pagination.defaultPageSize = limit
      })
    },
    clickOption(type, record) {
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
    }
  }
}
</script>

<style scoped>
</style>
