insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Guest', 'Guest', '17 Tunia Drive, Boston', 32678, '(811) 433-2527', 17, '2016-03-15');
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (41,'Gym Sport Room 1', 5, 15.5, 5000, 50);
Insert into cd.bookings(facid,memid,starttime,slots)  values (35,41,'2015-09-07',25);
Select name, rank from (
Select fac.name, rank() over 
(order by sum(case when memid = 0 then slots * fac.guestcost
else slots * fac.membercost end) desc) as rank from cd.bookings as bk
inner join cd.facilities as fac on bk.facid = fac.facid
group by fac.name) as subq where rank <= 3 order by rank;  