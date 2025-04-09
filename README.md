# Bulletin Board System

이 프로젝트는 저의 성장을 담는 프로젝트입니다. <br>
계속 개선될 예정이고 개선뿐만 아니라 개선되는 과정 속에서 학습도 병행됩니다.<br>
현재 1단계 완료한 상태이고 계획목표는 아래와 같습니다.<br>

## 단계별	목표 
### 2단계	(현재진행중)<br>
세션 기반 로그인/로그아웃,회원가입, 세션 인증/인가 처리,<br>
게시글 권한 체크, 회원가입, 댓글<br>
온프레미스 방식(Docker 없이-> 후에 적용 (차이점 체득위함))<br>
온프레미스(윈도우 노트북 -> 라즈베리파이 or 미니pc(N100 예상)로 이전(차이점, 유지비관리,성능향상 위함)<br>
### 3단계	<br>
JWT 기반 인증, 스테이트리스 설계, 서버 2대 구성(jwt의 장점 체감위함)<br>
### 4단계	<br>
Redis + DB 튜닝, 대용량 성능 개선 (조회 최적화, 인덱싱 등)<br>

## 🔐 보안 설정 가이드

이 프로젝트는 민감한 설정 정보를 Git에 포함하지 않고 관리합니다.

## ✅ 숨긴 설정 파일
- `src/main/resources/application.properties`
- `src/main/resources/application-secret.properties`

## ⚙️ 설정 방법
1. `application.properties`에 아래와 같이 작성하세요.

spring.application.name=crud
spring.config.import=optional:classpath:application-secret.properties<br>

2.application-secret.properties 파일을 직접 생성하고, 아래 내용처럼 작성하세요:


spring.datasource.username=YOUR_DB_USERNAME<br>
spring.datasource.password=YOUR_DB_PASSWORD<br>
예시는 application-secret-example.properties 파일을 참고하세요<br>



## 목차


- [프로젝트 구조](#프로젝트-구조)
- [사용 기술](#사용-기술)
- [구현 기능](#구현-기능)




## 프로젝트 구조


## 사용 기술

## IDE
 IntelliJ IDEA Ultimate
## :hammer_and_wrench: Backend

| 기술                | 버전    |
|---------------------|--------|
| Spring Boot         | 3.4.3  |
| Spring Security     | X 예정 |
|  Lombok   | 적용  |
| JSON Web Token      | X 예정 |
| MyBatis             | 3.0.4  |
| MySQL Connector J   | 8.0.33 |
| Swagger             |  X 예정 |

<br />

## :hammer_and_wrench: Frontend

| 기술               | 버전    |
|--------------------|--------|
| NodeJS             | 22.14.0 |
| React              | 16.2.0  |
| react-axios        | 1.8.2   |
| react-dom          | 19.0.0  |
| react-js-pagination|  예정  |
| react-dom       | 6.3.0   |
| react-router-dom   | 6.3.0   |
| react-scripts      | 5.0.1   |
- .........

--
## 구현 기능

### 게시판 기능
- 모든 게시글 및 특정 게시글 조회
- 게시글 목록 조회
- 게시글 상세 조회
- 게시글 작성 [회원]
- 게시글 수정 [회원, 게시글 작성자]
- 게시글 삭제 [회원, 게시글 작성자]
- 게시글 검색 (제목, 내용, 작성자)
- 게시글 조회수 증가 기능

  > API 호출은 모듈화 사용
  > 수정/ 삭제 시 상태(State)를 활용하여 페이지 갱신 처리
  ---
  


### 회원 기능
- 로그인/로그아웃

## 기능 실행화면

--


## 코드 캡쳐 예시


