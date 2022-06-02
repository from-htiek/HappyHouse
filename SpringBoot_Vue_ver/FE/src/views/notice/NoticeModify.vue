<template>
  <CForm id="title" @submit="onSubmit">
    <CFormInput
      type="text"
      size="lg"
      placeholder="제목"
      v-model="notice.title"
    />
    <vue-editor v-model="notice.content" />
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
import { getNotice, modifyNotice } from '@/api/notice'
// import { mapState } from 'vuex'
import { VueEditor } from 'vue3-editor'

export default {
  name: 'NoticeWrite',
  data() {
    return {
      notice: {
        no: 0,
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
    // ...mapState(memberStore, ["userInfo"]),
  },
  created() {
    getNotice(
      this.$route.params.no,
      ({ data }) => {
        this.notice = data
      },
      (error) => {
        console.log(error)
      },
    )
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()

      let notice = {
        no: this.notice.no,
        title: this.notice.title,
        content: this.notice.content,
        date: this.notice.date,
      }
      this.updateNotice(notice)
    },
    updateNotice(notice) {
      modifyNotice(
        {
          no: notice.no,
          title: notice.title,
          content: notice.content,
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
      this.$router.push({ name: 'NoticeList' })
    },
    moveDetail() {
      this.$router.push({ name: 'NoticeDetail' })
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
