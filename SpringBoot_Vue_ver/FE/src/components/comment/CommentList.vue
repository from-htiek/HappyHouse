<template>
  <h5 class="mt-3">댓글</h5>
  <hr />
  <CForm @submit="onSubmit">
    <CFormInput type="text" placeholder="댓글 추가..." v-model="content" />
    <div class="col-11" />
    <div class="gap-2 d-md-flex justify-content-md-end mt-2 mb-2">
      <CButton type="reset" color="danger" size="sm">취소</CButton>
      <CButton type="submit" color="secondary" size="sm">댓글</CButton>
    </div>
  </CForm>
  <CCard>
    <CCardBody v-if="comments.length">
      <comment-list-item
        v-for="(comment, index) in comments"
        :key="index"
        :comment="comment"
        :article="article"
      />
    </CCardBody>
  </CCard>
</template>

<script>
import CommentListItem from '@/components/comment/CommentListItem.vue'
import { writeComment } from '@/api/comment.js'
import { mapState, mapActions } from 'vuex'

const commentStore = 'commentStore'
const memberStore = 'memberStore'

export default {
  name: 'CommentList',
  data() {
    return {
      no: 0,
      memboardId: 0,
      memId: '',
      content: '',
      date: '',
    }
  },
  props: {
    article: Object,
  },
  components: {
    CommentListItem,
  },
  computed: {
    ...mapState(commentStore, ['comment', 'comments']),
    ...mapState(memberStore, ['userInfo']),
  },
  methods: {
    ...mapActions(commentStore, ['getCommentList', 'registComment']),
    onSubmit(event) {
      event.preventDefault()

      let comment = {
        no: this.no,
        memboardId: this.article.no,
        memId: this.userInfo.memId,
        content: this.content,
        date: this.date,
      }
      this.registComment(comment)
    },
    registComment(comment) {
      writeComment(
        {
          no: comment.no,
          memboardId: comment.memboardId,
          memId: comment.memId,
          content: comment.content,
        },
        ({ data }) => {
          let msg = '등록 중 문제가 발생했습니다.'
          if (data === 'success') {
            msg = '등록이 완료되었습니다.'
          }
          alert(msg)
          this.$router.go()
        },
        (error) => {
          console.log(error)
        },
      )
    },
  },
  mounted() {
    setTimeout(() => {
      this.getCommentList(this.article.no)
    }, 50)
  },
}
</script>
