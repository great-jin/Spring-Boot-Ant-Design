import Vue from 'vue';
import axios from 'axios';

function request(axiosConfig) {
  const service = axios.create({
    baseURL: '/web-demo',   // 设置统一的请求前缀
    timeout: 300000         // 设置统一的超时时长
  })
  service.interceptors.request.use(config => {
    return config
  }, err => {
    const errorBody = err.response.data
    Vue.prototype.$notification['error']({
      message: errorBody.error,
      description: errorBody
    })
  })
  // 响应拦截
  service.interceptors.response.use(res => {
    return res
  }, err => {
    const errorBody = err.response.data
    Vue.prototype.$notification['error']({
      message: 'Internal Server Error',
      description: errorBody.error
    })
  })
  return service(axiosConfig)
}

export default request;
