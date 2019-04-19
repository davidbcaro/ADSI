create database JOYCD character set utf8 ;

Create table JOYCD.project(
code_project varchar(100),
name_project varchar (200),
status_project boolean
);
alter table JOYCD.project add primary key (code_project) comment 'Project code number';
alter table JOYCD.project modify name_project varchar (200) not null comment 'The name of the training group project';
alter table JOYCD.project modify status_project boolean not null comment 'Active or inactive';

create table JOYCD.phase_project(
name_phase varchar (20),
status_phase boolean,
project_code varchar(100)
);
alter table JOYCD.phase_project add primary key (name_phase, project_code) comment 'The phase will be entered either: The names of the phases Evaluation, analysis, execution, planning. ';
alter table JOYCD.phase_project modify status_phase varchar (20)  comment 'Active or inactive';
alter table JOYCD.phase_project add constraint fk_phase_project foreign key (project_code)  references JOYCD.project(code_project) on update cascade; 
alter table JOYCD.phase_project add index fk_phase_project_idx (project_code);

create table JOYCD.activity(
id_activity varchar (20),
name_activity varchar(350),
name_phase varchar(20),
Project_code varchar(20)
);
alter table joycd.activity add primary key (id_activity, name_phase, project_code) comment 'The id (RAE) of the proposed activity is added to the training group.';
alter table joycd.activity modify name_activity varchar (350) comment 'Name of the activity proposed by the instructor to the training group';
alter table joycd.activity add constraint fk_activity_phase foreign key (name_phase, Project_code ) references JOYCD.phase_project(name_phase, Project_code) on update cascade;
alter table JOYCD.activity add index fk_activity_phase_idx (name_phase, Project_code);
 
 create table JOYCD.level_formation(
level_formation varchar(20),
status boolean
);
 alter table JOYCD.level_formation add primary key (level_formation) comment'Technician and technologist or technological specialization';
 alter table JOYCD.level_formation modify status boolean not null comment'active or inactive';
 
create table JOYCD.program(
program_code varchar (100), 
name varchar (100),
version varchar (20),
initials varchar(45),
status boolean,
level_formation varchar (20)
);
alter table JOYCD.program add primary key (program_code ,version)comment 'Program_Code';
alter table JOYCD.program modify name varchar (100) not null comment 'The name of the program will be added (Development Analysis of training systems)';
alter table JOYCD.program modify version varchar(20) not null comment'The proposed activities will be put in place during the quarter';
alter table JOYCD.program modify initials varchar (45) not null comment'The initials of the training program (ADSI, DIM, ETC)';
alter table JOYCD.program modify status boolean not null comment'Active or inactive';
alter table JOYCD.program modify level_formation varchar (20) not null comment 'Technician and technologist or technological specialization';
alter table JOYCD.program add constraint fk_program_level_formation foreign key (level_formation) references JOYCD.level_formation(level_formation) on update cascade;
alter table JOYCD.program add index fk_program_level_formation_idx (level_formation);

create table JOYCD.competence(
competence_code varchar (100),
description varchar(200),
program_code varchar(100),
version varchar(20)
);
 alter table JOYCD.competence add primary key (competence_code, program_code, version) comment 'Competition code. Ex .: (220501032)';
 alter table JOYCD.competence modify description varchar (200) not null comment 'The corresponding competition will be described';
alter table JOYCD.competence add constraint fk_phc_program foreign key (program_code,version) references JOYCD.program (program_code,version) on update cascade;
alter table JOYCD.competence add index fk_phc_program_idx (program_code);
	
create table JOYCD.learning_result(
learning_result_code varchar (100),
description Varchar(350),
Program_code varchar(100),
competence_code varchar(100),
version varchar(20)
);
alter table JOYCD.learning_Result add primary key (learning_result_code, Program_code, competence_code,version)comment 'Learning outcome code';
alter table JOYCD.learning_Result modify description varchar (350) not null comment 'The assigned learning result will be described.';
alter table JOYCD.learning_Result add constraint fk_lr_phc foreign key (program_code,competence_code, version ) references JOYCD.competence(program_code,competence_code,version) on update cascade;
alter table JOYCD.learning_Result add index fk_lr_c_idx (program_code);


