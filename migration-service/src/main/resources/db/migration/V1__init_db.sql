DROP TABLE IF EXISTS VIDEOS;

CREATE TABLE VIDEOS (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    content TEXT NOT NULL,
    PRIMARY KEY (id)
)