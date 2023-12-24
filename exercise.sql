CREATE DATABASE IF NOT EXISTS ssm;
USE ssm;

CREATE TABLE IF NOT EXISTS `tb_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) ,
  `author` varchar(100) ,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE IF NOT EXISTS `tb_sample`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) ,
  PRIMARY KEY (`id`)
) ;