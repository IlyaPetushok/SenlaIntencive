insert into cd.facilities (facid,name, membercost, guestcost, initialoutlay, monthlymaintenance) values (48,'Gym Sport Room 123', 19, 35.5, 3500, 520);
Insert into cd.bookings(facid,memid,starttime,slots)  values (10,46,'2012-08-04',35);
Insert into cd.bookings(facid,memid,starttime,slots)  values (12,36,'2012-08-05',125);
Insert into cd.bookings(facid,memid,starttime,slots)  values (7,21,'2012-08-06',74);
With revdaily as (
Select days.day, rev.revenue 
from ( Select generate_series('2012-07-15'::date, '2012-08-31'::date, '1 day')
::date as day ) as days left join (
Select date(bk.starttime) as day,
sum(bk.slots *  case when bk.memid=0 then fac.guestcost else fac.membercost end) as revenue
from cd.facilities as fac inner join cd.bookings as bk
on fac.facid = bk.facid group by date(bk.starttime)) as rev
on days.day = rev.day) 
Select * From (Select day,avg(revenue) over(
order by day rows  between 14 preceding and current row) as revenue from revdaily)
as revroll where revroll.day >= '2012-08-01';