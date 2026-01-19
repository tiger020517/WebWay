# 📚 Java & SQLite 기반 문제 관리 콘솔 프로그램

IntelliJ, Java, Maven, SQLite를 사용하여 구현한 콘솔(CLI) 기반의 문제 관리(Problem Management) 프로그램입니다.

본 프로젝트는 GitFlow 워크플로우 규칙을 준수하며, JDBC를 통한 데이터베이스 CRUD 작업을 구현하는 것을 목표로 합니다.

## 1. 실행 결과

프로그램의 주요 기능 실행 화면입니다.

**[메인 메뉴 및 전체 목록 (메뉴 1)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/2.png">

**[이름 검색 (메뉴 2)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/3.png">

**[제목 검색 (메뉴 3)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/4.png">

**[문제 추가 (메뉴 4)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/1.png">

**[문제 수정 (메뉴 5)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/5.png">

**[문제 삭제 (메뉴 6)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/6.png">


**[파일로 저장 (메뉴 7)]**

<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/7.png">

**[종료 (메뉴 0)]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/8.png">

**[저장된 데이터]**
<img src="https://github.com/csee-ps/project1-2-tiger020517/blob/main/src/assets/9.png">



## 2. 데이터 항목 (Table Schema)

본 프로그램은 `pom.db` (또는 `problems.db`) SQLite 파일 내의 `Problems` 테이블을 사용합니다.

| 필드명 (Column) | 데이터 타입 (Type) | 설명 (Description) | 제약 조건 (Constraint) |
| :--- | :--- | :--- | :--- |
| `id` | INTEGER | 문제 고유 식별자 | **Primary Key**, AUTOINCREMENT |
| `user_id` | INTEGER | 사용자 ID | |
| `username` | TEXT | 사용자 이름 | DEFAULT 'anonymous' |
| `title` | TEXT | 문제 제목 | NOT NULL |
| `description` | TEXT | 문제 상세 내용 | |
| `create_at` | TEXT | 생성 일시 (ISO 형식) | NOT NULL |

## 3. 사용한 JDK 클래스 및 인터페이스

프로젝트 개발 중 사용한 Java의 주요 내장 클래스 및 인터페이스 목록입니다.

* **`java.sql` 패키지**
    * `Connection`: 데이터베이스 연결 세션
    * `DriverManager`: JDBC 드라이버를 관리하고 연결을 생성
    * `PreparedStatement`: SQL 쿼리를 미리 컴파일하고 파라미터를 안전하게 전송
    * `ResultSet`: SQL 쿼리(SELECT)의 결과를 저장
    * `SQLException`: DB 작업 중 발생하는 예외 처리
* **`java.util` 패키지**
    * `ArrayList`: 조회된 데이터 목록을 동적으로 저장
    * `Scanner`: 사용자의 콘솔 입력을 받기 위해 사용
* **`java.io` 패키지**
    * `FileWriter`: 텍스트 파일에 데이터를 쓰기 위해 사용
    * `PrintWriter`: `FileWriter`를 보조하여 편리하게 텍스트를 출력
    * `IOException`: 파일 입출력 예외 처리
* **`java.time` 패키지**
    * `LocalDateTime`: 현재 날짜와 시간을 가져오기 위해 사용 (데이터 추가/파일 저장 시)
    * `DateTimeFormatter`: 날짜/시간 형식을 지정 (예: `yyyyMMdd_HHmm`)

## 4. 소감 및 어려웠던 점

> * **소감:** 복잡하고 시작하기 어려웠다
> * > * **어려웠던 점:** 처음 `No suitable driver found` 오류와 `no such table: Problems` 오류가 발생했을 때 원인을 찾는 것이 어려웠습니다. `pom.xml` 의존성 동기화 문제와 DB 파일이 실제로 Java 프로그램 실행 위치에 생성된다는 점을 이해하게 되었습니다.
