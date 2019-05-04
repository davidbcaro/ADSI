create schema Tidsplan;

create table tidsplan.project (
	code varchar(100) not null primary key comment 'Cada proyecto tiene un ID –código- de referencia',
    name varchar(100) not null comment 'Se debe asignar un nombre a cada proyecto',
    status boolean not null comment 'El proyecto debe tener un estado de actividad  activo e inactivo'
);

 
  
  
insert into tidsplan.project (code, name, status) values ('569629', 'Implementación de módulos en el Sistema integral web de gestión de procesos educativos para el CEET', true);

create table tidsplan.project_phase (
	name_phase varchar(30) not null comment 'Se debe asignar un nombre a la fase de proyecto',
    status boolean not null comment 'La fase de proyecto debe tener un estado de actividad  activo e inactivo',
    project_code varchar(100) not null comment 'Se le asigna un codigo al proyecto  (llave foranea)',
    constraint fk_pp_project_idx foreign key (project_code) references tidsplan.project(code)  ON UPDATE CASCADE,
    index fk_pp_project_idx(project_code),
	primary key(name_phase, project_code)
);

insert into tidsplan.project_phase (name_phase, status, project_code) values ('ANALISIS', true ,569629);
insert into tidsplan.project_phase (name_phase, status, project_code) values ('PLANEACION', true ,569629);
insert into tidsplan.project_phase (name_phase, status, project_code) values ('EJECUCION', true ,569629);
insert into tidsplan.project_phase (name_phase, status, project_code) values ('EVALUACION', true ,569629);


create table tidsplan.activity(
	id_activity varchar(20) not null comment 'Cada actividad tiene un ID –código- de referencia',
    name varchar(250) not null comment 'Debe asigarse un nombre a las actividades',
    name_phase varchar(30) not null comment 'Se le asigna un nombre a la fase de proyecto  (llave foranea)',
    project_code varchar(100) not null comment 'Se le asigna un codigo a la fase del proyecto  (llave foranea)',
	constraint fk_activity_project_phase_idx foreign key (name_phase, project_code) references tidsplan.project_phase(name_phase, project_code)  ON UPDATE CASCADE,
    index fk_activity_pp_idx(name_phase, project_code),
    primary key(id_activity, name_phase, project_code)
);


insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 3', 'Determinar la estructura lógica del sistema.', 'PLANEACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 4', 'Desarrollar la estructura de datos y de vista de la aplicación del modulo', 'EJECUCION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 5', 'Desarrollar las tareas de configuración y puesta en marcha del sistema.', 'EVALUACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 6', 'Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos.', 'EVALUACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 2', 'Determinar los requerimientos del sistema según especificaciones y lineamientos del proyecto.', 'ANALISIS', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 3', 'Analizar procesos, datos y necesidades del centro de electricidad, electrónica y telecomunicaciones y el usuario final para el modulo especifico.', 'ANALISIS', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 4', 'Especificar modelo conceptual del sistema, especificando necesidades y requerimientos', 'PLANEACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 1', 'Actividades de  inducción en la formación profesional integral SENA', 'ANALISIS', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 8', ' Desarrollo los módulos del sistema integral web de acuerdo a los estándares de calidad y normatividad  legal vigente.', 'EJECUCION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 5', 'Determinar la estructura lógica del sistema', 'PLANEACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 6', 'Diseñar  la estructura tecnológica  del sistema integral', 'PLANEACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 9', 'Preparar documentación del proceso de implantación del sistema', 'EVALUACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 7', 'Desarrollar la estructura de datos y de vista de la aplicación del modulo', 'EJECUCION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 10', 'Desarrollar las tareas de configuración y puesta en marcha del sistema ', 'EVALUACION', '569629');
insert into tidsplan.activity (id_activity, name, name_phase, project_code) values ('Actividad 11', ' Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos.', 'EVALUACION', '569629');



create table tidsplan.formation_level (
	level_formation varchar(45) primary key not null comment 'Debe aparecer el nivel de formación: técnico, tecnólogo, especialización y tecnológica',
    status boolean not null comment 'El programa debe tener un estado activo o inactivo'
);

insert into tidsplan.formation_level (level_formation, status) values ('tecnico', true);
insert into tidsplan.formation_level (level_formation, status) values ('tecnologo', true);
insert into tidsplan.formation_level (level_formation, status) values ('especializacion', true);
insert into tidsplan.formation_level (level_formation, status) values ('tecnologica', true);




create table tidsplan.training_program (
	id_code varchar(70) not null comment 'Cada programa de formación tiene un ID código de referencia',
    name varchar(70) not null comment 'El programa de formación debe tener un nombre',
    version varchar(50) not null comment 'El programa de formación debe tener una versión',
    initials varchar(20) not null comment 'Debe tener unas iniciales, por ejemplo ADSI-AD, Gestión empresarial-GE, etc',
    status boolean not null comment 'El programa debe tener un estado de actividad  activo e inactivo',
    level_formation varchar(50) not null comment 'Se asignan los niveles de formacion  (llave foranea)',
    constraint fk_tp_fl_idx foreign key (level_formation) references tidsplan.formation_level(level_formation)  ON UPDATE CASCADE,
    index fk_activity_pp_idx(level_formation),
	primary key (id_code, version)
);

insert into tidsplan.training_program (id_code, name, version, initials, status, level_formation) values ('228120', 'TÉCNICO EN PROGRAMACIÓN DE SOFTWARE', '102', 'TPS', true, 'Técnico');
insert into tidsplan.training_program (id_code, name, version, initials, status, level_formation) values ('228106', 'ANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION', '102', 'ADSI', true, 'Tecnólogo');

create table tidsplan.competition (
	code varchar(100) not null comment 'Cada Competencia tiene un ID –código- de referencia',
    description varchar(150) not null comment 'Idea sobre la competencia ',
    program_code varchar(100) not null comment 'Cada programa de formación tiene un ID código de referencia (llave foranea)',
    program_version varchar(10) not null comment 'El programa de formación debe tener una versión (llave foranea)', 
    constraint fk_competition_tp foreign key (program_code, program_version) references tidsplan.training_program (id_code, version)  ON UPDATE CASCADE,
    index fk_competition_tp_idx (program_code, program_version), 
	primary key (code, program_code, program_version)
);

-- TPS 
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501032', 'Analizar los requerimientos del cliente para construir el sistema de información', '228120', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('240201500', 'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social.', '228120', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('240201501', 'Comprender textos en inglés en forma escrita y auditiva.', '228120', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501007', 'Construir el sistema que cumpla con los requisitos de la solución informática.','228120', '102');

