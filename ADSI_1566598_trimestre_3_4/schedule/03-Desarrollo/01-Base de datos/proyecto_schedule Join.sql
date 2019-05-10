
create database proyecto_schedule;
use proyecto_schedule;

create table Lugar_Residencia(
Id_Residencia int not null,
Ciudad_Residencia Varchar (30) not null,
Direccion_Residencia Varchar (50) not null,
primary key (Id_Residencia)
);

/*datos*/
insert into Lugar_Residencia (Id_Residencia, Ciudad_Residencia, Direccion_Residencia)
values (11, 'Bogotá', 'Calle 36H sur · 3-15'),
(21, 'Bogotá', 'Calle 69 BIS A sur · 89A-70'),
(31, 'Bogotá', 'Carrera 13C · 3A-22'),
(41, 'Bogotá', 'Carrera 7 · 71-52'),
(51, 'Bogotá', 'Avenida Calle 26 · 59-51'),
(61, 'Bogotá', 'Carrera 8 # 9-83'),
(71, 'Bogotá', 'Carrera 34 # 28-08'),
(81, 'Bogotá', 'Diagonal 22B Bis · 58-40'),
(91, 'Bogotá', 'Carrera 13C · 3A-22'),
(101, 'Bogotá', 'Carrera 7 · 71-52');

create table Genero(
Id_Genero int not null,
Nombre_Genero Varchar (20) not null,
primary key (Id_Genero)
);

/*Datos*/
insert into Genero (Id_Genero, Nombre_Genero)
values (12, 'Masculino'),
(22, 'Femenino');

create table Tipo_Documento(
Id_Documento int not null,
Nombre_Documento Varchar (60) not null,
primary key (Id_Documento )
);

/*Datos*/
insert into Tipo_Documento (Id_Documento, Nombre_Documento)
values (13, 'Cédula de Ciudadania'),
(23, 'Tarjeta de Identidad'),
(33, 'Cédula de Extranjería'),
(43, 'Pasaporte'),
(53, 'Documento Nacional de identificaciòn'),
(63, 'Numero de Identificaciòn Tributaria');

create table Sede(
Id_Sede int not null,
Nombre_Sede Varchar (50) not null,
Direccion_Sede Varchar (50) not null,
primary key (Id_Sede )
);

/*Datos*/
insert into Sede (Id_Sede, Nombre_Sede,Direccion_Sede)
values (14, 'Sede Colombia','Calle 69 # 20-36'),
(24, 'ServiciosFinancieros','Carrera 13 # 65-10'),
(34, 'Tecnoparque','Calle 54 # 10-39'),
(44, 'La Castellana','Cra. 47 # 91-98'),
(54, 'Ises','Carrera 13 # 58-31'),
(64, 'Centro Metalmecanico','Carrera 30 # 17B-25S'),
(74, 'Restrepo','Calle 22 Sur #212'),
(84, 'Fontibon','Calle 19A #96c40'),
(94, 'Meissen','Carrera 17Bis A #62'),
(104, 'CGMLTI','Calle 52 #13 65');

create table Jornada(
Id_Jornada int not null,
Nombre_Jornada Varchar (20) not null,
primary key (Id_Jornada)
);

/*Datos*/
insert into Jornada (Id_Jornada, Nombre_Jornada)
values (15, 'Diurna'),
(25, 'Nocturna'),
(35, 'Fines de Semana'),
(45, 'Madrugada');

create table Especialidad(
Id_Especialidad int not null,
Nombre_Especialidad Varchar (40) not null,
primary key (Id_Especialidad)
);

/*Datos*/
insert into Especialidad (Id_Especialidad, Nombre_Especialidad)
values (16, 'Teleinformática'),
(26, 'Electronica'),
(36, 'Telecomunicaciones'),
(46, 'Electricidad');

create table Tipo_Vinculacion(
Id_Vinculacion int not null,
Nombre_Vinculacion Varchar (20) not null,
Horas_Dedicadas varchar (10) not null,
primary key (Id_Vinculacion)
);

/*Datos*/
insert into Tipo_Vinculacion (Id_Vinculacion, Nombre_Vinculacion, Horas_Dedicadas)
values (17, 'Tiempo Completo','40 Horas'),
(27, 'Medio Tiempo','20 Horas'),
(37, 'Planta','30 Horas');

