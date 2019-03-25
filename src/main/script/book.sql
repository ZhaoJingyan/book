CREATE SCHEMA `book` DEFAULT CHARACTER SET utf8mb4;

DROP TABLE IF EXISTS `abstract`;
CREATE TABLE abstract
(
  id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  content     VARCHAR(255)       DEFAULT '' NOT NULL COMMENT '内容',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更行时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '摘要';

DROP TABLE IF EXISTS `book`;
CREATE TABLE book
(
  id                   INT                                                             NOT NULL PRIMARY KEY AUTO_INCREMENT
    COMMENT '',
  name                 VARCHAR(50)                                                     NOT NULL
    COMMENT '',
  account_date         CHAR(8)   DEFAULT '00000000'                                    NOT NULL,
  closing_account_date CHAR(8)   DEFAULT '00000000'                                    NOT NULL,
  create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP                             NOT NULL
    COMMENT '创建时间',
  update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NULL
    COMMENT '更行时间',
  abstract_id          INT       DEFAULT 0                                             NOT NULL COMMENT '摘要',
  UNIQUE KEY (name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '账本';

DROP TABLE IF EXISTS `subject`;
CREATE TABLE subject
(
  `id`          CHAR(8) PRIMARY KEY COMMENT '主键',
  `book_id`     INT          NOT NULL DEFAULT 0 COMMENT '账本ID',
  `path`        VARCHAR(255) NOT NULL UNIQUE COMMENT '路径',
  `name`        VARCHAR(30)  NOT NULL,
  `pid`         INT          NOT NULL DEFAULT 0,
  `create_time` TIMESTAMP    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更行时间',
  `abstract_id` INT          NOT NULL DEFAULT 0 COMMENT '摘要',
  UNIQUE KEY (name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1
  COMMENT '科目';

CREATE TABLE `water`
(
  id          INT PRIMARY KEY AUTO_INCREMENT
    COMMENT '主键',
  book_id     INT            NOT NULL DEFAULT 0
    COMMENT '账本id',
  subject_id  INT            NOT NULL DEFAULT 0 COMMENT '科目id',
  money       DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '金额',
  create_time TIMESTAMP      NOT NULL DEFAULT current_timestamp
    COMMENT '创建时间',
  update_time TIMESTAMP      NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    COMMENT '更行时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '流水';

CREATE TABLE accounting_entry
(
  id          INT PRIMARY KEY AUTO_INCREMENT
    COMMENT '主键',
  book_id     INT       NOT NULL DEFAULT 0 COMMENT '账本id',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp
    COMMENT '创建时间',
  update_time TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    COMMENT '更行时间'
);

CREATE TABLE account_detail
(
  id                  INT PRIMARY KEY AUTO_INCREMENT
    COMMENT '主键',
  book_id             INT NOT NULL DEFAULT 0
    COMMENT '账本id',
  accounting_entry_id INT NOT NULL DEFAULT 0
    COMMENT '',
  water_id            INT NOT NULL DEFAULT 0,
  order_id            INT NOT NULL DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 1
  COMMENT '账号明细';


