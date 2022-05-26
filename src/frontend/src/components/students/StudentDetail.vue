<template>
  <div>
    <h1>학생정보</h1>
    <div class="col-md-12">
      <div class="col-md-6">
        <b-form>
          <label class="mr-sm-2">소속 대학 : </label>
          <b-form-input class="Style35" v-model="university" readonly></b-form-input>
          <br><br>
          <label class="mr-sm-2">소속 학과 : </label>
          <b-form-input class="Style35" v-model="major" readonly></b-form-input>
          <br><br>
          <label class="mr-sm-2">학기 : </label>
          <b-form-input class="Style35" v-model="grade" readonly></b-form-input>
          <br><br>
          <label class="mr-sm-2">이름 : </label>
          <b-form-input class="Style35" v-model="name" readonly></b-form-input>
          <br><br>
          <label class="mr-sm-2">성별 : </label>
          <b-form-radio-group class="Style35" v-model="sex" disabled>
            <b-form-radio value="남">남</b-form-radio>
            <b-form-radio value="여">여</b-form-radio>
          </b-form-radio-group>
          <br><br>
          <label class="mr-sm-2">전화번호 : </label>
          <b-form-input class="Style10" v-model="firstNum" readonly></b-form-input>
          -
          <b-form-input class="Style10" v-model="secondNum" readonly></b-form-input>
          -
          <b-form-input class="Style10" v-model="lastNum" readonly></b-form-input>
          <br><br>
          <label class="mr-sm-2">주소 : </label>
          <br><br>
          <b-form-input class="Style35" v-model="roadAddress" readonly/>&nbsp;
          <br><br>
          <label class="mr-sm-2">생년월일 : </label>
          <b-form-datepicker class="Style35" v-model="birthday" readonly></b-form-datepicker>
          <br>
          <label class="mr-sm-2">입학년도 : </label>
          <b-form-datepicker class="Style35" v-model="entranceYear" readonly></b-form-datepicker>
          <br><br>
          <b-button @click="back" class="btn btn-secondary">뒤로</b-button>&nbsp;
          <b-button v-bind:to="'/students/studentupdate/no=' + no" variant="primary">수정</b-button>&nbsp;
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentDetail",
  data() {
    return {
      university: null,
      major: null,
      grade: 1,
      name: null,
      sex: '남',
      birthday: null,
      entranceYear: null,

      firstNum: "010",
      secondNum: "",
      lastNum: "",

      roadAddress: null,

      no: this.$route.params.studentnumber,

      studentsDTO: [],
    }
  },
  created() {
    this.getData()
  },
  methods: {
    back() {
      window.history.back()
    },
    async getData() {
      await this.$http.get('/json/' + this.no + '/student.json').then((response) => {
        this.studentsDTO = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      await this.$http.get('/json/university' + this.studentsDTO.university + '.json'
      ).then((response) => {
        this.university = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      await this.$http.get('/json/major' + this.studentsDTO.major + '.json'
      ).then((response) => {
        this.major = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      this.grade = this.studentsDTO.grade
      this.name = this.studentsDTO.name
      this.sex = this.studentsDTO.sex
      this.secondNum = this.studentsDTO.phoneNumber.toString().substring(4, 8)
      this.lastNum = this.studentsDTO.phoneNumber.toString().substring(9, 13)
      this.roadAddress = this.studentsDTO.address
      this.birthday = this.studentsDTO.birthday
      this.entranceYear = this.studentsDTO.entranceYear
    }
  }
}
</script>

<style scoped>
.Style35 {
  display: inline-block;
  width: 35%;
}
.Style10 {
  display: inline-block;
  width: 10%;
}
</style>