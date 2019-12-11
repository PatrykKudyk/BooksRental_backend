create table location(
    id bigint not null auto_increment,
    state varchar(255) not null,
    city varchar(255) not null,
    zip_code varchar(255) not null,
    street varchar(255) not null,
    building_number int not null,
    office_number varchar(255) not null,
    primary key(id)
)