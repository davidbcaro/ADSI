INSERT INTO wariosoft.document
(id_Document,
name,
state)
VALUES
('C.C',
'Cedula de Ciudadania',
'1');

INSERT INTO wariosoft.document
(id_Document,
name,
state)
VALUES
('T.I',
'Tajeta de Identidad',
'1');

INSERT INTO wariosoft.document
(id_Document,
name,
state)
VALUES
('C.E',
'Cedula de Extranjeria',
'1');

INSERT INTO wariosoft.document
(id_Document,
name,
state)
VALUES
('P',
'Pasaporte',
'1');
-------------------------------------------
INSERT INTO wariosoft.client
(document_Number,
id_Document,
first_Name,
second_Name,
first_Lastname,
second_Lastname,
photo)
VALUES
('80013833',
'C.C',
'Hernando',
'Enrique',
'Moreno',
'Moreno',
load_file(''));

INSERT INTO wariosoft.client
(document_Number,
id_Document,
first_Name,
second_Name,
first_Lastname,
second_Lastname,
photo)
VALUES
('800133',
'T.I',
'Hernando',
'Enrique',
'Moreno',
'Moreno',
load_file(''));

INSERT INTO wariosoft.client
(document_Number,
id_Document,
first_Name,
second_Name,
first_Lastname,
second_Lastname,
photo)
VALUES
('013833',
'C.E',
'Hernando',
'Enrique',
'Moreno',
'Moreno',
load_file(''));

-------------------------------------------

INSERT INTO wariosoft.user
(email,
password,
date_Terminate,
id_Document,
document_Number)
VALUES
('erpineda77@misena.edu.co',
'00000000',
'30/11/2018',
'C.C',
'80013833');

INSERT INTO wariosoft.user
(email,
password,
date_Terminate,
id_Document,
document_Number)
VALUES
('erpi77@misena.edu.co',
'00000000',
'30/11/2018',
'T.I',
'800133');
INSERT INTO wariosoft.user
(email,
password,
date_Terminate,
id_Document,
document_Number)
VALUES
('erpi77@misena.edu.co',
'00000000',
'30/11/2018',
'C.E',
'013833');
-------------------------------------------

INSERT INTO wariosoft.role
(id_Role,
description_Role,
state)
VALUES
('Super Administrador',
'Rol de super administrador',
'1');

INSERT INTO wariosoft.role
(id_Role,
description_Role,
state)
VALUES
('Administrador',
'Administrador del Software',
'1');

INSERT INTO wariosoft.role
(id_Role,
description_Role,
state)
VALUES
('Instructor',
'Usuario destinado a los instructores',
'1');

INSERT INTO wariosoft.role
(id_Role,
description_Role,
state)
VALUES
('Lider del Programa',
'Es el lider de un programa en especifico',
'1');

-------------------------------------------
INSERT INTO wariosoft.role_has_client
(id_Document,
document_Number,
id_Role,
state)
VALUES
('C.C',
'80013833',
'Super Administrador',
'1');
INSERT INTO wariosoft.role_has_client
(id_Document,
document_Number,
id_Role,
state)
VALUES
('T.I',
'800133',
'Administrador',
'1');

INSERT INTO wariosoft.role_has_client
(id_Document,
document_Number,
id_Role,
state)
VALUES
('C.E',
'013833',
'Lider del Programa',
'1');


-------------------------------------------
INSERT INTO wariosoft.specialty
(name_Specialty,
state)
VALUES
('Teleinformatica',
'1');
-------------------------------------------
INSERT INTO wariosoft.linking
(type_Linking,
hours,
state)
VALUES
('Tiempo completo',
'24',
'1');

INSERT INTO wariosoft.linking
(type_Linking,
hours,
state)
VALUES
('Medio tiempo',
'12',
'1');
-------------------------------------------
INSERT INTO wariosoft.teacher
(id_Document,
document_Number,
type_Linking,
name_Specialty)
VALUES
('C.C',
'80013833',
'medio tiempo',
'teleinformatica');
-------------------------------------------
INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Lunes',
'1');

INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Martes',
'1');

INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Miercoles',
'1');

INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Jueves',
'1');

INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Viernes',
'1');

INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Sabado',
'1');

INSERT INTO wariosoft.day
(name_Day,
state)
VALUES
('Domingo',
'1');
-------------------------------------------
INSERT INTO wariosoft.working_day
(initials_Working_Day,
name,
description,
image,
state)
VALUES
('D',
'Diurno',
'Es un horario con disponibilidad de 6 am-6 pm',
load_file(''),
'1');

INSERT INTO wariosoft.working_day
(initials_Working_Day,
name,
description,
image,
state)
VALUES
('N',
'Nocturno',
'Es un horario con disponibilidad de 6 pm- 10 pm',
load_file(''),
'1');

