CREATE TABLE news_authors (
    news_id BIGINT NOT NULL,
    name VARCHAR(255),
    x_link TEXT,
    youtube_link TEXT,
    instagram_link TEXT,
    
    -- Foreign key to link back to news_data
    CONSTRAINT fk_news_data 
        FOREIGN KEY (news_id) 
        REFERENCES news_data(id) 
        ON DELETE CASCADE
);
