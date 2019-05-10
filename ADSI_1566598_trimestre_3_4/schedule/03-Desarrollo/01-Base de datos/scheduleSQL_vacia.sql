create database schedulesql;
use schedulesql;

create table Lugar_Residencia(
Id_Residencia int not null,
Ciudad_Residencia Varchar (30) not null,
Direccion_Residencia Varchar (50) not null,
primary key (Id_Residencia)
);


create table Genero(
Id_Genero int not null,
Nombre_Genero Varchar (20) not null,
primary key (Id_Genero)
);


create table Tipo_Documento(
Id_Documento int not null,
Nombre_Documento Varchar (60) not null,
primary key (Id_Documento )
);


create table Sede(
Id_Sede int not null,
Nombre_Sede Varchar (50) not null,
Direccion_Sede Varchar (50) not null,
primary key (Id_Sede )
);


create table Jornada(
Id_Jornada int not null,
Nombre_Jornada Varchar (20) not null,
primary key (Id_Jornada)
);


create table Especialidad(
Id_Especialidad int not null,
Nombre_Especialidad Varchar (40) not null,
primary key (Id_Especialidad)
);


create table Tipo_Vinculacion(
Id_Vinculacion int not null,
Nombre_Vinculacion Varchar (20) not null,
Horas_Dedicadas varchar (10) not null,
primary key (Id_Vinculacion)
);


create table Trimestre(
Id_Trimestre int not null,
Numero_Trimestre Varchar (20) not null,
Id_Jornada int not null,
primary key (Id_Trimestre),
foreign key (Id_Jornada) references Jornada (Id_Jornada)
);


create table Horario(
Id_Horario int not null,
Dias_Horario varchar (30) not null,
Horainicio_Horario Time not null,
HoraFinal_Horario Time not null,
Id_Trimestre int not null
);

alter table Horario add constraint fk_Trimestre_Id_Trimestre 
foreign key (Id_Trimestre) references Trimestre (Id_Trimestre);

alter table Horario add primary key (Id_Horario, Id_Trimestre);



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


create table Ambiente(
Id_Ambiente int not null,
Capacidad_Ambiente int not null,
Id_Sede int not null
);

alter table Ambiente add constraint fk_Sede_Id_Sede
foreign key (Id_Sede) references Sede (Id_Sede);

alter table Ambiente add primary key (Id_Ambiente, Id_Sede);


create table Administrador(
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
Cargo_Administrador varchar (50) not null
);

alter table Administrador add constraint fk_Usuario_Documento_Usuario
foreign key (Documento_Usuario, Id_Documento) references Usuario (Documento_Usuario, Id_Documento);

alter table Administrador add primary key (Documento_Usuario, Id_Documento);


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


create table Ficha(
Id_Ficha int not null,
Programa_Formacion varchar (255) not null,
Id_Ambiente int not null,
Id_Trimestre int not null,
Id_Jornada int not null,
Id_Sede int not null
);

alter table Ficha add foreign key (Id_Trimestre)
references Trimestre (Id_Trimestre);

alter table Ficha add constraint fk_Ambiente_Id_Ambiente
foreign key (Id_Ambiente, Id_Sede) references Ambiente (Id_Ambiente, Id_Sede);

alter table Ficha add primary key (Id_Ambiente, Id_Ficha, Id_Sede);


create table Ficha_Instructor (
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
Id_Ficha int not null,
Id_Sede int not null,
Id_Ambiente int not null
);

alter table Ficha_Instructor add constraint fk_Id_Ficha
foreign key (Id_Ambiente, Id_Ficha, Id_Sede) references Ficha (Id_Ambiente, Id_Ficha, Id_Sede);

alter table Ficha_Instructor add constraint fk_Instructor_Documento_Usuario___
foreign key (Documento_Usuario, Id_Documento) references Instructor (Documento_Usuario, Id_Documento);

alter table Ficha_Instructor add primary key (Id_Ficha, Documento_Usuario, Id_Documento, Id_Ambiente, Id_Sede);


create table Aprendiz(
Id_Documento int not null,
Documento_Usuario BIGINT Unique not null,
EstratoSocial_Aprendiz int not null,
Id_Ficha int not null,
Id_Sede int not null,
Id_Ambiente int not null
);

alter table Aprendiz add constraint fk_Ficha_Id_Ficha_
foreign key (Id_Ambiente, Id_Ficha, Id_Sede) references Ficha (Id_Ambiente, Id_Ficha, Id_Sede);

alter table Aprendiz add constraint fk_Usuario_Documento_Usuario__
foreign key (Documento_Usuario, Id_Documento) references Usuario (Documento_Usuario, Id_Documento);

alter table Aprendiz add primary key (Id_Ficha, Documento_Usuario, Id_Documento, Id_Ambiente, Id_Sede);


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

/*consultas
select * from usuario;

DELETE FROM Sede WHERE Id_Sede = 44;*/