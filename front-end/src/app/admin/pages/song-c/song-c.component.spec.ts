import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongCComponent } from './song-c.component';

describe('SongCComponent', () => {
  let component: SongCComponent;
  let fixture: ComponentFixture<SongCComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SongCComponent]
    });
    fixture = TestBed.createComponent(SongCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
