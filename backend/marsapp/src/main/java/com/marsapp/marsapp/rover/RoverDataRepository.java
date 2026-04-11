package com.marsapp.marsapp.rover;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverDataRepository extends JpaRepository<RoverData, Long> {
    public Optional<RoverData> findFirstByOrderBySolDesc();
    public List<RoverData> findBySolBetween(int startSol, int endSol);
    public List<RoverData> findBySolGreaterThanEqual(int startSol);
}
