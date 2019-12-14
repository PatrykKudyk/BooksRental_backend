create table book(
    id bigint not null auto_increment,
    title varchar(255) not null,
    author_id bigint not null,
    release_year int not null,
    pages int not null,
    is_thick_cover bool not null,
    publishing_house_id bigint not null,
    rental_id bigint not null,
    is_loan bool not null,
    constraint fk_author foreign key(author_id)
    references author(id)
    on delete cascade
    on update cascade,
    constraint fk_publishing_house foreign key(publishing_house_id)
    references publishing_house(id)
    on delete cascade
    on update cascade,
    constraint fk_rental foreign key(rental_id)
    references rental(id)
    on delete cascade
    on update cascade,
    primary key(id)
)