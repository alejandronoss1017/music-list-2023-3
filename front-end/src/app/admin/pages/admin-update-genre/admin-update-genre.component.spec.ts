import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateGenreComponent } from './admin-update-genre.component';

describe('AdminUpdateGenreComponent', () => {
  let component: AdminUpdateGenreComponent;
  let fixture: ComponentFixture<AdminUpdateGenreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUpdateGenreComponent]
    });
    fixture = TestBed.createComponent(AdminUpdateGenreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
