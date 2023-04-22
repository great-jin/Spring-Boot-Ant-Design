import request from './util/axios';

const prefix = '/api/auth';

export function authVerify(data) {
  return request({
    url: `${prefix}/verify`,
    method: 'post',
    params: data
  })
}

export function login(data) {
  return request({
    url: `${prefix}/login`,
    method: 'post',
    data: data
  })
}

