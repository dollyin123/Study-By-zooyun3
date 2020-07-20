<template>
    <div>
        <h1>공지 사항</h1>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6">
                    <a href="/posts/save" role="button" class="btn btn-primary">글 등록</a>&nbsp;
                </div>
            </div>
            <br>
            <table class="table table-horizontal table-bordered">
                <thead class="thead-strong">
                <tr>
                    <th>게시글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>최종수정일</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <tr v-for="post in posts" v-bind:key="post.id">
                    <td>{{post.id}}</td>
                    <td><a v-bind:href="url+post.id">{{post.title}}</a></td>
                    <td>{{post.author}}</td>
                    <td>{{post.modifiedDate}}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
                posts: [],
                url: "/posts/update/",
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
                this.$http.get('/json/posts.json').then((response) => {
                    this.posts = response.data
                }).catch((ex) => {
                    console.log("List API Error : " + ex)
                })
            }
        },
    }
</script>

<style scoped>

</style>