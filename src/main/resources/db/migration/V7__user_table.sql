create table user(
    id bigint not null auto_increment,
    name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
    login varchar(20) not null,
    password varchar(32) not null,
    user_type varchar(255) not null,
    primary key(id)
);

