import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongUComponent } from './song-u.component';

describe('SongUComponent', () => {
  let component: SongUComponent;
  let fixture: ComponentFixture<SongUComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SongUComponent]
    });
    fixture = TestBed.createComponent(SongUComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
