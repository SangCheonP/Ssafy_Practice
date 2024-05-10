<script setup>
import { computed } from "vue";
const props = defineProps({
  attration: Object,
});
const image = computed(() => {
  return props.attration.firstimage ? props.attration.firstimage : "/src/assets/no-image.png";
});
</script>

<template>
  <div class="card" style="width: 18rem">
    <img :src="image" class="card-img-top" alt="..." width="100%" height="200px" />
    <div class="card-body">
      <h5 class="card-title">{{ props.attration.title }}</h5>
      <p class="card-text">주소 : {{ props.attration.addr1 }}</p>
      <p class="card-text">유형 : {{ props.attration.contenttypeid }}</p>
      <p class="card-text">위도 : {{ props.attration.mapy }}</p>
      <p class="card-text">경도 : {{ props.attration.mapx }}</p>
      <a href="#" class="btn btn-primary">Go Home</a>
    </div>
  </div>
</template>

<style scoped></style>
