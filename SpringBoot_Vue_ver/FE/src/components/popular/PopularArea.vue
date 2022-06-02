<template>
  <div v-if="pAreas.length > 0" class="text-center m-3 p-5">
    <CChartDoughnut :data="defaultData" />

    <div class="mt-4">지금 가장 인기 있는 지역은</div>
    <span
      style="background: linear-gradient(to top, #faf0d7 50%, transparent 50%)"
      >{{ pAreas[0].sidoName }} {{ pAreas[0].gugunName }}
      {{ pAreas[0].dongName }}</span
    ><span>입니다.</span>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import { CChartDoughnut } from '@coreui/vue-chartjs'

const popularStore = 'popularStore'

export default {
  name: 'PopularArea',
  components: { CChartDoughnut },
  data() {
    return {
      chartLabel: [],
      chartData: [],
    }
  },
  computed: {
    ...mapState(popularStore, ['pAreas']),
    defaultData() {
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
    ...mapActions(popularStore, ['getArea']),
  },

  created() {
    this.getArea()
  },

  watch: {
    pAreas: function () {
      this.chartLabel = []
      this.chartData = []

      this.pAreas.forEach((item) => {
        const area = item.gugunName.concat(' ').concat(item.dongName)
        this.chartLabel.push(area)
        // this.chartLabel.push(item.dongName)
        this.chartData.push(item.cnt)
      })

      console.log(this.chartLabel)
      console.log(this.chartData)
    },
  },
}
</script>

<style></style>
