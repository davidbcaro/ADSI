create schema cot;

-- PROJECT

create table cot.project(
	code mediumint
);

alter table cot.project add primary key (code); 
alter table cot.project add column name varchar(100) not null comment 'project name';
alter table cot.project add column state bool not null comment 'Status in which the project is located (start, finish, etc...)';


create table cot.phase(
	name_phase varchar(100) comment 'Phase name'
);
alter table cot.phase add column project_code mediumint not null comment 'Project foreign key (project code)';
alter table cot.phase add primary key (name_phase, project_code);
alter table cot.phase add column state bool not null comment 'Status in which the phase (finish, start, etc...)';
alter table cot.phase add constraint fk_phase_project foreign key (project_code) references cot.project (code) on update cascade;
alter table cot.phase add index fk_phase_project_idx(project_code);


create table cot.activity(
	id_activity varchar(20) comment 'Activity identification number'
	
);
alter table cot.activity add column phase_name_phase varchar(50) not null comment 'Phase foreign key (phase name)';
alter table cot.activity add column phase_project_code mediumint not null comment ' phase_project foreing key ( project code)';
alter table cot.activity add column name varchar(150) not null comment 'name of the activity';
alter table cot.activity add primary key(id_activity, phase_project_code, phase_name_phase);
alter table cot.activity add constraint fk_activity_phase foreign key (phase_name_phase, phase_project_code) references cot.phase (name_phase, project_code) on update cascade;
alter table cot.activity add index fk_activity_phase_idx(phase_name_phase, phase_project_code);


create table cot.level_trainig(
	code varchar(45) comment 'identification code  of the level training'
);
alter table cot.level_trainig add primary key (code);
alter table cot.level_trainig add column state bool not null comment 'Status in which the level training is found';


create table cot.program(
	code_program int comment 'identification code of the program'
);
alter table cot.program add column name_program varchar(150) not null comment 'program name';
alter table cot.program add column edition varchar(10)  comment 'program version';
alter table cot.program add column initials varchar(10) not null comment 'program initials (ADSI, DIN)';
alter table cot.program add column state varchar(100) not null comment 'Current status of the program ( discontinued, start, etc...)';
alter table cot.program add column level_tra_code varchar(45) not null comment 'Level trainig fiel foraing ( identification code of the level trainig)' ;
alter table cot.program add constraint fk_program_levelt foreign key (level_tra_code) references cot.level_trainig (code) on update cascade;
alter table cot.program add index fk_program_levelt_idx(level_tra_code);
alter table cot.program add primary key (code_program, edition);


create table cot.state_number_group(
	state bool comment 'Status of the number group ( finish, discontinued, etc...)'
);
alter table cot.state_number_group add primary key (state);


create table cot.number_group(
	number_group int comment 'identification code number group ( 1349397)'
);
alter table cot.number_group add primary key (number_group);
alter table cot.number_group add column date_start date not null comment 'Start date of the number group';
alter table cot.number_group add column date_end date not null comment 'finish date of the number group';
alter table cot.number_group add column route varchar(100) not null comment 'route of the number group ( 1f )';
alter table cot.number_group add column state bool not null comment 'Field of state of the group ( start, finish, etc..)';
alter table cot.number_group add column program_code int not null comment 'Field of the program code ( program code)';
alter table cot.number_group add column program_edition varchar(10) not null comment 'edition of the program  ( program code)';
alter table cot.number_group add constraint fk_ng_s foreign key (state) references cot.state_number_group (state) on update cascade;
alter table cot.number_group add constraint fk_ng_p foreign key (program_code,program_edition) references cot.program (code_program,edition) on update cascade;
alter table cot.number_group add index fk_ng_s_idx(state);
alter table cot.number_group add index fk_ng_p_idx(program_code,program_edition);


create table cot.working_day(
	initials varchar(10) comment 'D(Day_Time) N(Nigth)'
);

