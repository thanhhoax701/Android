package com.example.newfirebasedatabase;

public class SinhVien {
    public String HoTen;
    public String DiaChi;
    public Integer NamSinh;

    public SinhVien() {
        // Mặc định của firebase yêu cầu có 1 constructor rỗng khi nhận data
    }

    public SinhVien(String hoTen, String diaChi, Integer namSinh) {
        HoTen = hoTen;
        DiaChi = diaChi;
        NamSinh = namSinh;
    }
}
