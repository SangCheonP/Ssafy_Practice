<script setup>
import { ref } from "vue";
import { useRoute, useRouter, onBeforeRouteLeave, onBeforeRouteUpdate } from "vue-router";

const route = useRoute();
const router = useRouter();

const userId = ref(route.params.id);

const goHome1 = () => {
  router.push({ name: "home" });
};

const goHome2 = () => {
  router.replace({ name: "home" });
};

const changeUser = () => {
  router.push({ name: "user", params: { id: "asdwd" } });
};

onBeforeRouteLeave((to, from) => {
  const flag = window.confirm("정말 떠나시겠습니까?");
  if (flag === false) {
    return false;
  }
});

onBeforeRouteUpdate((to, from) => {
  userId.value = to.params.id;
});
</script>

<template>
  <div>
    <h1>User View</h1>
    <h2>{{ $route.params.id }}님 프로필입니다</h2>
    <h2>{{ userId }}님 프로필입니다</h2>
    <button @click="goHome1">홈으로(push)</button>
    <button @click="goHome2">홈으로(replace)</button>
    <button @click="changeUser">사용자전환</button>
  </div>
</template>

<style scoped></style>
