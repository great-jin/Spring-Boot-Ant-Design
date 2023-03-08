import request from "./util/axios";

export function uploadFile(params) {
  return request({
    method: 'post',
    url: '/api/minio/upload',
    data: params,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function minioDownload(params) {
  return request({
    url: '/api/minio/download',
    method: 'post',
    data: params,
    responseType: 'blob'
  }).then((res) => {
    // 获取文件名
    let fileName = res.headers["content-disposition"]
    // 解密文件名
    fileName = decodeURI(fileName)
    fileName = fileName.substring(fileName.lastIndexOf("="))
    fileName = fileName.slice(1)
    // 解析内容
    const content = res.data
    const blob = new Blob([content])
    if ('download' in document.createElement('a')) {
      // 非IE下载
      const elink = document.createElement('a')
      elink.download = fileName
      elink.style.display = 'none'
      elink.href = URL.createObjectURL(blob)
      document.body.appendChild(elink)
      elink.click()
      URL.revokeObjectURL(elink.href) // 释放URL 对象
      document.body.removeChild(elink)
    } else {
      // IE10+下载
      navigator.msSaveBlob(blob, fileName)
    }
  }).catch(error => {
    console.log(error)
  })
}
