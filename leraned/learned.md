### 절차지향 vs 객체지향
  - 절차지향: 물이 위에서 아래로 흐르는 것처럼 순차적인 처리가 중요시 되며 프로그램 전체가 유기적으로 연결되도록 만드는 프로그래밍 기법
  - 객체지향: 정의를 살펴보면 객체지향이란 실제 세계를 모델링하여 소프트웨어를 개발하는 방법. 데이터와 절차를 하나의 덩어리로 묶어서 생각
    - 특성: 캡슐회, 상속, 다형성
### URL 과 URI 의 차이
  - URI(Uniform Resource Identifier): 주소가 가리키는게 자원임(Apache, Tomcat 등)
    - URI = URL + URN(Uniform Resource Name)
  - URL(Uniform Resource Locator): 주소가 가리키는게 파일임
    - 모든 URL은 URI 임.

### http 와 https 의 차이
   - http: HyperText Transfer Protocol
     - https 보다 빠르지만 보안이 뚫리면 정보가 쉽게 유출 됨
   - https: HyperText Transfer Protocol over **Secure sockets layer**
     - http 보다 약간 느리지만 데이터를 암호화해주는 프로토콜인 **SSL** 이 합쳐져서 보안성이 좋음
     - SSL: Secure sockets layer

### 프레임워크
   - 설계의 기반이 되는 부분을 기술한  확장 가능한 기반 코드와 사용자가 이 코드를 자기 입맛대로 확장하는 데 필요한 라이브러리 이 두 가지 요소가 통합되어 제공되는 형태
      - ex) Ruby: 애자일 방식에 어울리는 웹 프로그래밍 언어
         - Ruby On Rails: Ruby의 웹 프로그래밍 **프레임워크**

### 개발 방식
   - 폭포수 모델: 하나의 단계가 완전히 끝난 후 다음 단계로 넘어가고 다음 단계에서 전 단계로 돌아갈 수 없는 프로세스
      - ex) 계획-요구분석-설계-구현-테스트-유지보수
   - 애자일 모델: 폭포수 모델의 많은 문제점을 해결하기 위해 등장. 코드를 수정해가면서 단계가 진행 됨
      - ex) 익스트림 프로그래밍(Extreme Programming, XP): 클라이언트와 함께 2주 정도의 반복 개발을 하고, 테스트와 우선 개발을 함

### 프로토콜
   - 어떤 시스템이 다른 시스템과 통신을 원활하게 수용하도록 해주는 통신 규약, 약속
      - ex) TCP/IP(Transmission Control Protocol / Internet Protocol): 컴퓨터와 컴퓨터가 통신 회선 등으로 연결 하기 위한 통신 규약

### RESTful
   - REpresentational State Transfer
   - 우리가 URL을 통해 서버에게서 얻는 웹 페이지를 일종의 자원이라고 보았을 때, URI가 자원이 되고 URI에 접근하는 Method(GET, POST, PUT, DELETE)를 바탕으로 자원을 사용하는 자원 기반의 구조를 만드는 것

### Overloading vs Overriding
   - Overloading: 같은 이름의 메소드를 여러 개 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
   - Overriding: 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의 해서 사용

### Call by Value vs Call by Reference
   - Call by Value: 값에 의한 호출(**java는 항상 call by value**)
```
void swap(int a, int b){
  int tmp = a;
  a = b;
  b = tmp;
}
int main(int argc, char** argv){
  int x=10, y=20;
  swap(x,y);
  printf("x=%d, y=%d\n", x, y);
  return;
}
==> 10, 20
```
   - Call by Reference: 참조에 의한 호출
```
void swap(int* a, int* b){
  int tmp = *a;
  *a = *b;
  *b = tmp;
}
int main(int argc, char** argv){
  int x=10, y=20;
  swap(x,y);
  printf("x=%d, y=%d\n", x, y);
  return;
}
==> 20, 10
```
### Vector vs ArrayList vs Linkedlist vs map
   - Vector: **동적 배열** 로써 미리 일정크기의 메모리를 할당해 놓고 그 이상의 값들이 추가되면 새로운 더 큰 메모리를 할당함
      - 장점: 어떤 종류의 객체도 담을 수 있음. 대용량의 데이터를 효과적으로 다룰 수 있음.
      - 단점: 무조건 **동기화** 이기 때문에 단일 스레드 처리에서는 ArrayList나 LinkedList 보다 성능이 떨어짐. **끝 위치가 아닌 곳** 에서 삽입 / 제거 수행 시 성능 저하
         - 동기화: 특정 스레드가 공유자원에 접근하고 있을 때 작업이 끝나기 전까진 다른 스레드가 접근할 수 없음

   - ArrayList: 배열의 복사에 의한 데이터 저장처리를 내부적으로 행함
      - 장점: 각 데이터에 대한 **인덱스** 를 갖고 있기 때문에 **검색이 용이함**
      - 단점: 많은 데이터의 추가 / 삭제시에는 배열의 복사가 빈번하게 일어나기 때문에 성능 저하

   - LinkedList: 다음 자료의 **위치정보** 를 갖고 있음
      - 장점: 데이터의 추가 / 삭제는 위치정보의 수정만으로 가능하기 때문에 많은 정보의 추가 / 삭제 처리 용이
      - 단점: 데이터가 많은 경우 내부적인 인덱스는 갖고 있지 않기 때문에 검색 시 처음 자료로부터 순차적으로 찾아 나가야 하기 때문에 성능 저하

   - map: key, value가 한쌍. 트리구조
      - 장점: **검색 속도** 가 일렬 방식(list, vector)보다 빠름
      - 단점: 삽입 / 삭제가 빈번할 경우 성능 저하(매번 정렬하기 때문)
         - hash_map
            - 장점: 많은 자료를 저장하고 있어도 검색이 빠름
            - 단점: 자료가 적으면 **메모리 낭비** 와 검색시 **오버헤드** 발생. 매번 정렬은 안하지만 추가 / 삭제는 일렬 방식(list, vector) 이 빠름

   - #### **정리**
      - 순서와 상관없거나 순차적으로만 추가, 삭제되는 데이터는 **vector** 를 사용하는게 좋음
      - 순서가 중요하여 리스트의 중간위치에 값이 추가, 삭제가 되는 경우 **list** 를 사용하는게 좋음

### 런타임 에러 vs 컴파일타임 에러 vs 논리 에러
  - 런타임 에러: 프로그램의 설계 미숙으로 발생하며 간혹 기계적 결함으로도 발생
    - ex: 무한 루프
  - 컴파일타임 에러: 주로 문법 오류로 발생. 컴파일 되지 않고 Warning 혹은 Error 발생
  - 논리 에러: 프로그래머가 의도하지 않은대로 결과가 나오는 경우

### 배열 vs 리스트
  - **동일한 특성의 데이터들을 한데 모아 처리할 수 있는 장점**
    - 배열
      - CPU의 처리 속도가 리스트보다 빠름
      - 삽입 할 위치에 있던 기존의 데이터를 그냥 덮어 쓰는 경우
      - 삭제되고 남아 있는 공간을 그대로 두는 경우
    - 리스트
      - 프로그램 실행 중 크기를 자유자재로 변경할 수 있음
      - 삽입 위치의 데이터와 그 이후의 데이터를 한 칸씩 뒤로 밀어서 삽입할 공간을 만들어야 하는 경우
      - 삭제 위치 이후의 데이터들을 한 칸씩 앞으로 밀어서 삭제 된 공간을 메워야 하는 경우
