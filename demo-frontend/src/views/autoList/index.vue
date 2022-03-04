<template>
  <div>

  </div>
</template>

<script>
export default {
  name: "AutoList",
  data () {
    return {
      infoList: [],
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      }
    }
  },
  methods: {
    addItem () {
      this.infoList.push({
        uuid: this.guid(),
        personName: '',
        tel: ''
      })
    },
    remove (item) {
      this.infoList = this.infoList.filter(op => (op.uuid !== item.uuid) || (op.id !== item.id))
      const { type } = this
      if (type === 'edit') {
        this.infoList.push(item.id)
      }
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0
        var v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    }
  }
}
</script>

<style scoped>
</style>
