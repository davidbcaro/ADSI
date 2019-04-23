create schema war;
create table war.project(
coding varchar(100)
);

alter table war.project add column name_project varchar(100) not null comment 'Nombre del proyecto';
alter table war.project add column state bool not null comment 'Estado del proyecto';
alter table war.project add primary key (coding);

create table war.phase(
name_phase varchar(20)
);

alter table war.phase add column project_code varchar(100) not null; 
alter table war.phase add column state bool;
alter table war.phase add constraint fk_pp_project foreign key (project_code) references war.project (coding);
alter table war.phase add index fk_pp_project_idx (project_code);
alter table war.phase add primary key (name_phase, project_code);

create table war.activity(
id_activity tinyint
);

alter table war.activity add column project_code varchar(100);

alter table war.activity add column name_activity varchar(100) not null comment 'Nombre de la actividad';
alter table war.activity add column name_phase varchar(20) not null;

alter table war.activity add constraint fk_activity_pp foreign key (name_phase, project_code) references war.phase(name_phase, project_code);
alter table war.activity add index fk_activity_pp_idx (name_phase, project_code);

alter table war.activity add primary key (id_activity, name_phase, project_code);


create table war.day(
name_day varchar(10)
);
alter table war.day add column state bool;
alter table war.day add primary key (name_day);

create table war.current_quarter(
id_current_quarter varchar(12) not null
);

alter table war.current_quarter add column start_date date;
alter table war.current_quarter add column end_date date;
alter table war.current_quarter add primary key (id_current_quarter);

create table war.headquarters(
name_headquarters varchar(100)
);
 
alter table war.headquarters add column address varchar(45) not null;
alter table war.headquarters add column state bool;
alter table war.headquarters add primary key (name_headquarters);

create table war.environment(
number_environment varchar(10),
description varchar(45),
state bool,
name_headquarters varchar(100)
);
alter table war.environment add constraint fk_headquarters_environment foreign key (name_headquarters) references war.headquarters(name_headquarters);
alter table war.environment add index fk_headquarters_environment_idx (name_headquarters);
alter table war.environment add primary key (number_environment,name_headquarters);




create table war.version_project(

id_version int

);

alter table war.version_project add column active bool;
alter table war.version_project add column id_current_quarter varchar(12) ;
alter table war.version_project add constraint fk_id_current_quarter foreign key (id_current_quarter) references war.current_quarter(id_current_quarter);
alter table war.version_project add index fk_id_current_quarter_idx (id_current_quarter);
alter table war.version_project add primary key (id_version, id_current_quarter );

create table war.modality(
name_modality varchar(20)
);

alter table war.modality add column active bool;
alter table war.modality add primary key (name_modality);


create table war.speciality(
name_speciality varchar(100)
);

alter table war.speciality add column state bool;
alter table war.speciality add primary key (name_speciality);

create table war.linking(

type_linking varchar(20)
);

alter table war.linking add column hours int not null;
alter table war.linking add column state bool not null;
alter table war.linking add primary key (type_linking);

create table war.state_number_group(
name_state varchar(10)
);

alter table war.state_number_group add column state bool;
alter table war.state_number_group add primary key (name_state);

create table war.working_day(
initials_working_day varchar(10) 
);

alter table war.working_day add column name varchar(45) not null;
alter table war.working_day add column description varchar(45);
alter table war.working_day add column image blob(100);
alter table war.working_day add column state bool;
alter table war.working_day add primary key (initials_working_day);

create table war.training_level(
training_level varchar(20)
);

alter table war.training_level add column state bool;
alter table war.training_level add primary key (training_level);

create table war.program(
code varchar(100),
training_level varchar(20)
);

alter table war.program add column name varchar(300) not null;
alter table war.program add column version varchar(10)not null;
alter table war.program add column initials varchar(10)not null;
alter table war.program add column state bool;

alter table war.program add constraint fk_program_tl foreign key (training_level) references war.training_level(training_level);
alter table war.program add primary key (code,version, training_level);

