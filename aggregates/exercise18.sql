Insert into cd.bookings(facid,memid,starttime,slots)  values (14,19,'2011-02-07',2);
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Guest', 'Guest', '9 Tunia Drive, Boston', 32678, '(811) 433-2527', 17, '2016-03-15');
Select firstname, surname,((sum(bk.slots)+10)/20)*10 as hours,
rank() over (order by ((sum(bk.slots)+10)/20)*10 desc) as rank
from cd.bookings as bk inner join cd.members as mems on bk.memid = mems.memid
group by mems.memid order by rank, surname, firstname;   