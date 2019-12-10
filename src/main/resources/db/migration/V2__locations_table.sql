create table locations(
    id bigint not null auto_increment,
    state varchar(255) not null,
    city varchar(255) not null,
    zipCode varchar(255) not null,
    street varchar(255) not null,
    buildingNumber int not null,
    officeNumber varchar(255) not null,
    primary key(id)
)