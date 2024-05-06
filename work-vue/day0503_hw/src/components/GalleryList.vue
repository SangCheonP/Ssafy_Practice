<script setup>
import {ref} from "vue";
import GalleryListItem from "./GalleryListItem.vue";

const numberOfItems = ref(4);
</script>

<template>
  <div>
    <main>
      <div class="container">
        <div class="row justify-content">
          <GalleryListItem v-for="n in numberOfItems" :key="n" />
        </div>
      </div>
    </main>
  </div>
</template>

<style scoped></style>
