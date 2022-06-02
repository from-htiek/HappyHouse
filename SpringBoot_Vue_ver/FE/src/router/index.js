// import { h, resolveComponent } from 'vue'
import { createRouter, createWebHashHistory } from 'vue-router'

import DefaultLayout from '@/layouts/DefaultLayout'
import store from '@/store/index.js'

const onlyAuthUser = async (to, from, next) => {
  // console.log(store);
  const checkUserInfo = store.getters['memberStore/checkUserInfo']
  const getUserInfo = store._actions['memberStore/getUserInfo']
  let token = sessionStorage.getItem('access-token')
  if (checkUserInfo == null && token) {
    await getUserInfo(token)
  }
  if (checkUserInfo === null) {
    // alert('로그인이 필요한 페이지입니다..')
    next({ name: 'signIn' })
    // router.push({ name: "signIn" });
  } else {
    // console.log("로그인 했다.");
    next()
  }
}

const routes = [
  {
    path: '/',
    name: 'Home',
    component: DefaultLayout,
    redirect: '/dashboard',
    children: [
      {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('@/views/Dashboard.vue'),
      },
      {
        path: '/board',
        name: 'BoardList',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/board/BoardList.vue'),
      },
      {
        path: '/board/write',
        name: 'BoardWrite',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/board/BoardWrite.vue'),
      },
      {
        path: '/board/detail/:no',
        name: 'BoardDetail',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/board/BoardDetail.vue'),
      },
      {
        path: '/board/modify/:no',
        name: 'BoardModify',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/board/BoardModify.vue'),
      },
      {
        path: '/notice',
        name: 'NoticeList',
        component: () => import('@/views/notice/NoticeList.vue'),
      },
      {
        path: '/notice/write',
        name: 'NoticeWrite',
        component: () => import('@/views/notice/NoticeWrite.vue'),
      },
      {
        path: '/notice/detail/:no',
        name: 'NoticeDetail',
        component: () => import('@/views/notice/NoticeDetail.vue'),
      },
      {
        path: '/notice/modify/:no',
        name: 'NoticeModify',
        component: () => import('@/views/notice/NoticeModify.vue'),
      },
      {
        path: '/user',
        name: 'user',
        component: () => import('@/views/MemberView.vue'),
        children: [
          {
            path: 'signin',
            name: 'signIn',
            component: () => import('@/components/user/MemberLogin.vue'),
          },
          {
            path: 'signup',
            name: 'signUp',
            component: () => import('@/components/user/MemberRegister.vue'),
          },
          {
            path: 'mypage',
            name: 'myPage',
            //beforeEnter: onlyAuthUser,
            component: () => import('@/components/user/MemberMyPage.vue'),
          },
          {
            path: 'update',
            name: 'update',
            //beforeEnter: onlyAuthUser,
            component: () => import('@/components/user/MemberUpdate.vue'),
          },
        ],
      },
      {
        path: '/house',
        name: 'House',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/HouseView.vue'),
      },
      {
        path: '/houselike',
        name: 'HouseLike',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/HouseLikeView.vue'),
      },
      {
        path: '/likeArea',
        name: 'LikeArea',
        beforeEnter: onlyAuthUser,
        component: () => import('@/views/LikeAreaView.vue'),
      },
      {
        path: '/popular',
        name: 'Popluar',
        component: () => import('@/views/PopularView.vue'),
      },
      {
        path: '/contact',
        name: 'Contact',
        component: () => import('@/views/ContactView.vue'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes,
  scrollBehavior() {
    // always scroll to top
    return { top: 0 }
  },
})

export default router
