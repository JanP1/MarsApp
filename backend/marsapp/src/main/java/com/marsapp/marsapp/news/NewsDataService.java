package com.marsapp.marsapp.news;


import org.springframework.stereotype.Service;

@Service
public class NewsDataService {

    private final NewsDataRepository newsDataRepository;

    public NewsDataService(NewsDataRepository newsDataRepository) {
        this.newsDataRepository = newsDataRepository;
    }


    
}
