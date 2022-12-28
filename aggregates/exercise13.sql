Insert into cd.bookings(facid,memid,starttime,slots)  values (22,17,'2001-12-24',55);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (38,'Tennis Court 22', 15, 35.5, 2000, 500);
Select fac.facid, fac.name, sum(bk.slots) * 0.50 as "Total Hours"
From cd.facilities as fac
inner join cd.bookings as bk on (fac.facid = bk.facid)
group by fac.facid, fac.name
order by fac.facid;