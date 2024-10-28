import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

	import chat from '@/views/modules/chat/list'
    import orders from '@/views/modules/orders/list'
	import storeup from '@/views/modules/storeup/list'
	import config from '@/views/modules/config/list'
    import news from '@/views/modules/news/list'	
	
	import fendian from '@/views/modules/fendian/list'
	import jianjie from '@/views/modules/jianjie/list'
	
    import yonghu from '@/views/modules/yonghu/list'
    import canzhuo from '@/views/modules/canzhuo/list'
    import dingdanxiangqing from '@/views/modules/dingdanxiangqing/list'
	import caipin from '@/views/modules/caipin/list'
	import diancan from '@/views/modules/caipin/diancan'	
    import kuchuen from '@/views/modules/kuchuen/list'
	import liushui from '@/views/modules/liushui/list'
	import yudingcanzhuo from '@/views/modules/yudingcanzhuo/list'

//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }  ,{
	path: '/chat',
        name: '客服管理',
        component: chat
      }
	  ,{
	  path: '/jianjie',
	      name: '餐厅简介',
	      component: jianjie
	    }
		,{
		path: '/fendian',
		    name: '分店信息',
		    component: fendian
		  }
         ,{
         path: '/news',
             name: '餐厅资讯',
             component: news
           } ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
	  ,{
	  path: '/storeup',
	      name: '我的收藏管理',
	      component: storeup
	    }
	  ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      },
	  {
	  path: '/kuchuen',
	      name: '库存',
	      component: kuchuen
	  },
	  {
	  path: '/caipin',
	      name: '菜品',
	      component: caipin
	  },
	  {
	  path: '/diancan',
	      name: '点餐',
	      component: diancan
	  },
	  
	  {
	  path: '/canzhuo',
	      name: '餐桌',
	      component: canzhuo
	  },
	  {
	  path: '/yudingcanzhuo',
	      name: '预定餐桌',
	      component: yudingcanzhuo
	  }, {
	path: '/config',
        name: '轮播图管理',
        component: config
      },
	  {
	  path: '/dingdanxiangqing',
	      name: '订单',
	      component: dingdanxiangqing
	  },
	  {
	  path: '/liushui',
	      name: '流水',
	      component: liushui
	  },
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