create table war.competition(
code varchar(100),
program_code varchar(100) not null,
program_version varchar(10) not null
);

alter table war.competition add constraint fk_program_c foreign key (program_code,program_version) references war.program(code,version);
alter table war.competition add index fk_program_c_idx (program_code,program_version);

alter table war.competition add column description varchar(100);
alter table war.competition add primary key (code,program_code,program_version);


create table war.role(
id_role varchar(20)

);

alter table war.role add column description_role varchar(100) not null;
alter table war.role add column state bool;
alter table war.role add primary key (id_role);

create table war.document(
id_document varchar(10) not null
);

alter table war.document add column name varchar(45) not null;
alter table war.document add column state bool;
alter table war.document add primary key (id_document);




create table war.client(
document_number varchar(20)
);


alter table war.client add column first_name varchar(20) not null ;
alter table war.client add column second_name varchar(20);
alter table war.client add column first_last_name varchar(20)not null;
alter table war.client add column second_Last_name varchar(20);
alter table war.client add column photo blob(10);
alter table war.client add column id_document varchar(10) not null;
alter table war.client add constraint fk_id_document foreign key (id_document) references war.document(id_document);
alter table war.client add index fk_id_document_idx (id_document);

alter table war.client add primary key (document_number,id_document);

create table war.role_has_client(
id_role varchar(20),
document_number varchar(20),
id_document varchar (10),
state bool
);

alter table war.role_has_client add constraint fk_rhc_role foreign key (id_role) references war.role(id_role);
alter table war.role_has_client add constraint fk_rhc_client foreign key (document_number,id_document) references war.client(id_document,document_number);
alter table war.role_has_client add index fk_rhc_role_idx (id_role);
alter table war.role_has_client add index fk_rhc_client_idx (document_number,id_Document);
alter table war.role_has_client add primary key (id_role,document_number,id_document);

create table war.user(
email varchar(50) not null,
password varchar(30) not null,
date_terminate varchar (45) not null,
document_number varchar(45),
id_document varchar(10)
);

alter table war.user add constraint fk_user_client foreign key (id_document,document_number) references war.Client(id_document,document_number);
alter table war.user add index fk_user_client_idx (id_document,document_number);
alter table war.user add primary key (id_document,document_number);






create table war.learning_outcome(
code varchar (100),
competition_code varchar(100) not null,
program_code varchar(100) not null,
program_version varchar(10)not null

);

alter table war.learning_outcome add column description varchar(300)not null;
alter table war.learning_outcome add constraint fk_lo_phc foreign key (competition_code,program_code,program_version) references war.competition(code,program_code,program_version);
alter table war.learning_outcome add index fk_lo_phc_idx(competition_code,program_code,program_version);
alter table war.learning_outcome add primary key (code,program_code,competition_code,program_version);


create table war.learning_outcome_has_activity(
outcome_code varchar(100),
program_code varchar(100),
competition_code varchar (100),
program_version varchar(10),
id_activity tinyint,
name_phase varchar(20),
project_code varchar(100)

);

alter table war.learning_outcome_has_activity add constraint fk_loha_lo foreign key (outcome_code,program_code,competition_code,program_version) references war.learning_outcome(code, program_code,competition_code,program_version);
alter table war.learning_outcome_has_activity add constraint fk_loha_activity foreign key (id_activity, name_phase, project_code) references war.activity(id_activity, name_phase, project_code);
alter table war.learning_outcome_has_activity add index fk_loha_lo_idx(outcome_code,program_code,competition_code,program_version);
alter table war.learning_outcome_has_activity add index fk_loha_activity_idx(id_activity,name_phase,project_code);
alter table war.learning_outcome_has_activity add primary key (outcome_code,program_code,competition_code,id_activity,name_phase,project_code,program_version);

create table war.trimester (
name_trimester varchar(20),
initials_working_day varchar(10),
training_level varchar (20)

);

alter table war.trimester add constraint fk_trimester_thlo foreign key (training_level) references war.training_level(training_level);
alter table war.trimester add index fk_trimester_thlo_idx(training_level);

