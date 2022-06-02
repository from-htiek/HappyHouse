import { apiInstance } from '@/api/index.js'

const api = apiInstance()

function registMember(user, success, fail) {
  api.post(`member/regist`, JSON.stringify(user)).then(success).catch(fail)
}

async function login(user, success, fail) {
  await api
    .post(`/member/login`, JSON.stringify(user))
    .then(success)
    .catch(fail)
}

async function findById(userid, success, fail) {
  api.defaults.headers['access-token'] = sessionStorage.getItem('access-token')
  await api.get(`/member/info/${userid}`).then(success).catch(fail)
}

function getMember(userid, success, fail) {
  api.get(`/member/memberinfo/${userid}`).then(success).catch(fail)
}

function modifyMember(user, success, fail) {
  api.put(`/member/update`, JSON.stringify(user)).then(success).catch(fail)
}

function deleteMember(userid, success, fail) {
  api.delete(`/member/delete/${userid}`).then(success).catch(fail)
}

//function logout(success, fail)

export { registMember, login, findById, getMember, modifyMember, deleteMember }
