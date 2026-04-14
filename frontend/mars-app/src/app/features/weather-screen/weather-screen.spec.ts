import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeatherScreen } from './weather-screen';

describe('WeatherScreen', () => {
  let component: WeatherScreen;
  let fixture: ComponentFixture<WeatherScreen>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WeatherScreen],
    }).compileComponents();

    fixture = TestBed.createComponent(WeatherScreen);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
