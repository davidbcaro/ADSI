CREATE database motobike_parking;
USE motobike_parking;



CREATE TABLE ciudad (
  ID_ciudad INT(15) NOT NULL,
  Nombre_ciudad VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (ID_ciudad));


CREATE TABLE cupo (
  Id_Cupo char(3) NOT NULL,
  Numero_cupo INT(3) NOT NULL,
  Estado_cupo enum('Disponible', 'Ocupado'),
  PRIMARY KEY (Id_Cupo));


CREATE TABLE  marca (
  Id_Marca INT(10) NOT NULL,
  Nombre_marca VARCHAR(20) NOT NULL,
  Modelo_vehiculo VARCHAR(20) NOT NULL,
  PRIMARY KEY (Id_Marca));



CREATE TABLE sede(
  Id_Sede INT(10) NOT NULL,
  Nombre_Sede VARCHAR(100) NOT NULL,
  Direccion_Sede VARCHAR(100) NOT NULL,
  Telefono INT(12) NOT NULL,
  ciudad_ID_ciudad INT(15) NOT NULL,
  PRIMARY KEY (Id_Sede,ciudad_ID_ciudad),
  UNIQUE INDEX Direccion_Sede (Direccion_Sede ASC),
  INDEX fk_sede_ciudad1_idx (ciudad_ID_ciudad ASC),
  CONSTRAINT fk_sede_ciudad1
    FOREIGN KEY (ciudad_ID_ciudad)
    REFERENCES ciudad (ID_ciudad)
    );
    
    
    
  CREATE TABLE tipo_documento (
  Id_TipoDoc INT(10) NOT NULL,
  TipoDocumento VARCHAR(20) NOT NULL,
  PRIMARY KEY (Id_TipoDoc));


