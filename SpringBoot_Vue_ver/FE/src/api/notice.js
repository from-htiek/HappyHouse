import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function listNotice(success, fail) {
  api.get(`/notice`).then(success).catch(fail)
}

function writeNotice(notice, success, fail) {
  api.post(`/notice`, JSON.stringify(notice)).then(success).catch(fail)
}

function getNotice(no, success, fail) {
  api.get(`/notice/${no}`).then(success).catch(fail)
}

function modifyNotice(notice, success, fail) {
  api
    .put(`/notice/${notice.no}`, JSON.stringify(notice))
    .then(success)
    .catch(fail)
}

function deleteNotice(no, success, fail) {
  api.delete(`/notice/${no}`).then(success).catch(fail)
}

export { listNotice, writeNotice, getNotice, modifyNotice, deleteNotice }
