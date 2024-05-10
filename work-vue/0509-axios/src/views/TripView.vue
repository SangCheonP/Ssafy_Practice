<script setup>
import VCard from "@/components/VCard.vue";
import { ref } from "vue";
import axios from "axios";
// const attractionName = ref("");
// const url =
//   "https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=SWASJPbuAU0D61k97THb8ScGih4OhO%2FUfIZ99OBzuDh2Cg88jAvhXBY83JUPiFi1GiQxF%2B4K0Xa%2Fdi%2BEl%2BsKdg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&keyword=%EA%B0%95%EC%9B%90&contentTypeId=12";
// console.log(import.meta.env);
const { VITE_OPEN_API_SERVICE_KEY, VITE_SEARCH_TRIP_URL } = import.meta.env;
const params = ref({
  serviceKey: VITE_OPEN_API_SERVICE_KEY,
  numOfRows: 10,
  pageNo: 1,
  MobileOS: "ETC",
  MobileApp: "AppTest",
  _type: "json",
  keyword: "",
});
const loadingImg = ref("");
const attractions = ref([]);
const searchAttraction = () => {
  axios.get(VITE_SEARCH_TRIP_URL, { params: params.value }).then(({ data }) => {
    attractions.value = data.response.body.items.item;
    console.log(attractions.value);
  });
};
//요청 인터셉터
axios.interceptors.request.use(
  function (config) {
    loadingImg.value = "loading.png";
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);
//응답 인터셉터
axios.interceptors.response.use(
  function (response) {
    loadingImg.value = "";
    return response;
  },
  function (error) {
    return Promise.reject(error);
  }
);
</script>

<template>
  <div class="container-fluid">
    <div class="alert alert-primary text-center fw-bold display-6 mt-3" role="alert">
      관광지 목록
    </div>
    <div class="row g-3 align-items-center justify-content-center mb-3">
      <div class="col-auto">
        <label for="attractionName" class="form-label">관광지명</label>
      </div>
      <div class="col-auto">
        <input type="text" id="attractionName" class="form-control" v-model="params.keyword" />
      </div>
      <div class="col-auto">
        <button type="button" class="btn btn-primary" @click="searchAttraction">검색</button>
      </div>
    </div>
    <div class="row" v-if="loadingImg !== ''">
      <img src="@/assets/loading.gif" alt="" />
    </div>
    <div class="row" v-else>
      <VCard v-for="att in attractions" :key="att.contentid" :attration="att" />
    </div>
  </div>
</template>

<style scoped></style>
