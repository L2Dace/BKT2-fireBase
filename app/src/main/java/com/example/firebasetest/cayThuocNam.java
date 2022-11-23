package com.example.firebasetest;

public class cayThuocNam {
    private String tenKH,tenThuongGoi;
    private int hinhAnh;

    public cayThuocNam(String tenKH, String tenThuongGoi, int hinhAnh) {
        this.tenKH = tenKH;
        this.tenThuongGoi = tenThuongGoi;
        this.hinhAnh = hinhAnh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenThuongGoi() {
        return tenThuongGoi;
    }

    public void setTenThuongGoi(String tenThuongGoi) {
        this.tenThuongGoi = tenThuongGoi;
    }
    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