create table JOYCD.learning_result_has_activity(
learning_result_code varchar(100),
competence_code varchar(100),
program_code varchar(100),
id_activity varchar(20),
name_phase varchar(20),
project_code varchar(100),
version varchar (20)
);
alter table JOYCD.learning_result_has_activity add primary key (learning_result_code,program_code,competence_code,id_activity,name_phase,project_code);
alter table JOYCD.learning_result_has_activity add constraint fk_lrha_lr foreign key (learning_result_code, program_code,competence_code, version) references JOYCD.learning_result(learning_result_code, program_code, competence_code ,version) on update cascade;
alter table JOYCD.learning_result_has_activity add index fk_lrha_lr_idx (learning_result_code, program_code,competence_code);
alter table JOYCD.learning_result_has_activity add constraint fk_lrha_a foreign key (id_activity, name_phase, project_code) references JOYCD.activity (id_activity, name_phase, project_code) on update cascade;
alter table JOYCD.learning_result_has_activity add index fk_lrha_a_idx (id_activity, name_phase, project_code);

create table  JOYCD.status_group_number(
status_name varchar(20),
status boolean 
);
alter table JOYCD.status_group_number add primary key (status_name);
alter table JOYCD.status_group_number modify status boolean not null comment 'It will be placed if the tab is Deferred, Merger, Bid, Finished, Start Date, End Date, Training Group Code, canceled or terminated.';

create table  JOYCD.group_number(
groups_number varchar(20),
start_date datetime,
finish_date datetime,
route char(4),
program_code varchar (100),
version_code varchar(100),
status_group_number varchar(20)
);
alter table JOYCD.group_number add primary key (groups_number);
alter table JOYCD.group_number modify program_code varchar (100) not null comment 'Program_Code (foreign)' ;
alter table JOYCD.group_number modify version_code varchar (100) not null comment 'version_code (foreign)' ;
alter table JOYCD.group_number add constraint fk_gn_p foreign key (program_code, version_code) references JOYCD.program(program_code, version) on update cascade;
alter table JOYCD.group_number add index fk_gn_p_idx (program_code, version_code);
alter table JOYCD.group_number modify status_group_number varchar(20) not null comment 'State_Group_Number_State_Name (Foreign program_code)' ;
alter table JOYCD.group_number add constraint fk_gn_sgn foreign key (status_group_number) references JOYCD.status_group_number(status_name) on update cascade;
alter table JOYCD.group_number add index fk_gn_sgn_idx (status_group_number);

create table  JOYCD.working_day(
initials varchar(10),
name varchar(45),
description varchar (150),
picture blob,
status boolean
);
alter table JOYCD.working_day add primary key (initials);
alter table JOYCD.working_day modify name varchar (45) not null comment 'Name of the day (Nocturna, Diurna etc.)';
alter table JOYCD.working_day modify description varchar (150) not null comment 'The specified day will be described. Nightly: 6 to 10 pm Daytime: 12 to 6 pm)';
alter table JOYCD.working_day modify picture blob comment 'The picture that will describe the day.';
alter table JOYCD.working_day modify status boolean not null comment 'Active or inactive';

create table  JOYCD.trimester(
trimester_name varchar(15),
working_day_initials varchar(10),
level_formation varchar(20)

);
alter table JOYCD.trimester add primary key (trimester_name, working_day_initials, level_formation);
alter table JOYCD.trimester add constraint fk_trim_wd foreign key (working_day_initials) references JOYCD.working_day(initials) on update cascade;
alter table JOYCD.trimester add index fk_trim_wd_idx (working_day_initials);
alter table JOYCD.trimester add constraint fk_trim_lf foreign key (level_formation) references JOYCD.level_formation(level_formation) on update cascade;
alter table JOYCD.trimester add index fk_trim_lf_idx (level_formation);

