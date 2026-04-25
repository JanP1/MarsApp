package com.marsapp.marsapp.rover;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoverDataRepository extends JpaRepository<RoverData, Long> {
    public Optional<RoverData> findFirstByOrderBySolDesc();
    public List<RoverData> findBySolBetween(int startSol, int endSol);
    public List<RoverData> findBySolGreaterThanEqual(int startSol);


    // Search for all the points inside the provided box
    @Query(value = """
        SELECT *
        FROM rover_data
        WHERE geom && ST_MakeEnvelope(:xmin, :ymin, :xmax, :ymax, 4326)
        """, nativeQuery = true)
    List<RoverData> findInBBox(
        @Param("xmin") double xmin,
        @Param("ymin") double ymin,
        @Param("xmax") double xmax,
        @Param("ymax") double ymax
    );
}
