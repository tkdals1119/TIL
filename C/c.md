# C

- #### 가변 배열 만들기
  ```
  int *arr;
  arr = (int*)malloc(sizeof(int)*크기);
  ```
- #### 배열 크기, 길이
  - 크기: sizeof(arr)
    - ex: int arr[3]일 때 4바이트가 3개 있으므로 12출력
  - 길이: sizeof(arr)/sizeof(int)  
    - ex: int arr[3]일 때 3출력

 - #### C언어는 자료형이 엄격하기 때문에 정수 나눗셈에서 소수점까지 출력하고 싶다면
 ```
 int a = 1;
 int b = 5;

 printf("%.2f", (double)a/(double)b); --> int형을 double로 캐스팅 한 후 나눗셈을 해야함(.2는 소수점 두번째 자리 까지 출력)

 ```
  - #### 여러 개 변수 동시 선언
    - `int a, b, c = 0;` (X)
    - `int a=0, b=c, c=0;` (O)

  - #### 기호 "%" 출력하기
    - `printf("%%\n");` => 퍼센트 기호 1개 출력하기
    - `printf("%%%%\n");` => 퍼센트 기호 2개 출력하기
    - `printf("%%%%%%\n");` => 퍼센트 기호 3개 출력하기

  - #### 전역변수
    - 전역변수는 따로 값을 지정하지 않고 선언하면 0으로 자동 초기화

  - #### 문자열 입력
    - `scanf("%s", arr);`
      - 공백이 있으면 입력을 멈춤
    - 공백이 포함된 문자열 입력
      - `scanf("%[^\n]", arr);`
      - `fgets(str_read, 100, stdin);`
        - str_read = 문자열이 저장되는곳
        - 100 = 크기. 즉 최대 99개의 문자를 저장
        - stdin = 표준입력

  - #### 문자열 비교
    - strcmp(str1, str2) => 두 개의 문자열이 같으면 0 반환
      - str1이 더 크면 양수 반환
      - str2이 더 크면 음수 반환

  - #### 문자열 길이
    - `str = strlen(arr);`
      - 'strlen'를 사용하려면 `#include <string.h>` 선언

  - #### int -> 문자열
    - `sprintf(ch, "%d", num);`
      - ch = 변환 된 문자열이 저장 될 배열
      - "%d" = 변환 할 데이터 타입
      - num = 변환 할 숫자가 담겨있는 변수

  - #### int->char, char->int
    - int->char: '0'을 더함
      - ex):
            ```
            int a = 5;
            char c;
            c = a+'0';
            ```
    - char->int: '0'을 뺌
      - ex):
            ```
            char c = '5';
            int a;
            a = c -'0';
            ```
## 알고리즘
```
> 그리드 알고리즘(탐욕 알고리즘, 욕심쟁이 알고리즘)
  - 간단히 말해서 최적의 해를 구하기 위해서는 첫 번째 활동이 최대한 일찍 끝나면 된다.
    - 오름 차순과 비슷하다고 보면 될 것 같다.

  - if(arr[i] > arr[i+1])
    {
      temp = arr[i];
      arr[i] = arr[i+1];
      arr[i+1] = temp;
    }
```

## Visual Studio
### Error
  - 간혹 **'미리 컴파일된 헤더를 찾는 동안 예기치 않은 파일의 끝이 나타났습니다.'** 라고 나오면 실행이 실패할 경우
    - 프로젝트명 오른쪽 마우스 클릭->속성->좌측메뉴중 C/C++클릭->미리 컴파일된 헤더->'미리 컴파일된 헤더 사용 안 함'으로 변경

  - scanf 오류
    - 블라블라 **'scanf' 선언을 참조하십시오.** 라고 빌드 실패가 나올 경우
      - 상단 `#include <stdio.h>` 위에 `#define _CRT_SECURE_NO_WARNINGS` 라고 선언하면 해결

  - `Run-Time Check Failure #2 – Stack around the variable ‘변수이름’ was corrupted.`
    - 사용자가 설정한 배열의 크기보다 더 큰것을 넣을려고 할때  위와 같은 에러가 발생

### 단축키
   - 주석달기 = CTRL + K + C
   - 주석해지 = CTRL + K + U
