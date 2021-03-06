/* 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/

SELECT * FROM nhan_vien WHERE 
-- REVERSE(SUBSTRING_INDEX(REVERSE(ho_ten), " ", 1)) 
SUBSTRING_INDEX(ho_ten, " ", -1)
REGEXP '^[HTK]' AND LENGTH(ho_ten) <= 15;

/* 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

SELECT * FROM khach_hang WHERE
ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0) BETWEEN 18 AND 50
AND dia_chi REGEXP '(Đà Nẵng|Quảng Trị)$';

/* 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
“Diamond”.*/

SELECT kh.ma_khach_hang, kh.ho_ten, kh.ma_loai_khach, lk.ten_loai_khach, COUNT(*) AS so_lan_dat_phong FROM khach_hang kh
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
JOIN loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = 'Diamond'
GROUP BY kh.ma_khach_hang
ORDER BY so_lan_dat_phong;

/* 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong,
ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với
tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng *
Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những
khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/

SELECT 	kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, 
		hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, 
        hd.ngay_ket_thuc, (SUM(hdct.so_luong * dvdk.gia) + dv.chi_phi_thue) AS tong_tien
FROM khach_hang kh 
LEFT JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
LEFT JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN loai_dich_vu ldv ON dv.ma_dich_vu = ldv.ma_loai_dich_vu  
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY kh.ma_khach_hang
ORDER BY kh.ma_khach_hang;

/* 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng
thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).*/

