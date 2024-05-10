<template>
  <div class="container">
    <header>
      <!-- Q1. Vue Router 에서 사용하는 Link 태그를 작성해보시오. -->
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/employee">직원목록</router-link> |
        <router-link to="/employee/insert">직원등록</router-link>
      </nav>
    </header>
    <RouterView />
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<style scoped>
.container {
  text-align: center;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  text-decoration: none;
  color: black;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
