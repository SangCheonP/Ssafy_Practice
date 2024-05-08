<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const myClick = (type) => {
  console.log(type + "선택됨");

  if (type === "blog") {
    router.push({ name: type });
  } else if (type === "shop") {
    router.push({ path: "/bpage/" + type });
  } else if (type === "weather") {
    router.push("/bpage/weather");
  }
};
</script>

<template>
  <div>
    <h2>BPage Vue</h2>
    <button @click="myClick('blog')">블로그</button>
    <button @click="myClick('shop')">쇼핑</button>
    <button @click="myClick('weather')">날씨</button>
    <div class="a">
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>
* {
  width: 100%;
  height: 100%;
  background-color: gainsboro;
}

.a {
  width: 90%;
  height: 300px;
  background-color: cornflowerblue;
}
</style>
