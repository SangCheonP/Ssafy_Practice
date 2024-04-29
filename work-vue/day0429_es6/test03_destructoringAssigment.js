let user = { id: "ssafy", name: "ssafy", age: 10, phone: "010-1232-5555" };

///////////////////////////////////// 일일이 뽑아 쓰기
function print1(data) {
  console.log("print1>" + data["id"] + "," + data["name"]);
}

print1(user);

////////////////////////////////////// 받자마자 분해
function print2({ id, name }) {
  console.log("print2>" + id + "," + name);
}
print2(user);

let { age, phone } = user;

///////////////////////////////////////////
function lib() {
  return { title: "title", author: "author", price: 20000 };
}

let { title: t, price: p } = lib();

///////////////////////////////////////////
<script type="module">
  import {(name, say)} from "test03_export.js"; console.log(`내 이름은 ${name}`) say()
</script>;