alter table war.trimester add constraint fk_trimester_workingday foreign key (initials_working_day) references war.working_day(initials_working_day);
alter table war.trimester add index fk_trimester_workingday_idx(initials_working_day);

alter table war.trimester add primary key (name_trimester,initials_working_day,training_level);






create table war.teacher(
document_number varchar(20),
id_document varchar(10),
type_linking varchar(20),
name_speciality varchar(100)
);

alter table war.teacher add constraint fk_teacher_availability foreign key (document_number,id_document) references war.client(document_number,id_document);
alter table war.teacher add index fk_teacher_availability_idx(document_number,id_document);

alter table war.teacher add constraint fk_teacher_speciality foreign key (name_speciality) references war.speciality(name_speciality);
alter table war.teacher add index fk_teacher_speciality_idx(id_document,name_speciality);

alter table war.teacher add constraint fk_teacher_tl foreign key (type_linking) references war.linking(type_linking);
alter table war.teacher add index fk_teacher_tl_idx(type_linking);


alter table war.teacher add primary key (document_number,id_document);

create table war.availability(
start_time datetime,
end_time datetime,
working_day varchar(10),
document_number varchar(20),
id_document varchar(10),
name_day varchar(10)


);

alter table war.availability add constraint fk_availability_teacher foreign key (document_number,id_document) references war.teacher(document_number,id_document);
alter table war.availability add index fk_availability_teacher_idx(document_number,id_document);

alter table war.availability add constraint fk_availability_day foreign key (name_day) references war.day(name_day);
alter table war.availability add index fk_availability_day_idx(name_day);

alter table war.availability add constraint fk_availability_workingday foreign key (working_day) references war.working_day(initials_working_day);
alter table war.availability add index fk_availability_workingday_idx(working_day);

alter table  war.availability add primary key (document_number,id_document,name_day,working_day,start_time);






create table war.number_group (
number_group varchar (100),
start_date date not null,
end_date date not null,
route char(4) not null,
name_state varchar(10),
program_code varchar(100)
);

alter table war.number_group add constraint fk_numbergroup_program foreign key (program_code) references war.program(code);
alter table war.number_group add index fk_numbergroup_program_idx(program_code);

alter table war.number_group add constraint fk_numbergroup_sng foreign key (name_state) references war.state_number_group(name_state);
alter table war.number_group add index fk_numbergroup_sng_idx(name_state);

alter table war.number_group add primary key (number_group,program_code,name_state);

create table war.learning_outcome_has_trimester(

name_trimester varchar(20),
initials_working_day varchar(10),
learning_outcome_code varchar (100),
program_code varchar (100),
competition_code varchar (100),
program_version varchar(10),
training_level varchar(20)
);

alter table war.learning_outcome_has_trimester add constraint fk_thlo_lo foreign key (learning_outcome_code,program_code,competition_code,program_version) references war.learning_outcome(code,program_code,competition_code,program_version);
alter table war.learning_outcome_has_trimester add index fk_thlo_lo_idx(learning_outcome_code,program_code,competition_code,program_version);

alter table war.learning_outcome_has_trimester add constraint fk_thlo_trimester foreign key (name_trimester,initials_working_day,training_level) references war.trimester(name_trimester,initials_working_day,training_level);
alter table war.learning_outcome_has_trimester add index fk_thlo_trimester_idx(name_trimester,initials_working_day,training_level);

alter table war.learning_outcome_has_trimester add primary key (learning_outcome_code,program_code,competition_code,name_trimester,initials_working_day,program_version,training_level);








create table war.number_group_has_trimester(
number_group varchar(100),
name_trimester varchar(20),
initials_working_day varchar(10),
training_level varchar(20)

);

alter table war.number_group_has_trimester add column number_group_has_trimester varchar(45);

alter table war.number_group_has_trimester add constraint fk_nght_trimester foreign key (name_trimester,initials_working_day,training_level) references war.trimester(name_trimester,initials_working_day,training_level);
alter table war.number_group_has_trimester add index fk_nght_trimester_idx(name_trimester,initials_working_day,training_level);

