# JAVASCRIPT

### 랜덤 정수 출력
  - `var num = Math.floor(Math.random()*(max- min))+min`
    -  **Math.round()** 사용하여 정수화하면 안됨. Math.round()를 사용하면 까지 10까지 나오는 것이 아니라 11까지 나오게 됨

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

### javascript / jquery / ajax
  - javascript : HTML의 단조로움을 벗어나게 하기 위한 수단 혹은 웹 언어의 근간이 되는 스크립트 언어
  - jquery : javascript의 사용을 좀 더 쉽게 해주기 위해 생긴 라이브러리
  - ajax : 비동기 통신을 위한 기술
    - http프로토콜은 기본적을 클라이언트 쪽에서 request를 보내고 server의 response를 받으면 이어졌던 연결이 끊기게 설계가 되어 있음
    - 페이지 일부분만 업데이트 할 시 굉장히 비효율적
    - XMLHttpRequest 객체를 통해(json이나 xml) 최소한의 필요한 데이터만 받아서 갱신
