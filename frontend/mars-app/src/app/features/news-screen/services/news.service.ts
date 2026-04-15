import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { LocalDate } from "../../../core/model/local-date.model";
import { Observable } from "rxjs";
import { News } from "../models/news.model";
import { environment } from "../../../../environments/environment.development";

@Injectable({providedIn: 'root'})
export class NewsService {

  private readonly baseUrl = `${environment.apiUrl}/api/news`;

  constructor(private http: HttpClient) {}

  getNewsFromDateUntilLatest(from: LocalDate): Observable<News[]> {
    const params = new HttpParams().set('from', from.toString());

    return this.http.get<News[]>(this.baseUrl, { params });
  }
}
