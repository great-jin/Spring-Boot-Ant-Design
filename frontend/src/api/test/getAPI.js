import request from '../util/axios';

/**
 * public String get1(String id)
 */
export function get1(params) {
  return request({
    url: `/api/axios/get1?id=${params}`,
    method: 'get'
  })
}

/**
 * public String get1(String id)
 */
export function get1_1(params) {
  return request({
    url: '/api/axios/get1',
    method: 'get',
    params: params
  })
}

/**
 * public String get2(@RequestParam(value = "id") String id)
 */
export function get2(params) {
  return request({
    url: '/api/axios/get2',
    method: 'get',
    params: params
  })
}

/**
 * public String get3(@RequestParam(value = "id") String id,
 *                    @RequestParam(value = "message") String msg)
 */
export function get3(params) {
  return request({
    url: '/api/axios/get3',
    method: 'get',
    params: params
  })
}

/**
 * public String get4(Student student)
 */
export function get4(params) {
  return request({
    url: '/api/axios/get4',
    method: 'get',
    params: params
  })
}
