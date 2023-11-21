import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateGenreComponent } from './admin-create-genre.component';

describe('AdminCreateGenreComponent', () => {
  let component: AdminCreateGenreComponent;
  let fixture: ComponentFixture<AdminCreateGenreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminCreateGenreComponent]
    });
    fixture = TestBed.createComponent(AdminCreateGenreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
