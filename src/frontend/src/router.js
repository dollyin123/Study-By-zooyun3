import Vue from 'vue'
import VueRouter from "vue-router";
import Home from "./components/Home";
import Posts_save from "./components/posts/Posts-save";
import Posts_update from "./components/posts/Posts-update";
import Board from "./components/posts/Board";
import StudentManager from "@/components/student/StudentManager";
import NewStudent from "@/components/student/NewStudent";
import Student_update from './components/student/Student-update';

Vue.use(VueRouter)

export default new VueRouter({
    mode: 'history',
    routes: [
        { path: '/', component: Home },
        { path: '/posts/save', component: Posts_save },
        { path: '/posts/update/:id', component: Posts_update },
        { path: '/posts', component: Board },
        { path: '/student', component: StudentManager },
        { path: '/student/new', component: NewStudent },
        { path: '/student/update/:id', component: Student_update },
    ]
})