CREATE TABLE user_tb (
     id INT PRIMARY KEY AUTO_INCREMENT,
     username VARCHAR(20) NOT NULL,
     password VARCHAR(120) NOT NULL,
     email VARCHAR(20) NOT NULL,
     nickname VARCHAR(20) NOT NULL,
     role VARCHAR(20) NOT NULL,
     is_blacked BOOLEAN DEFAULT FALSE,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE board_tb (
     id INT PRIMARY KEY AUTO_INCREMENT,
     user_id INT NOT NULL,
     title VARCHAR(100) NOT NULL,
     content VARCHAR(MAX),
     author VARCHAR(20) NOT NULL,
     reportFlag BOOLEAN DEFAULT FALSE,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (user_id) references user_tb(id)
);

CREATE TABLE report_tb (
     id INT PRIMARY KEY AUTO_INCREMENT,
     board_id INT NOT NULL,
     is_reported BOOLEAN NOT NULL ,
     reportContent VARCHAR(50),
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (board_id) references board_tb(id)
);

