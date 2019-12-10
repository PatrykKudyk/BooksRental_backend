create table rentals(
    id bigint not null auto_increment,
    bookId bigint not null,
    locationId bigint not null,
    constraint fk_book foreign key(bookId)
    references books(id)
    on delete cascade
    on update cascade,
    constraint fk_location_2 foreign key(locationId)
    references locations(id)
    on delete cascade
    on update cascade,
    primary key(id)
)