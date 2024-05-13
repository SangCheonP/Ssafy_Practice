<script setup>
import { useCounterStore } from "./stores/counter";

const store = useCounterStore();

import AComponent from "@/components/AComponent.vue";
import BComponent from "@/components/BComponent.vue";
</script>

<template>
  <div>
    <h1>APP입니다</h1>
    <p>store count : {{ store.count }}</p>
    <p>store double count : {{ store.doubleCount }}</p>
    <button @click="store.increment">count 증가</button>
    <AComponent></AComponent>
    <BComponent></BComponent>
  </div>
</template>

<style scoped></style>
