insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (23,'Tennis Court 1', 0, 80, 4000, 200);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (24,'Tennis Court 2', 5, 15.5, 5000, 50);
Insert into cd.bookings(facid,memid,starttime,slots)  values (23,9,'2012-09-21',3);
Insert into cd.bookings(facid,memid,starttime,slots)  values (24,10,'2012-09-21',5);
Select  bk.starttime,fac.name from
cd.bookings as bk inner join cd.facilities as fac on bk.facid=fac.facid
where fac.name
in ('Tennis Court 2','Tennis Court 1') 
and bk.starttime >= '2012-09-21' and bk.starttime < '2012-09-22' order by bk.starttime;