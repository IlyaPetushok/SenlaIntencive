insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Farrell', 'David', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 2, '2016-03-15');
Insert into cd.bookings(facid,memid,starttime,slots)  values (10,13,'2022-06-25',2);
Select cd.bookings.starttime From cd.bookings Inner Join cd.members on
cd.bookings.memid = cd.members.memid
where cd.members.firstname='David' and cd.members.surname='Farrell';