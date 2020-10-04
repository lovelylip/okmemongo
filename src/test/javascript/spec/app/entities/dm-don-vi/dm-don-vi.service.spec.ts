import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { DmDonViService } from 'app/entities/dm-don-vi/dm-don-vi.service';
import { IDmDonVi, DmDonVi } from 'app/shared/model/dm-don-vi.model';

describe('Service Tests', () => {
  describe('DmDonVi Service', () => {
    let injector: TestBed;
    let service: DmDonViService;
    let httpMock: HttpTestingController;
    let elemDefault: IDmDonVi;
    let expectedResult: IDmDonVi | IDmDonVi[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DmDonViService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new DmDonVi(
        'ID',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find('123').subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a DmDonVi', () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new DmDonVi()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a DmDonVi', () => {
        const returnedFromService = Object.assign(
          {
            ma: 'BBBBBB',
            ten: 'BBBBBB',
            tongLd: 1,
            tongLuong: 1,
            loaiDv: 'BBBBBB',
            diachi: 'BBBBBB',
            dienthoai: 'BBBBBB',
            fax: 'BBBBBB',
            soTaiKhoan: 'BBBBBB',
            nganHang: 'BBBBBB',
            maCqbh: 'BBBBBB',
            maTinh: 'BBBBBB',
            maHuyen: 'BBBBBB',
            soDkkd: 'BBBBBB',
            maSt: 'BBBBBB',
            nguoiLh: 'BBBBBB',
            maDvikcb: 'BBBBBB',
            maKhoikcb: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of DmDonVi', () => {
        const returnedFromService = Object.assign(
          {
            ma: 'BBBBBB',
            ten: 'BBBBBB',
            tongLd: 1,
            tongLuong: 1,
            loaiDv: 'BBBBBB',
            diachi: 'BBBBBB',
            dienthoai: 'BBBBBB',
            fax: 'BBBBBB',
            soTaiKhoan: 'BBBBBB',
            nganHang: 'BBBBBB',
            maCqbh: 'BBBBBB',
            maTinh: 'BBBBBB',
            maHuyen: 'BBBBBB',
            soDkkd: 'BBBBBB',
            maSt: 'BBBBBB',
            nguoiLh: 'BBBBBB',
            maDvikcb: 'BBBBBB',
            maKhoikcb: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a DmDonVi', () => {
        service.delete('123').subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
