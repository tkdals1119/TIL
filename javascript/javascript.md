# JAVASCRIPT

### 랜덤 정수 출력
  - `var num = Math.floor(Math.random()*(max- min))+min`
    -  **Math.floor()** 대신 Math.round()를 사용하여 정수화하면 안됨. Math.round()를 사용하면 까지 10까지 나오는 것이 아니라 11까지 나오게 됨

### 배열
  - 선언: `var arr = new Array()`
  - 모든 요소(/)로 구분: `var result = arr.join('/')`
  - 모든 요소 붙이기: `var result = arr.join('')`
  - 공백 문자로 요소 구분: `var result = arr.join(' ')`
  - 배열을 문자열로 변환 출력: `var result = arr.toString()`

### 중복 된 배열 요소 삭제
  - `var arr2 = arr.reduce(function(a,b){if(a.indexOf(b)<0)a.push(b);return a;},[])`

### 중복 요소 제거 + 순서 재정렬
  - `var arr2 = arr.slice().sort(function(a,b){return a - b}).reduce(function(a,b){if (a.slice(-1)[0] !== b) a.push(b);return a;},[])`

### null / undefinded / NAN
  - null : 변수가 정의 되지 않음
    - Number로 강제 형변환 하면 **0** 출력
  - undefined : 정의는 해놓았지만 값이 없음. 메모리 주소만 있고 내용물이 없다는 뜻
    - Number로 강제 형변환 하면 **NAN** 출력
  - NAN = not a number, 숫자가 아님
