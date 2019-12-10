create table authors(
    id bigint not null auto_increment,
    name varchar(255) not null,
    lastName varchar(255) not null,
    age int not null,
    primary key(id)
)