insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Popruk', 'Igor', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 9, '2016-03-15');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Romanenko', 'Artem', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 6, '2016-03-15');
select distinct recs.firstname as firstname, recs.surname as surname
from cd.members mems inner join cd.members recs
on recs.memid = mems.recommendedby order by surname, firstname;  