alter table war.number_group_has_trimester add constraint fk_nght_numbergroup foreign key (number_group) references war.number_group(number_group);
alter table war.number_group_has_trimester add index fk_nght_numbergroup_idx(number_group);


alter table war.number_group_has_trimester add primary key (name_trimester,number_group,initials_working_day,training_level);


create table war.learning_outcome_has_number_group_has_trimester(
learning_outcome_code varchar(100) not null,
competition_code varchar(100) not null,
competition_program_code varchar(100) not null,
competition_program_version varchar(10) not null,
number_group varchar(100) not null,
name_trimester varchar(20) not null,
initials_working_day varchar(10) not null,
trimester_training_level varchar(20) not null
);

alter table war.learning_outcome_has_number_group_has_trimester add constraint fk_lo_lohnght foreign key (learning_outcome_code,competition_code,competition_program_code,competition_program_version) references war.learning_outcome(code,program_code,competition_code,program_version);
alter table war.learning_outcome_has_number_group_has_trimester add index fk_lo_lohnght_idx(learning_outcome_code,competition_code,competition_program_code,competition_program_version);


alter table war.learning_outcome_has_number_group_has_trimester add constraint fk_nght_lohnght foreign key (name_trimester,number_group,initials_working_day,trimester_training_level)references war.number_group_has_trimester(name_trimester,number_group,initials_working_day,training_level);
alter table war.learning_outcome_has_number_group_has_trimester add index fk_trimester_lohnght_idx(name_trimester,number_group,initials_working_day,trimester_training_level);

alter table war.learning_outcome_has_number_group_has_trimester add primary key (learning_outcome_code,competition_code,competition_program_code,competition_program_version,name_trimester,number_group,initials_working_day,trimester_training_level);








create table war.schedule(
start_time varchar(15) not null,
end_time varchar (15) not null,
final_schedule int not null,
name_trimester varchar(20)not null,
number_group varchar (100),
initials_working_day varchar(10),
document_number varchar (20),
id_document varchar(10),
day_name_day varchar(10) not null,
name_modality varchar(20) ,
number_environment varchar (10) not null,
name_headquarters varchar (100) not null,
id_version int not null,
id_current_quarter varchar(12) not null
);


alter table war.schedule add constraint fk_schedule_thng foreign key (name_trimester,initials_working_day,number_group) references war.number_group_has_trimester(name_trimester,number_group,initials_working_day);
alter table war.schedule add index fk_schedule_thng_idx(name_trimester,number_group,initials_working_day);

alter table war.schedule add constraint fk_schedule_namemodality foreign key (name_modality) references war.modality(name_modality) ;
alter table war.schedule add index fk_schedule_namemodality_idx(name_modality);

alter table war.schedule add constraint fk_schedule_day foreign key (day_name_day) references war.day(name_day);
alter table war.schedule add index fk_schedule_day_idx(day_name_day);

alter table war.schedule add constraint fk_schedule_version foreign key (id_version,id_current_quarter) references war.version_project(id_version, id_current_quarter);
alter table war.schedule add index fk_schedule_version_idx(id_version,id_current_quarter);

alter table war.schedule add constraint fk_schedule_enviromnent foreign key (number_environment,name_headquarters) references war.environment(number_environment,name_headquarters);
alter table war.schedule add index fk_schedule_enviromnent_idx(number_environment,name_headquarters);

alter table war.schedule add constraint fk_schedule_teacher foreign key (document_number,id_document) references war.teacher(document_number,id_document);
alter table war.schedule add index fk_schedule_teacher_idx(document_number,id_document);

alter table war.schedule add primary key (name_trimester,number_group,initials_working_day,document_number,id_document,day_name_day,number_environment,name_headquarters,id_version,id_current_quarter);

create table war.server_email(
email varchar(100),
password varchar(64),
smtp_host varchar(100),
smtp_port int,
smtp_start_tls_enable bool,
smtp_auth bool,
affair_recovery varchar(200)

);

































