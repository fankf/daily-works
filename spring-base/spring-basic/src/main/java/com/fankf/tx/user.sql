CREATE TABLE `t_account` (
  `id` int NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `money` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into t_account VALUES ("zhangsan",1000);
insert into t_account VALUES ("lisi",1000);