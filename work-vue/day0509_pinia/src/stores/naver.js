import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useNaverStore = defineStore("naverStroe", () => {
  const keyword = ref("");
  const itemList = ref([]);

  const top3Items = computed(() => {
    return itemList.value
      .slice()
      .sort((a, b) => {
        return a.lprice - b.lprice;
      })
      .slice(0, 3);
  });
  const search = () => {
    let url = "http://localhost:9999/naver/shop/json";
    axios.get(url + "?keyword=" + keyword.value).then((response) => {
      itemList.value = response.data.items;
    });
  };
  return { keyword, itemList, top3Items, search };
});
