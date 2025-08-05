INSERT INTO TaiKhoan(name, password, isAdmin) values (N'taikhoan1', '12345678', 1);
INSERT INTO TaiKhoan(name, password, isAdmin) values (N'taikhoan2', '12345678', 0);

INSERT INTO TruongHoc (ten_truong) VALUES (N'Truong THPT Chuyen Ha Noi - Amsterdam');
INSERT INTO TruongHoc (ten_truong) VALUES (N'Truong THPT Nguyen Hue');
INSERT INTO TruongHoc (ten_truong) VALUES (N'Truong THPT Le Quy Don');
INSERT INTO TruongHoc (ten_truong) VALUES (N'Truong THPT Phan Dinh Phung');
INSERT INTO TruongHoc (ten_truong) VALUES (N'Truong THPT Chu Van An');

INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Nguyen Van An', 17, 1, 1);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Le Thi Bich', 18, 1, 1);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Tran Quoc Toan', 17, 1, 2);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Pham Hoang Nam', 18, 0, 2);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Hoang Minh Anh', 17, 1, 3);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Ngo Khanh Linh', 18, 0, 3);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Vu Gia Huy', 18, 1, 4);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Le Thuy Trang', 17, 1, 4);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Pham Minh Chau', 17, 1, 5);
INSERT INTO HocSinh (ten_hoc_sinh, tuoi, dang_hoc, truong_hoc_id) VALUES (N'Dang Hong Son', 18, 1, 5);
