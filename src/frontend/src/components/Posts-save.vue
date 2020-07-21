<template>
    <div>
        <h1>게시글 등록</h1>
        <div class="col-md-12">
            <div class="col-md-4">
                <form>
                    <div class="form-group">
                        <label>제목</label>
                        <input type="text" class="form-control" v-model="title" placeholder="제목을 입력하세요">
                    </div>
                    <div class="form-group">
                        <label>작성자</label>
                        <input type="text" class="form-control" v-model="author" placeholder="작성자를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" v-model="content" placeholder="내용을 입력하세요"></textarea>
                    </div>
                </form>
                <router-link to="/posts/board" role="button" class="btn btn-secondary">취소</router-link>&nbsp;
                <button type="button" class="btn btn-primary" v-on:click="postText">등록</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Posts-save",
        data() {
            return {
                title: "",
                author: "",
                content: "",
            }
        },
        methods: {
            postText() {
                this.$http.post('/api/v1/posts', {
                    "title": this.title,
                    "author": this.author,
                    "content": this.content
                }).then(() => {
                    alert('글이 등록되었습니다')
                    
                }).catch((ex) => {
                    alert("API Error : " + ex)
                })
            }
        }
    }
</script>

<style scoped>

</style>