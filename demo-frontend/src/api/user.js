import request from './util/axios';

export function List(params) {
    return request({
        url: '/users/list',
        method: 'get',
    })
}

export function getUser(params) {
  return request({
    url: `/users/get?code=${params}`,
    method: 'get'
  })
}

export function addUser(params) {
  return request({
    url: '/users/add',
    method: 'post',
    data: params
  })
}

export function Login(params) {
  return request({
    url: '/users/login',
    method: 'post',
    data: params
  })
}

export function updateUser(params) {
  return request({
    url: '/users/update',
    method: 'post',
    data: params
  })
}

export function deleteUser(params) {
  return request({
    url: `/users/delete?code=${params}`,
    method: 'get'
  })
}
