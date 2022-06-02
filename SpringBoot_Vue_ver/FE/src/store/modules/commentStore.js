// import Vuex from 'vuex'
// import router from '@/router'
import { listComment } from '@/api/comment.js'

const commentStore = {
  namespaced: true,
  state: {
    comments: [],
    comment: {},
  },
  getters: {},
  mutations: {
    GET_COMMENT_LIST: function (state, comments) {
      state.comments = comments
    },
  },
  actions: {
    getCommentList: ({ commit }, memboardId) => {
      listComment(
        memboardId,
        ({ data }) => {
          commit('GET_COMMENT_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default commentStore
