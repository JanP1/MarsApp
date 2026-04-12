package com.marsapp.marsapp.news;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDataRepository extends JpaRepository<NewsData, Long> {
}
