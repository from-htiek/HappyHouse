<template>
  <CCard style="height: 880px" class="p-5">
    <CRow class="mb-1">
      <CCol class="mt-3">
        <h2>{{ notice.title }}</h2>
      </CCol>
    </CRow>
    <div class="d-md-flex mt-3">
      <div class="mr-3 col-1">관리자</div>
      <div>{{ dateFormat(notice.date) }}</div>
    </div>
    <hr />
    <CRow style="height: 700px" class="mb-1 mt-4">
      <p v-html="notice.content"></p>
    </CRow>
    <div class="gap-2 d-md-flex justify-content-md-end mb-2">
      <CButton @click="moveList()" color="info" size="sm">목록보기</CButton>
      <CButton
        v-if="userInfo.memId == 'admin'"
        @click="moveModify()"
        color="primary"
        size="sm"
        >수정</CButton
      >
      <CButton
        v-if="userInfo.memId == 'admin'"
        @click="deleteNotice"
        color="danger"
        size="sm"
        >삭제</CButton
      >
    </div>
  </CCard>
</template>

<script>
import { getNotice, deleteNotice } from '@/api/notice.js'
import dayjs from 'dayjs'
import { mapState } from 'vuex'

const memberStore = 'memberStore'

export default {
  name: 'NoticeDetail',
  data() {
    return {
      notice: {},
    }
  },
  methods: {
    dateFormat(date) {
      return dayjs(date).format('YYYY.M.D A hh:mm')
    },
    moveModify() {
      this.$router.push({ name: 'NoticeModify' })
    },
    modifyNotice() {
      this.$router.push({
        name: 'NoticeModify',
        params: { no: this.$route.params.no },
      })
    },
    deleteNotice() {
      if (confirm('삭제된 글은 복구할 수 없습니다.\n삭제하시겠습니까?')) {
        deleteNotice(this.notice.no, () => {
          this.$router.push({ name: 'NoticeList' })
        })
      }
    },
    moveList() {
      this.$router.push({ name: 'NoticeList' })
    },
  },
  computed: {
    ...mapState(memberStore, ['isLogin', 'userInfo']),
  },
  created() {
    getNotice(
      this.$route.params.no,
      (response) => {
        this.notice = response.data
      },
      (error) => {
        console.log(error)
      },
    )
  },
}
</script>

<style></style>
