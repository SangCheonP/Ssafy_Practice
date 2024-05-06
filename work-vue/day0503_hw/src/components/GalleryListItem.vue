<script setup>
import GalleryListItemButton from './GalleryListItemButton.vue';
</script>

<template>
    <div class="col-md-4">
            <div class="card">
              <img class="card-img-top" src="../assets/sample.png" alt="" />
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </p>
                <GalleryListItemButton></GalleryListItemButton>
              </div>
            </div>
          </div>
</template>

<style scoped>

.card{
    margin: 10px 0;
}


</style>