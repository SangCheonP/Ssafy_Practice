<script setup>
import { defineProps } from "vue";

const props = defineProps({
  quiz: Object,
});
</script>

<template>
  <div>
    <h3>{{ quiz.question }}</h3>
    <label for="answer">정답 입력</label>
    <input type="text" id="answer" />
  </div>
</template>

<style scoped></style>
