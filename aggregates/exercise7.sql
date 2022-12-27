Insert into cd.bookings(facid,memid,starttime,slots)  values (10,22,'2011-02-24',7);
Insert into cd.bookings(facid,memid,starttime,slots)  values (11,22,'2013-09-29',3);
Select count(distinct memid) from cd.bookings;