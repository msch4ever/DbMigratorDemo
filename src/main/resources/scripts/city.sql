create table WORLD.city
(
    ID          int auto_increment
        primary key,
    Name        varchar(35) default '' not null,
    CountryCode char(3)     default '' not null,
    District    char(20)    default '' not null,
    Population  int         default 0  not null,
    constraint city_country_fk
        foreign key (CountryCode) references WORLD.country (Code)
);

create index City_CountryCode
    on WORLD.city (CountryCode);
