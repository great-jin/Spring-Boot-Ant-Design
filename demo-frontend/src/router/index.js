import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/form',
      name: 'form',
      component: () => import('@/views/form/index')
    }, {
      path: '/formModel',
      name: 'formModel',
      component: () => import('@/views/form/model/index')
    }, {
      path: '/table',
      name: 'Table',
      component: () => import('@/views/table/index')
    }, {
      path: '/file',
      name: 'Files',
      component: () => import('@/views/file/index')
    }, {
      path: '/modal',
      name: 'Modal',
      component: () => import('@/views/modal/index')
    }, {
      path: '/auto',
      name: 'Auto',
      component: () => import('@/views/auto/index')
    }
  ]
})
