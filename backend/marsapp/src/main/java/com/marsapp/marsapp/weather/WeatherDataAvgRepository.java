package com.marsapp.marsapp.weather;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataAvgRepository extends JpaRepository<WeatherDataAvg, Long>{ 
    public Optional<WeatherDataAvg> findFirstByOrderBySolDesc();
    public List<WeatherDataAvg> findFirst7ByOrderBySolDesc();
    public Optional<WeatherDataAvg> findBySol(String sol);
}
