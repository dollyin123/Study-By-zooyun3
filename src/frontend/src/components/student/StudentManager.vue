<template>
  <div>
    <h1>학생 관리</h1>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6">
          <b-button variant="primary" to="/student/new">학생정보 신규입력</b-button>
        </div>
      </div>
      <br>
      <b-table striped small hover fixed :items="students" :fields="fields">
        <template v-slot:cell(stNumber)="data">
          <router-link to="#">{{ data.value }}</router-link>
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentManager",
  data() {
    return {
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
      ]
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      this.$http.get('/json/simpleList.json').then((response) => {
        this.students = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
  },
}
</script>

<style scoped>

</style>