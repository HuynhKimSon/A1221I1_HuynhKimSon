CREATE DATABASE demo_5_view_index_procedure;

CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT,
    product_code INT NOT NULL,
	product_name VARCHAR(55) NOT NULL,
	product_price DOUBLE NOT NULL,
	product_amount DOUBLE NOT NULL,
	product_description VARCHAR(55) NOT NULL,
	product_status INT NOT NULL
);

INSERT INTO product(product_code,product_name,product_price,product_amount,product_description,product_status)
values	(112,'Bánh 1',1200,1400,"bánh abc 1", 0),
		(113,'Bánh 2',1300,1500,"bánh abc 2", 0),
        (114,'Bánh 3',1400,1600,"bánh abc 3", 0),
        (115,'Bánh 4',1500,1700,"bánh abc 4", 0),
        (116,'Bánh 5',1600,1800,"bánh abc 5", 0);

-- INDEX
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
ALTER TABLE product ADD UNIQUE product_code_index (product_code);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
ALTER TABLE product ADD UNIQUE product_composite_index (product_name, product_price);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM product WHERE product_code = 112; 
-- So sánh câu truy vấn trước và sau khi tạo index
SELECT * FROM product WHERE product_code = 112;

-- VIEW
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW tmp AS
SELECT product_code,product_name,product_price,product_status
FROM product;
-- Tiến hành sửa đổi view
UPDATE product
SET product_name = 'Kẹo 123'
WHERE product_code = 112;

-- Tiến hành xoá view
DROP VIEW tmp;

-- STORE PROCEDURE
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE findAllProducts()
BEGIN
  SELECT * FROM product;
END //
DELIMITER ;
CALL findAllProducts();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE addProduct()
BEGIN
  INSERT INTO product(product_code,product_name,product_price,product_amount,product_description,product_status)
values	(119,'Bánh 1',1200,1400,"bánh abc 1", 0);
END //
DELIMITER ;
CALL addProduct();

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
CREATE PROCEDURE editProduct(IN in_id INT)
BEGIN
	UPDATE product
    SET product_name = "Kẹo 12344567"
    WHERE id = in_id;
END //
DELIMITER ;

CALL editProduct(3);

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
CREATE PROCEDURE deleteProduct(IN in_id INT)
BEGIN
	DELETE FROM product
    WHERE id = in_id;
END //
DELIMITER ;

CALL deleteProduct(2);




