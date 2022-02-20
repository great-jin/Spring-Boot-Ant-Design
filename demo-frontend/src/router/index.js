import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/home'
import User from '@/views/user/index'
import Table from '@/views/table/index'
import Modal from '@/views/modal/index'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },{
      path: '/table',
      name: 'Table',
      component: Table
    },{
      path: '/user',
      name: 'User',
      component: User
    },{
      path: '/modal',
      name: 'Modal',
      component: Modal
    }
  ]
})
