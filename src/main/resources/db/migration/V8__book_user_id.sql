ALTER TABLE book
    ADD  user_id bigint AFTER rental_id,
    add constraint fk_user foreign key(user_id)
        references user(id)
        on delete cascade
        on update cascade;
