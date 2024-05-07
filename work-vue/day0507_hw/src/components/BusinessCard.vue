<script setup>
import { ref, computed } from "vue";

const businessCards = ref([
  { name: "일론 머스크", title: "테슬라 테크노킹" },
  { name: "래리 엘리슨", title: "오라클 창업주" },
  { name: "빌 게이츠", title: "MS 공동창업주" },
  { name: "래리 페이지", title: "구글 공동창업주" },
  { name: "세르게이 브린", title: "구글 공동창업주" },
]);

const deleteCard = (name, title) => {
  console.log(name + title);
  const index = businessCards.value.findIndex((card) => card.name === name);
  if (index !== -1) {
    businessCards.value.splice(index, 1);
  }
};
const cardCnt = computed(() => businessCards.value.length);
console.log(cardCnt.value);

import BusinessCardDetail from "./BusinessCardDetail.vue";
</script>

<template>
  <div class="container">
    <div class="row">
      <!-- v-for을 사용하여 각 카드 데이터를 card prop으로 전달 -->
      <div v-if="cardCnt !== 0">
        <span id="cnt">현재 보유중인 명함의 수 : {{ cardCnt }}</span
        ><br />
        <BusinessCardDetail
          class="col-md-4 mb-4"
          v-for="card in businessCards"
          :key="card.name"
          :card="card"
          @deleteCardEvent="deleteCard"
        />
      </div>
      <div v-else>
        <span>명함이 없습니다. 새로운 명함을 추가해주세요.</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  max-width: 960px; /* 최대 너비 설정 (Bootstrap 기본값 참고) */
  display: flex; /* Flexbox를 활용한 중앙 정렬 */
  flex-wrap: wrap; /* 요소들이 다음 줄로 넘어갈 수 있도록 설정 */
  justify-content: center; /* 중앙 정렬 */
}

#cnt {
  width: 100%; /* span에 너비를 전체로 설정 */
  display: block; /* 블록 레벨 요소로 변경 */
  text-align: center; /* 텍스트 중앙 정렬 */
  margin-top: 10px; /* 상단 마진 추가 */
  margin-bottom: 10px; /* 하단 마진 추가 */
}
</style>
