CREATE DATABASE user_manager;
USE user_manager;

DROP TABLE IF EXISTS users;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('son','son@codegym.vn','Viet Nam');
insert into users(name, email, country) values('hoa','hoa@che.uk','UK');

select * from users;

select * from users where cmnd = 100200300;

delete from users where id IN (1,2);