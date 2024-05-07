<script setup>
import { ref, defineProps, watch, toRefs } from "vue";
import NaverPageSearchAreaRow from "./NaverPageSearchAreaRow.vue";
// import { toRefs } from "vue";

// const keyword = ref("");
const props = defineProps({
  naverKeyword: String,
});

const { naverKeyword } = toRefs(props);
const items = ref([]);

watch(naverKeyword, () => {
  alert("넘어옴" + naverKeyword.value);
  fetch("http://localhost:9999/naver/shop/json?keyword=" + props.naverKeyword.value)
    .then((resp) => resp.json())
    .then((data) => {
      console.log(data);
      items.value = data.items;
      // keyword.value = "";
    });
});
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
        v-for="item in items"
        :money="item"
        :key="item.productId"
      ></NaverPageSearchAreaRow>
    </table>
  </div>
</template>

<style scoped></style>
