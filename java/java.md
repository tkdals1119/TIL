# java

- ### String 객체의 널체크
   - `if(str==null)`
   - **isEmpty** 는 객체의 null 판별이 아니라 객체의 값 유무를 판별
```
  String str1 = "";
  String str2 = null;
  String st3 = " ";

  if(str1.isEmpty()) -> true
  if(str2.isEmpty()) -> NullException
  if(str3.isEmpty()) -> false

  if(str1.length()) -> true
  if(str2.length()) -> NullException
  if(str3.length()) -> false

  if(str1.equals("")) -> true
  if(str2.equals("")) -> NullException

  if(str1==null) -> false
  if(str2==null) -> true
```
 - ### equals 와 == 의 차이
   - equals: 두 객체가 담고 있는 내용을 비교
   - ==: 두 객체를 비교(같은 객체를 참고하고 있는지)
```
  String str1 = new String("this");
  String str2 = new String("this");

  str1.equals(str2)-> true
  str1==str2 -> false
```

```
  String str1 = new String("this");
  String str2 = str1;

  str1.equals(str2)-> true
  str1==str2 -> true
```

- ### 형변환
  - int -> String
    - `String str = Integer.toString(i);`
    - `String str = "" + i;`

  - char -> int
    - `char ch = '9';`
    - `int num = ch-'0';`

  - int -> double
    - `int a=10;`
    - `double d = (double)a;`

  - String -> int
    - `int i = Integer.parserInt(str);`
    - `int i = Integer.valueOf(str).intValue();`

  - double -> String
    - `String str = Double.toString(d);`

  - long -> String
    - `String str = Long.toString(l);`

  - Integer -> boolean
    - `boolean b = (i != 0);`

  - boolean -> Integer
    - `int i = (b)? 1 : 0;`

- ### 랜덤 숫자 출력
  - `Random random = new Random();`
    - `int a = random.nextInt(범위)`
  - `double random2 = Math.random()`
    - `int a = (int)(random2*100)+10`
      - ex: 100=max, 10=min  

- ### 배열 초기화
  - `Arrays.fill(배열이름, 숫자/true/false);`
- ### hasNextLine()
  - 다음 행이 존재하는지 판별하여 true / false 반환

- ### next() vs nextLine()
  - next(): 문자 또는 문자열을 공백을 기준으로 한 단어 또는 한 문자씩 입력 받음
    - ex: "hello world" 입력 시 **hello** 출력. 공백을 기준으로 하기 때문.
  - nextLine(): 문자 또는 문장 한 라인 전체를 입력 받음
    - ex: "hello world" 입력 시 **hello world** 출력
  - 숫자 두 개를 공백 기준으로 한 줄에 입력할 시
    - ex: `str1 = sc.next(); str2 = sc.next();`

- ### toCharArray
  - ex: `char ch[] = str.toCharArray();`
  - 문자열을 배열로 저장

- ### 문자열에서 특정 문자열 검색
  - `str.matches(".*블라블라.*")`
  - 대소문자 구분없이 검색 ``str.matches("(?!).*블라블라.*")``
  
- ### toLowerCase
  - ex: `str = str.toLowerCase();`
  - 문자열에 있는 문자를 모두 소문자로 변환

- ### 소문자알파벳 - 97
  - 해당 알파벳이 몇 번째 알파벳인지 나타냄
  - 대문자 알파벳 + 32 = 소문자

- ### charAt(인수), indexOf(문자), substring(인수, 인수), length()
  - charAt(인수): 인수 번째의 문자를 읽음
    - 문자열에 한글자씩 접근하고자 할 때 CharAt 사용
    - ex: "abcde".charAt(1) -> **b**
    - ex: "12345".charAt(2)-'0' -> **3**
      - **-'0'** 은 int를 반환함

  - indexOf(문자)
    - 해당 문자가 들어있는 위치를 반환함(문자가 없으면 **-1** 를 반환)
      - ex: "abcde".indexOf("e") -> **4**

  - substring(인수, 인수)
    - charAt은 문자하나를 읽지만 substring은 문자열을 읽음
      - ex: "abcde".substring(1, 3) -> **bc**

  - length()
    - 인수의 길이를 반환
      - ex:
          ```
          String str="abcd";
          int i=str.length();
          System.out.println(i);
          --> 4
          ```
