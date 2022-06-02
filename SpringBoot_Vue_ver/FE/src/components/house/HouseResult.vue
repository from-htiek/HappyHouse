<template>
  <CAccordion flush v-if="houses && houses.length != 0">
    <div class="mt-1"></div>
    <CAccordionItem
      v-for="(house, index) in houses"
      :key="index"
      :house="house"
    >
      <CAccordionHeader @click="viewHouse(house.aptCode)">
        {{ house.aptName }}
      </CAccordionHeader>
      <house-detail />
    </CAccordionItem>
  </CAccordion>
  <div v-else class="mt-3 text-center">매물을 검색해보세요!</div>
</template>

<script>
import HouseDetail from '@/components/house/HouseDetail.vue'
import { mapState, mapActions } from 'vuex'
const houseStore = 'houseStore'
const memberStore = 'memberStore'
export default {
  name: 'HouseResult',
  data() {
    return {}
  },
  components: {
    HouseDetail,
  },
  computed: {
    ...mapState(houseStore, ['houses']),
    ...mapState(memberStore, ['userInfo']),
  },
  methods: {
    ...mapActions(houseStore, ['getdetailHouse']),
    viewHouse(code) {
      // console.log(code)
      // console.log(this.userInfo.memId)
      const params = {
        memId: this.userInfo.memId,
        aptCode: code,
      }
      this.getdetailHouse(params)
    },
  },
}
</script>

<style scoped></style>
