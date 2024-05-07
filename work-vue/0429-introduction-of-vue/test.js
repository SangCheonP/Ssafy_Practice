// let name = "박상천";

// console.log(name);

const user = {
  id: "ssafy",
  name: "박상천",
  age: 20,
  classNum: 15,
  info() {
    // concise method
    return this.name + "(" + this.id + ")님 나이" + this.age;
  },
};

// ES 5
// let id = user.id;
// let name = user.name;
// let age = user.age;

// ES 6 : 구조 분해 할당
let { id, name, age, classNum } = user;

console.log(id + " " + name + " " + age + " " + classNum);

// ES 5
// const user3 = {
//   userId: userId,
//   name: name,
//   age: age,
// };

// ES 6
const user3 = {
  userId,
  name,
  age,
};
