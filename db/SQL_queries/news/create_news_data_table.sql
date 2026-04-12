CREATE TABLE news_data (
    id BIGSERIAL PRIMARY KEY,
    published_at DATE,
    url TEXT,
    image_url TEXT,
    news_site VARCHAR(255),
    summary TEXT
);
