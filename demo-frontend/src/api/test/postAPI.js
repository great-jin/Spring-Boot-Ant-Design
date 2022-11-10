import request from '../util/axios';

/**
 * public String post1(String id)
 */
export function post1(params) {
  return request({
    url: '/api/axios/post1',
    method: 'post',
    params: params
  })
}

/**
 * public String post2(@RequestParam(value = "id") String id)
 */
export function post2(params) {
  return request({
    url: '/api/axios/post2',
    method: 'post',
    params: params
  })
}

/**
 * public String post3(@RequestParam(value = "id") String id,
 *                     @RequestParam(value = "message") String msg)
 */
export function post3(params) {
  return request({
    url: '/api/axios/post3',
    method: 'post',
    params: params
  })
}

/**
 * public String post4(Student student)
 */
export function post4(params) {
  return request({
    url: '/api/axios/post4',
    method: 'post',
    params: params
  })
}

/**
 * public String post5(@RequestBody Student student)
 */
export function post5(params) {
  return request({
    url: '/api/axios/post5',
    method: 'post',
    data: params
  })
}

/**
 * public String post6(@RequestParam String id,
 *                     @RequestBody Teacher teacher)
 */
export function post6(params1, params2) {
  return request({
    url: `/api/axios/post6`,
    method: 'post',
    params: params1, params2
  })
}

/**
 * public String post7(@RequestBody Student student,
 *                     @RequestBody Teacher teacher)
 */
export function post7(params1, params2) {
  return request({
    url: '/api/axios/post7',
    method: 'post',
    data: params1, params2
  })
}
