Insert into cd.bookings(facid,memid,starttime,slots)  values (6,7,'2011-02-24',7);
Insert into cd.bookings(facid,memid,starttime,slots)  values (5,7,'2013-09-29',3);
Select facid,sum(slots) as "slots" 
from cd.bookings group by facid having sum(slots) > 1000 order by facid;