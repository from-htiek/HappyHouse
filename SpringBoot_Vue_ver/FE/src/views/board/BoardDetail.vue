<template>
  <CCard style="height: 880px" class="p-5">
    <CRow class="mb-1">
      <CCol class="mt-3">
        <h2>{{ article.title }}</h2>
      </CCol>
    </CRow>
    <div class="d-md-flex mt-3">
      <div class="mr-3 col-1">{{ article.memId }}</div>
      <div>{{ dateFormat(article.date) }}</div>
    </div>
    <hr />
    <CRow style="height: 700px" class="mb-1 mt-4">
      <p v-html="article.content"></p>
    </CRow>
    <div class="gap-2 d-md-flex justify-content-md-end">
      <CButton @click="moveList()" color="info" size="sm">목록보기</CButton>
      <CButton
        v-if="userInfo.memId == article.memId || userInfo.memId == 'admin'"
        @click="moveModify()"
        color="primary"
        size="sm"
        >수정</CButton
      >
      <CButton
        v-if="userInfo.memId == article.memId || userInfo.memId == 'admin'"
        @click="deleteArticle"
        color="danger"
        size="sm"
        >삭제</CButton
      >
    </div>
  </CCard>
  <!-- <div v-if="comment.memboardId == article.no"> -->
  <comment-list :article="article" />
  <!-- </div> -->
</template>

<script>
import { getArticle, deleteArticle } from '@/api/board.js'
import dayjs from 'dayjs'
import { mapState } from 'vuex'
import CommentList from '@/components/comment/CommentList.vue'

const memberStore = 'memberStore'
// const commentStore = 'commentStore'

export default {
  name: 'BoardDetail',
  data() {
    return {
      article: {},
    }
  },
  components: {
    CommentList,
  },
  computed: {
    ...mapState(memberStore, ['isLogin', 'userInfo']),
    // ...mapState(commentStore, ['comments', 'comment']),
  },
  methods: {
    dateFormat(date) {
      return dayjs(date).format('YYYY.M.D A hh:mm')
    },
    moveModify() {
      this.$router.push({ name: 'BoardModify' })
    },
    modifyArticle() {
      this.$router.push({
        name: 'BoardModify',
        params: { no: this.$route.params.no },
      })
    },
    deleteArticle() {
      if (confirm('삭제된 글은 복구할 수 없습니다.\n삭제하시겠습니까?')) {
        deleteArticle(this.article.no, () => {
          this.$router.push({ name: 'BoardList' })
        })
      }
    },
    moveList() {
      this.$router.push({ name: 'BoardList' })
    },
  },
  created() {
    getArticle(
      this.$route.params.no,
      (response) => {
        this.article = response.data
      },
      (error) => {
        console.log(error)
      },
    )
  },
}
</script>

<style></style>
