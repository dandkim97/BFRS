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
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(1,0,5,'Ohio','Virginia',  '2020-01-02 13:00:00',  '2020-01-02 14:00:00', 100.0 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(2,3,4,'Ohio','Michigan',  '2020-01-03 14:00:00',  '2020-01-03 16:00:00', 200.0 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(3,2,3,'Texas','Ohio',  '2020-01-04 15:00:00',  '2020-01-04 18:00:00', 301.1 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(4,1,2,'Wyoming','Ohio',  '2020-01-05 16:00:00',  '2020-01-05 20:00:00', 250.2 );
insert into trip(id, seats_taken, plane_id, trip_from, trip_to, departure, arrival, price)
values(5,2,1,'Michigan','Alaska',  '2020-01-06 17:00:00',  '2020-01-06 23:00:00', 400.0 );

commit;