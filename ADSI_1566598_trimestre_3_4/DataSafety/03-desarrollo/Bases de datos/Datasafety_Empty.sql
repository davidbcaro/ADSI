create database Datasafety;
use Datasafety;

Create table TipoUsuario(
IdTipoUsuario int not null,
NombreTipoUsuario  varchar (255) not null
);


Create table TipoDocumento(
IdTipoDocumento int not null,
NombreTipoDocumento varchar (255) not null
);

create table Usuarios(
IdUsuario int not null,
N_identificacion int(15) not null,
Primer_nombre varchar(30) not null,
Segundo_nombre varchar (30),
Primer_Apellido varchar (30) not null,
Segundo_Apellido varchar(30),
CorreoIns varchar(255) unique not null,
Estado boolean not null,
Fecha_Act date not null,
Fecha_Inact date not null,
tipousuario_usuario int not null,
TipoDocumento_usuario int not null
);

alter table Usuarios add primary key(IdUsuario,tipoUsuario_Usuario,tipoDocumento_Usuario);
alter table TipoUsuario add primary key(IdTipoUsuario);
alter table TipoDocumento add primary key(IdTipoDocumento);
alter table Usuarios add constraint fk_tipousuario_usuario foreign key (tipousuario_usuario) references TipoUsuario(IdTipoUsuario);
alter table Usuarios add constraint fk_tipoDocumento_usuario foreign key (tipoDocumento_usuario) references tipoDocumento(IdTipoDocumento);

create table MarcaEquipo
(
IdMarcaEquipo int not null primary key,
NombreMarcaEquipo varchar (50) not null
);

create table TipoEquipo
(
IdTipoEquipo int not null primary key,
NombreTipoEquipo varchar (100) not null,
Observacion varchar (255) not null
);


create table Equipo
(
IdEqui int not null,
SerialEqui varchar (25) not null,
ModeloEqui varchar (10) not null,
SerialCargadorEqui varchar (25) not null,
Estado boolean not null,
Observacion varchar (255) not null,
Usuario_Equipo int not null,
MarcaEquipo_Equipo int not null,
TipoEquipo_Equipo int not null
);

alter table Equipo add primary key (MarcaEquipo_Equipo,TipoEquipo_Equipo,Usuario_Equipo,IdEqui);
alter table Equipo add constraint fk_Usuario_Equipo foreign key (Usuario_Equipo) references Usuarios (IdUsuario);
alter table Equipo add constraint fk_MarcaEquipo_Equipo foreign key (MarcaEquipo_Equipo) references MarcaEquipo (IdMarcaEquipo);
alter table Equipo add constraint fk_TipoEquipo_Equipo foreign key (TipoEquipo_Equipo) references TipoEquipo (IdTipoEquipo);
alter table Equipo add unique (IdEqui);


Create table Movimiento(
IdMovimiento int not null,
FechaEntradaMovimiento date not null,
FechaSalidaMovimiento date not null,
Observacion varchar (255) not null,
Movimiento_Equipo int not null
);

alter table Movimiento add primary key (IdMovimiento,Movimiento_Equipo);
alter table Movimiento add constraint fk_Movimiento_Equipo foreign key (Movimiento_Equipo) references Equipo (IdEqui);

create table LogError
(
IdError int not null,
CodigoError varchar (255) not null,
Fecha date not null,
Hora time not null
);

alter table LogError add primary key (IdError);

create table ServidorDeCorreo
(
IdServidorDeCorreo int not null,
RecuperacionDeContraseña varchar (255) not null,
ConfirmacionDeCuenta varchar (255) not null,
CambiarDeContraseña varchar (255) not null
);

alter table ServidorDeCorreo add primary key (IdServidorDeCorreo);