INSERT INTO wariosoft.working_day
(initials_Working_Day,
name,
description,
image,
state)
VALUES
('F.S',
'Fin de Semana',
'Es un horario con disponibilidad de 6 am- 12 pm',
load_file(''),
'1');
-------------------------------------------
INSERT INTO wariosoft.availability
(start_Time,
end_Time,
initials_Working_Day,
id_Document,
document_Number,
name_Day)
VALUES
('06:00:00 ',
'06:00:00 ',
'D',
'C.C',
'80013833',
'Lunes');

INSERT INTO wariosoft.availability
(start_Time,
end_Time,
initials_Working_Day,
id_Document,
document_Number,
name_Day)
VALUES
('06:00:00 ',
'06:00:00 ',
'D',
'C.C',
'80013833',
'Martes');

INSERT INTO wariosoft.availability
(start_Time,
end_Time,
initials_Working_Day,
id_Document,
document_Number,
name_Day)
VALUES
('06:00:00 ',
'06:00:00 ',
'D',
'C.C',
'80013833',
'Miercoles');

INSERT INTO wariosoft.availability
(start_Time,
end_Time,
initials_Working_Day,
id_Document,
document_Number,
name_Day)
VALUES
('06:00:00 ',
'06:00:00 ',
'D',
'C.C',
'80013833',
'Jueves');

INSERT INTO wariosoft.availability
(start_Time,
end_Time,
initials_Working_Day,
id_Document,
document_Number,
name_Day)
VALUES
('06:00:00 ',
'06:00:00 ',
'D',
'C.C',
'80013833',
'Viernes');
-------------------------------------------
INSERT INTO wariosoft.modality
(name_Modality,
state)
VALUES
('Presencial',
'1');

