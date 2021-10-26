drop table if exists MOVIE;
create table MOVIE (
                       mId bigint not null,
                       director varchar(255),
                       title varchar(255),
                       year integer,
                       primary key (mId)
);

drop table if exists RATING;
create table REVIEWER (
                          rId bigint not null,
                          name varchar(255),
                          primary key (rId)
);

drop table if exists RATING;
create table RATING (
                        mId bigint not null,
                        rId bigint not null,
                        ratingDate date,
                        stars integer,
                        primary key (mId, rId, stars)
);