let user = { name: "ssafy", age: 12 };

for (let key in user) {
  console.log(key + ">>" + user[key]);
}

///////////////////////////////////////////////
let arr = [10, 20, 30];
for (let i = 0; i < array.length; i++) {
  console.log(array[i]);
}

for (let key of user) {
  console.log(key);
}

/////////////////////////////////////////////////
// String 이어붙이기
let msg1 = "이름:" + user["name"] + ", 나이:" + user["age"];
let msg2 = `이름: + ${uset.name} + , 나이: + ${uset.age}`;
