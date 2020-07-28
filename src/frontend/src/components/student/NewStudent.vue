<template>
  <div>
    <h1>학생정보 신규입력</h1>
    <div class="col-md-12">
      <div class="col-md-4">
        <form>
          <div class="form-group">
            <label>소속 대학</label>
            <input type="text" class="form-control" v-model="universe" placeholder="소속 대학을 입력해 주세요">
          </div>
          <div class="form-group">
            <label>학과</label>
            <input type="text" class="form-control" v-model="major" placeholder="학과를 입력해 주세요">
          </div>
          <div class="form-group">
            <label>학기</label>
            <input type="text" class="form-control" v-model="grade" placeholder="학기를 입력해 주세요">
          </div>
          <div class="form-group">
            <label>이름</label>
            <input type="text" class="form-control" v-model="name" placeholder="이름을 입력해 주세요">
          </div>
          <div class="form-group">
            <label>성별</label>
            <input type="text" class="form-control" v-model="sex" placeholder="성별을 입력해 주세요">
          </div>
          <div class="form-group">
            <label></label>
            <input type="text" class="form-control" v-model="phoneNumber" placeholder="휴대전화 번호를 입력해 주세요">
          </div>
          <div class="form-group">
            <label></label>
            <input type="text" class="form-control" v-model="address" placeholder="주소를 입력해 주세요">
          </div>
          <div class="form-group">
            <label></label>
            <input type="text" class="form-control" v-model="birthday" placeholder="생일을 입력해 주세요">
          </div>
          <div class="form-group">
            <label></label>
            <input type="text" class="form-control" v-model="entranceYear" placeholder="입학년도를 입력해 주세요">
          </div>
          <div class="form-group">
            <label></label>
            <input type="text" class="form-control" v-model="picture" placeholder="사진 주소를 입력해 주세요">
          </div>
        </form>
        <router-link to="/posts/board" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
        <button type="button" class="btn btn-primary" v-on:click="NewStudent">등록</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NewStudent",
  data() {
    return {
      universe: "",
      major: "",
      stNumber: "",
      grade: "",
      name: "",
      sex: "",
      phoneNumber: "",
      address: "",
      birthday: "",
      entranceYear: "",
      picture: "",
    }
  },
  methods: {
    NewStudent() {
      this.$http.post('/api/v1/students', {
        "universe": this.universe,
        "major": this.major,
        "stNumber": "1", //TODO
        "grade": this.grade,
        "name": this.name,
        "sex": this.sex,
        "phoneNumber": this.phoneNumber,
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
    }
  }
}
</script>

<style scoped>

</style>