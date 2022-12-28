Insert into cd.bookings(facid,memid,starttime,slots)  values (4,10,'2011-02-24',70);
Insert into cd.bookings(facid,memid,starttime,slots)  values (12,22,'2022-11-24',300);
with create_list_sum as (select facid, sum(slots) as sum_slots
	from cd.bookings
	group by facid
)
select facid, sum_slots 
	from create_list_sum
	where sum_slots = (select max(sum_slots) from create_list_sum);
