drop table LOGIN cascade constraints;
drop table PLANE cascade constraints;
drop table FORMS cascade constraints;
drop table TRIP cascade constraints;
drop table LOGIN_TRIP cascade constraints;
drop table REVIEW cascade constraints;
drop table MESSAGE cascade constraints;

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
create table trip (
    id number primary key,
    seats_taken number,
    plane_id number,
    trip_from varchar2(25),
    trip_to varchar2(25),
    departure timestamp,
    arrival timestamp,
    price number(7,2),
    status varchar2(25),
    constraint fk_trip_plane foreign key (plane_id)
        references plane(id)
);
create table forms (
    id number primary key,
    num_seats number,
    num_bags number,
    plane_class varchar2(25),
    is_round number,
    trip_id number,
    constraint fk_forms_trip foreign key (trip_id)
        references trip(id)
);
create table login_trip (
    id number primary key,
    trip_id number,
    login_id number,
    trip_cost number,
    constraint fk_login_login_trip foreign key (login_id)
        references login(id),
    constraint fk_trip_login_trip foreign key (trip_id)
        references trip(id)
);
create table review (
    id number primary key,
    customer_id number,
    plane_id number,
    rating number,
    constraint fk_review_plane foreign key (plane_id)
        references plane(id),
    constraint fk_review_login foreign key (customer_id)
        references login(id)
);
create table message (
    id number primary key,
    asker_id number,
    asked_id number references login(id),
    status varchar2(25),
    type varchar2(25),
    quest varchar2(256),
    answer varchar2(256),
    constraint fk_message_login foreign key (asker_id)
        references login(id)
);

drop sequence login_seq;
drop sequence msg_seq;
drop sequence plane_seq;
drop sequence trip_seq;
drop sequence form_seq;
drop sequence review_seq;
create sequence login_seq;
create sequence msg_seq;
create sequence plane_seq;
create sequence trip_seq;
create sequence form_seq;
create sequence review_seq;

create or replace procedure approve_message
(asker_id_in in number, 
message_id_in in number, 
message_status_in in varchar2, 
message_answer_in in varchar2)
as
cursor messages
    is
        select * from message;
begin
    update login set loyalty_status = 1 where id = asker_id_in;
    update message set status = message_status_in, answer = message_answer_in where id = message_id_in;
    commit;
end approve_message;
/