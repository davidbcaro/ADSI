create schema wariosoft;


-- verde claro --

create table wariosoft.Document(

id_Document varchar(10) primary key comment 'Document Identification',
name varchar(45) not null comment 'Document Name',
state bool comment 'Document state, can be active and inactive'
);

create table wariosoft.Client(

document_Number varchar(20)comment 'Document Number',
id_Document varchar(10)comment 'Document Identification',
first_Name varchar(20) not null comment 'First name',
second_Name varchar(20)  comment 'Second name',
first_Lastname varchar(20) not null comment 'First lastname',
second_Lastname varchar(20) comment 'Second lastname',
photo blob(100) comment ' Client Photo',
primary key (id_Document, document_Number),
constraint fk_Client_Document foreign key (id_Document) references wariosoft.Document(id_Document) on update cascade,
index fk_Client_Document_idx(id_Document)
);

create table wariosoft.User(

email varchar(100) not null comment 'User Email foreing key',
password varchar(70) not null comment 'User Password',
date_Terminate varchar(45) not null comment 'Date Terminate',
id_Document varchar(10)comment 'Document Identification',
document_Number varchar(20)comment 'Document number',
primary key (id_Document, document_Number),
constraint fk_Client_User foreign key (id_Document, document_Number) references wariosoft.Client(id_Document, document_Number)on update cascade,
index fk_Client_User_idx(document_Number, id_Document)
);

create table wariosoft.Role(

id_Role varchar(20) primary key comment'Role Identification',
description_Role varchar(100) not null comment'Role Description',
state bool comment 'Rol State'
);

create table wariosoft.Role_has_Client(

id_Document varchar(10) comment 'Id role foreign key (role identifier) ​​It comes from the Role table',
document_Number varchar(20) comment'Document number from foreign key comes from the table Client (Client)',
id_Role varchar(20)comment'Role identification',
state bool comment'client state',
primary key (id_Document, document_Number,id_Role),
constraint fk_Role_RhC foreign key (id_Role) references wariosoft.Role(id_Role)on update cascade,
constraint fk_Role_RhasC foreign key (id_Document, document_Number) references wariosoft.Client(id_Document, document_Number)on update cascade,
index fk_Role_Role_has_Client_idx(id_Role, document_Number, id_Document)
);

create table wariosoft.Specialty(

name_Specialty varchar(100) primary key comment 'Name Specialty',
state bool not null comment 'State Specialty' 
);

create table wariosoft.Linking(

type_Linking varchar(20) primary key comment 'Type Linking',
hours int not null comment 'Hours of linking',
state bool not null comment 'State Kinking'
);

create table wariosoft.Teacher(

id_Document varchar(10) comment 'Customer document identifier (foreign key) This is from the Schedule table',
document_Number varchar(20) comment'Customer document number (foreign key) Comes from the Schedule table',
type_Linking varchar(20) not null comment 'Type Linking',
name_Specialty varchar(100) not null comment 'Name Specialty',
constraint fk_type_Linking foreign key (type_Linking) references wariosoft.Linking(type_Linking)on update cascade,
constraint fk_name_Specialty foreign key (name_Specialty) references wariosoft.Specialty(name_Specialty)on update cascade,
primary key (id_Document, document_Number),
constraint fk_Linking_Teacher foreign key (id_Document,  document_Number) references wariosoft.Client( id_Document, document_Number),
index  fk_Linking_Teacher_idx(id_Document,  document_Number),
index fk_type_Linking_idx(type_Linking),
index fk_name_Specialty_idx(name_Specialty)
);

create table wariosoft.Day(

name_Day varchar (10) primary key comment 'Name Day',
state bool comment 'State Day'
);

create table wariosoft.working_Day(

initials_Working_Day varchar(10) primary key comment 'Initials Working Day',
name varchar(45) not null comment 'Name of day',
description varchar (400) comment 'Description of day',
image blob comment 'Image of day',
state bool comment 'State of Day'
);

