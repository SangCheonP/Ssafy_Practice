import { createRouter, createWebHistory } from "vue-router"
import HomeView from "../views/HomeView.vue"
import UserView from "@/views/UserView.vue"
import LoginView from "@/views/LoginView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AboutView.vue"),
    },
    {
      path: "/user/:id",
      name: "user",
      component: UserView,
      beforeEnter: (to, from) => {
        console.log(to)
        console.log(from)
      },
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      beforeEnter: loginCheck()
    },
  ],
})

function loginCheck(to, from) {
    const isLogined = true

    if (isLogined === true) {
      console.log("로그인 상태입니다.")
      return { name: "home" }
    }
  }

// to : 이동 할 url 정보를 가진 route 객체
// from : 현재 url 정보를 가진 route 객체
// router.beforeEach((to, from, next) => {
//   console.log("beforEach 호출!!!")
//   console.log(to)
//   console.log(from)
// })

// router.beforeEach((to, from, next) => {
//   // to and from are both route objects. must call `next`.
//   next();
// })

// 1. Global Guard
// router.beforeEach((to, from) => {
//   const isLogined = false; // TODO : 서버에서 로그인여부 체크

//   if (!isLogined && to.name !== 'login') {
//     console.log("로그인이 필요합니다.")
//     return {name: "login"}
//   }
// })

export default router