SELECT DISTINCT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv 
	JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
	JOIN hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE dv.ma_dich_vu 
	NOT IN 
		(SELECT ma_dich_vu 
		 FROM hop_dong 
		 WHERE ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-03-31');

/* 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich,
so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng
chưa từng được khách hàng đặt phòng trong năm 2021.*/

SELECT DISTINCT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv 
	JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
	JOIN hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE YEAR(hd.ngay_lam_hop_dong) = '2020' AND dv.ma_dich_vu 
	NOT IN 
		(SELECT ma_dich_vu 
		 FROM hop_dong 
		 WHERE YEAR(ngay_lam_hop_dong) = '2021');

/* 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu
ho_ten không trùng nhau.*/

SELECT ho_ten FROM khach_hang
GROUP BY ho_ten
HAVING COUNT(ho_ten) = 1;

/* 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt
phòng.*/

SELECT YEAR(ngay_lam_hop_dong) AS nam, MONTH(ngay_lam_hop_dong) AS thang, COUNT(ma_khach_hang) AS tong_so_khach_hang_dat  FROM hop_dong
GROUP BY nam, thang
ORDER BY YEAR(ngay_lam_hop_dong), MONTH(ngay_lam_hop_dong);

/* 10.Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu
dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong,
ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở
dich_vu_di_kem).*/

SELECT hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, COUNT(hdct.ma_dich_vu_di_kem) AS so_luong_dich_vu_di_kem
FROM hop_dong hd
	JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY hd.ma_hop_dong;

/* 11.Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách
hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc
“Quảng Ngãi”.*/

SELECT dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai
FROM dich_vu_di_kem dvdk 
	JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
	JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
WHERE hd.ma_khach_hang IN  (
		SELECT kh.ma_khach_hang
		FROM khach_hang kh
		JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
		WHERE dia_chi REGEXP '(Đà Nẵng|Vinh)$' AND lk.ten_loai_khach = 'Diamond')
GROUP BY dvdk.ma_dich_vu_di_kem;

/* 12.Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách
hàng), so_dien_thoai (khách hàng), ten_dich_vu,
so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở
dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được
khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được
khách hàng đặt vào 6 tháng đầu năm 2021.*/

SELECT hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, COUNT(hdct.ma_dich_vu_di_kem) AS so_luong_dich_vu_di_kem
FROM hop_dong hd 
	JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
    JOIN nhan_vien nv ON  hd.ma_nhan_vien = nv.ma_nhan_vien
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong 
WHERE ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-31' AND kh.ma_khach_hang 
	NOT IN
		(SELECT ma_khach_hang
		 FROM hop_dong
		 WHERE ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-06-01')
GROUP BY hd.ma_hop_dong;    

/* 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các
Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử
dụng nhiều như nhau).*/

DROP VIEW IF EXISTS tmp;
CREATE VIEW tmp AS 
SELECT ma_dich_vu_di_kem, COUNT(ma_dich_vu_di_kem) as so_lan_su_dung
FROM hop_dong_chi_tiet
GROUP BY ma_dich_vu_di_kem;

SELECT * 
FROM  tmp; 

SELECT * 
FROM  dich_vu_di_kem 
WHERE ma_dich_vu_di_kem IN 
	(SELECT ma_dich_vu_di_kem 
	 FROM tmp
     GROUP BY ma_dich_vu_di_kem
	 HAVING MAX(so_lan_su_dung) = 
		(SELECT MAX(so_lan_su_dung) 
		 FROM tmp));

DROP VIEW tmp;

/* 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một
lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong,
ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính
dựa trên việc count các ma_dich_vu_di_kem).*/

-- CACH 1
DROP VIEW IF EXISTS tmp;
CREATE VIEW tmp AS 
SELECT ma_dich_vu_di_kem, COUNT(ma_dich_vu_di_kem) as so_lan_su_dung
FROM hop_dong_chi_tiet
GROUP BY ma_dich_vu_di_kem;

SELECT hdct.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
FROM  dich_vu_di_kem dvdk
	JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
	JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu 
WHERE dvdk.ma_dich_vu_di_kem IN 
	(SELECT ma_dich_vu_di_kem 
	 FROM tmp
     WHERE so_lan_su_dung = 1
     GROUP BY ma_dich_vu_di_kem)
GROUP BY hdct.ma_hop_dong;

DROP VIEW tmp;
 
-- CACH 2
SELECT hdct.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(dvdk.ma_dich_vu_di_kem) as so_lan_su_dung
FROM  dich_vu_di_kem dvdk
	JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
	JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
    JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
GROUP BY dvdk.ten_dich_vu_di_kem
HAVING COUNT(dvdk.ma_dich_vu_di_kem)
ORDER BY COUNT(dvdk.ma_dich_vu_di_kem);

/* 15.Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten,
ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được
tối đa 3 hợp đồng từ năm 2020 đến 2021.*/

SELECT nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
FROM nhan_vien nv
	JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
	JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan
    JOIN hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
WHERE hd.ngay_lam_hop_dong BETWEEN '2020-01-01' AND '2021-12-31'
GROUP BY nv.ma_nhan_vien
HAVING count(nv.ma_nhan_vien) <=3
ORDER BY nv.ma_nhan_vien;

/* 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019
đến năm 2021.*/

/*DELIMITER //
DROP TRIGGER IF EXISTS BEFORE_DELETE_NHAN_VIEN //
CREATE TRIGGER BEFORE_DELETE_NHAN_VIEN
BEFORE DELETE
ON nhan_vien FOR EACH ROW
BEGIN
	DELETE FROM hop_dong
    WHERE ma_nhan_vien = OLD.ma_nhan_vien;
    
END //
DELIMITER ;*/

DELETE FROM nhan_vien 
WHERE NOT EXISTS (
		SELECT *
		FROM
			hop_dong
		WHERE
			hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien AND 
            ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2021-12-31');

/* 17.Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum
lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.*/

DROP VIEW IF EXISTS tmp;
CREATE VIEW tmp AS 
SELECT DISTINCT
			kh.ma_khach_hang, sum(dv.chi_phi_thue + dvdk.gia * hdct.so_luong) AS tong_thanh_toan FROM khach_hang kh
			JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
			JOIN dich_vu dv ON dv.ma_dich_vu = hd.ma_dich_vu
			JOIN hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
			JOIN dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
WHERE
			kh.ma_loai_khach = 2
			AND YEAR(hd.ngay_lam_hop_dong) = 2021
GROUP BY hd.ma_hop_dong
HAVING tong_thanh_toan > 100000;

UPDATE khach_hang
SET ma_loai_khach = 1
WHERE ma_khach_hang IN (SELECT ma_khach_hang FROM tmp);

DROP VIEW tmp;

/* 18.Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc
giữa các bảng).*/

/*SET FOREIGN_KEY_CHECKS=0;
DELETE FROM khach_hang
WHERE ma_khach_hang IN (
	SELECT ma_khach_hang
	FROM hop_dong
		WHERE YEAR(ngay_lam_hop_dong) < 2021
	GROUP BY ma_khach_hang);
SET FOREIGN_KEY_CHECKS=1;*/

/*DELETE FROM khach_hang
WHERE EXISTS (
		SELECT
			*
		FROM
			hop_dong
		WHERE
			 hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
			 AND YEAR(ngay_lam_hop_dong) < 2021);*/


/* 19.Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong
năm 2020 lên gấp đôi. */

DROP VIEW IF EXISTS tmp;
CREATE VIEW tmp AS 
SELECT DISTINCT hdct.ma_dich_vu_di_kem
								FROM hop_dong hd  
									 JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct. ma_hop_dong
									 JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
								WHERE YEAR(hd.ngay_lam_hop_dong)  = 2020
								GROUP BY hdct.ma_dich_vu_di_kem
								HAVING COUNT(hdct.ma_dich_vu_di_kem) >=3;

UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem IN (SELECT ma_dich_vu_di_kem FROM tmp);

DROP VIEW tmp;

/* 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ
thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang),
ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.*/

SELECT ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, 'nhan_vien' as 'type' FROM nhan_vien
UNION ALL
SELECT ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, 'khach_hang' as 'type' FROM khach_hang;

-- 
SELECT AVG(hd.ma_hop_dong)
FROM hop_dong hd 
	JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
    WHERE kh.ma_loai_khach = 3;
    
SELECT *
FROM hop_dong hd 
	JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
    WHERE kh.ma_khach_hang IN ( SELECT ma_khach_hang FROM khach_hang where ma_loai_khach = 3);

-- Lon thu 2
SELECT ma_nhan_vien, ho_ten, year(ngay_sinh) FROM nhan_vien
WHERE year(ngay_sinh) = (SELECT year(ngay_sinh) 
						 FROM nhan_vien
							GROUP BY YEAR(ngay_sinh)
							ORDER BY YEAR(ngay_sinh) DESC
							LIMIT 1,1);
