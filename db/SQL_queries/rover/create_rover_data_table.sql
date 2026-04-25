CREATE TABLE rover_data (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sol INTEGER NOT NULL,
    lat DOUBLE PRECISION NOT NULL,
    lon DOUBLE PRECISION NOT NULL,
    elevation DOUBLE PRECISION,

    geom geometry(Point, 4326)
    GENERATED ALWAYS AS (
        ST_SetSRID(ST_MakePoint(lon, lat), 4326)
    ) STORED
);


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