-- ADSI 
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501006', 'Especificar los requisitos necesarios para desarrollar el sistema de información de acuerdo con las necesidades del cliente.','228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('240201500', 'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('240201501', 'Comprender textos en inglés en forma escrita y auditiva.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('240201502', 'Producir textos en inglés en forma escrita y oral.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501032', 'Analizar los requisitos del cliente para construir el sistema de información.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501033', 'Diseñar el sistema de acuerdo con los requerimientos del cliente.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501007', 'Construir el sistema que cumpla con los requisitos de la solución informática.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501034', 'Implantar la solución que cumpla con los requerimientos para su operación.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501009', 'Participar en el proceso de negociación de Tecnología informática para permitir la implementación del sistema de información.', '228106', '102');
insert into tidsplan.competition (code, description, program_code, program_version) values ('220501035', ' Aplicar buenas prácticas de calidad en el proceso de desarrollo de software, de acuerdo con el referente adoptado en la empresa ', '228106', '102');





create table tidsplan.learning_result (
	id_code varchar(100) not null comment 'Cada resultado de aprendizaje tiene un ID –código- de referencia', 
    description text not null comment 'resultado de aprendizaje.',
    program_code varchar(100) not null comment 'Se le asigna un codigo al programa de formacion  (llave foranea)',
    competition_code varchar(100) not null comment 'Se le asigna un codigo a la competencia  (llave foranea)',
    program_version varchar (20) not null comment 'El programa de formación debe tener una versión (llave foranea)', 
    constraint fk_lr_competition foreign key (competition_code, program_code, program_version) references tidsplan.competition (code, program_code, program_version)  ON UPDATE CASCADE,
	index fk_lr_competition_idx (program_code, competition_code, program_version),
    primary key(id_code, program_code, competition_code, program_version)
);

-- trimestre 1 ADSI 
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-1', 'Aplicar las técnicas de recolección de datos , diseñando  los instrumentos necesarios para el procesamiento de información, de acuerdo con la situación planteada por la empresa.', '228106', '220501006', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-2', 'Elaborar mapas de procesos que permitan identificar las áreas involucradas en un sistema de información, utilizando herramientas informáticas y las Tic’s, para generar informes según las necesidades de la empresa.', '228106', '220501006', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-3', 'Plantear diferentes alternativas, de modelos tecnológicos de información empresarial, teniendo en cuenta la plataforma  tecnológica de la empresa y las tendencias del mercado, para dar solución a las situaciones relacionadas con el manejo de la información de la organización.', '228106', '220501006', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-4', 'Interpretar el informe de requerimientos, para determinar las necesidades tecnológicas en el manejo de la información, de acuerdo con las normas y protocolos establecidos en la empresa.', '228106', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-5', 'Representa el bosquejo de la solución al problema presentado por el cliente, mediante la  elaboración de diagramas de casos de uso,  apoyado en el análisis del informe de requerimientos, al confrontar la situación problemica con el usuario según  normas y protocolos de la organización.', '228106', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-6', 'Construir el modelo conceptual del macrosistema frente a los requerimientos del cliente,  mediante el uso e interpretación de la información levantada, representado en diagramas de clase, de interacción, colaboración y contratos de operación, de acuerdo con las diferentes secuencias, fases y procedimientos del sistema.', '228106', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (Inducción)', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (Inducción)', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (Inducción)', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles.  ', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-4 (Inducción)', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (Comunicación)', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social. ', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (Comunicación)', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (Comunicación)', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-1', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos.', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-2', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico.', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-1', 'Reproducir en inglés frases o enunciados simples que permitan expresar de forma lenta ideas o conceptos.', '228106', '240201502', '102');

-- Trimestre 2 ADSI
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-7', 'Valorar la incidencia de los datos en los procesos del macrosistema, tomando como referente  el diccionario de datos y las miniespecificaciones, para la consolidación de los datos que intervienen, de acuerdo con parámetros establecidos.', '228106', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-8', 'Elaborar el informe de los resultados del análisis del sistema de información, de acuerdo con los requerimientos del cliente  según normas y protocolos establecidos.', '228106', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-9', 'Diseñar la arquitectura del software, mediante la interpretación de las clases, objetos y mecanismos de colaboración, utilizando herramientas tecnológicas de diseño, de acuerdo con las tendencias de las tecnologías de la información y la comunicación.', '228106', '220501033', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-10', 'Construir el prototipo del sistema de información, a partir del análisis de las características funcionales del sistema en relación con facilidad de manejo, funcionalidad y experiencia del usuario, apoyado en software aplicado según protocolos de diseño.', '228106', '220501033', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-11', 'Diseñar  la estructura de datos, a partir del modelo conceptual determinado en el análisis del sistema, utilizando herramientas tecnológicas de bases de datos, según las normas y estándares establecidos', '228106', '220501033', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-12', 'Diseñar  la arquitectura tecnológica  del sistema de información, mediante el reconocimiento de hardware y software, de acuerdo con la tecnología disponible en el mercado, el informe de análisis levantado y el diagrama de distribución.', '228106', '220501033', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-3', 'Leer textos muy breves y sencillos en inglés general y técnico', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (ETICA)', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (ETICA)', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (ETICA)', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva.', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-2', 'Identificar formas gramaticales básicas en textos y documentos elementales escritos en inglés.', '228106', '240201502', '102');

-- trimestre 3 ADSI
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-13', 'Aplicar políticas y mecanismos de control en el diseño del sistema de información, mediante el análisis de la vulnerabilidad de la información, siguiendo los parámetros establecidos por la organización.', '228106', '220501033', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-14', 'Elaborar el informe de diseño del sistema de información, de acuerdo con la selección de las herramientas, tanto de software como de hardware, requeridas para la solución informática', '228106', '220501033', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-15', 'Interpretar el informe técnico de diseño, para determinar el plan de trabajo durante la fase de construcción del software, de acuerdo con las normas y protocolos establecidos en la empresa.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-16', 'Construir la base de datos, a partir del modelo de datos determinado en el diseño del sistema, utilizando sistemas de gestión de base de datos, según los protocolos establecidos en la organización.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-17', 'Construir la interfaz de usuario, apoyado en la evaluación del prototipo, determinando las entradas y salidas requeridas en el diseño y definiendo los lineamientos para la navegación, de acuerdo con las necesidades del usuario.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-18', 'Realizar la codificación de los módulos del sistema y el programa principal, a partir de la utilización del lenguaje de programación seleccionado, de acuerdo con las especificaciones del diseño.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (AMBIENTAL Y CULTURA FISICA)', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. ', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (AMBIENTAL Y CULTURA FISICA)', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral . ', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (AMBIENTAL Y CULTURA FISICA)', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional. ', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-4 (AMBIENTAL Y CULTURA FISICA)', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales. ', '228106', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-4', 'Encontrar información específica y predecible en escritos sencillos y cotidianos.', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-3', 'Comprender una amplia variedad de frases y vocabulario  en inglés sobre temas de interés personal y temas técnicos.', '228106', '240201502', '102');
-- Trimestre 4 ADSI
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-19', 'Construir el programa de instalación del aplicativo, utilizando las herramientas de desarrollo disponibles en el mercado, según las características de la arquitectura de la solución.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-20', 'Elaborar el manual técnico de la aplicación, de acuerdo con la complejidad del aplicativo y según normas y procedimientos establecidos por la empresa.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-21', 'Ejecutar y documentar las pruebas del software, aplicando técnicas de ensayo-error, de acuerdo con el plan diseñado y los procedimientos establecidos por la empresa.', '228106', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-22', 'Configurar el software de la aplicación para cliente y servidor, mediante la utilización del hardware disponible,  ejecutándola en la plataforma tecnológica, según normas y protocolos establecidos por la empresa.', '228106', '220501034', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-23', 'Elaborar el informe administrativo, siguiendo los protocolos de la organización, basado en los planes de instalación, respaldo y migración del sistema de información, facilitando la operatividad y mantenimiento de la solución informática.', '228106', '220501034', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-24', 'Definir estrategias para la  validación de manuales de usuario y de operación,  respondiendo a las necesidades y satisfacción del cliente, frente a la solución informática propuesta, según políticas de la organización.', '228106', '220501034', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-5', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-4 ', 'Comprender las ideas principales de textos complejos en inglés que tratan de temas tanto concretos como abstractos, incluso si son de carácter técnico, siempre que estén dentro de su campo de especialización', '228106', '240201502', '102');
	
-- Trimestre 5 ADSI
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-25', 'Capacitar a los usuarios del sistema, sobre la estructuración y el manejo del aplicativo,  de acuerdo con el plan establecido, el perfil de los usuarios, según políticas de la organización.', '228106', '220501034', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-26', 'Elaborar informes técnicos relacionados con la solución informática implantada, de acuerdo con las propuestas de alternativas aplicadas, teniendo en cuenta las técnicas de comunicación y según normas y protocolos establecidos', '228106', '220501034', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-27', 'Interpretar el diagnóstico de necesidades informáticas, para determinar las tecnológicas requeridas en el manejo de la información, de acuerdo con las normas y protocolos establecidos por la empresa.', '228106', '220501009', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-28', 'Definir estrategias para la elaboración de términos de referencia y procesos de evaluación de proveedores, en la adquisición de tecnología, según protocolos establecidos.', '228106', '220501009', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-29', 'Participar en los perfeccionamientos de contratos informáticos, estableciendo cláusulas técnicas, que respondan a las necesidades de los actores de la negociación, de acuerdo con la ley de contratación.', '228106', '220501009', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-30', 'Elaborar el informe sobre el cumplimiento de los términos de referencia previstos en la negociación, de acuerdo con la participación de cada uno de los actores en relación con la satisfacción de los bienes informáticos contratados y recibidos, según normas y protocolos de la organización.', '228106', '220501009', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-6', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-5', 'Leer textos complejos y con un vocabulario más específico, en inglés general y técnico.', '228106', '240201502', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-6', 'Buscar de manera sistemática información específica y detallada en escritos en inglés, mas estructurados y con mayor contenido técnico. ', '228106', '240201502', '102');

