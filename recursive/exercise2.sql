insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Kluchnik', 'Zahar', 'Skidel', 27898, '(29) 986-1127', 1, '2012-11-17');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Truhan', 'Alexey', 'Mosts', 308538, '(33) 455-2457', 1, '2006-01-19');
with recursive recommendeds(memid) as (
select memid from cd.members where recommendedby = 1 union all 
select mems.memid from recommendeds as recm inner join cd.members as mems on mems.recommendedby = recm.memid)
select recm.memid, mems.firstname, mems.surname from recommendeds as recm
inner join cd.members mems on recm.memid = mems.memid order by memid      