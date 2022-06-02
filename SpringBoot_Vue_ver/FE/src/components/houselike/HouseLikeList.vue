<template>
  <CAccordion flush v-if="houses && houses.length != 0">
    <div class="mt-1"></div>
    <CAccordionItem
      v-for="(house, index) in houses"
      :key="index"
      :house="house"
    >
      <CAccordionHeader @click="viewHouse(house.aptCode, house)">
        {{ house.aptName }}
      </CAccordionHeader>
      <house-detail />
    </CAccordionItem>
  </CAccordion>
  <div v-else>관심 매물이 없습니다.</div>
</template>

<script>
import HouseDetail from '@/components/house/HouseDetail.vue'
import { mapState, mapActions } from 'vuex'

const houseStore = 'houseStore'
const houseLikeStore = 'houseLikeStore'
const memberStore = 'memberStore'
export default {
  name: 'HouseLikeList',
  data() {
    return {}
  },
  components: {
    HouseDetail,
  },
  computed: {
    ...mapState(houseLikeStore, ['houses']),
    ...mapState(memberStore, ['userInfo']),
  },
  methods: {
    ...mapActions(houseStore, ['getdetailHouse']),
    ...mapActions(houseLikeStore, ['getHouselikeList', 'getHouseLike']),
    viewHouse(code, house) {
      // this.code = this.house.aptCode
      // // console.log(this.code)
      console.log(code)

      const params = {
        memId: this.userInfo.memId,
        aptCode: code,
      }
      const latlng = {
        lat: house.lat,
        lng: house.lng,
      }
      // 선택한 매물을 좌표를 house에 저장
      this.getHouseLike(latlng)
      this.getdetailHouse(params)
    },
  },
  created() {
    this.getHouselikeList(this.userInfo.memId)
  },
}
</script>

<style scoped></style>
