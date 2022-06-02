import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function getList(id, success, fail) {
  api.get(`/houselike/list/${id}`).then(success).catch(fail)
}

function likeHouse(params, success, fail) {
  api
    .post(`/houselike/insert`, JSON.stringify(params))
    .then(success)
    .catch(fail)
}

function dislikeHouse(no, success, fail) {
  api.delete(`/houselike/delete/${no}`).then(success).catch(fail)
}

function likeArea(params, success, fail) {
  api.post(`/arealike/insert`, JSON.stringify(params)).then(success).catch(fail)
}

function likeAreaList(memId, success, fail) {
  api.get(`/arealike/${memId}`).then(success).catch(fail)
}

export { getList, likeHouse, dislikeHouse, likeArea, likeAreaList }
