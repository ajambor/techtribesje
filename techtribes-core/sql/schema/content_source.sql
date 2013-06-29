DROP TABLE IF EXISTS content_source;

CREATE TABLE content_source (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(128) not null,
    twitter_id varchar(32),
    github_id varchar(64),
    island char(1),
    type char(1) not null,
    feed_url1 varchar(512),
    feed_url2 varchar(512),
    feed_url3 varchar(512),
    profile_text varchar(512) character set utf8,
    profile_image_url varchar(512),
    url varchar(512),
    content_aggregated bit not null default 1,
    twitter_followers int not null default 0,
    search_terms varchar(1024),
    primary key (id));