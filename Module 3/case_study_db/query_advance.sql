/*21. Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả
các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một
hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.*/

DROP VIEW IF EXISTS v_nhan_vien;
CREATE VIEW v_nhan_vien AS
	SELECT nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv. dia_chi
	FROM nhan_vien nv
	JOIN hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
    WHERE nv.dia_chi LIKE '%Hải Châu%' AND hd.ngay_lam_hop_dong = '2019-12-12';

/*22. Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành
“Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn
này.*/

UPDATE v_nhan_vien
SET dia_chi = REPLACE(dia_chi, 'Hải Châu', 'Liên Chiểu');

/*23. Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của
một khách hàng nào đó với ma_khach_hang được truyền vào như là 1
tham số của sp_xoa_khach_hang.*/

DELIMITER //
DROP PROCEDURE IF EXISTS sp_xoa_khach_hang //
CREATE PROCEDURE sp_xoa_khach_hang(IN in_id INT)
BEGIN
	DELETE FROM khach_hang
    WHERE ma_khach_hang = in_id;
END //
DELIMITER ;

CALL sp_xoa_khach_hang(21);


/*24. Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào
bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện
kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được
trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên
quan.*/

DELIMITER //
DROP PROCEDURE IF EXISTS sp_them_moi_hop_dong //
CREATE PROCEDURE sp_them_moi_hop_dong(
IN in_ngay_lam_hop_dong datetime, 
IN in_ngay_ket_thuc datetime, 
IN in_tien_dat_coc double, 
IN in_ma_nhan_vien int, 
IN in_ma_khach_hang int, 
IN in_ma_dich_v int)
BEGIN
  INSERT INTO hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
values	(in_ngay_lam_hop_dong,in_ngay_ket_thuc,in_tien_dat_coc,in_ma_nhan_vien,in_ma_khach_hang,in_ma_dich_v);
END //
DELIMITER ;
CALL sp_them_moi_hop_dong('2020-12-08','2020-12-08',0,3,1,3);



/*25. Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng
hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng
hop_dong ra giao diện console của database.
Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc
ghi ở console.*/




/*26. Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc
hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không,
với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng
ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu
không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn
ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.

Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc
ghi ở console.*/



/*27. Tạo Function thực hiện yêu cầu sau:
a. Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng
với tổng tiền là &gt; 2.000.000 VNĐ.
b. Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời
gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp
đồng mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các
khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không
xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được
truyền vào như là 1 tham số của function này.*/





/*28. Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ
được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015
đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các
bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ
liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những
bản liên quan khác.*/