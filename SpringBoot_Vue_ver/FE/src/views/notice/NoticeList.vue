<template>
  <CCard style="height: 880px">
    <h2 class="text-center mt-5">공지사항</h2>
    <CCardBody>
      <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
          <div v-if="notices.length">
            <div class="container">
              <div class="row">
                <div class="d-flex justify-content-end mb-4">
                  <CButton
                    v-if="userInfo.memId == 'admin'"
                    @click="moveWrite()"
                    color="info"
                    size="sm"
                    >글쓰기</CButton
                  >
                </div>
              </div>
            </div>
            <CRow>
              <CCol>
                <CTable hover responsive>
                  <CTableHead>
                    <CTableRow class="text-center">
                      <CTableHeaderCell></CTableHeaderCell>
                      <CTableHeaderCell>번호</CTableHeaderCell>
                      <CTableHeaderCell>제목</CTableHeaderCell>
                      <CTableHeaderCell>글쓴이</CTableHeaderCell>
                      <CTableHeaderCell>등록일</CTableHeaderCell>
                    </CTableRow>
                  </CTableHead>
                  <CTableBody>
                    <!-- 하위 component인 ListRow에 데이터 전달(props) -->
                    <notice-list-item
                      v-for="(notice, index) in notices"
                      :key="index"
                      :notice="notice"
                    />
                  </CTableBody>
                </CTable>
              </CCol>
            </CRow>
          </div>
          <div v-else class="text-center">
            <div>아직 작성된 글이 없습니다.</div>
            <CButton
              v-if="userInfo.memId == 'admin'"
              class="mt-3"
              size="sm"
              @click="moveWrite()"
              color="info"
              >글쓰기</CButton
            >
          </div>
        </div>
      </div>
    </CCardBody>
  </CCard>
</template>

<script>
import NoticeListItem from '@/components/notice/NoticeListItem.vue'
import { mapState, mapActions } from 'vuex'

const noticeStore = 'noticeStore'
const memberStore = 'memberStore'

export default {
  name: 'NoticeList',
  components: {
    NoticeListItem,
  },
  computed: {
    ...mapState(noticeStore, ['notices']),
    ...mapState(memberStore, ['isLogin', 'userInfo']),
  },
  methods: {
    ...mapActions(noticeStore, ['getNoticeList']),
    moveWrite() {
      this.$router.push({ name: 'NoticeWrite' })
    },
  },
  created() {
    this.getNoticeList()
  },
}
</script>

<style scoped>
/* #container {
  background-color: aliceblue;
} */
</style>
