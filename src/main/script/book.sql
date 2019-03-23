CREATE TABLE book (
  id                   INT PRIMARY KEY      AUTO_INCREMENT
  COMMENT '',
  name                 VARCHAR(50) NOT NULL
  COMMENT '',
  accounting_date      CHAR(8)     NOT NULL DEFAULT '00000000',
  closing_account_date CHAR(8)     NOT NULL DEFAULT '00000000',
  create_time          TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  update_time          TIMESTAMP   NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更行时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '账本';

CREATE TABLE subject (
  id          CHAR(8) PRIMARY KEY
  COMMENT '主键',
  book_id     INT          NOT NULL DEFAULT 0,
  path        VARCHAR(255) NOT NULL UNIQUE
  COMMENT '路径',
  name        VARCHAR(30)  NOT NULL,
  pid int not null DEFAULT 0,
  create_time TIMESTAMP    NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更行时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '科目';

CREATE TABLE `water` (
  id         INT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  book_id    INT NOT NULL DEFAULT 0
  COMMENT '账本id',
  subject_id INT NOT NULL DEFAULT 0 comment '科目id',
  money DECIMAL(10,2) not null DEFAULT 0 COMMENT '金额',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更行时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '流水';

create table accounting_entry(
  id         INT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  book_id    INT NOT NULL DEFAULT 0 COMMENT '账本id',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更行时间'
);

CREATE TABLE account_detail (
  id                  INT PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键',
  book_id             INT NOT NULL    DEFAULT 0
  COMMENT '账本id',
  accounting_entry_id INT NOT NULL    DEFAULT 0
  COMMENT '',
  water_id            INT NOT NULL    DEFAULT 0,
  order_id            INT NOT NULL    DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '账号明细';


