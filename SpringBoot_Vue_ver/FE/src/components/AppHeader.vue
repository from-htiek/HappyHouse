<template>
  <CHeader position="sticky" class="mb-4">
    <CContainer fluid>
      <CHeaderToggler class="ps-1">
        <CIcon icon="cil-menu" size="lg" />
      </CHeaderToggler>
      <!-- <CHeaderBrand class="mx-auto d-lg-none" to="/">
        <CIcon :icon="logo" height="48" alt="Logo" />
      </CHeaderBrand> -->
      <!-- <CHeaderNav class="mx-auto d-lg-flex">
        <CNavItem>
          <CNavLink href="#">Happy House</CNavLink>
        </CNavItem>
      </CHeaderNav> -->

      <CHeaderNav v-if="userInfo">
        <CNavItem>
          <CNavLink active> {{ userInfo.memId }}님 환영합니다. </CNavLink>
        </CNavItem>

        <CNavItem>
          <CNavLink>
            <router-link :to="{ name: 'myPage' }">
              <CIcon class="mx-2" icon="cil-user" size="sm" />내정보보기
            </router-link>
          </CNavLink>
        </CNavItem>

        <CNavItem>
          <CButton @click="onClickLogout">
            <CIcon class="mx-2" icon="cil-account-logout" size="sm" />로그아웃
          </CButton>
        </CNavItem>
      </CHeaderNav>

      <CHeaderNav v-else>
        <CNavItem>
          <CNavLink>
            <router-link :to="{ name: 'signIn' }">
              <CIcon class="mx-2" icon="cil-lock-locked" size="md" />로그인
            </router-link>
          </CNavLink>
          <!-- <CNavLink href="#">
            <CIcon class="mx-2" icon="cil-user" size="mg" />로그인
          </CNavLink> -->
        </CNavItem>
        <!-- <AppHeaderDropdownAccnt /> -->
      </CHeaderNav>
    </CContainer>
  </CHeader>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
const memberStore = 'memberStore'

//import AppHeaderDropdownAccnt from './AppHeaderDropdownAccnt'
// import { logo } from '@/assets/brand/logo'
export default {
  name: 'AppHeader',
  computed: {
    ...mapState(memberStore, ['isLogin', 'userInfo']),
  },
  // components: {
  //   AppHeaderDropdownAccnt,
  // },
  // setup() {
  //   return {
  //     logo,
  //   }
  // },
  methods: {
    ...mapMutations(memberStore, ['SET_IS_LOGIN', 'SET_USER_INFO']),
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false)
      this.SET_USER_INFO(null)
      sessionStorage.removeItem('access-token')
      if (this.$route.path != '/') this.$router.push({ name: 'Dashboard' })
    },
  },
}
</script>

<style scoped>
a {
  text-decoration: none;
  color: rgb(55, 66, 83);
}
</style>
