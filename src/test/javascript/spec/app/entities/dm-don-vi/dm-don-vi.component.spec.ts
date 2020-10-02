import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, convertToParamMap } from '@angular/router';

import { OkmeTestModule } from '../../../test.module';
import { DmDonViComponent } from 'app/entities/dm-don-vi/dm-don-vi.component';
import { DmDonViService } from 'app/entities/dm-don-vi/dm-don-vi.service';
import { DmDonVi } from 'app/shared/model/dm-don-vi.model';

describe('Component Tests', () => {
  describe('DmDonVi Management Component', () => {
    let comp: DmDonViComponent;
    let fixture: ComponentFixture<DmDonViComponent>;
    let service: DmDonViService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OkmeTestModule],
        declarations: [DmDonViComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: of({
                defaultSort: 'id,asc',
              }),
              queryParamMap: of(
                convertToParamMap({
                  page: '1',
                  size: '1',
                  sort: 'id,desc',
                })
              ),
            },
          },
        ],
      })
        .overrideTemplate(DmDonViComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DmDonViComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DmDonViService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DmDonVi('123')],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dmDonVis && comp.dmDonVis[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DmDonVi('123')],
            headers,
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dmDonVis && comp.dmDonVis[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});
