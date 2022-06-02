import { likeAreaList } from '@/api/bookmark.js'

const bookmark = {
  namespaced: true,
  state: {
    likeAreas: [],
  },

  getters: {},

  mutations: {
    SET_LIKEAREA_LIST: (state, areas) => {
      state.likeAreas = areas
      console.log('mutation', state.likeAreas)
    },
  },

  actions: {
    getLikeArea: ({ commit }, memId) => {
      likeAreaList(
        memId,
        ({ data }) => {
          commit('SET_LIKEAREA_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default bookmark
