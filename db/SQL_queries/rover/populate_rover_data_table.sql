INSERT INTO rover_data (sol, lat, lon)
SELECT 
    s AS sol, 
    (random() * 100)::int AS lat, 
    (random() * 100)::int AS lon
FROM generate_series(1, 100) AS s;
