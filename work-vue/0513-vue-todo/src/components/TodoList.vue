<script setup>
import { useTodoStore } from "@/stores/todo";
import TodoListItem from "@/components/TodoListItem.vue";
const store = useTodoStore();
</script>

<template>
  <div>
    <h1>할 일 목록</h1>
    <TodoListItem v-for="todo in store.todos" :key="todo.id" :todo="todo"></TodoListItem>
  </div>
</template>

<style scoped></style>
