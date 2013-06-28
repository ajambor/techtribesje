DROP TABLE IF EXISTS talk;

CREATE TABLE talk (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(256) character set utf8 not null,
	  description varchar(10240) character set utf8 not null,
	  type char(1) not null,
    event_name varchar(128) not null,
    city varchar(32),
    country varchar(32) not null,
    content_source_id int not null,
    url varchar(256),
    talk_date DATE not null,
    slides_url varchar(256),
    video_url varchar(256),
    primary key (id));