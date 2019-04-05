create database cot

--proyecto 

use cot
create table project(
	code int ,
	name varchar(100) NOT NULL, 
	primary key (code)
);
use cot
-- phase 
create table phase(
name_phase varchar(50),
project_code int,
state bit NOT NULL,
primary key (name_phase , project_code),
constraint fk_project_phase FOREIGN KEY (project_code)REFERENCES project(code)
); 

-- activity
create table activity(
id_activity varchar(20),	
phase_name varchar(50),
project_code int,
name varchar(150) NOT NULL,
primary key (id_activity,phase_name, project_code),
constraint fk_phase_activity FOREIGN KEY (phase_name, project_code) REFERENCES phase(name_phase, project_code) 
);

-- level_Training
create table level_training(
code varchar(45),
state bit,
primary key (code)
);

-- program
create table program(
code_program int,
edition varchar(10),
name_program varchar(150),
initials varchar(10),
state varchar(100),
level_training_code varchar(45),
primary key (code_program , edition),
constraint fk_level_trainig_program FOREIGN KEY(level_training_code) REFERENCES level_training(code)
);

-- state_number_group

create table state_number_group(
state bit,
primary key (state)
);

-- number_group
use cot
create table number_group(
number_group int,
date_start date,
date_end date,
route varchar(100),
state bit,
program_code int,
program_edition varchar(10),
primary key (number_group),
constraint fk_state_numberg FOREIGN KEY(state) REFERENCES state_number_group(state),
constraint fk_project_numberg FOREIGN KEY (program_code,program_edition) REFERENCES program(code_program, edition)
);

-- working_day

create table working_day(
initials varchar (10),
name varchar(100),
description varchar(255),
picture VARBINARY(MAX),
primary key (initials),
);

-- trimester

create table trimester(
number int,
initials varchar(10),
code varchar(45),
primary key (number ,initials , code ),
constraint fk_working_trimester FOREIGN KEY (initials) REFERENCES working_day(initials), 
constraint fk_level_trimester FOREIGN KEY (code) REFERENCES level_training(code),
);

-- trimester has group number 

create table number_group_has_trimester(
number_group int,
number int,
initials varchar(10),
tri_code varchar(45),
primary key (number_group, number , initials , tri_code) ,
constraint fk_numberg_phc FOREIGN KEY (number_group) REFERENCES number_group(number_group),
constraint fk_trimester_phc FOREIGN KEY (number, initials,tri_code) REFERENCES trimester(number ,initials , code)
);

