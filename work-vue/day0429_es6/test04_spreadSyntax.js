const nums = [10, 20, 30, 40];

// 얕은 복사(주소값 복사)
const copy1 = nums;
copy1[0] = 999;
console.log(nums);
console.log(copy1);

// 깊은 복사
const copy2 = [];
for (let n of nums) {
  copy2.push(n);
}

///////////////////////////////////////////////
const copy3 = [...nums];
