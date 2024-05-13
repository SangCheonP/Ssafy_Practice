<script setup>
import { useCounterStore } from "@/stores/counter";

const store = useCounterStore();
</script>

<template>
  <div>
    <h1>BComponentChild 입니다.</h1>
    <h3>BComponentChild stroe count : {{ store.count }}</h3>
    <button @click="store.increment()">Child count 증가</button>
  </div>
</template>

<style scoped></style>
