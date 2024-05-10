<script setup>
//Q7. 업데이트 기능을 완성해봅시다.
//데이터는 store를 통해 바인딩 합니다.
import { useEmployeeStore } from "@/stores/employee";
import { storeToRefs } from "pinia";
const store = useEmployeeStore();

const employeeUpdate = function () {
  store.employeeUpdate();
};

const { employee } = storeToRefs(store);
</script>

<template>
  <div>
    <h4>직원 수정</h4>
    <div>
      <label for="name">이름 : </label>
      <input type="text" id="name" readonly v-model="employee.name" />
    </div>
    <div>
      <label for="position">직급 : </label>
      <input type="text" id="position" v-model="employee.position" />
    </div>
    <div>
      <label for="department">부서 : </label>
      <input type="text" id="department" v-model="employee.department" />
    </div>
    <div>
      <button @click="employeeUpdate">수정</button>
    </div>
  </div>
</template>

<style scoped></style>
