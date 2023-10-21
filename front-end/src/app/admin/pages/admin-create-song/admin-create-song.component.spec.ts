import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateSongComponent } from './admin-create-song.component';

describe('AdminCreateSongComponent', () => {
  let component: AdminCreateSongComponent;
  let fixture: ComponentFixture<AdminCreateSongComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminCreateSongComponent]
    });
    fixture = TestBed.createComponent(AdminCreateSongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
