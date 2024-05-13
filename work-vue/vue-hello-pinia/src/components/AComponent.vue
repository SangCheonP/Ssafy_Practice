<script setup>
import { useCounterStore } from "@/stores/counter";

const store = useCounterStore();
</script>

<template>
  <div>
    <h1>AComponent 입니다</h1>
    <h3>AComponent stroe count : {{ store.count }}</h3>
  </div>
</template>

<style scoped></style>