-- trimestre 6 ADSI

INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-31','Identificar las características de los procesos de desarrollo de software, frente al referente de calidad adoptado por la empresa, ajustándolos a los resultados de las mediciones, evaluaciones y recomendaciones realizadas', '228106', '220501035', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-32','Identificar los puntos críticos de control en los procesos de desarrollo de software, para establecer las acciones a seguir, garantizando el cumplimiento de los estándares de calidad, siguiendo los lineamientos establecidos por la organizac', '228106', '220501035', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-33','Aplicar los estándares de calidad involucrados en los procesos de desarrollo de software, siguiendo el plan establecido para mantener la integridad de los productos  de trabajo definidos, según las prácticas de configuración establecidas por la empresa', '228106', '220501035', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-34','Elaborar instrumentos e instructivos, requeridos por el aseguramiento de la calidad, para documentar y evaluar los procesos de desarrollo de software, de acuerdo con las normas y procedimientos establecidas por la empresa.', '228106', '220501035', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-35','Evaluar procesos y productos de desarrollo de software, documentar y concertar acciones a seguir, para garantizar el cumplimiento de las normas establecidas, de acuerdo con el plan definido y con los criterios de medición, métricas y políticas determinados por la empresa', '228106', '220501035', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-36','Elaborar el informe final del proceso de gestión de calidad en el desarrollo de software, que consolide la información de las evidencias, hallazgos y novedades frente al seguimiento y control de los productos, según normas internacionales y protocolos de la organización.', '228106', '220501035', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-7','Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos.', '228106', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-7','Encontrar y utilizar sin esfuerzo vocabulario y expresiones de inglés técnico en artículos de revistas, libros especializados, páginas web, etc. ', '228106', '240201502', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-8','Relacionarse con hablantes nativos en un grado suficiente de fluidez y naturalidad, de modo que la comunicación se realice sin esfuerzo por parte de los interlocutores. ', '228106', '240201502', '102');

-- trimestre 1 TPS
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-1', 'INTERPRETAR EL DIAGRAMA RELACIONAL PARA IDENTIFICAR EL MODELO DE DATOS.', '228120', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-2', 'IDENTIFICAR CADA UNO DE LOS CONCEPTOS Y PRINCIPIOS QUE CONSTITUYE LA PROGRAMACIÓNORIENTADA A OBJETOS PARA INTERPRETAR EL DISEÑO.', '228120', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-3', 'DESCRIBIR QUE SON LOS MODIFICADORES PARA APLICARLOS A UN PROYECTO DE FORMACIÓN', '228120', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-4', 'INTERPRETAR LOS DIAGRAMAS DE CASO DE USO, DE OBJETOS, DE ESTADOS, DE SECUENCIA, DE PAQUETES O COMPONENTES, DE DESPLIEGUE, DE COLABORACIÓN SEGÚN EL DISEÑO ENTREGADO', '228120', '220501032', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (Inducción)', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA.', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (Inducción)', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional.  ', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (Inducción)', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles.', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-4 (Inducción)', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional.', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (Comunicación)', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social. ', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (Comunicación)', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.  ', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (Comunicación)', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social.', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-1', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos', '228120', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-2', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico.', '228120', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-3', 'Leer textos muy breves y sencillos en inglés general y técnico', '228120', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-4', 'Encontrar información específica y predecible en escritos sencillos y cotidianos', '228120', '240201501', '102');


-- trimestre 2 TPS
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-5', 'RELACIONAR LAS TABLAS CONSTRUIDAS PARA PRESENTAR LA INFORMACIÓN SOLICITADA EN EL DISEÑO.', '228120', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-6', 'CONSTRUIR EL MAPA DE NAVEGACIÓN DE ACUERDO CON EL DISEÑO ENTREGADO PARA ORIENTAR AL USUARIO EN EL USO DEL APLICATIVO.', '228120', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-7', 'CONSTRUIR LA MATRIZ CRUD EN EL LENGUAJE DE PROGRAMACIÓN SELECCIONADO PARA VERIFICAR LA FUNCIONALIDAD DEL SISTEMA DE ACUERDO CON EL DISEÑO ENTREGADO.', '228120', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAE-8', 'CONSTRUIR LAS TABLAS QUE HACEN PARTE DEL DISEÑO DEL DIAGRAMA RELACIONAL EN EL MOTOR DE BASE DE DATOS EMPLEANDO LAS CUATRO FORMAS DE NORMALIZACIÓN.', '228120', '220501007', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (ETICA)', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (ETICA)', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (ETICA)', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva.', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-1 (AMBIENTAL Y CULTURA FISICA)', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. ', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-2 (AMBIENTAL Y CULTURA FISICA)', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral . ', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-3 (AMBIENTAL Y CULTURA FISICA)', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional. ', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAB-4 (AMBIENTAL Y CULTURA FISICA)', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales', '228120', '240201500', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-5', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc', '228120', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-6', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica.', '228120', '240201501', '102');
INSERT INTO tidsplan.learning_result (id_code, description, program_code, competition_code, program_version) VALUES ('RAT-7', 'Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos.', '228120', '240201501', '102');





	

create table tidsplan.learning_result_has_activity (
	lr_code varchar(100) not null comment 'Se le asigna un codigo al resultado de aprendizaje ',
    program_code varchar(100) not null comment 'Se le asigna un codigo al programa  (llave foranea)',
    competition_code varchar(100) not null comment 'Se le asigna un codigo a la competencia  (llave foranea)', 
	id_activity varchar(50) not null comment 'Se le asigna un ID a la actividad  (llave foranea)',
	name_phase varchar(20) not null comment 'Se le asigna un nombre a la fase  (llave foranea)', 
    project_code varchar(100) not null comment 'Se le asigna un codigo al proyecto',
    program_version varchar (20) not null comment 'El programa de formación debe tener una versión (llave foranea)', 
    constraint fk_lrha_lr foreign key (lr_code, program_code, competition_code, program_version) references tidsplan.learning_result(id_code, program_code, competition_code, program_version)  ON UPDATE CASCADE,
	index fk_lrha_lr_idx(lr_code, program_code, competition_code, project_code),
    constraint fk_lrha_activity foreign key (id_activity, name_phase, project_code) references tidsplan.activity (id_activity, name_phase, project_code)  ON UPDATE CASCADE,
	index fk_lrha_activity_idx(id_activity, name_phase, project_code),
    primary key (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version)
);

-- ADSI TRIMESTRE 1

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-1', '228106', '220501006', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-2', '228106', '220501006', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-3', '228106', '220501006', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-4', '228106', '220501032', 'Actividad 3', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-5', '228106', '220501032', 'Actividad 4', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-6', '228106', '220501032', 'Actividad 4', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (Inducción)', '228106', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (Inducción)', '228106', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (Inducción)', '228106', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-4 (Inducción)', '228106', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (Comunicación)', '228106', '240201500', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (Comunicación)', '228106', '240201500', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (Comunicación)', '228106', '240201500', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-1', '228106', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-2', '228106', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-1', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');

