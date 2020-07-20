import Vue from 'vue'
import VueRouter from "vue-router";
import Home from "./components/Home";
import Posts_save from "./components/Posts-save";
import Posts_update from "./components/Posts-update";
import Board from "./components/Board";

Vue.use(VueRouter)

export default new VueRouter({
    mode: 'history',
    routes: [
        { path: '/', component: Home },
        { path: '/posts/save', component: Posts_save },
        { path: '/posts/update/:id', component: Posts_update },
        { path: '/posts/board', component: Board },
    ]
})