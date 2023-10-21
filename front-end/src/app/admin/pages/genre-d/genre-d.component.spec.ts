import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreDComponent } from './genre-d.component';

describe('GenreDComponent', () => {
  let component: GenreDComponent;
  let fixture: ComponentFixture<GenreDComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GenreDComponent]
    });
    fixture = TestBed.createComponent(GenreDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
