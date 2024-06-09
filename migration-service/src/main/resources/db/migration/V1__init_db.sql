DROP TABLE IF EXISTS VIDEOS CASCADE;
DROP TABLE IF EXISTS VIDEO_METADATA CASCADE;

CREATE TABLE VIDEOS (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    content TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE VIDEO_METADATA (
    video_id BIGINT NOT NULL,
    title VARCHAR(255),
    synopsis VARCHAR(255),
    director VARCHAR(255),
    video_cast VARCHAR(255),
    year SMALLINT,
    genre VARCHAR(255),
    running_time BIGINT,
    is_deleted BOOLEAN,
    primary key (video_id)
);