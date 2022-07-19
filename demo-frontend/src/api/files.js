import request from './util/axios';

export function UploadFile(params) {
  return request({
    url: '/files/upload',
    method: 'post',
    data: params,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export const download = params => request({
  method: 'get',
  url: '/files/downloadExcel',
  responseType: 'blob',
  params,
  headers: { 'Access-Control-Allow-origin': '*', 'Content-Type': 'charset=UTF-8' }
}).then((res) => {
  if (res && res.status === 200) {
    // 设置文件后缀
    let fileName = '' + res.headers.filename + '.txt'
    fileName = decodeURI(fileName)
    const blob = new Blob([res.data])
    let brower = ''
    if (navigator.userAgent.indexOf('Edge') > -1) {
      brower = 'Edge'
    }
    if ('download' in document.createElement('a')) {
      if (brower === 'Edge') {
        navigator.msSaveBlob(blob, fileName)
        return
      }
      const url = window.URL.createObjectURL(res.data)
      const link = document.createElement('a')
      link.style.display = 'none'
      link.href = url
      link.setAttribute('download', fileName)
      if (!document.getElementById(fileName)) {
        document.body.appendChild(link)
      }
      link.click()
      URL.revokeObjectURL(link.herf)
      document.body.removeChild(link)
    } else {
      // IE10+下载
      navigator.msSaveBlob(blob, fileName)
    }
  }
}).catch(error => {
  console.log(error)
})