alter table cot.working_day add primary key(initials) ;
alter table cot.working_day add column name varchar(100) not null comment 'name of the day ( day, nigth, etc...)';
alter table cot.working_day add column description varchar(255) not null comment 'Description of the working_day';
alter table cot.working_day add column picture blob;

create table cot.trimester(
	number int comment 'identification number of the trimester '
);
alter table cot.trimester add column initials varchar (10) comment 'Working day foreign key ( intial of the day)';
alter table cot.trimester add column code varchar(45) comment 'identification code  of the level training';
alter table cot.trimester add primary key(number, initials, code);
alter table cot.trimester add constraint fk_t_wd foreign key (initials) references cot.working_day (initials) on update cascade;
alter table cot.trimester add constraint fk_t_lr foreign key (code) references cot.level_trainig (code) on update cascade;
alter table cot.trimester add index fk_t_wd_idx(initials);
alter table cot.trimester add index fk_t_lr_idx(code);

create table cot.number_group_has_trimester(
		number_group int comment 'Number group foreign key ( identification number of the group)'
);

alter table cot.number_group_has_trimester add column number int comment 'Trimester foreign key ( identification number of the trimester)';
alter table cot.number_group_has_trimester add column initials varchar (10) comment 'Trimester_Working day foreign key ( initials day)';
alter table cot.number_group_has_trimester add column tri_code varchar (45) comment 'code of trimester ( initials day)';
alter table cot.number_group_has_trimester add primary key (number_group, number, initials,tri_code);
alter table cot.number_group_has_trimester add constraint fk_ng_phc foreign key (number_group) references cot.number_group (number_group) on update cascade;
alter table cot.number_group_has_trimester add constraint fk_trimester_phc foreign key (number, initials,tri_code) references cot.trimester (number, initials,code) on update cascade;
alter table cot.number_group_has_trimester add index fk_trimester_phc_idx(number, initials,tri_code);
alter table cot.number_group_has_trimester add index fk_ng_phc_idx(number_group);

create table cot.competence(
code_competence int comment 'identification code of the competence'
);
alter table cot.competence add column description varchar(250) comment 'Description related to the competence';
alter table cot.competence add column code_program int comment 'identification code of the program';
alter table cot.competence add column edition varchar(10)  comment 'program version';
alter table cot.competence add constraint fk_c_p foreign key (code_program, edition) references cot.program (code_program, edition) on update cascade;
alter table cot.competence add index fk_c_p_idx (code_program, edition);
alter table cot.competence add primary key (code_competence, code_program, edition);



create table cot.learning_result(
	code varchar (45) comment 'Reference code of the learning result'
);
alter table cot.learning_result add column description varchar(500) not null comment 'Description of approach to learning outcome';
alter table cot.learning_result add column code_competence int comment 'identification code of the competence';
alter table cot.learning_result add column code_program int comment 'identification code of the program';
alter table cot.learning_result add column edition varchar(10)  comment 'program version';
alter table cot.learning_result add constraint fk_lr_c foreign key (code_program, edition, code_competence) references cot.competence (code_program, edition, code_competence) on update cascade;
alter table cot.learning_result add index fk_lr_c_idx (code_competence, code_program, edition);
alter table cot.learning_result add primary key (code, code_competence, code_program, edition);

create table cot.learning_result_has_activity(
	code varchar(45) comment 'number  of Code of result(foreign key)'
);
alter table cot.learning_result_has_activity add column program_code int comment 'Competence Program Code(foreign key)';
alter table cot.learning_result_has_activity add column edition varchar(10)  comment 'program version';
alter table cot.learning_result_has_activity add column competence_code int comment 'Learning outcome code (foreing key)';
alter table cot.learning_result_has_activity add column id_activity varchar (20) comment 'Activity_id_activity foreing key ( number activity )';
alter table cot.learning_result_has_activity add column apn_phase varchar(50) comment 'Name phase of the activity (foreing key)';
alter table cot.learning_result_has_activity add column app_code mediumint comment 'Number project of phase activity (foreing key)';
alter table cot.learning_result_has_activity add primary key (code, program_code, edition, competence_code, id_activity, apn_phase, app_code);
alter table cot.learning_result_has_activity add constraint fk_lrha_lr foreign key ( program_code, edition, competence_code, code) references cot.learning_result (code_program, edition,  code_competence, code) on update cascade;
alter table cot.learning_result_has_activity add constraint fk_lrha_a foreign key ( id_activity, app_code, apn_phase) references cot.activity (id_activity, phase_project_code, phase_name_phase) on update cascade;
alter table cot.learning_result_has_activity add index fk_lrha_lr_idx (program_code, edition, competence_code, code);
alter table cot.learning_result_has_activity add index fk_lrha_a_idx ( id_activity, app_code, apn_phase);



