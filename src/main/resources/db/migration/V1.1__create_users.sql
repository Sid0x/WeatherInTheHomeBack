create table users
(
    id       bigint       not null
        constraint users_pkey
            primary key,
    username varchar(255) not null,
    password varchar(255) not null
);

alter table users
    owner to postgres;

insert into users
values (nextval('hibernate_sequence'), 'esp32', '$2a$10$gneIbKFXi4EdiNGAwGryvOHqeO3P1jFp/QVZJOzP2pm2GmprYNPDy');