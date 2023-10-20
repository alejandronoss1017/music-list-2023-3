import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreRComponent } from './genre-r.component';

describe('GenreRComponent', () => {
  let component: GenreRComponent;
  let fixture: ComponentFixture<GenreRComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GenreRComponent]
    });
    fixture = TestBed.createComponent(GenreRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
