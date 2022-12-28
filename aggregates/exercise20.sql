insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (46,'Gym Sport Room 3', 9, 15, 3000, 650);
Insert into cd.bookings(facid,memid,starttime,slots)  values (10,46,'2015-09-07',25);
Select name, case class when 1 then 'high' when 2 then 'average' else 'low' end
from (Select fac.name, ntile(3) over (order by sum(
    case when memid = 0 then slots * fac.guestcost else slots * fac.membercost
    end) desc) as class
  from cd.bookings inner join cd.facilities as fac on cd.bookings.facid = fac.facid
  group by fac.name
) as subq
order by class, name;