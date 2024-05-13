<script setup>
import { useCounterStore } from "@/stores/counter";

const store = useCounterStore();

import BComponentChild from "@/components/BComponentChild.vue";
</script>

<template>
  <div>
    <h1>BComponent 입니다</h1>
    <h3>BComponent stroe count : {{ store.count }}</h3>
    <BComponentChild></BComponentChild>
  </div>
</template>

<style scoped></style>
