Insert into cd.bookings(facid,memid,starttime,slots)  values (6,7,'2011-02-24',7);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (38,'Gym 1', 3, 10.5, 4250, 500);
Select f.name, sum(bk.slots * (
Case when bk.memid = 0 then fac.guestcost else fac.membercost end)) as revenue
from cd.bookings as bk
inner join cd.facilities as fac on bk.facid = fac.facid
group by fac.name
having sum(bk.slots * (
Case when bk.memid = 0 then fac.guestcost else fac.membercost end)) < 1000
order by revenue;