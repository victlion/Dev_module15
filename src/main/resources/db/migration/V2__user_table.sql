CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username varchar(45) NOT NULL,
  password varchar(64) NOT NULL,
  role varchar(45) NOT NULL,
  enabled bool DEFAULT NULL
);

INSERT INTO users (username,password,role,enabled)
VALUES ('user',
'$2a$10$BZ1ma1as3/WdHszxPFl3muFC1GOIU3oFcslhPb3qBIe7Ht9bvYHuC',
'ROLE_USER', 1);