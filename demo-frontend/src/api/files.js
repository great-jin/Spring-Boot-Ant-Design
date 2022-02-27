import request from './axios';

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

export function TableUpload(params) {
  return request({
    url: '/files/uploadFiles',
    method: 'post',
    data: params
  })
}
