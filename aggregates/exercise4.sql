insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (34,'TenisCort 10', 15, 35.3, 400, 2000);
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (35,'TenisCort 21', 5, 15.5, 500, 50);
Select Distinct facid,sum(slots) as "Total Slots" 
from cd.bookings group by facid order by facid;