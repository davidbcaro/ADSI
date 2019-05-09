create table Rol
(
CodRol  int primary key not null,
TipoRol varchar (25) not null
);
create sequence SEC_ROL start with 1 increment by 1;

insert into Rol (CodRol,TipoRol) values (SEC_ROL.nextval,'Soporte');
insert into Rol (CodRol,TipoRol) values (SEC_ROL.nextval,'AdministradorMaster');
insert into Rol (CodRol,TipoRol) values (SEC_ROL.nextval,'Administrador');
insert into Rol (CodRol,TipoRol) values (SEC_ROL.nextval,'Cliente');

create table TipoDocumento
(
IdTipo integer primary key not null,
Clase_Documento varchar (255) not null
);
create sequence SEC_TD start with 1 increment by 1;

insert into TipoDocumento (IdTipo,Clase_Documento)values (SEC_TD.nextval,'C.C');
insert into TipoDocumento (IdTipo,Clase_Documento) values (SEC_TD.nextval,'Pasaporte');
insert into TipoDocumento (IdTipo,Clase_Documento) values (SEC_TD.nextval,'T.I');
insert into TipoDocumento (IdTipo,Clase_Documento) values (SEC_TD.nextval,'Cedula Extranjeria');
select * from TipoDocumento;

create table EstadoAprendiz
(
IdEstado int primary key not null,
Tipo_Estado varchar (255) not null
);
create sequence SEC_ET start with 1 increment by 1;

insert into EstadoAprendiz (IdEstado,Tipo_Estado)values(SEC_ET.nextval,'Activo');
insert into EstadoAprendiz (IdEstado,Tipo_Estado)values(SEC_ET.nextval,'Desertado');
insert into EstadoAprendiz (IdEstado,Tipo_Estado)values(SEC_ET.nextval,'Aplazado');
insert into EstadoAprendiz (IdEstado,Tipo_Estado)values(SEC_ET.nextval,'No Aplica');
select * from EstadoAprendiz;

create table Especialidad
(
IdEspecialidad int primary key not null,
Nombre_Especialidad varchar (55) not null
);
create sequence SEC_Es start with 1 increment by 1;

insert into Especialidad (IdEspecialidad,Nombre_Especialidad) values (SEC_Es.nextval,'Electricidad');
insert into Especialidad (IdEspecialidad,Nombre_Especialidad) values (SEC_Es.nextval,'Electronica');
insert into Especialidad (IdEspecialidad,Nombre_Especialidad) values (SEC_Es.nextval,'Telecomunicaciones');
insert into Especialidad (IdEspecialidad,Nombre_Especialidad) values (SEC_Es.nextval,'Teleinformatica');
insert into Especialidad (IdEspecialidad,Nombre_Especialidad) values (SEC_Es.nextval,'No Aplica');
select * from Especialidad;

create table Programa
(
IdPrograma integer not null,
Nombre_Programa varchar (255) not null,
IdEspecilidad_Programa int not null
);

alter table Programa add unique (IdPrograma);
alter table Programa add primary key (IdEspecilidad_Programa,IdPrograma);
alter table Programa add constraint fk_Especialidad_Programa foreign key (IdEspecilidad_Programa) references Especialidad(IdEspecialidad);
create sequence SEC_Pr start with 1 increment by 1;

insert into Programa (IdPrograma,Nombre_Programa,IdEspecilidad_Programa) values (SEC_Pr.nextval,'Produccion Multimedia',4);
insert into Programa (IdPrograma,Nombre_Programa,IdEspecilidad_Programa) values (SEC_Pr.nextval,'Gestion de Redes de datos',4);
insert into Programa (IdPrograma,Nombre_Programa,IdEspecilidad_Programa) values (SEC_Pr.nextval,'Analisis y Desarrollo de software',4);
insert into Programa (IdPrograma,Nombre_Programa,IdEspecilidad_Programa) values (SEC_Pr.nextval,'No aplica',5);
select * from Programa;

create table Ficha
(
IdFicha integer not null,
Numero_Ficha varchar (255) not null,
IdPrograma_Ficha int not null
);
alter table Ficha add unique (IdFicha);
alter table Ficha add primary key (IdPrograma_Ficha,IdFicha);
alter table Ficha add constraint Fk_Programa_Ficha foreign key (IdPrograma_Ficha) references Programa(IdPrograma);
create sequence SEC_Fi start with 1 increment by 1;

insert into Ficha (IdFicha,Numero_Ficha,IdPrograma_Ficha) values (SEC_Fi.nextval,'1556598',3);
insert into Ficha (IdFicha,Numero_Ficha,IdPrograma_Ficha) values (SEC_Fi.nextval,'1132325 G2',2);
insert into Ficha (IdFicha,Numero_Ficha,IdPrograma_Ficha) values (SEC_Fi.nextval,'1488683 PM-2',1);
insert into Ficha (IdFicha,Numero_Ficha,IdPrograma_Ficha) values (SEC_Fi.nextval,'1438736 G3',3);
insert into Ficha (IdFicha,Numero_Ficha,IdPrograma_Ficha) values (SEC_Fi.nextval,'NO Aplica',4);
select * from Ficha;

