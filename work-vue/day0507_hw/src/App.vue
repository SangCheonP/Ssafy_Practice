<script setup>
import { ref } from "vue";
import BusinessCard from "@/components/BusinessCard.vue";
import CreateCardForm from "./components/CreateCardForm.vue";

const newCard = ref({});

const updateCard = (cardInfo) => {
  console.log("updateCard");

  newCard.value = cardInfo;
};
</script>

<template>
  <header>
    <span>명함 관리 페이지</span>
  </header>
  <main>
    <span>명함을 관리하는 페이지입니다. 여기에 명함 목록이 표시됩니다.</span>
    <div><CreateCardForm @createCardEvent="updateCard" /></div>
  </main>
  <article>
    <h3>보유 명함 목록</h3>
    <BusinessCard :card="newCard" />
  </article>
  <footer class="footer mt-auto py-3 bg-light fixed-bottom">
    <div class="container">
      <span class="text-muted">© 2023 My Business Cards</span>
    </div>
  </footer>
</template>

<style scoped>
header {
  text-align: center; /* 헤더 내 모든 내용을 가운데 정렬 */
  padding: 20px 0; /* 위아래로 패딩 추가 */
}

header > span {
  background-color: blue;
  color: white;
  font-weight: bold;
  font-size: 30px;
  padding: 10px 20px; /* span 내의 패딩 추가 */
  display: inline-block; /* inline-block으로 설정하여 패딩과 정렬이 올바르게 작동하게 함 */
}

main {
  text-align: center;
}

article > h3 {
  padding: 50px 0;
  text-align: center;
  font-weight: bold;
}

footer {
  text-align: center;
}
</style>
