-- THEM MOI 
insert into class (class_id, class_name, stastudentrt_date, status)
values	(1, 'A1', '2008-12-20', 1),
		(2, 'A2', '2008-12-22', 1),
		(3, 'B3', current_date, 0);
        
insert into student (student_name, address, phone, status, class_id)
values	('Hung', 'Ha Noi', '0912113113', 1, 1),
		('Hoa', 'Hai phong','0912113121', 1, 1),
		('Manh', 'HCM', '0123123123', 0, 2);       
        
insert into subject
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
        
insert into mark (sub_id, student_id, mark, exam_times)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
-- QUERY
-- Hiển thị danh sách tất cả các học viên
select * from student;

-- Hiển thị danh sách các học viên đang theo học.
select * from student
where status = 1;

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.
select * from subject
where  credit < 10;

-- Hiển thị danh sách học viên lớp A1
select s.student_id, s.student_name, c.class_name 
from 
student s join class c on s.class_id = c.class_id;

-- Hiển thị điểm môn CF của các học viên.

select s.student_id, s.student_name, sub.sub_name, m.mark
from
student s join mark m on s.student_id = m.student_id join subject sub on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';








