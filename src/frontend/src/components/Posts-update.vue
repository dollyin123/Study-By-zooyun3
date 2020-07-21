<template>
    <div>
        <h1>게시글 수정</h1>
        <div class="col-md-12">
            <div class="col-md-4">
                <form>
                    <div class="form-group">
                        <label>글 번호</label>
                        <input type="text" class="form-control" v-bind:value="postDTO.id" readonly>
                    </div>
                    <div class="form-group">
                        <label>제목</label>
                        <input type="text" class="form-control" v-model="title" v-bind:value="postDTO.title">
                    </div>
                    <div class="form-group">
                        <label> 작성자 </label>
                        <input type="text" class="form-control" v-bind:value="postDTO.author" readonly>
                    </div>
                    <div class="form-group">
                        <label> 내용 </label>
                        <textarea class="form-control" v-model="content" v-bind:value="postDTO.content"></textarea>
                    </div>
                </form>
                <router-link to="/posts/board" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
                <button type="button" class="btn btn-primary" v-on:click="updateText">수정 완료</button>&nbsp;
                <button type="button" class="btn btn-danger" v-on:click="deleteText">삭제</button>
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
                title: "",
                content: "",
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
                this.$http.get('/json/' + this.id + '/post.json').then((response) => {
                    this.postDTO = response.data
                    this.title = this.postDTO.title
                    this.content = this.postDTO.content
                }).catch((ex) => {
                    alert("API Error : " + ex)
                })
            },
            updateText() {
                this.$http.put('/api/v1/posts/' + this.id, {
                    "title": this.title,
                    "content": this.content,
                }).then(() => {
                    alert('글이 수정되었습니다')
                    this.$router.push('/posts/board')
                }).catch((ex) => {
                    alert("API Error : " + ex)
                })
            },
            deleteText() {
                this.$http.delete('/api/v1/posts/' + this.id).then(() => {
                    alert('글이 삭제되었습니다')
                    this.$router.push('/posts/board')
                }).catch((ex) => {
                    alert("API Error : " + ex)
                })
            }
        }
    }
</script>

<style scoped>

</style>