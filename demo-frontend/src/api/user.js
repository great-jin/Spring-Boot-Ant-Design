import request from './axios';

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

// 传入Json对象的键值对
export function Login(params) {
    return request({
        url: '/users/login',
        method: 'post',
        data: params
    })
}
