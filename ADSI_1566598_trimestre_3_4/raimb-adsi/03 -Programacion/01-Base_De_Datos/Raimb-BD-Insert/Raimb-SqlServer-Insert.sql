create database RAIMB
use RAIMB

create table Rol
(
CodRol  int identity primary key not null,
TipoRol varchar (25) not null
)

insert into Rol (TipoRol) values ('Soporte')
insert into Rol (TipoRol) values ('AdministradorMaster')
insert into Rol (TipoRol) values ('Administrador')
insert into Rol (TipoRol) values ('Cliente')
/*select * from Rol;*/
/*drop table Rol;*/

create table TipoDocumento
(
IdTipo integer identity primary key not null,
Clase_Documento varchar (255) not null
)

insert into TipoDocumento (Clase_Documento)values ('C.C')
insert into TipoDocumento (Clase_Documento) values ('Pasaporte')
insert into TipoDocumento (Clase_Documento) values ('T.I')
insert into TipoDocumento (Clase_Documento) values ('Cedula Extranjeria')
select * from TipoDocumento

create table EstadoAprendiz
(
IdEstado int identity primary key not null,
Tipo_Estado varchar (255) not null
)

insert into EstadoAprendiz (Tipo_Estado)values ('Activo')
insert into EstadoAprendiz (Tipo_Estado)values('Desertado')
insert into EstadoAprendiz (Tipo_Estado)values('Aplazado')
insert into EstadoAprendiz (Tipo_Estado)values('No Aplica')
select * from EstadoAprendiz

create table Especialidad
(
IdEspecialidad int identity primary key not null,
Nombre_Especialidad varchar (55) not null
)

insert into Especialidad (Nombre_Especialidad) values ('Electricidad')
insert into Especialidad (Nombre_Especialidad) values ('Electronica')
insert into Especialidad (Nombre_Especialidad) values ('Telecomunicaciones')
insert into Especialidad (Nombre_Especialidad) values ('Teleinformatica')
insert into Especialidad (Nombre_Especialidad) values ('No Aplica')
select * from Especialidad

create table Programa
(
IdPrograma integer identity not null,
Nombre_Programa varchar (255) not null,
IdEspecilidad_Programa int not null
)

alter table Programa add unique (IdPrograma)
alter table Programa add primary key (IdEspecilidad_Programa,IdPrograma)
alter table Programa add constraint fk_Especialidad_Programa foreign key (IdEspecilidad_Programa) references Especialidad(IdEspecialidad)

insert into Programa (Nombre_Programa,IdEspecilidad_Programa) values ('Produccion Multimedia',4)
insert into Programa (Nombre_Programa,IdEspecilidad_Programa) values ('Gestion de Redes de datos',4)
insert into Programa (Nombre_Programa,IdEspecilidad_Programa) values ('Analisis y Desarrollo de software',4)
insert into Programa (Nombre_Programa,IdEspecilidad_Programa) values ('No aplica',5)
select * from Programa

create table Ficha
(
IdFicha integer identity not null,
Numero_Ficha varchar (255) not null,
IdPrograma_Ficha int not null
)
alter table Ficha add unique (IdFicha)
alter table Ficha add primary key (IdPrograma_Ficha,IdFicha)
alter table Ficha add constraint Fk_Programa_Ficha foreign key (IdPrograma_Ficha) references Programa(IdPrograma)

insert into Ficha (Numero_Ficha,IdPrograma_Ficha) values ('1556598',3)
insert into Ficha (Numero_Ficha,IdPrograma_Ficha) values ('1132325 G2',2)
insert into Ficha (Numero_Ficha,IdPrograma_Ficha) values ('1488683 PM-2',1)
insert into Ficha (Numero_Ficha,IdPrograma_Ficha) values ('1438736 G3',4)
insert into Ficha (Numero_Ficha,IdPrograma_Ficha) values ('NO Aplica',4)
select * from Ficha


create table Usuario
(
IdNumeIden char (12) not null,
Primer_Nombre varchar (55) not null,
Segundo_Nombre varchar (55) null,
Primer_Apellido varchar (55) not null,
Segundo_Apellido varchar (255) null,
NumTelefonico bigint not null,
Correo_Electronica varchar (255) unique not null,
UserName varchar (255) null,
Contraseña varchar(255) null, 
CodRol_Usuario int not null,
IdEstado_Usuario int not null,
IdTipoDc_Usuario int not null,
IdFicha_Usuario int not null,
foreign key (IdEstado_Usuario) references EstadoAprendiz(IdEstado),
foreign key (IdFicha_Usuario) references Ficha(IdFicha)
)
alter table Usuario add unique (IdNumeIden)
/*select * from Usuario;
drop table Usuario;*/

