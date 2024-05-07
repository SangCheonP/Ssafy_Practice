<script setup>
import { ref } from "vue";

import NaverPageHeader from "./NaverPageHeader.vue";
import NaverSearchArea from "./NaverPageSearchArea.vue";

const momKeyword = ref("");

const yes = (msg) => {
  console.log(msg);
  momKeyword.value = msg;
};
</script>

<template>
  <div>
    <NaverPageHeader v-on:mom="yes"></NaverPageHeader>
    <NaverSearchArea :naverKeyword="momKeyword"></NaverSearchArea>
  </div>
</template>

<style scoped>
div {
  background-color: brown;
}
</style>
