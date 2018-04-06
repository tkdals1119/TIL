# C++
* [STL](#STL)
* [Map](#Map)
* [동적할당](#동적할당)
* [헤더파일](#헤더파일)
* [배열](#배열)
* [문자열](#문자열)
* [포인터](#포인터)
* [정렬](#정렬)
* [형변환](#형변환)
* [랜덤정수](#랜덤정수)
* [팁](#팁)
* [에러](#에러)

- ## STL
  - STL: 표준 C++ 라이브러리(Standard Template Library)
  - 프로그램에 필요한 자료구조와 알고리즘을 Template로 제공하는 라이브러리
  - 구성요소
    - Container
      - 객체를 저장하는 객체, 자료구조 라고도 함. 클래스 템플릿으로 구현되어 있음
      - container는 크게 sequence container(array, vector, list, deque), associative container(set, multiset, map, multimap)로 나뉨
    - Iterator
      - 포인터와 비슷한 개념으로 컨테이너의 원소를 가리키고, 가리키는 원소에 접근하여 다음 원소를 가리키는 기능. 순회
    - Algorithm
      - 정렬, 삭제, 검색, 연산 등을 해결하는 일반화된 방법을 제공하는 함수 템플릿
    - Function Object
      - 함수처럼 동작하는 객체로 operator() 연산자를 오버로딩 한 객체
      - 컨테이너와 알고리즘 등에 클라이언트 정책을 반영하게 함
    - Container Adapter
      - 구성요소의 인터페이스를 변경해 새로운 인터페이스를 갖는 구성요소로 변경(stack, queue, priority_queue)
    - Allocator
      - 컨테이너의 메모리 할당 정책을 캡슐화한 클래스 객체로 모든 컨테이너는 자신만의 할당기를 가지고 있음

- ## Map
  - 특징: 자동 정렬
  - 선언방법: `map<KeyType, ValueType> 변수이름;`
  - 입력
    - insert: `map.insert(pair<KeyType, ValueType>(KeyValue, Value))`
      - insert를 통해 값의 쌍을 넘겨주어야 하는데 따로 struct를 만들필요 없이 pair을 통해 값의 쌍을 묶어서 만든다음에 map 에 넘기는 방식
    - map[KeyValue] = Value **(이미 value가 있는 key 값에 쓸 경우 덮어짐)**
  - 제거
    - `map.erase(Key)`
  - 탐색
    - `if(map.count("abc")!=0) printf("Yes!\n");`
      - count 함수는 요소의 개수를 리턴함. map의 경우 0 or 1을 리턴하고 multimap은 하나의 키값에 여러개의 요소를 가질 수 있으므로 그 개수를 리턴함
  - 모든 요소 탐색
```
map<int ,int> iMap;
map<int, int>::iterator itMap;

for(itMap=iMap.begin(); itMap!=iMap; itMap++)
{
  printf("%d, %d\n", itMap->first, itMap->second);
}

```

- ## 동적할당
  - c: (int*)malloc(sizeof(int*)배열이름)
  - c++: 간단하게 new 로 하면 됌(new와 delete는 c++ 기본 연산자이므로 헤더파일을 추가하지 않아도 됌)
    - `int *arr = new int[size]`(int형 size크기의 배열을 할당해서 그 주소를 arr에게 넘겨줌)

- ## 헤더파일
  - `<iostream>` -> Input/Out Stream(입출력 스트림)
    - C++ 표준 라이브러리 중의 하나인 입출력을 위한 헤더파일
  - `<iostream.h>` -> 구버전, `<iostream>` -> 신버전
  - c에서 사용하던 헤더를 가져오려면 `<cstdio>` 선언
  - `include <algorithm>`
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
  - ### **char *str** 와 **char str[]** 의 차이
    - **char *str** : 문자열 상수의 주소를 담음( 부분 수정 안됌 )
    - **char str[]** : 문자열 값을 담음 ( 수정 가능 )
  - ### 문자열 입출력
```
#include <string>
int main()
{
	string st; cin >> st;
	printf("%s\n", st.c_str());
	return 0;
}
```
  - ### 공백을 포함한 문자열 입출력
```
#include <string> => 'getline' 함수를 사용하려면 헤더를 선언해야함
#include <cstring> => c언어 형식의 입출력 사용 시 선언

string str;
getline(cin, str);

printf("%s\n", str.c_str());

```
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
- ### 문자열과 문자 배열
  - 생성
    - `char arr[SIZE];`
    - `string s;`
  - 입력
    - `cin >> arr;`
    - `cin >> s;`
  - 문자열 개수
    - `int size = strlen(arr);` => `strlen()` 함수를 사용하려면 `#include <cstring>` 추가
    - `int size = s.length();`
  - 출력
    - `cout >> arr;` // `for(int i=0; i<strlen(arr); i++) cout << arr[i]`
    - `cout >> s;` // `for(int i=0; i<strlen(arr); i++) cout << s[i]`

- ## 포인터
  - 포인터: 주소 값 저장
```
int a = 10;
int *b = &a;

printf("%d\n", b) => a의 주소값 출력
printf("%d\n", *b) => a의 값 출력
```
  - 레퍼런스: 값 저장
```
int a = 10;
int &b = a;
b = 20;

printf("%d\n", a) => 20 출력

> 일반적으로 변수를 선언한다는 것은 '해당 주소'와 '이름표(a)' 가 하나씩 만들어지는 것이다. 레퍼런스 변수는 해당 주소에 이름표를 두 개(a, b)를 만들어 준다는 것이다.
즉, b의 값을 변경하면 a의 값도 변경된다.

```
  - 포인터 연결
    - 하나의 포인터 연결
```
int a = 10;
int *b = &a; => b에는 a의 주소값 저장. *b는 a의 주소에 저장 된 값
int *bb = b; => bb에는 b에 저장 된 a의 주소값. *bb는 b에 저장 된 a의 주소에 저장 된 값
```

    - 하나의 포인터를 다중포인터로 연결
```
int a = 10;
int *b = &a;
int **bb = &b;

printf("a의 주소 %d\n", &a); => 7339596
printf("b의 주소 %d\n", &b); => 7339584

printf("&bb: %d\n", &bb); => bb 자신의 주소(7339576)
printf("bb: %d\n", bb); => b의 주소(7339584)
printf("*bb: %d\n", *bb); => b가 가리키는 주소(a 주소)(7339596)
printf("**bb: %d\n", **bb); => a의 값(10)

```

- ## 정렬
  - 오름차순(algorithm 헤더파일의 sort 함수 사용)
```
#include <algorithm> => sort 함수를 사용하기 위해 algorithm 헤더 선언

int tc;
cin >> tc;
int *arr = new int[tc];

sort(arr, arr+tc); => 오름차순 정렬
```

  - 내림차순(functional 헤더파일의 greater<자료형>()사용)
```
#include <algorithm>
#include <functional> => greater<자료형>() 을 사용하기 위해 functional 헤더 선언

int tc;
cin >> tc;
int *arr = new int[tc];

sort(arr, arr+tc, greater<int>()); => 내림차순 정렬
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

- ## 랜덤정수
  - 1~100
```
#include <cstdlib>

printf("%d\n", (rand()%100)+1);

```

- ## 팁
  - ### const: 변수의 값이 상수임을 지정하고 프로그래머가 이 변수를 수정하지 못하게 함
  - ### 함수 원형을 선언하는 이유
    - 컴파일러와 직접적으로 관계가 있음
    - 컴파일러가 함수 원형을 근거로 데이터형을 비교함으로써 에러를 검출
    - 함수 원형이 함수로 인한 에러를 만들 확률을 낮춤

  - ### c++ 에서 printf를 사용하여 string 출력
    - `printf("%s\n", string.c_str())`

  - ### 출력 속도
    - 정석: **cin&cout** 보다 **scanf&printf** 가 빠름
    - 편의: **cin&printf**
    - **endl** 많이 느림. **\n** 사용
    - 입출력이 많을 시
```
ios_base::sync_with_stdio(false);
cin.tie(NULL);
cout.tie(NULL);
를 선언하고 cin&cout 사용

> 대신 C 표준 입출력 함수와 혼용하여 사용하지 말 것
```

  - **namespace(이름공간)** 의 의미: 특정 영역(공간)의 범위를 지정하고 이름을 붙여준 것
```
#include <iostream>
void function(void) { std::cout << "A.com에서 정의한 함수 " << std::endl; }
void function(void) { std::cout << "B.com에서 정의한 함수 " << std::endl; }

int main(void)
{
      function();
      return  0;
}
> 위 경우 function 의 이름이 같아 컴파일 시 문제가 발생함


> 해결 방법
#include <iostream>
namespace A_COM // => A_COM이라는 이름의 공간을 구성하겠다는 의미
{
       void function(void) { std::cout << "A.com에서 정의한 함수 " << std::endl; }
}

namespace B_COM
{
       void function(void) { std::cout << "B.com에서 정의한 함수 " << std::endl; }
}

int main(void)
{
      A_COM:: function(); // => A_COM 이라는 이름 공간안에 선언되어 있는 function 함수를 호출하라
      B_COM:: function();
      return  0;
}


번외) std::cout => std 라는 네임스페이스(namespace) 안에 선언 및 정의가 되어있는 cout을 참조하겠다는 의미로 해석할 수 있음
      출력을 위해 매번 **std::cout** 하기 번거로우므로 **using namespace std** 선언
```

- ## 에러
  - `'test' 식별자를 찾을 수 없습니다.` 라고 간혹 에러가 뜨곤 한다.
    - 해결1) **test()** 함수를 상단에 함수 원형으로 선언
    - 해결2) **test()** 함수를 호출하는 함수보다 **test()** 함수를 먼저 작성
      - 헤더로 따로 관리하지 않는 이상 모든 메소드는 순차적으로 접근하기 때문
