<script setup>
import MainChildItem from "./MainChildItem.vue";
// 1. props 배열 선언
// defineProps(["myMsg"]);

// 2. props 객체 선언
const props = defineProps({
  myMsg: String,
  myName: String,
});

const childMsg = "childe에서 가공 : " + props.myMsg;

const emit = defineEmits(["upMoney", "changeName"]);

const upMoney = () => {
  emit("upMoney", 10, 20, 30, 40);
};

const changeName = (name) => {
  emit("changeName", name);
};
</script>

<template>
  <div class="child">
    <h1>MainChild</h1>
    <h3>{{ myName }}</h3>
    <div>MainChild : {{ myMsg }}</div>
    <button @click="$emit('moneyEvent')">용돈업</button>
    <button @click="upMoney">용돈10만원</button>
    <MainChildItem @change-name="changeName" :child-msg="childMsg" />
  </div>
</template>

<style scoped>
.child {
  background-color: blueviolet;
}
</style>
