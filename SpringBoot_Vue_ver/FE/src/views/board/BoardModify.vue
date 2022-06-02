<template>
  <CForm id="title" @submit="onSubmit">
    <CFormInput
      type="text"
      size="lg"
      placeholder="제목"
      v-model="article.title"
    />
    <vue-editor v-model="article.content" />
    <div class="container">
      <div id="btn" class="row">
        <div class="col-11" />
        <div class="gap-2 d-md-flex justify-content-md-end mt-2 mb-2">
          <CButton type="submit" color="primary" size="sm">수정</CButton>
          <CButton @click="moveDetail()" color="danger" size="sm">취소</CButton>
        </div>
      </div>
    </div>
  </CForm>
</template>

<script>
import { getArticle, modifyArticle } from '@/api/board'
import { mapState } from 'vuex'
import { VueEditor } from 'vue3-editor'
const memberStore = 'memberStore'

export default {
  name: 'BoardWrite',
  data() {
    return {
      article: {
        no: 0,
        memId: '',
        title: '',
        content: '',
        date: '',
      },
    }
  },
  components: {
    VueEditor,
  },

  computed: {
    ...mapState(memberStore, ['userInfo']),
  },
  created() {
    getArticle(
      this.$route.params.no,
      ({ data }) => {
        this.article = data
      },
      (error) => {
        console.log(error)
      },
    )
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()

      let article = {
        no: this.article.no,
        memId: this.userInfo.memId,
        title: this.article.title,
        content: this.article.content,
        date: this.article.date,
      }
      this.updateArticle(article)
    },
    updateArticle(article) {
      modifyArticle(
        {
          no: article.no,
          memId: article.memId,
          title: article.title,
          content: article.content,
        },
        ({ data }) => {
          let msg = '수정 중 문제가 발생했습니다.'
          if (data === 'success') {
            msg = '수정이 완료되었습니다.'
          }
          alert(msg)
          this.moveDetail()
        },
        (error) => {
          console.log(error)
        },
      )
    },
    moveList() {
      this.$router.push({ name: 'BoardList' })
    },
    moveDetail() {
      this.$router.push({ name: 'BoardDetail' })
    },
  },
}
</script>

<style>
#title {
  background-color: white;
}
#btn {
  border: 1px solid lightgrey;
}
</style>
