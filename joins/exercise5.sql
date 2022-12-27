insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Visotsky', 'Egor', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 2, '2016-03-15');
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance)
values (25,'Tennis Court 1', 0, 80, 4000, 200);
insert into cd.bookings(facid,memid,starttime,slots)  values (25,20,'2022-06-25',2);
Select distinct cd.members.firstname || ' ' || cd.members.surname as fullname, cd.facilities.name 
from cd.members inner join cd.bookings on cd.members.memid =cd.bookings.memid 
inner join cd.facilities on cd.bookings.facid = cd.facilities.facid 
where cd.facilities.name in ('Tennis Court 2','Tennis Court 1')
order by fullname,cd.facilities.name;