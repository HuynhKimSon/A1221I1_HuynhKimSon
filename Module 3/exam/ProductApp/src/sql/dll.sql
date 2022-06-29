CREATE DATABASE product_manager;

DROP TABLE IF EXISTS products;
create table products (
 id INT AUTO_INCREMENT PRIMARY KEY,
 id_category INT NOT NULL,
 `name` varchar(120) NOT NULL,
 price NUMERIC(15,2)  NOT NULL,
 quantity int(25) NOT NULL,
 color varchar(120) NOT NULL,
 `description` varchar(220) NOT NULL,
 FOREIGN KEY (id_category) REFERENCES category(id_category)
);

DROP TABLE IF EXISTS category;
create table category (
 id_category INT AUTO_INCREMENT PRIMARY KEY,
 name_category varchar(120) NOT NULL
);


insert into products(id_category, name, price, quantity, color, description) values('Minh','minh@codegym.vn','Viet Nam');

insert into category(name_category) values();

select * from products p inner join category c on p.id_category = c.id_category
where c.name_category like "%S%";


select * from users;

select * from users where cmnd = 100200300;

delete from users where id IN (1,2);