-- ADSI TRIMESTRE 2 

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-7', '228106', '220501032', 'Actividad 3', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-8', '228106', '220501032', 'Actividad 4', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-9', '228106', '220501033', 'Actividad 5', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-10', '228106', '220501033', 'Actividad 5', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-11', '228106', '220501033', 'Actividad 5', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-12', '228106', '220501033', 'Actividad 6', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-3', '228106', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (ETICA)', '228106', '240201500', 'Actividad 4', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (ETICA)', '228106', '240201500', 'Actividad 6', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (ETICA)', '228106', '240201500', 'Actividad 9', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-2', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');

-- ADSI TRIMESTRE 3 

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-13', '228106', '220501033', 'Actividad 5', 'PLANEACIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-14', '228106', '220501033', 'Actividad 6', 'PLANEACIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-15', '228106', '220501007', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-16', '228106', '220501007', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-17', '228106', '220501007', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-18', '228106', '220501007', 'Actividad 8', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-4', '228106', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-4 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'Actividad 7', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-3', '228106', '240201502', 'Actividad 8', 'EJECUCIÓN', '569629', '102');

-- ADSI TRIMESTRE 4 

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-19', '228106', '220501007', 'Actividad 8', 'EJECUCIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-20', '228106', '220501007', 'Actividad 9', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-21', '228106', '220501007', 'Actividad 9', 'EVALUACIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-22', '228106', '220501034', 'Actividad 10', 'EVALUACIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-23', '228106', '220501034', 'Actividad 10', 'EVALUACIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-24', '228106', '220501034', 'Actividad 11', 'EVALUACIÓN', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-5', '228106', '240201501', 'Actividad 6', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-4', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');

-- ADSI TRIMESTRE 5

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-25', '228106', '220501034', 'Actividad 10', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-26', '228106', '220501034', 'Actividad 11', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-27', '228106', '220501009', 'Actividad 3', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-28', '228106', '220501009', 'Actividad 6', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-29', '228106', '220501009', 'Actividad 10', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-30', '228106', '220501009', 'Actividad 10', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-6', '228106', '240201501', 'Actividad 7', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-5', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-6', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');

-- ADSI TRIMESTRE 6

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-31', '228106', '220501035', 'Actividad 3', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-32', '228106', '220501035', 'Actividad 4', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-33', '228106', '220501035', 'Actividad 8', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-34', '228106', '220501035', 'Actividad 5', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-35', '228106', '220501035', 'Actividad 11', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-36', '228106', '220501035', 'Actividad 8', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-7', '228106', '240201501', 'Actividad 8', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-7', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-8', '228106', '240201502', 'Actividad 8', 'EJECUCION', '569629', '102');

-- TPS TRIMESTRE 1 

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-1', '228120', '220501032', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-2', '228120', '220501032', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-3', '228120', '220501032', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-4', '228120', '220501032', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (Inducción)', '228120', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (Inducción)', '228120', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (Inducción)', '228120', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-4 (Inducción)', '228120', '240201500', 'Actividad 1', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (Comunicación)', '228120', '240201500', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (Comunicación)', '228120', '240201500', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (Comunicación)', '228120', '240201500', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-1', '228120', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-2', '228120', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-3', '228120', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-4', '228120', '240201501', 'Actividad 2', 'ANALISIS', '569629', '102');

-- TPS TRIMESTRE 2  

insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-5', '228120', '220501007', 'Actividad 4', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-6', '228120', '220501007', 'Actividad 4', 'EJECUCION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-7', '228120', '220501007', 'Actividad 5', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAE-8', '228120', '220501007', 'Actividad 6', 'EVALUACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (ETICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (ETICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (ETICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-1 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-2 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-3 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAB-4 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-5 ', '228120', '240201501', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-6 ', '228120', '240201501', 'Actividad 3', 'PLANEACION', '569629', '102');
insert into tidsplan.learning_result_has_activity (lr_code, program_code, competition_code, id_activity, name_phase, project_code, program_version) values ('RAT-7 ', '228120', '240201501', 'Actividad 3', 'PLANEACION', '569629', '102');



create table tidsplan.state_group (
	name_state varchar(15) primary key comment 'Se debe asignar un nombre a el estado de la ficha',
    status boolean not null comment 'El estado de ficha debe tener un estado de actividad  aplazado, en formación, fusión, oferta cerrada y terminado'
);

insert into tidsplan.state_group (name_state, status) values ('En formacion', true);
insert into tidsplan.state_group (name_state, status) values ('Aplazada', true);
insert into tidsplan.state_group (name_state, status) values ('Fusionada', true);
insert into tidsplan.state_group (name_state, status) values ('Oferta cerrada', true);
insert into tidsplan.state_group (name_state, status) values ('Terminada', true);






create table tidsplan.group (
	number_group varchar(100) not null comment 'Se debe asignar un número a cada ficha',
    start_date date not null comment 'Se asigna una fecha de inicio de la ficha ',
    end_date date not null comment 'Tiempo en el que se determina la fecha final de esta ficha ',
    route varchar(15)  not null comment 'Ruta especifica con un numero asignado',
    name_state varchar(15)  not null comment 'El nombre que se asigna al estado (llave foranea)', 
    version varchar(20) not null comment 'El programa de formación debe tener una versión',
    program_code varchar(100) not null comment 'Cada programa de formación tiene un ID código de referencia (llave foranea)',
	constraint fk_group_sg foreign key (name_state) references tidsplan.state_group(name_state)  ON UPDATE CASCADE,
	index fk_group_sg_idx(name_state) ,
    constraint fk_group_tp foreign key (program_code, version) references tidsplan.training_program (id_code, version)  ON UPDATE CASCADE,
    index fk_group_tp_idx (program_code, version) ,
    primary key (number_group)
);

insert into tidsplan.group (number_group, start_date, end_date, route, name_state, version, program_code) values ('1349397', '2017-01-23', '2018-11-23', '3123', 'En formacion', '102', '228106'   );
insert into tidsplan.group (number_group, start_date, end_date, route, name_state, version, program_code) values ('1234456', '2017-01-23', '2017-11-23', '3343', 'En formacion', '102', '228120'   );





create table tidsplan.working_day (
	initials varchar(10) primary key not null comment 'Cada jornada debe tener las iniciales Diurna-DI, Nocturna-NO, Fines de semana-FS, Madrugada-MA ',
    name varchar(45) not null comment 'Cada jornada debe tener un nombre Diurna, Nocturna, Fines de semana, Madrugada ',
    description text comment 'Tiempo estimado para cada jornada ',
    image blob(100) comment 'Imagen que identifique cada jornada ',
    status boolean not null comment 'Debe tener el estado en que se encuentra la jornada activa o inactiva'    
);

insert into tidsplan.working_day (initials, name, description, image, status) values ('D', 'Diurna', 'Jornada diurna de 6:00 AM a 6:00 PM ',' ', true);
insert into tidsplan.working_day (initials, name, description, image, status) values ('N', 'Nocturna', 'Jornada Nocturna de 6:00 PM a 10:00 PM'  , ' ', true);
insert into tidsplan.working_day (initials, name, description, image, status) values ('FS', 'Fines de semana', 'Fines de semana de 6:00 AM a 6:00 PM', ' ', true);





create table tidsplan.trimester (
	name_trimester varchar(20) not null comment 'Se asigna un nombre a cada trimestre ',
    workingday_initials varchar(10) not null comment 'Se le asignan iniciales a la jornada (llave foranea)',
	level_formation varchar(50) not null comment 'Se le asigna un nivel de formacion ',
	constraint fk_trimester_working_day foreign key (workingday_initials) references tidsplan.working_day(initials)  ON UPDATE CASCADE,
    index fk_trimester_working_day_idx(workingday_initials),
    constraint fk_trimester_fl foreign key (level_formation) references tidsplan.formation_level(level_formation)  ON UPDATE CASCADE,
	index fk_trimester_fl_idx(level_formation),
    primary key (name_trimester, workingday_initials, level_formation)
);

insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-1', 'D', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-2', 'D', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-3', 'D', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-4', 'D', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-5', 'D', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-6', 'D', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-1', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-2', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-3', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-4', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-5', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-6', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-7', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-8', 'N', 'tecnologo');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-1', 'D', 'tecnico');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-2', 'D', 'tecnico');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-1', 'N', 'tecnico');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-2', 'N', 'tecnico');
insert into tidsplan.trimester (name_trimester, workingday_initials, level_formation) values ('trimestre-3', 'N', 'tecnico');