create table cot.trimester_has_learning_result(
	trimester_number int comment'Number of trimester (foreing key'
);
alter table cot.trimester_has_learning_result add column tri_work_initials varchar(10) comment 'Initials of the day at trimester' ;
alter table cot.trimester_has_learning_result add column learningr_code varchar(45) comment 'Number of learning result (foreing key)';
alter table cot.trimester_has_learning_result add column levelt_code varchar(45) comment 'Code of the level training (foreing key)';
alter table cot.trimester_has_learning_result add column learning_edition varchar(10) comment 'edition level training (foreing key)';
alter table cot.trimester_has_learning_result add column program_code int comment 'Number of program (foreing key)';
alter table cot.trimester_has_learning_result add column competence_code int comment 'Number of competence (foreing key)';
alter table cot.trimester_has_learning_result add constraint fk_thlr_lr foreign key (learningr_code, competence_code, program_code,learning_edition) references cot.learning_result (code, code_competence,   code_program,edition) on update cascade;
alter table cot.trimester_has_learning_result add constraint fk_thlr_t foreign key (tri_work_initials, trimester_number,levelt_code) references cot.trimester (initials, number, code) on update cascade;
alter table cot.trimester_has_learning_result add primary key ( competence_code,levelt_code, learningr_code, program_code,learning_edition, tri_work_initials, trimester_number);
alter table cot.trimester_has_learning_result add index fk_thlr_lr_idx ( program_code, competence_code, learningr_code,levelt_code,learning_edition);
alter table cot.trimester_has_learning_result add index fk_thlr_t_idx (tri_work_initials, trimester_number);



create table cot.number_group_has_trimester_has_learning_result(
number_group int comment 'Number grpoup (foreing key)'
);
alter table cot.number_group_has_trimester_has_learning_result add column number_trimester int comment 'Number  trimester of result learning';
alter table cot.number_group_has_trimester_has_learning_result add column initials_dw varchar (10) comment 'Initials day working of the trimester ';
alter table cot.number_group_has_trimester_has_learning_result add column number_lear varchar(45) comment 'Number of learning result(foreing key)';
alter table cot.number_group_has_trimester_has_learning_result add column program_code int comment 'Number  program of competence (foreing key)';
alter table cot.number_group_has_trimester_has_learning_result add column competence_code int comment 'Number of competence (foreing key)';
alter table cot.number_group_has_trimester_has_learning_result add column levelt_code varchar (45) comment 'Code of the level training (foreing key)';
alter table cot.number_group_has_trimester_has_learning_result add column learningtri_edition varchar(10) comment 'edition level training (foreing key)';
alter table cot.number_group_has_trimester_has_learning_result add constraint fk_nghthlr_thlr foreign key (competence_code,levelt_code, number_lear, program_code,learningtri_edition,  initials_dw, number_trimester) references cot.trimester_has_learning_result (competence_code,levelt_code, learningr_code, program_code,learning_edition,tri_work_initials, trimester_number) on update cascade;
alter table cot.number_group_has_trimester_has_learning_result add constraint fk_nghthlr_ng foreign key (number_group) references cot.number_group (number_group) on update cascade; 
alter table cot.number_group_has_trimester_has_learning_result add primary key (number_trimester, initials_dw, number_lear, program_code, competence_code, number_group,levelt_code,learningtri_edition);
alter table cot.number_group_has_trimester_has_learning_result add index fk_nghthlr_thlr_idx (number_lear, program_code, competence_code, initials_dw, number_trimester,levelt_code,learningtri_edition);
alter table cot.number_group_has_trimester_has_learning_result add index fk_nghthlr_ng_idx (number_group);


