DROP TABLE IF EXISTS activity;

CREATE TABLE activity (
    content_source_id int NOT NULL,
    international_talks int NOT NULL DEFAULT 0,
    local_talks int NOT NULL DEFAULT 0,
    content int NOT NULL DEFAULT 0,
    tweets int NOT NULL DEFAULT 0,
    events int NOT NULL DEFAULT 0,
    last_activity_datetime DATETIME NOT NULL,
    activity_datetime DATETIME NOT NULL,
    primary key (content_source_id, activity_datetime));