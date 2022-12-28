insert into cd.members (surname, firstname, address, zipcode, telephone, joindate) 
values ('Fast', '228', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', '2006-10-17');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Obivan', 'Kenoby', '3 Tunia Drive, Boston', 32678, '(811) 433-2527', 7, '2021-07-15');
Select recommendedby,count(*) from cd.members where recommendedby is not null 
group by recommendedby order by recommendedby;