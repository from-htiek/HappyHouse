<template>
  <CTableRow>
    <CTableDataCell class="col-1 text-center"
      ><CIcon :icon="cilBullhorn" size="xl"
    /></CTableDataCell>
    <CTableDataCell class="col-1 text-center">{{ notice.no }}</CTableDataCell>
    <CTableDataCell class="col-5">
      <router-link
        id="subject"
        :to="{ name: 'NoticeDetail', params: { no: notice.no } }"
      >
        {{ notice.title }}</router-link
      >
    </CTableDataCell>
    <CTableDataCell class="col-1 text-center">관리자</CTableDataCell>
    <CTableDataCell class="col-2 text-center">{{ dateFormat }}</CTableDataCell>
  </CTableRow>
</template>

<script>
// import moment from 'moment'
// import { mapActions } from 'vuex'
import dayjs from 'dayjs'
import { CIcon } from '@coreui/icons-vue'
import { cilBullhorn } from '@coreui/icons'

// const BoardStore = 'BoardStore'

export default {
  name: 'NoticeListItem',
  props: {
    notice: Object,
  },
  data() {
    return {
      date: this.notice.date,
    }
  },
  component: {
    dayjs,
    CIcon,
  },
  setup() {
    return {
      cilBullhorn,
    }
  },
  computed: {
    dateFormat() {
      return dayjs(this.date).format('YYYY-MM-DD')
    },
  },
}
</script>

<style scope>
#subject {
  text-decoration: none;
  font-weight: bold;
  color: rgb(0, 0, 0);
}
</style>
