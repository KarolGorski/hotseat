import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EcinemaComponent } from './ecinema.component';

describe('EcinemaComponent', () => {
  let component: EcinemaComponent;
  let fixture: ComponentFixture<EcinemaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EcinemaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EcinemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
