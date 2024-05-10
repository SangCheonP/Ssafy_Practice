<script setup>
import { RouterLink, RouterView } from "vue-router";
import { ref } from "vue";
import { useCounterStore } from "./stores/counter.js";
import { storeToRefs } from "pinia";

const counter = useCounterStore();
// 구조할당분해를 하면 반응성을 잃음
// const { count } = counter;
const { count } = storeToRefs(counter);

import NaverPage from "./components/NaverPage.vue";
</script>

<template>
  <div>
    <div>
      <h3>{{ count }}</h3>
      <h3>{{ counter.doubleCount }}</h3>
      <button @click="counter.increment">증가</button>
    </div>
    <div>
      <NaverPage></NaverPage>
    </div>
  </div>
</template>

<style scoped></style>
