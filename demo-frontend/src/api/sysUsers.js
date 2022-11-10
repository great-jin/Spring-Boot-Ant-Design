import request from './util/axios';

export function listUser() {
  return request({
    url: '/sysUser/list',
    method: 'get',
  })
}

export function getSysUser(params) {
  return request({
    url: `/sysUser/${params}`,
    method: 'get',
  })
}
