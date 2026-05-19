CREATE TABLE autor_obra (
autor_id int not null,
obra_id int not null,
primary key (autor_id, obra_id),
foreign key (autor_id) references autor(id),
foreign key (obra_id) references obra(id)
);