create table  JOYCD.role(
id_role varchar(20),
description varchar(200),
status boolean
);
alter table JOYCD.role add primary key(id_role);
alter table  JOYCD.role modify description varchar(200) not null comment '[The assigned role description will be entered.]';
alter table  JOYCD.role modify status boolean not null comment '[It will be added if the status is active or inactive.]';


create table  JOYCD.identification_card(
id_identification_card_number varchar(15),
name varchar(45),
status boolean
);
 alter table JOYCD.identification_card add primary key (id_identification_card_number);
 alter table JOYCD.identification_card modify name varchar (45) not null comment'[The name of the persons document. (ID card, identity card, etc.)]';
 alter table JOYCD.identification_card modify status boolean comment '[It will be added if the status is active or inactive.]';


create table  JOYCD.customer(
document_type varchar(25),
first_name varchar(45),
second_name varchar(45),
first_last_name varchar(45),
second_last_name varchar(45),
photo blob,
identification_card_number varchar (15)
);
alter table JOYCD.customer add primary key (document_type , identification_card_number);
alter table JOYCD.customer modify first_name varchar (45) not null comment '[The first name of the person will be added.]';
alter table JOYCD.customer modify second_name varchar (45) comment '[The second name of the person will be added.]';
alter table JOYCD.customer modify first_last_name varchar(45) not null comment'[The first last name of the person will be added.]';
alter table JOYCD.customer modify second_last_name varchar (45) comment'[The second last name of the person will be added.]';
alter table JOYCD.customer modify photo blob comment'	[You will find the photo of the person.]';
alter table JOYCD.customer add constraint fk_person_id_card foreign key (identification_card_number) references JOYCD.identification_card(id_identification_card_number) on update cascade;
alter table JOYCD.customer add index fk_person_id_card_idx (identification_card_number);

create table  JOYCD.speciality(
name_speciality varchar(45),
status boolean
);
alter table JOYCD.speciality add primary key (name_speciality);
alter table JOYCD.speciality modify status boolean comment'It will be placed if the tab is Deferred, Merger, Bid, Finished, Start Date, End Date, Training Group Code, canceled or terminated.';

create table  JOYCD.bonding(
type_bonding varchar(20),
hours int,
status int
);
alter table JOYCD.bonding add primary key (type_bonding);
alter table JOYCD.bonding modify hours int not null comment '	[Number of hours for each type of link.]';
alter table JOYCD.bonding modify status boolean not null comment'[Active or inactive.]';

create table  JOYCD.instructor(
document_type varchar(25),
identification_card varchar(10),
type_bonding varchar(20),
name_speciality varchar(45)
);
alter table JOYCD.instructor add primary key (document_type, identification_card);
alter table JOYCD.instructor add constraint fk_ins_customer foreign key (document_type, identification_card) references JOYCD.customer(document_type, identification_card_number) on update cascade; 
alter table JOYCD.instructor add index fk_ins_customer_idx (document_type, identification_card);
alter table JOYCD.instructor modify type_bonding varchar(20) not null comment '[Half time, full time and plant.]' ;
alter table JOYCD.instructor add constraint fk_ins_bonding foreign key (type_bonding) references JOYCD.bonding(type_bonding) on update cascade;
alter table JOYCD.instructor add index fk_ins_bonding_idx (type_bonding);
alter table JOYCD.instructor modify name_speciality varchar(45) not null comment '	[It will put the name of the specialty.]' ;
alter table JOYCD.instructor add constraint fk_ins_speciality foreign key (name_speciality) references JOYCD.speciality(name_speciality) on update cascade;
alter table JOYCD.instructor add index fk_ins_speciality_idx (name_speciality);

