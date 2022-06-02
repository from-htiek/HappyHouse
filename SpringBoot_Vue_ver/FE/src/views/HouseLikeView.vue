<template>
  <CCard style="height: 880px">
    <h2 class="mt-5 text-center">MY 관심매물</h2>
    <CCardBody class="mt-5 mb-5">
      <CRow>
        <CCol xs="8" class="map">
          <house-like-map />
        </CCol>
        <CCol xs="4" class="list">
          <house-like-list />
        </CCol>
      </CRow>
    </CCardBody>
  </CCard>
</template>

<script>
import HouseLikeMap from '@/components/houselike/HouseLikeMap.vue'
import HouseLikeList from '@/components/houselike/HouseLikeList.vue'

export default {
  name: 'HouseLikeView',
  components: {
    HouseLikeMap,
    HouseLikeList,
  },
}
</script>

<style scoped>
.list {
  height: 640px;
  overflow: auto;
}
/* .map {
  height: 550px;
  width: 70%;
}
.list {
  height: 550px;
  width: 30%;
  overflow: auto;
} */
</style>
