create database SynergiasMagister;

use SynergiasMagister;

-- ModuloUsuario


create table Usuario(
Id_Usaurio int (15) not null,
Id_URLSynMag int (15) not null,
PrimerNombre varchar (50) not null,
SegundoNombre varchar (50) null,
PrimerApellido varchar (50) not null,
SegundoApellido varchar (50) null,
DocumentoIdentidad int (15) not null,
Email varchar (50) not null unique,
telefono int (15) not null
);

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('001','001','Andres','Felipe','Ibarra','Gomez','53264851','Andres_@gmail.com','304621354');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('002','002','Juan','Fernando','Castañeda','Pinto','1023558984','Juan_@gmail.com','321456898');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('003','003','Luis','Fernando','Arevalo','Ruiz','1023789854','Luis_@gmail.com','3001234598');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('004','004''Paula','Andrea','Gonzales','Gonzales','1024895654','Paula_@gmail.com','3216547896');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('005','005','Andres','Felipe','Perez','Piraquive','54987698','AndresF_@gmail.com','311456987');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('006','006','Diego','Alejandro','Gil','Castro','1025987654','Diego_@gmail.com','3128549874');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('007','007','Jennifer','Lorena','Casierra','Lopez','1024897478','Jennifer_@gmail.com','3259874587');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('008','008','Maike','Alfonso','Bahia','Perez','54879548','Maike_@gmail.com','311654988');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('009','009','Stefanny','Aurora','Sanchez','Cardozo','1204556984','Stefanny_@gmail.com','3217418596');

insert into Usuario (Id_Usaurio,Id_URLSynMag,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,DocumentoIdentidad,Email,telefono)
values ('010','010','Jhon','Jaider','Castañeda','Suares','52997874','Jhon_@gmail.com','3114789652');


create table MaestroInvestigador(
Id_Usaurio int (10) not null,
Contraseña varchar (16) not null,
Perfil_Corto varchar (255) not null,
Fotografia blob null,
CvLac varchar (255) null
);
 
 
create table TipoUsuario(
Id_Tipo_Usuario int (10) not null,
Id_Usaurio int (10) not null,
TipoU enum ('Administrador','MaestroInvestigador', 'UsuarioExterno') not null
);

 
create table Chat( 
Id_Chat int (10) not null,
Id_Usaurio int (10) not null,
Fecha date not null,
Receptor varchar (100) not null,
Transcripcion text not null
); 


create table UsuarioExterno(
I_dUsaurio int (8) not null,
Id_Ubicacion int not null,
Id_InstAuspiciadora int not null,
InstPertenenciaOtra varchar (100) not null,
LaborOcupacion varchar (70) not null
); 
 
 
create table Titulacion(
Id_Titulacion int (10) not null,
Titulo varchar (100) not null
); 
 
 
create table Universidad_Institucion(
Id_Universidad int (10) not null,
NomUnivarsidad varchar (100) not null
); 
 
 
create table CarreraLicenciatura(
Id_CarreraMI int (10) not null, 
Id_Usaurio int (10) not null, 
FechaFin date not null
); 
 
 
Create table Posgrado(
Id_PosgradoMI int (10) not null,
Id_Usuario int (10) not null,
FechaFin date 
); 


create table OtrasFormaciones( 
Id_OtraFormacionMI int (10) not null, 
Id_Usuario int (10) not null, 
FechaFin date, 
IntensHoras varchar (10) not null
); 
 
 
create table OtroIdioma( 
Id_OtroIdiomaMI int (10) not null, 
Id_Usuario int (10) not null, 
NomIdioma varchar (15) not null, 
Certificado bit not null
); 
 
 
create table IdiomaEscrito(
Id_PorctDominio int (10) not null, 
Id_OtroIdiomaMI int (10) not null, 
Id_Usuario int (10) not null, 
Porct enum ('10%', '20%', '30%', '40%', '50%', '60%', '70%', '80%', '90%', '100%') not null
);
 
 
create table IdiomaHablado(
Id_PorctDominio int (10) not null, 
Id_OtroIdiomaMI int (10) not null, 
Id_Usuario int (10) not null, 
Porct enum ('10%', '20%', '30%', '40%', '50%', '60%', '70%', '80%', '90%', '100%') not null
);
 
 
create table IdiomaLeido(
Id_PorctDominio int (10) not null, 
Id_OtroIdiomaMI int (10) not null, 
Id_Usuario int (10) not null, 
Porct enum ('10%', '20%', '30%', '40%', '50%', '60%', '70%', '80%', '90%', '100%') not null
);

 
create table IdiomaEscuchado(
Id_PorctDominio int (10) not null, 
Id_OtroIdiomaMI int (10) not null, 
Id_Usuario int (10) not null, 
Porct enum ('10%', '20%', '30%', '40%', '50%', '60%', '70%', '80%', '90%', '100%') not null
);
 

