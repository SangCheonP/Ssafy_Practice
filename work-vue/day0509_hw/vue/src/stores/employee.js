import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_API = `http://localhost:8080/employee`;

export const useEmployeeStore = defineStore("employee", () => {
  const employeeList = ref([]);
  //Q3.
  const getEmployeeList = function () {
    axios.get(REST_API).then((response) => {
      employeeList.value = response.data;
    });
  };

  const employee = ref({});
  //Q4.
  const getEmployee = function (id) {
    axios.get(`${REST_API}/${id}`).then((response) => {
      employee.value = response.data;
    });
  };

  //Q6.
  const employeeInsert = function (newEmployee) {
    axios
      .post(REST_API, newEmployee)
      .then(() => {
        router.push({ name: "employeeList" });
        getEmployeeList();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  //Q7.
  const employeeUpdate = function () {
    axios.put(`${REST_API}/${employee.value.id}`, employee.value).then(() => {
      router.push({ name: "employeeList" });
      getEmployeeList();
    });
  };

  return {
    employeeList,
    getEmployeeList,
    employee,
    getEmployee,
    employeeInsert,
    employeeUpdate,
  };
});