INSERT INTO wariosoft.modality
(name_Modality,
state)
VALUES
('Virtual',
'1');
-------------------------------------------
INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('1',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('2',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('3',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('4',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('5',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('6',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('7',
'2017-07-17',
'2017-09-23');

INSERT INTO wariosoft.current_quarter
(id_Current_Quarter,
start_Date,
end_Date)
VALUES
('8',
'2017-07-17',
'2017-09-23');
-------------------------------------------
INSERT INTO wariosoft.version
(id_Version,
active,
id_Current_Quarter)
VALUES
('102',
'1',
'1');
-------------------------------------------
INSERT INTO wariosoft.headquarters
(name_Headquarters,
address,
state)
VALUES
('SENA SEDE BARRIO COLOMBIA',
'Cll. 69 #20-36',
'1');
-------------------------------------------
INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('100',
'Aula en el primer piso con equipos de computo para trabajar',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('AUDITORIO ',
'Aula en la cual se hacen reuniones',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('103',
'Aula en el primer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('200',
'Aula en el segundo piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('201',
'Aula en el segundo piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('202',
'Aula en el segundo piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('300',
'Aula en el tercer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('301',
'Aula en el tercer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('302',
'Aula en el tercer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('303',
'Aula en el tercer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('305',
'Aula en el tercer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('307',
'Aula en el tercer piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('400',
'Aula en el cuarto piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('401',
'Aula en el cuarto piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('402',
'Aula en el cuarto piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('SALA DE INSTRUCTORES',
'Aula en la cual pueden ingresar solo instructores',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('407',
'Aula en el cuarto piso que cuenta con equipos de computo',
'1',
'SENA SEDE BARRIO COLOMBIA');

INSERT INTO wariosoft.environment
(number_Environment,
description,
state,
name_Headquarters)
VALUES
('CAFE-LIBRO',
'Aula en la cual se puede descansar o realizar actividades fuera de clase',
'1',
'SENA SEDE BARRIO COLOMBIA');
-------------------------------------------
INSERT INTO wariosoft.training_level
(training_Level,
state)
VALUES
('Tecnico',
'1');

INSERT INTO wariosoft.training_level
(training_Level,
state)
VALUES
('Tecnologo',
'1');
-------------------------------------------
-- Diurno --
INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('1',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('2',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('3',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('4',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('5',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('6',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('7',
'Tecnologo',
'D');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('8',
'Tecnologo',
'D');

-- Nocturno --

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('1',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('2',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('3',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('4',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('5',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('6',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('7',
'Tecnologo',
'N');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('8',
'Tecnologo',
'N');

-- Fin de Semana --

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('1',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('2',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('3',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('4',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('5',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('6',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('7',
'Tecnologo',
'F.S');

INSERT INTO wariosoft.trimester
(name_Trimester,
training_Level,
initials_Working_Day)
VALUES
('8',
'Tecnologo',
'F.S');
-------------------------------------------
INSERT INTO wariosoft.project
(project_Code,
name_project,
state)
VALUES
('576887 v102',
'SISTEMA INTEGRAL WEB PARA GESTION DE PROCESOS EDUCATIVOS DEL CEET',
'1');
-------------------------------------------
INSERT INTO wariosoft.phase
(name_Phase,
state,
project_Code)
VALUES
('FASE 1: ANÁLISIS',
'1',
'576887 v102');

INSERT INTO wariosoft.phase
(name_Phase,
state,
project_Code)
VALUES
('FASE 2: PLANEACIÓN',
'1',
'576887 v102');

INSERT INTO wariosoft.phase
(name_Phase,
state,
project_Code)
VALUES
('FASE 3: EJECUCIÓN',
'1',
'576887 v102');

INSERT INTO wariosoft.phase
(name_Phase,
state,
project_Code)
VALUES
('FASE 4: EVALUACIÓN',
'1',
'576887 v102');
-------------------------------------------
INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('1',
'Actividades de  inducción en la formación profesional integral SENA',
'FASE 1: ANÁLISIS',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('2',
'Determinar los requerimientos del sistema según especificaciones y lineamientos del proyecto.',
'FASE 1: ANÁLISIS',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('3',
'Analizar procesos, datos y necesidades del centro de electricidad, electronica y telecomunicaciones y el usuario final para el modulo especifico.',
'FASE 1: ANÁLISIS',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('4',
'Especificar Modelo Conceptual del sistema,especificando necesidades y requerimientos',
'FASE 2: PLANEACIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('5',
'Determinar la estructura lógica del sistema',
'FASE 2: PLANEACIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('6',
'Desarrollar la estructura de datos y de vista de la aplicación del modulo',
'FASE 2: PLANEACIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('7',
'Desarrollar la estructura de datos y de vista de la aplicación del modulo',
'FASE 3: EJECUCIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('8',
'Desarrollo los módulos del sistema integral web de acuerdo a los estándares de calidad y normatividad  legal vigente.',
'FASE 3: EJECUCIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('9',
'Preparar documentación del proceso de implantación del sistema',
'FASE 4: EVALUACIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('10',
'Desarrollar las tareas de configuración y puesta en marcha del sistema',
'FASE 4: EVALUACIÓN',
'576887 v102');

INSERT INTO wariosoft.activity
(id_Activity,
name_activity,
name_Phase,
project_Code)
VALUES
('11',
'Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos.',
'FASE 4: EVALUACIÓN',
'576887 v102');
-------------------------------------------
INSERT INTO wariosoft.program
(program_Code,
name,
version,
initials,
state,
training_Level)
VALUES
('228106',
'Analisis y Desarrollo de Sistemas de Informacion',
'version 102',
'A.D.S.I',
'1',
'Tecnologo');

INSERT INTO wariosoft.program
(program_Code,
name,
version,
initials,
state,
training_Level)
VALUES
('228120',
'Analisis y Desarrollo de Sistemas de Informacion',
'version 102',
'T.P.S',
'1',
'Tecnologo');
-------------------------------------------

-- TPS ----------------------------------------------------------------------------------

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501032',
'Analizar los requerimientos del cliente para construir el sistema de información',
'228120',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('240201500',
'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social.',
'228120',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('240201501',
'Comprender textos en inglés en forma escrita y auditiva.',
'228120',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501007',
'Construir el sistema que cumpla con los requisitos de la solución informática',
'228120',
'Version 102');


-- ADSI----------------------------------------------------------------------------

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501006',
'Especificar los requisitos necesarios para desarrollar el sistema de información de acuerdo con las necesidades del cliente',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('240201500',
'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social.',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('240201501',
'Comprender textos en inglés en forma escrita y auditiva',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('240201502',
'Producir textos en inglés en forma escrita y oral.',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501032',
'Analizar los requisitos del cliente para construir el sistema de información.',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501033',
'Diseñar el sistema de acuerdo con los requerimientos del cliente',
'228106',
'Version 102');


INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501007',
'Construir el sistema que cumpla con los requisitos de la solución informática.',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501034',
'Implantar la solución que cumpla con los requerimientos para su operación.',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501009',
'Participar en el proceso de negociación de Tecnología informática para permitir la implementación del sistema de información.',
'228106',
'Version 102');

INSERT INTO wariosoft.competition
(competition_Code,
description,
program_Code,
version)
VALUES
('220501035',
'Aplicar buenas prácticas de calidad en el proceso de desarrollo de software, de acuerdo con el referente adoptado en la empresa',
'228106',
'Version 102');


-------------------------------------------
-- trimestre 1-----

-- trimestre 1 ADSI 

INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-1','Aplicar las técnicas de recolección de datos , diseñando  los instrumentos necesarios para el procesamiento de información, de acuerdo con la situación planteada por la empresa.','220501006','228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-2','Elaborar mapas de procesos que permitan identificar las áreas involucradas en un sistema de información, utilizando herramientas informáticas y las Tic’s, para generar informes según las necesidades de la empresa.','220501006','228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-3','Plantear diferentes alternativas, de modelos tecnológicos de información empresarial, teniendo en cuenta la plataforma  tecnológica de la empresa y las tendencias del mercado, para dar solución a las situaciones relacionadas con el manejo de la información de la organización.','220501006','228106','Version 102');

INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-4','Interpretar el informe de requerimientos, para determinar las necesidades tecnológicas en el manejo de la información, de acuerdo con las normas y protocolos establecidos en la empresa.','220501032','228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-5', 'Representa el bosquejo de la solución al problema presentado por el cliente, mediante la  elaboración de diagramas de casos de uso,  apoyado en el análisis del informe de requerimientos, al confrontar la situación problemica con el usuario según  normas y protocolos de la organización.','220501032', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-6', 'Construir el modelo conceptual del macrosistema frente a los requerimientos del cliente,  mediante el uso e interpretación de la información levantada, representado en diagramas de clase, de interacción, colaboración y contratos de operación, de acuerdo con las diferentes secuencias, fases y procedimientos del sistema.','220501032','228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (Inducción)', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA.','240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (Inducción)', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional.','240201500', '228106',  'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (Inducción)', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles. ','240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-4 (Inducción)', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional.','240201500',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (Comunicación)', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social. ','240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (Comunicación)', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.','240201500','228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (Comunicación)', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social','240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-1', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos.','240201501', '228106',  'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-2', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico.','240201501', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-1', 'Reproducir en inglés frases o enunciados simples que permitan expresar de forma lenta ideas o conceptos.','240201502', '228106','Version 102');

-- Trimestre 2 ADSI
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-7', 'Valorar la incidencia de los datos en los procesos del macrosistema, tomando como referente  el diccionario de datos y las miniespecificaciones, para la consolidación de los datos que intervienen, de acuerdo con parámetros establecidos.','220501032','228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-8', 'Elaborar el informe de los resultados del análisis del sistema de información, de acuerdo con los requerimientos del cliente  según normas y protocolos establecidos.','220501032','228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-9', 'Diseñar la arquitectura del software, mediante la interpretación de las clases, objetos y mecanismos de colaboración, utilizando herramientas tecnológicas de diseño, de acuerdo con las tendencias de las tecnologías de la información y la comunicación.','220501033','228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-10', 'Construir el prototipo del sistema de información, a partir del análisis de las características funcionales del sistema en relación con facilidad de manejo, funcionalidad y experiencia del usuario, apoyado en software aplicado según protocolos de diseño.', '220501033', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-11', 'Diseñar  la estructura de datos, a partir del modelo conceptual determinado en el análisis del sistema, utilizando herramientas tecnológicas de bases de datos, según las normas y estándares establecidos', '220501033', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-12', 'Diseñar  la arquitectura tecnológica  del sistema de información, mediante el reconocimiento de hardware y software, de acuerdo con la tecnología disponible en el mercado, el informe de análisis levantado y el diagrama de distribución.','220501033', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-3', 'Leer textos muy breves y sencillos en inglés general y técnico','240201501',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (ETICA)', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.','240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (ETICA)', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.', '240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (ETICA)', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva.','240201500',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-2', 'Identificar formas gramaticales básicas en textos y documentos elementales escritos en inglés.','240201502',  '228106','Version 102');

-- trimestre 3 ADSI
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-13', 'Aplicar políticas y mecanismos de control en el diseño del sistema de información, mediante el análisis de la vulnerabilidad de la información, siguiendo los parámetros establecidos por la organización.','220501033',  '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-14', 'Elaborar el informe de diseño del sistema de información, de acuerdo con la selección de las herramientas, tanto de software como de hardware, requeridas para la solución informática','220501033', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-15', 'Interpretar el informe técnico de diseño, para determinar el plan de trabajo durante la fase de construcción del software, de acuerdo con las normas y protocolos establecidos en la empresa.','220501007', '228106',  'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-16', 'Construir la base de datos, a partir del modelo de datos determinado en el diseño del sistema, utilizando sistemas de gestión de base de datos, según los protocolos establecidos en la organización.','220501007', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-17', 'Construir la interfaz de usuario, apoyado en la evaluación del prototipo, determinando las entradas y salidas requeridas en el diseño y definiendo los lineamientos para la navegación, de acuerdo con las necesidades del usuario.', '220501007', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-18', 'Realizar la codificación de los módulos del sistema y el programa principal, a partir de la utilización del lenguaje de programación seleccionado, de acuerdo con las especificaciones del diseño.', '220501007', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (AMBIENTAL Y CULTURA FISICA)', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. ', '240201500', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (AMBIENTAL Y CULTURA FISICA)', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral . ', '240201500', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (AMBIENTAL Y CULTURA FISICA)', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional. ', '240201500',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-4 (AMBIENTAL Y CULTURA FISICA)', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales. ', '240201500', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-4', 'Encontrar información específica y predecible en escritos sencillos y cotidianos.', '240201501',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-3', 'Comprender una amplia variedad de frases y vocabulario  en inglés sobre temas de interés personal y temas técnicos.', '240201502',  '228106','Version 102');
-- Trimestre 4 ADSI
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-19', 'Construir el programa de instalación del aplicativo, utilizando las herramientas de desarrollo disponibles en el mercado, según las características de la arquitectura de la solución.', '220501007',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-20', 'Elaborar el manual técnico de la aplicación, de acuerdo con la complejidad del aplicativo y según normas y procedimientos establecidos por la empresa.','220501007', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-21', 'Ejecutar y documentar las pruebas del software, aplicando técnicas de ensayo-error, de acuerdo con el plan diseñado y los procedimientos establecidos por la empresa.','220501007',  '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-22', 'Configurar el software de la aplicación para cliente y servidor, mediante la utilización del hardware disponible,  ejecutándola en la plataforma tecnológica, según normas y protocolos establecidos por la empresa.', '220501034',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-23', 'Elaborar el informe administrativo, siguiendo los protocolos de la organización, basado en los planes de instalación, respaldo y migración del sistema de información, facilitando la operatividad y mantenimiento de la solución informática.', '220501034', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-24', 'Definir estrategias para la  validación de manuales de usuario y de operación,  respondiendo a las necesidades y satisfacción del cliente, frente a la solución informática propuesta, según políticas de la organización.', '220501034',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-5', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc','240201501', '228106',  'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-4 ', 'Comprender las ideas principales de textos complejos en inglés que tratan de temas tanto concretos como abstractos, incluso si son de carácter técnico, siempre que estén dentro de su campo de especialización','240201502', '228106', 'Version 102');
	
-- Trimestre 5 ADSI
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-25', 'Capacitar a los usuarios del sistema, sobre la estructuración y el manejo del aplicativo,  de acuerdo con el plan establecido, el perfil de los usuarios, según políticas de la organización.', '220501034',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-26', 'Elaborar informes técnicos relacionados con la solución informática implantada, de acuerdo con las propuestas de alternativas aplicadas, teniendo en cuenta las técnicas de comunicación y según normas y protocolos establecidos', '220501034',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-27', 'Interpretar el diagnóstico de necesidades informáticas, para determinar las tecnológicas requeridas en el manejo de la información, de acuerdo con las normas y protocolos establecidos por la empresa.','220501009', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-28', 'Definir estrategias para la elaboración de términos de referencia y procesos de evaluación de proveedores, en la adquisición de tecnología, según protocolos establecidos.','220501009', '228106',  'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-29', 'Participar en los perfeccionamientos de contratos informáticos, estableciendo cláusulas técnicas, que respondan a las necesidades de los actores de la negociación, de acuerdo con la ley de contratación.', '220501009',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-30', 'Elaborar el informe sobre el cumplimiento de los términos de referencia previstos en la negociación, de acuerdo con la participación de cada uno de los actores en relación con la satisfacción de los bienes informáticos contratados y recibidos, según normas y protocolos de la organización.', '220501009',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-6', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica','240201501',  '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-5', 'Leer textos complejos y con un vocabulario más específico, en inglés general y técnico.', '240201502', '228106', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-6', 'Buscar de manera sistemática información específica y detallada en escritos en inglés, mas estructurados y con mayor contenido técnico. ','240201502', '228106','Version 102');

-- trimestre 6 ADSI

INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-31','Identificar las características de los procesos de desarrollo de software, frente al referente de calidad adoptado por la empresa, ajustándolos a los resultados de las mediciones, evaluaciones y recomendaciones realizadas', '220501035',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-32','Identificar los puntos críticos de control en los procesos de desarrollo de software, para establecer las acciones a seguir, garantizando el cumplimiento de los estándares de calidad, siguiendo los lineamientos establecidos por la organizac', '220501035',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-33','Aplicar los estándares de calidad involucrados en los procesos de desarrollo de software, siguiendo el plan establecido para mantener la integridad de los productos  de trabajo definidos, según las prácticas de configuración establecidas por la empresa','220501035', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-34','Elaborar instrumentos e instructivos, requeridos por el aseguramiento de la calidad, para documentar y evaluar los procesos de desarrollo de software, de acuerdo con las normas y procedimientos establecidas por la empresa.','220501035', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-35','Evaluar procesos y productos de desarrollo de software, documentar y concertar acciones a seguir, para garantizar el cumplimiento de las normas establecidas, de acuerdo con el plan definido y con los criterios de medición, métricas y políticas determinados por la empresa', '220501035',  '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-36','Elaborar el informe final del proceso de gestión de calidad en el desarrollo de software, que consolide la información de las evidencias, hallazgos y novedades frente al seguimiento y control de los productos, según normas internacionales y protocolos de la organización.','220501035', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-7','Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos.', '240201501', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-7','Encontrar y utilizar sin esfuerzo vocabulario y expresiones de inglés técnico en artículos de revistas, libros especializados, páginas web, etc. ','240201502', '228106','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-8','Relacionarse con hablantes nativos en un grado suficiente de fluidez y naturalidad, de modo que la comunicación se realice sin esfuerzo por parte de los interlocutores. ', '240201502', '228106','Version 102');

-- trimestre 1 TPS
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-1', 'INTERPRETAR EL DIAGRAMA RELACIONAL PARA IDENTIFICAR EL MODELO DE DATOS.', '220501032', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-2', 'IDENTIFICAR CADA UNO DE LOS CONCEPTOS Y PRINCIPIOS QUE CONSTITUYE LA PROGRAMACIÓNORIENTADA A OBJETOS PARA INTERPRETAR EL DISEÑO.', '220501032',  '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-3', 'DESCRIBIR QUE SON LOS MODIFICADORES PARA APLICARLOS A UN PROYECTO DE FORMACIÓN','220501032', '228120',  'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-4', 'INTERPRETAR LOS DIAGRAMAS DE CASO DE USO, DE OBJETOS, DE ESTADOS, DE SECUENCIA, DE PAQUETES O COMPONENTES, DE DESPLIEGUE, DE COLABORACIÓN SEGÚN EL DISEÑO ENTREGADO', '220501032', '228120','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (Inducción)', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA.', '240201500',  '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (Inducción)', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional.  ','240201500', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (Inducción)', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles.','240201500', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-4 (Inducción)', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional.', '240201500',  '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (Comunicación)', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social. ','240201500', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (Comunicación)', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.  ', '240201500',  '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (Comunicación)', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social.', '240201500',  '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-1', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos','240201501', '228120',  'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-2', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico.', '240201501', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-3', 'Leer textos muy breves y sencillos en inglés general y técnico','240201501', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-4', 'Encontrar información específica y predecible en escritos sencillos y cotidianos', '240201501', '228120', 'Version 102');


-- trimestre 2 TPS
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-5', 'RELACIONAR LAS TABLAS CONSTRUIDAS PARA PRESENTAR LA INFORMACIÓN SOLICITADA EN EL DISEÑO.', '220501007', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-6', 'CONSTRUIR EL MAPA DE NAVEGACIÓN DE ACUERDO CON EL DISEÑO ENTREGADO PARA ORIENTAR AL USUARIO EN EL USO DEL APLICATIVO.', '220501007', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-7', 'CONSTRUIR LA MATRIZ CRUD EN EL LENGUAJE DE PROGRAMACIÓN SELECCIONADO PARA VERIFICAR LA FUNCIONALIDAD DEL SISTEMA DE ACUERDO CON EL DISEÑO ENTREGADO.', '220501007',  '228120','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAE-8', 'CONSTRUIR LAS TABLAS QUE HACEN PARTE DEL DISEÑO DEL DIAGRAMA RELACIONAL EN EL MOTOR DE BASE DE DATOS EMPLEANDO LAS CUATRO FORMAS DE NORMALIZACIÓN.', '220501007', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (ETICA)', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.', '240201500', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (ETICA)', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral','240201500', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (ETICA)', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva.', '240201500',  '228120','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-1 (AMBIENTAL Y CULTURA FISICA)', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. ', '240201500',  '228120','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-2 (AMBIENTAL Y CULTURA FISICA)', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral', '240201500', '228120', 'Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-3 (AMBIENTAL Y CULTURA FISICA)', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional. ', '240201500', '228120','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAB-4 (AMBIENTAL Y CULTURA FISICA)', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales', '240201500', '228120','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-5', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc', '240201501', '228120','Version 102');
INSERT INTO wariosoft.learning_outcome(learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-6', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica.', '240201501',  '228120','Version 102');
INSERT INTO wariosoft.learning_outcome (learning_Outcome_Code, description, competition_code, program_code, Version) VALUES ('RAT-7', 'Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos.', '240201501', '228120','Version 102');
-------------------------------------------

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAE-1',
'228106',
'220501006',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAE-2', 
'228106', 
'220501006',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAE-3',
'228106',
'220501006',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAE-4',
'228106',
'220501032',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAE-5',
'228106',
'220501032',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAE-6',
'228106',
'220501032',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-1 (Inducción)',
'228106',
'240201500',
'Version 102',
'Tecnologo');



INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-2 (Inducción)', 
'228106', 
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-3 (Inducción)', 
'228106', 
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-4 (Inducción)',
'228106',
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-1 (Comunicación)',
'228106',
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-2 (Comunicación)',
'228106',
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAB-3 (Comunicación)',
'228106',
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAT-1',
'228106',
'240201501',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAT-2',
'228106',
'240201501',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAT-1',
'228106',
'240201502',
'Version 102',
'Tecnologo');

-- TRIMESTRE 2 --------------------------------------------------------------
INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAE-7',
'228106',
'220501032',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAE-8', 
'228106', 
'220501032',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAE-9',
'228106',
'220501033',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAE-10',
'228106',
'220501033',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAE-11',
'228106',
'220501033',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAE-12',
'228106',
'220501033',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAT-3',
'228106',
'240201501',
'Version 102',
'Tecnologo');



INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAB-1 (ETICA)', 
'228106', 
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAB-2 (ETICA)', 
'228106', 
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('2',
'D',
'RAB-3 (ETICA)',
'228106',
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAT-2',
'228106',
'240201502',
'Version 102',
'Tecnologo');

-- TRIMESTRE 3 ---------------------------

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAE-13',
'228106',
'220501033',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAE-14', 
'228106', 
'220501033',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAE-15',
'228106',
'220501007',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAE-16',
'228106',
'220501007',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAE-17',
'228106',
'220501007',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAE-18',
'228106',
'220501007',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAB-1 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'Version 102',
'Tecnologo');



INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAB-2 (AMBIENTAL Y CULTURA FISICA)', 
'228106', 
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAB-3 (AMBIENTAL Y CULTURA FISICA)', 
'228106', 
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAB-4 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('1',
'D',
'RAT-4',
'228106',
'240201501',
'Version 102',
'Tecnologo');
--
INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('3',
'D',
'RAT-3',
'228106',
'240201502',
'Version 102',
'Tecnologo');

-- TRIMESTRE 4 -----------------------------------------

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAE-19',
'228106',
'220501007',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAE-20', 
'228106', 
'220501007',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAE-21',
'228106',
'220501007',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAE-22',
'228106',
'220501034',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAE-23',
'228106',
'220501034',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAE-24',
'228106',
'220501034',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAT-5',
'228106',
'240201501',
'Version 102',
'Tecnologo');



INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('4',
'D',
'RAT-4', 
'228106', 
'240201502',
'Version 102',
'Tecnologo');

-- TRIMESTRE 5 -----------------------------------------

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAE-25',
'228106',
'220501034',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAE-26', 
'228106', 
'220501034',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAE-27',
'228106',
'220501009',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAE-28',
'228106',
'220501009',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAE-29',
'228106',
'220501009',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAE-30',
'228106',
'220501009',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAT-6',
'228106',
'240201501',
'Version 102',
'Tecnologo');



INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAT-5', 
'228106', 
'240201502',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('5',
'D',
'RAT-6', 
'228106', 
'240201502',
'Version 102',
'Tecnologo');

-- TRIMESTRE 6 -----------------------------------------

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAE-31',
'228106',
'220501035',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAE-32', 
'228106', 
'220501035',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAE-33',
'228106',
'220501035',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAE-34',
'228106',
'220501035',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAE-35',
'228106',
'220501035',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAE-36',
'228106',
'220501035',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAT-7',
'228106',
'240201501',
'Version 102',
'Tecnologo');



INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAT-7', 
'228106', 
'240201502',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.learning_outcome_has_trimester
(name_Trimester,
initials_Working_Day,
learning_Outcome_Code,
program_Code,
competition_Code,
version,
training_Level)
VALUES
('6',
'D',
'RAT-8', 
'228106', 
'240201502',
'Version 102',
'Tecnologo');



-------------------------------------------
INSERT INTO wariosoft.state_number_group
(name_State,
state)
VALUES
('En formacion',
'1');

INSERT INTO wariosoft.state_number_group
(name_State,
state)
VALUES
('Terminada',
'1');

INSERT INTO wariosoft.state_number_group
(name_State,
state)
VALUES
('Fusionada',
'1');

INSERT INTO wariosoft.state_number_group
(name_State,
state)
VALUES
('Aplazada',
'1');

INSERT INTO wariosoft.state_number_group
(name_State,
state)
VALUES
('Cancelada',
'1');
-------------------------------------------
INSERT INTO wariosoft.number_group
(number_Group,
start_Date,
end_Date,
route,
name_State,
program_Code,
version)
VALUES
('1349397',
'2016-12-01',
'2018-11-30',
'1-G',
'En formacion',
'228106',
'Version 102');
-------------------------------------------
INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'1',
'D',
'Tecnologo'
);

-- Arriba Duda --

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'2',
'D',
'Tecnologo'
);

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'3',
'D',
'Tecnologo'
);

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'4',
'D',
'Tecnologo'
);

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level)
VALUES
('1349397',
'5',
'D',
'Tecnologo');

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'6',
'D',
'Tecnologo'
);

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'7',
'D',
'Tecnologo'
);

INSERT INTO wariosoft.number_group_has_trimester
(number_Group,
name_Trimester,
initials_Working_Day,
training_Level
)
VALUES
('1349397',
'8',
'D',
'Tecnologo'
);
-------------------------------------------

-- Trimestre 1 ----------------------------------------------------------------

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-1',
'228106',
'220501006',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-2',
'228106',
'220501006',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-3',
'228106',
'220501006',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-4',
'228106',
'220501032',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-5',
'228106',
'220501032',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-6',
'228106',
'220501032',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-1 (Inducción)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-2 (Inducción)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-3 (Inducción)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-4 (Inducción)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-1 (Comunicación)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-2 (Comunicación)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');


INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-3 (Comunicación)',
'228106',
'240201500',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-1',
'228106',
'240201501',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-2',
'228106',
'240201501',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-1',
'228106',
'240201502',
'1',
'1349397',
'D',
'Version 102',
'Tecnologo');

-- Trimestre 2 ----------------------------------------------------------------

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-7',
'228106',
'220501032',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-8',
'228106',
'220501032',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-9',
'228106',
'220501033',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-10',
'228106',
'220501033',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-11',
'228106',
'220501033',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-12',
'228106',
'220501033',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-3',
'228106',
'240201501',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-1 (ETICA)',
'228106',
'240201500',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-2 (ETICA)',
'228106',
'240201500',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-3 (ETICA)',
'228106',
'240201500',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-2',
'228106',
'240201502',
'2',
'1349397',
'D',
'Version 102',
'Tecnologo');

-- Trimestre 3 ----------------------------------------------------------------

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-13',
'228106',
'220501033',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-14',
'228106',
'220501033',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-15',
'228106',
'220501007',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-16',
'228106',
'220501007',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-17',
'228106',
'220501007',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-18',
'228106',
'220501007',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-1 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-2 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-3 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-4 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-4',
'228106',
'240201501',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');
INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-3',
'228106',
'240201502',
'3',
'1349397',
'D',
'Version 102',
'Tecnologo');

-- Trimestre 4 ----------------------------------------------------------------

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-19',
'228106',
'220501007',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-20',
'228106',
'220501007',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-21',
'228106',
'220501007',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-22',
'228106',
'220501034',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-23',
'228106',
'220501034',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-24',
'228106',
'220501034',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-5',
'228106',
'240201501',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-4',
'228106',
'240201502',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-3 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAB-4 (AMBIENTAL Y CULTURA FISICA)',
'228106',
'240201500',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-4',
'228106',
'240201501',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');
INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-3',
'228106',
'240201502',
'4',
'1349397',
'D',
'Version 102',
'Tecnologo');
-- Trimestre 5 ----------------------------------------------------------------

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-25',
'228106',
'220501034',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-26',
'228106',
'220501034',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-27',
'228106',
'220501009',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-28',
'228106',
'220501009',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-29',
'228106',
'220501009',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-30',
'228106',
'220501009',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-6',
'228106',
'240201501',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-5',
'228106',
'240201502',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-6',
'228106',
'240201502',
'5',
'1349397',
'D',
'Version 102',
'Tecnologo');

-- Trimestre 6 ----------------------------------------------------------------

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-31',
'228106',
'220501035',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-32',
'228106',
'220501035',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-33',
'228106',
'220501035',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-34',
'228106',
'220501035',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-35',
'228106',
'220501035',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAE-36',
'228106',
'220501035',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-7',
'228106',
'240201501',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-7',
'228106',
'240201502',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');

INSERT INTO wariosoft.results_viewed
(learning_Outcome_Code,
program_Code,
competition_Code,
name_Trimester,
number_Group,
initials_Working_Day,
version,
training_Level)
VALUES
('RAT-8',
'228106',
'240201502',
'6',
'1349397',
'D',
'Version 102',
'Tecnologo');


-------------------------------------------


INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAE-1',
'228106',
'220501006',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAE-2',
'228106',
'220501006',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAE-3',
'228106',
'220501006',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAE-4',
'228106',
'220501032',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAE-5',
'228106',
'220501032',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAE-6',
'228106',
'220501032',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-1 (Inducción)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-2 (Inducción)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-3 (Inducción)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-4 (Inducción)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-1 (Comunicación)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-2 (Comunicación)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');


INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAB-3 (Comunicación)',
'228106',
'240201500',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAT-1',
'228106',
'240201501',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAT-2',
'228106',
'240201501',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');

INSERT INTO wariosoft.learning_outcome_has_activity
(learning_Outcome_Code,
program_Code,
competition_Code,
id_Activity,
name_Phase,
project_Code,
version)
VALUES
('RAT-1',
'228106',
'240201502',
'1',
'FASE 1: ANÁLISIS',
'576887 v102',
'Version 102');




-------------------------------------------
INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00 ',
'12:00:00',
'1',
'1349397',
'D',
'80013833',
'C.C',
'Lunes',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00',
'12:00:00',
'2',
'1349397',
'D',
'80013833',
'C.C',
'Martes',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00 am',
'12:00:00 am',
'3',
'1349397',
'D',
'80013833',
'C.C',
'Miercoles',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00 am',
'12:00:00 am',
'4',
'1349397',
'D',
'80013833',
'C.C',
'Jueves',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00',
'12:00:00 ',
'5',
'1349397',
'D',
'80013833',
'C.C',
'Viernes',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00 am',
'12:00:00 am',
'6',
'1349397',
'D',
'80013833',
'C.C',
'Sabado',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00 am',
'12:00:00 am',
'7',
'1349397',
'D',
'80013833',
'C.C',
'Domingo',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);

INSERT INTO wariosoft.schedule
(start_Time,
end_Time,
name_Trimester,
number_Group,
initials_Working_Day,
document_Number,
id_Document,
name_Day,
name_Modality,
number_Environment,
name_Headquarters,
id_Version,
id_Current_Quarter,
training_Level
)
VALUES
('06:00:00 am',
'12:00:00 am',
'8',
'1349397',
'D',
'80013833',
'C.C',
'Domingo',
'Presencial',
'303',
'SENA SEDE BARRIO COLOMBIA',
'102',
'1',
'Tecnologo'
);