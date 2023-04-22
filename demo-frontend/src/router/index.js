import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
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
      path: '/request',
      name: 'Request',
      component: () => import('@/views/request/index')
    }
  ]
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.path !== '/form' && token === null) {
    next('/form')
    Vue.prototype.$notification['error']({
      message: 'Please login',
      description: 'Please login'
    })
  } else {
    next()
  }
})

export default router
