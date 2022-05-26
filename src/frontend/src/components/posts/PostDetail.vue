<template>
  <div>
    <h1>{{ boardName }}</h1>
    <div class="col-md-12">
      <div class="col-md-4">
        <b-form>
          <b-form-group label="글 번호 : ">
            <b-form-input v-bind:value="postDTO.id" readonly></b-form-input>
          </b-form-group>
          <b-form-group label="제목 : ">
            <b-form-input v-bind:value="postDTO.title" readonly></b-form-input>
          </b-form-group>
          <b-form-group label="작성자 : ">
            <b-form-input v-bind:value="postDTO.author" readonly></b-form-input>
          </b-form-group>
          <b-form-group label="내용 : ">
            <b-form-textarea v-bind:value="postDTO.content" readonly></b-form-textarea>
          </b-form-group>
          <router-link v-bind:to="'/posts/postsboard/id=' + id" role="button" class="btn btn-secondary">뒤로</router-link>&nbsp;
          <b-button v-bind:to="'/posts/postupdate/id=' + id + '/no=' + no" variant="primary">수정</b-button>&nbsp;
          <button type="button" class="btn btn-danger" v-on:click="deleteText">삭제</button>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "PostDetail",
  data() {
    return {
      postDTO: [],
      id: this.$route.params.id,
      no: this.$route.params.postnumber,
      boardName: '',
    }
  },
  created() {
    this.boardName = (this.$route.params.id === 'notice' ? '공지사항' : '자유게시판'),
        this.getData()
  },
  methods: {
    getData() {
      this.$http.get('/json/' + this.no + '/post.json').then((response) => {
        this.postDTO = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    deleteText() {
      this.$http.delete('/api/posts/' + this.no).then(() => {
        alert('글이 삭제되었습니다')
        this.$router.push('/posts/postsboard/id=' + this.id)
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    }
  }
}
</script>

<style scoped>

</style>