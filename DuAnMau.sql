USE DuAnMau 
go
create table NhanVien
(MaNV nvarchar(50) Not null,
 Passwords nvarchar(50) not null,
 Fullname nvarchar(50) not null,
 Roles bit not null,
 Primary Key(MaNV)
 )
 create table ChuyenDe
 ( MaCD Nchar(5) not null,
 TenCD nvarchar(50) not null,
 HocPhi Float not null,
 ThoiLuong int not null,
 Hinh nvarchar(255) not null,
 MoTa nvarchar(255) not null,
 Primary Key(MaCD)
 )
 Go
 Create table KhoaHoc

 ( MaKH int identity(1,1) not null,
  MaCD nchar(5) not null,
  HocPhi Float not null,
  ThoiLuong int not null,
  NgayKG Date Not null,
  GhiChu nvarchar(50) null,
  MaNV Nvarchar(50) not null,
  NgayTao Date not null,
  Primary key(MaKH),
  Foreign key(MaCD) references ChuyenDe(MaCD) on delete no action on update cascade,
  Foreign key(MaNV) references NhanVien(MaNV) on delete no action on update cascade
  
  )
  --GO
  Create table NguoiHoc
  (MaNH nchar(7) not null,
  Hoten nvarchar(50) not null,
  NgaySinh Date not null,
  GioiTinh bit not null,
  DienThoai nvarchar(50) not null,
  Email nvarchar(50) not null,
  GhiChu nvarchar(max) null,
  MaNV nvarchar(50) not null,
  NgayDK Date not null,
  Primary key(MaNH),
  Foreign key(MaNV) REFERENCES NhanVien(MaNV) on delete no action on update cascade
  )
  GO

  Create table HocVien
  (MaHV int identity(1,1) not null,
  MaKH int not null,
  MaNH nchar(7) not null,
  Grade float not null,
  primary key(MaHV),
  Foreign key(MaNH) REFERENCES NguoiHoc(MaNH) on delete no action on update cascade,
  Foreign key(MaKH) REFERENCES KhoaHoc(MaKH) on delete no action 
  --Foreign key(MaKH) REFERENCES KhoaHoc(MaKH) on delete no action on update cascade
  )
  CREATE TRIGGER update_HocVien_KhoaHoc ON KhoaHoc for update
  AS 
  begin
  update HocVien set MaKH = (select MaKH from inserted )
  where MaKH like (select MaKH from deleted )
  end 
  go
  --Tra ve ma nguoi hoc , ho ten va diem cua nguoi do
  Create proc sp_BangDiem(@MaKH int)
  as begin 
  select nh.MaNH,nh.Hoten,hv.Grade
  from HocVien hv inner join NguoiHoc nh on nh.MaNH=hv.MaNH
  where hv.MaKH = @MaKH
  order by hv.Grade DESC
  end
  go
  --tra ve ten chuyen de - so hoc vien - diem thap nhat - diem cao nhat - trung binh 
  create proc sp_ThongKeDiem
  as begin 
  select TenCD ChuyenDe,
  COUNT(MaHV) SoHV,
  Min(Grade) ThapNhat,
  MAX(Grade) CaoNhat,
  AVG(Grade) TrungBinh
  from KhoaHoc kh
  join HocVien hv on kh.MaKH = hv.MaKH
  join ChuyenDe cd on cd.MaCD = kh.MaCD
  group by TenCD
  end 
  go
  -- tra ve ten chuyen de - so khoa hoc - so hoc vien - doanh thu - thap nhat - cao nhat - trung binh 
  create proc sp_ThongKeDoanhThu(@year int)
  as begin
  select 
  TenCD ChuyenDe,
  COUNT(DISTINCT kh.MaKH) SoKH,
  COUNT(hv.MaHV) SoHV,
  SUM(kh.HocPhi) Doanhthu,
  MIN(kh.HocPhi) Thapnhat,
  MAX(kh.HocPhi) Caonhat,
  AVG(kh.HocPhi) TrungBinh
  from KhoaHoc kh
  inner join HocVien hv on kh.MaKH= hv.MaKH
  inner join ChuyenDe cd on cd.MaCD= kh.MaCD
  Where YEAR(NgayKG) = @year
  group by TenCD
  end
  go
  -- tra ve nam - so luong - dautien - cuoicung
  create proc sp_ThongKeNguoiHoc
  as begin 
  select YEAR(NgayDK) Nam,
  COUNT(*) SoLuong,
  Min(NgayDK) Dautien,
  Max(NgayDK) CuoiCung
  from NguoiHoc
  group by YEAR(NgayDK)
  end

  --INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh, MoTa) VALUES(?,?,?,?,?,?)
  --UPDATE ChuyenDe SET MaCD=?,TenCD=?,HocPhi=?,ThoiLuong =?,Hinh=?,MoTa=?,WHERE MaCD=?
  --DELETE FROM ChuyenDe Where MaCD = ?
  --SELECT * from ChuyenDe WHERE MaCD=?

  

