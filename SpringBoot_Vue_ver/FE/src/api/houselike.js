import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function getList(id, success, fail) {
  api.get(`/houselike/list/${id}`).then(success).catch(fail)
}

export { getList }
