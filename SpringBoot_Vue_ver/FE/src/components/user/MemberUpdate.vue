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
              <CFormInput type="text" id="inputPassword" v-model="user.memPw" />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userName" class="col-sm-1 col-form-label"
              >이름</CFormLabel
            >
            <CCol sm="5">
              <CFormInput type="text" id="userName" v-model="user.memName" />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userEmail" class="col-sm-1 col-form-label"
              >이메일</CFormLabel
            >
            <CCol sm="5">
              <CFormInput type="email" id="userEmail" v-model="user.memEmail" />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userTel" class="col-sm-1 col-form-label"
              >전화번호</CFormLabel
            >
            <CCol sm="5">
              <CFormInput type="text" id="userTel" v-model="user.memTel" />
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
                v-model="user.signupDate"
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
                  @click="updateMember"
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
                  @click="moveMyPage"
                  >취소</CButton
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
import { mapState, mapActions } from 'vuex'
import { getMember, modifyMember } from '@/api/member'

const memberStore = 'memberStore'

export default {
  name: 'MemberUpdate',
  data() {
    return {
      user: {
        memId: '',
        memPw: '',
        memName: '',
        memEmail: '',
        memTel: '',
        signupDate: '',
      },
    }
  },
  computed: {
    ...mapState(memberStore, ['userInfo']),
  },
  created() {
    getMember(
      this.userInfo.memId,
      ({ data }) => {
        this.user = data
      },
      (error) => {
        console.log(error)
      },
    )
  },
  methods: {
    ...mapActions(memberStore, ['updateUserInfo']),
    updateMember() {
      const user = {
        memId: this.user.memId,
        memPw: this.user.memPw,
        memName: this.user.memName,
        memEmail: this.user.memEmail,
        memTel: this.user.memTel,
        signupDate: this.user.signupDate,
      }

      modifyMember(
        user,
        ({ data }) => {
          let msg = '수정 처리 시 문제가 발생했습니다.'
          if (data === 'success') {
            msg = '수정이 완료되었습니다.'
          }
          alert(msg)

          this.moveMyPage()
        },
        (error) => {
          console.log(error)
        },
      )
      this.updateUserInfo(this.user)
    },
    moveMyPage() {
      this.$router.push({ name: 'myPage' })
    },
  },
}
</script>

<style scoped></style>
