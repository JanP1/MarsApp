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
    public List<NewsData> getNewsForDate(
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {

        return newsDataService.getNewsForDate(date);
    }


    @GetMapping
    public List<NewsData> getNewsFromDayTillNow(
            @RequestParam(name = "from")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from
    ) {
        return newsDataService.getNewsFromDayTillNow(from);
    }


}
