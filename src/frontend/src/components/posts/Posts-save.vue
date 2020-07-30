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
            <b-form-input v-model="author" required placeholder="작성자를 입력하세요"></b-form-input>
          </b-form-group>
          <b-form-group label="내용 : " inline>
            <b-form-textarea v-model="content" required placeholder="내용을 입력하세요"></b-form-textarea>
          </b-form-group>
          <router-link to="/posts" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
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
    }
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.$http.post('/api/v1/posts', {
        "title": this.title,
        "author": this.author,
        "content": this.content
      }).then(() => {
        alert('글이 등록되었습니다')
        this.$router.push('/posts')
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    }
  }
}
</script>

<style scoped>

</style>