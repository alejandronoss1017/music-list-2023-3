import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreCComponent } from './genre-c.component';

describe('GenreCComponent', () => {
  let component: GenreCComponent;
  let fixture: ComponentFixture<GenreCComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GenreCComponent]
    });
    fixture = TestBed.createComponent(GenreCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
