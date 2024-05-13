<script setup>
import { useTodoStore } from "@/stores/todo";
const store = useTodoStore();
defineProps({
  todo: Object,
});
</script>

<template>
  <div>
    <span @click="updateTodo">{{ todo.text }}</span>
    <button @click="store.deleteTodo(todo.id)">삭제</button>
  </div>
</template>

<style scoped></style>
