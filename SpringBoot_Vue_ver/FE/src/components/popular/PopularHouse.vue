<template>
  <div v-if="pHouses.length > 0" class="text-center m-3 p-5">
    <CChartDoughnut :data="defaultData2" />
    <div class="mt-4">지금 가장 인기 있는 매물은</div>
    <span
      style="background: linear-gradient(to top, #faf0d7 50%, transparent 50%)"
      >{{ pHouses[0].aptName }}</span
    ><span>입니다.</span>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { CChartDoughnut } from '@coreui/vue-chartjs'

const popularStore = 'popularStore'

export default {
  name: 'PopularHouse',
  components: { CChartDoughnut },
  data() {
    return {
      chartLabel: [],
      chartData: [],
    }
  },
  computed: {
    ...mapState(popularStore, ['pHouses']),
    defaultData2() {
      return {
        labels: this.chartLabel,
        datasets: [
          {
            backgroundColor: [
              '#F4BFBF',
              '#FFD9C0',
              '#FAF0D7',
              '#8CC0DE',
              '#F47C7C',
              '#F4BFBF',
              '#FFD9C0',
              '#FAF0D7',
              '#8CC0DE',
              '#F47C7C',
            ],
            data: this.chartData,
          },
        ],
      }
    },
  },
  methods: {
    ...mapActions(popularStore, ['getHouse']),
  },

  created() {
    this.getHouse()
  },

  watch: {
    pHouses: function () {
      this.chartLabel = []
      this.chartData = []

      this.pHouses.forEach((item) => {
        // const area = item.sidoName
        //   .concat(' ')
        //   .concat(item.gugunName)
        //   .concat(' ')
        //   .concat(item.dongName)
        // this.chartLabel.push(area)
        this.chartLabel.push(item.aptName)
        this.chartData.push(item.cnt)
      })

      console.log(this.chartLabel)
      console.log(this.chartData)
    },
  },
}
</script>

<style></style>
