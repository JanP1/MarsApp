package com.marsapp.marsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.marsapp.marsapp.model.WeatherDataAvg;

@Repository
public interface WeatherDataAvgRepository extends JpaRepository<WeatherDataAvg, Long>{ 
    public WeatherDataAvg findFirstByOrderBySolDesc();
}
