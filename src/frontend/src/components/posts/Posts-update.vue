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
          <router-link to="/posts" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
          <b-button type="submit" variant="primary">수정 완료</b-button>&nbsp;
          <button type="button" class="btn btn-danger" v-on:click="deleteText">삭제</button>
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
      title: "",
      content: "",
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      this.$http.get('/json/' + this.id + '/post.json').then((response) => {
        this.postDTO = response.data
        this.title = this.postDTO.title
        this.content = this.postDTO.content
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    onSubmit(evt) {
      evt.preventDefault()
      this.$http.put('/api/v1/posts/' + this.id, {
        "title": this.title,
        "content": this.content,
      }).then(() => {
        alert('글이 수정되었습니다')
        this.$router.push('/posts')
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    deleteText() {
      this.$http.delete('/api/v1/posts/' + this.id).then(() => {
        alert('글이 삭제되었습니다')
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