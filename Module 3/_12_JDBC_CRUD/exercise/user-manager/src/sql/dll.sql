CREATE DATABASE user_manager;
USE user_manager;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 cmnd int(25) NOT NULL UNIQUE,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(cmnd, name, email, country) values('100200300','Minh','minh@codegym.vn','Viet Nam');
insert into users(cmnd, name, email, country) values('100200301','Kante','kante@che.uk','Kenia');
insert into users(cmnd, name, email, country) values('100200302','son','son@codegym.vn','Viet Nam');
insert into users(cmnd, name, email, country) values('100200303','hoa','hoa@che.uk','UK');

select * from users;

delete from users where id IN (1,2);