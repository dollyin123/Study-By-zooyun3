<template>
  <div>

  </div>
</template>

<script>
export default {
  name: "course",
  methods: {
    addCourseToCart(course) {
      this.$store.dispatch("addCourseToCart", course)
    }
  }
}
</script>

<style scoped>

</style>