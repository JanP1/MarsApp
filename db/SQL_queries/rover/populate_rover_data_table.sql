INSERT INTO rover_data (sol, lat, lon, elevation)
SELECT 
    s AS sol, 
    (random() * 100)::int AS lat, 
    (random() * 100)::int AS lon,
    (random() * 100)::int AS elevation

FROM generate_series(1, 100) AS s;
