use Datasafety;

insert	into	TipoUsuario	
(IdTipoUsuario,NombreTipoUsuario)
values (1,'Aprendiz');

insert	into	TipoUsuario	
(IdTipoUsuario,NombreTipoUsuario)
values (2,'Administrativos'),
(3,'Visitantes');

insert	into TipoDocumento
(IdTipoDocumento,NombreTipoDocumento)
values (1,'Cedula de ciudadania'),
(2,'Cedula de extranjeria'),
(3,'tarjeta de identidad'),
(4,'Pasaporte'),
(5,'nit'),
(6,'otros');

insert	into	Usuarios	
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (1,80762294,'Carlos','Andres','Diaz','Valderrama','cadiaz49@misena.edu.co',TRUE,'01/01/18','01/01/20',1,2);

insert	into	Usuarios	
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (2,1018422959,'Carlos','Yesid','Triana','Sarmiento','cytriana9@misena.edu.co',TRUE,'01/01/18','01/01/20',3,2);

insert	into	Usuarios	
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values(3,80218987,'Johan','Efren','Morales','Obando','jemorales76@misena.edu.co',TRUE,'01/01/18','01/01/20',3,2);

insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (4,654132132,'David','Mauricio','Niño','Rincon','David@misena.edu.co',FALSE,'01/01/18','01/01/20',2,3);

insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (5,51561465,'Hector','Arturo','Lopez','Guzman','Hector@misena.edu.co',FALSE,'01/01/18','01/01/19',3,2);

insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (6,4651565,'Gonzalo','Ladino','Jaimes','Guzman','Jaimes@misena.edu.co',TRUE,'01/01/18','1/01/19',3,2);

insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (7,56846468,'Fabian','David','Petro','Duque','Fabian5@misena.edu.co',FALSE,'01/01/19','01/01/21',3,2);


insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (8,3453453,'Felipe','Andres','Vargas','Valbuena','Felipe1@misena.edu.co',TRUE,'01/01/19','20/01/19',2,3);

insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (9,541651897,'Leidy','Marcela','Santos','Uribe','Leidym@misena.edu.co',FALSE,'01/01/00','01/01/19',1,3);

insert into Usuarios
(IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Estado,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario)
values (10,6545698,'Paula','Andrea','Benitez','Mesa','Paula6@misena.edu.co',FALSE,'01/01/17','01/01/19',1,3);


insert	into	MarcaEquipo	
(IdMarcaEquipo,NombreMarcaEquipo)
values (1,'LENOVO'), (2,'ACER'), (3,'HP'), (4,'SAMSUNG'), (5,'ASUS'), (6,'OTRO');

insert	into	TipoEquipo	
(IdTipoEquipo,NombreTipoEquipo,Observacion)
values (1,'PORTATIL','NO'), (2,'TABLET','NO APLICA'), (3,'VIDEO BEAM','NO'),(4,'VIDEO BEAM','N/A');

insert into Equipo
(IdEqui,SerialEqui,ModeloEqui,SerialCargadorEqui,Estado,Observacion,Usuario_Equipo,MarcaEquipo_Equipo,TipoEquipo_Equipo)

values (1,'3t23k','T420','3t23kT420',TRUE,'CARGADOR',1,1,1);

insert into Equipo
(IdEqui,SerialEqui,ModeloEqui,SerialCargadorEqui,Estado,Observacion,Usuario_Equipo,MarcaEquipo_Equipo,TipoEquipo_Equipo)
values (2,'3584t','XM4568','3548dff1',FALSE,'MOUSE',2,2,3);


insert into Equipo
(IdEqui,SerialEqui,ModeloEqui,SerialCargadorEqui,Estado,Observacion,Usuario_Equipo,MarcaEquipo_Equipo,TipoEquipo_Equipo)
values (3,'354545TG','SD222533','11456YRTD',TRUE,'CARGADOR/MOUSE',3,1,4);


insert into Equipo
(IdEqui,SerialEqui,ModeloEqui,SerialCargadorEqui,Estado,Observacion,Usuario_Equipo,MarcaEquipo_Equipo,TipoEquipo_Equipo)
values (4,'36446JHKL','GH6543126','645645YDV',TRUE,'NO APLICA',2,4,3);

insert into Equipo
(IdEqui,SerialEqui,ModeloEqui,SerialCargadorEqui,Estado,Observacion,Usuario_Equipo,MarcaEquipo_Equipo,TipoEquipo_Equipo)
values (5,'DFGGF64546L','GGHJ231465','3135FDDS15',FALSE,'NO APLICA',3,2,1);

insert into Movimiento
(IdMovimiento,FechaEntradaMovimiento,FechaSalidaMovimiento,Observacion,Movimiento_Equipo)
values(1,'18/05/18','18/05/18','FALSE',1);