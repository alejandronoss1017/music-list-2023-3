import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreUComponent } from './genre-u.component';

describe('GenreUComponent', () => {
  let component: GenreUComponent;
  let fixture: ComponentFixture<GenreUComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GenreUComponent]
    });
    fixture = TestBed.createComponent(GenreUComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
