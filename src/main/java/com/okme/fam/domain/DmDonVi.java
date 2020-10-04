package com.okme.fam.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A DmDonVi.
 */
@Document(collection = "dm_don_vi")
public class DmDonVi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 0, max = 20)
    @Field("ma")
    private String ma;

    @Field("ten")
    private String ten;

    @Field("tong_ld")
    private Long tongLd;

    @Field("tong_luong")
    private Long tongLuong;

    @Field("loai_dv")
    private String loaiDv;

    @Field("diachi")
    private String diachi;

    @Field("dienthoai")
    private String dienthoai;

    @Field("fax")
    private String fax;

    @Field("so_tai_khoan")
    private String soTaiKhoan;

    @Field("ngan_hang")
    private String nganHang;

    @Field("ma_cqbh")
    private String maCqbh;

    @Field("ma_tinh")
    private String maTinh;

    @Field("ma_huyen")
    private String maHuyen;

    @Field("so_dkkd")
    private String soDkkd;

    @Field("ma_st")
    private String maSt;

    @Field("nguoi_lh")
    private String nguoiLh;

    @Field("ma_dvikcb")
    private String maDvikcb;

    @Field("ma_khoikcb")
    private String maKhoikcb;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public DmDonVi ma(String ma) {
        this.ma = ma;
        return this;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public DmDonVi ten(String ten) {
        this.ten = ten;
        return this;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Long getTongLd() {
        return tongLd;
    }

    public DmDonVi tongLd(Long tongLd) {
        this.tongLd = tongLd;
        return this;
    }

    public void setTongLd(Long tongLd) {
        this.tongLd = tongLd;
    }

    public Long getTongLuong() {
        return tongLuong;
    }

    public DmDonVi tongLuong(Long tongLuong) {
        this.tongLuong = tongLuong;
        return this;
    }

    public void setTongLuong(Long tongLuong) {
        this.tongLuong = tongLuong;
    }

    public String getLoaiDv() {
        return loaiDv;
    }

    public DmDonVi loaiDv(String loaiDv) {
        this.loaiDv = loaiDv;
        return this;
    }

    public void setLoaiDv(String loaiDv) {
        this.loaiDv = loaiDv;
    }

    public String getDiachi() {
        return diachi;
    }

    public DmDonVi diachi(String diachi) {
        this.diachi = diachi;
        return this;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public DmDonVi dienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
        return this;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getFax() {
        return fax;
    }

    public DmDonVi fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public DmDonVi soTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
        return this;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getNganHang() {
        return nganHang;
    }

    public DmDonVi nganHang(String nganHang) {
        this.nganHang = nganHang;
        return this;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getMaCqbh() {
        return maCqbh;
    }

    public DmDonVi maCqbh(String maCqbh) {
        this.maCqbh = maCqbh;
        return this;
    }

    public void setMaCqbh(String maCqbh) {
        this.maCqbh = maCqbh;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public DmDonVi maTinh(String maTinh) {
        this.maTinh = maTinh;
        return this;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public DmDonVi maHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
        return this;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getSoDkkd() {
        return soDkkd;
    }

    public DmDonVi soDkkd(String soDkkd) {
        this.soDkkd = soDkkd;
        return this;
    }

    public void setSoDkkd(String soDkkd) {
        this.soDkkd = soDkkd;
    }

    public String getMaSt() {
        return maSt;
    }

    public DmDonVi maSt(String maSt) {
        this.maSt = maSt;
        return this;
    }

    public void setMaSt(String maSt) {
        this.maSt = maSt;
    }

    public String getNguoiLh() {
        return nguoiLh;
    }

    public DmDonVi nguoiLh(String nguoiLh) {
        this.nguoiLh = nguoiLh;
        return this;
    }

    public void setNguoiLh(String nguoiLh) {
        this.nguoiLh = nguoiLh;
    }

    public String getMaDvikcb() {
        return maDvikcb;
    }

    public DmDonVi maDvikcb(String maDvikcb) {
        this.maDvikcb = maDvikcb;
        return this;
    }

    public void setMaDvikcb(String maDvikcb) {
        this.maDvikcb = maDvikcb;
    }

    public String getMaKhoikcb() {
        return maKhoikcb;
    }

    public DmDonVi maKhoikcb(String maKhoikcb) {
        this.maKhoikcb = maKhoikcb;
        return this;
    }

    public void setMaKhoikcb(String maKhoikcb) {
        this.maKhoikcb = maKhoikcb;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmDonVi)) {
            return false;
        }
        return id != null && id.equals(((DmDonVi) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmDonVi{" +
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
