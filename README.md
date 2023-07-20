# KDTBE5_Spring_ToyProject3_admin

### 📄 관리자 기능 명세서

1. 관리자 회원 권한 관리
    - [X]  회원의 role 변경 가능해야 함
2. 관리자 회원 Email 전송 관리
    - [X]  회원에게 email 전송 가능해야 함
3. 관리자 게시글 CRUD 관리
    - [X]  게시글 목록보기, 삭제하기, 숨기기/보이기, 블랙리스트(욕설) 등록 가능해야 함 (수정,
      상세보기는 구현할 필요 없음)
4. 관리자 게시글 통계 관리
    - [ ]  유저의 게시글 수, 댓글 수를 볼 수 있고, 댓글수가 많은 유저 순, 게시글 수가 많은 유저
      순으로 정렬가능해야 함
5. 관리자 블랙리스트 고객 등록/해제
    - [X]  게시글 신고목록 페이지 구현, 해당 페이지에서 블랙리스트 고객 등록 및 해제 가능
  
### 📒테이블 목록

```sql
Table tb_user 
{
  id int [pk, increment]
  username varchar [not null]
  password varchar [not null]
  email varchar [not null]
  nickname varchar [not null]
  role varchar [not null, default: "새싹회원", note: "게시글 수 10개 이상 우수 회원"]
  is_blacked boolean [default:false, note: "블랙 여부" ]
  created_at timestamp
  updated_at timestamp
}
```

```sql
Table tb_board {
  id int [pk, increment]
  category int [note: "tb_user - role"]
  title varchar [not null]
  content text
  thumbnail varchar
  user_id int [not null]
  is_blind boolean [not null, default: false]
  created_at timestamp
  updated_at timestamp
}
```

```sql
Table tb_comment {
  id int [pk, increment]
  board_id int [not null]
  user_id int [not null]
  content varchar(50)
  group_num int [not null, note: "댓글 인덱스"]
  depth int [not null, default: 0, note: "댓글 depth 최대 1"]
  order int [not null, default: 0, note: "댓글,대댓글 정렬용"]
  created_at timestamp
  updated_at timestamp
}
```

```sql
Table tb_report_list{
  id int [pk, increment]
  board_id int [not null]
  report_flag boolean [not null, default:false]
  report_content varchar
  created_at timestamp
  updated_at timestamp
}
```

Ref: tb_board.user_id > tb_user.id
Ref: tb_comment.board_id > tb_board.id
Ref: tb_comment.user_id > tb_user.id
Ref: tb_board.id > tb_report_list.board_id



### Email 전송 세팅

✅ Naver SMTP 사용
1. 네이버 로그인
2. 네이버 2차 인증 (앱 비밀번호 확인)
3. 네이버 메일 -> 환경설정 -> POP3/SMTP 설정에서 **POP3/SMTP 사용** 사용함으로 체크 

application.yml 안에 있는 username, password 는 환경 변수로 관리
Edit Configuration 에서 환경변수 설정
spring.mail.username={navermail@naver.com};spring.mail.password={naverAppPassword}


