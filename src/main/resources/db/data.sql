INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('ssar', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '쌀', 'SPROUT', false, now(), null);

INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('hyoung', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '태형', 'SPROUT', false, now(), null);

INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('hyeji', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '혜지', 'SPROUT', false, now(), null);

INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('seok', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '형석', 'SPROUT', false, now(), null);

INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('won', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '주원', 'SPROUT', false, now(), null);

INSERT INTO user_tb(username, password, email, nickname, role, is_blacked, created_at, update_at)
VALUES ('admin', '$2a$10$MQ/untje4DpfMqLXt/g7H.TBgUUu73x6En8nH.iQJhk4UPUuF6fdy','ussu1112@naver.com', '관리자', 'ADMIN', false, now(), null);

INSERT INTO board_tb(title, content, author, user_id, is_reported, created_at)
VALUES ( '글 제목입니다.','글 내용입니다.','ssar', 1, false, now() );

INSERT INTO comment_tb(created_at, update_at, content, board_id, parent_comment_id, user_id)
VALUES (now(), now(), '댓글 내용', 1, null, 1);

INSERT INTO board_tb(title, content, author, user_id, is_reported, created_at)
VALUES ( '글 제목입니다.','글 내용입니다.','ssar', 1, false, now() );

INSERT INTO comment_tb(created_at, update_at, content, board_id, parent_comment_id, user_id)
VALUES (now(), now(), '댓글 내용111', 1, null, 1);

INSERT INTO board_tb(title, content, author, user_id, is_reported, created_at)
VALUES ( '글 제목입니다.','글 내용입니다.','ssar', 1, false, now() );

INSERT INTO comment_tb(created_at, update_at, content, board_id, parent_comment_id, user_id)
VALUES (now(), now(), '댓글 내용222', 2, null, 1);

INSERT INTO board_tb(title, content, author, user_id, is_reported, created_at)
VALUES ( '글 제목입니다.','글 내용입니다.','ssar', 1, false, now() );

INSERT INTO comment_tb(created_at, update_at, content, board_id, parent_comment_id, user_id)
VALUES (now(), now(), '댓글 내용22', 1, null, 2);

INSERT INTO board_tb(title, content, author, user_id, is_reported, created_at)
VALUES ( '글 제목입니다.','글 내용입니다.','ssar', 1, false, now() );

INSERT INTO comment_tb(created_at, update_at, content, board_id, parent_comment_id, user_id)
VALUES (now(), now(), '댓글 내용', 1, null, 3);