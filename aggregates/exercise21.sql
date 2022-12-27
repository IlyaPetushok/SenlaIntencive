insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (48,'Gym Sport Room 123', 19, 35.5, 3500, 520);
Insert into cd.bookings(facid,memid,starttime,slots)  values (10,46,'2011-11-1',35);
Select fac.name as name,fac.initialoutlay/((sum(case
when memid = 0 then slots * fac.guestcost else slots * membercost end)/3)
 - fac.monthlymaintenance) as months
from cd.bookings as bk inner join cd.facilities as fac on bk.facid = fac.facid
group by fac.facid order by name; 