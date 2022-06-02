<template>
  <CCol :xs="12">
    <CCard class="mb-4">
      <CCardBody class="mt-5 mb-5">
        <h2 class="mb-5 text-center">My Page</h2>
        <CCardText> </CCardText>
        <CForm>
          <CRow class="mb-3 ml-5">
            <CCol sm="3"></CCol>
            <CFormLabel for="inputId" class="col-sm-1 col-form-label"
              >아이디</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="inputId"
                v-model="userInfo.memId"
                readonly
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="inputPassword" class="col-sm-1 col-form-label"
              >비밀번호</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="password"
                id="inputPassword"
                v-model="userInfo.memPw"
                readonly
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userName" class="col-sm-1 col-form-label"
              >이름</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="userName"
                v-model="userInfo.memName"
                readonly
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userEmail" class="col-sm-1 col-form-label"
              >이메일</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="email"
                id="userEmail"
                v-model="userInfo.memEmail"
                readonly
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userTel" class="col-sm-1 col-form-label"
              >전화번호</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="userTel"
                v-model="userInfo.memTel"
                readonly
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="signUpDate" class="col-sm-1 col-form-label"
              >가입일</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="signUpDate"
                v-model="userInfo.signupDate"
                readonly
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mt-5">
            <CCol sm="4"></CCol>
            <CCol sm="2">
              <div class="d-grid gap-2">
                <CButton
                  color="dark"
                  variant="outline"
                  shape="rounded-pill"
                  @click="moveUpdate"
                  >정보수정</CButton
                >
              </div>
            </CCol>
            <CCol sm="2">
              <div class="d-grid gap-2">
                <CButton
                  color="dark"
                  variant="outline"
                  shape="rounded-pill"
                  @click="deleteMember"
                  >회원탈퇴</CButton
                >
              </div>
            </CCol>
            <CCol sm="4"></CCol>
          </CRow>
        </CForm>
      </CCardBody>
    </CCard>
  </CCol>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex'
// import { deleteMember } from '@/api/member'

const memberStore = 'memberStore'

export default {
  name: 'MemberMyPage',
  components: {},
  computed: {
    ...mapState(memberStore, ['userInfo']),
  },
  methods: {
    ...mapMutations(memberStore, ['SET_IS_LOGIN', 'SET_USER_INFO']),
    ...mapActions(memberStore, ['deleteUser']),
    moveUpdate() {
      this.$router.replace({
        name: 'update',
        params: {
          memId: this.userInfo.memId,
        },
      })
    },
    deleteMember() {
      if (confirm('정말 탈퇴하시겠습니까?')) {
        this.deleteUser(this.userInfo.memId)
        // deleteMember(
        //   this.userInfo.memId,
        //   ({ data }) => {
        //     console.log(data)
        //     this.SET_IS_LOGIN(false)
        //     this.SET_USER_INFO(null)
        //     sessionStorage.removeItem('access-token')
        //     alert('탈퇴가 완료되었습니다.')
        //     this.$router.push({ name: 'signIn' })
        //   },
        //   (error) => {
        //     console.log(error)
        //   },
        // )
        this.$router.push({ name: 'signIn' })
      }
    },
  },
}
</script>

<style></style>