create table MaestroInvestigaInfLaboral(
Id_InfLaboral int (10) not null, 
Id_Usuario int (10) not null, 
Id_Ubicacion int (10) not null, 
Id_InsAuspiciadora int (10) not null, 
OtrInstPertenencia varchar (100) not null,
AreasDocencia varchar (150) not null, 
EmailInstitucion varchar (100) null
); 

 
create table JornadaLaboral(
Id_Jornada int (10) not null, 
Id_Usuario int (10) not null,
Id_InfLaboral int (10) not null, 
JornadaLaboral enum ('Mañana','Tarde','Noche','Completa','FinSemana') not null,
JornadaLaboralOtra varchar (50) not null
);

 
create table MInProyecto(
Id_Usuario int (10) not null, 
Id_ProyectoInvestiga int (10) not null, 
Id_Rol int (10) not null
);

 
create table RolnProyecto(
Rol enum ('Lider','Asistente','Metodologo','Auxiliar') not null,
Rol_otro char (50) not null, 
Responsabilidades varchar (500) not null,
Logros varchar (500) not null
); 

 
create table UsuarioMIDistinciones(
Id_DistincionMI int (10) not null,
Id_Usuario int (10) not null,
Titulo varchar (255) not null, 
Id_InstAuspiciadora int (10) null, 
OtraInstOtorgante varchar (255) null, 
Evidencias blob not null
);

 
create table TipoDistincion(
Id_TpDistincion int (10) not null, 
Id_DistincionMI int (10) not null, 
Id_Usuario int (10) not null, 
TipoDis enum ('Premiacion','Reconocimiento publico','Incentivo Academico','Incentivo Institucional') not null, 
Tipo_Otro char (50) not null
); 

 
create table UsuarioMIPublicaciones(
Id_Usuario int (10) not null, 
Id_ObraRecursoDiario int (10) not null, 
Id_InstAuspiciadora int (10) not null, 
ISSN_DOI varchar (20) null,
enBibliotecaMI enum ('A','B') not null
);

 
create table PublicacionesMaterias( 
Id_Usuario int (10) not null, 
Id_ObraRecursoDiario int (10) not null, 
Id_Materia int (10) not null
); 

 
create table PublicacionesAutores(
Id_Usuario int (10) not null, 
Id_ObraRecursoDiario int (10) not null, 
Id_Autores int (10) not null
); 

 
create table PublicacionesPalabrasClave(
Id_Usuario int (10) not null,  
Id_ObraRecursoDiario int (10) not null, 
Id_PalabraClave int (10) not null
); 

 
create table UsuariMIPonencia(
Id_PonenciaMI int (10) not null, 
Id_Usuario int (10) not null, 
Titulo varchar (255) not null, 
Fecha date not null, 
NombreEvento varchar(255) not null, 
Resumen varchar(255) not null,
Evidencia blob not null
); 

 
create table PonenciaAutores(
Id_Usuario int (10) not null, 
Id_PonenciaMI int (10) not null, 
Id_Autor int (10) not null
); 


create table PonenciaPalabrasClave(
Id_Usaurio int (10) not null, 
Id_PonenciaMI int (10) not null, 
Id_PalabraClave int (10) not null
); 


create table URLnSynMag(
Id_URLnSynMag int (10) not null, 
URL varchar (255) not null, 
EntidadRef char(50) not null
); 


create table UExternoSigueMI(
Id_UsaurioExtSeguidor int (10) not null, 
Id_UsaurioMISeguido int (10) not null
); 


create table UsaurioExternoTemasDeInteres(
Id_Usuario int (10) not null, 
Id_Tema int(10) not null
);


