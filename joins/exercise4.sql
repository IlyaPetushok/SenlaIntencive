insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Silvanovich', 'Ivan', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 3, '2016-03-15');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Vdovenko', 'Kirill', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 5, '2012-09-25');
select mems.firstname as memfname, mems.surname as memsname, 
recs.firstname as recfname, recs.surname as recsname
from cd.members mems left outer join cd.members recs 
on recs.memid = mems.recommendedby order by memsname, memfname;    