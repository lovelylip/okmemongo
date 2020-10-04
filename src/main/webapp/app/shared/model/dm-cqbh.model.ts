import { Moment } from 'moment';

export interface IDmCqbh {
  id?: string;
  ma?: string;
  ten?: string;
  diaChi?: string;
  maXa?: string;
  maHuyen?: string;
  maTinh?: string;
  emailAcc?: string;
  phoneNumber?: string;
  status?: string;
  createDate?: Moment;
  activeDate?: Moment;
  inactiveDate?: Moment;
  maCqbhCha?: string;
  nguoiKy?: string;
  chucDanh?: string;
  tenNoiKy?: string;
  isActive?: string;
  path?: string;
  ngayKhoa?: number;
  ngayTemp?: string;
}

export class DmCqbh implements IDmCqbh {
  constructor(
    public id?: string,
    public ma?: string,
    public ten?: string,
    public diaChi?: string,
    public maXa?: string,
    public maHuyen?: string,
    public maTinh?: string,
    public emailAcc?: string,
    public phoneNumber?: string,
    public status?: string,
    public createDate?: Moment,
    public activeDate?: Moment,
    public inactiveDate?: Moment,
    public maCqbhCha?: string,
    public nguoiKy?: string,
    public chucDanh?: string,
    public tenNoiKy?: string,
    public isActive?: string,
    public path?: string,
    public ngayKhoa?: number,
    public ngayTemp?: string
  ) {}
}
