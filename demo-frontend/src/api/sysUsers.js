import request from './util/axios';

const prefix = '/api/sysUser';

export function listUser() {
  return request({
    url: `${prefix}/list`,
    method: 'get',
  })
}

export function getPage(params) {
  return request({
    url: `${prefix}/page`,
    method: 'get',
    params: params
  })
}

export function getSysUser(params) {
  return request({
    url: `${prefix}/${params}`,
    method: 'get',
  })
}
