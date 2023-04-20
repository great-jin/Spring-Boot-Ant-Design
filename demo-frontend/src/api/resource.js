import request from './util/axios';

const prefix = '/api/resource';

export function admin() {
  return request({
    url: `${prefix}/admin`,
    method: 'get'
  })
}

export function user() {
  return request({
    url: `${prefix}/user`,
    method: 'get'
  })
}
