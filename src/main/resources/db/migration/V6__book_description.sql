ALTER TABLE book
    ADD description varchar(500) not null
        AFTER is_loan;