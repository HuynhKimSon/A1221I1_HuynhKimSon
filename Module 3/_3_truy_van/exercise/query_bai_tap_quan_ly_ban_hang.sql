-- THEM MOI
insert into customer(customer_name, customer_age)
values	('Minh Quan', 10),
		('Ngoc Oanh', 20),
		('Hong Ha', 50);

insert into order_product(customer_id, order_date, order_total_price)
values	(1,'3/21/2006 00:00:00',12500),
		(2,'3/21/2006 00:00:00',15600),
        (1,'3/21/2006 00:00:00',11370);
        
insert into product(product_name, product_price)
values	('may giat', 3),
		('tu lanh', 3),
		('dieu hoa', 3),
		('quat', 3),
		('bep dien', 3);
        
insert into order_detail(order_id,product_id, order_qty)
values 	(1,1,3),
		(1,3,3),
		(2,4,3),
		(3,1,3),
		(2,2,3),
		(3,5,3);

-- QUERY
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select order_id, order_date, order_total_price from order_product;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select distinct c.customer_id, c.customer_name, c.customer_age, p.product_name
from customer c 
join order_product o on c.customer_id = o.customer_id
join order_detail od on  c.customer_id = od.order_id
join product p on  od.product_id = p.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select distinct c.customer_id, c.customer_name, c.customer_age 
from
customer c left join order_product o on c.customer_id = o.customer_id
where o.customer_id is null;

select distinct c.customer_id, c.customer_name, c.customer_age 
from
order_product o right join  customer c on  o.customer_id = c.customer_id
where o.customer_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.order_id as invoice_code, o.order_date as invoice_date, sum( od.order_qty * p.product_price) as invoice_total 
from
order_product o join order_detail od on o.order_id = od.order_id
join product p on od.product_id = p.product_id
group by o.order_id;

select * from product;
select * from order_datil;