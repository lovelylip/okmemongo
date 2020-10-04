package com.okme.fam.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DmCqbh.
 */
@Document(collection = "dm_cqbh")
public class DmCqbh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("ma")
    private String ma;

    @Field("ten")
    private String ten;

    @Field("dia_chi")
    private String diaChi;

    @Field("ma_xa")
    private String maXa;

    @Field("ma_huyen")
    private String maHuyen;

    @Field("ma_tinh")
    private String maTinh;

    @Field("email_acc")
    private String emailAcc;

    @Field("phone_number")
    private String phoneNumber;

    @Field("status")
    private String status;

    @Field("create_date")
    private LocalDate createDate;

    @Field("active_date")
    private LocalDate activeDate;

    @Field("inactive_date")
    private LocalDate inactiveDate;

    @Field("ma_cqbh_cha")
    private String maCqbhCha;

    @Field("nguoi_ky")
    private String nguoiKy;

    @Field("chuc_danh")
    private String chucDanh;

    @Field("ten_noi_ky")
    private String tenNoiKy;

    @Field("is_active")
    private String isActive;

    @Field("path")
    private String path;

    @Field("ngay_khoa")
    private Long ngayKhoa;

    @Field("ngay_temp")
    private String ngayTemp;

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

    public DmCqbh ma(String ma) {
        this.ma = ma;
        return this;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public DmCqbh ten(String ten) {
        this.ten = ten;
        return this;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public DmCqbh diaChi(String diaChi) {
        this.diaChi = diaChi;
        return this;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaXa() {
        return maXa;
    }

    public DmCqbh maXa(String maXa) {
        this.maXa = maXa;
        return this;
    }

    public void setMaXa(String maXa) {
        this.maXa = maXa;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public DmCqbh maHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
        return this;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public DmCqbh maTinh(String maTinh) {
        this.maTinh = maTinh;
        return this;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getEmailAcc() {
        return emailAcc;
    }

    public DmCqbh emailAcc(String emailAcc) {
        this.emailAcc = emailAcc;
        return this;
    }

    public void setEmailAcc(String emailAcc) {
        this.emailAcc = emailAcc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public DmCqbh phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public DmCqbh status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public DmCqbh createDate(LocalDate createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getActiveDate() {
        return activeDate;
    }

    public DmCqbh activeDate(LocalDate activeDate) {
        this.activeDate = activeDate;
        return this;
    }

    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
    }

    public LocalDate getInactiveDate() {
        return inactiveDate;
    }

    public DmCqbh inactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getMaCqbhCha() {
        return maCqbhCha;
    }

    public DmCqbh maCqbhCha(String maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
        return this;
    }

    public void setMaCqbhCha(String maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public DmCqbh nguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
        return this;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public DmCqbh chucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
        return this;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getTenNoiKy() {
        return tenNoiKy;
    }

    public DmCqbh tenNoiKy(String tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
        return this;
    }

    public void setTenNoiKy(String tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
    }

    public String getIsActive() {
        return isActive;
    }

    public DmCqbh isActive(String isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getPath() {
        return path;
    }

    public DmCqbh path(String path) {
        this.path = path;
        return this;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getNgayKhoa() {
        return ngayKhoa;
    }

    public DmCqbh ngayKhoa(Long ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
        return this;
    }

    public void setNgayKhoa(Long ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
    }

    public String getNgayTemp() {
        return ngayTemp;
    }

    public DmCqbh ngayTemp(String ngayTemp) {
        this.ngayTemp = ngayTemp;
        return this;
    }

    public void setNgayTemp(String ngayTemp) {
        this.ngayTemp = ngayTemp;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmCqbh)) {
            return false;
        }
        return id != null && id.equals(((DmCqbh) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmCqbh{" +
            "id=" + getId() +
            ", ma='" + getMa() + "'" +
            ", ten='" + getTen() + "'" +
            ", diaChi='" + getDiaChi() + "'" +
            ", maXa='" + getMaXa() + "'" +
            ", maHuyen='" + getMaHuyen() + "'" +
            ", maTinh='" + getMaTinh() + "'" +
            ", emailAcc='" + getEmailAcc() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", status='" + getStatus() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", activeDate='" + getActiveDate() + "'" +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", maCqbhCha='" + getMaCqbhCha() + "'" +
            ", nguoiKy='" + getNguoiKy() + "'" +
            ", chucDanh='" + getChucDanh() + "'" +
            ", tenNoiKy='" + getTenNoiKy() + "'" +
            ", isActive='" + getIsActive() + "'" +
            ", path='" + getPath() + "'" +
            ", ngayKhoa=" + getNgayKhoa() +
            ", ngayTemp='" + getNgayTemp() + "'" +
            "}";
    }
}
