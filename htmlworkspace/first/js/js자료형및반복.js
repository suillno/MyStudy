// 자료형
/* undefinded, number,bigint,boolean,string,object,function
        object : primitive type과 달리 다양한 데이터를 담을수 있다.
        중괄호를 {}사용해서 만든다
        {key : value} 쌍으로 구성된 프로퍼티를 여러개 넣을수 있다.*/
/* let user = new Object(); //생성자 문법
      let user2 = {}; // 객체 리터럴 문법 */

// 오브젝트는 상수로 선언해도 값 변경이 가능하다.
let user = {
  name: "이순신",
  age: 300,
  "good day": true,
};
// 값 호출
console.log(user.name);

// 값 변경
user.age = 400;
console.log(user.age);
// 공백 이 있는 키는 []로 호출한다.
console.log(user["good day"]);

// 함수호출시 오브젝트 반환 - 키 벨류가 동일하면 단축해서 사용가능하다
function makeUser(name, age) {
  return {
    name,
    age,
  };
}

let user2 = makeUser("김유신", 120);
// 오브젝트 호출
console.table(user2);
// 오브젝트내 property 여부 확인 및 삭제
console.log("name" in user);
delete user.name;
console.log("name" in user);

console.log(user.name === undefined);
console.log(user.address === undefined);
// 변수 key 안에 user의 끝까지 반복하여 담는다
for (let key in user) {
  console.log(key);
  console.log(user[key]);
}

// closure 지역함수를 외부에서 호출해도 접근할수있게 해주는 기능
function makeCount() {
  let count = 0;
  return function () {
    count++;
    return count;
  };
}
const counter = makeCount();
console.log(counter());
console.log(counter());

const sals = {
  john: 100,
  ann: 150,
  jane: 130,
};
// 팀원의 급여 합을 구하고 그값을 sum에 저장 sals가 비어 있으면 sum에 0을 저장
let sum = 0;
for (let res in sals) {
  sum += sals[res];
}
console.log(sum);

// 객체 obj의 프로퍼티 값이 숫자인경우 그 값을 2배로 해주는 함수
// multi(obj)를 만들어라
const menu = {
  width: 200,
  height: 300,
  title: "my menu",
};
console.log(menu.height);
function multi(obj) {
  for (let item in obj) {
    if (typeof obj[item] === "number") obj[item] *= 2;
  }
}
multi(menu);
console.table(menu);
