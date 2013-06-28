DROP TABLE IF EXISTS tribe_member;

CREATE TABLE tribe_member (
    tribe_id int not null,
    person_id int not null,
    primary key (tribe_id, person_id));