create table TemasInteres(
Id_Tema int (10) not null, 
Tema char (50) not null
); 


create table AdministradorTI(
Id_Usuario int(10) not null, 
Fotografia blob not null, 
UserName varchar (20) not null, 
Contraseña varchar (16) not null
); 


create table LogError(
Id_Error int (10) not null primary key,
NomError varchar (50) not null, 
Descripcion blob not null
); 


create table servidorEmail(
Id_PinServer int (10) not null primary key,
Descripcion blob not null, 
NomPinServer varchar (50) not null, 
Fecha timestamp not null
); 


create table UsuarioMIParticipacionProyectos(
Id_Usuario int (10) not null, 
Id_ProyectoInvestiga int (10) not null, 
NombreProyecto varchar (255) not null, 
Id_Rol varchar (10) not null, 
OtroGrupoInvestigacion varchar (255) null, 
Evidencia blob not null
);


 
-- ModuloSalaProfesores

create table RedComunidadInvestiga (
Id_RedComunidadInvestiga int (10) not null,
Id_Usuario int (10) not null,
Id_InstAuspiciadora int (10) not null,
Id_Ubicaicon int (10) not null,
Id_URlnSynMag int (10) not null,
Nombres varchar (50) not null,
LiderRed varchar (255) not null
);

create table RedComunidadInvestiga_Descripcion (
Id_DescripcionRed int (10) not null,
Id_RedComunidadInvestiga int (10) not null,
Co_lider varchar (50) not null,
Email varchar (100) not null,
RedesSociales varchar (255) not null,
WebSite varchar (255) not null,
TerminosAsociadosMI varchar (2000) not null,
PagosVirtuales varchar (255) not null,
ImagenRedGrupo blob not null
);

create table RedComunidadInvestiga_Caracterizacion (
Id_CaracterizacionRed int (10) not null,
Id_RedComunidadInvestiga int (10) not null,
RegtHistorico blob not null,
Objeticvos varchar (500) not null,
FundaEnfoque blob not null,
ColaborAuspiciante blob null,
PlanTrabajo blob not null,
Alianzas blob not null
);

create table RedComunidadInvestiga_LogrosReconocimientos (
Id_LogroReconocimiento int (10) not null,
Id_RedComunidadInvestiga int (10) not null,
Titulo varchar (255) not null,
Otorgante varchar (255) not null,
Evidencia blob not null
);

create table TipoLogroReconociemiento (
Id_TlRec int (10) not null,
Id_LogroReconocimiento int (10) not null,
Id_RedComunidadInvestiga int (10) not null,
Tipo enum ('Premiacion','MencionPublico','IncentivoAcademico','IncentivoInstitucional') not null
);

create table RedComunidadInvestiga_MetasAnuales (
Id_MetaAnual int (10) not null,
Id_RedComunidadInvestiga int (10) not null,
Meta varchar (100) not null,
Indicador varchar (50) not null,
PorcAlcanse enum ('10%','20%','30%','40%','50','60%','70%','80%','90%','100%') not null,
Actualizacion enum ('Automatica','Manual') not null,
MonitorSynMag varchar (50) not null
);

create table RedComunidadInvestiga_LineasInvestigacion (
Id_LineaInvestigacion int (10) not null,
Id_RedComunidadInvestiga int (10) not null,
NombreLineaInvestiga varchar (50) not null,
Objetivos varchar (500) not null,
Logros varchar (500) not null,
Efectos blob not null
);

create table RedComunidadInvestiga_Materias (
Id_RedComunidadInvestiga int (10) not null,
Id_CartacterizacionRed int (10) not null,
Id_Materia int (10) not null
);

create table RedComunidadInvestiga_ProyectoInvestigacion (
Id_RedComunidadInvestiga int (10) not null,
Id_ProyectoInvestigacion int (10) not null
);

create table EntidadAuspiadora (
Id_InstAuspiciadora int (10) not null,
Id_Usuario int (10) not null,
Id_URLnSynMag int (10) not null,
Id_Ubicaicon int (10) not null,
NomInstitucion varchar (255) not null,
ImagenInstitucional blob not null,
RepresentanteLegal varchar (255) not null,
Email varchar (255) not null,
PaginaWeb varchar (255) not null,
CretificadoColciencias blob not null,
TermAlianza varchar (2000) not null
);