create table Trimestre(
Id_Trimestre int not null,
Numero_Trimestre Varchar (20) not null,
Id_Jornada int not null,
primary key (Id_Trimestre),
foreign key (Id_Jornada) references Jornada (Id_Jornada)
);

/*Datos*/
insert into Trimestre (Id_Trimestre, Numero_Trimestre, Id_Jornada)
values (18, 'Primer Trimestre',15),
(28, 'Segundo Trimestre',25),
(38, 'Tercer Trimestre',35),
(48, 'Cuarto Trimestre',45),
(58, 'Quinto Trimestre',15),
(68, 'Sexto Trimestre',25),
(78, 'Septimo Trimestre',35),
(88, 'Octavo Trimestre',45);

create table Horario(
Id_Horario int not null,
Dias_Horario varchar (30) not null,
Horainicio_Horario Time not null,
HoraFinal_Horario Time not null
);


alter table Horario add primary key (Id_Horario);

/*Datos*/

insert into Horario (Id_Horario, Dias_Horario, Horainicio_Horario, HoraFinal_Horario)
values (19, 'Lunes a Viernes','6:00','18:00'),
(29, 'Lunes a Viernes','18:00','22:00'),
(39, 'Sabado y Domingo','7:00','17:00'),
(49, 'Lunes a Viernes','22:00','06:00'),
(59, 'Lunes a Viernes','06:00','18:00'),
(69, 'Lunes a Viernes','18:00','22:00'),
(79, 'Sabado y Domingo','7:00','17:00'),
(89, 'Lunes a Viernes','22:00','06:00'),
(99, 'Lunes a Viernes','6:00','18:00'),
(109, 'Lunes a Viernes','18:00','22:00');

create table Usuario(
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
Primer_Nombre_Usuario Varchar (20) not null,
Segundo_Nombre_Usuario Varchar (20) not null,
Primer_Apellido_Usuario Varchar (20) not null,
Segundo_Apellido_Usuario Varchar (20) not null,
Correo_Electronico_Usuario Varchar (50) not null,
Contraseña_Usuario Varchar (12) not null,
Fecha_Nacimiento_Usuario date not null,
Id_Residencia int not null,
Id_Genero int not null
);

alter table Usuario add foreign key (Id_Residencia)
references Lugar_Residencia (Id_Residencia);

alter table Usuario add foreign key (Id_Genero)
references Genero (Id_Genero);

alter table Usuario add constraint fk_Tipo_Documento_Id_Documento
foreign key (Id_Documento) references Tipo_Documento (Id_Documento);

alter table Usuario add primary key (Documento_Usuario, Id_Documento);


/*Datos*/
insert into Usuario
(Id_Documento, Documento_Usuario, Primer_Nombre_Usuario, Segundo_Nombre_Usuario, Primer_Apellido_Usuario, 
Segundo_Apellido_Usuario, Correo_Electronico_Usuario, Contraseña_Usuario, Fecha_Nacimiento_Usuario, 
Id_Residencia, Id_Genero)
values 
(13, 46986265,'Juan','Camilo','Gonzalez','Avila','juan@misena.edu.co','juan123','1993-01-28',101,12),
(13, 1025468961,'David','Alberto','Franco','Lozano','david@misena.edu.co','david123','1995-01-28', 11, 12),

(13, 45986265, 'Fredy','Alonso','Ruiz','Molano','fruiz@misena.edu.co','fredy123','1991-01-28', 21, 12),
(13, 1265894561, 'Claudia','','Ceccotti','De carmo','claudia@misena.edu.co','claudia123','1989-02-18', 31, 22),
(13, 52689246, 'Andres','Camilo','Penagos','Chavez','andres@misena.edu.co','andres123','1990-03-15', 41, 12),
(13, 79684659, 'Nelly','Johanna','Niño','Piñeros','nelly@misena.edu.co','nelly123','1988-04-24', 51, 22),

