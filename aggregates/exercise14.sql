insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Joplette', 'Janis', '5 Tunia Drive', 18978, '(233) 413-2527', 29, '2014-03-15');
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) 
values (40,'Tennis Court 25', 15, 35.5, 2000, 500);
Insert into cd.bookings(facid,memid,starttime,slots)  values (40,30,'2013-03-28',35);
Select  mems.surname, mems.firstname, mems.memid, min(bk.starttime) as starttime
from cd.members as mems
inner join cd.bookings as bk on bk.memid = mems.memid
where starttime >= '2012-09-01'
group by mems.surname, mems.firstname, mems.memid
order by mems.memid;