create table Usuario
(
IdNumeIden char (12) not null,
Primer_Nombre varchar (55) not null,
Segundo_Nombre varchar (55) null,
Primer_Apellido varchar (55) not null,
Segundo_Apellido varchar (255) null,
NumTelefonico number (10) not null,
Correo_Electronica varchar (255) unique not null,
UserName varchar (255) null,
Contraseña varchar(255) null, 
CodRol_Usuario int not null,
IdEstado_Usuario int not null,
IdTipoDc_Usuario int not null,
IdFicha_Usuario int not null,
foreign key (IdEstado_Usuario) references EstadoAprendiz(IdEstado),
foreign key (IdFicha_Usuario) references Ficha(IdFicha)
);
alter table Usuario add unique (IdNumeIden);
alter table Usuario add primary key (IdNumeIden,CodRol_Usuario,IdTipoDc_Usuario);
alter table Usuario add constraint Fk_Rol_Usuario foreign key (CodRol_Usuario) references Rol (CodRol);
alter table Usuario add constraint Fk_TD_Usuario foreign key (IdTipoDc_Usuario) references TipoDocumento (IdTipo);

insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,UserName,Contraseña,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568687','Jhon','Felipe','Cardenas','Morales','3156789524','jfcardenaso@misena.edu.co','Dogus1','123456',1,4,1,5);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,UserName,Contraseña,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568565','andres','camilo','topo','suares',3156789487,'CorreoFalso@Esfaso.not','ACTS','22222;3',2,4,1,5);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,UserName,Contraseña,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568152','James','Felipe','Chicala','Mocoa',3156789789,'CorreoFalso@Esfaso.nEt','123a','55555;3',3,4,1,5);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568123','Jhon','Andres','Cardona','Sanchez',3156789025,'CorreoFalso@Esfasos.not',3,3,3,4);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568122','Jhon','Andres','Cardona','Sanchez',3156789025,'CorreoFalso1@Esfasos.not',3,3,3,4);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568426','Tom','michael','Suares','Sanchez',3156789025,'CorreoFalso12@Esfasos.not',3,3,3,4);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014567534','Luis','Muriel','Cardona','Sichaca',3156789025,'CorreoFals1o@Esfasos.not',3,3,3,4);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014561548','Fernando','Camilo','Castillo','Torres',3156789025,'CorreoFalso3@Esfasos.not',3,3,3,4);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014562348','Daniela','Camila','Jimenez','Rubiano',3156789025,'CorreoFalso4@Esfasos.not',3,3,3,4);
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014567824','Laura','Camila','Jimenez','Cañon',3156789025,'CorreoFalso5@Esfasos.not',3,3,3,4);
select * from Usuario;

create table Nota
(
Id_Nota int primary key not null,
Comentario varchar (255) not null,
IdNumeIden_Nota char (12) not null,
foreign key (IdNumeIden_Nota) references Usuario (IdNumeIden)
);
create sequence SEC_No start with 1 increment by 1;

insert into Nota (Id_Nota,Comentario,IdNumeIden_Nota) values (SEC_No.nextval,'Placa 457-CDS Esta Hace 1 hora en el parqueadero','1014568687');
select * from Nota;


create table ClaseVehiculo
(
IdClase integer primary key not null,
Tipo_Vehiculo varchar (55) not null
);
create sequence SEC_Ve start with 1 increment by 1;

insert into ClaseVehiculo (IdClase,Tipo_Vehiculo) values (SEC_Ve.nextval,'Bicicleta');
insert into ClaseVehiculo (IdClase,Tipo_Vehiculo) values (SEC_Ve.nextval,'Motocicleta');
select * from ClaseVehiculo;

create table Modelo
(
IdModelo int primary key not null,
Ano_Modelo varchar (55) not null
);
create sequence SEC_Mo start with 1 increment by 1;

insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'Ninguno');
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'2015');
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'2015');
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'2015');
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'2015');
/*Modelos Bicicletas*/
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'BMX');
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'Ruta');
insert into Modelo (IdModelo,Ano_Modelo) values (SEC_Mo.nextval,'Montaña');
select * from Modelo;

create table Marca
(
IdMarca int primary key not null,
Nombre_Marca varchar (55) not null
);
create sequence SEC_Ma start with 1 increment by 1;

insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Ninguna');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Honda');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Yamaha');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'KTM');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Suzuki');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Kawasaki');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'BMW');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Ducati');
/*Marca Bicicletas*/
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Cervélo');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'GW');
insert into Marca (IdMarca,Nombre_Marca) values (SEC_Ma.nextval,'Bianchi');
SELECT * FROM Marca;

create table Vehiculo
(
IdVehiculo varchar (12) not null,
ColorVehiculo varchar (55) not null,
IdNumeIden_Vehiculo char (12) not null,
IdClase_Vehiculo int not null,
IdModelo_Vehiculo int not null,
IdMarca_Vehiculo int not null
);

