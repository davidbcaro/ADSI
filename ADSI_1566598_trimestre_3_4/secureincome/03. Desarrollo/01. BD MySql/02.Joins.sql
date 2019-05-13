create database secureincome;
use secureincome;

create table rol (
id_rol varchar (10) not null,
tipo_rol varchar(20) not null,
primary key (id_rol)
);

create table tipo_de_sangre (
id_rh varchar (10) not null,
tipo_rh varchar (5) not null,
primary key (id_rh)
);

create table ficha (
id_ficha varchar (10) not null,
num_ficha int not null,
nom_programa varchar (255) not null,
primary key (id_ficha)
);

create table genero (
id_gen varchar (10) not null,
tipo_gen varchar (15) not null,
primary key (id_gen)
);

create table tipo_documento (
id_tdoc varchar (30) not null,
tipo_doc varchar (255),
primary key (id_tdoc)
);

create table usuario (
id_usu varchar (10) not null,
pri_nom_usu varchar (30) not null,
seg_nom_usu varchar (30),
pri_ape_usu varchar (30) not null,
seg_ape_usu varchar (30),
code_barras_usu varchar (30) not null,
edad_usu int not null,
correo_usu varchar (255) unique,
id_rol varchar (10) not null,
id_rh varchar (10) not null,
id_ficha varchar (10) not null,
id_gen varchar (10) not null,
id_tdoc varchar (30) not null,
foreign key (id_rh) references tipo_de_sangre (id_rh)
);

create table vigilante (
id_vig varchar (15) not null,
correo_vig varchar (50) unique,
contra_vig int not null,
pri_nom_vig varchar (30) not null,
seg_nom_vig varchar (30),
pri_ape_vig varchar (30) not null,
seg_ape_vig varchar (30),
id_tdoc varchar (30) not null
);
 
create table jornada (
id_jor varchar (15) not null,
tipo_jor varchar (20) not null,
primary key (id_jor)
);

create table jornada_vigilante (
id_vig varchar (15) not null,
id_jor varchar (15) not null,
id_tdoc varchar (30) not null
); 

create table marca (
id_mar varchar (10) not null,
nom_mar varchar (20) not null,
primary key (id_mar)
);

create table equipo (
id_equi varchar (10) not null,
tipo_equi varchar (15) not null,
serial_pc varchar (20) unique,
id_mar varchar (10) not null,
id_rol varchar (10) not null,
id_ficha varchar (10) not null,
id_gen varchar (10) not null,
id_tdoc varchar (30) not null,
id_usu varchar (10) not null,
foreign key (id_mar) references marca (id_mar)
);

create table registro (
id_reg varchar (10) not null,
hora_ing time not null,
hora_sal time not null,
fecha_ing date not null,
fecha_sal date not null,
id_mar varchar (10) not null,
id_rol varchar (10) not null,
id_ficha varchar (10) not null,
id_gen varchar (10) not null,
id_tdoc varchar (30) not null,
id_usu varchar (10) not null,
id_vig varchar (15) not null,
id_jor varchar (15) not null
);

create table log_error (
Id_error varchar (20) not null,
desc_error text, 
primary key (Id_error)
);

create table Serv_correo (
Id_serv_corr varchar(10) not null,
tipo_servidor_web varchar (15) not null,
primary key (Id_serv_corr)
);

alter table usuario add constraint fk_gen foreign key (id_gen) references genero (id_gen);
alter table usuario add constraint fk_tdoc foreign key (id_tdoc) references tipo_documento (id_tdoc);
alter table usuario add constraint fk_rol foreign key (id_rol) references rol (id_rol);
alter table usuario add constraint fk_ficha foreign key (id_ficha) references ficha (id_ficha);
alter table usuario add primary key (id_gen,id_tdoc,id_rol,id_ficha,id_usu);

alter table vigilante add constraint fk_vign foreign key (id_tdoc) references tipo_documento (id_tdoc);
alter table vigilante add primary key (id_vig,id_tdoc);

alter table jornada_vigilante add constraint fk_jors foreign key (id_jor) references jornada (id_jor);
alter table jornada_vigilante add constraint fk_vigi foreign key (id_vig,id_tdoc) references vigilante (id_vig,id_tdoc);
alter table jornada_vigilante add primary key (id_jor,id_vig,id_tdoc);

alter table equipo add constraint fk_usu foreign key (id_gen,id_tdoc,id_rol,id_ficha,id_usu) references usuario (id_gen,id_tdoc,id_rol,id_ficha,id_usu);
alter table equipo add primary key (id_gen,id_tdoc,id_rol,id_ficha,id_usu,id_equi);


alter table registro add constraint fk_vidfg foreign key (id_vig) references vigilante (id_vig);
alter table registro add constraint fk_jords foreign key (id_jor) references jornada (id_jor);
alter table registro add constraint fk_usufd foreign key (id_gen,id_tdoc,id_rol,id_ficha,id_usu) references usuario (id_gen,id_tdoc,id_rol,id_ficha,id_usu);
alter table registro add primary key (id_gen,id_tdoc,id_ficha,id_vig,id_jor,id_rol,id_usu,id_reg);
-- Registros

