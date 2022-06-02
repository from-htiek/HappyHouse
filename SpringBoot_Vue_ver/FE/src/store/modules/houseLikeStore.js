import { getList } from '@/api/bookmark.js'

const houseLikeStore = {
  namespaced: true,
  state: {
    houses: [], // 관심 매물 목록
    house: {}, // 선택한 관심 매물 좌표
  },
  getters: {},
  mutations: {
    GET_HOUSE_LIKE_LIST: (state, houses) => {
      state.houses = houses
      console.log(state.houses)
    },
    GET_HOUSE_LIKE: (state, latlng) => {
      state.house = latlng
      console.log('lat: ' + state.house.lat)
      console.log('lng: ' + state.house.lng)
    },
  },
  actions: {
    getHouselikeList({ commit }, id) {
      getList(
        id,
        ({ data }) => {
          console.log(data)
          commit('GET_HOUSE_LIKE_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
    getHouseLike({ commit }, latlng) {
      commit('GET_HOUSE_LIKE', latlng)
    },
  },
}

export default houseLikeStore
