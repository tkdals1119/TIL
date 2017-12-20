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
 - equals 와 == 의 차이
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
