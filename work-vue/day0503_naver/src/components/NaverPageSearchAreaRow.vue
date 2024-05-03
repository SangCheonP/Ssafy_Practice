<script setup>
defineProps({ money: Object });
</script>

<template>
  <tr>
    <td><img :src="money.image" width="150px" height="170px" /></td>
    <td v-html="money.title"></td>
    <td>{{ money.lprice }}</td>
    <td><a :href="money.link">바로가기</a></td>
  </tr>
</template>

<style scoped>
td {
  background-color: orange;
}
</style>
