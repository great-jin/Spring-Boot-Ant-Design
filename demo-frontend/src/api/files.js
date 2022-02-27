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
