<template>
  <div class="p-5" style="background-color: #FAFAFA;">
    <b-card>
      <b-card-body>
        <div class="col-md-12">
          <div class="pb-5">
            <h3 style="display: initial;">{{ boardName }}</h3>
            <b-button class="float-right" variant="primary" v-bind:to="'/posts/postsave/id=' + id">글 등록</b-button>
          </div>
          <b-table striped small hover fixed :items="posts" :fields="fields">
            <template v-slot:cell(title)="data">
              <router-link v-bind:to="'/posts/postdetail/id='+ id + '/no=' + data.item.id">
                {{ data.value }}
              </router-link>
            </template>
          </b-table>
          <b-pagination-nav :link-gen="linkGen" :number-of-pages="rows" use-router></b-pagination-nav>
        </div>
      </b-card-body>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "Home",
  beforeRouteUpdate(to, from, next) {
    this.id = to.params.id
    this.checkId(this.id)
    this.getData(to.params.id, (to.query.page === undefined ? 1 : to.query.page))
    this.getRows(to.params.id)
    next()
  },

  data() {
    return {
      searchOption: '',
      keyWord: '',
      board: '',
      boardName: '',
      id: this.$route.params.id,
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
      currentPage: 1,
      rows: 1,
      getBy: 'title',
      TAGet: [
        {value: 'title', text: '제목'},
        {value: 'author', text: '작성자'},
      ],
      search: null,
    }
  },
  created() {
    this.getData(this.$route.params.id, (this.$route.query.page === undefined ? 1 : this.$route.query.page))
    this.checkId(this.$route.params.id)
    this.getRows(this.$route.params.id)
  },
  methods: {
    getData(id, page) {
      this.$http.get('/json/postsList.json/' + id + '/page=' + page).then((response) => {
        this.posts = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    checkId(id) {
      this.board = id
      if (id == 'notice') {
        this.boardName = '공지사항'
      }
      if (id == 'free') {
        this.boardName = '자유게시판'
      }
    },
    getRows(id) {
      this.$http.get('/getrows/' + id).then((response) => {
        this.rows = response.data
      })
    },
    linkGen(pageNum) {
      return pageNum === 1 ? '?' : `?page=${pageNum}`
    },
  },
}
</script>

<style scoped>

</style>