import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function listComment(memboardId, success, fail) {
  api.get(`/comment/${memboardId}`).then(success).catch(fail)
}

function writeComment(comment, success, fail) {
  api.post(`/comment`, JSON.stringify(comment)).then(success).catch(fail)
}

function getComment(no, success, fail) {
  api.get(`/comment/modify/${no}`).then(success).catch(fail)
}

function modifyComment(comment, success, fail) {
  api
    .put(`/comment/${comment.no}`, JSON.stringify(comment))
    .then(success)
    .catch(fail)
}

function deleteComment(no, success, fail) {
  api.delete(`/comment/${no}`).then(success).catch(fail)
}

export { listComment, writeComment, getComment, modifyComment, deleteComment }