create table MonitoRedGruponSegimiento (
Id_RedComunidadInvestiga int (10) not null,
Id_Usuario int (10) not null
);

create table NewMInRedComunidad (
Id_Usuario int (10) not null,
Id_RedGrupoInvestiga int (10) not null,
Afiliacion_FechaInicio date not null,
Afiliacion_FechaFin date not null,
Id_CuentaBancaria int (10) not null,
HorarioDisponible blob not null
);

create table CostoInscripcion (
Id_Costo int (10) not null,
NomServicio varchar (50) not null,
CostoAño varchar (10) not null,
CodAfiliadoVIP int (10) null,
Descuento varchar (10) null,
TotalCosto varchar (10) null
);

create table NewMInRedComunidad_CostoInscripcion (
Id_Usuario int (10) not null,
Id_RedGrupoInvestiga int (10) not null,
Id_Costo int (10) not null
);

create table HabilidadesConocimientos (
Id_Habilidad int (10) not null,
Id_RedGrupoInvestiga int (10) not null,
Id_Usuario int (10) not null,
Habilidad varchar (50) not null,
Certificada bit not null
);

create table Actividad_RedGrupoInvestiga (
Id_Actividad int (10) not null,
Id_URLnSynMag int (10) not null,
Id_RedGrupoInvestiga int (10) not null,
Titulo varchar (50) not null,
Detalles varchar (50) not null,
Fecha_Inicio date not null,
Fecha_Fin date not null,
PiezaPublicitaria blob not null
);

create table TipoActividad (
Id_TipoAct int (10) not null,
Id_Actividad int (10) not null,
Tipo enum ('Evento','Convocatoria') not null
);

create table InscripcionUsuarionActividad (
Id_Usuario int (10) not null,
Id_Actividad int (10) not null
);

create table UbicacionGeoreferenciador_ActividadRedComunidadInvestiga (
Id_Ubicacion int (10) not null,
Id_Actividad int (10) not null
);

create table Actividad_RedGrupoInvestigaPalabrasClave (
Id_Actividad int (10) not null,
Id_PalabraClave int (10) not null
);

create table ProyectoInvestigacion (
Id_ProyectoInvestigacion int (10) not null,
Id_RedGrupoInvestiga int (10) not null,
Id_LineaInvestigacion int (10) not null,
Id_URLnSynMag int (10) not null,
Titulo varchar (255) not null,
Resumen varchar (500) not null,
Fecha_Inicio date not null,
Fecha_Fin date not null
);

create table TipoProyecto (
Id_TipoProy int (10) not null,
Id_ProyectoSM int (10) not null,
Tipo enum ('ProyInvestiga','ProyDesrrllTecnologia','ProyInnova','ProyExtsnRespSocial') not null
);

create table ProyectoInvestigacion_Materia (
Id_Materia int (10) not null,
Id_ProyectoSM int (10) not null
);

create table ProyectoInvestigacion_PalabrasClave (
Id_ProyectoSM int (10) not null,
Id_PalabraClave int (10) not null
);

create table DiarioProyecto (
Id_ObraRecursoDiario int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Contenido blob not null,
BibliotecaMI bit not null
);

create table DiarioProyecto_PalabrasClave (
Id_ProyectoInvestigacion int (10) not null,
Id_PalabraClave int (10) not null,
Id_ObraRecursoDiario int (10) not null
);

create table DiarioProyecto_Autor (
Id_ProyectoInvestigacion int (10) not null,
Id_Autor int (10) not null,
Id_ObraRecursoDiario int (10) not null
);

create table UbicacionGeoreferenciador_ProyectoInvestigacion (
Id_Ubicacion int (10) not null,
Id_ProyectoSM int (10) not null
);

create table SeguimientoProyecto_Usuario (
Id_ProyectoSM int (10) not null,
Id_Usuario int (10) not null
);

create table ProductoEsperado (
Id_ProductoInvest int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Nombre varchar (50) not null,
Descripcion varchar (255) not null,
Evidencia blob not null
);

create table TipoProductoEsperado (
Id_TipoProdEsperado int (10) not null,
Id_ProductoInvest int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Tipo enum ('ProdGeneracionConocimiento','ProdTecnol-Innova','ProdDivulgacion','ProdFormacion') not null
);