CREATE TABLE  rol_usuario (
  Id_Rol INT(1) NOT NULL,
  TipoRol enum('Administrador','Aprendiz','Guarda Seguridad'),
  PRIMARY KEY (Id_Rol));



  CREATE TABLE usuario (
    Id_Usuario VARCHAR(20) NOT NULL,
    Primer_Nombre VARCHAR(20) NOT NULL,
    Segundo_Nombre VARCHAR(20) NULL DEFAULT NULL,
    Primer_Apellido VARCHAR(20) NOT NULL,
    Segundo_Apellido VARCHAR(20) NULL DEFAULT NULL,
    Email VARCHAR(100) NULL DEFAULT NULL,
    Telefono INT(12) NOT NULL,
    Direccion VARCHAR(50) NOT NULL,
    Contraseña VARCHAR(25) NOT NULL,
    Huella BLOB NULL DEFAULT NULL,
    Foto BLOB NULL DEFAULT NULL,
    Documentos BLOB NULL DEFAULT NULL,
    sede_Id_Sede INT(10) NOT NULL,
    sede_ciudad_ID_ciudad1 INT(15) NOT NULL,
    tipo_documento_Id_TipoDoc INT(10) NOT NULL,
    rol_usuario_Id_Rol INT(10) NOT NULL,
    cupo_Id_Cupo CHAR(3) NOT NULL,
    PRIMARY KEY (Id_Usuario , tipo_documento_Id_TipoDoc),
    UNIQUE INDEX Email (Email ASC),
    INDEX fk_usuario_tipo_documento1_idx (tipo_documento_Id_TipoDoc ASC),
    INDEX fk_usuario_rol_usuario1_idx (rol_usuario_Id_Rol ASC),
    INDEX fk_usuario_cupo1_idx (cupo_Id_Cupo ASC),
    INDEX fk_usuario_sede1_idx (sede_Id_Sede ASC , sede_ciudad_ID_ciudad1 ASC),
    CONSTRAINT fk_usuario_cupo1 FOREIGN KEY (cupo_Id_Cupo)
        REFERENCES cupo (Id_Cupo),
    CONSTRAINT fk_usuario_rol_usuario1 FOREIGN KEY (rol_usuario_Id_Rol)
        REFERENCES rol_usuario (Id_Rol),
    CONSTRAINT fk_usuario_tipo_documento1 FOREIGN KEY (tipo_documento_Id_TipoDoc)
        REFERENCES tipo_documento (Id_TipoDoc),
    CONSTRAINT fk_usuario_sede1 FOREIGN KEY (sede_Id_Sede , sede_ciudad_ID_ciudad1)
        REFERENCES sede (Id_Sede , ciudad_ID_ciudad)
);
    
    
    
    
    CREATE TABLE vehiculo (
  Id_Vehiculo INT(10) AUTO_INCREMENT NOT NULL,
  Marco VARCHAR(25) NOT NULL,
  Placa VARCHAR(7) NOT NULL,
  Numero_chasis INT(25) NOT NULL,
  usuario_Id_Usuario VARCHAR(20) NOT NULL,
  sede_Id_Sede INT(10) NOT NULL,
  marca_Id_Marca INT(10) NOT NULL,
  UNIQUE INDEX Placa (Placa ASC),
  UNIQUE INDEX Numero_chasis (Numero_chasis ASC),
  PRIMARY KEY (Id_Vehiculo, usuario_Id_Usuario, sede_Id_Sede, marca_Id_Marca),
  INDEX fk_vehiculo_usuario_idx (usuario_Id_Usuario ASC),
  INDEX fk_vehiculo_sede1_idx (sede_Id_Sede ASC),
  INDEX fk_vehiculo_marca1_idx (marca_Id_Marca ASC),
  CONSTRAINT fk_vehiculo_usuario
    FOREIGN KEY (usuario_Id_Usuario)
    REFERENCES usuario (Id_Usuario),
  CONSTRAINT fk_vehiculo_sede1
    FOREIGN KEY (sede_Id_Sede)
    REFERENCES sede (Id_Sede),
  CONSTRAINT fk_vehiculo_marca1
    FOREIGN KEY (marca_Id_Marca)
    REFERENCES marca (Id_Marca));
    
    CREATE TABLE registro(
  Id_Registro INT(10) AUTO_INCREMENT NOT NULL,
  Ingresohor TIME NOT NULL,
  Salidahor TIME NOT NULL,
  Ingresfec DATE NOT NULL,
  Salidafec DATE NOT NULL,
  sede_Id_Sede INT(10) NOT NULL,
  sede_ciudad_ID_ciudad1 INT(15) NOT NULL,
  usuario_Id_Usuario VARCHAR(20) NOT NULL,
  usuario_tipo_documento_Id_TipoDoc INT(10) NOT NULL,
  vehiculo_Id_Vehiculo INT(10) NOT NULL,
  vehiculo_usuario_Id_Usuario VARCHAR(20) NOT NULL,
  vehiculo_sede_Id_Sede INT(10) NOT NULL,
  vehiculo_marca_Id_Marca INT(10) NOT NULL,
  PRIMARY KEY (Id_Registro),
  INDEX fk_registro_sede1_idx (sede_Id_Sede ASC, sede_ciudad_ID_ciudad1 ASC),
  INDEX fk_registro_usuario1_idx (usuario_Id_Usuario ASC, usuario_tipo_documento_Id_TipoDoc ASC),
  INDEX fk_registro_vehiculo1_idx (vehiculo_Id_Vehiculo ASC, vehiculo_usuario_Id_Usuario ASC, vehiculo_sede_Id_Sede ASC, vehiculo_marca_Id_Marca ASC),
  CONSTRAINT fk_registro_sede1
    FOREIGN KEY (sede_Id_Sede , sede_ciudad_ID_ciudad1)
    REFERENCES sede (Id_Sede , ciudad_ID_ciudad),
  CONSTRAINT fk_registro_usuario1
    FOREIGN KEY (usuario_Id_Usuario , usuario_tipo_documento_Id_TipoDoc)
    REFERENCES usuario (Id_Usuario , tipo_documento_Id_TipoDoc),
  CONSTRAINT fk_registro_vehiculo1
    FOREIGN KEY (vehiculo_Id_Vehiculo , vehiculo_usuario_Id_Usuario , vehiculo_sede_Id_Sede , vehiculo_marca_Id_Marca)
    REFERENCES vehiculo (Id_Vehiculo , usuario_Id_Usuario , sede_Id_Sede, marca_Id_Marca));


