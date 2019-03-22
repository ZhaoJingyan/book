CREATE TABLE book(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT '',
  name VARCHAR(50) NOT NULL COMMENT '',
  create_time TIMESTAMP not null DEFAULT current_timestamp COMMENT '创建时间',
  update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更行时间'
);

CREATE table subject(
  id char(8) PRIMARY KEY comment '主键',
  book_id int not null,
  path VARCHAR(255) not NULL COMMENT '',
  name VARCHAR(30) not null
)