CREATE TABLE rover_data (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sol INTEGER NOT NULL,
    lat NUMERIC NOT NULL,
    lon NUMERIC NOT NULL,
    elevation NUMERIC,
    -- The Geometry column (Point, WGS84)
    geom GEOMETRY(Point, 4326)
);

-- The "Magic" Index for 400k points
CREATE INDEX idx_rover_data_geom ON rover_data USING GIST (geom);

-- CREATE TABLE rover_data (
--     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     sol INTEGER NOT NULL,
--     lat NUMERIC NOT NULL,
--     lon NUMERIC NOT NULL,
--     elevation NUMERIC NOT NULL
--
-- );
-- CREATE TABLE rover_data (
--     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     sol INTEGER NOT NULL,
--     lat NUMERIC NOT NULL,
--     lon NUMERIC NOT NULL,
--     elevation NUMERIC NOT NULL
--
-- );
