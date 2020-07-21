<template>
    <div>
        <b-navbar type="dark" variant="info">
            <b-icon icon="list" variant="light" font-scale="3" v-b-toggle.sidebar-1></b-icon>
            <b-sidebar id="sidebar-1" aria-labelledby="sidebar-1-title" shadow>
                <template v-slot:default="{ hide }">
                    <div class="p-3">
                        <h4 id="sidebar-no-header-title">Menu</h4>
                        <nav class="mb-3">
                            <b-nav vertical>
                                <router-link to="/posts/board" @click="hide">공지사항</router-link>
                            </b-nav>
                        </nav>
                    </div>
                </template>
            </b-sidebar>

            <b-navbar-brand to="/">Home</b-navbar-brand>

            <b-navbar-nav class="ml-auto">
                <span v-if="getName">Logged in as:
                    <span id="user">{{MyName}}</span>&nbsp;
                    <b-button href="/logout" size="sm" class="mr-sm-0">Logout</b-button>
                </span>&nbsp;
                <span v-if="!getName">
                    <b-button href="/oauth2/authorization/google" variant="primary">Google Login</b-button>&nbsp;
                    <b-button href="/oauth2/authorization/naver" variant="success">Naver Login</b-button>
                    </span>
            </b-navbar-nav>
        </b-navbar>
    </div>
</template>

<script>
    export default {
        name: "header",
        data() {
            return {
                MyName: null,
                getName: false,
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
                this.$http.get('/json/MyName.json').then((response) => {
                    if (response.data != "") {
                        this.MyName = response.data
                        this.getName = true
                    }
                }).catch((ex) => {
                    alert("API Error : " + ex)
                })
            }
        },
    }
</script>

<style scoped>

</style>