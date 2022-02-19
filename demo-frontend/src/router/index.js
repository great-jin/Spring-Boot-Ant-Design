import Vue from 'vue'
import Router from 'vue-router'
import Page from '@/views/page/index'
import Table from '@/views/table/index'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/'
    },{
      path: '/page',
      components: Page
    },{
      path: '/table',
      components: Table
    }
  ]
})
