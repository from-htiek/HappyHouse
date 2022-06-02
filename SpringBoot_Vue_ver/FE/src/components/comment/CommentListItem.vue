<template>
  <div class="mb-3">
    <div>{{ comment.memId }} {{ dateFormat }}</div>
    <div v-if="isModify">{{ comment.content }}</div>
    <div v-else>
      <CForm @submit.prevent="onSubmit">
        <CFormInput type="text" v-model="content" />
        <div class="gap-2 d-md-flex justify-content-md-end mt-2 mb-2">
          <CButton @click.prevent="moveDetail()" color="danger" size="sm"
            >취소</CButton
          >
          <CButton type="submit" color="primary" size="sm">저장</CButton>
        </div>
      </CForm>
    </div>
    <div
      v-if="
        (userInfo.memId == comment.memId || userInfo.memId == 'admin') &&
        isModify
      "
    >
      <div class="gap-2 d-md-flex justify-content-md-end mt-2 mb-2">
        <CButton
          v-if="userInfo.memId == comment.memId && isModify"
          @click="modComment"
          color="primary"
          size="sm"
          >수정</CButton
        >
        <CButton
          v-if="
            (userInfo.memId == comment.memId || userInfo.memId == 'admin') &&
            isModify
          "
          @click="deleteComment"
          color="danger"
          size="sm"
          >삭제</CButton
        >
      </div>
    </div>
  </div>
  <hr />
</template>

<script>
import { mapState } from 'vuex'
import dayjs from 'dayjs'
import { deleteComment, modifyComment } from '@/api/comment.js'

const memberStore = 'memberStore'

export default {
  name: 'CommentListItem',
  props: {
    comment: Object,
    article: Object,
  },
  data() {
    return {
      no: this.comment.no,
      content: this.comment.content,
      date: this.comment.date,
      isModify: true,
    }
  },
  component: {
    dayjs,
  },
  computed: {
    ...mapState(memberStore, ['userInfo']),
    dateFormat() {
      return dayjs(this.date).format('YY.M.D hh:mm')
    },
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()

      let comment = {
        no: this.no,
        memboardId: this.article.no,
        memId: this.userInfo.memId,
        content: this.content,
        date: '',
      }
      this.updateComment(comment)
    },
    updateComment(comment) {
      modifyComment(
        {
          no: comment.no,
          memboardId: comment.memboardId,
          memId: comment.memId,
          content: comment.content,
        },
        ({ data }) => {
          let msg = '수정 중 문제가 발생했습니다.'
          if (data === 'success') {
            msg = '수정이 완료되었습니다.'
          }
          alert(msg)
          this.$router.go()
        },
        (error) => {
          console.log(error)
        },
      )
    },
    modComment() {
      if (this.isModify) this.isModify = false
      else this.isModify = true
      this.content = this.comment.content
      this.no = this.comment.no
    },
    deleteComment() {
      if (confirm('댓글 삭제\n댓글을 완전히 삭제할까요?')) {
        deleteComment(this.comment.no, () => {
          this.$router.go()
        })
      }
    },
    moveDetail() {
      this.$router.go()
    },
  },
}
</script>
