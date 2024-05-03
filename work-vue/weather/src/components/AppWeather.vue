<script setup>
import { watch, ref } from "vue";

const ssafys = ref([
  { area: "서울", code: "1168064000" },
  { area: "광주", code: "2915573000" },
  { area: "구미", code: "4719060000" },
  { area: "대전", code: "3020052600" },
]);
const selArea = ref("");
const weathers = ref([]);

// TODO : watch (selArea가 변경되면(code의 길이가 10자리이면) 날씨 얻어 오기)
watch(selArea, async (newVal, oldVal) => {
  if (newVal.length === 10) {
    await getWeather(newVal);
  }
});
// TODO :
// method : getWeather >> fetch를 이용하여 날씨 얻어오기
// url : http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${val}
const getWeather = async (val) => {
  try {
    const response = await fetch(`http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${val}`);
    if (!response.ok) throw new Error("Network response was not ok.");
    const data = await response.text();
    makeList(data);
  } catch (error) {
    console.error("Failed to fetch weather: ", error);
  }
};

const makeList = (data) => {
  weathers.value = [];
  let parser = new DOMParser();
  const xml = parser.parseFromString(data, "application/xml");
  let datas = xml.querySelectorAll("data");
  datas.forEach((weather) => {
    // console.log(weather);
    let obj = new Object();
    obj.hour = weather.querySelector("hour").textContent;
    obj.icon = weather.querySelector("wfEn").textContent;
    obj.temp = weather.querySelector("temp").textContent;
    obj.wfKor = weather.querySelector("wfKor").textContent;
    obj.reh = weather.querySelector("reh").textContent;

    // TODO : weathers 배열에 obj 추가
    weathers.value.push(obj);
  });
};
</script>

<template>
  <div>
    <h2>SSAFY 캠퍼스 날씨</h2>
    <label for="area">캠퍼스 선택 : </label>
    <select id="area" v-model="selArea">
      <option v-for="(ssafy, index) in ssafys" :key="ssafy.code" :value="ssafy.code">
        {{ ssafy.area }}
      </option>
    </select>
    선택 캠퍼스 코드 : <input type="text" v-model="selArea" /><br /><br />
    <div v-if="weathers.length != 0">
      <table>
        <tr>
          <th>시간(시)</th>
          <th>아이콘</th>
          <th>온도(°C)</th>
          <th>날씨</th>
          <th>습도(%)</th>
        </tr>
        <tr v-for="(weather, index) in weathers" :key="index">
          <td>{{ weather.hour }}</td>
          <td><img :src="`./img/${weather.icon}.png`" alt="" /></td>
          <td>{{ weather.temp }}</td>
          <td>{{ weather.wfKor }}</td>
          <td>{{ weather.reh }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<style scoped>
table {
  width: 500px;
}
tr,
td {
  text-align: center;
}
th {
  border-bottom: 2px solid darkgray;
}
img {
  width: 80px;
}
</style>
