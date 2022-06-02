import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function sidoList(success, fail) {
  api.get(`/map/sido`).then(success).catch(fail)
}
function gugunList(params, success, fail) {
  api.get(`/map/gugun`, { params: params }).then(success).catch(fail)
}

function dongList(params, success, fail) {
  api.get(`/map/dong`, { params: params }).then(success).catch(fail)
}

function houseListByDong(params, success, fail) {
  api.get(`/map/aptdong`, { params: params }).then(success).catch(fail)
}

function houseListbyName(params, success, fail) {
  api.get(`/map/aptName`, { params: params }).then(success).catch(fail)
}

function houseDetail(params, success, fail) {
  api.get(`/map/aptDetail`, { params: params }).then(success).catch(fail)
}
export {
  sidoList,
  gugunList,
  dongList,
  houseListByDong,
  houseListbyName,
  houseDetail,
}
