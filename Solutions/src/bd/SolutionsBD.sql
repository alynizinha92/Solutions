use solutions;
describe usuario;
select * from usuario;

alter table usuario add column perfil VARCHAR(30) not null;

alter table usuario drop column perfil;
update usuario set perfil='admin' where iduser=1;
update usuario set perfil='admin' where iduser=2;
update usuario set perfil='user' where iduser=3