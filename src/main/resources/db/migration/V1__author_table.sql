create table author(
    id bigint not null auto_increment,
    name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null,
    primary key(id)
)