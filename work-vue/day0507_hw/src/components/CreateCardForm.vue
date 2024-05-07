<script setup>
import { ref } from "vue";

const name = ref("");
const title = ref("");

const emit = defineEmits(["createCardEvent"]);

const createCardFunc = () => {
  console.log("실행됨");

  const cardInfo = {
    name: name.value,
    title: title.value,
  };

  emit("createCardEvent", cardInfo);

  console.log("emit 후");

  name.value = "";
  title.value = "";
};
</script>

<template>
  <div class="container mt-5">
    <form @submit.prevent="createCardFunc">
      <div class="row">
        <div class="col-md-4">
          <label for="name" class="form-label">이름</label>
          <input type="text" class="form-control" id="name" v-model="name" />
        </div>
        <div class="col-md-4">
          <label for="title" class="form-label">직함</label>
          <input type="text" class="form-control" id="title" v-model="title" />
        </div>
        <div class="col-md-4 d-flex align-items-end">
          <button type="submit" class="btn btn-primary">명함 추가</button>
        </div>
      </div>
    </form>
  </div>
</template>

<style scoped></style>
