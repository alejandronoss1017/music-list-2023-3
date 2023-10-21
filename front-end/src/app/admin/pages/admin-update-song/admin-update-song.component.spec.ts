import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateSongComponent } from './admin-update-song.component';

describe('AdminUpdateSongComponent', () => {
  let component: AdminUpdateSongComponent;
  let fixture: ComponentFixture<AdminUpdateSongComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminUpdateSongComponent]
    });
    fixture = TestBed.createComponent(AdminUpdateSongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
