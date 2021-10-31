create table weather
(
    id                   bigint       not null
        constraint weather_pkey
            primary key,
    room_id              bigint       not null
        constraint fk_room
            references room,
    atmospheric_pressure varchar(255) not null,
    co2                  varchar(255),
    date                 timestamp    not null,
    humidity             varchar(255) not null,
    temperature          varchar(255) not null
);

alter table weather
    owner to postgres;