import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarsMapComponent } from './mars-map-component';

describe('MarsMapComponent', () => {
  let component: MarsMapComponent;
  let fixture: ComponentFixture<MarsMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MarsMapComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(MarsMapComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
