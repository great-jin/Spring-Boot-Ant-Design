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
    url: `${prefix}/get`,
    method: 'get',
    params: params
  })
}

export function addSysUser(params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateSysUser(params) {
  return request({
    url: `${prefix}/edit`,
    method: 'post',
    data: params
  })
}
