import jwt_decode from 'jwt-decode'
import { login, findById, deleteMember } from '@/api/member.js'

const memberStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: {},
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true
      state.userInfo = userInfo
    },
    UPDATE_USER_INFO: (state, user) => {
      console.log(user)
      state.userInfo = user
    },
  },
  actions: {
    // async registMember({ commit }, user) {
    //   await registMember(
    //     user,
    //     ({ data }) => {
    //       if (response.data.message === 'success') {
    //         commit('REGIST_USER', user)
    //         console.log('회원가입 완료')
    //         alert('회원가입이 완료되었습니다.')
    //         this.$router.push({ name: signIn })
    //       }
    //     },
    //     (error) => {
    //       console.log(error)
    //     },
    //   )
    // },
    async userConfirm({ commit }, user) {
      await login(
        user,
        (response) => {
          if (response.data.message === 'success') {
            let token = response.data['access-token']
            commit('SET_IS_LOGIN', true)
            commit('SET_IS_LOGIN_ERROR', false)
            sessionStorage.setItem('access-token', token)
          } else {
            alert('로그인이 실패했습니다')
            commit('SET_IS_LOGIN', false)
            commit('SET_IS_LOGIN_ERROR', true)
          }
        },
        () => {},
      )
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token)
      findById(
        decode_token.memId,
        (response) => {
          if (response.data.message === 'success') {
            console.log(response.data.userInfo)
            commit('SET_USER_INFO', response.data.userInfo)
            alert('로그인 성공')
          } else {
            console.log('유저 정보 없음!!')
          }
        },
        (error) => {
          console.log(error)
        },
      )
    },

    updateUserInfo({ commit }, user) {
      commit('UPDATE_USER_INFO', user)
    },

    deleteUser({ commit }, userId) {
      deleteMember(
        userId,
        ({ data }) => {
          console.log(data)
          commit('SET_IS_LOGIN', false)
          commit('SET_USER_INFO', null)
          sessionStorage.removeItem('access-token')
          alert('탈퇴가 완료되었습니다.')
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default memberStore
