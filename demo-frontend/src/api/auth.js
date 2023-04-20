import request from './util/axios';

const prefix = '/api/auth';

export function authVerify(params) {
  return request({
    url: `${prefix}/verify`,
    method: 'post',
    data: params
  })
}
