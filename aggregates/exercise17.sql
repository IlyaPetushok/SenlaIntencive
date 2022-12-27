Insert into cd.bookings(facid,memid,starttime,slots)  values (17,21,'2012-07-11',2);
Insert into cd.bookings(facid,memid,starttime,slots)  values (16,13,'2010-02-14',2);
Select facid, total from (
  Select facid, sum(slots) as total,
         rank() over (order by sum(slots) desc) as rank
  from cd.bookings
  group by facid
) as ranked where rank = 1