<template>
  <h2 class="mt-5 mb-5 text-center">개발자 소개</h2>

  <CRow class="mt-5">
    <CCol :xs="4">
      <CCard class="mb-4">
        <CCardBody class="mt-5 mb-5">
          <div id="box">
            <img class="profile" src="@/assets/images/khy.jpg" />
          </div>
          <h2 class="mt-5 mb-1 text-center">김현용</h2>
          <h5 class="text-center">HYEONYONG KIM</h5>
          <div class="text-center">SSAFY 7기</div>
          <div class="mb-5 text-center">구미 4반</div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'envelope']" />
            gusdyd1432@naver.com
          </div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'code-branch']" /> Light-HD
          </div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'mobile-screen']" /> 010-8668-4767
          </div>
        </CCardBody>
      </CCard>
    </CCol>
    <CCol :xs="4">
      <CCard class="mb-4">
        <CCardBody class="mt-5 mb-5">
          <div id="box">
            <img class="profile" src="@/assets/images/psh.jpg" />
          </div>
          <h2 class="mt-5 mb-1 text-center">박신혜</h2>
          <h5 class="text-center">SINHYE PARK</h5>
          <div class="text-center">SSAFY 7기</div>
          <div class="mb-5 text-center">구미 4반</div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'envelope']" /> sinb6961@naver.com
          </div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'code-branch']" /> psh0420
          </div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'mobile-screen']" /> 010-3268-3434
          </div>
        </CCardBody>
      </CCard>
    </CCol>
    <CCol :xs="4">
      <CCard class="mb-4">
        <CCardBody class="mt-5 mb-5">
          <div id="box">
            <img class="profile" src="@/assets/images/pcr.jpg" />
          </div>
          <h2 class="mt-5 mb-1 text-center">박채림</h2>
          <h5 class="text-center">CHAERIM PARK</h5>
          <div class="text-center">SSAFY 7기</div>
          <div class="mb-5 text-center">구미 4반</div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'envelope']" />
            from.htiek@gmail.com
          </div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'code-branch']" /> from.htiek
          </div>
          <div class="text-center">
            <font-awesome-icon :icon="['fas', 'mobile-screen']" /> 010-2606-3505
          </div>
        </CCardBody>
      </CCard>
    </CCol>
  </CRow>
</template>

<script>
export default {
  name: 'Contact',
  components: {},
}
</script>

<style scoped>
#box {
  width: 150px;
  height: 150px;
  border-radius: 70%;
  overflow: hidden;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
}
.profile {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
