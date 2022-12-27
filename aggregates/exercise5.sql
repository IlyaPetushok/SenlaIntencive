insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (36,'Zal12', 25, 35.3, 2000, 150);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (37,'Zal13',15, 25.5, 3000, 300);
Select facid, sum(slots) as "Total Slots"
from cd.bookings where
starttime >= '2012-09-01' and starttime < '2012-10-01'
group by facid order by sum(slots);  