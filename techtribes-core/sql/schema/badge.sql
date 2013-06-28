DROP TABLE IF EXISTS badge;

CREATE TABLE badge (
    badge_id int not null,
    content_source_id int not null,
    date DATETIME not null,
    primary key (badge_id, content_source_id));