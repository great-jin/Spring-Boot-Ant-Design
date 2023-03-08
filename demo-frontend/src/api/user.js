import request from './util/axios';

export function Login(params) {
  return request({
    url: '/users/login',
    method: 'post',
    data: params
  })
}
