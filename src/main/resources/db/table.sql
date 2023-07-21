create table user_tb
(
     id         bigint auto_increment     primary key,
     created_at datetime(6)          null,
     update_at  datetime(6)          null,
     email      varchar(20)          not null,
     is_blacked boolean              null,
     nickname   varchar(20)          not null,
     password   varchar(120)         not null,
     role       varchar(255)         null,
     username   varchar(255)         not null
);

create table board_tb
(
     id          bigint auto_increment primary key,
     created_at  datetime(6)  null,
     update_at   datetime(6)  null,
     author      varchar(255) null,
     content     text         null,
     is_reported boolean      default false not null,
     thumbnail   varchar(255) null,
     title       varchar(255) null,
     user_role   varchar(255) null,
     user_id     bigint       null,
     foreign key (user_id) references user_tb (id)
);

create table report_tb
(
     id             bigint auto_increment primary key,
     created_at     datetime(6)  null,
     update_at      datetime(6)  null,
     report_content varchar(255) null,
     report_flag    boolean      default false  not null,
     board_id       bigint       null,
     foreign key (board_id) references board_tb (id)
);

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



