INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('ssar', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '쌀', 'SPROUT', false, now(), null);

INSERT INTO board_tb(title, content, author, user_id, is_reported, created_at)
VALUES ( '글 제목입니다.','글 내용입니다.','ssar', 1, false, now() )