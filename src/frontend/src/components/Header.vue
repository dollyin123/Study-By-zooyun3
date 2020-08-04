<template>
  <div v-if="getName">
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
                <router-link to="/posts" @click="hide">공지사항</router-link>
                <router-link to="/student" @click="hide">학생관리</router-link>
              </b-nav>
            </nav>
          </div>
        </template>
      </b-sidebar>

      <b-navbar-brand to="/">Home</b-navbar-brand>

      <b-navbar-nav class="ml-auto">
        <span>Logged in as:
          <span id="user">{{ MyName }}</span>&nbsp;
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
      MyName: null,
      getName: false,
    }
  },
  created() {
    this.getData()
  },
  methods: {
    getData() {
      this.$http.get('/json/MyName.json').then((response) => {
        if (response.data != "") {
          this.MyName = response.data
          this.getName = true
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    }
  },
}
</script>

<style scoped>

</style>