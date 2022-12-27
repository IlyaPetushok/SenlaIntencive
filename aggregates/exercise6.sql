Insert into cd.bookings(facid,memid,starttime,slots)  values (21,21,'2012-08-12',11);
Insert into cd.bookings(facid,memid,starttime,slots)  values (22,22,'2013-09-29',14);
Select facid, extract(month from starttime) as month, sum(slots) as "Total Slots" from cd.bookings
where extract(year from starttime) = 2012
group by facid, month order by facid, month;  