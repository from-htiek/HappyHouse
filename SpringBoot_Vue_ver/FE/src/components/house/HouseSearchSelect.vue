<template>
  <div class="gap-2 d-md-flex justify-content-md-center mt-2">
    <div class="select-wrap">
      <CFormSelect
        size="sm"
        class="w-100 mb-3 select-form"
        v-model="sidoCode"
        :options="sidos"
        @change="gugunList($event)"
      >
      </CFormSelect>
    </div>
    <div class="select-wrap">
      <CFormSelect
        size="sm"
        class="w-100 mb-3 select-form"
        v-model="gugunCode"
        :options="guguns"
        @change="dongList($event)"
      >
      </CFormSelect>
    </div>
    <div class="select-wrap">
      <CFormSelect
        size="sm"
        class="w-100 mb-3 select-form"
        v-model="dongCode"
        :options="dongs"
      >
      </CFormSelect>
      <!-- @change="searchApt($event)" -->
    </div>
    <CButton
      id="search"
      class="mb-3"
      color="info"
      size="sm"
      @click="searchApt(dongCode)"
      >검색</CButton
    >
    <CButton
      id="likedong"
      class="mb-3"
      color="secondary"
      size="sm"
      @click="likeRegion"
      >관심지역</CButton
    >
    <!-- <CButton color="dark" @click="searchApt(dongCode)">검색</CButton>
    </CCol>
    <CCol>
      <CButton
        shape="rounded-pill"
        style="background-color: rgb(255, 194, 0)"
        @click="likeRegion"
        >{{ likemsg }}</CButton
      >
    </CCol> -->
  </div>
  <!-- <CCol class="select-wrap align-items-center"> -->
  <!-- </CRow> -->
</template>

<script>
import { mapState, mapActions, mapMutations } from 'vuex'
import { likeArea } from '@/api/bookmark.js'

const houseStore = 'houseStore'
const memberStore = 'memberStore'
export default {
  name: 'HouseSearchSelect',
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      likemsg: '관심지역 등록',
      likearr: ['100', '200', '400'],
    }
  },

  computed: {
    ...mapState(houseStore, ['sidos', 'guguns', 'dongs']),
    ...mapState(memberStore, ['userInfo']),
  },

  created() {
    this.CLEAR_SIDO_LIST()
    this.getSido()
    // console.log(this.sidoCode)
  },
  methods: {
    ...mapActions(houseStore, [
      'getSido',
      'getGugun',
      'getDong',
      'getHouseListByDong',
    ]),
    ...mapMutations(houseStore, [
      'CLEAR_SIDO_LIST',
      'CLEAR_GUGUN_LIST',
      'CLEAR_DONG_LIST',
    ]),

    gugunList(e) {
      console.log(e.target.value)
      // await setTimeout(function () {}, 1)
      // console.log(this.sidoCode)
      this.CLEAR_GUGUN_LIST()
      this.gugunCode = null
      if (e.target.value) this.getGugun(e.target.value)
    },

    dongList(e) {
      // await setTimeout(function () {}, 1)
      // console.log(this.gugunCode)
      console.log(e.target.value)
      this.CLEAR_DONG_LIST()
      this.dongCode = null
      if (e.target.value) this.getDong(e.target.value)
    },

    searchApt(dong) {
      // console.log(this.dongCode)
      // if (e.target.value) this.getHouseListByDong(e.target.value)
      if (dong) this.getHouseListByDong(dong)
    },

    likeRegion() {
      const params = {
        memId: this.userInfo.memId,
        dongCode: this.dongCode,
      }
      likeArea(
        params,
        ({ data }) => {
          if (data === 'success') {
            // this.getHouseListByDong(this.dongCode)
            // this.likemsg = "관심등록 해제"
            alert('관심지역 등록!')
          }
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
}
</script>

<style scoped>
.select-wrap {
  /* line-height: 50px; */
  text-align: center;
  vertical-align: middle !important;
  /* display: ; */
}
.select-form {
  /* padding: ; */
  /* margin-top: 15px; */
  text-align: center;
  width: 70%;
}
#likedong {
  color: black;
  background-color: rgb(255, 194, 0);
  border: 0;
}
#search {
  color: white;
}
</style>
