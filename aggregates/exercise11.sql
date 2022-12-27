Insert into cd.bookings(facid,memid,starttime,slots)  values (4,10,'2011-02-24',70);
Insert into cd.bookings(facid,memid,starttime,slots)  values (12,22,'2022-11-24',300);
Select facid, sum(slots) as sumslot from cd.bookings group by facid order by sum(slots) desc 
limit 1;