alter table Vehiculo add primary key  (IdVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo);
alter table Vehiculo add constraint Fk_Vehiculo_Usuario foreign key (IdNumeIden_Vehiculo) references Usuario (IdNumeIden);
alter table Vehiculo add constraint Fk_Vehiculo_Clase foreign key (IdClase_Vehiculo) references ClaseVehiculo (IdClase);
alter table Vehiculo add constraint Fk_Vehiculo_Modelo foreign key (IdModelo_Vehiculo) references Modelo (IdModelo);
alter table Vehiculo add constraint Fk_Vehiculo_Marca foreign key (IdMarca_Vehiculo) references Marca (IdMarca);
alter table Vehiculo add unique (IdVehiculo);

insert into Vehiculo (IdVehiculo,ColorVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo) values ('AXD28A','Negro','1014568687',2,2,2);
insert into Vehiculo (IdVehiculo,ColorVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo) values ('DFR35B','Rojo','1014567824',2,3,3);
insert into Vehiculo (IdVehiculo,ColorVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo) values ('SDFV0000003','Azul','1014567824',1,6,10);
SELECT * FROM Vehiculo;


create table conteoparqueadero
(
Idlugarparqueadero int primary key not null,
IdVehiculo_Cp varchar (12) not null,
Foreign key (IdVehiculo_Cp) references Vehiculo (IdVehiculo)
);
create sequence SEC_Cp start with 1 increment by 1;

create table Bahia
(
Id_Bahia Varchar (55) primary key not null,
Cnatidad_Bahias int not null,
Numerador_Bahias int not null
);

insert into Bahia (Id_Bahia,Cnatidad_Bahias,Numerador_Bahias) values ('A1',30,1);
insert into Bahia (Id_Bahia,Cnatidad_Bahias,Numerador_Bahias) values ('B1',30,2);
SELECT * FROM Bahia;

 create table Cupo
(
Id_Cupo int not null,
Estado number (1) not null check (Estado in (0,1)),
Id_Bahia_Cupo varchar (55) not null
);

alter table Cupo add primary key (Id_Cupo,Id_Bahia_Cupo);
alter table Cupo add constraint Fk_Bahia_Cupo foreign key (Id_Bahia_Cupo) references Bahia(Id_Bahia);
alter table Cupo add unique (Id_Cupo);

insert into Cupo (Id_Cupo,Estado,Id_Bahia_Cupo) values (1,1,'A1');
insert into Cupo (Id_Cupo,Estado,Id_Bahia_Cupo) values (2,0,'B1');
SELECT * FROM Cupo;

create table Registro
(
IdRegistro int not null,
Fecha_Hora_Ingreso timestamp not null,
Fecha_Hora_Salida timestamp (2) not null,
Id_Cupo_Registro int not null
);

alter table Registro add primary key (IdRegistro,Id_Cupo_Registro);
alter table Registro add constraint Fk_Registro_Cupo foreign key (Id_Cupo_Registro) references Cupo (Id_Cupo);
alter table Registro add unique (IdRegistro);
create sequence SEC_Reg start with 1 increment by 1;

insert into Registro (IdRegistro,Fecha_Hora_Ingreso,Fecha_Hora_Salida,Id_Cupo_Registro) values (SEC_Reg.nextval,'1-1-1999 08:00:10.123456','1-1-1999 08:30:00.123456',1);
insert into Registro (IdRegistro,Fecha_Hora_Ingreso,Fecha_Hora_Salida,Id_Cupo_Registro) values (SEC_Reg.nextval,'1999/1/1 19:00:10','1999/1/1 20:30',2);
SELECT * FROM Registro;

create table Vehiculo_Registro 
(
IdVehiculo_Registro varchar(12) not null,
IdRegistro_Registro int not null
);

alter table Vehiculo_Registro add unique (IdVehiculo_Registro);
alter table Vehiculo_Registro add primary key (IdVehiculo_Registro,IdRegistro_Registro);
alter table Vehiculo_Registro add constraint Fk_Vehiculo_Registro_vehivulo foreign key (IdVehiculo_Registro) references Vehiculo (IdVehiculo);
alter table Vehiculo_Registro add constraint Fk_Registro_Vehiculo foreign key (IdRegistro_Registro) references Registro (IdRegistro);

insert into Vehiculo_Registro  (IdVehiculo_Registro,IdRegistro_Registro) values('AXD28A',1);
insert into Vehiculo_Registro  (IdVehiculo_Registro,IdRegistro_Registro) values('DFR35B',2);
SELECT * FROM Vehiculo_Registro;


create table ServidorCorreo
(
IdServidor int primary  key not null,
Recupearcion_de_Contraseña varchar (60) not null,
Corfimar_Cuenta varchar(60) not null,
Cambiar_Comtraseña varchar (60) not null
);
create sequence SEC_SC start with 1 increment by 1;

Create table LogError
(
Iderror int primary key not null,
Codigo_error varchar (255) not null,
Hora_y_Fecha_Error timestamp not null
);
create sequence SEC_LE start with 1 increment by 1;