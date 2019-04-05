-- project 

insert into cot.project (code, name, state) values ('576887', 'SISTEMA INTEGRAL WEB PARA GESTION DE PROCESOS EDUCATIVOS DEL CEET', true);
insert into cot.project (code, name, state) values ('569629', 'Implementacion de modulos en el sistema integral web de gestion de procesos educativos para el ceet', true);

-- phase

insert into cot.phase (name_phase, project_code, state) values ('FASE 1. ANALISIS', '576887', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE 2. PLANEACION', '576887', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE 3. EJECUCION', '576887', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE 4. EVALUACION', '576887', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE-1. ANALISIS', '569629', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE-2. PLANEACION', '569629', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE-3. EJECUCION', '569629', true );
insert into cot.phase (name_phase, project_code, state) values ('FASE-4. EVALUACION', '569629', true );

-- activity

insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 2', 'FASE 1. ANALISIS',  '576887', 'Determinar los requerimientos del sistema según especificaciones y lineamientos del proyecto');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 3', 'FASE 1. ANALISIS',  '576887', ' Analizar procesos, datos y necesidades del centro de electricidad, electrónica y telecomunicaciones y el usuario final para el modulo especifico.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 4', 'FASE 2. PLANEACIÓN',  '576887', 'Especificar modelo conceptual del sistema, especificando necesidades y requerimientos.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 5', 'FASE 2. PLANEACIÓN',  '576887', 'Determinar la estructura lógica del sistema');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 6', 'FASE 2. PLANEACIÓN',  '576887', 'Diseñar  la estructura tecnológica  del sistema integral');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 7', 'FASE 3. EJECUCION',  '576887', 'Desarrollar la estructura de datos y de vista de la aplicación del modulo');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 8', 'FASE 3. EJECUCION',  '576887', 'Desarrollo los módulos del sistema integral web de acuerdo a los estándares de calidad y normatividad  legal vigente.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 9', 'FASE 4. EVALUACION',  '576887', 'Preparar documentación del proceso de implantación del sistema ');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 10', 'FASE 4. EVALUACION',  '576887', 'Desarrollar las tareas de configuración y puesta en marcha del sistema ');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 11', 'FASE 4. EVALUACION',  '576887', 'Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 2', 'FASE-1. ANALISIS',  '569629', 'Determinar los requerimientos del sistema según especificaciones y lineamientos del proyecto');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 3', 'FASE-1. ANALISIS',  '569629', ' Analizar procesos, datos y necesidades del centro de electricidad, electrónica y telecomunicaciones y el usuario final para el modulo especifico.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 4', 'FASE-2. PLANEACIÓN',  '569629', 'Especificar modelo conceptual del sistema, especificando necesidades y requerimientos.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 5', 'FASE-2. PLANEACIÓN',  '569629', 'Determinar la estructura lógica del sistema');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 6', 'FASE-2. PLANEACIÓN',  '569629', 'Diseñar  la estructura tecnológica  del sistema integral');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 7', 'FASE-3. EJECUCION',  '569629', 'Desarrollar la estructura de datos y de vista de la aplicación del modulo');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 8', 'FASE-3. EJECUCION',  '569629', 'Desarrollo los módulos del sistema integral web de acuerdo a los estándares de calidad y normatividad  legal vigente.');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 9', 'FASE-4. EVALUACION',  '569629', 'Preparar documentación del proceso de implantación del sistema ');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 10', 'FASE-4. EVALUACION',  '569629', 'Desarrollar las tareas de configuración y puesta en marcha del sistema ');
insert into cot.activity (id_activity, phase_name_phase, phase_project_code, name) values ('Actividad 11', 'FASE-4. EVALUACION',  '569629', 'Elaborar informes y procesos de evaluación para la validación de los productos e implantación del sistema determinando recursos.');

-- level  

insert into cot.level_trainig (code, state) values ('Tecnologo', true);
insert into cot.level_trainig (code, state) values ('Tecnico', true);

-- program 

insert into cot.program (code_program, name_program, edition, initials, state, level_tra_code) values ('228106', 'ANÁLISIS Y DESARROLLO DE SISTEMAS DE INFORMACIÓN', 'v 102', 'ADSI', true, 'Tecnologo');
insert into cot.program (code_program, name_program, edition, initials, state, level_tra_code) values ('228120', 'PROGRAMACION DE SOFTWARE', 'v 102', 'TPS', true, 'Tecnico');

-- state number group

insert into cot.state_number_group (state) values (true);
insert into cot.state_number_group (state) values (false);

-- number group

insert into cot.number_group (number_group, date_start, date_end, route, state, program_code, program_edition) values ('1349397', 1/12/2016, 30/11/2018, 'Ruta 1G ficha 1349397', true, 228106, 'v 102');

-- Working_Day
insert into cot.working_day set initials='D',name='Diurno',description='';
insert into cot.working_day set initials='N', name='Noche',description='';
insert into cot.working_day set initials='M',name='Madrugada',description='';


-- trimester tecnologo

insert into cot.trimester set number='1', initials='D', code='Tecnologo';