CREATE TABLE tipo_vehiculo (
  ID_TipoVehiculo INT(10) NOT NULL,
  clase_vehiculo varchar(10) NOT NULL,
  vehiculo_Id_Vehiculo INT(10) NOT NULL,
  vehiculo_usuario_Id_Usuario VARCHAR(20) NOT NULL,
  vehiculo_sede_Id_Sede INT(10) NOT NULL,
  vehiculo_marca_Id_Marca INT(10) NOT NULL,
  PRIMARY KEY (ID_TipoVehiculo),
  INDEX fk_tipo_vehiculo_vehiculo1_idx (vehiculo_Id_Vehiculo ASC, vehiculo_usuario_Id_Usuario ASC, vehiculo_sede_Id_Sede ASC, vehiculo_marca_Id_Marca ASC),
  CONSTRAINT fk_tipo_vehiculo_vehiculo1
    FOREIGN KEY (vehiculo_Id_Vehiculo , vehiculo_usuario_Id_Usuario, vehiculo_sede_Id_Sede , vehiculo_marca_Id_Marca)
    REFERENCES vehiculo (Id_Vehiculo , usuario_Id_Usuario , sede_Id_Sede , marca_Id_Marca));

CREATE TABLE LogError (
  ID_Log INT(10) NOT NULL,
  Tipo_Error varchar(20) NOT NULL
  );
  
  CREATE TABLE email (
  ID_email INT(10) NOT NULL,
  Confirmar_Email varchar(100) NOT NULL,
  Recuperar_password varchar (50) not null,
  Cambiar_contraseña varchar (50) not null
  );
insert into Ciudad (ID_ciudad,Nombre_ciudad)
Values (1,'Bogota'),(2,'Medellin'),(3,'Barranquilla'),(4,'Cartagena'),(5,'Villavicencio');



insert into marca(Id_Marca,Nombre_marca,Modelo_vehiculo)
values
(10,'AKT','Ak'),(11,'AKT','JET 4'),(12,'AKT','125 SL'),(13,'AKT','150 TT'),(14,'AKT','110'),(15,'AKT','EVO'),
(20,'Honda','SHADOW'),(21,'Honda','ECO'),(22,'Honda','HERO'),(23,'Honda','C-100'),(24,'Honda','AERO'),(25,'Honda','XL'),
(30,'Kawasaki','ZKI'),(31,'Kawasaki','NINJA'),(32,'Kawasaki','ATV'),(33,'Kawasaki','KLR'),(34,'Kawasaki','VULCAN'),(35,'Kawasaki','KX'),
(40,'Kymco','ACTIV'),(41,'Kymco','AGILITY'),(42,'Kymco','DOWTOWN'),(43,'Kymco','JETIX'),(44,'Kymco','FLY'),(45,'Kymco','ROCKET'),
(50,'Suzuki','TURISMO'),(51,'Suzuki','GSX'),(52,'Suzuki','GS'),(53,'Suzuki','HAYATE'),(54,'Suzuki','INAZUMA'),(55,'Suzuki','SPORT'),
(60,'Yamaha','FAZER'),(61,'Yamaha','FINO'),(62,'Yamaha','LIBERO'),(63,'Yamaha','SZ-R'),(64,'Yamaha','BWS'),(65,'Yamaha','R600');



