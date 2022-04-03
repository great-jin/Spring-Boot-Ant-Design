import Vue from 'vue'
import Router from 'vue-router'

import Form from '@/views/form/index'
import FormModel from '@/views/form/model/index'
import Table from '@/views/table/index'
import Files from '@/views/upload/index'
import Shows from '@/views/modal/index'
import Auto from '@/views/auto/index'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/form',
      name: 'form',
      component: Form
    },
    {
      path: '/formModel',
      name: 'formModel',
      component: FormModel
    },
    {
      path: '/table',
      name: 'Table',
      component: Table
    },
    {
      path: '/file',
      name: 'Files',
      component: Files
    },
    {
      path: '/show',
      name: 'Shows',
      component: Shows
    },
    {
      path: '/auto',
      name: 'Auto',
      component: Auto
    }
  ]
})
