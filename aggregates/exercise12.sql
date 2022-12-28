Insert into cd.bookings(facid,memid,starttime,slots)  values (4,10,'2011-02-24',70);
Insert into cd.bookings(facid,memid,starttime,slots)  values (12,22,'2022-11-24',300);
Select facid, extract(month from starttime), sum(slots)
from cd.bookings
Where extract(year from starttime) = 2012
group by rollup(facid, extract (month from starttime))
order by facid, extract (month from starttime)