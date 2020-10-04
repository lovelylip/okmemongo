import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { DmCqbhService } from 'app/entities/dm-cqbh/dm-cqbh.service';
import { IDmCqbh, DmCqbh } from 'app/shared/model/dm-cqbh.model';

describe('Service Tests', () => {
  describe('DmCqbh Service', () => {
    let injector: TestBed;
    let service: DmCqbhService;
    let httpMock: HttpTestingController;
    let elemDefault: IDmCqbh;
    let expectedResult: IDmCqbh | IDmCqbh[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DmCqbhService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new DmCqbh(
        'ID',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            createDate: currentDate.format(DATE_FORMAT),
            activeDate: currentDate.format(DATE_FORMAT),
            inactiveDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        service.find('123').subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a DmCqbh', () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
            createDate: currentDate.format(DATE_FORMAT),
            activeDate: currentDate.format(DATE_FORMAT),
            inactiveDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createDate: currentDate,
            activeDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService
        );

        service.create(new DmCqbh()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a DmCqbh', () => {
        const returnedFromService = Object.assign(
          {
            ma: 'BBBBBB',
            ten: 'BBBBBB',
            diaChi: 'BBBBBB',
            maXa: 'BBBBBB',
            maHuyen: 'BBBBBB',
            maTinh: 'BBBBBB',
            emailAcc: 'BBBBBB',
            phoneNumber: 'BBBBBB',
            status: 'BBBBBB',
            createDate: currentDate.format(DATE_FORMAT),
            activeDate: currentDate.format(DATE_FORMAT),
            inactiveDate: currentDate.format(DATE_FORMAT),
            maCqbhCha: 'BBBBBB',
            nguoiKy: 'BBBBBB',
            chucDanh: 'BBBBBB',
            tenNoiKy: 'BBBBBB',
            isActive: 'BBBBBB',
            path: 'BBBBBB',
            ngayKhoa: 1,
            ngayTemp: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createDate: currentDate,
            activeDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of DmCqbh', () => {
        const returnedFromService = Object.assign(
          {
            ma: 'BBBBBB',
            ten: 'BBBBBB',
            diaChi: 'BBBBBB',
            maXa: 'BBBBBB',
            maHuyen: 'BBBBBB',
            maTinh: 'BBBBBB',
            emailAcc: 'BBBBBB',
            phoneNumber: 'BBBBBB',
            status: 'BBBBBB',
            createDate: currentDate.format(DATE_FORMAT),
            activeDate: currentDate.format(DATE_FORMAT),
            inactiveDate: currentDate.format(DATE_FORMAT),
            maCqbhCha: 'BBBBBB',
            nguoiKy: 'BBBBBB',
            chucDanh: 'BBBBBB',
            tenNoiKy: 'BBBBBB',
            isActive: 'BBBBBB',
            path: 'BBBBBB',
            ngayKhoa: 1,
            ngayTemp: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createDate: currentDate,
            activeDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a DmCqbh', () => {
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
