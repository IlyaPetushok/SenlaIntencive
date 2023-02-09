create table vape(
	vape_id integer not null unique,
	power_vape integer not null,
	battery integer not null,
	type_vape character varying(30),
	foreign key (vape_id) references item(id_item) on delete cascade
);