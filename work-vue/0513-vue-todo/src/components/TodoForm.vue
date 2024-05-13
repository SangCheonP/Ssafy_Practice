<script setup>
import { ref } from "vue";
import { useTodoStore } from "@/stores/todo.js";

const store = useTodoStore();
const todoText = ref("");
const formElement = ref(null);

const inputAndReset = () => {
  store.addTodo(todoText.value);
  //   todoText.value = "";
  formElement.value.reset();
};
</script>

<template>
  <div>
    <form @submit.prevent="inputAndReset" ref="formElement">
      <input type="text" v-model="todoText" />
      <button type="submit">추가</button>
    </form>
  </div>
</template>

<style scoped></style>
