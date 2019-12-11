create table rental(
    id bigint not null auto_increment,
    book_id bigint not null,
    location_id bigint not null,
    constraint fk_book foreign key(book_id)
    references book(id)
    on delete cascade
    on update cascade,
    constraint fk_location_2 foreign key(location_id)
    references location(id)
    on delete cascade
    on update cascade,
    primary key(id)
)