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