<script setup>
import { RouterLink, RouterView } from "vue-router";
import { ref } from "vue";

const path = ref("");
if (true) {
  path.value = "apage";
}
</script>

<template>
  <div>
    <header>
      <nav>
        <RouterLink :to="`/${path}`">A</RouterLink>
        <RouterLink to="/bpage">B</RouterLink>
      </nav>
    </header>

    <RouterView />
  </div>
</template>

<style scoped></style>
