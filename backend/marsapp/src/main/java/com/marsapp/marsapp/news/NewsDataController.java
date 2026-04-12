package com.marsapp.marsapp.news;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/news")
public class NewsDataController {

    private final NewsDataService newsDataService;

    public NewsDataController(NewsDataService newsDataService) {
        this.newsDataService = newsDataService;
    }


    @GetMapping
    public List<NewsData> getNews(
            @RequestParam(name = "date", required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            
            @RequestParam(name = "from", required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from
    ) {
        if (date != null) {
            return newsDataService.getNewsForDate(date);
        } else if (from != null) {
            return newsDataService.getNewsFromDayTillNow(from);
        }
        
        throw new IllegalArgumentException("Either 'date' or 'from' parameter must be provided");
    }


}
