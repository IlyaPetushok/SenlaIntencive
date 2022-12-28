Insert into cd.bookings(facid,memid,starttime,slots)  values (14,19,'2011-02-07',2);
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Guest', 'Guest', '9 Tunia Drive, Boston', 32678, '(811) 433-2527', 17, '2016-03-15');
select firstname, surname, hours, rank() over (order by hours desc) from
(select firstname, surname,round(sum(bks.slots)/20.0)*10 as hours
	from cd.bookings bks inner join cd.members mems
	on bks.memid = mems.memid group by mems.memid
) as subq order by rank, surname, firstname;  
