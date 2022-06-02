<template>
  <CCard style="height: 880px">
    <h2 class="text-center mt-5">MY 관심지역</h2>
    <CCardBody>
      <like-area-card />
    </CCardBody>
  </CCard>
</template>

<script>
import LikeAreaCard from '@/components/likearea/LikeAreaCard.vue'
export default {
  name: 'LikeAreaView',
  components: {
    LikeAreaCard,
  },
}
</script>

<style></style>
