import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        courses: [],
        cart: []
    },
    actions: {
        addCourseToCart({state, commit}, course) {
            const cartItem = state.cart.find(item => item.id === course.id);
            if(!cartItem) {
                commit('pushCourseToCart', course.id);
            } else {
                alert('이미 담은 강의입니다.')
            }
        }
    },
    mutations: {
        pushCourseToCart(state, CourseId) {
            state.cart.push({
                id: CourseId
            });
        },
    }
})

export default store