(63, 8305095269,'Corporacion','Uniandina','','','cuniandina@cuniandina.edu.co','andina123','1975-09-28',61, 12),
(13, 52551763,'Daniela','','Lopez','Martinez','damielalm@hotmail.com','daniela123','1990-03-27',61, 22),
(13, 93138497,'Oscar','Leonardo','Orjuela','Silva','oleonardo@gmail.com','oscar123','1985-05-20',71, 12),
(23, 01121789563,'Laura','Camila','Vela','Clavijo', 'lcamilavela@outlook.com','laura123','2001-12-17',81, 22),
(23, 20042087954,'Johan','Esteban','Romero','Vela','johan@misena.edu.co', 'johan123','2002-07-20',91, 12);


create table Ambiente(
Id_Ambiente int not null,
Capacidad_Ambiente int not null,
Id_Sede int not null
);

alter table Ambiente add constraint fk_Sede_Id_Sede
foreign key (Id_Sede) references Sede (Id_Sede);

alter table Ambiente add primary key (Id_Ambiente, Id_Sede);

/*Datos*/
insert into Ambiente
(Id_Ambiente,Capacidad_Ambiente,Id_Sede)	
values (1011 , 30, 14),
(1021 , 20, 24),
(1031 , 15, 34),
(1041 , 30, 44),
(1051 , 35, 54),
(1061 , 20, 64),
(1071 , 15, 74),
(1081 , 30, 84),
(1091 , 35, 94);

create table Administrador(
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
Cargo_Administrador varchar (50) not null
);

alter table Administrador add constraint fk_Usuario_Documento_Usuario
foreign key (Documento_Usuario, Id_Documento) references Usuario (Documento_Usuario, Id_Documento);

alter table Administrador add primary key (Documento_Usuario, Id_Documento);

/*Datos*/
insert into Administrador
(Id_Documento,Documento_Usuario,Cargo_Administrador)	
values (13, 46986265, 'Ingeniero de Sistemas'),
(13, 1025468961, 'Ingeniero de Sistemas');

create table Instructor(
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
Profesion_Instructor varchar (50) not null,
Id_Vinculacion int not null,
Id_Especialidad int not null
);

alter table Instructor add foreign key (Id_Vinculacion)
references Tipo_Vinculacion (Id_Vinculacion);

alter table Instructor add foreign key (Id_Especialidad)
references Especialidad (Id_Especialidad);

alter table Instructor add constraint fk_Usuario_Documento_Usuario_
foreign key (Documento_Usuario, Id_Documento) references Usuario (Documento_Usuario, Id_Documento);

alter table Instructor add primary key (Documento_Usuario, Id_Documento);

/*Datos*/
insert into Instructor
(Id_Documento, Documento_Usuario, Profesion_Instructor, Id_Vinculacion, Id_Especialidad)	
values (13 , 45986265, 'Ingeniero de Sistemas', 17, 16),
(13 , 1265894561, 'Ingeniero de Electrónico', 27, 26),
(13 , 52689246, 'Ingeniero de Telecomunicaciones', 37, 36),
(13 , 79684659, 'Ingeniero de Electricidad', 17, 46);

create table Ficha(
Id_Ficha int not null,
Programa_Formacion varchar (255) not null,
Id_Ambiente int not null,
Id_Trimestre int not null,
Id_Jornada int not null,
Id_Sede int not null,
Id_Horario int not null
);

alter table Ficha add foreign key (Id_Trimestre)
references Trimestre (Id_Trimestre);

alter table Ficha add constraint fk_Ambiente_Id_Ambiente
foreign key (Id_Ambiente, Id_Sede) references Ambiente (Id_Ambiente, Id_Sede);

alter table Ficha add constraint fk_Horario_Id_Horario
foreign key (Id_Horario) references Horario (Id_Horario);      

alter table Ficha add primary key (Id_Ambiente, Id_Ficha, Id_Sede, Id_Horario);

