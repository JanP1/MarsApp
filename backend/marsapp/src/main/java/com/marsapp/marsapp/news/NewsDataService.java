package com.marsapp.marsapp.news;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.marsapp.marsapp.exceptions.ResourceNotFoundException;

@Service
public class NewsDataService {

    private final NewsDataRepository newsDataRepository;

    public NewsDataService(NewsDataRepository newsDataRepository) {
        this.newsDataRepository = newsDataRepository;
    }

    public List<NewsData> getNewsForDate(LocalDate date) {

        List<NewsData> newsList = newsDataRepository.findByPublishedAt(date);
        
        if (newsList.isEmpty()) {
            throw new ResourceNotFoundException("Rover position for sol not found");
        }
        
        return newsList;

    }

    public List<NewsData> getNewsFromDayTillNow(LocalDate date) {

        List<NewsData> newsList = newsDataRepository.findByPublishedAtGreaterThanEqual(date);

        if (newsList.isEmpty()) {
            throw new ResourceNotFoundException("Rover position for sol not found");
        }

        return newsList;
    }

    
}