create table tidsplan.quarter_planning (
	name_trimester varchar(20) not null comment 'Se le asigna un nombre al trimestre  (llave foranea)',
	workingday_initials varchar(10) not null comment 'Se le asignan las iniciales a la jornada  (llave foranea)',
    lr_code varchar(100) not null comment 'Se le asigna un codigo al resultado de aprendizaje  (llave foranea)',
    program_code varchar(100) not null comment 'Se le asigna un codigo al programa de formacion  (llave foranea)',
    competition_code varchar(100) not null comment 'Se le asigna un codigo a la competencia  (llave foranea)',
    level_formation varchar(50) not null comment 'Se le asigna un nivel de formacion ',
    program_version varchar (20) not null comment 'El programa de formación debe tener una versión (llave foranea)', 
    constraint fk_qp_trimester foreign key (name_trimester, workingday_initials, level_formation) references tidsplan.trimester(name_trimester, workingday_initials, level_formation)  ON UPDATE CASCADE,
	index fk_qp_trimester_idx(name_trimester, workingday_initials,level_formation),
    constraint fk_qp_lr foreign key (lr_code, program_code, competition_code, program_version) references tidsplan.learning_result(id_code, program_code, competition_code, program_version)  ON UPDATE CASCADE,
    index fk_trimester_fll_idx(lr_code, program_code, competition_code, program_version),
    primary key (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version)
    
);

-- ADSI	TRIMESTRE 1

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-1', '228106', '220501006', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-2', '228106', '220501006', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-3', '228106', '220501006', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-4', '228106', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-5', '228106', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-6', '228106', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-1 (Inducción)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-2 (Inducción)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-3 (Inducción)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-4 (Inducción)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-1 (Comunicación)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-2 (Comunicación)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-3 (Comunicación)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-1', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-2', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-1', '228106', '240201502', 'tecnologo', '102' );

-- ADSI TRIMESTRE 2

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-7', '228106', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-8', '228106', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-9', '228106', '220501033', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-10', '228106', '220501033', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-11', '228106', '220501033', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-12', '228106', '220501033', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAT-3', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-1 (ETICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-2 (ETICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-3 (ETICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAT-2', '228106', '240201502', 'tecnologo', '102' );

-- ADSI TRIMESTRE 3

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAE-13', '228106', '220501033', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAE-14', '228106', '220501033', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAE-15', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAE-16', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAE-17', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAE-18', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAT-4', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAB-1 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAB-2 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAB-3 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAB-4 (AMBIENTAL Y CULTURA FISICA)', '228106', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-3', 'D', 'RAT-3', '228106', '240201502', 'tecnologo', '102' );

-- ADSI TRIMESTRE 4

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAE-19', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAE-20', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAE-21', '228106', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAE-22', '228106', '220501034', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAE-23', '228106', '220501034', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAE-24', '228106', '220501034', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAT-5', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-4', 'D', 'RAT-4', '228106', '240201502', 'tecnologo', '102' );

-- ADSI TRIMESTRE 5

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAE-25', '228106', '220501034', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAE-26', '228106', '220501034', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAE-27', '228106', '220501009', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAE-28', '228106', '220501009', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAE-29', '228106', '220501009', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAE-30', '228106', '220501009', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAT-6', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAT-5', '228106', '240201502', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-5', 'D', 'RAT-6', '228106', '240201502', 'tecnologo', '102' );


-- ADSI TRIMESTRE 6 

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAE-31', '228106', '220501035', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAE-32', '228106', '220501035', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAE-33', '228106', '220501035', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAE-34', '228106', '220501035', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAE-35', '228106', '220501035', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAE-36', '228106', '220501035', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAT-7', '228106', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAT-7', '228106', '240201502', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-6', 'D', 'RAT-8', '228106', '240201502', 'tecnologo', '102' );

-- TPS TRIMESTRE 1

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-1', '228120', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-2', '228120', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-3', '228120', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAE-4', '228120', '220501032', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-1 (Inducción)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-2 (Inducción)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-3 (Inducción)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-4 (Inducción)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-1 (Comunicación)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-2 (Comunicación)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAB-3 (Comunicación)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-1', '228120', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-2', '228120', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-3', '228120', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-1', 'D', 'RAT-4', '228120', '240201501', 'tecnologo', '102' );

-- TPS TRIMESTRE 2

insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-5', '228120', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-6', '228120', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-7', '228120', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAE-8', '228120', '220501007', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-1 (ETICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-2 (ETICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-3 (ETICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-1 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-2 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-3 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAB-4 (AMBIENTAL Y CULTURA FISICA)', '228120', '240201500', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAT-5', '228120', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAT-6', '228120', '240201501', 'tecnologo', '102' );
insert into tidsplan.quarter_planning (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version) values ('trimestre-2', 'D', 'RAT-7', '228120', '240201501', 'tecnologo', '102' );




create table tidsplan.group_has_trimester (
	number_group varchar(100) not null comment 'Se le asigna un numero a la ficha (llave foranea)',
    name_trimester varchar(20) not null comment 'Se le aisgna un nombre al trimestre (llave foranea)',
    workingday_initials varchar (10) not null comment 'Se le asignan iniciales a la jornada (llave foranea)',
    level_formation varchar (50) not null comment 'Se le asigna un nivel de formacion ',    
	constraint fk_ght_group foreign key (number_group) references tidsplan.group(number_group)  ON UPDATE CASCADE,
	index fk_ght_group_idx(number_group),
    constraint fk_ght_trimester foreign key (name_trimester, workingday_initials, level_formation) references tidsplan.trimester(name_trimester, workingday_initials, level_formation)  ON UPDATE CASCADE,
	index fk_ght_trimester_idx(name_trimester, workingday_initials, level_formation),
    primary key(number_group, name_trimester, workingday_initials, level_formation)
);


insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1349397', 'trimestre-1', 'D', 'tecnologo');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1349397', 'trimestre-2', 'D', 'tecnologo');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1349397', 'trimestre-3', 'D', 'tecnologo');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1349397', 'trimestre-4', 'D', 'tecnologo');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1349397', 'trimestre-5', 'D', 'tecnologo');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1349397', 'trimestre-6', 'D', 'tecnologo');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1234456', 'trimestre-1', 'D', 'tecnico');
insert into tidsplan.group_has_trimester (number_group, name_trimester, workingday_initials, level_formation) values ('1234456', 'trimestre-2', 'D', 'tecnico');


create table tidsplan.results_viewed (
	name_trimester varchar(20) not null comment 'Se le asigna un nombre al trimestre (llave foranea) ',
	workingday_initials varchar (10) not null comment 'Se le asignan iniciales  a la jornada (llave foranea)',
	lr_code varchar(100) not null comment 'Se le asigna un codigo al resultado de aprendizaje ( llave foranea)',
    program_code varchar(100) not null comment 'Se le asigna un codigo al programa de formacion (llave foranea)',
    competition_code varchar(100) not null comment 'Se le asigna un codigo a la competencia (llave foranea)',
    level_formation varchar (50) not null comment 'Se le asigna un nivel de formacion ',    
    program_version varchar (20) not null comment 'El programa de formación debe tener una versión (llave foranea)', 
	number_group varchar(100) not null comment 'Se asigna un numero a la ficha (llave foranea)  ',
	constraint fk_rv_ght foreign key (number_group, name_trimester, workingday_initials, level_formation) references tidsplan.group_has_trimester(number_group, name_trimester, workingday_initials, level_formation)  ON UPDATE CASCADE,
	index fk_rv_ght_idx(number_group, name_trimester, workingday_initials, level_formation),
    constraint fk_rv_lr foreign key (lr_code, program_code, competition_code, program_version) references tidsplan.learning_result(id_code, program_code, competition_code, program_version)  ON UPDATE CASCADE,
	index fk_rv_lr_idx(lr_code, program_code, competition_code, program_version),
    primary key(number_group, name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version)
);

insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAE-1', '228106', '220501006', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAE-2', '228106', '220501006', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAE-3', '228106', '220501006', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAE-4', '228106', '220501032', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAE-5', '228106', '220501032', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAE-6', '228106', '220501032', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-1 (Inducción)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-2 (Inducción)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-3 (Inducción)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-4 (Inducción)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-1 (Comunicación)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-2 (Comunicación)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAB-3 (Comunicación)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAT-1', '228106', '240201501', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAT-2', '228106', '240201501', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-1', 'D', 'RAT-1', '228106', '240201502', 'tecnologo', '102', '1349397' );

-- ADSI TRIMESTRE 2

insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAE-7', '228106', '220501032', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAE-8', '228106', '220501032', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAE-9', '228106', '220501033', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAE-10', '228106', '220501033', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAE-11', '228106', '220501033', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAE-12', '228106', '220501033', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAT-3', '228106', '240201501', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAB-1 (ETICA)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAB-2 (ETICA)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAB-3 (ETICA)', '228106', '240201500', 'tecnologo', '102', '1349397' );
insert into tidsplan.results_viewed (name_trimester, workingday_initials, lr_code, program_code, competition_code, level_formation, program_version, number_group) values ('trimestre-2', 'D', 'RAT-2', '228106', '240201502', 'tecnologo', '102', '1349397' );




create table tidsplan.role (
	id_rol varchar(20) primary key not null comment 'Se debe asignar un ID –Código- a cada rol',
    description varchar(100) not null comment 'El nombre del rol instructor, líder o administrador ' ,
    status boolean comment 'El estado debe permitir habilitar o deshabilitar un rol '
);

insert into tidsplan.role(id_rol, description, status) values ('Administrador', 'rol de administrador', true);
insert into tidsplan.role(id_rol, description, status) values ('Super administrador' , 'rol de superadministrador', true);

create table tidsplan.document(
	id_document varchar(20) not null primary key comment 'Debe tener un id del tipo de documento', 
    type_document varchar(45) not null comment 'El tipo puede ser Tarjeta de identidad TI, cédula CC, Documento extranjero DE',
    status boolean
);

insert into tidsplan.document(id_document, type_document, status) values ('CC', 'Cedula de ciudadania', true);
insert into tidsplan.document(id_document, type_document, status) values ('TI', 'Tarjeta de identidad', true);
insert into tidsplan.document(id_document, type_document, status) values ('CE', 'Cedula  extrangera', true);
insert into tidsplan.document(id_document, type_document, status) values ('PS', 'Pasaporte', true);




create table tidsplan.customer (
    document varchar(30) not null comment 'Se le asigna un ID al documento  (llave foranea)',
	document_number varchar(20) not null comment 'Debe tener un número de documento',
    first_name varchar(20) not null comment 'El usuario debe tener un primero nombre ',
    second_name varchar(20) comment 'Puede tener un segundo nombre ',
    surname varchar(20) not null comment '3.- Primer apellido (Firts last name)	El usuario debe tener un primer apellido (The user must have a first last name)',
    second_surname varchar(20) comment 'Puede tener un segundo apellido ',
    photo blob comment 'Se debe permitir el uso de una foto ',
    constraint fk_customer_document foreign key (document) references tidsplan.document(id_document)  ON UPDATE CASCADE,
	index fk_customer_document_idx(document),
	primary key(document_number, document)
    );
    
insert into tidsplan.customer(document, document_number, first_name, second_name, surname, second_surname, photo) values ('CC', '80013833', 'Hernando', 'Enrique', 'Moreno', 'Moreno', load_file('C:/imagenes/Hernando.jpg'));
insert into tidsplan.customer(document, document_number, first_name, second_name, surname, second_surname, photo) values ('CC', '14796314', 'Sandra', 'Maria','Martinez', 'Montez',  load_file('C:/imagenes/person.jpg'));
insert into tidsplan.customer(document, document_number, first_name, second_name, surname, second_surname, photo) values ('CC', '59874135', 'Wilder', 'Marcos','Meza','Villadiego', load_file('C:/imagenes/person.jpg'));
insert into tidsplan.customer(document, document_number, first_name, second_name, surname, second_surname, photo) values ('CC', '21488946', 'Justo', 'Efrain', 'bueno','Mena', load_file('C:/imagenes/person.jpg'));


    
create table tidsplan.user (
    document varchar(10) not null comment 'Tipo de documento del usuario',
    document_number varchar(20) not null comment 'Se le agrega un numero de documento al usuario',
	mail varchar(100) not null comment 'Se debe tener un correo electrónico suministrado por el usuario',
    password varchar(100) not null comment 'El usuario debe tener una contraseña para su cuenta ',
    end_date date not null comment 'El usuario debe tener una fecha de terminación asignada ',
    constraint fk_user_customer foreign key (document_number, document) references tidsplan.customer(document_number, document)  ON UPDATE CASCADE,
	index fk_user_customer_idx(document_number, document),
    primary key(document_number, document)
);

insert into tidsplan.user(document, document_number, mail, password, end_date) values ('CC', '80013833','hemoreno33@misena.edu.co', '123456789', '2017/12/15');

create table tidsplan.customer_has_role (
	document varchar(10) not null comment 'Tipo de documento del usuario',
	document_number varchar(20) not null comment 'Se le agrega un numero de documento al usuario',
	idrol varchar(20) not null comment 'Se debe asignar un ID –Código- a cada rol',
    status boolean comment 'El estado debe permitir habilitar o deshabilitar un rol',
	constraint fk_chr_customer foreign key (document, document_number) references tidsplan.customer(document, document_number)  ON UPDATE CASCADE,
	index fk_chr_customer_idx(document, document_number),
    constraint fk_chr_role foreign key (idrol) references tidsplan.role(id_rol)  ON UPDATE CASCADE,
	index fk_chr_role_idx(idrol),
	primary key(document_number, document, idrol)
);

insert into tidsplan.customer_has_role(document, document_number, idrol, status) values ('CC', '80013833', 'Administrador', true);
insert into tidsplan.customer_has_role(document, document_number, idrol, status) values ('CC', '80013833', 'Super administrador', true);



create table tidsplan.employment_relationship (
	type_employment_relationship varchar(20)  primary key not null comment 'El tipo de vinculación será de medio tiempo, tiempo completo y planta ',
    hours int not null comment 'Se deberá tener un estimado de horas dependiendo su tipo de vinculación ',
    status boolean not null comment 'Se tendrá el tipo de estado activo o inactivo '
);

insert into tidsplan.employment_relationship (type_employment_relationship, hours, status) values ('medio tiempo', 6, true);
insert into tidsplan.employment_relationship (type_employment_relationship, hours, status) values ('tiempo completo', 12, true);

create table tidsplan.speciality (
	name_speciality varchar(50) not null primary key comment 'Se debe asignar un nombre a la especialidad ',
	photo blob comment 'Se debe asignar un nombre a la especialidad ',
    status boolean not null comment 'El estado debe ser activo o inactivo '
);

insert into tidsplan.speciality (name_speciality, photo, status) values ('TELEINFORMATICA', load_file('C:/imagenes/ELECTRICIDAD.jpg'), true);
insert into tidsplan.speciality (name_speciality, photo, status) values ('TELECOMUNICACIONES', load_file('C:/imagenes/ELECTRONICA.jpg'), true);
insert into tidsplan.speciality (name_speciality, photo, status) values ('ELECTRICIDAD', load_file('C:/imagenes/TELECOMUNICACIONES.jpg'), true);
insert into tidsplan.speciality (name_speciality, photo, status) values ('ELECTRONICA', load_file('C:/imagenes/TELEINFO.jpg'), true);
insert into tidsplan.speciality (name_speciality, photo, status) values ('PROMOVER','' , true);