create table RepositoriosDocs (
Id_Repositorio int (10) not null,
Nombre varchar (50) not null,
FechaCreacion date not null,
RegistroActividad varchar (255) not null,
Tamaño varchar (50) not null,
Creador varchar (50) not null,
Descripcion varchar (255) not null,
Id_ProyectoSm int (10) not null
);

Create table DocumentosProyecto (
Id_Documento int (10) not null,
Id_Repositorio int (10) not null,
Id_ProyectoSM int (10) not null,
NombreDoc varchar (50) not null,
Tipo enum ('DocumentoLectura','ElementoMultimedia','OVA') not null,
Tipo_Otro varchar (50) not null,
FechaCreacion date not null,
UbicacionRepo varchar (255) not null,
Tamaño varchar (255) not null,
Propietario varchar (50) not null,
Descripcion varchar (255) not null
);

Create table DocumentosProyecto_RegistroActividad (
Id_RegistroAvtividad int (10) not null,
Id_Documento int (10) not null,
Fecha date not null,
Descripcion varchar (255) not null
);
 
create table ActividadesProyecto (
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Actividad varchar (255) not null,
Fecha_Inicio date not null,
Fecha_Fin date not null
);

create table EvidenciaActividad (
Id_Evidencia int (10) not null,
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Titulo varchar (255) not null,
Descripcion varchar (255) not null,
Evidencia blob not null
);

create table TipoEvidenciaActividad (
Id_TipoEvidencia int (10) not null,
Id_Evidencia int (10) not null,
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Tipo enum ('DocumentoLectura','ElementoMultimedia','OVA') not null,
Tipo_Otro varchar (50) not null
);

create table RecursoProyecto (
Id_Recurso int (10) not null,
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Tipo_Otro varchar (50) not null,
NombreRecurso varchar (50) not null
);

create table TipoRecursoProyecto (
Id_TipoRecurso int (10) not null,
Id_Recurso int (10) not null,
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Tipo enum ('FromSynMag','ExternoDigital','ExternoFisico') not null
);

create table ComunicacionProyecto (
Id_Comunicacion int (10) not null,
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Fecha date not null,
Participantes varchar (500) not null,
Descripcion varchar (500) not null
);

create table TipoComunicacionProyecto ( 
Id_TipoComunica int (10) not null,
Id_Comunicacion int (10) not null,
Id_ActividadProy int (10) not null,
Id_ProyectoInvestigacion int (10) not null,
Tipoenum('SincrTextUnoUno','SincrTextGrupo','SincrVideoconf','AsincrPosttUsuario','AsincrPosttGrupo') 
);

create table OfertaFormativa (
Id_Formacion int (10) not null,
Id_Usuario int (10) not null,
Nombre varchar (255) not null,
PalabarClave varchar (255) not null,
Descripcion varchar (255) not null
);

create table OfertaFormativa_Materias (
Id_Formacion int (10) not null,
Id_Materia int (10) not null
);

create table OfertaFormativa_PalabrasClave (
Id_Formacion int (10) not null,
Id_PalabraClave int (10) not null
);

create table Proyecto_OfertaFormativa (
Id_ProyectoSM int (10) not null,
Id_Formacion int (10) not null
);

create table RecursosExternos (
Id_EnlaceExt int (10) not null,
Nombre varchar (100) not null,
URLexterna varchar (255) not null,
Descripcion varchar (255) not null,
AntAuspicia int (255) not null
);

create table Proyecto_RecursosExternos (
Id_EnlaceExt int (10) not null,
Id_ProyectoSM int (10) not null
);

create table AsesoriaPersonalizada (
Id_Asesoria int (10) not null,
FechaSolicitud date not null,
Solicitante varchar (50)  not null,
TemaConsulta varchar (255) not null,
MotivoConsulta varchar (255) not null
);

create table Proyecto_AsesoriaPersonalizada (
Id_Asesoria int (10) not null,
Id_ProyectoSM int (10) not null
);
 
-- ModuloDivulgacion

