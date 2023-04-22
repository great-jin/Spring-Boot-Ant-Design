import Vue from 'vue';
import axios from 'axios';
import router from '@/router/index'

function request(axiosConfig) {
  const service = axios.create({
    baseURL: '/web-demo',   // 设置统一的请求前缀
    timeout: 300000         // 设置统一的超时时长
  })
  service.interceptors.request.use(config => {
    config.headers['Token'] = getToken()[0]
    config.headers['Authorization'] = getToken()[1]
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
    if (res.status === 203) {
      Vue.prototype.$notification['error']({
        message: 'Non-Authoritative',
        description: 'Non-Authoritative'
      })
      // No auth, redirect to home
      router.push('/form')
    }
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

function getToken() {
  let token = localStorage.getItem('token')
  if (token === undefined || token === null) {
    token = ''
  }
  let auth = localStorage.getItem('auth')
  if (auth === undefined || auth === null) {
    auth = ''
  }
  return [token, auth]
}

export default request;