alter table Usuario add primary key (IdNumeIden,CodRol_Usuario,IdTipoDc_Usuario)
alter table Usuario add constraint Fk_Rol_Usuario foreign key (CodRol_Usuario) references Rol (CodRol)
alter table Usuario add constraint Fk_TD_Usuario foreign key (IdTipoDc_Usuario) references TipoDocumento (IdTipo)

insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,UserName,Contraseña,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568687','Jhon','Felipe','Cardenas','Morales','3156789524','jfcardenaso@misena.edu.co','Dogus1','123456',1,4,1,5)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,UserName,Contraseña,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568565','andres','camilo','topo','suares',3156789487,'CorreoFalso@Esfaso.not','ACTS','22222;3',2,4,1,5)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,UserName,Contraseña,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568152','James','Felipe','Chicala','Mocoa',3156789789,'CorreoFalso@Esfaso.nEt','123a','55555;3',3,4,1,5)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568123','Jhon','Andres','Cardona','Sanchez',3156789025,'CorreoFalso@Esfasos.not',3,3,3,4)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568123','Jhon','Andres','Cardona','Sanchez',3156789025,'CorreoFalso1@Esfasos.not',3,3,3,4)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014568426','Tom','michael','Suares','Sanchez',3156789025,'CorreoFalso12@Esfasos.not',3,3,3,4)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014567534','Luis','Muriel','Cardona','Sichaca',3156789025,'CorreoFals1o@Esfasos.not',3,3,3,4)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014561548','Fernando','Camilo','Castillo','Torres',3156789025,'CorreoFalso3@Esfasos.not',3,3,3,4)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014562348','Daniela','Camila','Jimenez','Rubiano',3156789025,'CorreoFalso4@Esfasos.not',3,3,3,4)
insert into Usuario (IdNumeIden,Primer_Nombre,Segundo_Nombre,Primer_Apellido,Segundo_Apellido,NumTelefonico,Correo_Electronica,CodRol_Usuario,IdEstado_Usuario,IdTipoDc_Usuario,IdFicha_Usuario)
values ('1014567824','Laura','Camila','Jimenez','Cañon',3156789025,'CorreoFalso5@Esfasos.not',3,3,3,4)

delete from usuario 

create table Nota
(
Id_Nota int identity primary key not null,
Comentario varchar (255) not null,
IdNumeIden_Nota char (12) not null,
foreign key (IdNumeIden_Nota) references Usuario (IdNumeIden)
)
insert into Nota (Comentario,IdNumeIden_Nota) values ('Placa 457-CDS Esta Hace 1 hora en el parqueadero','1014568687')
select * from Nota

create table ClaseVehiculo
(
IdClase integer identity primary key not null,
Tipo_Vehiculo varchar (55) not null
)

insert into ClaseVehiculo (Tipo_Vehiculo) values ('Bicicleta')
insert into ClaseVehiculo (Tipo_Vehiculo) values ('Motocicleta')
select * from ClaseVehiculo

create table Modelo
(
IdModelo int identity primary key not null,
Ano_Modelo varchar (55) not null
)

insert into Modelo (Ano_Modelo) values ('Ninguno')
insert into Modelo (Ano_Modelo) values ('2015')
insert into Modelo (Ano_Modelo) values ('2015')
insert into Modelo (Ano_Modelo) values ('2015')
insert into Modelo (Ano_Modelo) values ('2015')
/*Modelos Bicicletas*/
insert into Modelo (Ano_Modelo) values ('BMX')
insert into Modelo (Ano_Modelo) values ('Ruta')
insert into Modelo (Ano_Modelo) values ('Montaña')
select * from Modelo

create table Marca
(
IdMarca int identity primary key not null,
Nombre_Marca varchar (55) not null
)

insert into Marca (Nombre_Marca) values ('Ninguna')
insert into Marca (Nombre_Marca) values ('Honda')
insert into Marca (Nombre_Marca) values ('Yamaha')
insert into Marca (Nombre_Marca) values ('KTM')
insert into Marca (Nombre_Marca) values ('Suzuki')
insert into Marca (Nombre_Marca) values ('Kawasaki')
insert into Marca (Nombre_Marca) values ('BMW')
insert into Marca (Nombre_Marca) values ('Ducati')
/*Marca Bicicletas*/
insert into Marca (Nombre_Marca) values ('Cervélo')
insert into Marca (Nombre_Marca) values ('GW')
insert into Marca (Nombre_Marca) values ('Bianchi')


SELECT * FROM Marca

create table Vehiculo
(
IdVehiculo varchar (12) not null,
ColorVehiculo varchar (55) not null,
IdNumeIden_Vehiculo char (12) not null,
IdClase_Vehiculo int not null,
IdModelo_Vehiculo int not null,
IdMarca_Vehiculo int not null
)

