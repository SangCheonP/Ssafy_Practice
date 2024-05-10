<script setup>
import { ref } from "vue";
import { useNaverStore } from "@/stores/naver";
import { storeToRefs } from "pinia";

const naverStore = useNaverStore();
const { keyword } = storeToRefs(naverStore);
const { search } = naverStore;
</script>

<template>
  <div>
    <h3>네이버 페이지 헤더</h3>
    <input type="text" v-model="keyword" @keydown.enter="search" />
    <button @click="search">검색</button>
  </div>
</template>

<style scoped></style>
