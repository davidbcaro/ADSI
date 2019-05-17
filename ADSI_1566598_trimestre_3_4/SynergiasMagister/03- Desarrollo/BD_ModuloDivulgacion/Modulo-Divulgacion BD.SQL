create database SynMag_ModDivulgacion;

use SynMag_ModDivulgacion;

create table JORNADALABORAL (
Id_Jornada int primary key auto_increment not null,
JLaboral enum ('Mañana','Tarde','Noche','Completa','FindSemana') null,
JLaboral_Otra varchar (255) null
);

-- --------------------------------------------------------------
-- Tipo Post, Post General

create table TIPOPOST(
Id_TpPostGeneral int (10) not null,
Tipo_Registro int (10) not null,
Tipo_Actualizacion int (10) not null,
primary key (Id_TpPostGeneral)
);

create table POSTGENERAL(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
Evento enum ('UsuarioMI','UsuarioExterno','RegistronBiblioteca','RedComunidad','EntAuspicia','MInRedComunidad','Proyecto','Actividad','OfertaFormativa') not null,
Id_Like int (10) not null,
Id_Comentario int (10) not null,
foreign key (Id_Like) references MONITORLIKES (Id_Like),
foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario)
);

alter table POSTGENERAL add constraint 
Fk1Id_TpPostGeneral foreign key (Id_TpPostGeneral) references TIPOPOST (Id_TpPostGeneral);

alter table POSTGENERAL add primary key (Id_PostGeneral,Id_TpPostGeneral);

-- ---------------------------------------------------------------------------
-- Post Usuario

create table TIPOUSUARIO (
Id_TpUsuario int primary key auto_increment not null,
TpUsuario enum ('Administrador TI','Maestro Investigador', 'Usuario Externo') not null
);

create table USUARIO (
Id_Usuario int not null,
Id_TpUsuario int not null,
PrimerNombre varchar (50) not null,
SegundoNombre varchar (50) null,
PrimerApellido varchar (50) not null,
SegundoApellido varchar (50) null,
DocIdentidad bigint not null unique,
Email varchar (255) not null unique,
telefono bigint null,
URLnSynMag varchar (255) not null unique
); 


alter table USUARIO add constraint 
FK1_TpUsuario foreign key (Id_TpUsuario) references TIPOUSUARIO (Id_TpUsuario);

alter table USUARIO add primary key (Id_Usuario, Id_TpUsuario);

alter table USUARIO modify column Id_Usuario
int not null auto_increment;


create table MAESTROINVESTIGADORA (
Id_Usuario int (10) not null,
Id_TpUsuario int (10) not null,
Perfil text not null,
Fotografia blob not null,
CvLac varchar (255) null unique,
Contraseña varchar (20) not null
);

alter table MAESTROINVESTIGADORA add constraint
FK1_Usuario foreign key (Id_Usuario, Id_TpUsuario) references USUARIO (Id_Usuario, Id_TpUsuario);

alter table MAESTROINVESTIGADORA add primary key (Id_Usuario, Id_TpUsuario); 


-- ----------------------------------------------------------
-- Post Usuario

create table DATACTUALIZADO_USUARIOMI(
Id_DatActualizadoMI int (10) not null,
DtActualiza enum ('Perfil','Formacion','Laboral','ExprInvestiga') not null,
primary key (Id_DatActualizadoMI)
);


create table POSTUSUARIOMI(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
MAESTROINVESTIGADORAId_Usuario int (10) not null,
MAESTROINVESTIGADORAId_TpUsuario int (10) not null,
-- MAESTROINVESTIGADORAId_Ubicacion int (10) not null,
-- MAESTROINVESTIGADORAId_TpUbica int (10) not null,
Id_DatActualizadoMI int (10) not null,
Encabezado varchar (255) not null
-- TotalSeguidores int (3) not null,
-- TotalSeguidos int (3) not null
);

alter table POSTUSUARIOMI add constraint 
Fk1Id_DatActualizadoMI foreign key (Id_DatActualizadoMI) references DATACTUALIZADO_USUARIOMI (Id_DatActualizadoMI);


alter table POSTUSUARIOMI add constraint 
Fk2Id_PostGeneral foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);


alter table POSTUSUARIOMI add constraint 
Fk1MAESTROINVESTIGADORAId_Usuario foreign key (MAESTROINVESTIGADORAId_Usuario,MAESTROINVESTIGADORAId_TpUsuario) references MAESTROINVESTIGADORA (Id_Usuario, Id_TpUsuario); 

alter table POSTUSUARIOMI add primary key (Id_PostGeneral,Id_TpPostGeneral,MAESTROINVESTIGADORAId_Usuario,MAESTROINVESTIGADORAId_TpUsuario);


-- -------------------------------------------------------------------------------------------------------------------
-- Post Usuario Externo 

create table ADMINISTRADORTI (
Id_Usuario int not null,
Id_TpUsuario int not null,
Fotografía blob not null,
Contraseña varchar (16) not null
);

alter table ADMINISTRADORTI add constraint
FK2Id_Usuario foreign key (Id_Usuario, Id_TpUsuario) references USUARIO (Id_Usuario, Id_TpUsuario);

