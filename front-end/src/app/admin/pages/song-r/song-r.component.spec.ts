import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongRComponent } from './song-r.component';

describe('SongRComponent', () => {
  let component: SongRComponent;
  let fixture: ComponentFixture<SongRComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SongRComponent]
    });
    fixture = TestBed.createComponent(SongRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
