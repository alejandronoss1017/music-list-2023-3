import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMainPageComponent } from './admin-main-page.component';

describe('AdminMainPageComponent', () => {
  let component: AdminMainPageComponent;
  let fixture: ComponentFixture<AdminMainPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminMainPageComponent]
    });
    fixture = TestBed.createComponent(AdminMainPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
