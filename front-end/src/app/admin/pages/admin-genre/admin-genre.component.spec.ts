import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGenreComponent } from './admin-genre.component';

describe('AdminGenreComponent', () => {
  let component: AdminGenreComponent;
  let fixture: ComponentFixture<AdminGenreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminGenreComponent]
    });
    fixture = TestBed.createComponent(AdminGenreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
