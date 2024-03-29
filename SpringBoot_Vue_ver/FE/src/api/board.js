import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function listArticle(success, fail) {
  api.get(`/board`).then(success).catch(fail)
}

function writeArticle(article, success, fail) {
  api.post(`/board`, JSON.stringify(article)).then(success).catch(fail)
}

function getArticle(no, success, fail) {
  api.get(`/board/${no}`).then(success).catch(fail)
}

function modifyArticle(article, success, fail) {
  api
    .put(`/board/${article.no}`, JSON.stringify(article))
    .then(success)
    .catch(fail)
}

function deleteArticle(no, success, fail) {
  api.delete(`/board/${no}`).then(success).catch(fail)
}

export { listArticle, writeArticle, getArticle, modifyArticle, deleteArticle }