insert into sede (Id_Sede,Nombre_Sede,Direccion_Sede,Telefono,ciudad_ID_ciudad)
values
(92106920,'Colegio Superior de Estudios Técnicos - COLSUTEC - Sede Colombia','Calle 69 # 20 - 36',4573733,1),
(92103017,'Centro de Electricidad, Electrónica y Telecomunicaciones','Cra 30 No. 17 B - 25 Sur ',5461500 ,1),
(94025157,'Centro de Servicios y Gestión Empresarial ','Calle 51 No. 57 – 70 Torre Norte ',8391918,2),
(920610469,'Centro Tecnológico de Gestión Industrial','Diag. 104 No. 69 - 120 El Pedregal',4442800,2),
(91030919, 'Centro para el Desarrollo Agroecológico y Agroindustrial',' Calle 9 No. 19 - 120 Barrio Santander',3851285,3),
(93024342,' Centro de Comercio y Servicios','  Cra. 43 No. 42 - 40 Piso 10',3851285,3),
(93040101,' Centro Nacional Industrial y de Aviación ', 'Calle 30 No. 3 Este - 164', 6539040,4),
(92180101,' Centro para la Industria Petroquímica ','Av. Pedro de Heredia Sector Tesca C',6697100,4),
(91171201,' Centro Agroindustrial del Meta Sede El Hachón',' Km. 12 Vía Puerto López Sede El Hachón Km. 12 Vía Puerto López',6825151,5),
(95321224,'Centro de Industria y Servicios del Meta Sede Popular ','Cra. 12A No. 24 - 39 Barrio Popular',6720821,5);
  
  
  
insert into tipo_documento (Id_TipoDoc,TipoDocumento)
values
(1,'C.C'),
(2,'T.I'),
(3,'C.E'),
(4,'NIT'),
(5,'Pasaporte');


insert into cupo(Id_Cupo,Numero_cupo,Estado_cupo)
Values
('A1',1,'Ocupado'),('A2',2,'Ocupado'),('A3',3,'Ocupado'),('A4',4,'Ocupado'),('A5',5,'Ocupado'),
('B1',6,'Ocupado'),('B2',7,'Ocupado'),('B3',8,'Ocupado'),('B4',9,'Ocupado'),('B5',10,'Ocupado'),
('C1',11,'Disponible'),('C2',12,'Disponible'),('C3',13,'Disponible'),('C4',14,'Disponible'),('C5',15,'Disponible');



insert into rol_usuario(Id_Rol,TipoRol)
VALUES(1,'Administrador'),(2,'Aprendiz'),(3,'Guarda Seguridad');


insert into tipo_vehiculo (ID_TipoVehiculo,clase_vehiculo,vehiculo_Id_Vehiculo,vehiculo_usuario_Id_Usuario,vehiculo_sede_Id_Sede,vehiculo_marca_Id_Marca)
values
(1,'Motocicleta','SWW85P',1144454987,92106920,10),
(1,'Motocicleta','PPW85P',1155554987,920610469,20),
(2,'Bicicleta','451285',1883654987,92106920,22),
(1,'Motocicleta','SXC45W',1523654987,920610469,54), 
(1,'Motocicleta','PFD52Q',1743654987,92106920,65), 
(1,'Motocicleta','FNI46X',1842654987,920610469,13),
(1,'Motocicleta','GCN74O',1782654987,92106920,21),
(1,'Motocicleta','TDN45B',1045365487,92106920,32),
(1,'Motocicleta','UDN95N',1145654487,920610469,52),
(1,'Motocicleta','ODM45B',1198564987,92106920,52);


insert into usuario
(Id_Usuario,tipo_documento_Id_TipoDoc,Primer_Nombre, Segundo_Nombre,Primer_Apellido,Segundo_Apellido,Email,Telefono,Direccion,Contraseña,sede_Id_Sede,sede_ciudad_ID_ciudad1,rol_usuario_Id_Rol,cupo_Id_Cupo)
values

