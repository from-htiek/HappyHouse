import {
  sidoList,
  gugunList,
  dongList,
  houseListByDong,
  houseListbyName,
  houseDetail,
} from '@/api/house.js'

const houseStore = {
  namespaced: true,
  state: {
    sidos: [{ label: '선택하세요', value: null }],
    guguns: [{ label: '선택하세요', value: null }],
    dongs: [{ label: '선택하세요', value: null }],
    houses: [],
    house: [],
    isDone: false,
  },

  getters: {},

  mutations: {
    SET_SIDO_LIST: (state, sidos) => {
      sidos.forEach((sido) => {
        // console.log(sido)
        state.sidos.push({ label: sido.sidoName, value: sido.sidoCode })
      })
      // console.log('sido mutation', state.sidos)
      // state.isSidoChange = !state.isSidoChange
    },
    SET_GUGUN_LIST: (state, guguns) => {
      guguns.forEach((gugun) => {
        state.guguns.push({ label: gugun.gugunName, value: gugun.gugunCode })
      })
      // console.log('gugun mutation', state.guguns)
    },
    SET_DONG_LIST: (state, dongs) => {
      dongs.forEach((dong) => {
        state.dongs.push({ label: dong.dongName, value: dong.dongCode })
      })
      // console.log('dong mutation', state.dongs)
    },
    SET_HOUSE_LIST: (state, houses) => {
      state.houses = houses
      state.isDone = !state.isDone
    },
    SET_DETAIL_HOUSE: (state, house) => {
      state.house = house
      // console.log(state.house)
    },

    CLEAR_SIDO_LIST: (state) => {
      state.sidos = [{ label: '선택하세요', value: null }]
    },
    CLEAR_GUGUN_LIST: (state) => {
      state.guguns = [{ label: '선택하세요', value: null }]
    },
    CLEAR_DONG_LIST: (state) => {
      state.dongs = [{ label: '선택하세요', value: null }]
    },
  },

  actions: {
    getSido: ({ commit }) => {
      sidoList(
        // async getSido({ commit }) {
        //   await sidoList(
        ({ data }) => {
          // console.log(data)
          commit('SET_SIDO_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
    getGugun: ({ commit }, sidoCode) => {
      const params = {
        sido: sidoCode,
      }
      gugunList(
        params,
        ({ data }) => {
          // console.log(data)
          // console.log(commit, response)
          commit('SET_GUGUN_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
    getDong: ({ commit }, gugunCode) => {
      const params = {
        gugun: gugunCode,
      }
      dongList(
        params,
        ({ data }) => {
          commit('SET_DONG_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
    getHouseListByDong: ({ commit }, dongCode) => {
      const params = {
        dong: dongCode,
      }
      houseListByDong(
        params,
        ({ data }) => {
          // console.log(data)
          commit('SET_HOUSE_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },

    getHouseListByName: ({ commit }, aptName) => {
      const params = {
        aptName,
      }
      houseListbyName(
        params,
        ({ data }) => {
          // console.log(data)
          commit('SET_HOUSE_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },

    getdetailHouse: ({ commit }, params) => {
      // const params = {
      //   memId,
      //   aptCode,
      // }
      // console.log(params)
      houseDetail(
        params,
        ({ data }) => {
          // console.log(data)
          commit('SET_DETAIL_HOUSE', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default houseStore
