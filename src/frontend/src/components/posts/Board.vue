<template>
  <div>
    <h1>공지 사항</h1>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6">
          <b-button variant="primary" to="/posts/save">글 등록</b-button>
        </div>
      </div>
      <br>
      <b-table striped small hover fixed :items="posts" :fields="fields">
        <template v-slot:cell(id)="data">
          {{ data.value }}
        </template>
        <template v-slot:cell(title)="data">
          <router-link v-bind:to="url + data.item.id">{{ data.value }}</router-link>
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      fields: [
        {
          key: 'id',
          label: '게시글번호',
        },
        {
          key: 'title',
          label: '제목',
        },
        {
          key: 'author',
          label: '작성자',
        },
        {
          key: 'modifiedDate',
          label: '최종수정일',
        }
      ],
      posts: [],
      url: "/posts/update/",
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      this.$http.get('/json/posts.json').then((response) => {
        this.posts = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
  },
}
</script>

<style scoped>

</style>