import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '',
      redirect: '/form'
    },
    {
      path: '/form',
      name: 'form',
      component: () => import('@/views/form/index')
    }, {
      path: '/table',
      name: 'Table',
      component: () => import('@/views/table/index')
    }, {
      path: '/modal',
      name: 'Modal',
      component: () => import('@/views/modal/index')
    }, {
      path: '/axios',
      name: 'Axios',
      component: () => import('@/views/axios/index')
    }, {
      path: '/file',
      name: 'Files',
      component: () => import('@/views/file/index')
    }
  ]
})
