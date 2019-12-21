create table rental(
    id bigint not null auto_increment,
    name varchar(255) not null,
    location_id bigint not null,
    constraint fk_location_2 foreign key(location_id)
    references location(id)
    on delete cascade
    on update cascade,
    primary key(id)
)