-- Give grants to local user
GRANT ALL PRIVILEGES ON *.* To 'zeta_test'@'localhost' IDENTIFIED BY 'zeta_test';

-- Create database
CREATE DATABASE zeta_test;

-- Create Tables
CREATE TABLE users (
    user_id BIGINT primary key not null,
    phone_number varchar(13),
    email varchar(30),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY (phone_number),
    UNIQUE KEY (email)
);

CREATE TABLE accounts (
    account_id BIGINT primary key not null,
    user_id BIGINT not null,
    balance integer not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE postings (
    account_id BIGINT not null,
    posting_id BIGINT not null,
    posting_type varchar(10),
    amount integer not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key(account_id, posting_id)
);

insert into users(user_id, phone_number, email) values(0, '+918813886000', 'teat0@zeta.tech');
insert into users(user_id, phone_number, email) values(1, '+918813886001', 'teat1@zeta.tech');
insert into users(user_id, phone_number, email) values(2, '+918813884002', 'teat2@zeta.tech');
insert into users(user_id, phone_number, email) values(3, '+918813886003', 'teat3@zeta.tech');
insert into users(user_id, phone_number, email) values(4, '+918813886004', 'teat4@zeta.tech');
insert into users(user_id, phone_number, email) values(5, '+918813886005', 'teat5@zeta.tech');
insert into users(user_id, phone_number, email) values(6, '+918813886006', 'teat6@zeta.tech');
insert into users(user_id, phone_number, email) values(7, '+918813886007', 'teat7@zeta.tech');
insert into users(user_id, phone_number, email) values(8, '+918813886008', 'teat8@zeta.tech');
insert into users(user_id, phone_number, email) values(9, '+918813886009', 'teat9@zeta.tech');

insert into accounts(account_id, user_id, balance) values(1, 1, 0);
insert into accounts(account_id, user_id, balance) values(2, 1, 100);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(2, 1, 'CREDIT', 100, '2017-09-01');
insert into accounts(account_id, user_id, balance) values(3, 1, 330);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(3, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(3, 2, 'CREDIT', 20, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(3, 3, 'CREDIT', 50, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(3, 4, 'CREDIT', 130, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(3, 5, 'CREDIT', 30, '2017-09-02');
insert into accounts(account_id, user_id, balance) values(4, 1, 0);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 2, 'DEBIT', 10, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 3, 'DEBIT', 50, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 4, 'CREDIT', 200, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 5, 'CREDIT', 40, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 6, 'DEBIT', 70, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 7, 'DEBIT', 130, '2017-09-04');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(4, 8, 'DEBIT', 80, '2017-09-05');
insert into accounts(account_id, user_id, balance) values(5, 2, 120);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(5, 1, 'CREDIT', 100, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(5, 2, 'CREDIT', 40, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(5, 3, 'CREDIT', 30, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(5, 4, 'DEBIT', 100, '2017-09-04');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(5, 5, 'CREDIT', 50, '2017-09-04');
insert into accounts(account_id, user_id, balance) values(6, 2, 50);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(6, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(6, 2, 'CREDIT', 20, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(6, 3, 'DEBIT', 30, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(6, 4, 'CREDIT', 10, '2017-09-04');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(6, 5, 'DEBIT', 50, '2017-09-05');
insert into accounts(account_id, user_id, balance) values(7, 3, 30);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(7, 1, 'CREDIT', 100, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(7, 2, 'DEBIT', 70, '2017-09-05');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(7, 3, 'CREDIT', 70, '2017-09-05');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(7, 4, 'DEBIT', 70, '2017-09-05');
insert into accounts(account_id, user_id, balance) values(8, 4, 10);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 2, 'CREDIT', 20, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 3, 'DEBIT', 30, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 4, 'CREDIT', 10, '2017-09-04');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 5, 'DEBIT', 50, '2017-09-05');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 6, 'CREDIT', 10, '2017-09-05');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(8, 7, 'DEBIT', 50, '2017-09-05');
insert into accounts(account_id, user_id, balance) values(9, 5, 90);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(9, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(9, 2, 'CREDIT', 20, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(9, 3, 'DEBIT', 30, '2017-09-03');
insert into accounts(account_id, user_id, balance) values(10, 6, 200);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(10, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(10, 2, 'CREDIT', 100, '2017-09-01');
insert into accounts(account_id, user_id, balance) values(11, 7, 90);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 2, 'CREDIT', 20, '2017-09-02');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 3, 'DEBIT', 30, '2017-09-03');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 4, 'CREDIT', 110, '2017-09-04');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 5, 'DEBIT', 50, '2017-09-05');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 6, 'DEBIT', 10, '2017-09-05');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(11, 7, 'DEBIT', 50, '2017-09-05');
insert into accounts(account_id, user_id, balance) values(12, 8, 100);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(12, 1, 'CREDIT', 100, '2017-09-01');
insert into accounts(account_id, user_id, balance) values(13, 8, 70);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(13, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(13, 2, 'DEBIT', 20, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(13, 3, 'CREDIT', 150, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(13, 4, 'DEBIT', 130, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(13, 5, 'DEBIT', 30, '2017-09-01');
insert into accounts(account_id, user_id, balance) values(14, 9, 30);
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 1, 'CREDIT', 100, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 2, 'CREDIT', 40, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 3, 'DEBIT', 120, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 4, 'CREDIT', 200, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 5, 'DEBIT', 150, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 6, 'DEBIT', 70, '2017-09-01');
insert into postings(account_id, posting_id, posting_type, amount, created_at) values(14, 7, 'CREDIT', 30, '2017-09-01');