create table wariosoft.Availability(

start_Time time comment 'Availability start time',
end_Time time not null comment 'End time for availability',
initials_Working_Day varchar(10) comment 'Initials of the day of availability',
id_Document varchar(10) comment 'Customer Document Identifier Comes from the Instructor table',
document_Number varchar(20) comment'Customer Document Number Comes from the Instructor table',
name_Day varchar (10) comment 'Name day',
primary key (start_Time,id_Document, document_Number, name_Day, initials_Working_Day),
constraint fk_working_Day_Availability foreign key (initials_Working_Day) references wariosoft.working_Day(initials_Working_Day)on update cascade,
constraint fk_teacher_availability foreign key (id_Document, document_Number) references wariosoft.Teacher (id_Document, document_Number)on update cascade, 
constraint fk_day_availability foreign key (name_Day) references wariosoft.Day (name_Day)on update cascade,
index fk_working_Day_Availability_idx(initials_Working_Day),
index fk_teacher_availability_idx(id_Document, document_Number),
index fk_day_availability_idx(name_Day)
 
);

create table wariosoft.Modality(

name_Modality varchar(20) primary key comment'Name Modality',
state bool comment 'State Modality'
);

create table wariosoft.Current_Quarter(

id_Current_Quarter varchar(12) primary key comment'Current Quarter Identification',
start_Date date comment 'Start Date',
end_Date date comment 'End Date'
);

create table wariosoft.Version(

id_Version int comment'version identification',
active bool comment 'Active Version',
id_Current_Quarter varchar(12) comment'current quarter identification',
primary key (id_Version,id_Current_Quarter),
constraint fk_id_Current_Quarter_version foreign key (id_Current_Quarter) references wariosoft.Current_Quarter(id_Current_Quarter)on update cascade,
index  fk_id_Current_Quarter_version_idx(id_Current_Quarter)
);

create table wariosoft.Headquarters(

name_Headquarters varchar(100) primary key comment'Name Headquarters',
address varchar(45) not null comment 'Headquarters Address',
state bool comment 'State Headquartes'
);

create table wariosoft.Environment(

number_Environment varchar(100) comment'Number Environment',
description varchar(400) comment'Description Environment',
state bool comment 'State Environment',
name_Headquarters varchar(100) comment'Name of the seat of the ambiete (foreign key) It comes from the Timetable table',
primary key (number_Environment,name_Headquarters),
constraint fk_name_Headquarters_Enviroment foreign key (name_Headquarters) references wariosoft.Headquarters(name_Headquarters)on update cascade,
index fk_name_Headquarters_Enviroment_idx(name_Headquarters)
);

create table wariosoft.Training_Level(

training_Level varchar(20) primary key comment'Level of formation',
state bool not null comment 'State Training Level'
);

create table wariosoft.Trimester(

name_Trimester varchar(20) comment'Name Trimester',
training_Level varchar(20)comment'Training Level',
initials_Working_Day varchar(10) comment 'Iniciales de la jornada del trimestre(llave foranea) Proviene de la tabla Numero del grupo segun trimestre',
primary key (name_Trimester,initials_Working_Day,training_Level),
constraint fk_working_Day_Trimester foreign key (initials_Working_Day) references wariosoft.working_Day(initials_Working_Day)on update cascade,
constraint fk_Training_Level_Trimester foreign key (training_Level) references wariosoft.Training_Level(training_Level)on update cascade,
index fk_working_Day_Trimester_idx(initials_Working_Day),
index fk_Training_Level_Trimester_idx(training_Level)
);

create table wariosoft.Project(

project_Code varchar(100) primary key comment 'Project Code',
name_project varchar(100) not null comment 'Name Project',
state bool not null comment 'State Project'
);

create table wariosoft.Phase(

name_Phase varchar(20) comment 'Name Phase',
state bool comment 'State Phase',
project_Code varchar(100) comment 'Project code of the phase (foreign key) It comes from the project table',
primary key (name_Phase,project_Code),
constraint fk_Project_Phase foreign key (project_Code) references wariosoft.Project(project_Code)on update cascade,
index fk_Project_Phase_idx(project_Code)
);

create table wariosoft.Activity(

id_Activity int comment 'Identification Activity',
name_activity varchar(400) not null comment 'Name Activity',
name_Phase varchar (20) comment 'Name of the phase of the activity (foreign key) It comes from the phase table',
project_Code varchar (100) comment 'Project Code',
primary key (id_Activity, name_Phase,project_Code),
constraint fk_Phase_Activity foreign key (name_Phase,project_Code) references wariosoft.Phase(name_Phase,project_Code)on update cascade,
index fk_Phase_Activity_idx(name_Phase,project_Code)
);

