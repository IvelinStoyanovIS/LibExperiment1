CREATE TABLE IF NOT EXISTS uktcLib.person (
	person_id int primary key unique auto_increment,
    user_name varchar(55) unique, 
    password varchar(55),
    role_id INT,
    hash_pass VARCHAR(100),
    CONSTRAINT FOREIGN KEY (role_id) REFERENCES role (id)
);


CREATE TABLE uktcLib.role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(20) NOT NULL
);

insert into uktcLib.role(id,roleName) values(01,'admin');
insert into uktcLib.role(id,roleName) values(02,'user');