create table UbicacionGeoreferenciador(
Id_Ubicacion int (10) not null,
Id_URLnSynMag int (10) not null, 
Id_PstGeneral int (10) not null, 
Direccion int (10) not null, 
CodPostal int (10) not null, 
Coordenadas int (10) not null, 
Descripcion varchar (255) not null
); 


create table TipoUbicacion(
Id_TipUbica int (10) not null,
Id_Ubicacion int (10) not null, 
TipoUbica enum ('Maestr@Investigador@', 'UExterno', 'Actividad', 'Proyecto', 'EntidadAuspiciadora', 'RedComunidad', 'OftFormativa') not null
);


create table PostGeneral(
Id_PostGeneral int (10) not null, 
Id_URLnSynMag int (10) not null, 
Id_Postype int (10) not null, 
Evento enum ('Maestr@Investigador@', 'UsuarioExterno', 'RegistroBiblioteca', 'RedComunidadInvestiga', 'EntidadAuspiciadora', 'MInRedComunidad', 'Proyecto', 'Actividad', 'OfertaFormativa') not null,
TotalLikes int (3) not null,
TotalComentarios int (3) not null
); 


create table TipoPost(
Id_Postype int (10) not null,
Postype enum ('Registro', 'Actualizacion') not null
); 


create table Post_newUsuarioExterno(
Id_PostGeneral int (10) not null,
Id_Usuario int (10) not null, 
Id_Ubicacion int (10) not null,
Encabezado char (255) not null, 
TotalnSeguimiento int (3) not null
); 


create table Post_newUsuarioMI(
Id_PostGeneral int (10) not null, 
Id_Usuario int (10) not null, 
Id_Ubicacion int (10) not null, 
Encabezado char (255) not null, 
totalnSeguimiento int (3) not null,
TotalnSeguidores int (3) not null
); 


create table DataActualizadoMI(
Id_ActualizaMI int (10) not null, 
Id_PostGeneral int (10) not null,
DataActualizado enum ('Perfil','Formacion','Laboral','ExpInvestigativa') not null
); 


create table Post_EntidadAuspiciadora(
Id_PostGeneral int (10) not null, 
Id_InstAuspiciadora int (10) not null,
IdUbicacion int (10) not null,
Encabezado char (255) not null
); 


create table Post_RedComunidadInvestiga( 
Id_PostGeneral int (10) not null, 
Id_RedGrupoInvestiga int (10) not null, 
Id_Ubicacion int (10) not null, 
Encabexado char (255) not null, 
TotalIntegrantes int (3) not null, 
Id_RedComunidadInvestiga int (10) not null
); 


create table DataActualizadoRedComunidad(
Id_ActualizaRedComunidad int (10) not null, 
Id_PostGeneral int (10) not null, 
DataActualizado enum ('Basico', 'desceripcion', 'caracterizacion', 'LogrosReconoc', 'LineasInvestiga', 'Metas') not null
); 


create table Post_newMInRedcomund(
Id_PostGeneral int (10) not null, 
Id_Usuario Int (10) not null, 
Id_RedComunidadInvestiga int (10) not null, 
Encabezado char (255) not null,
URL_Usuario varchar (255) not null,
URL_RedComund int (10) not null, 
URL_EntAuspicia varchar (255) not null, 
TotalnIntegrantesRedComund int (3) not null
); 


create table Post_ActividadRedGrupoInvestiga(
Id_PostGeneral int (10) not null, 
Id_actividad int (10) not null, 
Id_Ubicacion int (10) not null, 
TipoActividad enum ('Evento', 'Convocatoria') not null,
Encabezado char (255) not null, 
TotalInscritos int (4) not null
); 


create table Post_newRegistroBilblioteca( 
Id_PostGeneral int (10) not null, 
Id_ObraRecursoDiario int (10) not null,
Encabezado char (255) not null, 
TotalConsultas int (10) not null
); 


create table Post_Proyecto(
Id_PostGeneral int (10) not null, 
Id_ProyectoSM int (10) not null, 
Id_Ubicacion int (10) not null, 
Encabezado char (255) not null, 
UsuariosnSeguiendo int (3) not null
); 


create table DataActualizadoProyecto(
Id_ActualizadoProy int (10) not null,
Id_PostGeneral int (10) not null, 
DataActualizado enum ('GestionProyecto', 'ProductoEsperado', 'DiarioProyecto') not null
); 