create table  JOYCD.day(
name_day varchar (10),
status boolean
);
alter table JOYCD.day add primary key (name_day);
alter table JOYCD.day modify status boolean not null comment 'Active or inactive';

create table  JOYCD.availability(
hour_start time,
hour_end time,
document_type varchar(25),
identification_card varchar(10),
name_day varchar (10),
working_day_initials varchar(10)
);
alter table JOYCD.availability add primary key (hour_start, document_type, identification_card, name_day, working_day_initials );
alter table JOYCD.availability modify hour_end time comment'	[The final time that the user will have.]';
alter table JOYCD.availability add constraint fk_avl_ins foreign key (document_type, identification_card) references JOYCD.instructor(document_type, identification_card) on update cascade;
alter table JOYCD.availability add index fk_avl_ins_idx (document_type, identification_card);
alter table JOYCD.availability add constraint fk_avl_day foreign key (name_day) references JOYCD.day (name_day) on update cascade;
alter table JOYCD.availability add index fk_avl_day_idx (name_day);
alter table JOYCD.availability add constraint fk_avl_wd foreign key (working_day_initials)  references JOYCD.working_day(initials) on update cascade;
alter table JOYCD.availability add index fk_avl_wd_idx (working_day_initials);

create table  JOYCD.actuality_trimester(
actuality_trimester varchar(12),
date_start date,
date_finish date
);
alter table JOYCD.actuality_trimester add primary key (actuality_trimester);
alter table JOYCD.actuality_trimester modify date_start date not null comment 'Start date at which the current quarter was started';
alter table JOYCD.actuality_trimester modify date_finish date not null comment 'End date that will have the current quarter.';

create table  JOYCD.modality(
name_modality varchar(100),
status boolean
);
alter table JOYCD.modality add primary key (name_modality);
alter table JOYCD.modality modify status boolean not null comment '	Active or inactive';

create table  JOYCD.headquarters(
name_headquarters varchar(100),
direction varchar(45),
status boolean
);
alter table JOYCD.headquarters add primary key (name_headquarters);
alter table JOYCD.headquarters modify direction varchar(45) not null comment'[It will add the number of the address in which the seat is located.]';
alter table JOYCD.headquarters modify status boolean comment 'Enabled or disabled';

create table  JOYCD.environment(
number_environment varchar(45),
description varchar(150),
status boolean,
headquarters_name varchar (100)
);
alter table JOYCD.environment add primary key (number_environment, headquarters_name);
alter table JOYCD.environment modify description varchar (150) comment '	Describes all things within the environment.';
alter table JOYCD.environment modify status boolean comment 'Enabled or disabled';
alter table JOYCD.environment add constraint fk_headquarters_name_e foreign key (headquarters_name) references JOYCD.headquarters(name_headquarters) on update cascade;
alter table JOYCD.environment add index fk_headquarters_name_e_idx (headquarters_name);

create table JOYCD.group_number_has_trimester(
groups_number varchar(20),
trimester_name varchar(15),
working_day_initials varchar(10),
level_formation varchar (20)
);
alter table JOYCD.group_number_has_trimester add primary key (groups_number,trimester_name, working_day_initials, level_formation);
alter table JOYCD.group_number_has_trimester add constraint fk_gnht_tri foreign key (trimester_name, working_day_initials, level_formation) references JOYCD.trimester(trimester_name,working_day_initials,level_formation) on update cascade; 
alter table JOYCD.group_number_has_trimester add index  fk_gnht_tri_idx (trimester_name, working_day_initials, level_formation);
alter table JOYCD.group_number_has_trimester add constraint fk_gnht_gn foreign key (groups_number) references JOYCD.group_number(groups_number) on update cascade;
alter table JOYCD.group_number_has_trimester add index  fk_gnht_gn_idx (groups_number);

