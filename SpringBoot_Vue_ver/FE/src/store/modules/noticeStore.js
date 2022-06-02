// import Vuex from 'vuex'
// import router from '@/router'
import { listNotice } from '@/api/notice.js'

const noticeStore = {
  namespaced: true,
  state: {
    notices: [],
    notice: {},
  },
  getters: {},
  mutations: {
    GET_NOTICE_LIST: function (state, notices) {
      state.notices = notices
    },
  },
  actions: {
    getNoticeList: ({ commit }) => {
      listNotice(
        ({ data }) => {
          commit('GET_NOTICE_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default noticeStore
