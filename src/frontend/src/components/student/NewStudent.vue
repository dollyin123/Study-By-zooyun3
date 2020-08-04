<template>
  <div>
    <h1>학생정보 신규입력</h1>
    <div class="col-md-12">
      <div class="col-md-6">
        <b-form @submit="onSubmit">
          <!-- TODO 대학 학과 DB처리 -->
          <label class="mr-sm-2">소속 대학 : </label>
          <b-form-select class="Style35" v-model="university" :options="universityList" v-on:change="findMajor"
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
          <b-form-select class="Style25" v-model="sido" :options="sidoList" v-on:change="findSigungu">
            <template v-slot:first>
              <b-form-select-option :value="null" disabled>-- 시도 --</b-form-select-option>
            </template>
          </b-form-select>&nbsp;
          <b-form-select class="Style25" v-model="sigungu" :options="sigunguList" v-on:change="findOopmien">
            <template v-slot:first>
              <b-form-select-option :value="null" disabled>-- 시군구 --</b-form-select-option>
            </template>
          </b-form-select>&nbsp;
          <b-form-select class="Style25" v-model="oopmien" :options="oopmienList">
            <template v-slot:first>
              <b-form-select-option :value="null" disabled>-- 읍면 --</b-form-select-option>
            </template>
          </b-form-select>
          <br><br>
          <b-form-input class="Style60" type="text" v-model="moreaddress" placeholder="도로명" required></b-form-input>
          <br><br>
          <label class="mr-sm-2">생년월일 : </label>
          <b-form-datepicker class="Style35" v-model="birthday"></b-form-datepicker>
          <br>
          <label class="mr-sm-2">입학년도 : </label>
          <b-form-datepicker class="Style35" v-model="entranceYear"></b-form-datepicker>
          <br>
          <label class="mr-sm-2">증명사진 : </label>
          <b-form-file class="Style60"
                       v-model="picture"
                       :state="Boolean(picture)"
                       accept="image/png"
                       placeholder="Choose a file or drop it here..."
                       drop-placeholder="Drop file here..."
                       required
          ></b-form-file>
          <br><br>
          <router-link to="/posts" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
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
      address: null,
      birthday: null,
      entranceYear: null,
      picture: null,

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

      sido: null,
      sigungu: null,
      oopmien: null,
      moreaddress: null,

      sidoList: [],
      sigunguList: [],
      oopmienList: [],

      zero: "",
    }
  },
  created() {
    this.findUNIV()
    this.findSido()
  },
  watch: {
    '$route': 'getData'
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.$http.get('/json/universityCode'+this.university+'.json').then((response) => {
        this.university = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      this.$http.get('/json/majorCode'+this.major+'.json').then((response) => {
        this.major = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
      if (this.sigungu != null) {
        this.sigungu = " " + this.sigungu
      }
      if (this.oopmien != null) {
        this.oopmien = " " + this.oopmien
      }
      this.address = this.sido + this.sigungu + this.oopmien + " " + this.moreaddress
      this.$http.post('/api/v1/students', {
        "university": this.university,
        "major": this.major,
        "stNumber": "0",
        "grade": this.grade,
        "name": this.name,
        "sex": this.sex,
        "phoneNumber": this.firstNum + "-" + this.secondNum + "-" + this.lastNum,
        "address": this.address,
        "birthday": this.birthday,
        "entranceYear": this.entranceYear,
        "picture": null, //TODO
      }).then(() => {
        this.getStId()
        alert('신규 학생 정보가 등록되었습니다')
        this.$router.push('/student')
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    findUNIV() {
      this.$http.get('/json/universityList.json').then((response) => {
        this.universityList = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    findMajor() {
      this.$http.get('/json/majorList'+this.university+'.json').then((response) => {
        this.majorList = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    findSido() {
      this.$http.get('/json/sido.json').then((response) => {
        this.sidoList = response.data
      })
    },
    findSigungu() {
      this.sigunguList = null;
      this.oopmienList = null;
      this.$http.get('/json/sigungu' + this.sido + '.json').then((response) => {
        if (response.data != "") {
          this.sigunguList = response.data
        } else {
          this.$http.get('/json/andoopmien' + this.sido + '.json').then((response) => {
            this.oopmienList = response.data
          })
        }
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    findOopmien() {
      this.$http.get('/json/oopmien' + this.sigungu + '.json').then((response) => {
        this.oopmienList = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    getStId() {
      this.$http.get('/json/newId.json').then((response) => {
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
          default:
            this.zero = "";
            break
        }
        this.$http.put('/api/v1/students/' + response.data, {
          "stNumber": "12" + this.entranceYear.toString().substring(0, 2) + this.zero + response.data
        })
      })
    },
  }
}
</script>

<style scoped>
.Style60 {
  display: inline-block;
  width: 60%;
}

.Style35 {
  display: inline-block;
  width: 35%;
}

.Style25 {
  display: inline-block;
  width: 25%;
}

.Style10 {
  display: inline-block;
  width: 10%;
}
</style>