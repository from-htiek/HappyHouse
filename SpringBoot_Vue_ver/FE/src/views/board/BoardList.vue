<template>
  <CCard style="height: 880px">
    <h2 class="text-center mt-5">자유게시판</h2>
    <CCardBody>
      <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
          <div v-if="articles.length">
            <div class="container">
              <div class="row">
                <div class="d-flex justify-content-end mb-4">
                  <CButton @click="moveWrite()" color="info" size="sm"
                    >글쓰기
                  </CButton>
                </div>
              </div>
            </div>
            <CRow>
              <CCol>
                <CTable hover responsive>
                  <CTableHead>
                    <CTableRow class="text-center">
                      <CTableHeaderCell>번호</CTableHeaderCell>
                      <CTableHeaderCell>제목</CTableHeaderCell>
                      <CTableHeaderCell>글쓴이</CTableHeaderCell>
                      <CTableHeaderCell>등록일</CTableHeaderCell>
                    </CTableRow>
                  </CTableHead>
                  <CTableBody>
                    <!-- 하위 component인 ListRow에 데이터 전달(props) -->
                    <board-list-item
                      v-for="(article, index) in articles"
                      :key="index"
                      :article="article"
                    />
                  </CTableBody>
                </CTable>
              </CCol>
            </CRow>
          </div>
          <div v-else class="text-center">
            <div>아직 작성된 글이 없습니다.</div>
            <CButton class="mt-3" size="sm" @click="moveWrite()" color="info"
              >글쓰기</CButton
            >
          </div>
        </div>
      </div>
    </CCardBody>
  </CCard>
</template>

<script>
import BoardListItem from '@/components/board/BoardListItem.vue'
import { mapState, mapActions } from 'vuex'

const boardStore = 'boardStore'

export default {
  name: 'BoardList',
  components: {
    BoardListItem,
  },
  computed: {
    ...mapState(boardStore, ['articles']),
  },
  methods: {
    ...mapActions(boardStore, ['getArticleList']),
    moveWrite() {
      this.$router.push({ name: 'BoardWrite' })
    },
  },
  created() {
    this.getArticleList()
  },
}
</script>