insert into rol
(id_rol, tipo_rol)
values('R1','APRENDIZ'),
('R2','VISITANTE'),
('R3','INSTRUCTOR');

insert into tipo_de_sangre
(id_rh, tipo_rh)
values('RH1','O+'),
('RH2','O-'),
('RH3','A+'),
('RH4','A-'),
('RH5','AB-');

insert into ficha
(id_ficha, num_ficha, nom_programa)
values('F1','1566598','ADSI'),
('F2','1503959','MULTIMEDIA'),
('F3','1503538','PROGRAMACION DE SOFTWARE'),
('F4','1503561','TELECOMUNICACIONES');

insert into genero
(id_gen, tipo_gen)
values('G1','MASCULINO'),
('G2','FEMENINO');

insert into tipo_documento
(id_tdoc, tipo_doc)
values('Z1','CEDULA DE CIUDADANIA'),
('Z2','TARJETA DE IDENTIDAD'),
('Z3','CEDULA ESTRANGERIA'),
('Z4','PASAPORTE');

insert into vigilante
(id_vig, correo_vig, contra_vig, pri_nom_vig, seg_nom_vig, pri_ape_vig, seg_ape_vig, id_tdoc)
values('V1','joseg12@hotmail.com','12345','Pedro','Jose','Gutierrez','Mesa','Z1'),
('V2','juanm58@hotmail.com','12345','Juan','Manuel','Tarta','Velez','Z1'),
('V3','Andresf45@hotmail.com','12345','Andres','Felipe','Rojas','Chavez','Z1');

insert into usuario
(id_usu, pri_nom_usu, seg_nom_usu, pri_ape_usu, seg_ape_usu, edad_usu,correo_usu,code_barras_usu,id_rol,id_rh,id_ficha,id_gen,id_tdoc)
values('U1','Juan','Miguel ','Antonio','Perez','18','jmantonio26@misena.edu.co','G500','R1','RH1','F1','G1','Z1'),
('U2','Carlos','Andres ','Henao','Calderon','35','cahenao32@misena.edu.co','G600','R3','RH2','F2','G1','Z1'),
('U3','Natalia','Andrea ','Trujillo','Calderon','20','ntrujillo35@misena.edu.co','G700','R1','RH3','F1','G2','Z1'),
('U4','Karen','Tatiana ','Valbuena','Martinez','31','ktvalbuena11@misena.edu.co','G100','R3','RH1','F3','G2','Z1'),
('U5','John','Freddy ','Martinez','Garavito','22','jfmartinez64@misena.edu.co','G200','R1','RH2','F4','G1','Z1'),
('U6','Elver','Tomas ','Gomez','Tovar','40','etgomez632@misena.edu.co','G900','R3','RH3','F1','G1','Z1'),
('U7','Laura','Sofia ','Torres','Martinez','25','lstorrez654@misena.edu.co','G1030','R2','RH1','F3','G2','Z1'),
('U8','Karen ','Dallana ','Perez','Rodriguez','19','kdperez24@misena.edu.co','G300','R1','RH1','F4','G2','Z1'),
('U9','Pedro','Ulises ','Tavares','Beltran','45','putavares21@misena.edu.co','G400','R2','RH2','F3','G1','Z1');

insert into jornada
(id_jor,tipo_jor)
values ('J1','Diurna'),
('J2','Nocturna'),
('J3','Fin_Semana');

insert into jornada_vigilante
(id_vig,id_jor,id_tdoc)
values ('V1','J1','Z1'),
('V1','J2','Z1'),
('V1','J3','Z1'),
('V2','J1','Z1'),
('V2','J2','Z1'),
('V2','J3','Z1'),
('V3','J1','Z1'),
('V3','J2','Z1'),
('V3','J3','Z1');

insert into marca
(id_mar,nom_mar)
values('M1','SAMSUNG'),
('M2','LG'),
('M3','ACER'),
('M4','HP'),
('M5','DELL'),
('M6','LENOVO'),
('M7','APPLE'),
('M8','TOSHIBA'),
('M9','ASUS'),
('M10','ALIENWARE'),
('M11','LANIX');