create table JOYCD.group_number_has_trimester_has_learning_result(
group_number varchar (20),
trimester_name varchar(15),
working_day_initials varchar(10),
learning_result_code varchar(100),
program_code varchar(100),
competence_code varchar (100),
level_formation varchar(20),
version varchar(20)
);
alter table JOYCD.group_number_has_trimester_has_learning_result add primary key (group_number,trimester_name, working_day_initials, level_formation,learning_result_code,program_code ,competence_code, version);
alter table JOYCD.group_number_has_trimester_has_learning_result add constraint fk_gnhthlr_gnht foreign key (group_number,trimester_name, working_day_initials, level_formation) references JOYCD.group_number_has_trimester (groups_number,trimester_name, working_day_initials, level_formation) on update cascade;
alter table JOYCD.group_number_has_trimester_has_learning_result add index fk_gnhthlr_gnht_idx (group_number,trimester_name, working_day_initials, level_formation);
alter table JOYCD.group_number_has_trimester_has_learning_result add constraint fk_gnhthlr_lr foreign key (learning_result_code,program_code ,competence_code, version) references JOYCD.learning_result (learning_result_code, Program_code, competence_code, version) on update cascade; 
alter table JOYCD.group_number_has_trimester_has_learning_result add index  fk_gnhthlr_lr_idx (learning_result_code,program_code ,competence_code, version);

create table JOYCD.trimester_has_learning_result(
trimester_name varchar(15),
working_day_initials varchar(10),
learning_result_code varchar(100),
program_code varchar(100),
competence_code varchar (100),
level_formation varchar(20),
version varchar(20)
);
alter table  JOYCD.trimester_has_learning_result add primary key (trimester_name, working_day_initials, learning_result_code, program_code, competence_code, level_formation,version);
alter table  JOYCD.trimester_has_learning_result add constraint fk_trimhlr_trim foreign key (trimester_name, working_day_initials, level_formation) references JOYCD.trimester (trimester_name, working_day_initials, level_formation) on update cascade; 
alter table JOYCD.trimester_has_learning_result add index fk_trimhlr_trim_idx (trimester_name, working_day_initials, level_formation);
alter table  JOYCD.trimester_has_learning_result add constraint fk_trimhlr_lr foreign key (learning_result_code, Program_code, competence_code, version) references JOYCD.learning_result (learning_result_code, Program_code, competence_code, version) on update cascade;
alter table JOYCD.trimester_has_learning_result add index fk_trimhlr_lr_idx (learning_result_code, Program_code, competence_code, version);

create table JOYCD.customer_has_role(
person_document_type varchar(25),
identification_card_number varchar(10),
id_role varchar(20)
);
alter table JOYCD.customer_has_role add primary key (person_document_type, identification_card_number,id_role );
alter table JOYCD.customer_has_role add constraint fk_phr_role foreign key (id_role) references JOYCD.role(id_role);
alter table JOYCD.customer_has_role add index fk_phr_role_idx (id_role);
alter table JOYCD.customer_has_role add constraint fk_phr_per foreign key (person_document_type,identification_card_number) references JOYCD.customer (document_type, identification_card_number) on update cascade;
alter table JOYCD.customer_has_role add index fk_phr_per_idx (person_document_type,identification_card_number);

create table JOYCD.version_schedule(
version int,
status_version boolean,
actuality_trimester varchar(12)
);
alter table JOYCD.version_schedule add primary key (version, actuality_trimester);
alter table JOYCD.version_schedule modify status_version boolean not null comment 'Version(1.1 1.2 2.1 2.2 ) etc' ;
alter table JOYCD.version_schedule add constraint fk_vs_at foreign key (actuality_trimester) references JOYCD.actuality_trimester(actuality_trimester) on update cascade;
alter table JOYCD.version_schedule add index fk_vs_at_idx (actuality_trimester);

