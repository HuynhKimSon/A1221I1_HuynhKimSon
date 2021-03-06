CREATE DATABASE furama_manager;

CREATE TABLE vi_tri(
	ma_vi_tri INT AUTO_INCREMENT PRIMARY KEY,
    ten_vi_tri VARCHAR(45) NOT NULL
);

CREATE TABLE trinh_do(
	ma_trinh_do INT AUTO_INCREMENT PRIMARY KEY,
    ten_trinh_do VARCHAR(45) NOT NULL
);

CREATE TABLE bo_phan(
	ma_bo_phan INT AUTO_INCREMENT PRIMARY KEY,
    ten_bo_phan VARCHAR(45) NOT NULL
);

CREATE TABLE nhan_vien(
	ma_nhan_vien INT AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL UNIQUE,
    luong DOUBLE NOT NULL,
    so_dien_thoai VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(45) NOT NULL UNIQUE,
    dia_chi VARCHAR(45) NOT NULL,
    ma_vi_tri INT NOT NULL,
    ma_trinh_do INT NOT NULL,
    ma_bo_phan INT NOT NULL,
    FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
    FOREIGN KEY (ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
    FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan)
);

-- CREATE TABLE customer_type(
-- 	customer_type_id INT AUTO_INCREMENT PRIMARY KEY,
--     customer_type_name VARCHAR(45) NOT NULL
-- );

-- CREATE TABLE customer(
-- 	customer_id INT AUTO_INCREMENT PRIMARY KEY,
--     customer_type_id INT NOT NULL,
--     customer_name VARCHAR(45) NOT NULL,
--     customer_birthday DATE NOT NULL,
--     customer_gender BIT(1) NOT NULL,
--     customer_id_card VARCHAR(45) NOT NULL UNIQUE,
--     customer_phone VARCHAR(45) NOT NULL UNIQUE,
--     customer_email VARCHAR(45) NOT NULL UNIQUE,
--     customer_address VARCHAR(45) NOT NULL,
--     FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id)
-- );

CREATE TABLE loai_dich_vu(
	ma_loai_dich_vu INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai_dich_vu VARCHAR(45) NOT NULL
);

CREATE TABLE kieu_thue(
	ma_kieu_thue INT AUTO_INCREMENT PRIMARY KEY,
    ten_kieu_thue VARCHAR(45) NOT NULL
);

CREATE TABLE dich_vu(
	ma_dich_vu INT AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu VARCHAR(45) NOT NULL,
    dien_tich INT NOT NULL,
    chi_phi_thue DOUBLE NOT NULL,
    so_nguoi_toi_da INT NOT NULL,
    ma_kieu_thue INT NOT NULL, 
    ma_loai_dich_vu INT NOT NULL,
    tieu_chuan_phong VARCHAR(45) NOT NULL,
    mo_ta_tien_nghi_khac VARCHAR(45),
    dien_tich_ho_boi DOUBLE,
    so_tang INT,
    FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
    FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu)
);

CREATE TABLE hop_dong(
	ma_hop_dong INT AUTO_INCREMENT PRIMARY KEY,
    ngay_lam_hop_dong DATETIME NOT NULL,
    ngay_ket_thuc DATETIME NOT NULL,
	tien_dat_coc DOUBLE NOT NULL,
    ma_nhan_vien INT NOT NULL,
    ma_khach_hang INT NOT NULL,
    ma_dich_vu INT NOT NULL ,
    FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
    FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
    FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu)
);

CREATE TABLE dich_vu_di_kem(
	ma_dich_vu_di_kem INT AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu_di_kem VARCHAR(45) NOT NULL,
    gia DOUBLE NOT NULL,
    don_vi VARCHAR(10) NOT NULL,
    trang_thai VARCHAR(45) NOT NULL
);

CREATE TABLE hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet INT AUTO_INCREMENT PRIMARY KEY,
    ma_hop_dong INT NOT NULL,
    ma_dich_vu_di_kem INT NOT NULL,
    so_luong INT NOT NULL,
	FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
    FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem)
);

-- THEM MOI DU LIEU

INSERT INTO vi_tri(ten_vi_tri)
VALUES	("Gi??m ?????c"),
		("Qu???n l??"),
		("Nh??n vi??n");

INSERT INTO trinh_do(ten_trinh_do)
VALUES	("Trung c???p"),
		("Cao ?????ng"),
		("?????i h???c"),
        ("Sau ?????i h???c");

INSERT INTO bo_phan(ten_bo_phan)
VALUES	("Sale-Marketing"),
		("H??nh ch??nh"),
		("Ph???c v???"),
        ("Qu???n l??");
        
/*INSERT INTO nhan_vien(ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
VALUES	
		('L?? V??n B??nh','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Y??n B??i, ???? N???ng',1,2,1),
        ('H??? Th??? Y???n','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','29315 Nguy???n T???t Th??nh, ???? N???ng',1,3,1),
        ('V?? C??ng To???n','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','29125 Nguy???n T???t Th??nh, ???? N???ng',2,1,4);*/

