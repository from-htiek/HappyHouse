<template>
  <CForm id="title" @submit="onSubmit">
    <CFormInput type="text" size="lg" placeholder="제목" v-model="title" />
    <vue-editor v-model="content" />
    <div class="container">
      <div id="btn" class="row">
        <div class="col-11" />
        <div class="gap-2 d-md-flex justify-content-md-end mt-2 mb-2">
          <CButton type="submit" color="primary" size="sm">등록</CButton>
          <CButton @click="moveList()" color="danger" size="sm">취소</CButton>
        </div>
      </div>
    </div>
  </CForm>
</template>

<script>
import { writeNotice } from '@/api/notice'
import { mapState } from 'vuex'
import { VueEditor } from 'vue3-editor'

const noticeStore = 'noticeStore'
export default {
  name: 'BoardWrite',
  data() {
    return {
      no: 0,
      title: '',
      content: '',
      date: '',
    }
  },
  components: {
    VueEditor,
  },

  computed: {
    ...mapState(noticeStore, ['notice']),
  },

  methods: {
    onSubmit(event) {
      event.preventDefault()

      let notice = {
        no: this.no,
        title: this.title,
        content: this.content,
        date: this.date,
      }
      console.log(notice)
      // alert("글 완료");
      this.registNotice(notice)
      // alert("글 완료");
      // if (!err) alert(msg);
      // else this.$store.dispatch("writeArticle", article);
    },
    registNotice(notice) {
      writeNotice(
        {
          title: notice.title,
          content: notice.content,
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
      this.$router.push({ name: 'NoticeList' })
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
