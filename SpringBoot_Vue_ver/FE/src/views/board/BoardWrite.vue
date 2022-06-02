<template>
  <CForm id="title" @submit.prevent="onSubmit">
    <CFormInput type="text" size="lg" placeholder="제목" v-model="title" />
    <vue-editor v-model="content" />
    <div class="container">
      <div id="btn" class="row">
        <div class="col-11" />
        <div class="gap-2 d-md-flex justify-content-md-end mt-2 mb-2">
          <CButton type="submit" color="primary" size="sm">등록</CButton>
          <CButton @click.prevent="moveList()" color="danger" size="sm"
            >취소</CButton
          >
        </div>
      </div>
    </div>
  </CForm>
</template>

<script>
import { writeArticle } from '@/api/board'
import { mapState } from 'vuex'
import { VueEditor } from 'vue3-editor'

const boardStore = 'boardStore'
const memberStore = 'memberStore'
export default {
  name: 'BoardWrite',
  data() {
    return {
      no: 0,
      memId: '',
      title: '',
      content: '',
      date: '',
    }
  },
  components: {
    VueEditor,
  },

  computed: {
    ...mapState(boardStore, ['article']),
    ...mapState(memberStore, ['userInfo']),
  },

  methods: {
    onSubmit(event) {
      event.preventDefault()

      let article = {
        no: this.no,
        memId: this.userInfo.memId,
        title: this.title,
        content: this.content,
        date: this.date,
      }
      console.log(article)
      // alert("글 완료");
      this.registArticle(article)
      // alert("글 완료");
      // if (!err) alert(msg);
      // else this.$store.dispatch("writeArticle", article);
    },
    registArticle(article) {
      writeArticle(
        {
          memId: article.memId,
          title: article.title,
          content: article.content,
        },
        ({ data }) => {
          let msg = '등록 중 문제가 발생했습니다.'
          if (data === 'success') {
            msg = '등록이 완료되었습니다.'
          }
          alert(msg)
          this.moveList()
        },
        (error) => {
          console.log(error)
        },
      )
    },
    moveList() {
      this.$router.push({ name: 'BoardList' })
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
