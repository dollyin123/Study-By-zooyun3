<template>
    <div>
        <h1>게시글 수정</h1>
        <div class="col-md-12">
            <div class="col-md-4">
                <form>
                    <div class="form-group">
                        <label for="id">글 번호</label>
                        <input type="text" class="form-control" id="id" v-bind:value="postDTO.id" readonly>
                    </div>
                    <div class="form-group">
                        <label for="title">제목</label>
                        <input type="text" class="form-control" id="title" v-bind:value="postDTO.title">
                    </div>
                    <div class="form-group">
                        <label for="author"> 작성자 </label>
                        <input type="text" class="form-control" id="author" v-bind:value="postDTO.author" readonly>
                    </div>
                    <div class="form-group">
                        <label for="content"> 내용 </label>
                        <textarea class="form-control" id="content" v-model="postDTO.content"></textarea>
                    </div>
                </form>
                <a href="/" role="button" class="btn btn-secondary">취소</a>&nbsp;
                <button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>&nbsp;
                <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Posts-update",
        data() {
            return {
                postDTO: [],
                id: this.$route.params.id,
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
                this.$http.get('/json/'+this.id+'/post.json').then((response) => {
                    this.postDTO = response.data
                }).catch((ex) => {
                    console.log("List API Error : " + ex)
                })
            }
        },
    }
</script>

<style scoped>

</style>