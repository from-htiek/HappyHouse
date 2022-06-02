<template>
  <CCard style="height: 880px">
    <h2 class="mt-5 text-center">매물 검색</h2>
    <CCardBody>
      <CRow class="search-bar">
        <CCol xs="8" class="search-bar-select mt-3">
          <house-search-select />
        </CCol>
        <CCol xs="4" class="search-bar-input mt-3">
          <house-search-input />
        </CCol>
      </CRow>
      <CRow class="justify-content-start map-content">
        <CCol xs="8" class="map">
          <house-map />
        </CCol>
        <CCol xs="4" class="search-result">
          <house-result />
        </CCol>
      </CRow>
    </CCardBody>
  </CCard>
</template>

<script>
import HouseSearchSelect from '@/components/house/HouseSearchSelect.vue'
import HouseSearchInput from '@/components/house/HouseSearchInput.vue'
import HouseResult from '@/components/house/HouseResult.vue'
import HouseMap from '@/components/house/HouseMap.vue'
// import { mapState } from 'vuex'
// const houseStore = 'houseStore'

export default {
  name: 'HouseView',
  components: {
    HouseSearchSelect,
    HouseSearchInput,
    HouseResult,
    HouseMap,
  },
}
</script>

<style scoped>
.search-bar {
  background-color: white;
  text-align: center;
}

.search-bar-select {
  width: 70%;
}

.search-bar-input {
  height: 50px;
  width: 30%;
  line-height: 50px;
  text-align: center;
  vertical-align: middle;
}

.map-content {
  height: 670px;
  /* background-color: antiquewhite; */
}

.map {
  /* height: 400px; */
  width: 70%;
  background-color: white;
  text-align: center;
}

.search-result {
  height: 640px;
  width: 30%;
  background-color: white;
  overflow: auto;
}
</style>
