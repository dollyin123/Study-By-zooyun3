<template>
  <div>
    <div v-if="!getName" style="text-align: center;">
      <br>
      <img src="../assets/naver.png" v-on:click="naverLogin">
      <br>
      <img src="../assets/google.png" v-on:click="googleLogin">
    </div>
    <div v-if="getName">
      <h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      getName: false,
    }
  },
  created() {
    this.getData()
  },
  watch: {
    '$route': 'getData'
  },
  methods: {
    getData() {
      this.$http.get('/json/MyName.json').then((response) => {
        if (response.data != "") {
          this.getName = true
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    naverLogin() {
      location.href="/oauth2/authorization/naver"
    },
    googleLogin() {
      location.href="/oauth2/authorization/google"
    }
  },
}
</script>

<style scoped>

</style>