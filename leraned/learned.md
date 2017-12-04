### URL 과 URI 의 차이
  - URI(Uniform Resource Identifier): 주소가 가리키는게 자원임(Apache, Tomcat 등)
    - URI = URL + URN(Uniform Resource Name)
  - URL(Uniform Resource Locator): 주소가 가리키는게 파일임
    - 모든 URL은 URI 이다.

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