create table cot.speciality(
	name varchar(100) comment 'Save the name that refers to the specificity'
);
alter table cot.speciality add column state bool not null comment 'Enabled, Disabled ....';
alter table cot.speciality add column picture blob comment 'save a photo of the user';
alter table cot.speciality add primary key (name);


create table cot.link_up(
	type_link varchar(100) comment 'Name of the link'
);
alter table cot.link_up add column hours int not null comment 'Hours over which the link type is handled';
alter table cot.link_up add column state bool not null comment 'Enabled, Disabled';
alter table cot.link_up add primary key (type_link);


create table cot.rol(
	id_rol varchar(45) comment 'name for identification rol'
);
alter table cot.rol add column description varchar(250) not null comment 'descriptio specify of the rol';
alter table cot.rol add column state bool not null comment 'Enabled, Disabled';
alter table cot.rol add primary key (id_rol);


create table cot.document(
	document varchar(10) comment 'Code that identifies the type of document'
);
alter table cot.document add column name varchar(30) not null comment 'Name by which the type of document is known';
alter table cot.document add column state bool not null comment 'Enabled, disabled';
alter table cot.document add primary key (document);


create table cot.person(
	number_document int comment 'Document number identifying the person'
);
alter table cot.person add column first_name varchar(100) not null comment 'First name ';
alter table cot.person add column second_name varchar(100) comment 'second name';
alter table cot.person add column last_name varchar(100) not null comment 'Last name';
alter table cot.person add column second_lname varchar(100) comment 'second last name';
alter table cot.person add column photo blob(150) not null comment 'save a photo of the user';
alter table cot.person add column document varchar(10) comment 'Code of the type of document that the person owns';
alter table cot.person add constraint fk_person_document foreign key (document) references cot.document (document) on update cascade;
alter table cot.person add primary key (number_document, document);
alter table cot.person add index fk_person_document_idx (document);


create table cot.person_has_rol(
	person_number_document int comment 'Document number identifying the person'
);
alter table cot.person_has_rol add column person_id_docuemnt varchar(10) comment 'Reference code that identifies the type of document';
alter table cot.person_has_rol add column id_rol varchar(45) comment 'Code that identifies the role';
alter table cot.person_has_rol add constraint fk_phr_person foreign key (person_number_document, person_id_docuemnt) references cot.person (number_document, document) on update cascade; 
alter table cot.person_has_rol add constraint fk_phr_rol foreign key (id_rol) references cot.rol (id_rol) on update cascade;
alter table cot.person_has_rol add primary key (person_number_document, person_id_docuemnt, id_rol);
alter table cot.person_has_rol add index fk_phr_person_idx (person_number_document, person_id_docuemnt);
alter table cot.person_has_rol add index fk_phr_rol_idx (id_rol);

create table cot.useri(
	email varchar(100) comment 'Electronic mail owned by the person'
);
alter table cot.useri add column password varchar(15) comment 'Password that the person will use to enter';
alter table cot.useri add column person_number int comment 'Document number to identify the person';
alter table cot.useri add column document varchar(10) comment 'Reference code of the persons document type';
alter table cot.useri add constraint fk_useri_person foreign key (person_number, document) references cot.person (number_document, document) on update cascade;
alter table cot.useri add primary key  (person_number, document);
alter table cot.useri add index fk_useri_person_idx (person_number, document);


