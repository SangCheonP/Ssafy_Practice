import { createRouter, createWebHistory } from "vue-router";
import APage from "@/views/APage.vue";
import NaverBlogComp from "@/components/NaverBlogComp.vue";
import NaverShopComp from "@/components/NaverShopComp.vue";
import NaverWeatherComp from "@/components/NaverWeatherComp.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/apage",
      name: "apage",
      component: APage,
    },
    {
      path: "/bpage",
      name: "bpage",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/BPage.vue"),
      // children은 상위 /a뒤에 /가 기본으로 붙으
      children: [
        {
          path: "blog",
          name: "blog",
          component: NaverBlogComp,
        },
        {
          path: "shop",
          name: "shop",
          component: NaverShopComp,
        },
        {
          path: "weather",
          name: "weather",
          component: NaverWeatherComp,
        },
      ],
    },
  ],
});

export default router;
