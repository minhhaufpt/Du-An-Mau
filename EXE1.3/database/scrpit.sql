USE [master]
GO
/****** Object:  Database [DuAnMau]    Script Date: 10/10/2022 12:13:44 PM ******/
CREATE DATABASE [DuAnMau]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DuAnMau', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENMINHHAU\MSSQL\DATA\DuAnMau.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DuAnMau_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENMINHHAU\MSSQL\DATA\DuAnMau_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DuAnMau] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DuAnMau].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DuAnMau] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DuAnMau] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DuAnMau] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DuAnMau] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DuAnMau] SET ARITHABORT OFF 
GO
ALTER DATABASE [DuAnMau] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DuAnMau] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DuAnMau] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DuAnMau] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DuAnMau] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DuAnMau] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DuAnMau] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DuAnMau] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DuAnMau] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DuAnMau] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DuAnMau] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DuAnMau] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DuAnMau] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DuAnMau] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DuAnMau] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DuAnMau] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DuAnMau] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DuAnMau] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DuAnMau] SET  MULTI_USER 
GO
ALTER DATABASE [DuAnMau] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DuAnMau] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DuAnMau] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DuAnMau] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DuAnMau] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DuAnMau] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DuAnMau] SET QUERY_STORE = OFF
GO
USE [DuAnMau]
GO
/****** Object:  User [minhhau]    Script Date: 10/10/2022 12:13:44 PM ******/
CREATE USER [minhhau] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[ChuyenDe]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChuyenDe](
	[MaCD] [nvarchar](5) NOT NULL,
	[TenCD] [nvarchar](50) NOT NULL,
	[HocPhi] [float] NOT NULL,
	[ThoiLuong] [int] NOT NULL,
	[Hinh] [nvarchar](255) NULL,
	[MoTa] [nvarchar](255) NULL,
 CONSTRAINT [PK__ChuyenDe__27258E04EC12FEF9] PRIMARY KEY CLUSTERED 
(
	[MaCD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocVien]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocVien](
	[MaHV] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [int] NOT NULL,
	[MaNH] [nchar](7) NOT NULL,
	[Grade] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhoaHoc]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhoaHoc](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[MaCD] [nvarchar](5) NOT NULL,
	[HocPhi] [float] NOT NULL,
	[ThoiLuong] [int] NOT NULL,
	[NgayKG] [date] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[NgayTao] [date] NOT NULL,
 CONSTRAINT [PK__KhoaHoc__2725CF1E4C61B62A] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiHoc]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiHoc](
	[MaNH] [nchar](7) NOT NULL,
	[Hoten] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DienThoai] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](max) NULL,
	[MaNV] [nvarchar](50) NOT NULL,
	[NgayDK] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[Passwords] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Roles] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'CD01', N'Java1', 1200000, 10, N'1631038470-Ent-JavaProgramming.jpg', N'Java cơ bản')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'CD02', N'HTML/CSS', 1231444, 10, NULL, N'Tạo trang web')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'CD03', N'SQL Server', 21314441, 10, NULL, N'Server')
GO
SET IDENTITY_INSERT [dbo].[HocVien] ON 

INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Grade]) VALUES (2, 10, N'NH02   ', 6)
INSERT [dbo].[HocVien] ([MaHV], [MaKH], [MaNH], [Grade]) VALUES (3, 10, N'NH01   ', 10)
SET IDENTITY_INSERT [dbo].[HocVien] OFF
GO
SET IDENTITY_INSERT [dbo].[KhoaHoc] ON 

INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (10, N'CD01', 1200000, 10, CAST(N'2022-08-07' AS Date), N'Java cơ bản', N'minhhau', CAST(N'2022-10-09' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (11, N'CD01', 1200000, 10, CAST(N'2021-03-08' AS Date), N'Java nâng cao', N'minhhau', CAST(N'2022-10-09' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (12, N'CD02', 1231444, 10, CAST(N'2022-05-05' AS Date), N'html css nang cao', N'minhhau', CAST(N'2022-10-09' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (13, N'CD03', 21314441, 10, CAST(N'2021-12-11' AS Date), N'Server', N'minhhau', CAST(N'2022-10-09' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (14, N'CD01', 1200000, 10, CAST(N'2022-10-20' AS Date), N'none', N'minhhau', CAST(N'2021-10-10' AS Date))
INSERT [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (15, N'CD01', 1200000, 10, CAST(N'2003-12-12' AS Date), N'Java cơ bản 2', N'minhhau', CAST(N'2022-10-09' AS Date))
SET IDENTITY_INSERT [dbo].[KhoaHoc] OFF
GO
INSERT [dbo].[NguoiHoc] ([MaNH], [Hoten], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'NH01   ', N'Nguyễn Minh Hậu', CAST(N'2004-02-06' AS Date), 1, N'034241241', N'haunguyen@gmail.com', N'Học sinh', N'minhhau', CAST(N'2022-10-09' AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [Hoten], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'NH02   ', N'Nguyễn Ngọc Ánh Hoa', CAST(N'2001-01-20' AS Date), 0, N'10241515125', N'hoa@gmail.com', N'hoa nek', N'minhhau', CAST(N'2022-10-09' AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [Hoten], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'NH03   ', N'Nguyễn Minh Tâm', CAST(N'2002-10-10' AS Date), 1, N'064566666', N'tam@gmail.com', N'chào', N'minhhau', CAST(N'2022-10-09' AS Date))
GO
INSERT [dbo].[NhanVien] ([MaNV], [Passwords], [Fullname], [Roles]) VALUES (N'anhhoa', N'1234', N'Nguyễn Ngọc Ánh Hoa', 0)
INSERT [dbo].[NhanVien] ([MaNV], [Passwords], [Fullname], [Roles]) VALUES (N'minhhau', N'123', N'Nguyễn Minh Hậu', 1)
INSERT [dbo].[NhanVien] ([MaNV], [Passwords], [Fullname], [Roles]) VALUES (N'tantam', N'1234', N'Nguyễn Tấn Tâm', 0)
GO
ALTER TABLE [dbo].[HocVien]  WITH CHECK ADD  CONSTRAINT [FK__HocVien__MaKH__3E52440B] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhoaHoc] ([MaKH])
GO
ALTER TABLE [dbo].[HocVien] CHECK CONSTRAINT [FK__HocVien__MaKH__3E52440B]
GO
ALTER TABLE [dbo].[HocVien]  WITH CHECK ADD FOREIGN KEY([MaNH])
REFERENCES [dbo].[NguoiHoc] ([MaNH])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD  CONSTRAINT [FK__KhoaHoc__MaCD__286302EC] FOREIGN KEY([MaCD])
REFERENCES [dbo].[ChuyenDe] ([MaCD])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[KhoaHoc] CHECK CONSTRAINT [FK__KhoaHoc__MaCD__286302EC]
GO
ALTER TABLE [dbo].[KhoaHoc]  WITH CHECK ADD  CONSTRAINT [FK__KhoaHoc__MaNV__29572725] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[KhoaHoc] CHECK CONSTRAINT [FK__KhoaHoc__MaNV__29572725]
GO
ALTER TABLE [dbo].[NguoiHoc]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON UPDATE CASCADE
GO
/****** Object:  StoredProcedure [dbo].[sp_BangDiem]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 Create proc [dbo].[sp_BangDiem](@MaKH int)
  as begin 
  select nh.MaNH,nh.Hoten,hv.Grade
  from HocVien hv inner join NguoiHoc nh on nh.MaNH=hv.MaNH
  where hv.MaKH = @MaKH
  order by hv.Grade DESC
  end
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeDiem]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  --tra ve ten chuyen de - so hoc vien - diem thap nhat - diem cao nhat - trung binh 
  create proc [dbo].[sp_ThongKeDiem]
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
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeDoanhThu]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  -- tra ve ten chuyen de - so khoa hoc - so hoc vien - doanh thu - thap nhat - cao nhat - trung binh 
  create proc [dbo].[sp_ThongKeDoanhThu](@year int)
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
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeNguoiHoc]    Script Date: 10/10/2022 12:13:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sp_ThongKeNguoiHoc]
  as begin 
  select YEAR(NgayDK) as 'Nam',
  COUNT(*) as 'SoLuong',
  Min(NgayDK) as 'Dautien',
  Max(NgayDK) as 'CuoiCung'
  from NguoiHoc
  group by YEAR(NgayDK)
  end
GO
USE [master]
GO
ALTER DATABASE [DuAnMau] SET  READ_WRITE 
GO
