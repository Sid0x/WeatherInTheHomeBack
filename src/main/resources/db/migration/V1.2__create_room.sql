create table room
(
    id        bigint       not null
        constraint room_pkey
            primary key,
    room_name varchar(255) not null
);

alter table room
    owner to postgres;

insert into room
values (nextval('hibernate_sequence'), 'BEDROOM');
insert into room
values (nextval('hibernate_sequence'), 'KITCHEN');