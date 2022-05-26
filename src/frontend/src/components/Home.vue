<template>
  <div class="p-5" style="background-color: #FAFAFA;">
    <div v-if="!isGetName" style="text-align: center;">
      <br>
      <img src="../assets/naver.png" v-on:click="naverLogin">
      <br>
      <img src="../assets/google.png" v-on:click="googleLogin">
      <br>
      <b-card>
        <b-card-body>
          <div class="col-md-12">
            <b-form @submit="onSubmit">
              <b-form-group label="로그인"/>
              <b-form-group label="아이디 : ">
                <b-form-input v-model="number" required></b-form-input>
              </b-form-group>
              <b-form-group label="비밀번호 : ">
                <b-form-input v-model="password" required></b-form-input>
              </b-form-group>
              <b-button type="submit" variant="primary">로그인</b-button>
            </b-form>
          </div>
        </b-card-body>
      </b-card>
    </div>
    <div v-if="isGetName">
      <h1>학생정보관리 사이트 프로젝트</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      isGetName: false,
      myName: '',
      number: null,
      password: null,
    }
  },
  created() {
    this.getName()
  },
  methods: {
    onSubmit(evt) { //TODO
      evt.preventDefault()
      this.$http.post('/user', {
        "email": this.number,
        "password": this.password,
        "name": this.number,
        "role": "ROLE_USER"
      }).then(() => {
        this.$http.post('/login', {
          "email": this.number,
          "password": this.password,
        }).then(() => {
          window.location.reload();
        }).catch(() => {
          alert("로그인 실패")
        })
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getName() {
      this.$http.get('/json/getname').then((response) => {
        if (response.data != '') {
          this.isGetName = true
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    naverLogin() {
      location.href = "/oauth2/authorization/naver"
    },
    googleLogin() {
      location.href = "/oauth2/authorization/google"
    }
  },
}
</script>

<style scoped>

</style>