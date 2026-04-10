INSERT INTO weather_data_avg (sol, low, high)
SELECT 
    s, 
    floor(random() * ((-40) - (-80) + 1) + (-80))::int,
    floor(random() * (10 - (-30) + 1) + (-30))::int
FROM generate_series(1, 100) AS s;