create table wariosoft.Program(

program_Code varchar (100) comment 'Program Code',
name varchar(100) not null comment 'Name Program',
version varchar(20) not null comment 'Program version',
initials varchar (20) not null comment 'Program Initials',
state bool comment 'Program State',
training_Level varchar(20) comment 'Training Level' not null,
primary key (program_Code,version),
constraint fk_tl_p foreign key (training_Level) references wariosoft.Training_Level(training_Level)on update cascade,
index fk_tl_p_idx(training_Level)
);

create table wariosoft.Competition(

competition_Code varchar(100) comment 'Competition code',
description varchar(800) not null comment 'Description of the competition',
program_Code varchar (100) comment 'Program Code',
version varchar(20) not null comment 'Program version',
primary key (competition_Code,program_Code,version),
constraint fk_Program_Competition foreign key (  program_Code, version) references wariosoft.Program( program_Code, version)on update cascade,
index fk_Program_Competition_idx( program_Code, version)

);

create table wariosoft.Learning_Outcome(

learning_Outcome_Code varchar(100) comment 'Learning outcome code',
description varchar(350) not null comment 'Description of learning outcomes',
competition_Code varchar(100) comment 'Code of competence of the Program (foreign key) Privilege of the table Program according to competition',
program_Code varchar(100) comment 'Code of the program of the competition (foreign key) Privilege of the table Program according to competition',
version varchar(20) not null comment 'Program version',
primary key(learning_Outcome_Code,competition_Code,program_Code,version),
constraint fk_Competition_Learning_Outcome foreign key (competition_Code,program_Code, version) references wariosoft.Competition(competition_Code,program_Code, version)on update cascade,
index fk_Competition_Learning_Outcome_idx(competition_Code,program_Code, version)

);

create table wariosoft.Learning_Outcome_has_Trimester(

name_Trimester varchar(20) comment 'Name of the quarter foreign key',
initials_Working_Day varchar(10) comment 'initials of the day corresponding to the foreign key quarter',
learning_Outcome_Code varchar(100) comment 'Code of the learning result foreign key.',
program_Code varchar(100) comment 'Competency program code corresponding to the foreign key learning result.',
competition_Code varchar(100) comment 'Code of the competition of the program corresponding to the result of apendizaje foreign key.',
version varchar(20) not null comment 'Program version',
training_Level varchar(20) comment 'Training Level',
primary key(name_Trimester,initials_Working_Day,training_Level,learning_Outcome_Code,competition_Code,program_Code,version),
constraint fk_L_O_L_O_has_Trimester foreign key (learning_Outcome_Code, competition_Code, program_Code, version) references wariosoft.Learning_Outcome(learning_Outcome_Code, competition_Code, program_Code, version)on update cascade,
constraint fk_Trimester_L_O_has_Trimester foreign key (name_Trimester, initials_Working_Day, training_Level) references wariosoft.Trimester(name_Trimester, initials_Working_Day, training_Level)on update cascade,
index fk_L_O_L_O_has_Trimester_idx (learning_Outcome_Code, competition_Code, program_Code, version),
index fk_Trimester_L_O_has_Trimester_idx (name_Trimester, initials_Working_Day, training_Level)
);

create table wariosoft.State_Number_Group(

name_State varchar(20) primary key comment 'Name of the status of the card',
state bool not null comment 'Status of the card'


);

create table wariosoft.Number_Group(

number_Group varchar(100) comment 'Number of the card',
start_Date date not null comment 'Start date of the card',
end_Date date not null comment 'End date of the card',
route varchar(4) not null comment 'Route of the card',
name_State varchar(100) not null comment 'Name of the status of the card',
program_Code varchar(100) not null comment 'Program code',
version varchar(20) not null comment 'Program version',
constraint fk_Program_Number_Group foreign key(program_Code, version) references wariosoft.Program (program_Code, version)on update cascade,
constraint fk_S_Number_Group_Number_Group foreign key (name_State) references wariosoft.State_Number_Group(name_State)on update cascade,
primary key (number_Group),
index fk_Program_Number_Group_idx(program_Code, version),
index fk_S_Number_Group_Number_Group_idx(name_State)

);

