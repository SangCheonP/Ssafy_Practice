<script setup>
import { ref } from "vue";
import NaverPageSearchAreaRow from "./NaverPageSearchAreaRow.vue";

const keyword = ref("");
const items = ref([]);

const mySearch = () => {
  // alert("검색어 입력됨!" + keyword.value);
  fetch("http://localhost:9999/naver/shop/json?keyword=" + keyword.value)
    .then((resp) => resp.json())
    .then((data) => {
      console.log(data);
      items.value = data.items;
      keyword.value = "";
    });
};
</script>

<template>
  <div>
    <input type="text" v-model="keyword" @keydown.enter="mySearch" />
    <button @click="mySearch">검색</button>
    <table>
      <tr>
        <th>이미지</th>
        <th>제목</th>
        <th>최저가</th>
        <th>사러가기</th>
      </tr>
      <NaverPageSearchAreaRow
        v-for="item in items"
        :money="item"
        :key="item.productId"
      ></NaverPageSearchAreaRow>
    </table>
  </div>
</template>

<style scoped></style>