/*Datos*/
insert into Ficha
(Id_Ficha, Programa_Formacion, Id_Ambiente, Id_Trimestre, Id_Jornada, Id_Sede, Id_Horario)	
values (1566597, 'Analisis y Desarrollo de Sistemas de Informacion', 1011, 18, 15, 14, 19),
(1566598, 'Analisis y Desarrollo de Sistemas de Informacion', 1021, 28, 25, 24, 29),
(1566599, 'Tecnio profesional de esitemas de informacion', 1031, 28, 25, 34, 39),
(1566600, 'Gestión redes de datos', 1041, 38, 35, 44, 49),
(1566601, 'Soporte y gestion de servicios para telecomunicaciones', 1051, 48, 45, 54, 59),
(1566602, 'Instalacion de redes internas para telecomunicaciones', 1061, 58, 15, 64, 69),
(1566603, 'Mantenimiento de equipo biomedico', 1071, 68, 25, 74, 79),
(1566604, 'Mantenimiento biomedico e instrumental industrial', 1081, 78, 35, 84, 89),
(1566605, 'Supervision de redes de distribucion de energia electrica', 1091, 88, 45, 94, 99),
(1566606, 'Electricidad industrial', 1011, 88, 45, 14, 109);

create table Ficha_Instructor (
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
Id_Ficha int not null,
Id_Sede int not null,
Id_Ambiente int not null,
Id_Horario int not null
);

alter table Ficha_Instructor add constraint fk_Id_Ficha
foreign key (Id_Ambiente, Id_Ficha, Id_Sede) references Ficha (Id_Ambiente, Id_Ficha, Id_Sede);

alter table Ficha_Instructor add constraint fk_Instructor_Documento_Usuario___
foreign key (Documento_Usuario, Id_Documento) references Instructor (Documento_Usuario, Id_Documento);

alter table Ficha_Instructor add constraint fk_Horario_Id_Horario_
foreign key (Id_Horario) references Horario (Id_Horario); 

alter table Ficha_Instructor add primary key (Id_Ficha, Documento_Usuario, Id_Documento, Id_Ambiente, Id_Sede, Id_Horario);

/*Datos*/
insert into Ficha_Instructor
(Id_Documento, Documento_Usuario, Id_Ficha, Id_Sede, Id_Ambiente, Id_Horario)	
values (13, 45986265, 1566597, 14, 1011, 19),
(13, 1265894561, 1566598, 24, 1021, 29),
(13, 52689246, 1566599, 34, 1031, 39),
(13, 79684659, 1566600, 44, 1041, 49);

create table Aprendiz(
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
EstratoSocial_Aprendiz int not null,
Id_Ficha int not null,
Id_Sede int not null,
Id_Ambiente int not null,
Id_Horario int not null
);

alter table Aprendiz add constraint fk_Ficha_Id_Ficha_
foreign key (Id_Ambiente, Id_Ficha, Id_Sede, Id_Horario) references Ficha (Id_Ambiente, Id_Ficha, Id_Sede, Id_Horario);

alter table Aprendiz add constraint fk_Usuario_Documento_Usuario__
foreign key (Documento_Usuario, Id_Documento) references Usuario (Documento_Usuario, Id_Documento);

alter table Aprendiz add primary key (Id_Ficha, Documento_Usuario, Id_Documento, Id_Ambiente, Id_Sede, Id_Horario);

/*Datos*/
insert into Aprendiz
(Id_Documento, Documento_Usuario, EstratoSocial_Aprendiz, Id_Ficha, Id_Sede, Id_Ambiente, Id_Horario)	
values (63, 8305095269, 6, 1566602, 64, 1061, 69),
(13, 52551763, 3, 1566599, 34, 1031, 39),
(13, 93138497, 2, 1566601, 54, 1051, 59),
(23, 01121789563, 3, 1566600, 44, 1041, 49),
(23, 20042087954, 2, 1566601, 54, 1051, 59);

create table Login(
Id_Login int not null,
Usuario_Login varchar (10)  not null,
Contraseña varchar (10) not null
);

create table Error_Login(
Id_Error int not null,
Codigo_Error varchar (255)  not null,
Fecha_Error date not null,
Hora_Error time not null
);

create table Servidor_Correo(
Id_Servidor_Correo int not null,
Verificacion_Cuenta varchar (255)  not null,
Recuperacion_Cuenta varchar (255)  not null,
Actualizacion_Cuenta varchar (255)  not null
);

/*consultas*/
select * from Usuario;

DELETE FROM Sede WHERE Id_Sede = 44;

/*JOIN*/


