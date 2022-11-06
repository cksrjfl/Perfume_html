CREATE DATABASE IF NOT EXISTS project_perfume
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE project_perfume;

CREATE TABLE IF NOT EXISTS user(
id VARCHAR(128) PRIMARY KEY, -- "email"
password VARCHAR(32),
name VARCHAR(32),
);

CREATE TABLE IF NOT EXISTS feed(
	no INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id VARCHAR(128), -- "email"
	content VARCHAR(4096),
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS perfume(
	no INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	perfume_name VARCHAR(128),
	perfume_image VARCHAR(128),
	perfume_ingredient VARCHAR(4096),
	perfume_content VARCHAR(4096)
);

CREATE TABLE IF NOT EXISTS ingredient(
	no INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ingredient_name VARCHAR(128),
	ingredient_image VARCHAR(128),
	perfume_include VARCHAR(4096),
	ingredient_content VARCHAR(4096)
);

create table if not exists ingre_feed(
	no INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	id varchar(128),
	content varchar(4096),
	ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);