INSERT INTO nhan_vien(ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
VALUES	('Nguy???n V??n An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguy???n T???t Th??nh, ???? N???ng',1,3,1),
		('L?? V??n B??nh','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Y??n B??i, ???? N???ng',1,2,1),
        ('H??? Th??? Y???n','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','29315 Nguy???n T???t Th??nh, ???? N???ng',1,3,1),
        ('V?? C??ng To???n','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','29125 Nguy???n T???t Th??nh, ???? N???ng',2,1,4),
        ('Nguy???n B???nh Ph??t','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','K234/11 ??i???n Bi??n Ph???, Gia Lai',2,4,2),
        ('Kh??c Nguy???n An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','2956 Nguy???n T???t Th??nh, ???? N???ng',2,3,3),
        ('Nguy???n H???u H??','1993-01-01','534323231',8000000,'0941234523','nhh0101@gmail.com','4 Nguy???n Ch?? Thanh, Hu???',1,3,1),
        ('Nguy???n H?? ????ng','1989-09-03','234414123',7000000,'0941234553','donghanguyen@gmail.com','2915 Nguy???n T???t Th??nh, ???? N???ng',1,2,4),
        ('T??ng Hoang','1982-09-03','256781231',8000000,'0245144444','hoangtong@gmail.com','213 H??m Nghi, ???? N???ng',1,3,2),
        ('Nguy???n C??ng ?????o','1994-01-08','755434343',10000000,'0988767111','nguyencongdao12@gmail.com','2 Nguy???n T???t Th??nh, ???? N???ng',2,3,1);
        
INSERT INTO loai_khach(ten_loai_khach)
VALUES	("Diamond"),
		("Platinium"),
		("Gold"),
        ("Silver"),
        ("Member");
        
-- INSERT INTO customer_type(customer_type_name)
-- VALUES	("Diamond"),
-- 		("Platinium"),
-- 		("Gold"),
--         ("Silver"),
--         ("Member");

INSERT INTO khach_hang(ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi)
VALUES	(5,'Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng'),
		(3,'Ph???m Xu??n Di???u','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???'),
        (1,'Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213822','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh'),
        (2,'D????ng V??n Quan','1981-07-08',1,'543432111','0373213122','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng'),
        (1,'Ho??ng Tr???n Nhi Nhi','1995-12-09',1,'795453345','0490039241','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai'),
        (4,'T??n N??? M???c Ch??u','2005-12-06',0,'732434215','0312345678','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng'),
        (4,'Nguy???n M??? Kim','1984-04-08',0,'856453123','0988888844','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh'),
        (2,'Nguy???n Th??? Qu???nh','1994-07-01',0,'965656433','0912345698','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum'),
        (3,'Tr???n ?????i Danh','1989-07-01',1,'432341235','0763212345','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
        (1,'Nguy???n T??m ?????c','1979-11-07',1,'344343432','0987654321','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng');
        
-- INSERT INTO customer(customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
-- VALUES	(5,'Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng'),
-- 		(3,'Ph???m Xu??n Di???u','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???'),
--         (1,'Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213822','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh'),
--         (2,'D????ng V??n Quan','1981-07-08',1,'543432111','0373213122','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng'),
--         (1,'Ho??ng Tr???n Nhi Nhi','1995-12-09',1,'795453345','0490039241','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai'),
--         (4,'T??n N??? M???c Ch??u','2005-12-06',0,'732434215','0312345678','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng'),
--         (4,'Nguy???n M??? Kim','1984-04-08',0,'856453123','0988888844','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh'),
--         (2,'Nguy???n Th??? Qu???nh','1994-07-01',0,'965656433','0912345698','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum'),
--         (3,'Tr???n ?????i Danh','1989-07-01',1,'432341235','0763212345','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
--         (1,'Nguy???n T??m ?????c','1979-11-07',1,'344343432','0987654321','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng');

INSERT INTO kieu_thue(ten_kieu_thue)
VALUES	("year"),
		("month"),
		("day"),
        ("hour");
        
INSERT INTO loai_dich_vu(ten_loai_dich_vu)
VALUES	("Villa"),
		("House"),
        ("Room");

INSERT INTO dich_vu(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)
VALUES	('Villa Beach Front',25000, 10000000,10,3,1,'vip','C?? h??? b??i', 500, 4),
		('House Princess 01',35000, 16000000,12,2,2,'normal','C?? th??m b???p n?????ng', null, null),
        ('Room Twin 01',14000,17000000,14,4,3,'vip','C?? tivi', null, 4),
        ('Villa No Beach Front',5000,18000000,20,4,3,'normal','C?? h??? b??i', 500, null),
        ('House Princess 02',16000,20000000,16,3,2,'normal','C?? tivi', null, 4),
        ('Room Twin 02',15000,21000000,12,2,1,'vip','C?? th??m b???p n?????ng', null, 4);

INSERT INTO dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai)
VALUES	('Karaoke',10000000,'gi???','ti???n nghi, hi???n t???i'),
		('Thu?? xe m??y',11000000,'chi???c','h???ng 1 xe'),
        ('Thu?? xe ?????p',12000000,'chi???c','t???t'),
        ('Buffet bu???i s??ng',8000000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
        ('Buffet bu???i tr??a',7000000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
        ('Buffet bu???i t???i',6000000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng');
        
INSERT INTO hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
VALUES	('2020-12-08','2020-12-08',0,3,1,3),
		('2020-07-14','2020-07-21',200000,7,1,1),
        ('2021-03-15','2021-03-17',50000,3,4,2),
        ('2021-01-14','2021-01-18',100000,7,5,5),
        ('2021-07-14','2021-07-15',0,7,2,6),
        ('2021-09-02','2021-09-05',100000,8,4,4),
        ('2021-06-17','2021-06-03',100000,3,2,6),
        ('2020-11-19','2020-11-19',0,2,10,1),
        ('2021-04-12','2021-04-14',150000,9,9,3),
        ('2021-04-25','2021-04-25',0,10,2,5),
        ('2021-05-25','2021-05-27',0,1,3,1);

INSERT INTO hop_dong_chi_tiet(ma_hop_dong, ma_dich_vu_di_kem, so_luong)
VALUES	(1,4,5),
		(2,2,5),
        (3,3,15),
        (4,5,12),
        (5,6,32),
        (6,2,3),
        (7,1,4),
        (2,1,8);



































