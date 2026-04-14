import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsScreen } from './news-screen';

describe('NewsScreen', () => {
  let component: NewsScreen;
  let fixture: ComponentFixture<NewsScreen>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewsScreen],
    }).compileComponents();

    fixture = TestBed.createComponent(NewsScreen);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
