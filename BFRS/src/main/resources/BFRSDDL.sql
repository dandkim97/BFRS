--login
insert into login(id, username, pswrd, first_name, last_name, is_admin, loyalty_status)
    select login_seq.nextVal, 'tomt', 'tom', 'Tom', 'Tom', 1, 1 from dual;
insert into login(id, username, pswrd, first_name, last_name, is_admin, loyalty_status)
    select login_seq.nextVal, 'bobb', 'bob', 'Bob', 'Bob', 0, 0 from dual;
insert into login(id, username, pswrd, first_name, last_name, is_admin, loyalty_status)
    select login_seq.nextVal, 'amya', 'amy', 'Amy', 'Amy', 0, 1 from dual;

--plane
insert into plane(id, model, seats, avg_rating)
    select plane_seq.nextVal, 'American Airlines', 150, 5 from dual;
insert into plane(id, model, seats, avg_rating)
    select plane_seq.nextVal, 'United Airlines', 160, 4 from dual;
insert into plane(id, model, seats, avg_rating)
    select plane_seq.nextVal, 'JetBlue Airways', 170, 3 from dual;
insert into plane(id, model, seats, avg_rating)
    select plane_seq.nextVal, 'Delta Air Lines', 180, 2 from dual;
insert into plane(id, model, seats, avg_rating)
    select plane_seq.nextVal, 'Spirit Airlines', 190, 1 from dual;
insert into plane(id, model, seats, avg_rating)
    select plane_seq.nextVal, 'Allegiant Air', 200, 4 from dual;

--trip
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
    select trip_seq.nextVal, 50, 5, 'Ohio', 'Virginia', '2020-01-02 13:00:00', '2020-01-02 14:00:00', 114.16, 'On Time' from dual;
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
    select trip_seq.nextVal, 30, 4, 'North Carloina', 'California', '2020-01-03 14:00:00', '2020-01-03 20:30:00', 257.62, 'On Time' from dual;
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
    select trip_seq.nextVal, 90, 3, 'West Virginia', 'Florida', '2020-01-04 15:00:00', '2020-01-04 16:30:00', 94.39, 'On Time' from dual;
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
    select trip_seq.nextVal, 100, 2, 'Washington', 'Nevada', '2020-01-05 16:00:00', '2020-01-05 22:00:00', 346.58, 'On Time' from dual;
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
    select trip_seq.nextVal, 75, 1, 'Georgia', 'Montana', '2020-01-06 17:00:00', '2020-01-07 23:30:00', 524.78, 'On Time' from dual;
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
    select trip_seq.nextVal, 50, 6, 'Alabama', 'Colorado', '2020-01-06 17:00:00', '2020-01-07 20:30:00', 374.91, 'On Time' from dual;

commit;