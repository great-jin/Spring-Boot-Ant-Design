import Vue from 'vue'
import Router from 'vue-router'
import Page from '@/views/page/index'
import Test from '@/components/index'

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
      path: '/test',
      components: Test
    }
  ]
})
