insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Matthev', 'Genting', 'Belastok', 27898, '(29) 886-2527', 2, '2011-03-15');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Darren', 'Butters', 'Budapesht', 308538, '(811) 885-2527', 2, '2009-11-09');
with recursive recommenders(recommender) as (
  select recommendedby from cd.members where memid = 27
  union all
  Select mems.recommendedby
  from recommenders as recm
  inner join cd.members as mems on mems.memid = recm.recommender
)
Select recm.recommender, mems.firstname, mems.surname
from recommenders as recm
inner join cd.members as mems on recm.recommender = mems.memid
order by memid desc;