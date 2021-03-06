CREATE DATABASE uktcLib CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE uktcLib;

drop database uktcLib;

CREATE TABLE IF NOT EXISTS uktcLib.person (
	person_id int primary key unique auto_increment,
    user_name varchar(55) unique,
    password varchar(55),
    role_id INT,
    hash_pass VARCHAR(100),
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES role (id)
);

INSERT INTO uktcLib.person(user_name, password, role_id, hash_pass) VALUES
	("b", "b", 01, "hjhfjvtrjvr");

Select * from uktcLib.person;

Select count(user_name), count(password) from uktcLib.person where user_name='hiii' and password='helll';

DROP TABLE uktcLib.person;

CREATE TABLE uktcLib.role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(20) NOT NULL
);

insert into uktcLib.role(id,roleName) values(01,'admin');
insert into uktcLib.role(id,roleName) values(02,'user');

describe uktcLib.person;



CREATE TABLE books(
	id INT AUTO_INCREMENT PRIMARY KEY ,
    BookBarcode VARCHAR(11) NOT NULL UNIQUE,
	BookName VARCHAR(255) NOT NULL ,
    BookAutor VARCHAR(255) NOT NULL ,
    BookGenre VARCHAR(255),
    BookPublisher VARCHAR(255),
    BookDescription VARCHAR(255),
    BookDate VARCHAR(255),
    BookImage VARCHAR(255),
    file varchar(255)
);
Drop table books;

ALTER TABLE books add file varchar(255);
ALTER TABLE books add Imagepath varchar(100);

Select * from books;

INSERT INTO books (id, BookBarcode, BookName, BookAutor, BookGenre, BookPublisher, BookDescription, BookDate, BookImage)
VALUES 	(NULL, '9999999999' , 'Java for Dummies', 'Bary Burd', 'PC', 'AlexSoft', 'One book about Java...', '2013', 'No');


CREATE TABLE students (
	id int primary key not null auto_increment,
	name VARCHAR(100) NOT NULL,
    readBooks int,
    courseNumb int unique not null,
    email VARCHAR(100) NOT NULL,
    currentBook VARCHAR(100),
    file varchar(255) NOT NULL
);

DROP TABLE students;

INSERT INTO students (name, readBooks, courseNumb, email, currentbook, file) VALUES
	('Ivan', 0, 14250, 'ivan.cnfnf@gmail.com', 'none', 'no');

SELECT * FROM students WHERE courseNumb=14116;


SELECT * FROM students;

SET NAMES 'utf8';
SET CHARACTER SET utf8;

SELECT default_character_set_name FROM information_schema.SCHEMATA
WHERE schema_name = "uktcLib";

CREATE TABLE book_activity(
 activity_id int primary key not null auto_increment,
 student_id int not null,
 CONSTRAINT FOREIGN KEY (student_id) REFERENCES students(id),
 book_id int not null,
 CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(id),
 return_date DATE not null,
 is_return BOOLEAN not null,
 UNIQUE(student_id,book_id, return_date)
); 

DROP TABLE book_activity;

SELECT * FROM students;

INSERT INTO book_activity(student_id, book_id, return_date, is_return) VALUES 
	(6,1, CURDATE(), false),
    (5,2 , CURDATE(), false),
    (6,2 , CURDATE(), TRUE);


SELECT books.BookName, students.name, book_activity.return_date
FROM books JOIN students
ON books.id IN(
SELECT book_id FROM book_activity WHERE book_activity.student_id = students.id);

SELECT book_activity.activity_id, books.BookName, students.name, book_activity.return_date, book_activity.is_return
FROM books JOIN book_activity
ON books.id = book_activity.book_id and is_return = FALSE
JOIN students ON students.id = book_activity.student_id;

SELECT * FROM book_activity WHERE activity_id=1


