CREATE DATABASE quan_ly_diem_thi;

CREATE TABLE hoc_sinh(
	ma_hs varchar(20) PRIMARY KEY,
    ten_hs varchar(50),
    ngay_sinh DATETIME,
    lop varchar(20),
    gt varchar(20)
);

CREATE TABLE mon_hoc(
	ma_mh varchar(20) PRIMARY KEY,
    ten_mh varchar(50)
);

CREATE TABLE bang_diem(
	ma_hs varchar(20),
    ma_mh varchar(20),
    diem_thi int,
    ngay_kt DATETIME,
    PRIMARY KEY (ma_hs, ma_mh),
    FOREIGN KEY (ma_hs) REFERENCES hoc_sinh(ma_hs), 
    FOREIGN KEY (ma_mh) REFERENCES mon_hoc(ma_mh)
);

CREATE TABLE giao_vien(
	ma_gv varchar(20) PRIMARY KEY,
    ten_gv varchar(20),
    sdt varchar(10)
);

ALTER TABLE mon_hoc ADD ma_gv varchar(20);
ALTER TABLE mon_hoc ADD CONSTRAINT ma_gv FOREIGN KEY (ma_gv) REFERENCES giao_vien(ma_gv);