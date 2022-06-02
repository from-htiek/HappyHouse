<template>
  <div class="m-5 pr-5 pl-5 pb-5 pt-2">
    <CRow v-if="likeAreas" :xs="{ cols: 1, gutter: 4 }" :md="{ cols: 3 }">
      <CCol xs v-for="(area, index) in likeAreas" :key="index">
        <CCard class="h-100 border-dark ml-1 mr-1">
          <CCardHeader
            ><font-awesome-icon
              :icon="['fas', 'star']"
              style="color: rgb(255, 194, 0)"
              size="2x"
          /></CCardHeader>
          <CCardBody>
            <CCardTitle class="cardtitle" style="text-center"
              >{{ area.sidoName }} {{ area.gugunName }}
              {{ area.dongName }}</CCardTitle
            >
            <!-- <CCardText
              >This is a wider card with supporting text below as a natural
              lead-in to additional content. This content is a little bit
              longer.</CCardText
            > -->
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  </div>
  <!-- <CCard
    v-for="(area, index) in likeAreas"
    :key="index"
    class="mb-3 border-dark"
    style="max-width: 18rem"
  >
    <CCardHeader>Header</CCardHeader>
    <CCardBody>
      <CCardTitle>card title</CCardTitle>
      <CCardText></CCardText>
    </CCardBody>
  </CCard> -->
</template>

<script>
import { mapState, mapActions } from 'vuex'

const memberStore = 'memberStore'
const bookmarkStore = 'bookmarkStore'
export default {
  name: 'LikeAreaList',
  data() {
    return {}
  },
  computed: {
    ...mapState(memberStore, ['userInfo']),
    ...mapState(bookmarkStore, ['likeAreas']),
  },
  methods: {
    ...mapActions(bookmarkStore, ['getLikeArea']),
  },
  created() {
    console.log(this.userInfo.memId)
    this.getLikeArea(this.userInfo.memId)
  },
}
</script>

<style scoped>
.cardtitle {
  text-align: center !important;
}
</style>
