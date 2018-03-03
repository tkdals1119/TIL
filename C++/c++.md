# C++
* [동적할당](동적할당)
* [헤더파일](#헤더파일)
* [배열](#배열)
* [문자열](#문자열)
* [Tips](#Tips)
* [Error](#Error)

- ## 동적할당
  - c: (int*)malloc(sizeof(int*)배열이름)
  - c++: 간단하게 new 로 하면 됌(new와 delete는 c++ 기본 연산자이므로 헤더파일을 추가하지 않아도 됌)
    - `int *arr = new int[size]`(int형 size크기의 배열을 할당해서 그 주소를 arr에게 넘겨줌)

- ## 헤더파일
  - ### `#include <algorithm>`
    - max(), min()

- ## 배열
  - 정적할당: Stack // 동적할당: Heap
  - 1차 가변 배열 선언
```
int *arr;
arr = new int[num];
```
  - 2차 가변 배열 선언
```
/*메모리 할당*/
int **arr = new int*[Y];
for (i = 0; i < Y; ++i)
{
  arr[i] = new int[X];
  memset(arr[i], 0, sizeof(int) * X);
}

/*메모리 해제*/
for (i = 0; i < Y; ++i)
{
  delete [] arr;
}
delete [] arr;
```
  - 2차 가변 배열 파라미터 전달
```
void cal(int **arr) {}
int main()
{
  cal(arr);
}
```
  - 배열 크기
    - int 배열
      - `sizeof(arr)/sieof(int)`
    - char 배열
      - `sizeof(arr)`
    - **중요**
      - ### 동적 할당 받은 배열의 크기 구하기
      - `sizeof` 그 값을 컴파일 이전에 얻어 내는데 동적 메모리 할당은 컴파일 이후에 메모리를 할당하므로 **포인터의 크기인 4를 반환**
      - 동적메모리 할당을 받은 배열의 크기: **`_msize((void*)배열이름)` or `_msize((void*)arr)/sizeof(int)`**

- ## 문자열
  - ### 문자열 확장
    - `str = str + "abc";`
    - `str.append("abc");`

  - ### 문자열 길이
    - `str.size()`
    - `str.length()`

  - ### 문자열 길이2
    - `str.capacity()` => str 이 갖고 있는 길이 반환
    - `str.max_size()` => str 이 최대로 갖을 수 있는 길이 반환

  - ### 문자열의 문자 접근
    - `str.at(0)` => java의 **charAt** 기능과 동일함

  - ### 문자열 검색
    - `str.find("abc")` => "abc" 라는 문자열이 시작되는 위치 반환
```
if(str.find("abc"!=string::npos))
{
  // "abc"라는 문자열을 찾았을 때의 동작
}
```
    - => string::find() 함수는 찾는 단어나 문자열이 없으면 **string::npos** 를 리턴

  - ### 문자열 비교
```
if (myString.compare(myString2) == 0)
{
  // 두 문자열이 완전히 같은 문자열일때의 처리
}

else if (myString.compare(myString2) < 0)
{
  // myString의 문자열이 myString2보다 사전순으로 앞일 때 처리
}

else if (myString.compare(myString2) > 0)
{
  // myString의 문자열이 myString2보다 사전순으로 뒤일 때 처리
}
```

  - ### 문자열 대체
```
//myString의 “is” 문자열을 모두 “was”로 바꾸는 예제

string myString = “that is is is man”;
int pos;
string replaceString = “was”;

while( (pos = myString.find(“is”)) != string::npos)
{
  myString.replace(pos,replaceString.length(),replaceString);
}
```

- ## 형변환
  - ### char -> int
    - `int num = ch-'0'`

  - ### int -> string
```
string myString;
int myInt = 10;
myString = to_string(myInt) ;
```
  - ### string -> int
```
string myString = “55”;
int myInt ;
myInt = stoi(myString);
```
- ## Tips
  - ### const: 변수의 값이 상수임을 지정하고 프로그래머가 이 변수를 수정하지 못하게 함

  - ### 함수 원형을 선언하는 이유
    - 컴파일러와 직접적으로 관계가 있음
    - 컴파일러가 함수 원형을 근거로 데이터형을 비교함으로써 에러를 검출
    - 함수 원형이 함수로 인한 에러를 만들 확률을 낮춤

  - ### c++ 에서 printf를 사용하여 string 출력
    - `printf("%s\n", string.c_str())`

- ## Error
  - `'test' 식별자를 찾을 수 없습니다.` 라고 간혹 에러가 뜨곤 한다.
    - 해결1) **test()** 함수를 상단에 함수 원형으로 선언
    - 해결2) **test()** 함수를 호출하는 함수보다 **test()** 함수를 먼저 작성
      - 헤더로 따로 관리하지 않는 이상 모든 메소드는 순차적으로 접근하기 때문
