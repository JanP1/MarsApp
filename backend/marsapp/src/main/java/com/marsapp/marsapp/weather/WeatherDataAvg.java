package com.marsapp.marsapp.weather;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_data_avg")
public class WeatherDataAvg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int sol;

    @Column(nullable = false)
    private int high;

    @Column(nullable = false)
    private int low;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getSol() {
        return sol;
    }
    public void setSol(int sol) {
        this.sol = sol;
    }
    public int getHigh() {
        return high;
    }
    public void setHigh(int high) {
        this.high = high;
    }
    public int getLow() {
        return low;
    }
    public void setLow(int low) {
        this.low = low;
    }
}
