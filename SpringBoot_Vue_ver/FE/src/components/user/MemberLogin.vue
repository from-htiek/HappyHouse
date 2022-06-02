<template>
  <CCol :xs="12">
    <CCard class="mb-4">
      <CCardBody class="mt-5 mb-5">
        <h2 class="mb-5 text-center">로그인</h2>

        <!-- <CCardText> </CCardText> -->
        <CForm>
          <!-- <CAlert color="danger" v-if="isLoginError"
            >아이디 또는 비밀번호를 확인하세요.</CAlert
          > -->
          <CRow class="mb-3 ml-5">
            <CCol sm="3"></CCol>
            <CFormLabel for="userid" class="col-sm-1 col-form-label"
              >아이디</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="text"
                id="userid"
                v-model="user.memId"
                required
                placeholder="아이디를 입력하세요."
                @keyup.enter="confirm"
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mb-3">
            <CCol sm="3"></CCol>
            <CFormLabel for="userpwd" class="col-sm-1 col-form-label"
              >비밀번호</CFormLabel
            >
            <CCol sm="5">
              <CFormInput
                type="password"
                id="userpwd"
                required
                v-model="user.memPw"
                placeholder="비밀번호를 입력하세요."
                @keyup.enter="confirm"
              />
            </CCol>
            <CCol sm="3"></CCol>
          </CRow>

          <CRow class="mt-5">
            <CCol sm="4"></CCol>
            <CCol sm="2">
              <div class="d-grid gap-2">
                <CButton
                  type="submit"
                  color="dark"
                  variant="outline"
                  shape="rounded-pill"
                  @click="confirm"
                  >로그인</CButton
                >
              </div>
            </CCol>
            <CCol sm="2">
              <div class="d-grid gap-2">
                <CButton
                  color="dark"
                  variant="outline"
                  shape="rounded-pill"
                  @click="movePage"
                  >회원가입</CButton
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

const memberStore = 'memberStore'

export default {
  name: 'MemberLogin',
  data() {
    return {
      user: {
        memId: null,
        memPw: null,
      },
    }
  },
  computed: {
    ...mapState(memberStore, ['isLogin', 'isLoginError']),
  },
  methods: {
    ...mapActions(memberStore, ['userConfirm', 'getUserInfo']),
    async confirm() {
      await this.userConfirm(this.user)
      let token = sessionStorage.getItem('access-token')
      if (this.isLogin) {
        await this.getUserInfo(token)
        this.$router.push({ name: 'Dashboard' })
      }
    },
    movePage() {
      this.$router.push({ name: 'signUp' })
    },
  },
}
</script>

<style></style>
