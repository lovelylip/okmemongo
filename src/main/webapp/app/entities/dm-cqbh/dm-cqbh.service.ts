import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IDmCqbh } from 'app/shared/model/dm-cqbh.model';

type EntityResponseType = HttpResponse<IDmCqbh>;
type EntityArrayResponseType = HttpResponse<IDmCqbh[]>;

@Injectable({ providedIn: 'root' })
export class DmCqbhService {
  public resourceUrl = SERVER_API_URL + 'api/dm-cqbhs';

  constructor(protected http: HttpClient) {}

  create(dmCqbh: IDmCqbh): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmCqbh);
    return this.http
      .post<IDmCqbh>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(dmCqbh: IDmCqbh): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(dmCqbh);
    return this.http
      .put<IDmCqbh>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: string): Observable<EntityResponseType> {
    return this.http
      .get<IDmCqbh>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IDmCqbh[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: string): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(dmCqbh: IDmCqbh): IDmCqbh {
    const copy: IDmCqbh = Object.assign({}, dmCqbh, {
      createDate: dmCqbh.createDate && dmCqbh.createDate.isValid() ? dmCqbh.createDate.format(DATE_FORMAT) : undefined,
      activeDate: dmCqbh.activeDate && dmCqbh.activeDate.isValid() ? dmCqbh.activeDate.format(DATE_FORMAT) : undefined,
      inactiveDate: dmCqbh.inactiveDate && dmCqbh.inactiveDate.isValid() ? dmCqbh.inactiveDate.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.createDate = res.body.createDate ? moment(res.body.createDate) : undefined;
      res.body.activeDate = res.body.activeDate ? moment(res.body.activeDate) : undefined;
      res.body.inactiveDate = res.body.inactiveDate ? moment(res.body.inactiveDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((dmCqbh: IDmCqbh) => {
        dmCqbh.createDate = dmCqbh.createDate ? moment(dmCqbh.createDate) : undefined;
        dmCqbh.activeDate = dmCqbh.activeDate ? moment(dmCqbh.activeDate) : undefined;
        dmCqbh.inactiveDate = dmCqbh.inactiveDate ? moment(dmCqbh.inactiveDate) : undefined;
      });
    }
    return res;
  }
}