insert into cot.trimester set number='2', initials='D', code='Tecnologo';


insert into cot.trimester set number='3', initials='D', code='Tecnologo';


insert into cot.trimester set number='4', initials='D', code='Tecnologo';


insert into cot.trimester set number='5', initials='D', code='Tecnologo';


insert into cot.trimester set number='6', initials='D', code='Tecnologo';


insert into cot.trimester set number='7', initials='D', code='Tecnologo';


insert into cot.trimester set number='8', initials='D', code='Tecnologo';

-- trimester tecnico

insert into cot.trimester set number='1', initials='D', code='Tecnico';


insert into cot.trimester set number='2', initials='D', code='Tecnico';



insert into cot.trimester set number='3', initials='D', code='Tecnico';



insert into cot.trimester set number='4', initials='D', code='Tecnico';

-- number group has trimester

insert into cot.number_group_has_trimester set number_group='1349397',number='1',initials='D',tri_code='Tecnologo';


insert into cot.number_group_has_trimester set number_group='1349397',number='2',initials='D',tri_code='Tecnologo';


insert into cot.number_group_has_trimester set number_group='1349397',number='3',initials='D',tri_code='Tecnologo';


insert into cot.number_group_has_trimester set number_group='1349397',number='4',initials='D',tri_code='Tecnologo';


insert into cot.number_group_has_trimester set number_group='1349397',number='5',initials='D',tri_code='Tecnologo';


insert into cot.number_group_has_trimester set number_group='1349397',number='6',initials='D',tri_code='Tecnologo';

-- Tecnico
insert into cot.number_group_has_trimester set number_group='1349397',number='1',initials='D',tri_code='Tecnico';


insert into cot.number_group_has_trimester set number_group='1349397',number='2',initials='D',tri_code='Tecnico';


insert into cot.number_group_has_trimester set number_group='1349397',number='3',initials='D',tri_code='Tecnico';


insert into cot.number_group_has_trimester set number_group='1349397',number='4',initials='D',tri_code='Tecnico';


-- competence