create table wariosoft.Number_Group_has_Trimester(

number_Group varchar(100) comment 'Number of the card (foreign key) It comes from the table Number of group',
name_Trimester varchar(20) comment 'Name of the quarter (foreign key) It comes from the quarter table',
initials_Working_Day varchar(10) comment 'Initials of the quarter (foreign key) It comes from the quarter table',
training_Level varchar(20) comment 'Training Level',
primary key(number_Group,name_Trimester,initials_Working_Day,training_Level),
constraint fk_Number_Group_N_G_has_T foreign key (number_Group) references wariosoft.Number_Group (number_Group)on update cascade,
constraint fk_Trimester_N_G_has_T foreign key (name_Trimester,initials_Working_Day,training_Level) references wariosoft.Trimester (name_Trimester,initials_Working_Day,training_Level)on update cascade,
index fk_Number_Group_N_G_has_T_idx(number_Group),
index fk_Trimester_N_G_has_T_idx(name_Trimester,initials_Working_Day,training_Level)
);

create table wariosoft.results_viewed(

learning_Outcome_Code varchar(100) comment 'Learning result code (foreign key) It comes from the Learning result table',
program_Code varchar(100) comment 'Code of the program of the competition according to the program of the result of learning (foreign key) It comes from the Table Result of learning',
competition_Code varchar(100) comment 'Code of the programs competence according to the learning result (foreign key) It comes from the table Result of learning',
name_Trimester varchar(20) comment 'Name of the quarter according to the number of the group (foreign key) It comes from the table Number of the group according to quarter',
number_Group varchar(100) comment 'Number of the quarter group (Foreign key) It comes from the table Number of the group according to quarter',
initials_Working_Day varchar(10) comment 'Initials of the quarter day (Foreign key) It comes from the table Number of the group according to quarter',
version varchar(20) not null comment 'Program version',
training_Level varchar(20) comment 'Training Level',
primary key(learning_Outcome_Code,competition_Code,program_Code,version,number_Group,name_Trimester,initials_Working_Day,training_Level),
constraint fk_Learning_Outcome_L_Outcome_has_N_G_has_Trimester foreign key(learning_Outcome_Code,competition_Code,program_Code,version) references wariosoft.Learning_Outcome(learning_Outcome_Code,competition_Code,program_Code,version)on update cascade,
constraint fk_Trimester_L_Outcome_has_N_G_has_Trimester foreign key (number_Group,name_Trimester,initials_Working_Day,training_Level) references wariosoft.Number_Group_has_Trimester(number_Group,name_Trimester,initials_Working_Day,training_Level)on update cascade,
index fk_Learning_Outcome_L_Outcome_has_N_G_has_Trimester_idx(learning_Outcome_Code,competition_Code,program_Code,version),
index fk_Trimester_L_Outcome_has_N_G_has_Trimester_idx(number_Group,name_Trimester,initials_Working_Day,training_Level)
);

create table wariosoft.Learning_Outcome_has_Activity(

learning_Outcome_Code varchar(100) comment 'Learning result code (foreign key) It comes from the learning result table',
program_Code varchar(100) comment 'Learning outcome competency program code (foreign key) It comes from the learning result table',
competition_Code varchar(100) comment 'Competition code according to the learning outcome program (foreign key) It comes from the learning result table',
id_Activity int comment 'Activity ID (foreign key) It comes from the Activity table',
name_Phase varchar(20) comment 'Name of the phase of the activity (Foreign Key) It comes from the Activity table',
project_Code varchar(100) comment 'Phase project code (foreign key) It comes from the Activity table',
version varchar(20) not null comment 'Program version',
primary key(learning_Outcome_Code,competition_Code,program_Code,version,id_Activity, name_Phase,project_Code),
constraint fk_Learning_Outcome_L_O_has_A foreign key (learning_Outcome_Code,competition_Code,program_Code, version) references wariosoft.Learning_Outcome(learning_Outcome_Code,competition_Code,program_Code, version)on update cascade,
constraint fk_Activity_L_O_has_A foreign key (id_Activity, name_Phase,project_Code) references wariosoft.Activity(id_Activity, name_Phase,project_Code)on update cascade,
index fk_Learning_Outcome_L_O_has_A_idx(learning_Outcome_Code,competition_Code,program_Code, version),
index fk_Activity_L_O_has_A_idx(id_Activity, name_Phase,project_Code)
);

