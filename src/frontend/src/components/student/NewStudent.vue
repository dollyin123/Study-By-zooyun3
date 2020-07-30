<template>
  <div>
    <h1>학생정보 신규입력</h1>
    <div class="col-md-12">
      <div class="col-md-5">
        <b-form @submit="onSubmit">
          <!-- TODO 대학 학과 DB처리 -->
          <label class="mr-sm-2">소속 대학 : </label>
          <b-form-select class="topStyle" v-model="university" :options="universityList" v-on:select="selectUNIV"
          ></b-form-select>
          <br><br>
          <label class="mr-sm-2">소속 학과 : </label>
          <b-form-select class="topStyle" v-model="major" :options="majorList"></b-form-select>
          <br><br>
          <label class="mr-sm-2">학기 : </label>
          <b-form-select class="topStyle" v-model="grade" :options="grades"></b-form-select>
          <br><br>
          <label class="mr-sm-2">이름 : </label>
          <b-form-input class="topStyle" v-model="name" placeholder="ex) 홍길동" required></b-form-input>
          <br><br>
          <label class="mr-sm-2">성별 : </label>
          <b-form-radio-group class="topStyle" v-model="selectSex">
            <b-form-radio value="남">남</b-form-radio>
            <b-form-radio value="여">여</b-form-radio>
          </b-form-radio-group>
          <br><br>
          <label class="mr-sm-2">전화번호 : </label>
          <b-form-input class="middleStyle" v-model="firstNum" readonly></b-form-input>-
          <b-form-input class="middleStyle" v-model="secondNum" required></b-form-input>-
          <b-form-input class="middleStyle" v-model="lastNum" required></b-form-input>
          <br><br>
          <!-- TODO 주소 외부 프로그램 가져와보기 -->
          <label class="mr-sm-2">주소 : </label>
          <b-form-input class="topStyle" v-model="address" required></b-form-input>
          <br><br>
          <label class="mr-sm-2">생년월일 : </label>
          <b-form-datepicker class="topStyle" v-model="birthday"></b-form-datepicker>
          <br>
          <label class="mr-sm-2">입학년도 : </label>
          <b-form-datepicker class="topStyle" v-model="entranceYear"></b-form-datepicker>
          <br>
          <label class="mr-sm-2">증명사진 : </label>
          <b-form-file class="bottomStyle"
                       v-model="file"
                       :state="Boolean(file)"
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
      sex: null,
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
      selectSex: '남',
      firstNum: "010",
      secondNum: "",
      lastNum: "",
    }
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault()
      this.$http.post('/api/v1/students', {
        "university": this.university,
        "major": this.major,
        "stNumber": "1", //TODO
        "grade": this.grade,
        "name": this.name,
        "sex": this.sex,
        "phoneNumber": this.firstNum + "-" + this.secondNum + "-" + this.lastNum,
        "address": this.address,
        "birthday": this.birthday,
        "entranceYear": this.entranceYear,
        "picture": this.picture,
      }).then(() => {
        alert('신규 학생 정보가 등록되었습니다')
        this.$router.push('/student')
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    selectUNIV() {

    }
  }
}
</script>

<style scoped>
.topStyle {
  display: inline-block;
  width: 35%;
}
.middleStyle {
  display: inline-block;
  width: 10%;
}
.bottomStyle {
  display: inline-block;
  width: 60%;
}
</style>