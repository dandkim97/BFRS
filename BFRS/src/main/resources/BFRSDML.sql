drop table LOGIN cascade constraints;
drop table PLANE cascade constraints;
drop table FORMS cascade constraints;
drop table TRIP cascade constraints;
drop table LOGIN_TRIP cascade constraints;
drop table REVIEW cascade constraints;
drop sequence login_seq;

create table login (
    id number primary key,
    username varchar2(25),
    pswrd varchar2(25),
    first_name varchar2(25),
    last_name varchar2(25),
    is_admin number(10),
    loyalty_status number
);
create table plane (
    id number primary key,
    model varchar2(25),
    seats number,
    avg_rating number
);
create table forms (
    id number primary key,
    num_seats number,
    num_bags number,
    plane_class varchar2(25),
    is_round number
);
create table trip (
    id number primary key,
    seats_taken number,
    plane_id number,
    trip_from varchar2(25),
    trip_to varchar2(25),
    departure timestamp,
    arrival timestamp,
    price number(7,2),
    constraint fk_trip_plane foreign key (plane_id)
        references plane(id)
);
create table login_trip (
    id number primary key,
    trip_id number,
    login_id number,
    constraint fk_login_login_trip foreign key (login_id)
        references login(id),
    constraint fk_trip_login_trip foreign key (trip_id)
        references trip(id)
);
create table review (
    id number primary key,
    plane_id number,
    rating number,
    constraint fk_review_plane foreign key (plane_id)
        references plane(id)
);

create sequence login_seq;