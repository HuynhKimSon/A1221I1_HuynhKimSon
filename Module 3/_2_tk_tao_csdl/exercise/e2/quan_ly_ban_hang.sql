create database quan_ly_ban_hang;

create table customer(
	customer_id int auto_increment primary key,
    customer_name varchar(50) not null,
    customer_age int
);

create table product(
	product_id int auto_increment primary key,
    product_name varchar(50) not null,
    product_price double not null
);

create table order_product(
	order_id int auto_increment primary key,
    customer_id int not null,
    order_date datetime not null,
    order_total_price double not null,
	foreign key (customer_id) references customer (customer_id)
);

create table order_detail(
	order_id int not null,
    product_id int not null,
    order_qty int not null,
	foreign key (order_id) references order_product (order_id),
	foreign key (product_id) references product (product_id)
);