insert into equipo
(id_equi,tipo_equi,serial_pc,id_mar,id_rol,id_ficha,id_gen,id_tdoc,id_usu)
values('E1','PORTATIL','1015125','M1','R1','F1','G1','Z1','U1'),
('E2','VIDEOVIN','1015126','M2','R1','F1','G1','Z1','U1'),
('E1','PORTATIL','4256575','M3','R3','F2','G1','Z1','U2'),
('E1','PORTATIL','45645644','M4','R1','F1','G2','Z1','U3'),
('E1','PORTATIL','56546454','M5','R3','F3','G2','Z1','U4'),
('E2','VIDEOVIN','56546456','M6','R3','F3','G2','Z1','U4'),
('E1','PORTATIL','12378645','M7','R1','F4','G1','Z1','U5'),
('E1','PORTATIL','15248564','M8','R3','F1','G1','Z1','U6'),
('E1','PORTATIL','16258466','M9','R2','F3','G2','Z1','U7'),
('E1','PORTATIL','87662842','M10','R1','F4','G2','Z1','U8'),
('E1','PORTATIL','75738387','M11','R2','F3','G1','Z1','U9');

insert into registro
(id_reg,hora_ing,hora_sal,fecha_ing,fecha_sal,id_mar,id_rol,id_ficha,id_gen,id_tdoc,id_usu,id_vig,id_jor)
values('RG1','06:15:00','12:15:10','2018/02/02','2018/02/02','M1','R1','F1','G1','Z1','U1','V1','J1'),
('RG2','06:15:00','12:15:10','2018/02/02','2018/02/02','M2','R1','F1','G1','Z1','U1','V1','J1'),
('RG3','18:05:15','21:30:04','2018/03/01','2018/03/01','M3','R3','F2','G1','Z1','U2','V3','J2'),
('RG4','06:17:04','12:17:10','2018/04/09','2018/04/09','M4','R1','F1','G2','Z1','U3','V1','J1'),
('RG5','08:20:03','16:30:04','2018/05/06','2018/05/06','M5','R3','F3','G2','Z1','U4','V2','J3'),
('RG6','08:20:03','16:30:04','2018/05/06','2018/05/06','M6','R3','F3','G2','Z1','U4','V2','J3'),
('RG7','06:20:08','12:30:50','2018/04/07','2018/04/07','M7','R1','F4','G1','Z1','U5','V1','J1'),
('RG8','06:00:10','12:45:10','2018/04/15','2018/04/15','M8','R3','F1','G1','Z1','U6','V1','J1'),
('RG9','18:00:15','21:28:45','2018/06/22','2018/06/22','M9','R2','F3','G2','Z1','U7','V3','J2'),
('RG10','06:13:45','12:15:47','2018/07/30','2018/07/30','M10','R1','F4','G2','Z1','U8','V1','J1'),
('RG11','08:17:23','16:40:23','2018/02/24','2018/02/24','M11','R2','F3','G1','Z1','U9','V2','J3');


-- JOINS --

-- Usuario/Genero
Select pri_nom_usu,seg_nom_usu,pri_ape_usu,seg_ape_usu,tipo_gen from usuario inner join genero on usuario.id_gen = genero.id_gen;
-- Usuario/Tipo_documento
select pri_nom_usu,seg_nom_usu,pri_ape_usu,seg_ape_usu,tipo_doc from Usuario join Tipo_documento on Usuario.id_tdoc = Tipo_documento.id_tdoc;
-- 03Usuario/Rol
select pri_nom_usu,seg_nom_usu,pri_ape_usu,seg_ape_usu,tipo_rol from Usuario left join Rol on Usuario.id_rol = Rol.id_rol;
-- 04Usuario/Ficha
select pri_nom_usu,seg_nom_usu,pri_ape_usu,seg_ape_usu,num_ficha,nom_programa from Usuario left join Ficha on Usuario.id_ficha = Ficha.id_ficha;
-- 05Vigilante/Tipo_documento
select pri_nom_vig,seg_nom_vig,pri_ape_vig,seg_ape_vig,tipo_doc from Vigilante right join Tipo_documento on Vigilante.id_tdoc = Tipo_documento.id_tdoc;
-- 06Jornada/Vigilante
select tipo_jor,pri_nom_vig,seg_nom_vig,pri_ape_vig,seg_ape_vig from Jornada left join jornada_vigilante on jornada_vigilante.id_jor = Jornada.id_jor left join vigilante on jornada_vigilante.id_vig = vigilante.id_vig;
-- 07Equipo/Usuario
select pri_nom_usu,seg_nom_usu,pri_ape_usu,seg_ape_usu,tipo_equi,serial_pc from Equipo right join Usuario on Usuario.id_usu = Equipo.id_usu;
-- 08Registro/Vigilante
Select pri_nom_vig,seg_nom_vig,pri_ape_vig,seg_ape_vig,hora_ing,hora_sal, fecha_ing,fecha_sal from Registro right join Vigilante on Registro.id_vig = Vigilante.id_vig;
-- 09Registro/Jornada
select tipo_jor,hora_ing,hora_sal,fecha_ing,fecha_sal from Registro left join jornada on Registro.id_jor = Jornada.id_jor;
-- 10Registro/Usuario
Select pri_nom_usu,seg_nom_usu,pri_ape_usu,seg_ape_usu, hora_ing,hora_sal,fecha_ing,fecha_sal from Registro join Usuario on Registro.id_usu = Usuario.id_usu;