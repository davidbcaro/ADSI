create database EON;


-- Documento
create table EON.Document(
id_Document varchar(100) comment 'Id of the type of document that the User has Can be: * CC * TI * CoE * Passport',
Name varchar(45) not null comment 'Name of the document that the user has',
Status boolean comment 'The document status that the user has Could be: *Enabled *Disabled',
primary key(id_Document)
);
-- insert de Documento
insert into eon.document (id_Document, Name, Status) values ('CC', 'Cedula de Ciudadania', true);
insert into eon.document (id_Document, Name, Status) values ('TI', 'Tarjeta de Identidad', true);
insert into eon.document (id_Document, Name, Status) values ('CE', 'Cedula de Extranjeria', true);
insert into eon.document (id_Document, Name, Status) values ('PP', 'Pasaporte', true);
insert into eon.document (id_Document, Name, Status) values ('DNI', 'Documento Nacional de Identificacion', true);
insert into eon.document (id_Document, Name, Status) values ('NCS', 'Numero ciego SENA', true);


-- Client
create table EON.Client(
document_Number varchar(20) comment 'The customer document number',
first_Name varchar(15) not null comment 'The customers first name',
second_Name varchar(20) comment 'The customers second name',
first_Last_name varchar(20) not null comment 'The clients first Last Name',
second_Last_name varchar(20) comment 'The clients second Last Name',
Photo blob comment 'Customer Photo',
id_Document varchar(100) comment 'Id of the type of document that the User has Can be: * CC * TI * CoE * Passport',
constraint fk_Client_Document foreign key (id_Document) references eon.document(id_Document) ON UPDATE CASCADE,
primary key(document_Number, id_Document)
);
-- insert de Client
insert into eon.client (document_Number, first_Name, second_Name, first_Last_name, second_Last_name, Photo, id_Document) values ('80013833', 'Hernando', 'Enrique', 'Moreno', 'Moreno', (load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/1154819.JPG')), 'CC');


-- User
create table EON.User(
document_Number varchar(20) comment 'The customer document number',
id_Document varchar(100) comment 'Id of the type of document that the User has Can be: * CC * TI * CoE * Passport',
Mail varchar(60) not null comment '	The mail that will enter the user',
Password varchar(20) not null comment 'Password that will enter the use',
Date_endind date comment 'Program end date',
constraint fk_user_client foreign key (document_Number, id_Document) references eon.client(document_Number, id_Document) ON UPDATE CASCADE,
primary key(document_Number, id_Document)
);
-- insert de User
insert into eon.user (document_Number, id_Document, Mail, Password, Date_endind) values ('80013833', 'CC', 'hemoreno33@misena.edu.co', 'contraseña123', '2017-12-15');


-- Role
create table EON.Role(
id_Role varchar(30) comment 'Id of the role of the document that the user has It can be: * Administrator * apprentice *instructor *Leader of the program',
Description varchar(100) not null comment 'The description that each role will have in how much to function',
Status boolean comment 'The status of the paper Could be: *Enabled *Disabled',
primary key(id_Role)
);
-- insert de Role
insert into eon.role (id_Role, Description, Status) values ('Aprendiz', 'El Aprendiz del SENA', true);
insert into eon.role (id_Role, Description, Status) values ('Instructor', 'El Instructor del SENA', true);
insert into eon.role (id_Role, Description, Status) values ('Lider del Programa', 'El Lider del Programa del SENA', true);
insert into eon.role (id_Role, Description, Status) values ('Administrador', 'El Administrador del SENA', true);
insert into eon.role (id_Role, Description, Status) values ('Super Administrador', 'El Super Administrador del SENA', true);


-- Client has Role
create table EON.Client_has_Role(
document_Number varchar(20) comment 'Foreing Key of The customer document number',
id_Document varchar(100) comment 'Foreing Key of Id of the type of document that the User has Can be: * CC * TI * CoE * Passport',
id_Role varchar(30) comment 'Foreing Key of Id of the role of the document that the user has It can be: * Administrator * apprentice *instructor *Leader of the program',
Status boolean comment 'Could be: *Active *Inactive',
constraint fk_chr_Client foreign key (document_Number, id_Document) references EON.Client(document_Number, id_Document) ON UPDATE CASCADE,
constraint fk_chr_Role foreign key (id_Role) references EON.Role(id_Role) ON UPDATE CASCADE,
primary key (document_Number, id_Document, id_Role)
);
-- insert de Client has Role 
insert into eon.client_has_role (document_Number, id_Document, id_Role, Status) values ('80013833', 'CC', 'Aprendiz', true);
insert into eon.client_has_role (document_Number, id_Document, id_Role, Status) values ('80013833', 'CC', 'Instructor', true);
insert into eon.client_has_role (document_Number, id_Document, id_Role, Status) values ('80013833', 'CC', 'Lider del Programa', true);
insert into eon.client_has_role (document_Number, id_Document, id_Role, Status) values ('80013833', 'CC', 'Administrador', true);
insert into eon.client_has_role (document_Number, id_Document, id_Role, Status) values ('80013833', 'CC', 'Super Administrador', true);


-- Bonding
create table EON.Bonding(
type_Linkage varchar(30) comment 'The type of linkage that the instructor will have These could be: *Halftime *Full time *Plant',
Hours int not null comment 'Number of hours for each type of linking',
Status boolean not null comment 'The state in which the linking will be: *Active *Inactive',
primary key(type_Linkage)
);
-- insert de Bonding 
insert into eon.bonding (type_Linkage, Hours, Status) values ('Tiempo Completo', 8, true);


-- Speciality
create table EON.Speciality(
speciality_Name varchar(30) comment 'The name of the specialties',
Status boolean not null comment 'Specialties states',
primary key(speciality_Name)
);
-- insert de Speciality
insert into eon.speciality (speciality_Name, Status) values ('TeleInformatica', true);
insert into eon.speciality (speciality_Name, Status) values ('TeleComunicaciones', true);
insert into eon.speciality (speciality_Name, Status) values ('Electricidad', true);
insert into eon.speciality (speciality_Name, Status) values ('Electronica', true);
insert into eon.speciality (speciality_Name, Status) values ('Promover', true);


-- Instructor
create table EON.Instructor(
document_Number varchar(20) comment 'Foreing Key of The customer document number',
id_Document varchar(100) comment 'Foreing Key of Id of the type of document that the User has Can be: * CC * TI * CoE * Passport',
speciality_Name varchar(30) comment 'Foreign attribute of The name of the specialties' not null,
type_Linkage varchar(30) comment 'Foreign attribute of The type of linkage that the instructor will have These could be: *Halftime *Full time *Plant' not null,
constraint fk_Instructor_Client foreign key (document_Number, id_Document) references EON.Client(document_Number, id_Document) ON UPDATE CASCADE,
constraint fk_Instructor_speciality foreign key (speciality_Name) references EON.speciality(speciality_Name) ON UPDATE CASCADE,
constraint fk_Instructor_Bonding foreign key (type_Linkage) references Eon.Bonding(type_Linkage) ON UPDATE CASCADE,
primary key(document_Number, id_Document)
);
-- insert de Instructor
insert into eon.instructor (document_Number, id_Document, speciality_Name, type_Linkage) values ('80013833', 'CC', 'TeleInformatica', 'Tiempo Completo');


-- Working Day
create table EON.Working_Day(
acronyms_Working_Day varchar(20)comment'The are placed abbreviations of the days',
name varchar(50)not null comment'* N (night)* WF (week fines)* Da (dawn)' ,
description varchar(45) comment'Daytime (6:00 to 12:00),Night (6:00 to 10:00)',
Image blob (200) comment'The image of the days',
State int comment'Could de: *Active*Inactive',
primary key (acronyms_Working_Day)
);
-- insert de Working Day
insert into eon.working_day (acronyms_Working_Day, name, description, Image, State) values ('D', 'Diurno', 'de 06:00:00 AM a 12:00:00 PM', 'C:/ProgramData/MySQL/MySQL Server 5.6/Uploads/14445jpg.jpg', true);
insert into eon.working_day (acronyms_Working_Day, name, description, Image, State) values ('T', 'Tarde', 'de 12:00:00 PM a 06:00:00 PM', 'C:/ProgramData/MySQL/MySQL Server 5.6/Uploads/Tarde.jpg', true);
insert into eon.working_day (acronyms_Working_Day, name, description, Image, State) values ('N', 'Nocturno', 'de 06:00:00 PM a 10:00:00 PM', 'C:/ProgramData/MySQL/MySQL Server 5.6/Uploads/Noche.jpg', true);


-- Day
create table EON.Day(
name_Day  varchar (10)comment'Monday Tuesday Wednesday Thursday ETC ...',
state boolean comment'Could be:*Active*Inactive',
primary key (name_Day)
);
-- insert de Day
insert into eon.day (name_Day, State) values ('Lunes', true);
insert into eon.day (name_Day, State) values ('Martes', true);
insert into eon.day (name_Day, State) values ('Miercoles', true);
insert into eon.day (name_Day, State) values ('Jueves', true);
insert into eon.day (name_Day, State) values ('Viernes', true);


-- Availability
Create table EON.Availability(
document_Number varchar(20) comment 'Foreing Key of The customer document number',
id_Document varchar(100) comment 'Foreing Key of Id of the type of document that the User has Can be: * CC * TI * CoE * Passport',
start_Time time comment 'The start time of the schedules',
end_Time time comment 'The end time of the schedules',
acronyms_Working_Day varchar(20) comment 'Foreing Key of The are placed abbreviations of the days',
name_Day varchar(10) comment 'Foreing Key of Monday Tuesday Wednesday Thursday ETC ...',
constraint fk_Availability_Instructor foreign key (document_Number, id_Document) references EON.Instructor(document_Number, id_Document) ON UPDATE CASCADE,
constraint fk_acronyms_Working_Day foreign key (acronyms_Working_Day) references EON.Working_Day (acronyms_Working_Day) ON UPDATE CASCADE,
constraint fk_Availability_Day foreign key (name_Day) references EON.Day (name_Day) ON UPDATE CASCADE,
primary key (document_Number, id_Document, start_Time, acronyms_Working_Day, name_Day)
);
-- insert de Availability
insert into eon.availability (document_Number, id_Document, start_Time, end_Time, acronyms_Working_Day, name_Day) values ('80013833', 'CC', '06:00:00', '14:00:00', 'D', 'Lunes');
insert into eon.availability (document_Number, id_Document, start_Time, end_Time, acronyms_Working_Day, name_Day) values ('80013833', 'CC', '06:00:00', '14:00:00', 'D', 'Martes');
insert into eon.availability (document_Number, id_Document, start_Time, end_Time, acronyms_Working_Day, name_Day) values ('80013833', 'CC', '06:00:00', '14:00:00', 'D', 'Miercoles');
insert into eon.availability (document_Number, id_Document, start_Time, end_Time, acronyms_Working_Day, name_Day) values ('80013833', 'CC', '06:00:00', '14:00:00', 'D', 'Jueves');
insert into eon.availability (document_Number, id_Document, start_Time, end_Time, acronyms_Working_Day, name_Day) values ('80013833', 'CC', '06:00:00', '14:00:00', 'D', 'Viernes');


-- Trimester
create table EON.Trimester(
quarter_Name varchar(20)comment'The name or number of the quarter',
acronyms_Working_Day varchar(100)comment'Foreing Key of The are placed abbreviations of the days',
speciality_Name varchar(100)comment'Foreing Key of The name of the specialties',
constraint fk_Trimestre_WD foreign key(acronyms_Working_Day)references eon.Working_Day (acronyms_Working_Day) ON UPDATE CASCADE,
constraint fk_Trimestre_Speciality foreign key(speciality_Name)references eon.speciality(speciality_Name) ON UPDATE CASCADE,
primary key(quarter_Name,acronyms_Working_Day,speciality_Name)
);
-- insert de Trimester
insert into eon.trimester (quarter_Name, acronyms_Working_Day, speciality_Name) values (1, 'D', 'TeleInformatica');
insert into eon.trimester (quarter_Name, acronyms_Working_Day, speciality_Name) values (2, 'D', 'TeleInformatica');
insert into eon.trimester (quarter_Name, acronyms_Working_Day, speciality_Name) values (3, 'D', 'TeleInformatica');
insert into eon.trimester (quarter_Name, acronyms_Working_Day, speciality_Name) values (4, 'D', 'TeleInformatica');
insert into eon.trimester (quarter_Name, acronyms_Working_Day, speciality_Name) values (5, 'D', 'TeleInformatica');
insert into eon.trimester (quarter_Name, acronyms_Working_Day, speciality_Name) values (6, 'D', 'TeleInformatica');


-- Training Level
create table EON.Training_Level(
training_Level varchar (20)comment'Could be:*Technical*Technologist* Technological specializati',
State int not null comment'State in which the level is asCould be: * Enabled* Disabled',
primary key (training_Level)
);
-- insert de Training Level
insert into eon.training_level (training_level, State) values ('Tecnico', false);
insert into eon.training_level (training_level, State) values ('Tecnologo', true);
insert into eon.training_level (training_level, State) values ('Especializado', false);


-- Programa
create table EON.Program(
Program_Code varchar (50) comment'The code of the training program',
Version varchar(50)not null comment'The version that has a program',
Name varchar (100)not null comment'Name of the training program',
Initials varchar (20) not null comment'The abbreviation of the program for example Adsi',
State boolean comment'State in which the level is asCould be: * Enabled* Disabled',
training_Level varchar (20) not null comment'Foreign attribute of Could be:*Technical*Technologist* Technological specializati',
constraint fk_Program_tL foreign key (training_Level)references eon.Training_Level(training_Level) ON UPDATE CASCADE,
primary key(Program_Code, Version)
);
-- insert de Programa
insert into eon.program (Program_Code, Version, Name, Initials, State, training_Level) values ('228106', 'V102', 'ANÁLISIS Y DESARROLLO DE SISTEMAS DE INFORMACIÓN', 'ADSI', true, 'Tecnologo');


-- Status ficha
Create table EON.Status_Ficha(
name_State varchar (20)comment'The name of the state that has the ficha',
State varchar (45)not null comment'Could be:*Cancelled*Postponed* Finished',
primary key (name_State)
);
-- insert de Status Ficha
insert into eon.status_ficha (name_State, State) values ('Aplazado', false);
insert into eon.status_ficha (name_State, State) values ('Cancelado', false);
insert into eon.status_ficha (name_State, State) values ('En ejecucion', true);
insert into eon.status_ficha (name_State, State) values ('Finalizado', false);


-- Ficha
create table EON.Ficha(
number_Ficha varchar(60) comment 'Is placed the ficha number',
start_Date date not null comment 'The start date of the ficha',
end_Date date not null comment 'The date on which the final ficha',
Route varchar(50) not null comment 'The number that identifies the ficha',
Program_Code varchar(100) not null comment 'Foreign attribute of The code of the training program',
Version varchar(10) not null comment 'The version that has a program',
name_State varchar(20) not null comment 'Foreign attribute of The name of the state that has the ficha',
constraint fk_Ficha_SF foreign key (name_State) references EON.Status_Ficha (name_State) ON UPDATE CASCADE,
constraint fk_Ficha_Program foreign key (Program_code, Version) references EON.Program (Program_Code, Version) ON UPDATE CASCADE,
primary key (number_Ficha)
);
-- insert de Ficha
insert into eon.ficha (number_Ficha, start_Date, end_Date, Route, Program_Code, Version, name_State) values ('1349397', '2016-12-1', '2018-11-30', 'RUTA 1G FICHA 1349397', '228106', 'V102', 'En ejecucion');


-- Ficha has Trimester
create table EON.Ficha_has_Trimester(
number_Ficha varchar(60) comment'Foreing Key of Is placed the ficha number',
quarter_Name varchar(20)comment'Foreing Key of The name or number of the quarter',
acronyms_working_Day varchar(20)comment'Foreing Key of The are placed abbreviations of the days',
speciality_Name varchar(100)comment'Foreing Key of The name of the specialties',
constraint fk_FhT_Ficha foreign key(number_Ficha)references eon.Ficha(number_Ficha) ON UPDATE CASCADE,
constraint fk_FhT_Trimester foreign key(quarter_Name, acronyms_Working_Day,speciality_Name)references eon.Trimester(quarter_Name,acronyms_Working_Day,speciality_Name) ON UPDATE CASCADE,
primary key(number_Ficha, quarter_Name, acronyms_Working_Day, speciality_Name)
);
-- insert de Ficha has Trimester
insert into eon.ficha_has_trimester (number_Ficha, quarter_Name, acronyms_working_Day, speciality_Name) values ('1349397', 1, 'D', 'TeleInformatica');
insert into eon.ficha_has_trimester (number_Ficha, quarter_Name, acronyms_working_Day, speciality_Name) values ('1349397', 2, 'D', 'TeleInformatica');
insert into eon.ficha_has_trimester (number_Ficha, quarter_Name, acronyms_working_Day, speciality_Name) values ('1349397', 3, 'D', 'TeleInformatica');
insert into eon.ficha_has_trimester (number_Ficha, quarter_Name, acronyms_working_Day, speciality_Name) values ('1349397', 4, 'D', 'TeleInformatica');
insert into eon.ficha_has_trimester (number_Ficha, quarter_Name, acronyms_working_Day, speciality_Name) values ('1349397', 5, 'D', 'TeleInformatica');
insert into eon.ficha_has_trimester (number_Ficha, quarter_Name, acronyms_working_Day, speciality_Name) values ('1349397', 6, 'D', 'TeleInformatica');


-- Modality
create table EON.Modality(
modality_Name varchar (20)comment'Could be:* Face-to-face* Virtual* Mixed',
State boolean comment'Could be:*Active*Inactive',
primary key(modality_Name)
);
-- insert de Modality
insert into eon.modality (modality_Name, State) values ('Presencial', true);
insert into eon.modality (modality_Name, State) values ('Virtual', false);
insert into eon.modality (modality_Name, State) values ('Mixta', false);


-- Headquarters
create table EON.Headquarters(
name_Headquarters varchar (100)comment'Barrio ColombiaSede, Restrepo,ETC',
address varchar(45)not null comment'It is the address where you will find the headquarters',
State boolean comment'Could be:*Closed*Available',
primary key(name_Headquarters)
);
-- insert de Headquarters
insert into eon.headquarters (name_Headquarters, address, State) values ('Sede Barrio Colombia', 'Cl. 69 #20-36', true);


-- Ambiente
create table EON.Ambience(
number_Ambience varchar(30)comment'The assigned training environment',
Description varchar (100) comment'The amount or capacity of students in the classroom or environment',
Status boolean comment'Could be:*Active*Inactive',
name_Headquarters varchar(100)comment'Foreing Key of Barrio Colombia,Sede Restrepo,ETC',
constraint fk_Ambience_Headquarters foreign key(name_Headquarters)references eon.Headquarters(name_Headquarters) ON UPDATE CASCADE,
primary key (name_Headquarters,number_Ambience)
);
-- insert de Ambiente
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('100', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('103', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('200', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('201', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('202', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('300', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('301', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('302', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('303', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('305', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('307', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('400', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('401', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('402', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('405', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('407', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('cafe libre', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('Sala de Instructores', '35 o mas',true, 'Sede Barrio Colombia');
insert into eon.ambience (number_Ambience, Description, Status, name_Headquarters) values ('Auditorio', '35 o mas',true, 'Sede Barrio Colombia');
 
 
-- Current Quarter
create table EON.Current_Quarter(
idCurrent_Quarter varchar (10) comment'Name that currently has the quarter',
start_Date date not null comment'The start date of the current quarter',
end_Date date not null comment'The final date of the final quarter',
primary key(idCurrent_Quarter)
);
-- insert de Current Quarter
insert into eon.current_quarter (idCurrent_Quarter, start_Date, end_Date) values (3, '2017-07-17', '2017-09-23');


-- Version
create table EON.Version(
idVersion int comment'Version Name',
active boolean comment'Could be:*Active*Inactive',
idCurrent_Quarter varchar(10) comment'Foreing Key of Name that currently has the quarter',
constraint fk_Version_CQ foreign key(idCurrent_Quarter)references eon.Current_Quarter (idCurrent_Quarter) ON UPDATE CASCADE,
primary key(idCurrent_Quarter, idVersion)
);
-- insert de Version
insert into eon.version (idVersion, active, idCurrent_Quarter) values (1, true, 3);


-- Schedule
create table EON.Schedule(
document_Number varchar(20) comment'Foreing Key of The customer document number',
id_Document varchar(10) comment'Foreing Key of Id of the type of document that the User has Can be: * CC* TI',
start_Time varchar(20) not null comment'The start date of the ficha',
end_Time varchar(10) not null comment'The end date of the ficha',
name_Day varchar(10) comment'The end date of the ficha',
modality_Name varchar(20) not null comment'Foreign attribute of Could be: *Face-to-face* Virtual* Mixed',
number_Ambience varchar(20) comment'Foreing Jey of The assigned training environment',
name_Headquarters varchar(100) comment'Foreing Key of Barrio Colombia, Sede Restrepo, ETC…',
number_Ficha varchar(60) comment'Foreing Key of Is placed the ficha number',
quarter_Name varchar(20) comment'Foreing Key of The name or number of the quarter',
acronyms_Working_Day varchar(20) comment'Foreing Key of The are placed abbreviations of the days',
idVersion int comment'Foreing Key of The are placed abbreviations of the days',
idCurrent_Quarter varchar(10) comment'Foreing Key of Name that currently has the quarter',
constraint fk_Schedule_Instructor foreign key(document_Number, id_Document) references eon.Instructor(document_Number, id_Document) ON UPDATE CASCADE,
constraint fk_Schedule_Day foreign key (name_Day) references eon.Day(name_Day) ON UPDATE CASCADE,
constraint fk_Schedule_Modality foreign key (modality_Name) references eon.Modality(modality_Name) ON UPDATE CASCADE,
constraint fk_Schedule_Ambience foreign key (name_Headquarters,number_Ambience) references eon.Ambience(name_Headquarters,number_Ambience) ON UPDATE CASCADE,
constraint fk_Schedule_Ficha foreign key (number_Ficha, quarter_Name, acronyms_Working_Day) references eon.Ficha_has_Trimester (number_Ficha, quarter_Name, acronyms_Working_Day) ON UPDATE CASCADE,
constraint fk_Schedule_Version foreign key (idCurrent_Quarter, idVersion) references eon.Version (idCurrent_Quarter, idVersion) ON UPDATE CASCADE, 
primary key(document_Number, id_Document, name_Day, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_day, idVersion, idCurrent_Quarter) 
);
-- insert de Schedule
insert into eon.schedule (document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter) values ('80013833', 'CC', '06:00:00', '12:00:00', 'Lunes', 'Presencial', '300', 'Sede Barrio Colombia', '1349397', 3, 'D', 1, 3);
insert into eon.schedule (document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter) values ('80013833', 'CC', '06:00:00', '12:00:00', 'Martes', 'Presencial', '300', 'Sede Barrio Colombia', '1349397', 3, 'D', 1, 3);
insert into eon.schedule (document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter) values ('80013833', 'CC', '06:00:00', '12:00:00', 'Miercoles', 'Presencial', '300', 'Sede Barrio Colombia', '1349397', 3, 'D', 1, 3);
insert into eon.schedule (document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter) values ('80013833', 'CC', '06:00:00', '12:00:00', 'Jueves', 'Presencial', '300', 'Sede Barrio Colombia', '1349397', 3, 'D', 1, 3);
insert into eon.schedule (document_Number, id_Document, start_Time, end_Time, name_Day, modality_Name, number_Ambience, name_Headquarters, number_Ficha, quarter_Name, acronyms_Working_Day, idVersion, idCurrent_Quarter) values ('80013833', 'CC', '06:00:00', '12:00:00', 'Viernes', 'Presencial', '300', 'Sede Barrio Colombia', '1349397', 3, 'D', 1, 3);


-- Competition
create table EON.competition(
Competition_code varchar(50)comment'Code that distinguishes the competition',
description varchar(300)not null comment'Brief description of the competition',
Program_Code varchar(50)comment'Foreing Key of The code corresponding to the project',
Version varchar(50) comment'The version that has a program',
constraint fk_competition_Ficha foreign key (Program_Code, Version)references eon.program(Program_code, Version) ON UPDATE CASCADE,
primary key(Competition_code, Program_Code, Version) 
);
-- insert de Competition
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('220501006', 'Especificar los requisitos necesarios para desarrollar el sistema de información de acuerdo con las necesidades del cliente', '228106', 'V102');
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('220501032', 'Analizar los requisitos del cliente para construir el sistema de información', '228106', 'V102');
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('240201500', 'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social', '228106', 'V102');
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('240201501', 'Comprender textos en inglés en forma escrita y auditiva', '228106', 'V102');
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('240201502', 'Producir textos en inglés en forma escrita y oral', '228106', 'V102');
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('220501033', 'Diseñar el sistema de acuerdo con los requerimientos del cliente', '228106', 'V102');
insert into eon.competition (Competition_code, description, Program_Code, Version) values ('220501007', 'Construir el sistema que cumpla con los requisitos de la solución informática', '228106', 'V102');
insert into eon.competition (Competition_Code, description, Program_Code, Version) values ('220501034', 'Implantar la solución que cumpla con los requerimientos para su operación', '228106', 'V102');
insert into eon.competition (Competition_Code, description, Program_Code, Version) values ('220501009', 'Participar en el proceso de negociación de Tecnología informática para permitir la implementación del sistema de información', '228106', 'V102');
insert into eon.competition (Competition_Code, description, Program_Code, Version) values ('220501035', 'Aplicar buenas prácticas de calidad en el proceso de desarrollo de software, de acuerdo con el referente adoptado en la empresa ', '228106', 'V102');


-- Learning Result
create table EON.Learning_Result(
Code varchar(50)comment'Code that distinguishes it from other learning outcomes',
Description varchar(400) not null comment'Brief description of the learning outcome',
Program_Code varchar(50)comment'Foreing Key of The code corresponding to the project',
Competition_Code varchar(50)comment'Foreing Key of The code corresponding to the proje',
Version varchar(50) comment'The version that has a program',
constraint fk_LR_competition foreign key (Competition_Code, Program_Code, Version) references EON.competition (Competition_Code, Program_Code, Version) ON UPDATE CASCADE,
primary key (Code, Program_Code, Version, Competition_Code)
);
-- insert de Learning Result
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-1 220501006-01', 'Aplicar las técnicas de recolección de datos , diseñando  los instrumentos necesarios para el procesamiento de información, de acuerdo con la situación planteada por la empresa', '228106', '220501006', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-2 220501006-02', 'Elaborar mapas de procesos que permitan identificar las áreas involucradas en un sistema de información, utilizando herramientas informáticas y las Tic’s, para generar informes según las necesidades de la empresa', '228106', '220501006', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-3 220501006-03', 'Plantear diferentes alternativas, de modelos tecnológicos de información empresarial, teniendo en cuenta la plataforma  tecnológica de la empresa y las tendencias del mercado, para dar solución a las situaciones relacionadas con el manejo de la información de la organización', '228106', '220501006', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-4 220501032-01', 'Interpretar el informe de requerimientos, para determinar las necesidades tecnológicas en el manejo de la información, de acuerdo con las normas y protocolos establecidos en la empresa', '228106', '220501032', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-5 220501032-02', 'Representa el bosquejo de la solución al problema presentado por el cliente, mediante la  elaboración de diagramas de casos de uso,  apoyado en el análisis del informe de requerimientos, al confrontar la situación problemica con el usuario según  normas y protocolos de la organización', '228106', '220501032', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-6 220501032-03', 'Construir el modelo conceptual del macrosistema frente a los requerimientos del cliente,  mediante el uso e interpretación de la información levantada, representado en diagramas de clase, de interacción, colaboración y contratos de operación, de acuerdo con las diferentes secuencias, fases y procedimientos del sistema', '228106', '220501032', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-1 240201500-10', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-2 240201500-14', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-3 240201500-12', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-4 240201500-13', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-1 240201500-05', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-2 240201500-11', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-3 240201500-02', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-1 240201501-01', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-2 240201501-02', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-1 240201502-01', 'Reproducir en inglés frases o enunciados simples que permitan expresar de forma lenta ideas o conceptos', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-7 220501032-04', 'Valorar la incidencia de los datos en los procesos del macrosistema, tomando como referente  el diccionario de datos y las miniespecificaciones, para la consolidación de los datos que intervienen, de acuerdo con parámetros establecidos', '228106', '220501032', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-8 220501032-05', 'Elaborar el informe de los resultados del análisis del sistema de información, de acuerdo con los requerimientos del cliente  según normas y protocolos establecidos', '228106', '220501032', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-9 220501033-02', 'Diseñar la arquitectura del software, mediante la interpretación de las clases, objetos y mecanismos de colaboración, utilizando herramientas tecnológicas de diseño, de acuerdo con las tendencias de las tecnologías de la información y la comunicación', '228106', '220501033', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-10 220501033-03', 'Construir el prototipo del sistema de información, a partir del análisis de las características funcionales del sistema en relación con facilidad de manejo, funcionalidad y experiencia del usuario, apoyado en software aplicado según protocolos de diseño', '228106', '220501033', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-11 220501033-04', 'Diseñar  la estructura de datos, a partir del modelo conceptual determinado en el análisis del sistema, utilizando herramientas tecnológicas de bases de datos, según las normas y estándares establecidos', '228106', '220501033', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-12 220501033-01', 'Diseñar  la arquitectura tecnológica  del sistema de información, mediante el reconocimiento de hardware y software, de acuerdo con la tecnología disponible en el mercado, el informe de análisis levantado y el diagrama de distribución', '228106', '220501033', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-3 240201501-03', 'Leer textos muy breves y sencillos en inglés general y técnico', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-1', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-2', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-3 240201500-04', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-2 240201502-02', 'Identificar formas gramaticales básicas en textos y documentos elementales escritos en inglés', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-13 220501033-05', 'Aplicar políticas y mecanismos de control en el diseño del sistema de información, mediante el análisis de la vulnerabilidad de la información, siguiendo los parámetros establecidos por la organización', '228106', '220501033', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-14 220501033-06', 'Elaborar el informe de diseño del sistema de información, de acuerdo con la selección de las herramientas, tanto de software como de hardware, requeridas para la solución informática', '228106', '220501033', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-15 220501007-01', 'Interpretar el informe técnico de diseño, para determinar el plan de trabajo durante la fase de construcción del software, de acuerdo con las normas y protocolos establecidos en la empresa', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-16 220501007-02', 'Construir la base de datos, a partir del modelo de datos determinado en el diseño del sistema, utilizando sistemas de gestión de base de datos, según los protocolos establecidos en la organización', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-17 220501007-03', 'Construir la interfaz de usuario, apoyado en la evaluación del prototipo, determinando las entradas y salidas requeridas en el diseño y definiendo los lineamientos para la navegación, de acuerdo con las necesidades del usuario', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-18 220501007-04', 'Realizar la codificación de los módulos del sistema y el programa principal, a partir de la utilización del lenguaje de programación seleccionado, de acuerdo con las especificaciones del diseño', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-4 240201501-04', 'Encontrar información específica y predecible en escritos sencillos y cotidianos', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-1 240201500-06', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-2 240201500-07', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-3 240201500-08', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAB-4 240201500-01 ', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales', '228106', '240201500', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-3 240201502-03', 'Comprender una amplia variedad de frases y vocabulario  en inglés sobre temas de interés personal y temas técnicos', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-19 220501007-05', 'Construir el programa de instalación del aplicativo, utilizando las herramientas de desarrollo disponibles en el mercado, según las características de la arquitectura de la solución', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-20 220501007-06', 'Elaborar el manual técnico de la aplicación, de acuerdo con la complejidad del aplicativo y según normas y procedimientos establecidos por la empresa', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-21 220501007-07', 'Ejecutar y documentar las pruebas del software, aplicando técnicas de ensayo-error, de acuerdo con el plan diseñado y los procedimientos establecidos por la empresa', '228106', '220501007', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-22 220501034-01', 'Configurar el software de la aplicación para cliente y servidor, mediante la utilización del hardware disponible,  ejecutándola en la plataforma tecnológica, según normas y protocolos establecidos por la empresa', '228106', '220501034', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-23 220501034-02 ', 'Elaborar el informe administrativo, siguiendo los protocolos de la organización, basado en los planes de instalación, respaldo y migración del sistema de información, facilitando la operatividad y mantenimiento de la solución informática', '228106', '220501034', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-24 220501034-03', 'Definir estrategias para la  validación de manuales de usuario y de operación,  respondiendo a las necesidades y satisfacción del cliente, frente a la solución informática propuesta, según políticas de la organización', '228106', '220501034', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-5', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-4 240201502-04', 'Comprender las ideas principales de textos complejos en inglés que tratan de temas tanto concretos como abstractos, incluso si son de carácter técnico, siempre que estén dentro de su campo de especialización', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-25 220501034-04', 'Capacitar a los usuarios del sistema, sobre la estructuración y el manejo del aplicativo,  de acuerdo con el plan establecido, el perfil de los usuarios, según políticas de la organización', '228106', '220501034', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-26 220501034-05', 'Elaborar informes técnicos relacionados con la solución informática implantada, de acuerdo con las propuestas de alternativas aplicadas, teniendo en cuenta las técnicas de comunicación y según normas y protocolos establecidos', '228106', '220501034', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-27 220501009-01', 'Interpretar el diagnóstico de necesidades informáticas, para determinar las tecnológicas requeridas en el manejo de la información, de acuerdo con las normas y protocolos establecidos por la empresa', '228106', '220501009', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-28 220501009-02', 'Definir estrategias para la elaboración de términos de referencia y procesos de evaluación de proveedores, en la adquisición de tecnología, según protocolos establecidos', '228106', '220501009', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-29 220501009-03', 'Participar en los perfeccionamientos de contratos informáticos, estableciendo cláusulas técnicas, que respondan a las necesidades de los actores de la negociación, de acuerdo con la ley de contratación', '228106', '220501009', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-30 220501009-04', 'Elaborar el informe sobre el cumplimiento de los términos de referencia previstos en la negociación, de acuerdo con la participación de cada uno de los actores en relación con la satisfacción de los bienes informáticos contratados y recibidos, según normas y protocolos de la organización', '228106', '220501009', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-6', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-5 240201502-05', 'Leer textos complejos y con un vocabulario más específico, en inglés general y técnico', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-6 240201502-06', 'Buscar de manera sistemática información específica y detallada en escritos en inglés, mas estructurados y con mayor contenido técnico', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-31 220501035-01', 'Identificar las características de los procesos de desarrollo de software, frente al referente de calidad adoptado por la empresa, ajustándolos a los resultados de las mediciones, evaluaciones y recomendaciones realizadas', '228106', '220501035', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-32 220501035-02', 'Identificar los puntos críticos de control en los procesos de desarrollo de software, para establecer las acciones a seguir, garantizando el cumplimiento de los estándares de calidad, siguiendo los lineamientos establecidos por la organización', '228106', '220501035', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-33 220501035-03', 'Aplicar los estándares de calidad involucrados en los procesos de desarrollo de software, siguiendo el plan establecido para mantener la integridad de los productos  de trabajo definidos, según las prácticas de configuración establecidas por la empresa', '228106', '220501035', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-34 220501035-04', 'Elaborar instrumentos e instructivos, requeridos por el aseguramiento de la calidad, para documentar y evaluar los procesos de desarrollo de software, de acuerdo con las normas y procedimientos establecidas por la empresa', '228106', '220501035', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-35 220501035-05', 'Evaluar procesos y productos de desarrollo de software, documentar y concertar acciones a seguir, para garantizar el cumplimiento de las normas establecidas, de acuerdo con el plan definido y con los criterios de medición, métricas y políticas determinados por la empresa', '228106', '220501035', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAE-36 220501035-06', 'Elaborar el informe final del proceso de gestión de calidad en el desarrollo de software, que consolide la información de las evidencias, hallazgos y novedades frente al seguimiento y control de los productos, según normas internacionales y protocolos de la organización', '228106', '220501035', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-7', 'Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos', '228106', '240201501', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-7 240201502-07', 'Encontrar y utilizar sin esfuerzo vocabulario y expresiones de inglés técnico en artículos de revistas, libros especializados, páginas web, etc', '228106', '240201502', 'V102');
insert into eon.learning_result (Code, Description, Program_Code, Competition_Code, Version) values ('RAT-8 240201502-08', 'Relacionarse con hablantes nativos en un grado suficiente de fluidez y naturalidad, de modo que la comunicación se realice sin esfuerzo por parte de los interlocutores', '228106', '240201502', 'V102');


-- Trimester has Learning Result
create table EON.Trimester_has_Learning_Result(
quarter_Name varchar(20) comment'Foreing Key of The name or number of the quarter',
acronyms_Working_Day varchar(20) comment'Foreing Key of The are placed abbreviations of the days',
Learning_Result_Code varchar(50) comment'Foreing Key of The code corresponding to the project',
Program_Code varchar(50) comment'Foreing Key of The code corresponding to the project',
Competition_Code varchar(50) comment'Foreing Key of The code corresponding to the project',
speciality_Name varchar(100) comment'The name of the specialties',
Version varchar(50) comment'Foreing Key of The version that has a program',
constraint fk_ThLR_Trimester foreign key (quarter_Name, acronyms_Working_Day, speciality_Name) references EON.Trimester (quarter_Name, acronyms_Working_Day, speciality_Name) ON UPDATE CASCADE,
constraint fk_ThLR_LR foreign key (Learning_Result_Code, Program_Code, Version, Competition_Code) references EON.Learning_Result (Code, Program_Code, Version, Competition_Code) ON UPDATE CASCADE,
primary key(quarter_Name, acronyms_Working_Day, speciality_Name, Learning_Result_Code, Program_Code, Competition_Code, Version)
);
-- insert de Trimester has Learning Result
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAB-1', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-1 240201500-05', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAB-1 240201500-06', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-1 240201500-10', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAB-2', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAB-2 240201500-07', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-2 240201500-11', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-2 240201500-14', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-3 240201500-02', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAB-3 240201500-04', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAB-3 240201500-08', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-3 240201500-12', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAB-4 240201500-01', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAB-4 240201500-13', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAE-1 220501006-01', '228106', '220501006', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAE-10 220501033-03', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAE-11 220501033-04', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAE-12 220501033-01', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAE-13 220501033-05', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAE-14 220501033-06', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAE-15 220501007-01', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAE-16 220501007-02', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAE-17 220501007-03', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAE-18 220501007-04', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAE-19 220501007-05', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAE-2 220501006-02', '228106', '220501006', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAE-20 220501007-06', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAE-21 220501007-07', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAE-22 220501034-01', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAE-23 220501034-02 ', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAE-24 220501034-03', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAE-25 220501034-04', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAE-26 220501034-05', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAE-27 220501009-01', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAE-28 220501009-02', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAE-29 220501009-03', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAE-3 220501006-03', '228106', '220501006', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAE-30 220501009-04', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAE-31 220501035-01', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAE-32 220501035-02', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAE-33 220501035-03', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAE-34 220501035-04', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAE-35 220501035-05', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAE-36 220501035-06', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAE-4 220501032-01', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAE-5 220501032-02', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAE-6 220501032-03', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAE-7 220501032-04', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAE-8 220501032-05', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAE-9 220501033-02', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAT-1 240201501-01', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAT-1 240201502-01', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (1, 'D', 'RAT-2 240201501-02', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAT-2 240201502-02', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (2, 'D', 'RAT-3 240201501-03', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAT-3 240201502-03', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (3, 'D', 'RAT-4 240201501-04', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAT-4 240201502-04', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (4, 'D', 'RAT-5', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAT-5 240201502-05', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAT-6', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (5, 'D', 'RAT-6 240201502-06', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAT-7', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAT-7 240201502-07', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.trimester_has_learning_result (quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values (6, 'D', 'RAT-8 240201502-08', '228106', '240201502', 'TeleInformatica', 'V102');


-- Project
create table EON.project(
Code varchar(50) not null comment 'The code corresponding to the project',
Name varchar(150) not null comment 'Projects name',
State int comment 'Project status can be Active Developing Inactive',
primary key (Code)
);
-- insert de Project
insert into eon.project (Code, Name, State) values ('576887', 'SISTEMA INTEGRAL WEB PARA GESTION DE PROCESOS EDUCATIVOS DEL CEET', true);


-- Phase
create table EON.phase(
name_phase varchar (30) comment'The name with which the phase is identified',
State boolean comment'State in which the phase Could be Active Inactive',
Code varchar(50) comment'Foreing Key of The code corresponding to the project',
constraint fk_Phase_project foreign key (code) references eon.project(code) ON UPDATE CASCADE,
primary key (name_Phase, code)
);
-- insert de Phase
insert into eon.phase (name_Phase, State, Code) values ('Analisis', true, '576887');
insert into eon.phase (name_Phase, State, Code) values ('Planeacion', true, '576887');
insert into eon.phase (name_Phase, State, Code) values ('Ejecucion', true, '576887');
insert into eon.phase (name_Phase, State, Code) values ('Evaluacion', true, '576887');


-- Activity
create table EON.activity(
id_Activity int comment 'The id corresponding to the Activity',
Name varchar(200) not null comment 'Name that corresponds to the activity',
Code varchar(50) comment'Foreing Key of The code corresponding to the project',
name_phase varchar (30) comment'The name with which the phase is identified',
constraint fk_activity_phase foreign key (name_phase, code) references eon.phase (name_phase, code) ON UPDATE CASCADE,
primary key (id_Activity, name_phase, code)
);
-- insert de Activity
insert into eon.activity (id_Activity, Name, Code, name_phase) values (2, 'Determinar los requerimientos del sistema según especificaciones y lineamientos del proyecto', '576887', 'Analisis');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (3, 'Analizar procesos, datos y necesidades del centro de electricidad, electrónica y telecomunicaciones y el usuario final para el modulo especifico', '576887', 'Analisis');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (4, 'Especificar modelo conceptual del sistema, especificando necesidades y requerimientos', '576887', 'Planeacion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (1, 'Actividades de  inducción en la formación profesional integral SENA', '576887', 'Analisis');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (8, 'Desarrollo los módulos del sistema integral web de acuerdo a los estándares de calidad y normatividad  legal vigente', '576887', 'Ejecucion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (5, 'Determinar la estructura lógica del sistema', '576887', 'Planeacion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (6, 'Diseñar  la estructura tecnológica  del sistema integral', '576887', 'Planeacion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (9, 'Preparar documentación del proceso de implantación del sistema', '576887', 'Planeacion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (7, 'Desarrollar la estructura de datos y de vista de la aplicación del modulo', '576887', 'Ejecucion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (9, 'Preparar documentación del proceso de implantación del sistema', '576887', 'Evaluacion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (10, 'Desarrollar las tareas de configuración y puesta en marcha del sistema ', '576887', 'Evaluacion');
insert into eon.activity (id_Activity, Name, Code, name_phase) values (11, 'Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos', '576887', 'Evaluacion');


-- Learning Result has Activity
create table EON.Learning_Result_has_Activity(
Activity_id_Activity int comment 'Foreing Key of The id corresponding to the Activity',
name_Phase varchar (30) comment 'Foreing Key of The name with which the phase is identified',
Project_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Learning_Result_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Competition_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Program_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Version varchar(50) comment'Foreing Key of The version that has a program',
constraint fk_lrha_activity foreign key(Activity_id_Activity, name_Phase, Project_Code) references eon.activity(id_activity, name_phase, Code) ON UPDATE CASCADE,
constraint fk_lrha_lr foreign key(Learning_Result_Code, Program_Code, Version, Competition_Code) references eon.Learning_Result(Code, Program_Code, Version, Competition_Code) ON UPDATE CASCADE, 
primary key(Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Program_Code, Version, Competition_Code)
);
-- insert de Learning Result has Activity
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAE-1 220501006-01', '220501006', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAE-2 220501006-02', '220501006', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAE-3 220501006-03', '220501006', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (3, 'Analisis', '576887', 'RAE-4 220501032-01', '220501032', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (4, 'Planeacion', '576887', 'RAE-5 220501032-02', '220501032', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (4, 'Planeacion', '576887', 'RAE-6 220501032-03', '220501032', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (1, 'Analisis', '576887', 'RAB-1 240201500-10', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (1, 'Analisis', '576887', 'RAB-2 240201500-14', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (1, 'Analisis', '576887', 'RAB-3 240201500-12', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (1, 'Analisis', '576887', 'RAB-4 240201500-13', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAB-1 240201500-05', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAB-2 240201500-11', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAB-3 240201500-02', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAT-1 240201501-01', '240201501', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAT-2 240201501-02', '240201501', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-1 240201502-01', '240201502', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (3, 'Analisis', '576887', 'RAE-7 220501032-04', '220501032', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (4, 'Planeacion', '576887', 'RAE-8 220501032-05', '220501032', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (5, 'Planeacion', '576887', 'RAE-9 220501033-02', '220501033', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (5, 'Planeacion', '576887', 'RAE-10 220501033-03', '220501033', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (5, 'Planeacion', '576887', 'RAE-11 220501033-04', '220501033', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (6, 'Planeacion', '576887', 'RAE-12 220501033-01', '220501033', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAT-3 240201501-03', '240201501', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (4, 'Planeacion', '576887', 'RAB-1', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (6, 'Planeacion', '576887', 'RAB-2', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (9, 'Planeacion', '576887', 'RAB-3 240201500-04', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-2 240201502-02', '240201502', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (5, 'Planeacion', '576887', 'RAE-13 220501033-05', '220501033', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (6, 'Planeacion', '576887', 'RAE-14 220501033-06', '220501033', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAE-15 220501007-01', '220501007', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAE-16 220501007-02', '220501007', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAE-17 220501007-03', '220501007', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAE-18 220501007-04', '220501007', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (2, 'Analisis', '576887', 'RAT-4 240201501-04', '240201501', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAB-1 240201500-06', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAB-2 240201500-07', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAB-3 240201500-08', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAB-4 240201500-01', '240201500', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-3 240201502-03', '240201502', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAE-19 220501007-05', '220501007', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (9, 'Evaluacion', '576887', 'RAE-20 220501007-06', '220501007', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (9, 'Evaluacion', '576887', 'RAE-21 220501007-07', '220501007', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (10, 'Evaluacion', '576887', 'RAE-22 220501034-01', '220501034', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (10, 'Evaluacion', '576887', 'RAE-23 220501034-02', '220501034', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (11, 'Evaluacion', '576887', 'RAE-24 220501034-03', '220501034', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (6, 'Planeacion', '576887', 'RAT-5', '240201501', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-4 240201502-04', '240201502', '228106', 'v102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (10, 'Evaluacion', '576887', 'RAE-25 220501034-04', '220501034', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (11, 'Evaluacion', '576887', 'RAE-26 220501034-05', '220501034', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (3, 'Analisis', '576887', 'RAE-27 220501009-01', '220501009', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (6, 'Planeacion', '576887', 'RAE-28 220501009-02', '220501009', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (10, 'Evaluacion', '576887', 'RAE-29 220501009-03', '220501009', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (10, 'Evaluacion', '576887', 'RAE-30 220501009-04', '220501009', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (7, 'Ejecucion', '576887', 'RAT-6', '240201501', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-5 240201502-05', '240201502', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (10, 'Evaluacion', '576887', 'RAT-6 240201502-06', '240201502', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (3, 'Analisis', '576887', 'RAE-31 220501035-01', '220501035', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (4, 'Planeacion', '576887', 'RAE-32 220501035-02', '220501035', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAE-33 220501035-03', '220501035', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (5, 'Planeacion', '576887', 'RAE-34 220501035-04', '220501035', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (11, 'Evaluacion', '576887', 'RAE-35 220501035-05', '220501035', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (11, 'Evaluacion', '576887', 'RAE-36 220501035-06', '220501035', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (3, 'Analisis', '576887', 'RAT-7', '240201501', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-7 240201502-07', '240201502', '228106', 'V102');
insert into eon.learning_result_has_activity (Activity_id_Activity, name_Phase, Project_Code, Learning_Result_Code, Competition_Code, Program_Code, Version) values (8, 'Ejecucion', '576887', 'RAT-8 240201502-08', '240201502', '228106', 'V102');


-- viewed Results
create table EON.Viewed_results(
number_Ficha varchar(60)comment 'Foreing Key of Is placed the ficha number',
quarter_Name varchar(20)comment 'Foreing Key of The name or number of the quarter',
acronyms_Working_Day varchar(20) comment 'Foreing Key of The are placed abbreviations of the days',
speciality_Name varchar(100) comment 'The name of the specialties',
Learning_Result_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Program_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Competition_Code varchar(50) comment 'Foreing Key of The code corresponding to the project',
Version varchar(50) comment'Foreing Key of The version that has a program',
constraint fk_vr_fht foreign key(number_Ficha, quarter_Name,acronyms_Working_Day,speciality_Name)references eon.ficha_has_trimester(number_Ficha,quarter_Name,acronyms_Working_Day,speciality_Name) ON UPDATE CASCADE,
constraint fk_vr_lr foreign key(Learning_Result_Code, Program_Code, Version, Competition_Code)references eon.Learning_Result(Code, Program_Code, Version, Competition_Code) ON UPDATE CASCADE,
primary key(number_Ficha, quarter_Name,acronyms_Working_Day,speciality_Name, Learning_Result_Code, Program_Code, Version, Competition_Code)
);
-- insert de Viewed Results
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAB-1', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-1 240201500-05', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAB-1 240201500-06', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-1 240201500-10', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAB-2', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAB-2 240201500-07', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-2 240201500-11', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-2 240201500-14', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-3 240201500-02', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAB-3 240201500-04', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAB-3 240201500-08', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-3 240201500-12', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAB-4 240201500-01', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAB-4 240201500-13', '228106', '240201500', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAE-1 220501006-01', '228106', '220501006', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAE-10 220501033-03', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAE-11 220501033-04', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAE-12 220501033-01', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAE-13 220501033-05', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAE-14 220501033-06', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAE-15 220501007-01', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAE-16 220501007-02', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAE-17 220501007-03', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAE-18 220501007-04', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAE-19 220501007-05', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAE-2 220501006-02', '228106', '220501006', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAE-20 220501007-06', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAE-21 220501007-07', '228106', '220501007', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAE-22 220501034-01', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAE-23 220501034-02 ', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAE-24 220501034-03', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAE-25 220501034-04', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAE-26 220501034-05', '228106', '220501034', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAE-27 220501009-01', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAE-28 220501009-02', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAE-29 220501009-03', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAE-3 220501006-03', '228106', '220501006', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAE-30 220501009-04', '228106', '220501009', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAE-31 220501035-01', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAE-32 220501035-02', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAE-33 220501035-03', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAE-34 220501035-04', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAE-35 220501035-05', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAE-36 220501035-06', '228106', '220501035', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAE-4 220501032-01', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAE-5 220501032-02', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAE-6 220501032-03', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAE-7 220501032-04', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAE-8 220501032-05', '228106', '220501032', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAE-9 220501033-02', '228106', '220501033', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAT-1 240201501-01', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAT-1 240201502-01', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 1, 'D', 'RAT-2 240201501-02', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAT-2 240201502-02', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 2, 'D', 'RAT-3 240201501-03', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAT-3 240201502-03', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 3, 'D', 'RAT-4 240201501-04', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAT-4 240201502-04', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 4, 'D', 'RAT-5', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAT-5 240201502-05', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAT-6', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 5, 'D', 'RAT-6 240201502-06', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAT-7', '228106', '240201501', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAT-7 240201502-07', '228106', '240201502', 'TeleInformatica', 'V102');
insert into eon.viewed_results (number_Ficha, quarter_Name, acronyms_Working_Day, Learning_Result_Code, Program_Code, Competition_Code, speciality_Name, Version) values ('1349397', 6, 'D', 'RAT-8 240201502-08', '228106', '240201502', 'TeleInformatica', 'V102');


-- Auditory Log
create table EON.Auditory_Log(
id_Log bigint(20) comment 'The id of the Auditory log',
Level varchar(15) comment 'The level of the Auditory log',
log_Name text comment 'The name of the Auditory log',
Message text comment 'The message for the Auditory log',
Date datetime comment 'The date fot the Auditory log',
User varchar(100) comment 'The user for the Auditory log',
primary key (id_Log)
);


-- Log Error
create table EON.Log_error(
id_Log bigint(20) comment 'The id of the Log error',
Level varchar(15) comment 'The level of the Log error',
log_Name varchar(256) comment 'The name of the Log error',
Message text comment 'The message Alert for the Log error',
Date datetime comment 'The date fot the Log error',
User varchar(100) comment 'The user for the Log error',
primary key (id_Log)
);


-- Mail Server
create table EON.Mail_Server(
Mail int comment 'The email that the user will enter',
Password varchar(30) comment 'Password to enter the user',
smtp_Host varchar(120) comment 'The host that will have the project',
smtp_Port int comment 'The port that will have the project',
smtp_Start_tls_enable boolean comment 'Enabling mail to be sent',
smtp_Auth boolean comment 'The auth that will have the project',
recovery_Case varchar(50) comment 'He subject that will have the message that will be sent to the user',
message_Recovery varchar(250)  comment 'The message of recovery that reaches the user if he loses the account',
primary key (Mail)
);


