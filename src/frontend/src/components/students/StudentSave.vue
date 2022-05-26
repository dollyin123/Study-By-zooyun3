<template>
  <div>
    <h1>학생정보 신규입력</h1>
    <div class="col-md-12">
      <div class="col-md-6">
        <b-form @submit="onSubmit">
          <label class="mr-sm-2">소속 대학 : </label>
          <b-form-select class="Style35" v-model="university" :options="universityList" v-on:change="getMajorList"
                         required>
            <template v-slot:first>
              <b-form-select-option :value="null" disabled>-- 소속대학 --</b-form-select-option>
            </template>
          </b-form-select>
          <br><br>
          <label class="mr-sm-2">소속 학과 : </label>
          <b-form-select class="Style35" v-model="major" :options="majorList">
            <template v-slot:first>
              <b-form-select-option :value="null" disabled>-- 학과 --</b-form-select-option>
            </template>
          </b-form-select>
          <br><br>
          <label class="mr-sm-2">학기 : </label>
          <b-form-select class="Style35" v-model="grade" :options="grades"></b-form-select>
          <br><br>
          <label class="mr-sm-2">이름 : </label>
          <b-form-input class="Style35" v-model="name" placeholder="ex) 홍길동" required></b-form-input>
          <br><br>
          <label class="mr-sm-2">성별 : </label>
          <b-form-radio-group class="Style35" v-model="sex">
            <b-form-radio value="남">남</b-form-radio>
            <b-form-radio value="여">여</b-form-radio>
          </b-form-radio-group>
          <br><br>
          <label class="mr-sm-2">전화번호 : </label>
          <b-form-input class="Style10" v-model="firstNum" readonly></b-form-input>
          -
          <b-form-input class="Style10" v-model="secondNum" required></b-form-input>
          -
          <b-form-input class="Style10" v-model="lastNum" required></b-form-input>
          <br><br>
          <label class="mr-sm-2">주소 : </label>
          <b-button @click="openApi()">주소 찾기</b-button>
          <br><br>
          <b-form-input class="Style35" v-model="roadAddress" placeholder="도로명주소"/>&nbsp;
          <br><br>
          <label class="mr-sm-2">생년월일 : </label>
          <b-form-datepicker class="Style35" v-model="birthday"></b-form-datepicker>
          <br>
          <label class="mr-sm-2">입학년도 : </label>
          <b-form-datepicker class="Style35" v-model="entranceYear"></b-form-datepicker>
          <br><br>
          <router-link v-bind:to="'/students/studentsboard'" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
          <b-button type="submit" variant="primary">등록</b-button>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NewStudent",
  data() {
    return {
      university: null,
      major: null,
      stNumber: null,
      grade: 1,
      name: null,
      sex: '남',
      phoneNumber: null,
      birthday: null,
      entranceYear: null,
      id: null,

      universityList: [],
      majorList: [],
      grades: [
        {value: 1, text: '1'},
        {value: 2, text: '2'},
        {value: 3, text: '3'},
        {value: 4, text: '4'},
        {value: 5, text: '5'},
        {value: 6, text: '6'},
        {value: 7, text: '7'},
        {value: 8, text: '8'},
      ],

      firstNum: "010",
      secondNum: "",
      lastNum: "",

      roadAddress: null,

      zero: "",
    }
  },

  created() {
    this.getUniversityList()
    this.getSido()
  },
  methods: {
    openApi() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          this.roadAddress = data.roadAddress
        }
      }).open();
    },
    async onSubmit(evt) {
      evt.preventDefault()
      await this.$http.get('/json/getUniversityCodeByUniversity' + this.university + '.json').then((response) => {
        this.university = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      await this.$http.get('/json/getMajorCodeByMajor' + this.major + '.json').then((response) => {
        this.major = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      await this.$http.get('/json/newId.json').then((response) => {
        switch (response.data.toString().length) {
          case 1:
            this.zero = "000";
            break
          case 2:
            this.zero = "00";
            break
          case 3:
            this.zero = "0";
            break
          case 4:
            this.zero = "";
            break
          default :
            this.zero = "000";
        }
        this.id = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      await this.$http.post('/api/students', {
        "university": this.university,
        "major": this.major,
        "stNumber" : "12" + this.entranceYear.toString().substring(2, 4) + this.zero + (this.id + 1),
        "grade": this.grade,
        "name": this.name,
        "sex": this.sex,
        "phoneNumber": this.firstNum + "-" + this.secondNum + "-" + this.lastNum,
        "address": this.roadAddress,
        "birthday": this.birthday,
        "entranceYear": this.entranceYear,
      }).then(() => {
        alert('신규 학생 정보가 등록되었습니다')
        this.$router.push('/students')
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getUniversityList() {
      this.$http.get('/json/getUniversityList.json').then((response) => {
        this.universityList = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getMajorList() {
      this.$http.get('/json/getMajorList' + this.university + '.json').then((response) => {
        this.majorList = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getSido() {
      this.$http.get('/json/getSido.json').then((response) => {
        this.sidoList = response.data
      })
    },
    getSigungu() {
      this.sigunguList = null;
      this.oopmienList = null;
      this.$http.get('/json/getSigungu' + this.sido + '.json').then((response) => {
        if (response.data !== "") {
          this.sigunguList = response.data
        } else {
          this.$http.get('/json/getOopmienBySido' + this.sido + '.json').then((response) => {
            this.oopmienList = response.data
          })
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getOopmien() {
      this.$http.get('/json/getOopmienBySigungu' + this.sigungu + '.json').then((response) => {
        this.oopmienList = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
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