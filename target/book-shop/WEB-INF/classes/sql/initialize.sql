DROP DATABASE IF EXISTS book;
CREATE DATABASE book DEFAULT CHARACTER SET UTF8;
USE book;

DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orderitem;
DROP TABLE IF EXISTS notice;
DROP TABLE IF EXISTS category;

create table category(
			id varchar(100) primary key,
			name varchar(100) not null unique,
			description varchar(255)
		)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1;

CREATE TABLE user
(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	gender VARCHAR(4),
	email VARCHAR(50),
	phone VARCHAR(20),
	introduce varchar(100),
	activeCode VARCHAR(50),
	state INT(11) DEFAULT 0,
	role VARCHAR(10),
	registTime TIMESTAMP NOT NULL DEFAULT '2016-01-01 00:00:00',
	PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1;

CREATE TABLE book
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(40),
	price DOUBLE DEFAULT 0.0,
	category_id VARCHAR(40),
	num INT,
	img_url VARCHAR(100),
	description VARCHAR(255),
	PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1;

CREATE TABLE orders
(
	id VARCHAR(100) NOT NULL,
	money DOUBLE,
	receiveAddress VARCHAR(255),
	receiveName VARCHAR(20),
	reveicePhone VARCHAR(20),
	paystate INT,
	orderTime TIMESTAMP DEFAULT '2016-01-01 00:00:00',
	user_id INT,
	PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1;

CREATE TABLE orderitem
(
	order_id VARCHAR(100) NOT NULL,
	product_id VARCHAR(100),
	buynum INT,
	PRIMARY KEY(order_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1;

CREATE TABLE notice
(
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(10),
	details VARCHAR(255),
	time VARCHAR(18),
	PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1;