alter table ADMINISTRADORTI add primary key (Id_Usuario, Id_TpUsuario);


create table TIPOUBICACION (
Id_TpUbica int primary key auto_increment not null,
TpUbica enum ('MI-Laboral', 'UExterno' ,'Actividad' ,'Proyecto' ,'EntidadAuspicia' ,'RedComunidad' ,'OftFormativa') not null
);

create table UBICAGEOREFERENCIADOR (
Id_Ubicacion int not null,
Id_TpUbica int not null,
DireccionFisica varchar (100) not null unique,
CodPostal int (6) null,
Coordenadas varchar (20) null,
Descripcion varchar (255) not null
);

alter table UBICAGEOREFERENCIADOR add constraint
FK1_TpUbicacion foreign key (Id_TpUbica) references TIPOUBICACION (Id_TpUbica);

alter table UBICAGEOREFERENCIADOR add primary key (Id_Ubicacion, Id_TpUbica);

alter table UBICAGEOREFERENCIADOR modify column Id_Ubicacion
int not null auto_increment;


create table ENTIDADAUSPICIADORA (
Id_EntAuspicia int not null,
Id_Ubicacion int not null,
Id_TpUbica int not null,
ADMINISTRADORTIId_Usuario int not null,
ADMINISTRADORTIId_TpUsuario int not null,
NomEntidad varchar (50) not null,
Imagen blob not null,
Representante varchar (255) not null,
EmailEntid varchar (255) not null unique,
PaginaWeb varchar (255) null unique,
CertColciencias blob null,
TermAlianza_RedComuniad text not null,
foreign key (ADMINISTRADORTIId_Usuario, ADMINISTRADORTIId_TpUsuario) references ADMINISTRADORTI (Id_Usuario, Id_TpUsuario)
);

alter table ENTIDADAUSPICIADORA add constraint
FK1Id_Ubicacion foreign key (Id_Ubicacion, Id_TpUbica) references UBICAGEOREFERENCIADOR (Id_Ubicacion, Id_TpUbica);

alter table ENTIDADAUSPICIADORA add primary key (Id_EntAuspicia, Id_Ubicacion, Id_TpUbica);

alter table ENTIDADAUSPICIADORA modify column Id_EntAuspicia 
int not null auto_increment;



create table USUARIOEXTERNO (
Id_Usuario int not null,
Id_TpUsuario int not null,
ENTIDADASPICIADORAId_EntAuspicia int (10) null,
ENTIDADASPICIADORAId_Ubicacion int (10) null,
ENTIDADASPICIADORAId_TpUbica int (10) null,
InstitdPertenencia_Otra varchar (100) null,
Id_Ubicacion int not null,
Id_TpUbica int not null,
LabOcupa varchar (100) not null,
Contraseña varchar (16) not null
);

alter table USUARIOEXTERNO add constraint
Fk3Id_Usuario foreign key (Id_Usuario,Id_TpUsuario) references USUARIO (Id_Usuario,Id_TpUsuario);

alter table USUARIOEXTERNO add constraint
Fk2_TpUbicacion foreign key (Id_Ubicacion, Id_TpUbica) references UBICAGEOREFERENCIADOR (Id_Ubicacion, Id_TpUbica);

alter table USUARIOEXTERNO add foreign key (ENTIDADASPICIADORAId_EntAuspicia,ENTIDADASPICIADORAId_Ubicacion, ENTIDADASPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia, Id_Ubicacion, Id_TpUbica);

alter table USUARIOEXTERNO add primary key (Id_Usuario,Id_TpUsuario,Id_Ubicacion,Id_TpUbica);


create table POSTUSUARIOEXTERNO(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
USUARIOEXTERNOId_Usuario int (10) not null,
USUARIOEXTERNOId_TpUsuario int (10) not null,
-- USUARIOEXTERNOId_Ubicacion integer(10) not null,
-- USUARIOEXTERNOId_TpUbica int (10) not null,
Encabezado varchar (255) not null
-- TotalSeguidos int (3) not null
);

alter table POSTUSUARIOEXTERNO add constraint 
Fk3Id_PostGeneral foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);


alter table POSTUSUARIOEXTERNO add constraint 
Fk1USUARIOEXTERNOId_Usuario foreign key (USUARIOEXTERNOId_Usuario,USUARIOEXTERNOId_TpUsuario) references USUARIOEXTERNO (Id_UsuariO,Id_TpUsuario);


alter table POSTUSUARIOEXTERNO add primary key (Id_PostGeneral,Id_TpPostGeneral,USUARIOEXTERNOId_Usuario,USUARIOEXTERNOId_TpUsuario);


-- ------------------------------------------------------------------------------------
-- Post Entidad Auspicia 

create table POSTENTDAUSPICIA(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
ENTIDADAUSPICIADORAId_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion integer(10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null,
Encabezado varchar (255) not null
);


alter table POSTENTDAUSPICIA add constraint 
Fk4Id_PostGeneral foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);


alter table POSTENTDAUSPICIA add constraint 
Fk1ENTIDADAUSPICIADORAId_EntAuspicia foreign key (ENTIDADAUSPICIADORAId_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia,Id_Ubicacion,Id_TpUbica);


