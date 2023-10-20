import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSongComponent } from './admin-song.component';

describe('AdminSongComponent', () => {
  let component: AdminSongComponent;
  let fixture: ComponentFixture<AdminSongComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminSongComponent]
    });
    fixture = TestBed.createComponent(AdminSongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
