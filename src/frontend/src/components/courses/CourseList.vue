<template>
  <div>

  </div>
</template>

<script>
export default {
  name: "CourseList",
  created() {
    this.getCourse()
  },
  methods: {
    getCourse() {
      this.$http.get('').then((response) => {
        this.$store.state.courses = null
        this.$store.state.courses = response.data
      }).catch((ex) => {
        alert("API Error : " + ex)
      })
    },
    addCourseToCart(course) {
      this.$store.dispatch("addCourseToCart", course)
    }
  },
}
</script>

<style scoped>

</style>