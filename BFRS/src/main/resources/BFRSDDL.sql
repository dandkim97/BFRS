--plane
insert into plane(id, model, seats, avg_rating)
values(1,'Boeing707', 10, 5);
insert into plane(id, model, seats, avg_rating)
values(2,'Boeing720', 20, 4);
insert into plane(id, model, seats, avg_rating)
values(3,'Boeing727', 30, 3);
insert into plane(id, model, seats, avg_rating)
values(4,'Boeing737', 40, 2);
insert into plane(id, model, seats, avg_rating)
values(5,'Boeing747', 50, 1);
--trip
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
values(1,0,5,'Ohio','Virginia',  '2020-01-02 13:00:00',  '2020-01-02 14:00:00', 100.0, 'On Time');
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
values(2,3,4,'Ohio','Michigan',  '2020-01-03 14:00:00',  '2020-01-03 16:00:00', 200.0, 'On Time' );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
values(3,2,3,'Texas','Ohio',  '2020-01-04 15:00:00',  '2020-01-04 18:00:00', 301.1, 'On Time' );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
values(4,1,2,'Wyoming','Ohio',  '2020-01-05 16:00:00',  '2020-01-05 20:00:00', 250.2, 'On Time' );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price, status)
values(5,2,1,'Michigan','Alaska',  '2020-01-06 17:00:00',  '2020-01-06 23:00:00', 400.0, 'On Time' );

commit;

--plane
insert into plane(id, model, seats, avg_rating)
values(1,'American Airlines', 380, 5);
insert into plane(id, model, seats, avg_rating)
values(2,'United Airlines', 290, 4);
insert into plane(id, model, seats, avg_rating)
values(3,'Jet Blue', 180, 3);
insert into plane(id, model, seats, avg_rating)
values(4,'Delta', 250, 2);
insert into plane(id, model, seats, avg_rating)
values(5,'Spirit', 130, 1);
commit;
--trip
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(1,50,5,'Ohio','Virginia',  '2020-01-02 13:00:00',  '2020-01-02 14:00:00', 100.0 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(2,30,4,'Ohio','Michigan',  '2020-01-03 14:00:00',  '2020-01-03 16:00:00', 200.0 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(3,90,3,'Texas','Ohio',  '2020-01-04 15:00:00',  '2020-01-04 18:00:00', 301.1 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(4,100,2,'Wyoming','Ohio',  '2020-01-05 16:00:00',  '2020-01-05 20:00:00', 250.2 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(5,75,1,'Michigan','Alaska',  '2020-01-06 17:00:00',  '2020-01-06 23:00:00', 400.0 );

commit;

insert into login(id, username, pswrd, first_name,last_name,is_admin,loyalty_status)
values(1,'kit','cat','a','gaw',0,0);
insert into login(id, username, pswrd, first_name,last_name,is_admin,loyalty_status)
values(2,'may','june','judy','sim',0,0);
commit;

insert into forms(id, num_seats, num_bags, plane_class, is_round, trip_id, login_id)
values(1,2,3,'economy',0,1,1);
insert into forms(id, num_seats, num_bags, plane_class, is_round, trip_id, login_id)
values(2,3,4,'business',0,5,1);
insert into forms(id, num_seats, num_bags, plane_class, is_round, trip_id, login_id)
values(3,1,1,'economy',0,5,2);
insert into forms(id, num_seats, num_bags, plane_class, is_round, trip_id, login_id)
values(4,1,1,'economy',0,4,1);
commit;


insert into login_trip(id, trip_id, login_id, trip_cost)
values(1,1,1,330);
insert into login_trip(id, trip_id, login_id, trip_cost)
values(2,5,1,280);
insert into login_trip(id, trip_id, login_id, trip_cost)
values(3,5,2,190);
insert into login_trip(id, trip_id, login_id, trip_cost)
values(4,4,1,177);
commit;

insert into tripview(id, login_id, username, model, trip_from, trip_to, departure, arrival, num_seats, is_round, trip_cost)
values(1,1,'kit','Spirit','Ohio','Virginia',  '2020-01-02 13:00:00',  '2020-01-02 14:00:00',2,0,330.0 );
insert into tripview(id, login_id, username, model, trip_from, trip_to, departure, arrival, num_seats, is_round, trip_cost)
values(2,1,'kit', 'American Airlines','Michigan','Alaska',  '2020-01-06 17:00:00',  '2020-01-06 23:00:00',3,0,280.0 );
insert into tripview(id, login_id, username, model, trip_from, trip_to, departure, arrival, num_seats, is_round, trip_cost)
values(3,2,'may','American Airlines','Michigan','Alaska',  '2020-01-06 17:00:00',  '2020-01-06 23:00:00',1,0,190.0 );
insert into tripview(id, login_id, username, model, trip_from, trip_to, departure, arrival, num_seats, is_round, trip_cost)
values(4,1,'kit','Delta','Wyoming','Ohio',  '2020-01-05 16:00:00',  '2020-01-05 20:00:00',1,0,177.0 );
commit;
