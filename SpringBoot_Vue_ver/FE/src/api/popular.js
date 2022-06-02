import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function areaList(success, fail) {
  api.get(`/popular/area`).then(success).catch(fail)
}

function houseList(success, fail) {
  api.get(`/popular/house`).then(success).catch(fail)
}

export { areaList, houseList }