insert into cot.competence (code_competence, description, code_program, edition) values ('220501006', 'Especificar los requisitos necesarios para desarrollar el sistema de información de acuerdo con las necesidades del cliente..', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501032', 'Analizar los requisitos del cliente para construir el sistema de información', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501033', 'Diseñar el sistema de acuerdo con los requerimientos del cliente.', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501007', 'Construir el sistema que cumpla con los requisitos de la solución informática.', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501034', 'Implantar la solución que cumpla con los requerimientos para su operación.', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501009', 'Participar en el proceso de negociación de Tecnología informática para permitir la implementación del sistema de información.', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501035', 'Aplicar buenas prácticas de calidad en el proceso de desarrollo de software, de acuerdo con el referente adoptado en la empresa ', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('240201500', 'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social.', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('240201501', 'Comprender textos en inglés en forma escrita y auditiva', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('240201502', 'Producir textos en inglés en forma escrita y oral.', 228106, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501032', 'Analizar los requisitos del cliente para construir el sistema de información', 228120, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('220501007', 'Construir el sistema que cumpla con los requisitos de la solución informática.', 228120, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('240501500', 'Promover la interacción idónea consigo mismo, con los demás y con la naturaleza en los contextos laboral y social.', 228120, 'v 102');
insert into cot.competence (code_competence, description, code_program, edition) values ('240501501', 'Comprender textos en inglés en forma escrita y auditiva', 228120, 'v 102');

-- learning result

insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 1', 'Aplicar las técnicas de recolección de datos , diseñando  los instrumentos necesarios para el procesamiento de información, de acuerdo con la situación planteada por la empresa.', '220501006',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 2', 'Elaborar mapas de procesos que permitan identificar las áreas involucradas en un sistema de información, utilizando herramientas informáticas y las Tic’s, para generar informes según las necesidades de la empresa.', '220501006',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 3', 'Plantear diferentes alternativas, de modelos tecnológicos de información empresarial, teniendo en cuenta la plataforma  tecnológica de la empresa y las tendencias del mercado, para dar solución a las situaciones relacionadas con el manejo de la información de la organización.', '220501006',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 4', 'Interpretar el informe de requerimientos, para determinar las necesidades tecnológicas en el manejo de la información, de acuerdo con las normas y protocolos establecidos en la empresa.', '220501032',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 5', 'Representa el bosquejo de la solución al problema presentado por el cliente, mediante la  elaboración de diagramas de casos de uso,  apoyado en el análisis del informe de requerimientos, al confrontar la situación problemica con el usuario según  normas y protocolos de la organización.', '220501032',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 6', 'Construir el modelo conceptual del macrosistema frente a los requerimientos del cliente,  mediante el uso e interpretación de la información levantada, representado en diagramas de clase, de interacción, colaboración y contratos de operación, de acuerdo con las diferentes secuencias, fases y procedimientos del sistema.', '220501032',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 7', 'Valorar la incidencia de los datos en los procesos del macrosistema, tomando como referente  el diccionario de datos y las miniespecificaciones, para la consolidación de los datos que intervienen, de acuerdo con parámetros establecidos.', '220501032',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 8', 'Elaborar el informe de los resultados del análisis del sistema de información, de acuerdo con los requerimientos del cliente  según normas y protocolos establecidos.', '220501032',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 9', 'Diseñar la arquitectura del software, mediante la interpretación de las clases, objetos y mecanismos de colaboración, utilizando herramientas tecnológicas de diseño, de acuerdo con las tendencias de las tecnologías de la información y la comunicación.', '220501033',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 10', 'Construir el prototipo del sistema de información, a partir del análisis de las características funcionales del sistema en relación con facilidad de manejo, funcionalidad y experiencia del usuario, apoyado en software aplicado según protocolos de diseño.', '220501033',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 11', 'Diseñar  la estructura de datos, a partir del modelo conceptual determinado en el análisis del sistema, utilizando herramientas tecnológicas de bases de datos, según las normas y estándares establecidos.', '220501033',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 12', 'Diseñar  la arquitectura tecnológica  del sistema de información, mediante el reconocimiento de hardware y software, de acuerdo con la tecnología disponible en el mercado, el informe de análisis levantado y el diagrama de distribución.', '220501033',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 13', 'Aplicar políticas y mecanismos de control en el diseño del sistema de información, mediante el análisis de la vulnerabilidad de la información, siguiendo los parámetros establecidos por la organización.', '220501033',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 14', 'Elaborar el informe de diseño del sistema de información, de acuerdo con la selección de las herramientas, tanto de software como de hardware, requeridas para la solución informática', '220501033',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 15', 'Interpretar el informe técnico de diseño, para determinar el plan de trabajo durante la fase de construcción del software, de acuerdo con las normas y protocolos establecidos en la empresa.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 16', 'Construir la base de datos, a partir del modelo de datos determinado en el diseño del sistema, utilizando sistemas de gestión de base de datos, según los protocolos establecidos en la organización.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 17', 'Construir la interfaz de usuario, apoyado en la evaluación del prototipo, determinando las entradas y salidas requeridas en el diseño y definiendo los lineamientos para la navegación, de acuerdo con las necesidades del usuario.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 18', 'Realizar la codificación de los módulos del sistema y el programa principal, a partir de la utilización del lenguaje de programación seleccionado, de acuerdo con las especificaciones del diseño.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 19', 'Construir el programa de instalación del aplicativo, utilizando las herramientas de desarrollo disponibles en el mercado, según las características de la arquitectura de la solución.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 20', 'Elaborar el manual técnico de la aplicación, de acuerdo con la complejidad del aplicativo y según normas y procedimientos establecidos por la empresa.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 21', 'Ejecutar y documentar las pruebas del software, aplicando técnicas de ensayo-error, de acuerdo con el plan diseñado y los procedimientos establecidos por la empresa.', '220501007',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 22', 'Configurar el software de la aplicación para cliente y servidor, mediante la utilización del hardware disponible,  ejecutándola en la plataforma tecnológica, según normas y protocolos establecidos por la empresa.', '220501034',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 23', 'Elaborar el informe administrativo, siguiendo los protocolos de la organización, basado en los planes de instalación, respaldo y migración del sistema de información, facilitando la operatividad y mantenimiento de la solución informática.', '220501034',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 24', 'Definir estrategias para la  validación de manuales de usuario y de operación,  respondiendo a las necesidades y satisfacción del cliente, frente a la solución informática propuesta, según políticas de la organización', '220501034',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 25', 'Capacitar a los usuarios del sistema, sobre la estructuración y el manejo del aplicativo,  de acuerdo con el plan establecido, el perfil de los usuarios, según políticas de la organización.', '220501034',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 26', 'Elaborar informes técnicos relacionados con la solución informática implantada, de acuerdo con las propuestas de alternativas aplicadas, teniendo en cuenta las técnicas de comunicación y según normas y protocolos establecidos', '220501034',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 27', 'Interpretar el diagnóstico de necesidades informáticas, para determinar las tecnológicas requeridas en el manejo de la información, de acuerdo con las normas y protocolos establecidos por la empresa.', '220501009',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 28', 'Definir estrategias para la elaboración de términos de referencia y procesos de evaluación de proveedores, en la adquisición de tecnología, según protocolos establecidos.', '220501009',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 29', 'Participar en los perfeccionamientos de contratos informáticos, estableciendo cláusulas técnicas, que respondan a las necesidades de los actores de la negociación, de acuerdo con la ley de contratación.', '220501009',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 30', 'Elaborar el informe sobre el cumplimiento de los términos de referencia previstos en la negociación, de acuerdo con la participación de cada uno de los actores en relación con la satisfacción de los bienes informáticos contratados y recibidos, según normas y protocolos de la organización.', '220501009',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 31', 'Identificar las características de los procesos de desarrollo de software, frente al referente de calidad adoptado por la empresa, ajustándolos a los resultados de las mediciones, evaluaciones y recomendaciones realizadas', '220501035',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 32', 'Identificar los puntos críticos de control en los procesos de desarrollo de software, para establecer las acciones a seguir, garantizando el cumplimiento de los estándares de calidad, siguiendo los lineamientos establecidos por la organización.', '220501035',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 33', 'Aplicar los estándares de calidad involucrados en los procesos de desarrollo de software, siguiendo el plan establecido para mantener la integridad de los productos  de trabajo definidos, según las prácticas de configuración establecidas por la empresa', '220501035',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 34', 'Elaborar instrumentos e instructivos, requeridos por el aseguramiento de la calidad, para documentar y evaluar los procesos de desarrollo de software, de acuerdo con las normas y procedimientos establecidas por la empresa.', '220501035',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 35', 'Evaluar procesos y productos de desarrollo de software, documentar y concertar acciones a seguir, para garantizar el cumplimiento de las normas establecidas, de acuerdo con el plan definido y con los criterios de medición, métricas y políticas determinados por la empresa', '220501035',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE 36', 'Elaborar el informe final del proceso de gestión de calidad en el desarrollo de software, que consolide la información de las evidencias, hallazgos y novedades frente al seguimiento y control de los productos, según normas internacionales y protocolos de la organización.', '220501035',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 001', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA. ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 002', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional. ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 003', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles. ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 004', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional. ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 01', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social. ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 02', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.  ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB 03', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social.', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-1', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-2', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-3', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva.', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/1', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/2', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral . ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/3', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional. ', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/4', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales.', '240201500',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 01', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos. ', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 02', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico.', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 03', 'Leer textos muy breves y sencillos en inglés general y técnico.', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 04', 'Encontrar información específica y predecible en escritos sencillos y cotidianos.', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 05', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 06', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 07', 'Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos.', '240201501',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 1', 'Reproducir en inglés frases o enunciados simples que permitan expresar de forma lenta ideas o conceptos.', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 2', 'Identificar formas gramaticales básicas en textos y documentos elementales escritos en inglés. ', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 3', 'Comprender una amplia variedad de frases y vocabulario  en inglés sobre temas de interés personal y temas técnicos. ', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 4', 'Comprender las ideas principales de textos complejos en inglés que tratan de temas tanto concretos como abstractos, incluso si son de carácter técnico, siempre que estén dentro de su campo de especialización.', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 5', 'Leer textos complejos y con un vocabulario más específico, en inglés general y técnico', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 6', 'Buscar de manera sistemática información específica y detallada en escritos en inglés, mas estructurados y con mayor contenido técnico. ', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 7', 'Encontrar y utilizar sin esfuerzo vocabulario y expresiones de inglés técnico en artículos de revistas, libros especializados, páginas web, etc', '240201502',  '228106', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT 8', 'Relacionarse con hablantes nativos en un grado suficiente de fluidez y naturalidad, de modo que la comunicación se realice sin esfuerzo por parte de los interlocutores. ', '240201502',  '228106', 'v 102');

-- tps

insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE-1', 'INTERPRETAR EL DIAGRAMA RELACIONAL PARA IDENTIFICAR EL MODELO DE DATOS.', '220501032',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE-2', 'IDENTIFICAR CADA UNO DE LOS CONCEPTOS Y PRINCIPIOS QUE CONSTITUYE LA PROGRAMACIÓNORIENTADA A OBJETOS PARA INTERPRETAR EL DISEÑO', '220501032',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE-3', 'DESCRIBIR QUE SON LOS MODIFICADORES PARA APLICARLOS A UN PROYECTO DE FORMACIÓN', '220501032',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE-4', 'INTERPRETAR LOS DIAGRAMAS DE CASO DE USO, DE OBJETOS, DE ESTADOS, DE SECUENCIA, DE PAQUETES O COMPONENTES, DE DESPLIEGUE, DE COLABORACIÓN SEGÚN EL DISEÑO ENTREGADO.', '220501032',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE-5', 'RELACIONAR LAS TABLAS CONSTRUIDAS PARA PRESENTAR LA INFORMACIÓN SOLICITADA EN EL DISEÑO.', '220501007',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAE-6', 'CONSTRUIR LAS TABLAS QUE HACEN PARTE DEL DISEÑO DEL DIAGRAMA RELACIONAL EN EL MOTOR DE BASE DE DATOS EMPLEANDO LAS CUATRO FORMAS DE NORMALIZACIÓN.', '220501007',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-001', 'Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodología de formación, de acuerdo con la dinámica organizacional del SENA. ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-002', 'Concertar alternativas y acciones de formación para el desarrollo de las competencias del programa formación, con base en la política institucional. ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-003', 'Gestionar la información de acuerdo con los procedimientos establecidos y con las tecnologías de la información y la comunicación disponibles. ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-004', 'Identificar las oportunidades que el Sena ofrece en el marco de la formación profesional de acuerdo con el contexto nacional e internacional. ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-01', 'Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construcción colectiva del conocimiento y la resolución de problemas de carácter productico y social. ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-02', 'Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.  ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-03', 'Asumir actitudes críticas, argumentativas y propositivas en función de la resolución de problemas de carácter productivo y social.', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-/1', 'Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecución de los procesos de aprendizaje.', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-/2', 'Generar procesos autónomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB-/3', 'Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con visión prospectiva.', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/01', 'Asumir responsablemente los criterios de preservación y conservación del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/02', 'Generar hábitos saludables en su estilo de vida para garantizar la prevención de riesgos ocupacionales de acuerdo con el diagnóstico de su condición física individual y la naturaleza y complejidad de su desempeño laboral . ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/03', 'Aplicar técnicas de cultura física para el mejoramiento de su expresión corporal, desempeño laboral según la naturaleza y complejidad del área ocupacional. ', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAB/04', 'Interactuar en los contextos Productivos y Sociales en función de los Principios y Valores Universales.', '240501500',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-01', 'Comprender frases y vocabulario habitual sobre temas de interés personal y temas técnicos. ', '240501501',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-02', 'Comprender la idea principal en avisos y mensajes breves, claros y sencillos en inglés técnico.', '240501501',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-03', 'Leer textos muy breves y sencillos en inglés general y técnico.', '240501501',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-04', 'Encontrar información específica y predecible en escritos sencillos y cotidianos.', '240501501',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-05', 'Encontrar vocabulario y expresiones de inglés técnico en anuncios, folletos, páginas web, etc', '240501501',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-06', 'Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de información cotidiana y técnica', '240501501',  '228120', 'v 102');
insert into cot.learning_result (code, description, code_competence, code_program, edition) values ('RAT-07', 'Realizar intercambios sociales y prácticos muy breves, con un vocabulario suficiente para hacer una exposición o mantener una conversación sencilla sobre temas técnicos.', '240501501',  '228120', 'v 102');


-- learning result has activity

insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 1', '228106', 'v 102', '220501006', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 2', '228106', 'v 102', '220501006', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 3', '228106', 'v 102', '220501006', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 4', '228106', 'v 102', '220501032', 'Actividad 3', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 5', '228106', 'v 102', '220501032', 'Actividad 4', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 6', '228106', 'v 102', '220501032', 'Actividad 4', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 7', '228106', 'v 102', '220501032', 'Actividad 3', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 8', '228106', 'v 102', '220501032', 'Actividad 4', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 9', '228106', 'v 102', '220501033', 'Actividad 5', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 10', '228106', 'v 102', '220501033', 'Actividad 5', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 11', '228106', 'v 102', '220501033', 'Actividad 5', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 12', '228106', 'v 102', '220501033', 'Actividad 6', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 13', '228106', 'v 102', '220501033', 'Actividad 5', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 14', '228106', 'v 102', '220501033', 'Actividad 6', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 15', '228106', 'v 102', '220501007', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 16', '228106', 'v 102', '220501007', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 17', '228106', 'v 102', '220501007', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 18', '228106', 'v 102', '220501007', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 19', '228106', 'v 102', '220501007', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 20', '228106', 'v 102', '220501007', 'Actividad 9', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 21', '228106', 'v 102', '220501007', 'Actividad 9', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 22', '228106', 'v 102', '220501034', 'Actividad 10', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 23', '228106', 'v 102', '220501034', 'Actividad 10', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 24', '228106', 'v 102', '220501034', 'Actividad 11', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 25', '228106', 'v 102', '220501034', 'Actividad 10', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 26', '228106', 'v 102', '220501034', 'Actividad 11', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 27', '228106', 'v 102', '220501009', 'Actividad 3', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 28', '228106', 'v 102', '220501009', 'Actividad 6', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 29', '228106', 'v 102', '220501009', 'Actividad 10', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 30', '228106', 'v 102', '220501009', 'Actividad 10', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 31', '228106', 'v 102', '220501035', 'Actividad 3', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 32', '228106', 'v 102', '220501035', 'Actividad 4', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 33', '228106', 'v 102', '220501035', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 34', '228106', 'v 102', '220501035', 'Actividad 5', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 35', '228106', 'v 102', '220501035', 'Actividad 11', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE 36', '228106', 'v 102', '220501035', 'Actividad 11', 'FASE 4. EVALUACION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 001', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 002', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 003', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 004', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 01', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 02', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB 03', '228106', 'v 102', '240201500', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );

-- tps

insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-1', '228106', 'v 102', '240201500', 'Actividad 4', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-2', '228106', 'v 102', '240201500', 'Actividad 6', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-3', '228106', 'v 102', '240201500', 'Actividad 6', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/1', '228106', 'v 102', '240201500', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/2', '228106', 'v 102', '240201500', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/3', '228106', 'v 102', '240201500', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/4', '228106', 'v 102', '240201500', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 01', '228106', 'v 102', '240201501', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 02', '228106', 'v 102', '240201501', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 03', '228106', 'v 102', '240201501', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 04', '228106', 'v 102', '240201501', 'Actividad 2', 'FASE 1. ANALISIS', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 05', '228106', 'v 102', '240201501', 'Actividad 6', 'FASE 2. PLANEACIÓN', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 06', '228106', 'v 102', '240201501', 'Actividad 7', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 07', '228106', 'v 102', '240201501', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 1', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 2', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 3', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 4', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 5', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 6', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 7', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT 8', '228106', 'v 102', '240201502', 'Actividad 8', 'FASE 3. EJECUCION', '576887' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE-1', '228120', 'v 102', '220501032', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE-2', '228120', 'v 102', '220501032', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE-3', '228120', 'v 102', '220501032', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE-4', '228120', 'v 102', '220501032', 'Actividad 3', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE-5', '228120', 'v 102', '220501007', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAE-6', '228120', 'v 102', '220501007', 'Actividad 5', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-001', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-002', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-003', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-004', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-01', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-02', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-03', '228120', 'v 102', '240501500', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-/1', '228120', 'v 102', '240501500', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-/2', '228120', 'v 102', '240501500', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB-/3', '228120', 'v 102', '240501500', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/01', '228120', 'v 102', '240501500', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/02', '228120', 'v 102', '240501500', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAB/03', '228120', 'v 102', '240501500', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-01', '228120', 'v 102', '240501501', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-02', '228120', 'v 102', '240501501', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-03', '228120', 'v 102', '240501501', 'Actividad 2', 'FASE-1. ANALISIS', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-04', '228120', 'v 102', '240501501', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-05', '228120', 'v 102', '240501501', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-06', '228120', 'v 102', '240501501', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );
insert into cot.learning_result_has_activity (code, program_code, edition, competence_code, id_activity, apn_phase, app_code) values ('RAT-07', '228120', 'v 102', '240501501', 'Actividad 4', 'FASE-2. PLANEACIÓN', '569629' );

-- resultados por trimestre

insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE 1', program_code='228106',competence_code='220501006',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE 2', program_code='228106',competence_code='220501006',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE 3', program_code='228106',competence_code='220501006',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE 4', program_code='228106',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE 5', program_code='228106',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE 6', program_code='228106',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 001', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 002', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 003', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 004', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 01', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 02', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB 03', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAT 01', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAT 02', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAT 1', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';


insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE 7', program_code='228106',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE 8', program_code='228106',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE 9', program_code='228106',competence_code='220501033',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE 10', program_code='228106',competence_code='220501033',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE 11', program_code='228106',competence_code='220501033',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE 12', program_code='228106',competence_code='220501033',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB-1', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB-2', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB-3', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAT 03', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAT 2', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';


insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAE 13', program_code='228106',competence_code='220501033',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAE 14', program_code='228106',competence_code='220501033',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAE 15', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAE 16', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAE 17', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAE 18', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAB/1', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAB/2', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAB/3', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAB/4', program_code='228106',competence_code='240201500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAT 04', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='3',tri_work_initials='D',learningr_code='RAT 3', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';


insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAE 19', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAE 20', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAE 21', program_code='228106',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAE 22', program_code='228106',competence_code='220501034',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAE 23', program_code='228106',competence_code='220501034',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAE 24', program_code='228106',competence_code='220501034',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAT 05', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='4',tri_work_initials='D',learningr_code='RAT 4', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';


insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAE 25', program_code='228106',competence_code='220501034',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAE 26', program_code='228106',competence_code='220501034',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAE 27', program_code='228106',competence_code='220501009',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAE 28', program_code='228106',competence_code='220501009',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAE 29', program_code='228106',competence_code='220501009',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAE 30', program_code='228106',competence_code='220501009',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAT 06', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAT 5', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='5',tri_work_initials='D',learningr_code='RAT 6', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';


insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAE 31', program_code='228106',competence_code='220501035',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAE 32', program_code='228106',competence_code='220501035',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAE 33', program_code='228106',competence_code='220501035',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAE 34', program_code='228106',competence_code='220501035',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAE 35', program_code='228106',competence_code='220501035',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAE 36', program_code='228106',competence_code='220501035',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAT 07', program_code='228106',competence_code='240201501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAT 7', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='6',tri_work_initials='D',learningr_code='RAT 8', program_code='228106',competence_code='240201502',levelt_code='Tecnologo', learning_edition='v 102';




insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE-1', program_code='228120',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE-2', program_code='228120',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE-3', program_code='228120',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAE-4', program_code='228120',competence_code='220501032',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-001', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-002', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-003', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-004', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-01', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-02', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAB-03', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAT-01', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAT-02', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='1',tri_work_initials='D',learningr_code='RAT-03', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';

insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE-5', program_code='228120',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAE-6', program_code='228120',competence_code='220501007',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB-/1', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB-/2', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB-/3', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB/04', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB/01', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB/02', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAB/03', program_code='228120',competence_code='240501500',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAT-04', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAT-05', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAT-06', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';
insert into cot.trimester_has_learning_result set trimester_number='2',tri_work_initials='D',learningr_code='RAT-07', program_code='228120',competence_code='240501501',levelt_code='Tecnologo', learning_edition='v 102';


-- PRIMER TRIMESTRE
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAE 1', program_code='228106',competence_code='220501006', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAE 2', program_code='228106',competence_code='220501006', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAE 3', program_code='228106',competence_code='220501006', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAE 4', program_code='228106',competence_code='220501032', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAE 5', program_code='228106',competence_code='220501032', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAE 6', program_code='228106',competence_code='220501032', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAB 001', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAB 002', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAB 003', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAB 004', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAT 01', program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAT 02', program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='1', initials_dw='D',number_lear='RAT 1', program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';

-- SEGUNDO TRIMESTRE
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAE 7', program_code='228106',competence_code='220501032', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAE 8', program_code='228106',competence_code='220501032', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAE 9', program_code='228106',competence_code='220501033', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAE 10', program_code='228106',competence_code='220501033', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAE 11', program_code='228106',competence_code='220501033', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAE 12', program_code='228106',competence_code='220501033', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAT 03', program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAB-1', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAB-2', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAB-3', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='2', initials_dw='D',number_lear='RAT 2', program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';

-- TERCER TRIMESTRE
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAE 13', program_code='228106',competence_code='220501033', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAE 14', program_code='228106',competence_code='220501033', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAE 15', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAE 16', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAE 17', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAE 18', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAT 04', program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAB/1', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAB/2', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAB/3', program_code='228106',competence_code='240201500', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='3', initials_dw='D',number_lear='RAT 3', program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';

-- CUARTO TRIMESTRE

insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAE 19', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAE 20', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAE 21', program_code='228106',competence_code='220501007', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAE 22', program_code='228106',competence_code='220501034', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAE 23', program_code='228106',competence_code='220501034', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAE 24', program_code='228106',competence_code='220501034', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAT 05', program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='4', initials_dw='D',number_lear='RAT 4', program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';

-- QUINTO TRIMESTRE

insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAE 25', program_code='228106',competence_code='220501034', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAE 26', program_code='228106',competence_code='220501034', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAE 27', program_code='228106',competence_code='220501009', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAE 28', program_code='228106',competence_code='220501009', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAE 29', program_code='228106',competence_code='220501009', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAE 30', program_code='228106',competence_code='220501009', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAT 06', program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAT 5', program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='5', initials_dw='D',number_lear='RAT 6', program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';

-- SEXTO TRIMESTRE

insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAE 31',program_code='228106',competence_code='220501035', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAE 32',program_code='228106',competence_code='220501035', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAE 33',program_code='228106',competence_code='220501035', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAE 34',program_code='228106',competence_code='220501035', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAE 35',program_code='228106',competence_code='220501035', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAE 36',program_code='228106',competence_code='220501035', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAT 07',program_code='228106',competence_code='240201501', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAT 7',program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';
insert into cot.number_group_has_trimester_has_learning_result set number_group='1349397', number_trimester='6', initials_dw='D',number_lear='RAT 8',program_code='228106',competence_code='240201502', levelt_code='Tecnologo', learningtri_edition='v 102';






-- speciality
insert into cot.speciality set name='Telecomunicaciones',state=true,picture='';
insert into cot.speciality set name='Teleinformatica',state='1',picture='';
insert into cot.speciality set name='Electricidad',state='1',picture='';
insert into cot.speciality set name='Electronica',state='1',picture='';
insert into cot.speciality set name='Promoover',state='1',picture='';

-- link_up

insert into cot.link_up set type_link='Medio Tiempo',hours='4',state='1';
insert into cot.link_up set type_link='Tiempo Completo',hours='8',state='1';

-- rol

insert into cot.rol (id_rol, description, state) values ('Super administrador', 'Crea o elimina roles', true); 
insert into cot.rol (id_rol, description, state) values ('Administrador', 'Crea los horarios', true);

-- document

insert into cot.document (document, name, state) values ('CC', 'Cedula de ciudadania', true);
insert into cot.document (document, name, state) values ('TI', 'Tarjeta de identidad', true);
insert into cot.document (document, name, state) values ('CE', 'Cedula de extranjeria', false);

-- person

insert into cot.person (number_document, first_name, second_name, last_name, second_lname, photo, document) values ('80013831', 'Hernando', 'Enrique' , 'Moreno', 'Moreno', '', 'CC');
insert into cot.person (number_document, first_name, second_name, last_name, second_lname, photo, document) values ('1001054889', 'Luis', 'Fernando' , 'Camargo', 'Pineda', '', 'TI');
insert into cot.person (number_document, first_name, second_name, last_name, second_lname, photo, document) values ('1013686807', 'Jorge', 'Enrique' , 'Peralta', 'Diaz', '', 'CC');
insert into cot.person (number_document, first_name, second_name, last_name, second_lname, photo, document) values ('10304731', 'Carlos', 'David' , 'Acuña', 'Rosado', '', 'CC');
insert into cot.person (number_document, first_name, second_name, last_name, second_lname, photo, document) values ('123456789', 'Wilder', '' , 'Meza', '', '', 'CC');
insert into cot.person (number_document, first_name, second_name, last_name, second_lname, photo, document) values ('987654321', 'Justo', '' , 'Mena', '', '', 'CC');

-- person has rol

insert into cot.person_has_rol (person_number_document, person_id_docuemnt, id_rol) values ('80013831', 'CC', 'Administrador');
insert into cot.person_has_rol (person_number_document, person_id_docuemnt, id_rol) values ('80013831', 'CC', 'Super administrador');
insert into cot.person_has_rol (person_number_document, person_id_docuemnt, id_rol) values ('1001054889', 'TI', 'Super administrador');

-- user 

insert into cot.useri (email, password, person_number, document) values ('hulkike@misena.edu.co', '*********', '80013831', 'CC');
insert into cot.useri (email, password, person_number, document) values ('lfcamargo98@misena.edu.co', '*********', '1001054889', 'TI');
insert into cot.useri (email, password, person_number, document) values ('jeperalta48@misena.edu.co', '*********', '1013686807', 'CC');
insert into cot.useri (email, password, person_number, document) values ('cdacuna0@misena.edu.co', '*********', '10304731', 'CC');

-- instructor
insert into cot.instructor set speciality_name='Teleinformatica',linku_tol='Tiempo Completo',number_document='80013831',document='CC';
insert into cot.instructor set speciality_name='Teleinformatica',linku_tol='Tiempo Completo',number_document='123456789',document='CC';
insert into cot.instructor set speciality_name='Teleinformatica',linku_tol='Tiempo Completo',number_document='987654321',document='CC';

-- modality
insert into cot.modality set name_modality='Virtual',state='1';
insert into cot.modality set name_modality='Presencial',state='1';


--  day

insert into cot.dayi (name_dayi, state) values ('Lunes', true);
insert into cot.dayi (name_dayi, state) values ('Martes', true);
insert into cot.dayi (name_dayi, state) values ('Miercoles', true);
insert into cot.dayi (name_dayi, state) values ('Jueves', true);
insert into cot.dayi (name_dayi, state) values ('Viernes', true);
insert into cot.dayi (name_dayi, state) values ('Sabado', true);
insert into cot.dayi (name_dayi, state) values ('Domingo', true);

-- environment

insert into cot.environment (num_environment, state, description) values ('100', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('Auditorio', true, 'salon para enventos o reuniones con los aprendices');
insert into cot.environment (num_environment, state, description) values ('103', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('200', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('201', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('202', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('300', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('301', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('302', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('303', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('305', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('307', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('400', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('401', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('402', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('Sala de instructores', true, 'salon especifico para reuniones de instructores');
insert into cot.environment (num_environment, state, description) values ('405',true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('407', true, 'salon con 20 a 30 mesas y computadores');
insert into cot.environment (num_environment, state, description) values ('Cafe libro', true, 'salon de promover');
insert into cot.environment (num_environment, state, description) values ('Zona deportiva', true, 'Cultura fisica');

-- trimester term

insert into cot.trimester_term (id_trimester, start_date, end_date) values ('III-2017', 17/7/2017, 23/9/2017);

-- edition 

insert into cot.edition (ide_edition, id_trimester) values ( '102', 'III-2017');

-- disponibility
insert into cot.disponibility set start_date='06:00:00',end_date='18:00:00',number_document='80013831',document='CC',work_initials='D',name_dayi='Lunes';
insert into cot.disponibility set start_date='06:00:00',end_date='18:00:00',number_document='80013831',document='CC',work_initials='D',name_dayi='Martes';
insert into cot.disponibility set start_date='06:00:00',end_date='18:00:00',number_document='80013831',document='CC',work_initials='D',name_dayi='Miercoles';
insert into cot.disponibility set start_date='06:00:00',end_date='18:00:00',number_document='80013831',document='CC',work_initials='D',name_dayi='Jueves';
insert into cot.disponibility set start_date='06:00:00',end_date='18:00:00',number_document='80013831',document='CC',work_initials='D',name_dayi='Viernes';

-- headquarters
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '100');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, 'Auditorio');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '103');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '200');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '201');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '202');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '300');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '301');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '302');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '303');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '305');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '307');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '400');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '401');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '402');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, 'Sala de instructores');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '405');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, '407');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, 'Cafe libro');
insert into cot.headquaters (name_head, direction, state, num_environment) values ('Barrio Colombia', 'Cl. 69 #20-36', true, 'Zona deportiva');

-- timetable

insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', '300', '1349397', '3', 'D', 'Lunes', '102', 'III-2017', 'Presencial', '80013831', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');
insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', '300', '1349397', '3', 'D', 'Martes', '102', 'III-2017', 'Presencial', '80013831', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');
insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', '300', '1349397', '3', 'D', 'Miercoles', '102', 'III-2017', 'Presencial', '80013831', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');
insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', '300', '1349397', '3', 'D', 'Jueves', '102', 'III-2017', 'Presencial', '80013831', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');
insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', '300', '1349397', '3', 'D', 'Viernes', '102', 'III-2017', 'Presencial', '80013831', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');
insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', 'Cafe libro', '1349397', '3', 'D','Lunes', '102', 'III-2017', 'Presencial', '123456789', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');
insert into cot.timetable(name_head, num_environment, number_group, number_tri, initials_dai, name_dai, ide_edition, number_current, name_modality, id_num_document, type_document, start_date, end_date, trim_code) values ('Barrio Colombia', 'Zona deportiva', '1349397', '3','D','Martes',  '102','III-2017', 'Presencial', '987654321', 'CC', 7/17/2017, 23/9/2017, 'Tecnologo');



















































