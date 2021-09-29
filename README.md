# **cheerup-BE**
- 서비스 주소 : http://spartacheerup.s3-website.ap-northeast-2.amazonaws.com/
## **📕 개요**

- 명칭 : cheerup
- 개발 인원 : 5명
    - Front end: **노예찬, 박경준**
    - Back end: **박응수, 김선용, 이중원**
- 개발 기간 : 2021.07.09 ~ 2021.07.15
- 주요 기능
    - 유저가 고민을 적으면 랜덤으로 고민에 대한 해결책을 제시해줌. (마법의 고민해결책 컨셉 차용)
    - 게시글과 댓글에 대한 CRUD
    - JWT를 이용한 로그인
- 스택 : react/spring
- 형상 관리 툴 : git
- 협업 툴 : https://www.notion.so/22-1fc891afa24f457aac4aac2cb320a79f
- 프론트 github : https://github.com/uvula6921/cheerup-FE
- 간단 소개 : 리액트 - 스프링 게시판 기능을 통한 고민해결 사이트.

## **☝🏻 프로젝트 특징**

- 프론트엔드와 백엔드를 분리하여 프로젝트 개발
    - 각 파트별로 Repository를 생성 후 작업
    - 프론트: AWS S3
    - 백엔드: AWS EC2
    - DB : AWS RDS
    - 빌드 후, S3와 EC2를 연동
        - API 명세서에 따라 API호출 및 응답 확인
    - 로그인 시 JWT, 쿠키 사용


## 🎈 개발 환경 
    - 프론트: AWS S3
    - 백엔드: AWS EC2
    - DB : AWS RDS
 
   - Framwork : spring
   - IntelliJ Ultimate  
gradle-7.1.1  
Java 8  
SpringBoot 2.5.2  

 - 의존성 추가  
Lombok  
Web  
Security  
Jpa  
MySql  

## 📃 API 설계

| 기능                            | method | URI                        |
| ------------------------------- | ------ | -------------------------- |
| 명언 랜덤 가져오기              | GET    | /saying                    |
| 게시글 글쓰기                   | POST   | /article                   |
| 게시글 가져오기                 | GET    | /article                   |
| 게시글 삭제                     | DELETE | /article/{id}              |
| 특정 게시글 가져오기            | GET    | /article/{id}              |
| 댓글 가져오기                   | GET    | /comment/{articleId}       |
| 댓글 쓰기                       | POST   | /comment                   |
| 댓글 수정                       | PUT    | /comment/{id}              |
| 댓글 삭제                       | DELETE | /comment/{id}              |
| 로그인                          | POST   | /user/login                |
| 로그아웃                        | GET    | /user/logout               |
| 회원가입                        | POST   | /user/signup               |
| 좋아요 전체 조회                | GET    | /likeIt                    |
| 게시글 Id 별 좋아요 조회        | GET    | /likeIt/{articleId}        |
| 좋아요 총 개수                  | GET    | /likeItCounter             |
| 좋아요 입력, 취소               | POST   | /likeIt                    |
| (댓글 좋아요 전체 조회)         | GET    | /commentLikeIt             |
| (댓글 ID 별로 댓글 좋아요 조회) | GET    | /commentLikeIt/{commentId} |
| (댓글 좋아요 총개수 조회)       | GET    | /commentLikeItCounter      |
| ( 댓글 좋아요 입력, 취소)       | POST   | /commentLikeIt             |