(1155554987,1,'Dayana','liz','Perez','Fer','Dya@misena.edu.co',301321689,'Calle 25 N°12-03 sur','*******',920610469,2,1,'A2'),
(1883654987,1,'Carlos','Daniel','Arriba','Dauqe','Cad@misena.edu.co',301321689,'Calle 27 N°12-03 sur','*******',92106920,1,2,'A3'),
(1523654987,1,'Daniel','Fabien','Cierra','Triviño','Dani@misena.edu.co',311321689,'Calle 78 N°12-03 ','*******',920610469,2,2,'A4'), 
(1743654987,1,'willian','Barrera','Barrera','Paes','Will@misena.edu.co',32216889,'Calle 96 N°12-03 sur','*******',92106920,1,2,'A5'), 
(1842654987,1,'Carlos','Arley','Castillo','vargas','Carl@misena.edu.co',301321689,'Calle 117 N°12-03 sur','*******',920610469,2,1,'B1'),
(1782654987,1,'Daniela','Yuliana','Baez','Valdez','Danill@misena.edu.co',311321689,'Calle 150 N°12-03 ','*******',92106920,1,2,'B2'),
(1045365487,1,'jose','Daniel','Castañeda','Piedraota','Josee@misena.edu.co',31137989,'Calle 120 N°12-03 sur','*******',92106920,1,2,'B3'),
(1145654487,1,'Martha','Dayanna','dique','Silva','Math@misena.edu.co',30021689,'Calle 205 N°12-03 ','*******',920610469,2,3,'B4'),
(1198564987,1,'Lili','linda','Domingo','Diaz','LilA@misena.edu.co',30861689,'Calle 45 N°12-03 sur','*******',92106920,1,2,'B5');


insert into vehiculo (Id_Vehiculo,Marco,Placa,Numero_chasis,usuario_Id_Usuario,sede_Id_Sede,marca_Id_Marca)
values
(81254,0,'SWW85P',5423455,1144454987,92106920,10),
(1255,0,'PPW85P',2523456,1155554987,920610469,20),
(1256,A5K5F156,'451285',8523457,1883654987,92106920,22),
(1257,0,'SXC45W',8523458,1523654987,920610469,54), 
(1258,0,'PFD52Q',5423459,1743654987,92106920,65), 
(1259,0,'FNI46X',5423460,1842654987,920610469,13),
(1260,0,'GCN74O',5423461,1782654987,92106920,21),
(1261,0,'TDN45B',8423462,1045365487,92106920,32),
(1262,0,'UDN95N',7423463,1145654487,920610469,52),
(1263,1198564987,ODM45B,24234641198564987,92106920,52);



insert into LogError (ID_Log,Tipo_Error)
values  
(1,'Login'),
(2,'Sicronizacion'),
(3,'Tiempo de espera Agotado');


insert into email (ID_email,Confirmar_EmailL,Recuperar_password,Cambiar_contraseña)
  values
('ma@misena.edu.co','ma@misena.edu.co','**********','*******','**********'),
('Dya@misena.edu.co','Dya@misena.edu.co','**********','*******','**********'),
('Cad@misena.edu.co','Cad@misena.edu.co','**********','*******','**********'),
('Dani@misena.edu.co','Dani@misena.edu.co','**********','*******','**********'),
('Will@misena.edu.co','Will@misena.edu.co','**********','*******','**********'),
('Carl@misena.edu.co','Carl@misena.edu.co','**********','*******','**********'),
('Danill@misena.edu.co','Danill@misena.edu.co','**********','*******','**********'),
('Josee@misena.edu.co','Josee@misena.edu.co','**********','*******','**********'),
('Math@misena.edu.co','Math@misena.edu.co','**********','*******','**********'),
('LilA@misena.edu.co','LilA@misena.edu.co','**********','*******','**********');

  
