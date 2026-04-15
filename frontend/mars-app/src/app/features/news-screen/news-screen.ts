import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { News } from './models/news.model';
import { NewsService } from './services/news.service';
import { LocalDate } from '../../core/model/local-date.model';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-news-screen',
  imports: [AsyncPipe],
  templateUrl: './news-screen.html',
  styleUrl: './news-screen.scss',
})
export class NewsScreen {
  newsList$!: Observable<News[]>;

  constructor(private newsService: NewsService) {}

  ngOnInit(): void {

    const startDate = new LocalDate(2026, 1, 1);

    this.newsList$ = this.newsService.getNewsFromDateUntilLatest(startDate);
  }
}
