export interface IDmDonVi {
  id?: string;
  ma?: string;
  ten?: string;
  tongLd?: number;
  tongLuong?: number;
  loaiDv?: string;
  diachi?: string;
  dienthoai?: string;
  fax?: string;
  soTaiKhoan?: string;
  nganHang?: string;
  maCqbh?: string;
  maTinh?: string;
  maHuyen?: string;
  soDkkd?: string;
  maSt?: string;
  nguoiLh?: string;
  maDvikcb?: string;
  maKhoikcb?: string;
}

export class DmDonVi implements IDmDonVi {
  constructor(
    public id?: string,
    public ma?: string,
    public ten?: string,
    public tongLd?: number,
    public tongLuong?: number,
    public loaiDv?: string,
    public diachi?: string,
    public dienthoai?: string,
    public fax?: string,
    public soTaiKhoan?: string,
    public nganHang?: string,
    public maCqbh?: string,
    public maTinh?: string,
    public maHuyen?: string,
    public soDkkd?: string,
    public maSt?: string,
    public nguoiLh?: string,
    public maDvikcb?: string,
    public maKhoikcb?: string
  ) {}
}
