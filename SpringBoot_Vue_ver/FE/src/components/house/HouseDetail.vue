<template>
  <CAccordionBody v-if="house[0]">
    <img src="@/assets/images/apt.png" alt="" />
    <div class="mt-3"></div>
    <h4 style="display: inline-block; font-weight: bold">
      {{ house[0].aptName }}
    </h4>
    <span
      v-if="house[0].houseLikeno != -1"
      style="float: right; margin-right: 1px"
      @click="dislikeApt"
      ><font-awesome-icon :icon="['fas', 'heart']" style="color: red" size="2x"
    /></span>
    <span v-else style="float: right; margin-right: 1px" @click="likeApt"
      ><font-awesome-icon :icon="['far', 'heart']" size="2x"
    /></span>
    <div></div>
    <span> {{ house[0].dongName }} | </span>
    <span>{{ house[0].buildYear }}년 입주</span>
    <hr />
    <h6>최근 거래가</h6>
    <CTable small>
      <CTableHead>
        <CTableRow>
          <CTableDataCell scope="col">계약일</CTableDataCell>
          <CTableDataCell scope="col">거래가격</CTableDataCell>
          <CTableDataCell scope="col">면적</CTableDataCell>
          <CTableDataCell scope="col">층수</CTableDataCell>
        </CTableRow>
      </CTableHead>
      <CTableBody>
        <CTableRow v-for="(item, index) in house" :key="index">
          <CTableDataCell>{{ item.dealDate }}</CTableDataCell>
          <CTableDataCell>{{ item.dealAmount }}</CTableDataCell>
          <CTableDataCell>{{ item.area }}</CTableDataCell>
          <CTableDataCell>{{ item.floor }}</CTableDataCell>
        </CTableRow>
      </CTableBody>
    </CTable>
    <div v-if="house.length > 1">
      <hr />
      <h6>거래 추이</h6>
      <CChartLine :data="defaultData" />
    </div>
  </CAccordionBody>
  <!-- <div v-else>주택 목록이 없습니다.</div> -->
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { CChartLine } from '@coreui/vue-chartjs'
import { likeHouse, dislikeHouse } from '@/api/bookmark.js'

const houseStore = 'houseStore'
const memberStore = 'memberStore'

export default {
  name: 'HouseDetail',
  data() {
    return {
      chartLabel: [],
      chartData: [],
    }
  },
  components: {
    CChartLine,
  },
  computed: {
    ...mapState(houseStore, ['house']),
    ...mapState(memberStore, ['userInfo']),
    defaultData() {
      return {
        labels: this.chartLabel,
        datasets: [
          {
            label: '거래 가격',
            backgroundColor: '#f87979',
            borderColor: '#f87979',
            pointBackgroundColor: '#f87979',
            pointBorderColor: '#fff',
            data: this.chartData,
          },
        ],
      }
    },
  },

  watch: {
    house: function () {
      this.chartLabel = []
      this.chartData = []
      this.house.forEach((item) => {
        this.chartLabel.push(item.dealDate)
        this.chartData.push(parseInt(item.dealAmount))
      })
      // console.log('chart', this.chartLabel)
      // console.log(this.chartData)
    },
  },

  methods: {
    ...mapActions(houseStore, ['getdetailHouse']),
    likeApt() {
      const params = {
        memId: this.userInfo.memId,
        aptCode: this.house[0].aptCode,
      }
      likeHouse(
        params,
        ({ data }) => {
          if (data === 'success') {
            this.getdetailHouse(params)
            alert('좋아요 등록!')
          }
        },
        (error) => {
          console.log(error)
        },
      )
    },
    dislikeApt() {
      const params = {
        memId: this.userInfo.memId,
        aptCode: this.house[0].aptCode,
      }
      console.log(this.house[0].houseLikeno)
      dislikeHouse(
        this.house[0].houseLikeno,
        () => {
          this.getdetailHouse(params)
          alert('좋아요 해제!')
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
img {
  width: 100%;
}
.active {
  color: red;
}
</style>