create table JOYCD.user(
email varchar(45),
password varchar(100),
document_type varchar(25), 
identification_card_number varchar(10)
);
alter table JOYCD.user add primary key (document_type, identification_card_number);
alter table JOYCD.user modify email varchar (45) not null comment '[The users mail will be put.]';
alter table JOYCD.user modify password varchar(100) not null comment'[The password of the user.]';
alter table JOYCD.user add constraint fk_user_customer foreign key (document_type,identification_card_number) references JOYCD.customer(document_type , identification_card_number) on update cascade;
alter table JOYCD.user add index fk_user_customer_idx (document_type,identification_card_number);

create table JOYCD.schedule(
hour_start varchar(45),
hour_end varchar (45),
name_modality varchar(100),
schedule_finish date,
version int,
version_actuality_trimester varchar(12),
number_environment varchar(45),
headquarters_name varchar(100),
name_day varchar(10),
document_type varchar(25),
identification_card_number varchar(10),
groups_number varchar(20),
trimester_name varchar(15),
working_day_initials varchar(10),
level_formation varchar(20)
);
alter table JOYCD.schedule add primary key(version, version_actuality_trimester, number_environment, headquarters_name, name_day,document_type, identification_card_number, groups_number, trimester_name,working_day_initials,level_formation);
alter table JOYCD.schedule modify hour_start varchar(45) not null comment'Start time corresponding to the training program.';
alter table JOYCD.schedule modify hour_end varchar(45) not null comment'End time corresponding to the training group.';
alter table JOYCD.schedule modify schedule_finish date not null comment'Final schedule that will have the training group already adequate. (12 to 2, 2 to 6)';
alter table JOYCD.schedule modify name_modality varchar(100) not null comment'Name the modality that the schedule will have. (Virtual, Face-to-face, B-learing). (foreing Modality)';
alter table JOYCD.schedule add constraint fk_schedule_environment foreign key (number_environment, headquarters_name) references JOYCD.environment(number_environment, headquarters_name )  on update cascade;
alter table JOYCD.schedule add index fk_schedule_environment_idx (number_environment, headquarters_name);
alter table JOYCD.schedule add constraint fk_schedule_modality foreign key (name_modality) references JOYCD.modality(name_modality) on update cascade;
alter table JOYCD.schedule add index fk_schedule_modality_idx (name_modality);
alter table JOYCD.schedule add constraint fk_schedule_day foreign key (name_day) references JOYCD.day (name_day) on update cascade;
alter table JOYCD.schedule add index fk_schedule_day_idx (name_day);
alter table JOYCD.schedule add constraint fk_schedule_gnht foreign key (groups_number,trimester_name,working_day_initials,level_formation) references JOYCD.group_number_has_trimester(groups_number,trimester_name, working_day_initials, level_formation) on update cascade;
alter table JOYCD.schedule add index fk_schedule_gnht_idx (groups_number,trimester_name,working_day_initials,level_formation);
alter table JOYCD.schedule add constraint fk_schedule_inst foreign key (document_type,identification_card_number) references JOYCD.instructor(document_type, identification_card) on update cascade;
alter table JOYCD.schedule add index fk_schedule_inst_idx (document_type,identification_card_number);
alter table JOYCD.schedule add constraint fk_schedule_sversion foreign key(version, version_actuality_trimester) references JOYCD.version_schedule(version, actuality_trimester)on update cascade;
alter table JOYCD.schedule add index fk_schedule_sversion_idx (version, version_actuality_trimester);

create table JOYCD.email_server(
email varchar(100),
password varchar(45),
smtp_host varchar(45),
smtp_port int,
smtp_start_tls_enable boolean,
smtp_auth boolean,
recovery_order varchar(45),
recovery_message varchar(45)
);
alter table JOYCD.email_server add primary key(email);

create table JOYCD.log_audit(
log_audit bigint (20),
level varchar(25),
log_name varchar(256),
message text,
date datetime,
user varchar(100)
);
alter table JOYCD.log_audit  add primary key(log_audit); 

create table JOYCD.log_error(
log_error int,
level varchar (15),
log_name varchar(256),
message text,
date datetime,
user varchar (100)
);
alter table JOYCD.log_error add primary key (log_error);



























