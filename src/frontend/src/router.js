import Vue from 'vue'
import VueRouter from "vue-router";
import Home from "./components/Home";
import PostDetail from "@/components/posts/PostDetail";
import PostSave from "@/components/posts/PostSave";
import PostsBoard from "@/components/posts/PostsBoard";
import PostUpdate from "@/components/posts/PostUpdate";
import RegisterBoard from "@/components/register/RegisterBoard";
import StudentDetail from "@/components/students/StudentDetail";
import StudentSave from "@/components/students/StudentSave";
import StudentsBoard from "@/components/students/StudentsBoard";
import StudentUpdate from "@/components/students/StudentUpdate";

Vue.use(VueRouter)

export default new VueRouter({
    mode: 'history',
    routes: [
        { path: '/', component: Home },
        { path: '/posts/postdetail/id=:id/no=:postnumber', component: PostDetail },
        { path: '/posts/postsave/id=:id', component: PostSave },
        { path: '/posts/postsboard/id=:id', component: PostsBoard, props: (route) => ({query: route.query.page})},
        { path: '/posts/postupdate/id=:id/no=:postnumber', component: PostUpdate },
        { path: '/register/registerboard/no=:studentnumber', component: RegisterBoard },
        { path: '/students/studentdetail/no=:studentnumber', component: StudentDetail },
        { path: '/students/studentsave', component: StudentSave },
        { path: '/students/studentsboard', component: StudentsBoard, props: (route) => ({query: route.query.page}) },
        { path: '/students/studentupdate/no=:studentnumber', component: StudentUpdate },
    ]
})