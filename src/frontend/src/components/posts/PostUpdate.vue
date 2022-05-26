<template>
  <div>
    <h1>게시글 수정</h1>
    <div class="col-md-12">
      <div class="col-md-4">
        <b-form @submit="onSubmit">
          <b-form-group label="글 번호 : ">
            <b-form-input v-bind:value="postDTO.id" readonly></b-form-input>
          </b-form-group>
          <b-form-group label="제목 : ">
            <b-form-input v-model="title" v-bind:value="postDTO.title" required></b-form-input>
          </b-form-group>
          <b-form-group label="작성자 : ">
            <b-form-input v-bind:value="postDTO.author" readonly></b-form-input>
          </b-form-group>
          <b-form-group label="내용 : ">
            <b-form-textarea v-model="content" v-bind:value="postDTO.content" required></b-form-textarea>
          </b-form-group>
          <router-link v-bind:to="'/posts/postdetail/id=' + id + '/no=' + no" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
          <b-button type="submit" variant="primary">수정 완료</b-button>&nbsp;
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Posts-update",
  data() {
    return {
      postDTO: [],
      id: this.$route.params.id,
      no: this.$route.params.postnumber,
      title: "",
      content: "",
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      this.$http.get('/json/' + this.no + '/post.json').then((response) => {
        this.postDTO = response.data
        this.title = this.postDTO.title
        this.content = this.postDTO.content
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    onSubmit(evt) {
      evt.preventDefault()
      this.$http.put('/api/posts/' + this.no, {
        "title": this.title,
        "content": this.content,
      }).then(() => {
        alert('글이 수정되었습니다')
        this.$router.push('/posts/postdetail/id=' + this.id + '/no=' + this.no)
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
  }
}
</script>

<style scoped>

</style>