create table FuenteRegistro(
Id_fuenteReg int (10) not null, 
Id_PostGeneral int (10) not null, 
Postype enum ('newObra', 'newGuiaRecurso', 'new>DiarioProyecto') not null
); 


create table MonitorComentarios(
Id_Comentario int (10) not null, 
fecha date not null, 
To_About varchar (255),
Comenteario text
); 


create table MontComUsuarioMI(
Id_Comentario int (10) not null, 
Id_Usuario int (10) not null
); 


create table MonComUsaurioExterno(
Id_Comentario int (10) not null, 
Id_Usuario int (10) not null
);

 
create table MonComProyInvestigacion(
Id_Comentario int (10) not null, 
Id_ProyectoSM int (10) not null
); 

 
create table MonComActividadRedComunidadinvestiga(
Id_Comnetario int (10) not null, 
Id_Actividad int (10) not null
); 

 
create table MonComObraRecursoDiarioInv(
Id_Comentario int (10) not null, 
Id_ObraRecursoDiario int (10) not null
); 

 
create table MonComEntAuspicia(
Id_Comentario int (10) not null, 
Id_InsAuspiciadora int (10) not null
); 

 
create table MonComRedComunidadInvestiga(
Id_Comentario int (10) not null, 
Id_RedComunidadInvestiga int (10) not null
); 


create table MonitorLikes (
Id_Like int (10) not null,
Fecha date not null
);


create table MonitorLikes_EntidadAuspiciadora (
IdLike int (10) not null,
Id_Institucion_Auspiciadora int (10) not null
);


create table MonitorLikes_MaestroInvestigador (
IdLike int (10) not null,
IdUsuario int (10) not null
);


create table MonitorLikes_AvtividadRedComunidadInvestiga (
Id_Like int (10) not null,
Id_Actividad int (10) not null
);


create table MonitorLikes_ProyectoInvestigacion (
Id_Like int (10) not null,
Id_ProyectoSM int (10)
);


create table MonitorLikes_RedComunidadRedInvestiga (
Id_like int (12) not null,
Id_RedComunidadRedInvestiga int (10)
);


create table MonitorLikes_ObraRecursoDiarioInvestigacion (
Id_ObraRecursoDiario int (10) not null,
Id_Like int (10) not null
);


create table MonitorLikes_UsuarioExterno (
Id_Like int (10) not null,
Id_Usuario int (10) not null
);


-- ModuloBiblioteca


create table ObraRecursoDiario (
Id_ObraRecursoDiario int (10) not null,
Id_URLSynMag int (10) not null,
Titulo varchar (255) not null,
Fecha date not null,
Resumen varchar (500) not null,
Evidencia blob null
);


create table TipoObraRecursoDiario (
Id_TipoObraRecursoDiario int (10) not null,
Id_ObraRecursoDiario int (10) not null,
Tipo_DocumentoLectura bit not null,
Tipo_ElementoMultimedia bit not null,
Tipo_OVA bit not null,
Tipo_Otro bit not null
);


create table Autor (
Id_Autor varchar (50) not null,
Id_ObraRecursoDiario int (10) not null,
PrimerApellido varchar (255) not null,
SegundoApellido varchar (255) null,
PrimerNombre varchar (255) not null,
SegundoNombre varchar (255) null,
Profesion varchar (50) null
);


create table EditorialAuspiciador (
Id_EditAuspiciador int (10) not null,
Id_ObraRecursoDiario int (10) not null,
NombreEditorialAusoiciadro varchar (255) not null
);


create table PalabrasClave (
Id_PalabraClave int  not null,
Id_ObraRecursoDiario int (10) not null,
NombrePalabraClave varchar (50)  not null
);


create table Materias (
Id_Materia int (10) not null,
Id_ObraRecursoDiario int (10) not null,
NombreMaterri varchar (50) not null
);


create table MonitorConsultaObra (
Id_ObraRecursoDiario int (10) not null,
Id_Usuario int (10),
Fecha date not null
);


create table MonitorObraCompilada (
Id_ObraRecursoDiario int (10) not null,
Id_Usuario int (10),
Fecha date not null
);


create table MonitorObraDescarga (
Id_ObraRecursoDiario int (10) not null,
Id_Usuario int (10),
Fecha date not null
);