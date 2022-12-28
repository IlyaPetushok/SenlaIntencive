insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Deshkevich', 'Vika', 'Ivie', 27898, '(29) 986-1127', 6, '2012-11-17');
insert into cd.members (surname, firstname, address, zipcode, telephone, recommendedby, joindate) 
values ('Lozechnik', 'Liza', 'Lida', 308538, '(33) 455-2457', 13, '2006-01-19');
with recursive recommenders(recommender, member) as (
select recommendedby, memid
from cd.members union all select mems.recommendedby, recs.member
from recommenders as recs inner join cd.members as mems on mems.memid = recs.recommender
)
select recs.member member, recs.recommender, mems.firstname, mems.surname
from recommenders as recs inner join cd.members as mems		
on recs.recommender = mems.memid where recs.member = 22 or recs.member = 12
order by recs.member asc, recs.recommender desc     