create table cot.instructor(
	speciality_name varchar(100) not null comment 'Especilidad del instructor'
);
alter table cot.instructor add column linku_tol varchar(100) not null comment 'Select part time or full time';
alter table cot.instructor add column number_document int comment 'Save the document number related to the instructor';
alter table cot.instructor add column document varchar(10) comment 'Save the possible ids of the documents eg: CC, TI- ... .. etc';
alter table cot.instructor add constraint fk_i_s foreign key (speciality_name) references cot.speciality(name) on update cascade;
alter table cot.instructor add constraint fk_i_lu foreign key (linku_tol) references cot.link_up (type_link) on update cascade;
alter table cot.instructor add constraint fk_i_p foreign key (number_document, document) references cot.person (number_document, document) on update cascade;
alter table cot.instructor add primary key (number_document, document);
alter table cot.instructor add index fk_i_s_idx (speciality_name);
alter table cot.instructor add index fk_i_lu_idx (linku_tol);
alter table cot.instructor add index fk_i_p_idx (number_document, document);

create table cot.modality(
	name_modality varchar(20) comment 'Name with which the modality will be known'
);
alter table cot.modality add column state bool not null comment 'Enabled disabled';
alter table cot.modality add primary key (name_modality); 


create table cot.dayi(
	name_dayi varchar(10) comment 'weekdays'
);
alter table cot.dayi add column state bool not null comment 'Enabled disabled';
alter table cot.dayi add primary key (name_dayi);


create table cot.environment(
	num_environment varchar(45) comment 'Number assigned to the environment'
);
alter table cot.environment add column state bool not null comment 'Enabled disabled';
alter table cot.environment add column description varchar(100) comment 'Description of the environment';
alter table cot.environment add primary key (num_environment);


create table cot.trimester_term(
	id_trimester varchar(25) comment 'Trimester '
); 
alter table cot.trimester_term add column start_date date comment 'date start';
alter table cot.trimester_term add column end_date date comment 'date end ';
alter table cot.trimester_term add primary key (id_trimester);


create table cot.edition(
	ide_edition int comment 'Version identifier code'
);
alter table cot.edition add column id_trimester varchar(25) comment 'Number of edition';
alter table cot.edition add constraint fk_edition_tt foreign key (id_trimester) references cot.trimester_term (id_trimester) on update cascade;
alter table cot.edition add primary key (ide_edition, id_trimester);
alter table cot.edition add index fk_edition_tt_idx (id_trimester);



create table cot.disponibility(
	start_date date comment 'Date it starts'
);
alter table cot.disponibility add column end_date date comment 'Date on which it ends';
alter table cot.disponibility add column number_document int comment 'Document number of person';
alter table cot.disponibility add column document varchar(10) comment 'Code that identifies the type of document';
alter table cot.disponibility add column work_initials varchar(10) comment 'Initials that identify the day';
alter table cot.disponibility add column name_dayi varchar(10) comment 'Names of days';
alter table cot.disponibility add constraint fk_d_i foreign key (number_document, document) references cot.instructor (number_document, document) on update cascade;
alter table cot.disponibility add constraint fk_d_wd foreign key (work_initials) references cot.working_day (initials) on update cascade;
alter table cot.disponibility add constraint fk_d_d foreign key (name_dayi) references cot.dayi (name_dayi) on update cascade;
alter table cot.disponibility add primary key (start_date, number_document, document, work_initials, name_dayi);
alter table cot.disponibility add index fk_d_i_idx (number_document, document);
alter table cot.disponibility add index fk_d_wd_idx (work_initials);
alter table cot.disponibility add index fk_d_d_idx (name_dayi);

create table cot.headquaters(
	name_head varchar(45) comment 'Name of venue'
);
alter table cot.headquaters add column direction varchar(45) comment 'Address where the seat is located';
alter table cot.headquaters add column state bool not null comment 'Enabled disabled';
alter table cot.headquaters add column num_environment varchar(45) comment 'Number of rooms';
alter table cot.headquaters add constraint fk_h_e foreign key (num_environment) references cot.environment (num_environment) on update cascade;
alter table cot.headquaters add primary key (name_head, num_environment);
alter table cot.headquaters add index fk_h_e_idx (num_environment);


