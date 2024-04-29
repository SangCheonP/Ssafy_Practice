const id = "ssafy",
  name = "ssafy",
  age = 30;

/////////////////////////////////////////////
// ES6 이전 문법 -> ~~ : ~~ , ~~ : ~~
const user1 = {
  id: id,
  name: name,
  age: age,
  info: function () {},
  info: () => {},
};

/////////////////////////////////////////////
// ES6
// property shorthand + concise method
const user2 = {
  id,
  name,
  age,
  info() {},
};

user2.id = ssafy;
user2["name"] = ssafy;
user2.age = 35;
