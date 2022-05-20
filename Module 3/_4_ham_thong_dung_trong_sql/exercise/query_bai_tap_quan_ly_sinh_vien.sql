-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
group by sub_id
having credit >= all (select max(credit) from subject group by sub_id);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.sub_id, s.sub_name, max(m.mark) from subject s
join mark m on s.sub_id = m.sub_id
group by s.sub_id
having max(m.mark) >= all (select max(mark) from mark group by mark.sub_id);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.student_id, s.student_name, avg(m.mark) as 'diem trung binh' from student s 
join mark m on s.student_id = m.student_id
group by student_id
order by avg(m.mark) desc;

