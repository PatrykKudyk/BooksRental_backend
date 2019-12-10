create table books(
    id bigint not null auto_increment,
    title varchar(255) not null,
    authorId bigint not null,
    releaseYear int not null,
    pages int not null,
    isThickCover bool not null,
    publishingHouseId bigint not null,
    isLoan bool not null,
    constraint fk_author foreign key(authorId)
    references authors(id)
    on delete cascade
    on update cascade,
    constraint fk_publishing_house foreign key(publishingHouseId)
    references publishingHouses(id)
    on delete cascade
    on update cascade,
    primary key(id)
)