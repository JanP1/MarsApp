import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoverScreen } from './rover-screen';

describe('RoverScreen', () => {
  let component: RoverScreen;
  let fixture: ComponentFixture<RoverScreen>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RoverScreen],
    }).compileComponents();

    fixture = TestBed.createComponent(RoverScreen);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
