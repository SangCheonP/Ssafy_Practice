<script setup>
import { useNaverStore } from "@/stores/naver";
import { storeToRefs } from "pinia";

const naverStore = useNaverStore();
const { itemList, top3Items } = storeToRefs(naverStore);

import NaverPageSearchAreaRow from "./NaverPageSearchAreaRow.vue";
</script>

<template>
  <div>
    <table>
      <tr>
        <th>이미지</th>
        <th>제목</th>
        <th>최저가</th>
        <th>사러가기</th>
      </tr>
      <NaverPageSearchAreaRow
        v-for="item in itemList"
        :money="item"
        :key="item.productId"
      ></NaverPageSearchAreaRow>
    </table>
  </div>

  <div>
    <h2>아래는 최저가 3개입니다.</h2>
    <table>
      <tr>
        <th>이미지</th>
        <th>제목</th>
        <th>최저가</th>
        <th>사러가기</th>
      </tr>
      <NaverPageSearchAreaRow
        v-for="item in top3Items"
        :money="item"
        :key="item.productId"
      ></NaverPageSearchAreaRow>
    </table>
  </div>
</template>

<style scoped></style>
