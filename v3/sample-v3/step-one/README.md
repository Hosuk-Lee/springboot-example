# Step One

## Goal

- 프로젝트 설정

### 프로젝트 설정

1. Application 구조
2. Database
3. Logging
4. Security
5. Test
6. Document


1. 자바 어플리케이션 개발 표준
    1. 자바프로그램구조
    2. 코드컨벤션 . . . .
        * 파일주석
            - 파일에 정의되어 있는 클래스 혹은 인터페이스의 이름을 기술한다.
            - 파일명, 작성자, 작성일 등이 기술되어야 한다.
        * 클래스 설명 주석
            - import문 다음에 기술한다.
            - 설명 주석 형식은 블록 주석(/**……*/)을 사용한다.
            - 설명 주석 안의 각 라인은 * 로 시작한다.
            - 이 부분은 API Document에 출력되어야 하는 부분으로 Class 정의 바로 위 부분에 기술 되어야 한다.
            - 해당 클래스에 대한 기능과 용도를 간략하게 기술한다.
            - 데이터베이스 처리와 관련된 클래스에는(예, DAO: Data Access Object) 관련된 테이블 명을 기술한다.
            - I/O처리와 관련된 파일명을 기술하고 설명한다.
            - Constructor, Interface, Key Class에는 documentation을 하지 않는다. 단, constructor가 멤버변수를 set하는 역할이외의 처리를 수행하는 경우에는
              documentation을 하는 것으로 한다.
            - Extends, Implements, 관련 Bean 등 메소드 선언부 또는 import문을 통해서 알 수 있는 정보는 documentation에 표현하지 않는다
        * 멤버 변수 설명 주석
            - 클래스내의 선언부에 기술된 변수는 해당 라인 뒤에 “//”를 사용하여 comment를 기술한다.
            - 멤버 변수 기술 순서는 constant > static > primitive > reference 변수 순으로 한다.
        * 멤버 함수 설명 주석
            - 메소드의 바로 앞에 기술되며, 메소드의 기능에 대해 간단히 설명하도록 한다.
            - 주석 형식은 블록 주석(/** ... */)을 사용하며, 수정내역이 별도로 관리 되도록 한다.
            - Parameters – type과 변수명을 적고 간략하게 설명하고, 없으면 None으로 표기하거나 혹은 표기하지 않는
            - Exceptions – 각각의 Exception명과 발생 상황을 적고, 없으면 None으로 표기하거나 혹은 표기하지 않는다.
              예) @exception SQLException – SQL 처리 에러 발생시
            - Return value – type과 변수명을 적고, 없으면 None으로 표기하거나 혹은 표기하지 않는다.
              예) @return int count – HashTable 안의 키의 수
              @return boolean openSuccess - 정상open시 success


2. 