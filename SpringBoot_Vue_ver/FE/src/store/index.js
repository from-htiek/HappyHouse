import { createStore } from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import memberStore from '@/store/modules/memberStore.js'
import boardStore from '@/store/modules/boardStore.js'
import noticeStore from '@/store/modules/noticeStore.js'
import commentStore from '@/store/modules/commentStore.js'
import houseStore from '@/store/modules/houseStore.js'
import bookmarkStore from '@/store/modules/bookmarkStore.js'
import houseLikeStore from '@/store/modules/houseLikeStore.js'
import popularStore from '@/store/modules/popularStore.js'

export default createStore({
  state: {
    sidebarVisible: '',
    sidebarUnfoldable: false,
  },
  mutations: {
    toggleSidebar(state) {
      state.sidebarVisible = !state.sidebarVisible
    },
    toggleUnfoldable(state) {
      state.sidebarUnfoldable = !state.sidebarUnfoldable
    },
    updateSidebarVisible(state, payload) {
      state.sidebarVisible = payload.value
    },
  },
  actions: {},
  modules: {
    houseStore,
    boardStore,
    commentStore,
    noticeStore,
    memberStore,
    bookmarkStore,
    houseLikeStore,
    popularStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
})
