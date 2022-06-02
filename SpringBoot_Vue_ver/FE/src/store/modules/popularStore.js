import { areaList, houseList } from '@/api/popular.js'
//houseList
const popularStore = {
  namespaced: true,
  state: {
    pAreas: [],
    pHouses: [],
  },
  getters: {},
  mutations: {
    SET_PAREA_LIST: (state, areas) => {
      state.pAreas = areas
      // console.log('mutation', state.pAreas)
    },
    SET_PHOUSE_LIST: (state, houses) => {
      state.pHouses = houses
      console.log('mutation', state.pHouses)
    },
  },
  actions: {
    getArea: ({ commit }) => {
      areaList(
        ({ data }) => {
          commit('SET_PAREA_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
    getHouse: ({ commit }) => {
      houseList(
        ({ data }) => {
          commit('SET_PHOUSE_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default popularStore
