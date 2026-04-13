CREATE TABLE news_author_map (
    news_id BIGINT REFERENCES news_data(id) ON DELETE CASCADE,
    author_id BIGINT REFERENCES authors(id) ON DELETE CASCADE,
    PRIMARY KEY (news_id, author_id)
);
