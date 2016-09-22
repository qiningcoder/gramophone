create table gmp_user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account VARCHAR(32) NOT NULL,
  passwd VARCHAR(32) NOT NULL,
  nick VARCHAR(32) NOT NULL,
  sex VARCHAR(4) NOT NULL ,
  mobile VARCHAR(16) DEFAULT NULL ,
  email VARCHAR(32) DEFAULT NULL,
  UNIQUE KEY account (account)
)ENGINE=innodb CHARSET=utf8;