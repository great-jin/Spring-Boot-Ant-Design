import request from "./util/axios";

const prefix = "/api/test"

export function demo1() {
  return request({
    method: 'get',
    url: `${prefix}/demo1`
  })
}

export function demo4() {
  return request({
    method: 'get',
    url: `${prefix}/demo4`
  })
}
