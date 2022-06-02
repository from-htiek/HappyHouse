<template>
  <CTableRow>
    <CTableDataCell class="col-1 text-center">{{ article.no }}</CTableDataCell>
    <CTableDataCell class="col-4">
      <router-link :to="{ name: 'BoardDetail', params: { no: article.no } }">
        <div>{{ article.title }}</div>
      </router-link>
    </CTableDataCell>
    <CTableDataCell class="col-1 text-center">{{
      article.memId
    }}</CTableDataCell>
    <CTableDataCell class="col-1 text-center">{{ dateFormat }}</CTableDataCell>
  </CTableRow>
</template>

<script>
// import moment from 'moment'
// import { mapActions } from 'vuex'
import dayjs from 'dayjs'

// const BoardStore = 'BoardStore'

export default {
  name: 'BoardListItem',
  props: {
    article: Object,
  },
  data() {
    return {
      date: this.article.date,
    }
  },
  component: {
    dayjs,
  },
  computed: {
    dateFormat() {
      return dayjs(this.date).format('YYYY-MM-DD')
    },
  },
}
</script>

<style scoped>
a {
  text-decoration: none;
  color: rgb(0, 0, 0);
}
</style>
