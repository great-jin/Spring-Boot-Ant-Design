import request from "./util/axios";

export function uploadFile(params) {
  return request({
    url: '/minio/upload',
    method: 'post',
    data: params,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function downloadFile(params) {
  return request({
    url: '/minio/download',
    method: 'post',
    data: params,
    responseType: 'blob'
  })
}
