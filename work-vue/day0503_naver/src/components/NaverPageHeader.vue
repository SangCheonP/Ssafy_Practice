<script setup>
import { ref } from "vue";
const emit = defineEmits(["mom"]);
const keyword = ref("");
const mySearch = () => {
  console.log("NaverPageHeader에서 엔터 " + keyword.value);
  emit("mom", keyword.value);
};
</script>

<template>
  <div>
    <h3>네이버 페이지 헤더</h3>
    <input type="text" v-model="keyword" @keydown.enter="mySearch" />
    <button @click="mySearch">검색</button>
  </div>
</template>

<style scoped></style>
