<template>
  <div class="mt-2">
    <CFormInput
      type="text"
      size="sm"
      placeholder="아파트 이름 입력"
      v-model="aptName"
      @keyup.enter="onSubmit"
    />
  </div>
</template>

<script>
import { mapActions } from 'vuex'
const houseStore = 'houseStore'

export default {
  name: 'HouseSearchInput',
  data() {
    return {
      aptName: null,
    }
  },
  methods: {
    ...mapActions(houseStore, ['getHouseListByName']),
    onSubmit() {
      console.log(this.aptName)
      if (this.aptName) this.getHouseListByName(this.aptName)
    },
  },
}
</script>

<style scoped>
/* CFormInput {
  line-height: 50px;
  vertical-align: middle;
  margin-top: 2px !important;
} */
</style>