alter table POSTENTDAUSPICIA add primary key (Id_PostGeneral,Id_TpPostGeneral,ENTIDADAUSPICIADORAId_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);


-- --------------------------------------------------
-- Post Red Comunidad 

create table REDCOMUNIDADINVESTIGA(
Id_RedComunidad int (10) not null, 
Id_EntAuspicia int (10) not null, 
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null, 
ENTIDADAUSPICIADORAId_TpUbica int (10)  not null, 
ADMINISTRADORTIId_Usuario int (10) not null,  
ADMINISTRADORTIId_TipoUsuario int (10) not null, 
NombreRedComunidad varchar (255) not null, 
MINREDCOMUNIDADId_Usuario int (10) not null, 
MINREDCOMUNIDADId_TipoUsuario int (10) not null,
MINREDCOMUNIDADMAESTROINVESTIGADORId_Ubicacion int (10) not null, 
MINREDCOMUNIDADMAESTROINVESTIGADORId_TpUbica int (10) not null, 
MINREDCOMUNIDADId_RedComunidad int (10) not null, 
MINREDCOMUNIDADId_EntAuspicia int (10) not null,
ColiderRed varchar (255) not null
); 


alter table REDCOMUNIDADINVESTIGA add constraint 
Fk2Id_EntAuspicia foreign key (Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia,Id_Ubicacion, Id_TpUbica);

alter table REDCOMUNIDADINVESTIGA add primary key (Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica);

create table MINREDCOMUNIDAD(
Id_Usuario int (10) not null,
Id_TipoUsuario int (10) not null, 
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null, 
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null, 
ENTIDADAUSPICIADORAId_TpUbica int (10) not null, 
Date_Inicio date not null, 
Date_Final date not null, 
DataBanc varchar (255) not null unique,
LiderRed bit not null, 
CoLiderRed bit null, 
Id_Jornada int (10) not null
); 

alter table MINREDCOMUNIDAD add constraint 
Fk4Id_Usuario foreign key (Id_Usuario, Id_TipoUsuario) references MAESTROINVESTIGADORA (Id_Usuario, Id_TpUsuario); 

