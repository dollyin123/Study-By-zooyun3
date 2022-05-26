<template>
  <div>
    <h1>학생 관리</h1>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6">
          <b-button variant="primary" to="/students/studentsave">학생정보 신규입력</b-button>
        </div>
      </div>
      <br>
      <b-table striped small hover fixed :items="students" :fields="fields">
        <template v-slot:cell(stNumber)="data">
          <router-link v-bind:to="url + data.item.stNumber">{{ data.value }}</router-link>
        </template>
      </b-table>
      <b-pagination-nav :link-gen="linkGen" :number-of-pages="rows" use-router></b-pagination-nav>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentManager",
  data() {
    return {
      rows: 1,
      students: [],
      fields: [
        {
          key: 'university',
          label: '소속 대학',
        },
        {
          key: 'major',
          label: '소속 학과',
        },
        {
          key: 'grade',
          label: '학기',
        },
        {
          key: 'stNumber',
          label: '학번',
        },
        {
          key: 'name',
          label: '이름',
        }
      ],
      url: '/students/studentdetail/no='
    }
  },
  beforeRouteUpdate(to, from, next) {
    this.getData((to.query.page === undefined ? 1 : to.query.page))
    next()
  },
  created() {
    this.getData((this.$route.query.page === undefined ? 1 : this.$route.query.page))
    this.getRows()
  },
  methods: {
    getData(page) {
      this.$http.get('/json/studentList.json/page=' + page).then((response) => {
        this.students = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getRows() {
      this.$http.get('/getrows').then((response) => {
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