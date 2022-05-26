<template>
  <div v-if="isGetName">
    <b-navbar type="dark" variant="info">
      <b-icon icon="list" variant="light" font-scale="3" v-b-toggle.sidebar-1></b-icon>
      <b-sidebar id="sidebar-1" aria-labelledby="sidebar-1-title" bg-variant="light" no-header shadow>
        <template v-slot:default="{ hide }">
          <b-navbar type="dark" variant="info">
            <b-icon icon="list" variant="light" font-scale="3" v-b-toggle.sidebar-1></b-icon>
          </b-navbar>
          <div class="p-3">
            <h4 id="sidebar-no-header-title">Menu</h4>
            <nav class="mb-3">
              <b-nav vertical>
                <router-link to="/posts/postsboard/id=notice" @click="hide">공지사항</router-link>
                <router-link to="/posts/postsboard/id=free" @click="hide">자유게시판</router-link>
                <router-link v-if="isProfessor" to="/students/studentsboard" @click="hide">학생관리</router-link>
                <router-link v-if="isStudent" v-bind:to="'/students/studentdetail/no=' + number" @click="hide">
                  학생페이지
                </router-link>
              </b-nav>
            </nav>
          </div>
        </template>
      </b-sidebar>

      <b-navbar-brand to="/">Home</b-navbar-brand>

      <b-navbar-nav class="ml-auto">
        <span>Logged in as:
          <span id="user">{{ myName }}</span>&nbsp;
          <b-button href="/logout" size="sm" class="mr-sm-0">Logout</b-button>
        </span>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      myName: '',
      number: '',
      isGetName: false,
      isStudent: false,
      isProfessor: false,
    }
  },
  created() {
    this.getData()
  },
  methods: {
    async getData() {
      await this.$http.get('/json/getname').then((response) => {
        if (response.data != '') {
          this.myName = response.data
          this.isGetName = true
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      await this.$http.get('/json/getnumber').then((response) => {
        this.number = response.data
        if(this.number.toString().substring(0,2) == '12') { //TODO
          this.isStudent = true
          this.isProfessor = false
        }
        if(this.number.toString().substring(0,2) == '11') { //TODO
          this.isStudent = false
          this.isProfessor = true
        }
        if(this.number.toString().substring(0,2) == 'zo') {
          this.isStudent = true
          this.isProfessor = true
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getNumber() {
      this.$http.get('/json/getnumber').then((response) => {
        this.number = response.data.toString()
        console.log(this.number)
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
  },
}
</script>

<style scoped>

</style>