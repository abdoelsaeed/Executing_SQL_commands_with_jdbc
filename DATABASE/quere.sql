DROP DATABASE IF EXISTS jdbcc;
CREATE DATABASE jdbcc;
USE jdbcc;
CREATE TABLE employee(
id INT(15) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) ,
gender BOOLEAN,
salary DOUBLE
);


