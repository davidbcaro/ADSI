CREATE database motobike_parking;
USE motobike_parking;



CREATE TABLE ciudad (
  ID_ciudad INT(15) NOT NULL,
  Nombre_ciudad VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (ID_ciudad));


CREATE TABLE cupo (
  Id_Cupo INT(10) AUTO_INCREMENT NOT NULL,
  Numero_cupo INT(5) NOT NULL,
  Estado_cupo TINYINT(1) NOT NULL,
  PRIMARY KEY (Id_Cupo));


CREATE TABLE  marca (
  Id_Marca INT(10) NOT NULL,
  Nombre_marca VARCHAR(20) NOT NULL,
  Modelo_vehiculo INT(20) NOT NULL,
  PRIMARY KEY (Id_Marca));



CREATE TABLE sede(
  Id_Sede INT(10) AUTO_INCREMENT NOT NULL,
  Nombre_Sede VARCHAR(50) NOT NULL,
  Direccion_Sede VARCHAR(50) NOT NULL,
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
  Id_Rol INT(10) NOT NULL,
  TipoRol VARCHAR(2) NOT NULL,
  PRIMARY KEY (Id_Rol));



  CREATE TABLE usuario (
  Id_Usuario VARCHAR(20) NOT NULL,
  Primer_Nombre VARCHAR(20) NOT NULL,
  Segundo_Nombre VARCHAR(20) NULL DEFAULT NULL,
  Primer_Apellido VARCHAR(20) NOT NULL,
  Segundo_Apellido VARCHAR(20) NULL DEFAULT NULL,
  Email VARCHAR(100) NULL DEFAULT NULL,
  Telefono INT(10) NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Contraseña VARCHAR(25) NOT NULL,
  Huella BLOB NULL DEFAULT NULL,
  Foto BLOB NULL DEFAULT NULL,
  Documentos BLOB NULL DEFAULT NULL,
  sede_Id_Sede INT(10) NOT NULL,
  sede_ciudad_ID_ciudad1 INT(15) NOT NULL,
  tipo_documento_Id_TipoDoc INT(10) NOT NULL,
  rol_usuario_Id_Rol INT(10) NOT NULL,
  cupo_Id_Cupo INT(10) NOT NULL,
  PRIMARY KEY (Id_Usuario, tipo_documento_Id_TipoDoc),
  UNIQUE INDEX Email (Email ASC),
  INDEX fk_usuario_tipo_documento1_idx (tipo_documento_Id_TipoDoc ASC),
  INDEX fk_usuario_rol_usuario1_idx (rol_usuario_Id_Rol ASC),
  INDEX fk_usuario_cupo1_idx (cupo_Id_Cupo ASC),
  INDEX fk_usuario_sede1_idx (sede_Id_Sede ASC, sede_ciudad_ID_ciudad1 ASC),
  CONSTRAINT fk_usuario_cupo1
    FOREIGN KEY (cupo_Id_Cupo)
    REFERENCES cupo (Id_Cupo),
      CONSTRAINT fk_usuario_rol_usuario1
    FOREIGN KEY (rol_usuario_Id_Rol)
    REFERENCES rol_usuario (Id_Rol),

  CONSTRAINT fk_usuario_tipo_documento1
    FOREIGN KEY (tipo_documento_Id_TipoDoc)
    REFERENCES tipo_documento (Id_TipoDoc),

  CONSTRAINT fk_usuario_sede1
    FOREIGN KEY (sede_Id_Sede , sede_ciudad_ID_ciudad1)
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
  ID_TipoVehiculo INT(10) AUTO_INCREMENT NOT NULL,
  clase_vehiculo BINARY(2) NULL DEFAULT NULL,
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
  ConfirmaR_EMAIL varchar(100) NOT NULL,
  Recuperar_password varchar (50) not null,
  Cambiar_contraseña varchar (50) not null
  );