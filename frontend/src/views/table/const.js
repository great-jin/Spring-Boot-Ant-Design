export const columns = cxt => {
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      width: '10%',
      align: 'center',
      dataIndex: 'id'
    },
    {
      title: '账号',
      width: '15%',
      align: 'center',
      dataIndex: 'username'
    },
    {
      title: '性别',
      width: '20%',
      align: 'center',
      dataIndex: 'gender'
    },
    {
      title: '生日',
      width: '20%',
      align: 'center',
      dataIndex: 'birthday'
    },
    {
      title: '状态',
      width: '15%',
      align: 'center',
      dataIndex: 'isDelete',
      customRender: (record) => {
        if (record === 0) {
          return <a-tag color="blue">启用</a-tag>
        } else {
          return <a-tag color="gray">注销</a-tag>
        }
      }
    },
    {
      title: '操作',
      width: '25%',
      align: 'center',
      dataIndex: 'operation',
      scopedSlots: {customRender: 'operation'},
    }
  ]
}
