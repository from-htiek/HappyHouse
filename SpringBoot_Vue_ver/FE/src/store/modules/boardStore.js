// import Vuex from 'vuex'
// import router from '@/router'
import { listArticle } from '@/api/board.js'

const boardStore = {
  namespaced: true,
  state: {
    articles: [],
    article: {},
  },
  getters: {},
  mutations: {
    GET_ARTICLE_LIST: function (state, articles) {
      state.articles = articles
    },
  },
  actions: {
    getArticleList: ({ commit }) => {
      listArticle(
        ({ data }) => {
          commit('GET_ARTICLE_LIST', data)
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}

export default boardStore

// export default new Vuex.Store({
//   state: {
// articles: [],
// article: {},
//   },
//   getters: {},
//   mutations: {
// GET_ARTICLE_LIST: function (state, articles) {
//   state.articles = articles
// },

// WRITE_ARTICLE: function (state, article) {
//   state.articles.push(article)
// },

// GET_DETAIL_ARTICLE: function (state, article) {
//   //console.log(article);
//   state.article = article
// },

// MODIFY_ARTICLE: function (state, article) {
//   console.log(article)
//   state.article = article
// },

// DELETE_ARTICLE: function (state, no) {
//   //console.log(article);
//   state.articles.pop(no)
// },
//   },

//   actions: {
//     getArticleList({ commit }) {
//       http
//         .get()
//         .then(({ data }) => {
//           //this.articles = data;
//           commit('GET_ARTICLE_LIST', data)
//         })
//         .catch((err) => {
//           console.log(err)
//         })
//     },

// writeArticle({ commit }, article) {
//   http
//     .post(`/`, article)
//     .then(() => {
//       // console.log(article);
//       commit('WRITE_ARTICLE', article)
//       alert('등록이 완료되었습니다.')
//       router.push('/')
//     })
//     .catch((err) => {
//       alert('catch')
//       console.log(err)
//     })
// },

// detailArticle({ commit }, no) {
//   http
//     .get('/' + no)
//     .then(({ data }) => {
//       commit('GET_DETAIL_ARTICLE', data)
//     })
//     .catch((err) => {
//       console.log(err)
//     })
// },

//     // modifyArticle({ commit }, article) {
//     //   console.log(article.no)
//     //   http
//     //     .put('/' + article.no, article)
//     //     .then(() => {
//     //       commit('MODIFY_ARTICLE', article)
//     //       alert('수정이 완료되었습니다.')
//     //       router.push('/detail/' + article.no)
//     //     })
//     //     .catch((err) => {
//     //       alert('error')
//     //       console.log(err)
//     //     })
//     // },

//     // answerArticle({ commit }, article) {
//     //   console.log(article.no)
//     //   http
//     //     .put('/answer/' + article.no, article)
//     //     .then(() => {
//     //       commit('MODIFY_ARTICLE', article)
//     //       alert('수정이 완료되었습니다.')
//     //       router.push('/detail/' + article.no)
//     //     })
//     //     .catch((err) => {
//     //       alert('error')
//     //       console.log(err)
//     //     })
//     // },

//     // deleteArticle({ commit }, no) {
//     //   http
//     //     .delete('/' + no)
//     //     .then(() => {
//     //       commit('DELETE_ARTICLE', no)
//     //       alert('삭제가 완료되었습니다.')
//     //       router.push('/')
//     //     })
//     //     .catch((err) => {
//     //       alert('error')
//     //       console.log(err)
//     //     })
//     // },
//   },
// })
