DROP TABLE IF EXISTS job;

CREATE TABLE job (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(256) character set utf8 not null,
	description varchar(10240) character set utf8 not null,
	island char(1) not null,
    content_source_id int,
    url varchar(256),
    date_posted DATE not null,
    primary key (id));