alter table MINREDCOMUNIDAD add constraint 
Fk3Id_RedComunidad foreign key (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references  REDCOMUNIDADINVESTIGA (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table MINREDCOMUNIDAD add foreign key (Id_Jornada) references JORNADALABORAL (Id_Jornada);

alter table MINREDCOMUNIDAD add primary key (Id_Usuario, Id_TipoUsuario,Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica);

alter table REDCOMUNIDADINVESTIGA add foreign key (ADMINISTRADORTIId_Usuario,ADMINISTRADORTIId_TipoUsuario) references ADMINISTRADORTI  (Id_Usuario, Id_TpUsuario);

alter table REDCOMUNIDADINVESTIGA add foreign key (MINREDCOMUNIDADId_Usuario,MINREDCOMUNIDADId_TipoUsuario,MINREDCOMUNIDADId_RedComunidad,MINREDCOMUNIDADId_EntAuspicia,MINREDCOMUNIDADMAESTROINVESTIGADORId_Ubicacion,MINREDCOMUNIDADMAESTROINVESTIGADORId_TpUbica) references MINREDCOMUNIDAD (Id_Usuario, Id_TipoUsuario,Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica);


create table DATACTUALIZADO_REDCOMUNIDAD(
Id_DatActualizadaRedComunidad int (10) not null,
DtActualizada enum ('DtBasicos','Descripcion','Caracterizacion','LogrosReconoc','LineasInvestiga','Metas') not null,
primary key (Id_DatActualizadaRedComunidad)
);

create table POSTREDCOMUNIDAD(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
Id_RedComunidad int (10) not null,
ENTIDADAUSPICIADORAId_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion integer(10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null,
Id_DatActualizadaRedComunidad int (10) not null,
Encabezado varchar (255) not null,
TotalIntegrantes int (3) not null
);


alter table POSTREDCOMUNIDAD add constraint
Fk1Id_DatActualizadaRedComunidad foreign key (Id_DatActualizadaRedComunidad) references DATACTUALIZADO_REDCOMUNIDAD (Id_DatActualizadaRedComunidad);


alter table POSTREDCOMUNIDAD add constraint 
Fk5Id_PostGeneral foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);


alter table POSTREDCOMUNIDAD add constraint 
Fk2Id_RedComunidad foreign key (Id_RedComunidad,ENTIDADAUSPICIADORAId_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references REDCOMUNIDADINVESTIGA (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);


alter table POSTREDCOMUNIDAD add primary key (Id_PostGeneral,Id_TpPostGeneral,Id_DatActualizadaRedComunidad,Id_RedComunidad,ENTIDADAUSPICIADORAId_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);


-- -----------------------------------------------------------------------------------------------------------------
-- Post Maestro Investigador en Red Comunidad

 
create table POSTMINREDCOMUNIDAD (
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
Id_Usuario int (10) not null,
Id_TipoUsuario int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion integer(10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null,
Encabezado varchar (255) not null,
TotalIntegrantes_RedComunidad int (3) not null
);


alter table POSTMINREDCOMUNIDAD add constraint
Fk6Id_PostGeneral  foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);

alter table POSTMINREDCOMUNIDAD add constraint
Fk5Id_Usuario foreign key (Id_Usuario,Id_TipoUsuario,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references MINREDCOMUNIDAD (Id_Usuario,Id_TipoUsuario,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);


alter table POSTMINREDCOMUNIDAD add primary key  (Id_PostGeneral,Id_TpPostGeneral,Id_Usuario,Id_TipoUsuario,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);


-- ------------------------------------------------------------------------------------------------------------------------
-- Post Actividad _ Red Comunidad 

create table TIPOACTIVIDAD(
Id_TipoActividad int (10) primary key, 
TpActividad_Evento bit not null, 
TpActividad_Convocatoria bit not null
);

create table ACTIVIDADREDCOMUNIDAD(
Id_Actividad int (10) not null, 
Id_TipoActividad int (10) not null, 
Id_RedComunidad int (10) not null, 
Id_EntAuspicia int (10) not null, 
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null, 
ENTIDADAUSPICIADORAId_TpUbica int (10) not null, 
Titulo varchar (155) not null, 
Detalles blob not null,
FechaInicio timestamp (6) not null, 
FechaFin timestamp not null, 
Imagen blob not null
); 

alter table ACTIVIDADREDCOMUNIDAD add constraint 
Fk1Id_TIPOACTIVIDAD foreign key (Id_TipoActividad) references TIPOACTIVIDAD (Id_TipoActividad);

alter table ACTIVIDADREDCOMUNIDAD add constraint 
Fk4Id_redComunidad foreign key (Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica) references REDCOMUNIDADINVESTIGA (Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica);

alter table ACTIVIDADREDCOMUNIDAD add primary key (Id_Actividad, Id_TipoActividad,Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica);


create table POSTACTIVIDAD_REDCOMUNIDAD(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
Id_Actividad int (10) not null,
Id_TipoActividad int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null,
Encabezado varchar (255) not null,
TotalInscritos int (3) not null
);


alter table POSTACTIVIDAD_REDCOMUNIDAD add constraint 
Fk7Id_PostGeneral  foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);

alter table POSTACTIVIDAD_REDCOMUNIDAD add constraint 
Fk1Id_Actividad foreign key (Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ACTIVIDADREDCOMUNIDAD (Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table POSTACTIVIDAD_REDCOMUNIDAD add primary key (Id_PostGeneral,Id_TpPostGeneral,Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- --------------------------------------------------------------------------------------
-- POST REGISTRO BIBLIOTECA 

create table FUENTE_REGISTROBIBLIOTECA(
Id_FueteRegistro int (10) not null primary key ,
Fuente enum ('NewObra','NesGuiaRecursoInvestiga','NewDiarioProyecto') not null
); 

create table TIPOOBRARECURSODIARIO (
Id_TipoORD int primary key auto_increment not null, 
TpDocumento enum ('DocumentoLectura','ArchivoMultimedia','OVA', 'otro') not null, 
Tipo_Otro varchar (255) null
); 

create table OBRARECURSODIARIO (
Id_ObraRecursoDiario int not null, 
Id_TipoORD int not null, 
Titulo varchar (255) not null, 
Fecha date not null, 
URLnSynMag varchar (255) not null unique, 
Resumen varchar (500) not null, 
ENTIDADAUSPICIADORAId_EntAuspicia int  null,
ENTIDADAUSPICIADORAId_Ubicacion int null,
ENTIDADAUSPICIADORAId_TpUbica int null,
ENTIDADAUSPICIADORA_Otra varchar (100) null,
Evidencia blob not null,
foreign key (ENTIDADAUSPICIADORAId_EntAuspicia, ENTIDADAUSPICIADORAId_Ubicacion, ENTIDADAUSPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia, Id_Ubicacion, Id_TpUbica)
); 

alter table OBRARECURSODIARIO add constraint 
FK1_TIPOOBRARECURSODIARIO foreign key (Id_TipoORD) references TIPOOBRARECURSODIARIO (Id_TipoORD);

alter table OBRARECURSODIARIO add primary key (Id_ObraRecursoDiario, Id_TipoORD);

alter table OBRARECURSODIARIO modify column Id_ObraRecursoDiario 
int not null auto_increment;


create table POSTREGISTROBIBLIOTECA(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
Id_ObraRecursoDiario int (10) not null,
Id_TipoORD int (10) not null,
Id_FueteRegistro int (10) not null,
Encabezado varchar (255) not null,
TotalConsultas int (4) not null
);


alter table POSTREGISTROBIBLIOTECA add constraint
Fk1Id_FueteRegistro foreign key (Id_FueteRegistro) references FUENTE_REGISTROBIBLIOTECA (Id_FueteRegistro);

alter table POSTREGISTROBIBLIOTECA add constraint 
Fk8Id_PostGeneral  foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);

alter table POSTREGISTROBIBLIOTECA add constraint 
Fk1Id_ObraRecursoDiario foreign key (Id_ObraRecursoDiario,Id_TipoORD) references OBRARECURSODIARIO (Id_ObraRecursoDiario,Id_TipoORD);

alter table POSTREGISTROBIBLIOTECA add primary key (Id_PostGeneral,Id_TpPostGeneral,Id_ObraRecursoDiario,Id_TipoORD,Id_FueteRegistro);


-- ------------------------------------------------------------------------------


create table REDCOMUNIDAD_LINEADINVESTIGACION(
Id_LineaInvestiga int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null,
NombreLineaInvestiga varchar (255) not null,
Objetivos varchar (500) not null,
Logros varchar (500) not null
);

alter table REDCOMUNIDAD_LINEADINVESTIGACION add constraint
Fk5Id_RedCOmunidad foreign key (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references REDCOMUNIDADINVESTIGA (Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table REDCOMUNIDAD_LINEADINVESTIGACION add primary key (Id_LineaInvestiga,Id_RedComunidad, Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

Create table TIPOPROYECTO(
Id_TipoPory int (10) primary key auto_increment, 
TipoProy enum ('ProyInvestiga','ProyDsrrllTecnologico','ProyInnova','ProyEstencionRespSocial') not null
);

-- PROYECTODINVESTIGACION --

Create table PROYECTODINVESTIGACION(
Id_ProyectoInvestiga int (10) not null,
Id_TipoProy int (10) not null,
Id_Ubicacion int (10) not null,
Id_TipoUbica int (10) not null,
Titulo varchar (255) not null,
Id_LineaInvestiga int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TipoUbica int (10) not null,
Resumen text not null,
FechaInicio date not null,
FechaFin date null,
ActivonSynMag bit not null
);

alter table PROYECTODINVESTIGACION add constraint
Fk1Id_TIPOPROYECTO foreign key (Id_TipoProy) references TIPOPROYECTO (Id_TipoPory);

alter table PROYECTODINVESTIGACION add constraint
Fk2_UBICACION foreign key (Id_Ubicacion,Id_TipoUbica) references UBICAGEOREFERENCIADOR (Id_Ubicacion,Id_TpUbica);

alter table PROYECTODINVESTIGACION add primary key (Id_ProyectoInvestiga,Id_TipoProy,Id_Ubicacion,Id_TipoUbica);


-- --------------------------------------------------------------------------
-- 	POST PROYECTO


create table DATACTUALIZADO_PROYECTO(
Id_DatActualizaProyecto int (10) not null,
DatActualiza enum ('DescripcionProy','DiariosProy','ActividadesProy','RepositorioDocsProy'),
primary key (Id_DatActualizaProyecto)
);

create table POSTPROYECTO(
Id_PostGeneral int (10) not null,
Id_TpPostGeneral int (10) not null,
Id_ProyectoInvestiga int (10) not null,
Id_TipoProy int (10) not null,
PROYECTODINVESTIGACIONId_Ubicacion int (10) not null,
PROYECTODINVESTIGACIONId_TpUbica int (10) not null,
Id_DatActualizaProyecto int (10) not null,
Encabezado varchar (255) not null,
UsuariosSiguiendo int (4) not null
);

alter table POSTPROYECTO add constraint
Fk1Id_DatActualizaProyecto foreign key (Id_DatActualizaProyecto) references DATACTUALIZADO_PROYECTO (Id_DatActualizaProyecto);


alter table POSTPROYECTO add constraint
Fk9Id_PostGeneral  foreign key (Id_PostGeneral,Id_TpPostGeneral) references POSTGENERAL (Id_PostGeneral,Id_TpPostGeneral);


alter table POSTPROYECTO add constraint
Fk1Id_ProyectoInvestiga foreign key (Id_ProyectoInvestiga,Id_TipoProy,PROYECTODINVESTIGACIONId_Ubicacion,PROYECTODINVESTIGACIONId_TpUbica) references PROYECTODINVESTIGACION (Id_ProyectoInvestiga,Id_TipoProy,Id_Ubicacion,Id_TipoUbica);


alter table POSTPROYECTO add primary key (Id_PostGeneral,Id_TpPostGeneral,Id_ProyectoInvestiga,Id_TipoProy,PROYECTODINVESTIGACIONId_Ubicacion,PROYECTODINVESTIGACIONId_TpUbica,Id_DatActualizaProyecto);

-- ------------------------------------------------------------------------------------------------
-- MONITOR DE LIKES 

create table MONITORLIKES(
Id_Like int (10) not null,
Fecha date not null,
UserEmisor varchar (255) not null,
primary key (Id_Like)
);

-- -------------------------------------------------------------------------------
-- MONITOR LIKES MAESTRO INVESTIGADORA


create table MONITORKIES_MAESTROINVESTIGADORA(
Id_Like int (10) not null,
Id_Usuario int (10) not null,
Id_TipoUsuario int (10) not null
); 

alter table MONITORKIES_MAESTROINVESTIGADORA add constraint 
Fk1Id_Like foreign key (Id_Like) references MONITORLIKES (Id_Like);

alter table MONITORKIES_MAESTROINVESTIGADORA add constraint
Fk6Id_Usuario foreign key (Id_Usuario,Id_TipoUsuario) references MAESTROINVESTIGADORA (Id_Usuario,Id_TpUsuario);

alter table MONITORKIES_MAESTROINVESTIGADORA add primary key (Id_Like,Id_Usuario,Id_TipoUsuario);

-- -----------------------------------------------------------------------------------------------
-- MONITOR LIKES USUARIO EXTERNO 

-- AHUN NO ESTA 

create table MONITORLIKES_USUARIOEXTERNO(
Id_Like int (10) not null,
USUARIOEXTERNOId_Usuario int (10) not null,
USUARIOEXTERNOId_TipoUsuario int (10) not null,
USUARIOEXTERNOId_Ubicaicon int (10) not null,
USUARIOEXTERNOId_TpUbica int (10) not null
); 

alter table MONITORLIKES_USUARIOEXTERNO add constraint 
Fk2Id_Like foreign key (Id_Like) references MONITORLIKES (Id_Like);

alter table MONITORLIKES_USUARIOEXTERNO add constraint 
Fk4USUARIOEXTERNOId_Usuario foreign key (USUARIOEXTERNOId_Usuario,USUARIOEXTERNOId_TipoUsuario,USUARIOEXTERNOId_Ubicaicon,USUARIOEXTERNOId_TpUbica) references USUARIOEXTERNO (Id_Usuario,Id_TpUsuario,Id_Ubicacion,Id_TpUbica);

alter table MONITORLIKES_USUARIOEXTERNO add primary key (Id_Like,USUARIOEXTERNOId_Usuario,USUARIOEXTERNOId_TipoUsuario,USUARIOEXTERNOId_Ubicaicon,USUARIOEXTERNOId_TpUbica);

-- ------------------------------------------------------------------------------
-- MONITOR LIKES _ ENTIDAD AUSPICIA

create table MONITORLIKES_ENTIDADAUSPICIA(
Id_Like int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORLIKES_ENTIDADAUSPICIA add constraint 
Fk3Id_Like foreign key (Id_Like) references MONITORLIKES (Id_Like);

alter table MONITORLIKES_ENTIDADAUSPICIA add constraint 
Fk1Id_EntAuspicia foreign key (Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia,Id_Ubicacion,Id_TpUbica);

alter table MONITORLIKES_ENTIDADAUSPICIA add primary key (Id_Like,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- ------------------------------------------------------------------------------
-- MONITOR LIKES _ RED COMUNIDAD INVESTIGA

create table MONITORLIKES_REDCOMUNIDADINVESTIGA(
Id_like int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORLIKES_REDCOMUNIDADINVESTIGA add constraint 
Fk4Id_Like foreign key (Id_Like) references MONITORLIKES (Id_Like);
	
alter table MONITORLIKES_REDCOMUNIDADINVESTIGA add constraint
Fk6Id_RedComunidad foreign key (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references REDCOMUNIDADINVESTIGA (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table MONITORLIKES_REDCOMUNIDADINVESTIGA add primary key (Id_Like,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- -------------------------------------------------------------------------
-- MONITOR LIKES _ ACTIVIDAD RED COMUNIDAD

create table MONITORLIKES_ACTIVIDADREDCOMUNIDAD(
Id_like int (10) not null,
Id_Actividad int (10) not null,
Id_TipoActividad int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORLIKES_ACTIVIDADREDCOMUNIDAD add constraint 
Fk5Id_Like foreign key (Id_Like) references MONITORLIKES (Id_Like);

alter table MONITORLIKES_ACTIVIDADREDCOMUNIDAD add constraint
Fk2Id_Actividad foreign key (Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ACTIVIDADREDCOMUNIDAD (Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table MONITORLIKES_ACTIVIDADREDCOMUNIDAD add primary key (Id_Like,Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- -------------------------------------------------------------------------
-- MONITOR LIKES _ OBRA RECURSO DIARIO 

create table MONTORLIKES_OBRARECURSODIARIO(
Id_like int (10) not null,
OBRARECURSODIARIOId_ObraRecursoDiario int (10) not null,
OBRARECURSODIARIOId_TipoORD int (10) not null
);

alter table MONTORLIKES_OBRARECURSODIARIO add constraint 
Fk6Id_Like foreign key (Id_Like) references MONITORLIKES (Id_Like);

alter table MONTORLIKES_OBRARECURSODIARIO add constraint
Fk1OBRARECURSODIARIOId_ObraRecursoDiario foreign key (OBRARECURSODIARIOId_ObraRecursoDiario,OBRARECURSODIARIOId_TipoORD) references OBRARECURSODIARIO (Id_ObraRecursoDiario,Id_TipoORD);

alter table MONTORLIKES_OBRARECURSODIARIO add primary key (Id_Like,OBRARECURSODIARIOId_ObraRecursoDiario,OBRARECURSODIARIOId_TipoORD);

-- ---------------------------------------------------------------------------
-- MONITOR LIKES _ PROYECTO INVESTIGA

create table MONITORLIKES_PROYECTOINVESTIGA(
MONITORLIKESId_like int (10) not null,
Id_ProyectoInvestiga int (10) not null,
Id_TipoProy int (10) not null,
PROYECTODINVESTIGACIONId_Ubicacion int (10) not null,
PROYECTODINVESTIGACIONId_TpUbica int (10) not null
);

alter table MONITORLIKES_PROYECTOINVESTIGA add constraint 
Fk1MONITORLIKESId_like foreign key (MONITORLIKESId_like) references MONITORLIKES (Id_Like);
	
alter table MONITORLIKES_PROYECTOINVESTIGA add constraint
Fk2Id_ProyectoInvestiga foreign key (Id_ProyectoInvestiga,Id_TipoProy,PROYECTODINVESTIGACIONId_Ubicacion,PROYECTODINVESTIGACIONId_TpUbica) references PROYECTODINVESTIGACION (Id_ProyectoInvestiga,Id_TipoProy,Id_Ubicacion,Id_TipoUbica);

alter table MONITORLIKES_PROYECTOINVESTIGA add primary key (MONITORLIKESId_like,Id_ProyectoInvestiga,Id_TipoProy,PROYECTODINVESTIGACIONId_Ubicacion,PROYECTODINVESTIGACIONId_TpUbica);

-- ------------------------------------------------------------------------
-- MONITOR LIKES _ OFERTA FORMATIVA

Create table OFERTAFORMATIVA(
Id_OftFormativa int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null,
NomFormativa varchar (255) not null,
DescripcionForm blob not null,
Id_Ubicacion int (10) not null,
Id_TpUbica int (10) not null,
Fecha_Inicio date not null,
Fecha_Fin date not null,
IntHoraria int (10) not null,
Costos int (10) not null,
ModalidadForm varchar (255) not null
);


alter table OFERTAFORMATIVA add constraint
Fk1_Id_ENTIDADAUSPICIA foreign key(Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia,Id_Ubicacion, Id_TpUbica);


alter table OFERTAFORMATIVA add primary key(Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);


create table MONITORLIKES_OFERTAFORMATIVA(
Id_like int (10) not null,
Id_OftFormativa int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORLIKES_OFERTAFORMATIVA add constraint
Fk7Id_like foreign key (Id_like) references  MONITORLIKES (Id_Like);

alter table MONITORLIKES_OFERTAFORMATIVA add constraint
Fk1Id_OftFormativa foreign key (Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references OFERTAFORMATIVA (Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table  MONITORLIKES_OFERTAFORMATIVA add primary key (Id_like,Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- --------------------------------------------------------------------------
-- MONITOR COMENTARIOS

create table MONITORCOMENTARIOS(
Id_Comentario int (10) not null,
Fecha date not null,
UserEmisor varchar (255) not null,
Comentario varchar (1000) not null,
primary key (Id_Comentario)
);

-- ---------------------------------------------------------------------
-- MONITOR COMENTARIOS MAESTRO INVESTIGADORA

create table MONITORCOMENTARIOS_MAESTROINVESTIGADORA(
Id_Comentario int (10) not null,
Id_Usuario int (10) not null,
Id_TipoUsuario int (10) not null
); 

alter table MONITORCOMENTARIOS_MAESTROINVESTIGADORA add constraint
Fk1Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);

alter table MONITORCOMENTARIOS_MAESTROINVESTIGADORA add constraint
Fk7Id_Usuario foreign key (Id_Usuario,Id_TipoUsuario) references MAESTROINVESTIGADORA (Id_Usuario,Id_TpUsuario);

alter table MONITORCOMENTARIOS_MAESTROINVESTIGADORA add primary key (Id_Comentario,Id_Usuario,Id_TipoUsuario);

-- ---------------------------------------------------------
-- MONITOR COMENTARIOS ENTIDAD AUSPICIA

create table MONITORCOMENTARIOS_ENTIDADAUSPICIA(
Id_Comentario int (10) not null,
ENTIDADAUSPICIADORAId_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORCOMENTARIOS_ENTIDADAUSPICIA add constraint 
Fk2Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);

alter table MONITORCOMENTARIOS_ENTIDADAUSPICIA add constraint 
Fk2ENTIDADAUSPICIADORAId_EntAuspicia foreign key (ENTIDADAUSPICIADORAId_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ENTIDADAUSPICIADORA (Id_EntAuspicia,Id_Ubicacion,Id_TpUbica);

alter table MONITORCOMENTARIOS_ENTIDADAUSPICIA add primary key (Id_Comentario,ENTIDADAUSPICIADORAId_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- ------------------------------------------------------------
-- MONITOR COMENTARIOS RED COMUNIDAD INVESTIGA

create table MONITORCOMENTARIOS_REDCOMUNIDADINVESTIGA(
Id_Comentario int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORCOMENTARIOS_REDCOMUNIDADINVESTIGA add constraint 
Fk3Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);
	
alter table MONITORCOMENTARIOS_REDCOMUNIDADINVESTIGA add constraint
Fk7Id_RedComunidad foreign key (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references REDCOMUNIDADINVESTIGA (Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table MONITORCOMENTARIOS_REDCOMUNIDADINVESTIGA add primary key (Id_Comentario,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- --------------------------------------------------------------------
-- MONITOR COMENTARIOS ACTIVIDAD RED COMUNIDAD 

create table MONITORCOMENTARIOS_ACTIVIDADREDCOMUNIDAD(
Id_Comentario int (10) not null,
Id_Actividad int (10) not null,
Id_TipoActividad int (10) not null,
Id_RedComunidad int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORCOMENTARIOS_ACTIVIDADREDCOMUNIDAD add constraint 
Fk4Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);

alter table MONITORCOMENTARIOS_ACTIVIDADREDCOMUNIDAD add constraint
Fk3Id_Actividad foreign key (Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references ACTIVIDADREDCOMUNIDAD (Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table MONITORCOMENTARIOS_ACTIVIDADREDCOMUNIDAD add primary key (Id_Comentario,Id_Actividad,Id_TipoActividad,Id_RedComunidad,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- -----------------------------------------------------------------------
-- MONITOR COMENTARIOS OBRA RECURSO DIARIO 


create table MONTORCOMENTARIOS_OBRARECURSODIARIO(
Id_Comentario int (10) not null,
OBRARECURSODIARIOId_ObraRecursoDiario int (10) not null,
OBRARECURSODIARIOId_TipoORD int (10) not null
);

alter table MONTORCOMENTARIOS_OBRARECURSODIARIO add constraint 
Fk5Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);

alter table MONTORCOMENTARIOS_OBRARECURSODIARIO add constraint
Fk2OBRARECURSODIARIOId_ObraRecursoDiario foreign key (OBRARECURSODIARIOId_ObraRecursoDiario,OBRARECURSODIARIOId_TipoORD) references OBRARECURSODIARIO (Id_ObraRecursoDiario,Id_TipoORD);

alter table MONTORCOMENTARIOS_OBRARECURSODIARIO add primary key (Id_Comentario,OBRARECURSODIARIOId_ObraRecursoDiario,OBRARECURSODIARIOId_TipoORD);

-- -----------------------------------------------------------
-- MONITOR COMENTARIOS PROYECTO INVESTIGA 

create table MONITORCOMENTRIOS_PROYECTOINVESTIGA(
Id_Comentario int (10) not null,
Id_ProyectoInvestiga int (10) not null,
Id_TipoProy int (10) not null,
PROYECTODINVESTIGACIONId_Ubicacion int (10) not null,
PROYECTODINVESTIGACIONId_TpUbica int (10) not null
);

alter table MONITORCOMENTRIOS_PROYECTOINVESTIGA add constraint 
Fk6Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);
	
alter table MONITORCOMENTRIOS_PROYECTOINVESTIGA add constraint
Fk3Id_ProyectoInvestiga foreign key (Id_ProyectoInvestiga,Id_TipoProy,PROYECTODINVESTIGACIONId_Ubicacion,PROYECTODINVESTIGACIONId_TpUbica) references PROYECTODINVESTIGACION (Id_ProyectoInvestiga,Id_TipoProy,Id_Ubicacion,Id_TipoUbica);

alter table MONITORCOMENTRIOS_PROYECTOINVESTIGA add primary key (Id_Comentario,Id_ProyectoInvestiga,Id_TipoProy,PROYECTODINVESTIGACIONId_Ubicacion,PROYECTODINVESTIGACIONId_TpUbica);

-- ---------------------------------------------------------------------
-- MONITOR COMENTARIOS OFERTA FORMATIVA

create table MONITORCOMENTRIOS_OFERTAFORMATIVA(
Id_Comentario int (10) not null,
Id_OftFormativa int (10) not null,
Id_EntAuspicia int (10) not null,
ENTIDADAUSPICIADORAId_Ubicacion int (10) not null,
ENTIDADAUSPICIADORAId_TpUbica int (10) not null
);

alter table MONITORCOMENTRIOS_OFERTAFORMATIVA add constraint
Fk7Id_Comentario foreign key (Id_Comentario) references  MONITORCOMENTARIOS (Id_Comentario);

alter table MONITORCOMENTRIOS_OFERTAFORMATIVA add constraint
Fk2Id_OftFormativa foreign key (Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica) references OFERTAFORMATIVA (Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

alter table  MONITORCOMENTRIOS_OFERTAFORMATIVA add primary key (Id_Comentario,Id_OftFormativa,Id_EntAuspicia,ENTIDADAUSPICIADORAId_Ubicacion,ENTIDADAUSPICIADORAId_TpUbica);

-- --------------------------------------------------------
-- MONITOR COMENTARIOS USUARIO EXTERNO 

create table MONITORCOMENTARIOS_USUARIOEXTERNO(
Id_Comentario int (10) not null,
USUARIOEXTERNOId_Usuario int (10) not null,
USUARIOEXTERNOId_TipoUsuario int (10) not null,
USUARIOEXTERNOId_Ubicaicon int (10) not null,
USUARIOEXTERNOId_TpUbica int (10) not null
); 

alter table MONITORCOMENTARIOS_USUARIOEXTERNO add constraint 
Fk8Id_Comentario foreign key (Id_Comentario) references MONITORCOMENTARIOS (Id_Comentario);

alter table MONITORCOMENTARIOS_USUARIOEXTERNO add constraint 
Fk3USUARIOEXTERNOId_Usuario foreign key (USUARIOEXTERNOId_Usuario,USUARIOEXTERNOId_TipoUsuario,USUARIOEXTERNOId_Ubicaicon,USUARIOEXTERNOId_TpUbica) references USUARIOEXTERNO (Id_Usuario,Id_TpUsuario,Id_Ubicacion,Id_TpUbica);

alter table MONITORCOMENTARIOS_USUARIOEXTERNO add primary key (Id_Comentario,USUARIOEXTERNOId_Usuario,USUARIOEXTERNOId_TipoUsuario,USUARIOEXTERNOId_Ubicaicon,USUARIOEXTERNOId_TpUbica);