create table cot.timetable(
	name_head varchar(45) comment 'Name of headquarters'
);
alter table cot.timetable add column num_environment varchar(45) comment 'Number of enviroment';
alter table cot.timetable add column number_group int comment 'Number of groups ';
alter table cot.timetable add column number_tri int comment 'Number of trimester';
alter table cot.timetable add column initials_dai varchar(10) comment 'Initial letters of the day';
alter table cot.timetable add column name_dai varchar(10) comment 'Name of day';
alter table cot.timetable add column ide_edition int comment 'Number id of Edition';
alter table cot.timetable add column number_current varchar(25) comment 'Number of current term';
alter table cot.timetable add column name_modality varchar(20) not null comment 'Name of modality (Face-to-face and virtual)';
alter table cot.timetable add column id_num_document int comment 'Number document of instructor';
alter table cot.timetable add column type_document varchar(10) comment 'Type document of instructor';
alter table cot.timetable add column start_date date comment 'Start time of session' ;
alter table cot.timetable add column end_date date comment 'End time of the session' ;
alter table cot.timetable add column trim_code varchar(45) comment 'code of trimester(foreing key)';
alter table cot.timetable add constraint fk_tt_h foreign key (name_head, num_environment) references cot.headquaters(name_head, num_environment) on update cascade;
alter table cot.timetable add constraint fk_tt_nght foreign key (number_group, number_tri, initials_dai,trim_code) references cot.number_group_has_trimester(number_group, number, initials,tri_code) on update cascade;
alter table cot.timetable add constraint fk_tt_d foreign key (name_dai) references cot.dayi (name_dayi) on update cascade;
alter table cot.timetable add constraint fk_tt_e foreign key (ide_edition, number_current) references cot.edition (ide_edition, id_trimester) on update cascade;
alter table cot.timetable add constraint fk_tt_m foreign key (name_modality) references cot.modality (name_modality) on update cascade;
alter table cot.timetable add constraint fk_tt_i foreign key (id_num_document, type_document) references cot.instructor(number_document, document) on update cascade;
alter table cot.timetable add primary key (name_head, num_environment, number_group, number_tri, initials_dai,trim_code, name_dai, ide_edition, number_current, id_num_document, type_document);
alter table cot.timetable add index fk_tt_h_idx (name_head, num_environment);
alter table cot.timetable add index fk_tt_nght_idx (number_group, number_tri, initials_dai);
alter table cot.timetable add index fk_tt_d_idx (name_dai);
alter table cot.timetable add index fk_tt_e_idx (ide_edition, number_current);
alter table cot.timetable add index fk_tt_m_idx (name_modality);
alter table cot.timetable add index fk_tt_i_idx (id_num_document, type_document);

create table cot.email_server(
	email varchar(50)
);
alter table cot.email_server add column password_security varchar(45);
alter table cot.email_server add column smtp_host varchar(45);
alter table cot.email_server add column smtp_port varchar(45);
alter table cot.email_server add column smtp_start_tls_enable bool;
alter table cot.email_server add column smtp_auth bool;
alter table cot.email_server add column recovery_order varchar(45);
alter table cot.email_server add column recovery_message varchar(45);
alter table cot.email_server add primary key (email);

create table cot.log_error(
	log_error int
);
alter table cot.log_error add column level varchar(15);
alter table cot.log_error add column log_name varchar(256);
alter table cot.log_error add column message text;
alter table cot.log_error add column date datetime;
alter table cot.log_error add column user varchar(100);
alter table cot.log_error add primary key (log_error);

create table cot.log_audit(
	log_audit bigint(20)
);
alter table cot.log_audit add column level varchar(45);
alter table cot.log_audit add column log_name varchar (256);
alter table cot.log_audit add column message text;
alter table cot.log_audit add column date datetime;
alter table cot.log_audit add column user varchar(100);
alter table cot.log_audit add primary key (log_audit); 