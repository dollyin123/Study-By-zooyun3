<template>
  <div>
    <h1>게시글 등록</h1>
    <div class="col-md-12">
      <div class="col-md-4">
        <b-form @submit="onSubmit">
          <b-form-group label="제목 : " inline>
            <b-form-input v-model="title" required placeholder="제목을 입력하세요"></b-form-input>
          </b-form-group>
          <b-form-group label="작성자 : " inline>
            <b-form-input v-model="author" readonly></b-form-input>
          </b-form-group>
          <b-form-group label="내용 : " inline>
            <b-form-textarea v-model="content" required placeholder="내용을 입력하세요"></b-form-textarea>
          </b-form-group>
          <router-link v-bind:to="'/posts/postsboard/id=' + id" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
          <b-button type="submit" variant="primary">등록</b-button>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Posts-save",
  data() {
    return {
      title: "",
      author: "",
      content: "",
      board: "",
      id: this.$route.params.id,
    }
  },
  created() {
    this.getName()
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.$http.post('/api/posts', {
        "title": this.title,
        "author": this.author,
        "content": this.content,
        "board": this.$route.params.id
      }).then(() => {
        alert('글이 등록되었습니다')
        this.$router.push('/posts/postsboard/id=' + this.id)
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getName() {
      this.$http.get('/json/getname').then((response) => {
        this.author = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
  }
}
</script>

<style scoped>

</style>