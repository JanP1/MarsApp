package com.marsapp.marsapp.weather;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataAvgRepository extends JpaRepository<WeatherDataAvg, Long>{ 
    public Optional<WeatherDataAvg> findFirstByOrderBySolDesc();
}
