# KDTBE5_Spring_ToyProject3_admin

### 프로젝트 환경
`JDK 11` `Spring Boot` `MyBatis` `H2 database` `MYSQL`

<br>

### 📄 관리자 기능 명세서

1. 관리자 회원 권한 관리
    - [X]  회원의 role 변경 가능해야 함
2. 관리자 회원 Email 전송 관리
    - [X]  회원에게 email 전송 가능해야 함
3. 관리자 게시글 CRUD 관리
    - [X]  게시글 목록보기, 삭제하기, 숨기기/보이기, 블랙리스트(욕설) 등록 가능해야 함 (수정,
      상세보기는 구현할 필요 없음)
4. 관리자 게시글 통계 관리
    - [X]  유저의 게시글 수, 댓글 수를 볼 수 있고, 댓글수가 많은 유저 순, 게시글 수가 많은 유저
      순으로 정렬가능해야 함
5. 관리자 블랙리스트 고객 등록/해제
    - [X]  게시글 신고목록 페이지 구현, 해당 페이지에서 블랙리스트 고객 등록 및 해제 가능

<br>
  
### 📒 테이블 목록

```sql
create table user_tb
(
     id         bigint auto_increment     primary key,
     created_at datetime(6)          null,
     update_at  datetime(6)          null,
     email      varchar(20)          not null,
     is_blacked boolean default false not null,
     nickname   varchar(20)          not null,
     password   varchar(120)         not null,
     role       varchar(255)         null,
     username   varchar(255)         not null
);
```

```sql
create table board_tb
(
     id          bigint auto_increment primary key,
     created_at  datetime(6)  null,
     update_at   datetime(6)  null,
     author      varchar(255) null,
     content     text         null,
     is_reported boolean default false not null,
     thumbnail   varchar(255) null,
     title       varchar(255) null,
     user_role   varchar(255) null,
     user_id     bigint       null,
     foreign key (user_id) references user_tb (id)
);


```

```sql
create table comment_tb
(
     id                bigint auto_increment     primary key,
     created_at        datetime(6)   null,
     update_at         datetime(6)   null,
     content           varchar(50)   null,
     depth             int default 0 not null,
     board_id          bigint        null,
     parent_comment_id bigint        null,
     user_id           bigint        null,
     foreign key (board_id) references board_tb (id),
     foreign key (user_id) references user_tb (id),
     foreign key (parent_comment_id) references comment_tb (id)
);
```

```sql
create table report_tb
(
     id             bigint auto_increment primary key,
     created_at     datetime(6)  null,
     update_at      datetime(6)  null,
     report_content varchar(255) null,
     report_flag    boolean default false not null,
     board_id       bigint       null,
     foreign key (board_id) references board_tb (id)
);
```

<br>

### 📨 Email 전송 세팅

✅ Naver SMTP 사용
1. 네이버 로그인
2. 네이버 2차 인증 (앱 비밀번호 확인)
3. 네이버 메일 -> 환경설정 -> POP3/SMTP 설정에서 **POP3/SMTP 사용** 사용함으로 체크

application.yml 안에 있는 username, password 는 환경 변수로 관리   
Edit Configuration 에서 환경변수 설정   
spring.mail.username={navermail@naver.com};spring.mail.password={naverAppPassword}   

<br>

### Docker Compose

application.yml - prod 설정 시 Mysql Db 사용

```yml
version: "3"

services:
  database:
    image: mysql:8.0
    environment:
      - MYSQL_DATABASE=testdb
      - MYSQL_ROOT_HOST=%
      - MYSQL_ROOT_PASSWORD=root
    ports:
      - 3306:3306
```

**테이블은 [메인 애플리케이션](https://github.com/Ussu1112/KDTBE5_Spring_ToyProject3)에서 JPA로 자동 생성**