create table wariosoft.Schedule(

start_Time varchar(15) not null comment 'Start Time',
end_Time varchar(15) not null comment 'End time of the schedule',
name_Trimester varchar(20) comment 'Name of the quarter of the group number (foreign key) It comes from the table learning result has activity',
number_Group varchar(100) comment 'Number of the quarter group (foreign key) It comes from the table learning result has activity',
initials_Working_Day varchar(10) comment 'Beginning of the day of the group quarter (foreign key) It comes from the table learning result has activity',
document_Number varchar(20) comment 'Client document number (foreign key) From the Instructor table',
id_Document varchar(10) comment 'Customer document identifier (foreign key) From the Instructor table',
name_Day varchar(10) comment 'Name of the day (foreign key) It comes from the table Day',
name_Modality varchar(20) comment 'Mode name (foreign field)',
number_Environment varchar(100) comment 'Name of the environment (foreign key) It comes from the Environment table',
name_Headquarters varchar(100) comment 'Name of the seat of the environment (foreign key) It comes from the Environment table',
id_Version int comment 'Time version identifier Comes from the Version table',
id_Current_Quarter varchar(20) comment 'Identifier of the current quarter of the schedule version (foreign key) It comes from the Version table',
training_Level varchar(20) comment 'Training Level',
primary key(id_Document, document_Number,number_Environment,name_Headquarters,id_Version,id_Current_Quarter,name_Day,number_Group,name_Trimester,initials_Working_Day,training_Level),
constraint fk_Teacher_Schedule foreign key (id_Document, document_Number) references wariosoft.Teacher (id_Document, document_Number)on update cascade,
constraint fk_Modality_Schedule foreign key(name_Modality) references wariosoft.Modality (name_Modality)on update cascade,
constraint fk_Environment_Schedule foreign key (number_Environment,name_Headquarters) references wariosoft.Environment (number_Environment,name_Headquarters)on update cascade,
constraint fk_Version_Schedule foreign key (id_Version,id_Current_Quarter) references wariosoft.Version (id_Version,id_Current_Quarter)on update cascade,
constraint fk_Day_Schedule foreign key(name_Day) references wariosoft.Day(name_Day)on update cascade,
constraint fk_Number_Group_has_Trimester_Schedule foreign key(number_Group,name_Trimester,initials_Working_Day,training_Level) references wariosoft.Number_Group_has_Trimester (number_Group,name_Trimester,initials_Working_Day,training_Level)on update cascade,
index fk_Teacher_Schedule_idx(id_Document, document_Number),
index fk_Modality_Schedule_idx(name_Modality),
index fk_Environment_Schedule_idx(number_Environment,name_Headquarters),
index fk_Version_Schedule_idx(id_Version,id_Current_Quarter),
index fk_Day_Schedule_idx(name_Day),
index fk_Number_Group_has_Trimester_Schedule_idx(number_Group,name_Trimester,initials_Working_Day,training_Level)




);


create table wariosoft.Server_Email(
email varchar(100) primary key comment 'User email',
password varchar(64) not null comment 'User password',
smtp_host varchar(100) not null comment '',
smtp_Port int not null comment '',
smtp_Start_Tls_Enable bool not null comment '',
smtp_Auth bool not null comment '',
affair_Recovery varchar(200) comment '',
recovery_Case varchar(50) comment ''
);

create table wariosoft.Log_Error(
id_Log bigint(20) primary key comment '',
level varchar(15) null comment '',
log_Name varchar(256) null comment '',
message text null comment '',
date datetime null comment '',
user varchar(100) null comment ''
);

create table wariosoft.Log_Audit(
id_Log bigint(20) primary key comment '',
level varchar(15) null comment '',
log_Name varchar(256) null comment '',
message text null comment '',
date datetime null comment '',
user varchar(100) null comment ''
);

