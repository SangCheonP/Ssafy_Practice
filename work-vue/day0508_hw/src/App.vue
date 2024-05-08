<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <div class="container">
    <header class="header">
      <h1>Quiz 퀴즈</h1>
      <p>여기는 퀴즈의 나라! 놀라운 퀴즈들이 기다리고 있어요. 지금 바로 도전해보세요!</p>
    </header>
    <nav class="navigation">
      <RouterLink class="nav-link" to="/">Home</RouterLink>
      <RouterLink class="nav-link" to="/quiz">Quiz</RouterLink>
    </nav>
    <router-view></router-view>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  background-color: gainsboro;
}

.header {
  text-align: center;
  margin-bottom: 20px;
}

.header > h1 {
  background-color: coral;
}

.navigation {
  display: flex;
  flex-direction: row;
  margin-top: 10px;
}

.nav-link {
  padding: 10px;
  text-decoration: none;
  color: #333;
  background-color: #f4f4f4;
  border-radius: 5px;
}

.nav-link:hover {
  background-color: #e9e9e9;
}
</style>
