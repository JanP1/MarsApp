package com.marsapp.marsapp.news;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDataRepository extends JpaRepository<NewsData, Long> {
    public List<NewsData> findByPublishedAtGreaterThanEqual(LocalDate startDate);
    public List<NewsData> findByPublishedAt(LocalDate date);

}
