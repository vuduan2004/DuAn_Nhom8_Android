package duanvdph37524.fpoly.techstore_duan_nhom8.Model;

public class DienThoai {
    private String maDT, tenDienThoai,hinhAnh;
    private int giaTien, giaTienKM;

    public DienThoai(String maDT, String tenDienThoai, String hinhAnh, int giaTien, int giaTienKM) {
        this.maDT = maDT;
        this.tenDienThoai = tenDienThoai;
        this.hinhAnh = hinhAnh;
        this.giaTien = giaTien;
        this.giaTienKM = giaTienKM;
    }

    public DienThoai() {
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getGiaTienKM() {
        return giaTienKM;
    }

    public void setGiaTienKM(int giaTienKM) {
        this.giaTienKM = giaTienKM;
    }
}
