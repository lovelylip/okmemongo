package com.okme.fam.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.okme.fam.domain.DmCqbh} entity.
 */
public class DmCqbhDTO implements Serializable {
    
    private String id;

    @NotNull
    private String ma;

    private String ten;

    private String diaChi;

    private String maXa;

    private String maHuyen;

    private String maTinh;

    private String emailAcc;

    private String phoneNumber;

    private String status;

    private LocalDate createDate;

    private LocalDate activeDate;

    private LocalDate inactiveDate;

    private String maCqbhCha;

    private String nguoiKy;

    private String chucDanh;

    private String tenNoiKy;

    private String isActive;

    private String path;

    private Long ngayKhoa;

    private String ngayTemp;

    
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaXa() {
        return maXa;
    }

    public void setMaXa(String maXa) {
        this.maXa = maXa;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getEmailAcc() {
        return emailAcc;
    }

    public void setEmailAcc(String emailAcc) {
        this.emailAcc = emailAcc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
    }

    public LocalDate getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getMaCqbhCha() {
        return maCqbhCha;
    }

    public void setMaCqbhCha(String maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getTenNoiKy() {
        return tenNoiKy;
    }

    public void setTenNoiKy(String tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getNgayKhoa() {
        return ngayKhoa;
    }

    public void setNgayKhoa(Long ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
    }

    public String getNgayTemp() {
        return ngayTemp;
    }

    public void setNgayTemp(String ngayTemp) {
        this.ngayTemp = ngayTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmCqbhDTO)) {
            return false;
        }

        return id != null && id.equals(((DmCqbhDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmCqbhDTO{" +
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
