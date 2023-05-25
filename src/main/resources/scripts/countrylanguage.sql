create table WORLD.countrylanguage
(
    CountryCode char(3)         default ''  not null,
    Language    char(30)        default ''  not null,
    IsOfficial  enum ('T', 'F') default 'F' not null,
    Percentage  decimal(4, 1)   default 0.0 not null,
    primary key (CountryCode, Language),
    constraint countryLanguage_fk
        foreign key (CountryCode) references WORLD.country (Code)
);

create index Language_CountryCode
    on WORLD.countrylanguage (CountryCode);