/*USUARIO-ADMIN*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Cargo_Administrador
from Administrador
join Usuario
on Usuario.Documento_Usuario = Administrador.Documento_Usuario;

/*USUARIO-INSTRUCTOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Profesion_Instructor
from Instructor
join Usuario
on Usuario.Documento_Usuario = Instructor.Documento_Usuario;

/*USUARIO-APRENDIZ*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, EstratoSocial_Aprendiz
from Aprendiz
join Usuario
on Usuario.Documento_Usuario = Aprendiz.Documento_Usuario;

/*USUARIO-RESIDENCIA*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Ciudad_Residencia, Direccion_Residencia
from Usuario
join Lugar_Residencia	
on Usuario.Id_Residencia = Lugar_Residencia.Id_Residencia;

/*RESIDENCIA-USUARIO-ADMNISTRADOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Ciudad_Residencia, Direccion_Residencia, Cargo_Administrador
from Lugar_Residencia
join Usuario
inner join Administrador
on  Usuario.Documento_Usuario = Administrador.Documento_Usuario
on Lugar_Residencia.Id_Residencia = Usuario.Id_Residencia;

/*RESIDENCIA-USUARIO-INSTRUCTOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Ciudad_Residencia, Direccion_Residencia, Profesion_Instructor
from Lugar_Residencia
join Usuario
inner join Instructor
on  Usuario.Documento_Usuario = Instructor.Documento_Usuario
on Lugar_Residencia.Id_Residencia = Usuario.Id_Residencia;

/*RESIDENCIA-USUARIO-APRENDIZ*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Ciudad_Residencia, Direccion_Residencia, EstratoSocial_Aprendiz
from Lugar_Residencia
join Usuario
inner join Aprendiz
on  Usuario.Documento_Usuario = Aprendiz.Documento_Usuario
on Lugar_Residencia.Id_Residencia = Usuario.Id_Residencia;

/*APRENDIZ-FICHA-HORARIO*/
select Documento_Usuario, Programa_Formacion, Dias_Horario, Horainicio_Horario, HoraFinal_Horario
from Aprendiz
join Ficha
inner join horario	
on Ficha.Id_Horario = Horario.Id_Horario
on Aprendiz.Id_Horario = Ficha.Id_Horario;

/*HORARIO-FICHA_INSTRUCTOR*/
select Documento_Usuario, Dias_Horario, Horainicio_Horario, HoraFinal_Horario
from Ficha_Instructor
inner join horario	
on Ficha_Instructor.Id_Horario = Horario.Id_Horario;

/*VINCULACION-INSTRUCTOR*/
select Documento_Usuario, Profesion_Instructor, Nombre_Vinculacion
from Instructor
join tipo_vinculacion	
on Instructor.Id_Vinculacion = tipo_vinculacion.Id_Vinculacion;

/*ESPECIALIDAD-INSTRUCTOR*/
select Documento_Usuario, Profesion_Instructor, Nombre_Especialidad
from Instructor
join Especialidad	
on Instructor.Id_Especialidad = Especialidad.Id_Especialidad;

/*GENERO-USUARIO*/
select Documento_Usuario, Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero
from Usuario
join Genero	
on Usuario.Id_Genero = Genero.Id_Genero;

/*GENERO-USUARIO-ADMINISTRADOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero
from Genero
join Usuario
inner join Administrador
on Usuario.Documento_Usuario = Administrador.Documento_Usuario
on Genero.Id_Genero = Usuario.Id_Genero;

/*GENERO-INSTRUCTOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero
from Genero
join Usuario
inner join Instructor
on Usuario.Documento_Usuario = Instructor.Documento_Usuario
on Genero.Id_Genero = Usuario.Id_Genero;

/*GENERO-APRENDIZ*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero
from Genero
join Usuario
inner join Aprendiz
on Usuario.Documento_Usuario = Aprendiz.Documento_Usuario
on Genero.Id_Genero = Usuario.Id_Genero;

/*GENERO-USUARIO-APRENDIZ*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero, EstratoSocial_Aprendiz
from Genero
join Usuario
inner join Aprendiz
on Usuario.Documento_Usuario = aprendiz.Documento_Usuario  
on Genero.Id_Genero = Usuario.Id_Genero;

/*GENERO-USUARIO-ADMINISTRADOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero, Cargo_Administrador
from Genero
join Usuario
inner join Administrador
on Usuario.Documento_Usuario = Administrador.Documento_Usuario  
on Genero.Id_Genero = Usuario.Id_Genero;

/*GENERO-USUARIO-INSTRUCTOR*/
select Primer_Nombre_Usuario, Primer_Apellido_Usuario, Nombre_Genero, Profesion_Instructor
from Genero
join Usuario
inner join Instructor
on Usuario.Documento_Usuario = Instructor.Documento_Usuario  
on Genero.Id_Genero = Usuario.Id_Genero;

