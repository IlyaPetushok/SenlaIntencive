insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Ushkevich', 'Aleksander', '10 Tunia Drive, Boston', 234567, '(911) 345-2527', 4, '2016-03-15');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Sokolov', 'Aleksey', 'Dzershinskiy,23', 23447, '(929) 342-2117', 13, '2016-03-15');
Select distinct mems.firstname || ' ' ||  mems.surname as member,
	(Select memsr.firstname || ' ' || memsr.surname as recommender 
		from cd.members as memsr 
		where memsr.memid = mems.recommendedby)
	from 
		cd.members as mems
order by member; 