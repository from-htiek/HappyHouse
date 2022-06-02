<template>
  <CCol :xs="12">
    <CCard class="mb-4">
      <CCardBody class="mt-5 mb-5">
        <h2 class="mb-5 text-center">회원가입</h2>

        <CCardText> </CCardText>
        <CForm @submit.prevent="submitForm">
          <CRow class="mb-3 ml-5">
            <CCol sm="3"></CCol>
            <CFormLabel for="memId" class="col-sm-1 col-form-label"
              >아이디</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="memId"
                v-model="memId"
                placeholder="아이디를 입력하세요."
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="memPw" class="col-sm-1 col-form-label"
              >비밀번호</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="password"
                id="memPw"
                v-model="memPw"
                placeholder="비밀번호를 입력하세요."
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="memName" class="col-sm-1 col-form-label"
              >이름</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="memName"
                v-model="memName"
                placeholder="이름을 입력하세요."
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="memEmail" class="col-sm-1 col-form-label"
              >이메일</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="email"
                id="memEmail"
                v-model="memEmail"
                placeholder="이메일을 입력하세요."
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="memTel" class="col-sm-1 col-form-label"
              >전화번호</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="memTel"
                v-model="memTel"
                placeholder="전화번호를 입력하세요."
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mt-5">
            <CCol sm="5"></CCol>
            <CCol sm="2">
              <div class="d-grid gap-2">
                <CButton
                  type="submit"
                  color="dark"
                  variant="outline"
                  shape="rounded-pill"
                  >회원가입</CButton
                >
              </div>
            </CCol>
            <CCol sm="5"></CCol>
          </CRow>
        </CForm>
      </CCardBody>
    </CCard>
  </CCol>
</template>

<script>
import { registMember } from '@/api/member'
export default {
  name: 'MemberRegister',
  data() {
    return {
      memId: '',
      memPw: '',
      memName: '',
      memEmail: '',
      memTel: '',
    }
  },

  methods: {
    submitForm() {
      console.log('회원가입 버튼 누름')
      const user = {
        memId: this.memId,
        memPw: this.memPw,
        memName: this.memName,
        memEmail: this.memEmail,
        memTel: this.memTel,
      }
      registMember(
        user,
        ({ data }) => {
          let msg = '등록에 실패하셨습니다.'
          if (data === 'success') {
            msg = '등록이 완료되었습니다.'

            alert(msg)
            this.$router.push({ name: 'signIn' })
          } else {
            alert(msg)
          }
        },
        (error) => {
          console.log(error)
        },
      )

      //console.log(user)
      //this.$store.dispatch('registMember', user)
    },
  },
}
</script>

<style></style>