/*TIPO_DOCUMENTO-USUARIO-APRENDIZ*/
select Nombre_Documento,Primer_Nombre_Usuario, Primer_Apellido_Usuario, EstratoSocial_Aprendiz    
from Tipo_Documento
join Usuario
inner join Aprendiz
on Usuario.Documento_Usuario = Aprendiz.Documento_Usuario   
on Tipo_Documento.Id_Documento = Usuario.Id_Documento;

/*TIPO_DOCUMENTO-USUARIO-INSTRUCTOR*/
select Nombre_Documento,Primer_Nombre_Usuario, Primer_Apellido_Usuario, Profesion_Instructor    
from Tipo_Documento
join Usuario
inner join Instructor
on Usuario.Documento_Usuario = Instructor.Documento_Usuario   
on Tipo_Documento.Id_Documento = Usuario.Id_Documento;

/*TIPO_DOCUMENTO-USUARIO-ADMINISTRADOR*/
select Nombre_Documento,Primer_Nombre_Usuario, Primer_Apellido_Usuario, Cargo_Administrador    
from Tipo_Documento
join Usuario
inner join Administrador
on Usuario.Documento_Usuario = Administrador.Documento_Usuario   
on Tipo_Documento.Id_Documento = Usuario.Id_Documento;

/*HORARIO-FICHA_INSTRUCTOR-INSTRUCTOR*/

select Id_Ficha, Id_Sede, Dias_Horario, Horainicio_Horario, HoraFinal_Horario
from Horario
join ficha_Instructor
inner join Instructor
on ficha_Instructor.Documento_Usuario = Instructor.Documento_Usuario
on Horario.Id_Horario = ficha_Instructor.Id_Horario;

/*SEDE-AMBIENTE-FICHA*/

select Nombre_Sede,Direccion_Sede, Capacidad_Ambiente, Programa_Formacion, Id_Trimestre, Id_Jornada, Id_Horario, Id_Ficha
from Sede
join Ambiente
inner join Ficha
on Ambiente.Id_Ambiente = Ficha.Id_Ambiente
on Sede.Id_Sede = Ambiente.Id_Sede;

/*JORNADA-TRIMESTRE-FICHA*/

Select Nombre_Jornada, Numero_Trimestre, Programa_Formacion, Id_Ambiente, Id_Sede, Id_Horario, Id_Ficha
from Jornada
join Trimestre
inner join Ficha
on Trimestre.Id_Trimestre = Ficha.Id_Trimestre
on Jornada.Id_Jornada = Trimestre.Id_Jornada;

/*USUARIO-TIPO_DOCUMENTO*/

Select * 
from Usuario
join Tipo_Documento
on Tipo_Documento.Id_Documento = Usuario.Id_Documento;

/*AMBIENTE-FICHA-APRENDIZ*/

Select Capacidad_Ambiente, Programa_Formacion, Id_Trimestre, Id_Jornada,  Id_Documento, Documento_Usuario, EstratoSocial_Aprendiz
from Ambiente
join Ficha
inner join Aprendiz
on Ficha.Id_Ficha = Aprendiz.Id_Ficha
on Ambiente.Id_Ambiente = Ficha.Id_Ambiente;

/*TRIMESTRE-FICHA-APRENDIZ*/

Select Numero_Trimestre, Programa_Formacion, Id_Documento, Documento_Usuario, EstratoSocial_Aprendiz
from Trimestre
join Ficha
inner join Aprendiz
on Ficha.Id_Ficha = Aprendiz.Id_Ficha
on Trimestre.Id_Trimestre = Ficha.Id_Trimestre;

/*TRIMESTRE-JORNADA*/

Select * 
from Trimestre
join Jornada
on Jornada.Id_Jornada = Trimestre.Id_Jornada;

