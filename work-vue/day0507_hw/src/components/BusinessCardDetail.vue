<script setup>
import { defineEmits } from "vue";

const props = defineProps({
  card: Object,
});

const emit = defineEmits(["deleteCardEvent"]);

const deleteCardFunc = () => {
  alert("눌림");
  emit("deleteCardEvent", props.card.name, props.card.title);
};
</script>

<template>
  <div>
    <h2>{{ card.name }}</h2>
    <p>{{ card.title }}</p>
    <button @click="deleteCardFunc">명함 삭제</button>
  </div>
</template>

<style scoped>
div {
  width: auto; /* 너비 설정 */
  height: auto; /* 높이 설정 */
  text-align: center; /* 텍스트 중앙 정렬 */
  background-color: #f8f9fa; /* 배경색을 좀 더 부드러운 회색으로 변경 */
  display: inline-block; /* 인라인 블록 디스플레이 */
  border: 2px solid #007bff; /* 테두리 색상을 부트스트랩의 기본 파란색으로 변경 */
  border-radius: 10px; /* 테두리 둥글게 처리 */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 박스 그림자 효과 추가 */
  padding: 15px; /* 내부 여백 추가 */
  margin: 10px; /* 외부 여백 추가 */
}
</style>
