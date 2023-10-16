import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongDComponent } from './song-d.component';

describe('SongDComponent', () => {
  let component: SongDComponent;
  let fixture: ComponentFixture<SongDComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SongDComponent]
    });
    fixture = TestBed.createComponent(SongDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