alter table Vehiculo add primary key  (IdVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo)
alter table Vehiculo add constraint Fk_Vehiculo_Usuario foreign key (IdNumeIden_Vehiculo) references Usuario (IdNumeIden)
alter table Vehiculo add constraint Fk_Vehiculo_Clase foreign key (IdClase_Vehiculo) references ClaseVehiculo (IdClase)
alter table Vehiculo add constraint Fk_Vehiculo_Modelo foreign key (IdModelo_Vehiculo) references Modelo (IdModelo)
alter table Vehiculo add constraint Fk_Vehiculo_Marca foreign key (IdMarca_Vehiculo) references Marca (IdMarca)
alter table Vehiculo add unique (IdVehiculo)

insert into Vehiculo (IdVehiculo,ColorVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo) values ('AXD28A','Negro','1014568687',2,2,2)
insert into Vehiculo (IdVehiculo,ColorVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo) values ('DFR35B','Rojo','1014567824',2,3,3)
insert into Vehiculo (IdVehiculo,ColorVehiculo,IdNumeIden_Vehiculo,IdClase_Vehiculo,IdModelo_Vehiculo,IdMarca_Vehiculo) values ('SDFV0000003','Azul','1014567824',1,6,10)
SELECT * FROM Vehiculo
create table conteoparqueadero
 (
 Idlugarparqueadero int identity primary key not null,
 IdVehiculo_Cp char (12) not null
 /*Foreign key (IdVehiculo_Cp) references Vehiculo (IdVehiculo)*/
 )
 


 create table Bahia
(
Id_Bahia Varchar (55) primary key not null,
Cnatidad_Bahias int not null,
Numerador_Bahias int not null
)
insert into Bahia (Id_Bahia,Cnatidad_Bahias,Numerador_Bahias) values ('A1',30,1)
insert into Bahia (Id_Bahia,Cnatidad_Bahias,Numerador_Bahias) values ('B1',30,2)

SELECT * FROM Bahia

 create table Cupo
(
Id_Cupo int not null,
Estado bit,
Id_Bahia_Cupo varchar (55) not null
)

alter table Cupo add primary key (Id_Cupo,Id_Bahia_Cupo)
alter table Cupo add constraint Fk_Bahia_Cupo foreign key (Id_Bahia_Cupo) references Bahia(Id_Bahia)
alter table Cupo add unique (Id_Cupo)

insert into Cupo (Id_Cupo,Estado,Id_Bahia_Cupo) values (1,'true','A1')
insert into Cupo (Id_Cupo,Estado,Id_Bahia_Cupo) values (2,'false','b1')
SELECT * FROM Cupo
 
create table Registro
(
IdRegistro int identity not null,
Fecha_Hora_Ingreso datetime not null,
Fecha_Hora_Salida datetime not null,
Id_Cupo_Registro int not null
)

alter table Registro add primary key (IdRegistro,Id_Cupo_Registro)
alter table Registro add constraint Fk_Registro_Cupo foreign key (Id_Cupo_Registro) references Cupo (Id_Cupo)
/*alter table Registro add Auto_increment (IdRegistro);*/
alter table Registro add unique (IdRegistro)

insert into Registro (Fecha_Hora_Ingreso,Fecha_Hora_Salida,Id_Cupo_Registro) values ('1/1/1999 20:00','1/1/1999 20:30',1)
insert into Registro (Fecha_Hora_Ingreso,Fecha_Hora_Salida,Id_Cupo_Registro) values ('1/1/1999 19:00','1/1/1999 20:30',2)
SELECT * FROM Registro

create table Vehiculo_Registro 
(
IdVehiculo_Registro varchar(12) not null,
IdRegistro_Registro int not null
)

alter table Vehiculo_Registro add unique (IdVehiculo_Registro)
alter table Vehiculo_Registro add primary key (IdVehiculo_Registro,IdRegistro_Registro)
alter table Vehiculo_Registro add constraint Fk_Vehiculo_Registro_vehivulo foreign key (IdVehiculo_Registro) references Vehiculo (IdVehiculo)
alter table Vehiculo_Registro add constraint Fk_Registro_Vehiculo foreign key (IdRegistro_Registro) references Registro (IdRegistro)

insert into Vehiculo_Registro  (IdVehiculo_Registro,IdRegistro_Registro) values('AXD28A',1)
insert into Vehiculo_Registro  (IdVehiculo_Registro,IdRegistro_Registro) values('DFR35B',2)
SELECT * FROM Vehiculo_Registro

create table ServidorCorreo
(
IdServidor int identity primary  key not null,
Recupearcion_de_Contraseña varchar (60) not null,
Corfimar_Cuenta varchar(60) not null,
Cambiar_Comtraseña varchar (60) not null
)

Create table LogError
(
Iderror int identity primary key not null,
Codigo_error varchar (255) not null,
Hora_y_Fecha_Error datetime not null
)



create procedure validacion
@log varchar (30),
@pass varchar (30),
@rol int
as
select * from Usuario
where UserName = @log and Contraseña = @pass and CodRol_Usuario = @rol
go