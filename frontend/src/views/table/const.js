export const columns = cxt => {
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      dataIndex: 'id',
      width: '10%',
      align: 'center'
    },
    {
      title: '账号',
      dataIndex: 'accountCode',
      width: '15%',
      align: 'center',
      scopedSlots: { customRender: 'accountCode' },
    },
    {
      title: '用户名',
      dataIndex: 'userName',
      width: '20%',
      ellipsis: true,
      align: 'center'
    },
    {
      title: '密码',
      dataIndex: 'password',
      width: '20%',
      align: 'center'
    },
    {
      title: '状态',
      dataIndex: 'isDelete',
      width: '15%',
      align: 'center',
      customRender: (record) => {
        if(record === 0) {
          return <a-tag color="cyan">启用</a-tag>
        } else {
          return <a-tag >注销</a-tag>
        }
      }
    },
    {
      title: '操作',
      width: '25%',
      align: 'center',
      dataIndex: 'operation',
      scopedSlots: { customRender: 'operation' },
    }
  ]
}