create table tidsplan.instructor (
	document varchar(10) not null comment 'Tipo de documento del usuario',
	document_number varchar(20) not null comment 'Se le agrega un numero de documento al usuario',
	type_employment_relationship varchar(20) not null comment 'Se vincula un instructor al tipo de empleado (llave foranea)',
	name_speciality varchar(50) not null comment 'Se le asigna un nombre a una especialidad (llave foranea)',
	constraint fk_instructor_er foreign key (type_employment_relationship) references tidsplan.employment_relationship(type_employment_relationship)  ON UPDATE CASCADE,
	index fk_instructor_er_idx(type_employment_relationship),
    constraint fk_instructor_speciality foreign key (name_speciality) references tidsplan.speciality(name_speciality)  ON UPDATE CASCADE,
	index fk_instructor_speciality_idx(name_speciality),
    constraint fk_instructor_customer foreign key (document_number, document) references tidsplan.customer(document_number, document)  ON UPDATE CASCADE,
	index fk_instructor_customer_idx(document_number, document),
    primary key(document_number, document)
);

insert into tidsplan.instructor (document, document_number, type_employment_relationship, name_speciality) values ('CC', '80013833', 'Tiempo completo', 'Teleinformatica');
insert into tidsplan.instructor (document, document_number, type_employment_relationship, name_speciality) values ('CC', '14796314', 'Tiempo completo', 'Promover');
insert into tidsplan.instructor (document, document_number, type_employment_relationship, name_speciality) values ('CC', '59874135', 'Tiempo completo', 'Promover');
insert into tidsplan.instructor (document, document_number, type_employment_relationship, name_speciality) values ('CC', '21488946', 'Tiempo completo', 'Promover');




create table tidsplan.day (
name_day varchar(10) primary key not null comment 'Nombre del día lunes, martes, miércoles, jueves, viernes, sábado y domingo',
status boolean comment 'El estado del día puede ser activo o inactivo '
);

insert into tidsplan.day (name_day, status) values ('Lunes',true);
insert into tidsplan.day (name_day, status) values ('Martes',true);
insert into tidsplan.day (name_day, status) values ('Miercoles',true);
insert into tidsplan.day (name_day, status) values ('Jueves',true);
insert into tidsplan.day (name_day, status) values ('Viernes',true);
insert into tidsplan.day (name_day, status) values ('Sabado',true);
insert into tidsplan.day (name_day, status) values ('Domingo',true);



create table tidsplan.disponibility (
	document varchar(10) not null comment 'Se agrega el numero de documento de cliente (llave foranea)',
	document_number varchar(20) not null comment 'Se agrega el numero de documento de cliente (llave foranea)',
	start_hour time  not null comment 'La disponibilidad debe tener hora de inicio ',
    end_hour time comment 'La disponibilidad debe tener hora de fin ',
    name_day varchar(10) comment 'Se le asigna un nombre al dia (llave foranea)',
    working_day_initials varchar(10)  not null comment 'Se le asignan iniciales a la jornada (llave foranea)',
    constraint fk_disponibility_day foreign key (name_day) references tidsplan.day(name_day)  ON UPDATE CASCADE,
	index fk_disponibility_day_idx(name_day),
    constraint fk_disponibility_wd foreign key (working_day_initials) references tidsplan.working_day(initials)  ON UPDATE CASCADE,
	index fk_disponibility_wd_idx(working_day_initials),
    constraint fk_disponibility_instructor foreign key (document_number, document) references tidsplan.instructor(document_number, document)  ON UPDATE CASCADE,
	index fk_disponibility_instructor_idx(document_number, document),
    primary key(start_hour, name_day, working_day_initials, document_number, document)
);

insert into tidsplan.disponibility (document, document_number, start_hour, end_hour, name_day, working_day_initials) values ('CC', '80013833', '6:00:00', '6:00:00','Lunes','D');
insert into tidsplan.disponibility (document, document_number, start_hour, end_hour, name_day, working_day_initials) values ('CC', '80013833', '6:00:00', '6:00:00','Martes','D');
insert into tidsplan.disponibility (document, document_number, start_hour, end_hour, name_day, working_day_initials) values ('CC', '80013833', '6:00:00', '6:00:00','Miercoles','D');
insert into tidsplan.disponibility (document, document_number, start_hour, end_hour, name_day, working_day_initials) values ('CC', '80013833', '6:00:00', '6:00:00','Jueves','D');
insert into tidsplan.disponibility (document, document_number, start_hour, end_hour, name_day, working_day_initials) values ('CC', '80013833', '6:00:00', '6:00:00','Viernes','D');





create table tidsplan.modality (
	name_modality varchar(100) primary key not null comment 'Nombre de la modalidad presencial, mixta o virtual',
    status boolean comment 'Se debe asignar un estado activo o inactivo '
 );
 
insert into tidsplan.modality (name_modality, status) values ('presencial', true);
insert into tidsplan.modality (name_modality, status) values ('virtual', true);


create table tidsplan.headquartes (
	name_headquartes varchar(100) primary key not null comment 'Se le asigna un nombre a la sede', 
    address varchar(45) not null comment 'Debe tener una dirección para una mejor localización',
    status boolean comment 'Puede tener el estado de habilitado o inhabilitado '
);

INSERT INTO tidsplan.headquartes (name_headquartes, address, status) VALUES('Barrio Colombia', 'Cl. 69 #20-36', true);

create table tidsplan.environment (
	number_environment varchar(50) not null comment 'Nombre de la modalidad presencial, mixta o virtual',
    description varchar(45) comment 'Cada ambiente debe tener un número de localización asignado ',
    status boolean comment 'Debe tener algún tipo de estado habilitado o inhabilitado ',
	name_headquartes varchar(100)  not null comment 'Cada sede debe tener asignado un nombre ', 
    constraint fk_environment_headquartes foreign key (name_headquartes) references tidsplan.headquartes(name_headquartes)  ON UPDATE CASCADE,
	index fk_environment_headquartes_idx(name_headquartes),
    primary key(number_environment, name_headquartes)
);


INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('101', 'Ambiente 101', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('103', 'Ambiente 103', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('200', 'Ambiente 200', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('201', 'Ambiente 201', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('202', 'Ambiente 202', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('300', 'Ambiente 300', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('301', 'Ambiente 301', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('302', 'Ambiente 302', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('303', 'Ambiente 303', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('304', 'Ambiente 304', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('305', 'Ambiente 305', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('306', 'Ambiente 306', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('307', 'Ambiente 307', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('400', 'Ambiente 400', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('401', 'Ambiente 401', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('402', 'Ambiente 402', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('405', 'Ambiente 405', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('407', 'Ambiente 407', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('Auditorio', ' Auditorio', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('Sala Instructores', 'Sala Instructores', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('Cafe-Libro', 'Cafe-Libro', true, 'Barrio Colombia');
INSERT INTO tidsplan.environment (number_environment, description, status, name_headquartes) VALUES('Zona Deportiva', 'Zona Deportiva', true, 'Barrio Colombia');



create table tidsplan.trimester_current (
	id_trimester varchar(10) not null primary key comment 'Cada trimestre debe tener un ID –código- ',
    start_date date not null comment 'Se debe asignar una fecha de inicio a cada trimestre ',
    end_date date not null comment 'Se debe estipular una fecha de fin para el trimestre actual'
);

insert into tidsplan.trimester_current (id_trimester, start_date, end_date) values ('T1', '2017-01-23', '2017-03-21');
insert into tidsplan.trimester_current (id_trimester, start_date, end_date) values ('T2', '2017-04-22', '2017-06-16');
insert into tidsplan.trimester_current (id_trimester, start_date, end_date) values ('T3', '2017-07-17', '2017-09-23');
insert into tidsplan.trimester_current (id_trimester, start_date, end_date) values ('T4', '2017-10-24', '2017-12-18');
insert into tidsplan.trimester_current (id_trimester, start_date, end_date) values ('T5', '2018-01-23', '2018-03-21');
insert into tidsplan.trimester_current (id_trimester, start_date, end_date) values ('T6', '2018-04-22', '2018-06-16');

create table tidsplan.version (
	id_version int not null  comment 'Código –ID- de cada versión ',
    status boolean comment 'Puede tener un estado de actividad o inactividad ',
    id_trimester_current varchar(10) not null comment 'Se le asigna un ID al trimestre actual (llave foranea)',
    constraint fk_version_tc foreign key (id_trimester_current) references tidsplan.trimester_current(id_trimester)  ON UPDATE CASCADE,
	index fk_version_tc_idx(id_trimester_current),
    primary key(id_version, id_trimester_current)
);

insert into tidsplan.version (id_version, status, id_trimester_current) values ('1', true, 'T1');
insert into tidsplan.version (id_version, status, id_trimester_current) values ('2', true, 'T2');
insert into tidsplan.version (id_version, status, id_trimester_current) values ('3', true, 'T3');
insert into tidsplan.version (id_version, status, id_trimester_current) values ('4', true, 'T4');
insert into tidsplan.version (id_version, status, id_trimester_current) values ('5', true, 'T5');
insert into tidsplan.version (id_version, status, id_trimester_current) values ('6', true, 'T6');

CREATE TABLE tidsplan.schedule (
    start_hour time NOT NULL COMMENT 'Hora estimada en que empieza regir el horario ',
    end_hour time NOT NULL COMMENT 'Hora estimada en que termina el horario ',
    id_version int not null comment 'se le agrega un id a la version (llave foranea)',
    name_day VARCHAR(10) NOT NULL COMMENT 'Se le asigna un nombre al dia lunes, martes, etc. (llave foranea)',
    id_trimester_current VARCHAR(10) NOT NULL COMMENT 'Se le agrega un ID al trimestre actual',
    name_modality VARCHAR(100) NOT NULL COMMENT 'Se le asigna un nombre a la modalidad (llave foranea)',
    number_environment VARCHAR(50) NOT NULL COMMENT 'Se le asigna un numero al ambiente (llave foranea)',
    name_headquartes VARCHAR(100) NOT NULL COMMENT 'Se le asigna un nombre a la sede (llave foranea)',
    number_group VARCHAR(100) NOT NULL COMMENT 'Se le asigna un numero a la ficha (llave foranea)',
    name_trimester VARCHAR(20) NOT NULL COMMENT 'Se le asigna un nombre al trimestre (llave foranea)',
    working_day_initials VARCHAR(10) NOT NULL COMMENT 'Se le asignan iniciales a la jornada  ',
    document_number VARCHAR(20) NOT NULL COMMENT 'Se asigna un numero de documento (llave foranea)',
    document VARCHAR(10) NOT NULL COMMENT 'Se asigna un numero de documento (llave foranea)',
    constraint fk_shedule_version foreign key (id_version, id_trimester_current) references tidsplan.version (id_version, id_trimester_current) on update cascade,
    index fk_shedule_version_idx (id_version, id_trimester_current),
    CONSTRAINT fk_schedule_day FOREIGN KEY (name_day) REFERENCES tidsplan.day (name_day)  ON UPDATE CASCADE,
    INDEX fk_schedule_day_idx (name_day),
    CONSTRAINT fk_schedule_modality FOREIGN KEY (name_modality) REFERENCES tidsplan.modality (name_modality)  ON UPDATE CASCADE,
    INDEX fk_schedule_modality_idx (name_modality),
    CONSTRAINT fk_schedule_environment FOREIGN KEY (number_environment , name_headquartes) REFERENCES tidsplan.environment (number_environment , name_headquartes)  ON UPDATE CASCADE,
    INDEX fk_schedule_environment_idx (number_environment , name_headquartes),
    CONSTRAINT fk_schedule_ght FOREIGN KEY (number_group , name_trimester , working_day_initials) REFERENCES tidsplan.group_has_trimester (number_group , name_trimester , workingday_initials)  ON UPDATE CASCADE,
    INDEX fk_schedule_ght_idx (number_group , name_trimester , working_day_initials),
    CONSTRAINT fk_schedule_instructor FOREIGN KEY (document_number , document) REFERENCES tidsplan.instructor (document_number , document)  ON UPDATE CASCADE,
    INDEX fk_schedule_instructor_idx (document_number , document),
    PRIMARY KEY (start_hour , name_day , id_trimester_current , number_environment , name_headquartes , number_group , name_trimester , working_day_initials , document_number , document)
);

insert into tidsplan.schedule (start_hour, end_hour, id_version, name_day, id_trimester_current, name_modality, number_environment, name_headquartes, number_group, name_trimester, working_day_initials, document_number, document) values ('6:00:00', '12:00:00', 1, 'Lunes', 'T3', 'presencial', '300', 'Barrio Colombia', '1349397', 'trimestre-3', 'D', '80013833', 'CC' );
insert into tidsplan.schedule (start_hour, end_hour, id_version, name_day, id_trimester_current, name_modality, number_environment, name_headquartes, number_group, name_trimester, working_day_initials, document_number, document) values ('6:00:00', '12:00:00', 1, 'Martes', 'T3', 'presencial', '300', 'Barrio Colombia', '1349397', 'trimestre-3', 'D', '80013833', 'CC' );
insert into tidsplan.schedule (start_hour, end_hour, id_version, name_day, id_trimester_current, name_modality, number_environment, name_headquartes, number_group, name_trimester, working_day_initials, document_number, document) values ('6:00:00', '12:00:00', 1, 'Miercoles', 'T3', 'presencial', '300', 'Barrio Colombia', '1349397', 'trimestre-3', 'D', '80013833', 'CC' );
insert into tidsplan.schedule (start_hour, end_hour, id_version, name_day, id_trimester_current, name_modality, number_environment, name_headquartes, number_group, name_trimester, working_day_initials, document_number, document) values ('6:00:00', '12:00:00', 1, 'Jueves', 'T3', 'presencial', '300', 'Barrio Colombia', '1349397', 'trimestre-3', 'D', '80013833', 'CC' );
insert into tidsplan.schedule (start_hour, end_hour, id_version, name_day, id_trimester_current, name_modality, number_environment, name_headquartes, number_group, name_trimester, working_day_initials, document_number, document) values ('6:00:00', '12:00:00', 1, 'Viernes', 'T3', 'presencial', '300', 'Barrio Colombia', '1349397', 'trimestre-3', 'D', '80013833', 'CC' );



create table tidsplan.email_server (
	mail varchar(100) primary key not null comment 'Se le agrega un correo electronico',
    password varchar(50) not null comment 'contraseña que ',
    smtp_host varchar(60) not null comment 'Se le asigna una contraseña al correo electronico',
    smtp_port int not null comment 'Se le agrega un hosting',
    smtp_start_tls_enable boolean comment 'Se le agrega seguridad al aplicativo', 
    smtp_auth boolean comment 'Se le agrega campo de autenticacion',
    recovery_case varchar(45) not null comment 'Se agrega un tipo de recuperacion',
    recovery_message varchar(100) not null comment 'Se agrega un mensaje de recuperacion '
);

create table tidsplan.log_error (
	id_log bigint primary key comment 'Codigo que tendra el log',
    level varchar(15) comment 'nivel del log, importancia',
    log_name varchar(250) comment 'Se le agrega un nombre del log',
    message text comment 'mensaje del error',
    date datetime comment 'hora cuando se ejecuto el error',
    user varchar(50) comment 'Usuario al que le salio el error'
);

create table tidsplan.log_auditoria (
	id_log bigint(20) primary key comment ' ',
	level varchar(15) comment 'nivel del log, importancia',
	log_name varchar(250) comment 'Se le agrega un nombre del log',
	message text comment 'mensaje del error',
	date datetime comment 'hora cuando se ejecuto el error',
    user varchar(100) comment 'Usuario al que le salio el error'
);
