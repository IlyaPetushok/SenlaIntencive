insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Ushkevich', 'Vanya', '99 Tunia Drive, Boston', 32678, '(811) 433-2527', 4, '2016-03-15');
insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance)
values (31,'Tennis Court 10', 0, 80, 4000, 200);
insert into cd.bookings(facid,memid,starttime,slots)  values (31,15,'2012-09-14',2);
Select dt.member, dt.facility, dt.cost FROM
(Select mems.firstname || ' ' || mems.surname as member, fac.name as facility,
case when bk.memid=0 
then bk.slots * fac.guestcost else bk.slots * fac.membercost
end as cost
from cd.bookings as bk inner join cd.facilities as fac
on bk.facid=fac.facid inner join cd.members as mems on bk.memid=mems.memid
where extract('month' from bk.starttime)=9 and extract('year' from bk.starttime)=2012 and
extract('day' from bk.starttime)=14 ) as dt Where dt.cost > 30 order by dt.cost desc;