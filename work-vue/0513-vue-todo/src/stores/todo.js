import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useTodoStore = defineStore("todo", () => {
  let id = 0;
  const todos = ref([
    {
      id: id++,
      text: `${id}일 입니다.`,
      idDone: false,
    },
    {
      id: id++,
      text: `${id}일 입니까?`,
      idDone: false,
    },
    {
      id: id++,
      text: `${id}일 이군요.`,
      idDone: false,
    },
  ]);

  const addTodo = (todoText) => {
    todos.value.push({
      id: id++,
      text: `${id}일 ${todoText}`,
      idDone: false,
    });
  };

  const deleteTodo = (todoId) => {
    // const index = todos.value.indexOf(todoId);

    const index = todos.value.findIndex((todo) => todo.id === todoId);

    todos.value.splice(index, 1);
  };

  return { todos, addTodo, deleteTodo };
});
