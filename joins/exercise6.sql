insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Visotsky', 'Egor', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 2, '2016-03-15');
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance)
values (29,'Tennis Court 1', 0, 80, 4000, 200);
insert into cd.bookings(facid,memid,starttime,slots)  values (29,3,'2012-09-14',2);
select cd.members.firstname || ' ' || cd.members.surname as member, 
cd.facilities.name as facility, 
case 
when cd.members.memid = 0 then
cd.bookings.slots*cd.facilities.guestcost
else cd.bookings.slots*cd.facilities.membercost
end as cost
from cd.members inner join cd.bookings on cd.members.memid = cd.bookings.memid
inner join cd.facilities on cd.bookings.facid = cd.facilities.facid
where cd.bookings.starttime >= '2012-09-14' and 
cd.bookings.starttime < '2012-09-15' and (
(cd.members.memid = 0 and cd.bookings.slots*cd.facilities.guestcost > 30) or
(cd.members.memid != 0 and cd.bookings.slots*cd.facilities.membercost > 30))
order by cost desc; 