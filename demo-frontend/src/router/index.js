import Vue from 'vue'
import Router from 'vue-router'
import Page from '@/views/page/index'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/'
    },{
      path: '/page/index',
      components: Page
    }
  ]
})
