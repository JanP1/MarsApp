package com.marsapp.marsapp.rover;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rover_data")
public class RoverData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int sol;

    @Column(name = "lat")
    private int lattitude;

    @Column(name = "lon")
    private int longitude;

    @Column(name = "elevation")
    private int elevation;

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
    public int getLongitude() {
        return longitude;
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    public int getLattitude() {
        return lattitude;
    }
    public void setLattitude(int lattitude) {
        this.lattitude = lattitude;
    }
    public int getElevation() {
        return elevation;
    }
    public void setElevation(int elevation) {
        this.elevation = elevation;
    }
    
}
