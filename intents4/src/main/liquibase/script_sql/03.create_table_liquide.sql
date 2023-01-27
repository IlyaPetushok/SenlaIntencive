create table liquide (
	liquide_id_item integer not null,
	flavour character varying(40) not null,
	fortress integer not null default(0),
	type_nicotine character varying(15) 
	check (type_nicotine in ('солевой','обычный','без никотина')),
	volume integer not null,
	foreign key (liquide_id_item) references item(id_item)
 	on delete cascade
);