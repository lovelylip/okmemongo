package com.okme.fam.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.okme.fam.domain.DmDonVi} entity.
 */
public class DmDonViDTO implements Serializable {
    
    private String id;

    @NotNull
    @Size(min = 0, max = 20)
    private String ma;

    private String ten;

    private Long tongLd;

    private Long tongLuong;

    private String loaiDv;

    private String diachi;

    private String dienthoai;

    private String fax;

    private String soTaiKhoan;

    private String nganHang;

    private String maCqbh;

    private String maTinh;

    private String maHuyen;

    private String soDkkd;

    private String maSt;

    private String nguoiLh;

    private String maDvikcb;

    private String maKhoikcb;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Long getTongLd() {
        return tongLd;
    }

    public void setTongLd(Long tongLd) {
        this.tongLd = tongLd;
    }

    public Long getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(Long tongLuong) {
        this.tongLuong = tongLuong;
    }

    public String getLoaiDv() {
        return loaiDv;
    }

    public void setLoaiDv(String loaiDv) {
        this.loaiDv = loaiDv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getMaCqbh() {
        return maCqbh;
    }

    public void setMaCqbh(String maCqbh) {
        this.maCqbh = maCqbh;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getSoDkkd() {
        return soDkkd;
    }

    public void setSoDkkd(String soDkkd) {
        this.soDkkd = soDkkd;
    }

    public String getMaSt() {
        return maSt;
    }

    public void setMaSt(String maSt) {
        this.maSt = maSt;
    }

    public String getNguoiLh() {
        return nguoiLh;
    }

    public void setNguoiLh(String nguoiLh) {
        this.nguoiLh = nguoiLh;
    }

    public String getMaDvikcb() {
        return maDvikcb;
    }

    public void setMaDvikcb(String maDvikcb) {
        this.maDvikcb = maDvikcb;
    }

    public String getMaKhoikcb() {
        return maKhoikcb;
    }

    public void setMaKhoikcb(String maKhoikcb) {
        this.maKhoikcb = maKhoikcb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmDonViDTO)) {
            return false;
        }

        return id != null && id.equals(((DmDonViDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmDonViDTO{" +
            "id=" + getId() +
            ", ma='" + getMa() + "'" +
            ", ten='" + getTen() + "'" +
            ", tongLd=" + getTongLd() +
            ", tongLuong=" + getTongLuong() +
            ", loaiDv='" + getLoaiDv() + "'" +
            ", diachi='" + getDiachi() + "'" +
            ", dienthoai='" + getDienthoai() + "'" +
            ", fax='" + getFax() + "'" +
            ", soTaiKhoan='" + getSoTaiKhoan() + "'" +
            ", nganHang='" + getNganHang() + "'" +
            ", maCqbh='" + getMaCqbh() + "'" +
            ", maTinh='" + getMaTinh() + "'" +
            ", maHuyen='" + getMaHuyen() + "'" +
            ", soDkkd='" + getSoDkkd() + "'" +
            ", maSt='" + getMaSt() + "'" +
            ", nguoiLh='" + getNguoiLh() + "'" +
            ", maDvikcb='" + getMaDvikcb() + "'" +
            ", maKhoikcb='" + getMaKhoikcb() + "'" +
            "}";
    }
}
