<template>
  <CCard style="height: 880px">
    <h2 class="text-center mt-5">인기지역/매물</h2>
    <CCardBody>
      <CRow class="justify-content-around">
        <CCol class="chart"> <popular-area /> </CCol>
        <CCol class="chart"> <popular-house /></CCol>
      </CRow>
    </CCardBody>
  </CCard>
</template>

<script>
import PopularArea from '@/components/popular/PopularArea.vue'
import PopularHouse from '@/components/popular/PopularHouse.vue'
export default {
  name: 'PopularView',
  components: {
    PopularArea,
    PopularHouse,
  },
}
</script>

<style>
.chart {
  text-align: center;
}
</style>
