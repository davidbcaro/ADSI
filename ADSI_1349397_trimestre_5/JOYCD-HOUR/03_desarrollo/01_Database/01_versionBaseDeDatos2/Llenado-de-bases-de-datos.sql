-- project

INSERT INTO joycd.project
(code_project,name_project,status_project)
VALUES('228106','sistema integral web para gestion de procesos educativos del ceet',true);

INSERT INTO joycd.project(code_project,name_project,status_project)
VALUES('576887','sistema integral web para gestion de procesos educativos del ceet',true);

-- phase_project

INSERT INTO joycd.phase_project(name_phase,status_phase,project_code)
VALUES('analisis',true,'576887');

INSERT INTO joycd.phase_project(name_phase,status_phase,project_code)
VALUES('ejecucion',true,'576887');

INSERT INTO joycd.phase_project(name_phase,status_phase,project_code)
VALUES('evaluacion',true,'576887');

INSERT INTO joycd.phase_project(name_phase,status_phase,project_code)
VALUES('planeacion',true,'576887');

-- activity 

INSERT INTO joycd.activity(id_activity,name_activity,name_phase, Project_code)
VALUES('1','Actividades de  induccion en la formacion profesional integral SENA','analisis', '576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES  ('2', 'Determinar los requerimientos del sistema segun especificaciones y lineamientos del proyecto.', 'analisis','576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES ('3', 'Analizar procesos, datos y necesidades del centro de electricidad, electronica y telecomunicaciones y el usuario final para el modulo especifico.', 'analisis','576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES('4','Especificar Modelo Conceptual del sistema,especificando necesidades y requerimientos.','planeacion','576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES ('5','Determinar la estructura logica del sistema','planeacion','576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES('6','Diseñar  la estructura tecnologica  del sistema integral','planeacion','576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES('7','Desarrollar la estructura de datos y de vista de la aplicacion del modulo','ejecucion','576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code)
VALUES('8','Desarrollo los modulos del sistema integral web de acuerdo a los estandares de calidad y normatividad  legal vigente.','ejecucion','576887');

INSERT INTO joycd.activity (id_activity,name_activity,name_phase,Project_code) 
VALUES('9', 'Preparar documentacion del proceso de implantacion del sistema ', 'evaluacion', '576887');

INSERT INTO joycd.activity(id_activity,name_activity,name_phase,Project_code) 
VALUES ('10','Desarrollar las tareas de configuracion y puesta en marcha del sistema ','evaluacion','576887');

INSERT INTO joycd.activity (id_activity,name_activity,name_phase,Project_code)
VALUES('11','Elaborar informes y procesos de evaluacion para la validacion de los productos e implantacion del sistema determinando recursos.','evaluacion','576887');

-- level_formation

INSERT INTO joycd.level_formation
(level_formation,status)
VALUES('Tecnico',true);

INSERT INTO joycd.level_formation
(level_formation,status)
VALUES('Tecnologo',true);

-- program 

INSERT INTO joycd.program(program_code,name,version,initials,status,level_formation)
VALUES('228106','ANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION','Version 102','ADSI',true,'Tecnologo');

INSERT INTO joycd.program(program_code,name,version,initials,status,level_formation)
VALUES('228120','Tecnico EN PROGRAMACIoN DE SOFTWARE','Version 102','TPS',true,'Tecnico');

-- competence 

INSERT INTO joycd.competence(competence_code,description,program_code,version) 
VALUES('220501007','CONSTRUIR EL SISTEMA QUE CUMPLA CON LOS REQUISITOS DE LA SOLUCIoN INFORMATICA','228120','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501032','ANALIZAR LOS REQUISITOS DEL CLIENTE PARA CONSTRUIR EL SISTEMA DE INFORMACION','228120','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('240201500','PROMOVER LA INTERACCIoN IDoNEA CONSIGO MISMO, CON LOS DEMAS Y CON LA NATURALEZA EN LOS CONTEXTOS LABORAL Y SOCIAL','228120','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('240201501','COMPRENDER TEXTOS EN INGLeS EN FORMA ESCRITA Y AUDITIVA','228120','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501006','ESPECIFICAR LOS REQUISITOS NECESARIOS PARA DESARROLLAR EL SISTEMA DE INFORMACION DE ACUERDO CON LAS NECESIDADES DEL CLIENTE','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501007','Construir el sistema que cumpla con los requisitos de la solucion informatica.','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501009','PARTICIPAR EN EL PROCESO DE NEGOCIACIoN DE TECNOLOGiA INFORMaTICA PARAPERMITIR LA IMPLEMENTACIoN DEL SISTEMA DE INFORMACIoN.','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501032','ANALIZAR LOS REQUISITOS DEL CLIENTE PARA CONSTRUIR EL SISTEMA DE INFORMACION','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501033','Diseñar el sistema de acuerdo con los requerimientos del cliente.','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501034','IMPLANTAR LA SOLUCIoN QUE CUMPLA CON LOS REQUISITOS PARA SU OPERACION','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('220501035','APLICAR BUENAS PRaCTICAS DE CALIDAD EN EL PROCESO DE DESARROLLO DE SOFTWARE,DE CUERDO CON EL REFERENTE ADOPTADO EN LA EMPRESA.','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('240201500','Promover la interaccion idonea consigo mismo, con los demas y con la naturaleza en los contextos laboral y social.','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('240201501','Comprender textos en ingles en forma escrita y auditiva.','228106','Version 102');

INSERT INTO joycd.competence(competence_code,description,program_code,version)
VALUES('240201502','Producir textos en ingles en forma escrita y oral.','228106','Version 102');

-- learning_result 

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-13 220501033 05','Aplicar politicas y mecanismos de control en el diseño del sistema de informacion, mediante el analisis de la vulnerabilidad de la informacion, siguiendo los parametros establecidos por la organizacion.','228106','220501033','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-1 220501006-01 ','Aplicar las tecnicas de recoleccion de datos , diseñando  los instrumentos necesarios para el procesamiento de informacion, de acuerdo con la situacion planteada por la empresa.','228106','220501006','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-2 220501006-02 ','Elaborar mapas de procesos que permitan identificar las areas involucradas en un sistema de informacion, utilizando herramientas informaticas y las Tic’s, para generar informes segun las necesidades de la empresa.','228106','220501006','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-3 220501006-03','Plantear diferentes alternativas, de modelos tecnologicos de informacion empresarial, teniendo en cuenta la plataforma  ','228106','220501006','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-4 220501032 01','Interpretar el informe de requerimientos, para determinar las necesidades tecnologicas en el manejo de la informacion, de acuerdo con las normas y protocolos establecidos en la empresa.','228106','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-5 220501032 02','Representa el bosquejo de la solucion al problema presentado por el cliente, mediante la  elaboracion de diagramas de casos de uso,  apoyado en el analisis del informe de requerimientos, al confrontar la situacion problemica con el usuario segun  normas y protocolos de la organizacion.','228106','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-6 220501032 03','Construir el modelo conceptual del macrosistema frente a los requerimientos del cliente,  mediante el uso e interpretacion de la informacion levantada, representado en diagramas de clase, de interaccion, colaboracion y contratos de operacion, de acuerdo con las diferentes secuencias, fases y procedimientos del sistema.','228106','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-1 (Induccion)','Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodologia de formacion, de acuerdo con la dinamica organizacional del SENA. 24020150010 ','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-2 (Induccion)','Concertar alternativas y acciones de formacion para el desarrollo de las competencias del programa formacion, con base en la politica institucional.  24020150014','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-3 (Induccion)','Gestionar la informacion de acuerdo con los procedimientos establecidos y con las tecnologias de la informacion y la comunicacion disponibles.  24020150012','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-4 (Induccion)','Identificar las oportunidades que el Sena ofrece en el marco de la formacion profesional de acuerdo con el contexto nacional e internacional. 24020150013','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-1 (Comunicacion)','24020150005  Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construccion colectiva del conocimiento y la resolucion de problemas de caracter productico y social. ','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-2 (Comunicacion)','24020150011 Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida.  ','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-3 (Comunicacion)','24020150002 Asumir actitudes criticas, argumentativas y propositivas en funcion de la resolucion de problemas de caracter productivo y social.','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-1','Comprender frases y vocabulario habitual sobre temas de interes personal y temas tecnicos. (24020150101)','228106','240201501 ','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-2','Comprender la idea principal en avisos y mensajes breves, claros y sencillos en ingles tecnico. (24020150102)','228106','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT 1','Reproducir en ingles frases o enunciados simples que permitan expresar de forma lenta ideas o conceptos. (24020150201)','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-7 220501032 04','Valorar la incidencia de los datos en los procesos del macrosistema, tomando como referente  el diccionario de datos y las miniespecificaciones, para la consolidacion de los datos que intervienen, de acuerdo con parametros establecidos.','228106','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-8 220501032 05','Elaborar el informe de los resultados del analisis del sistema de informacion, de acuerdo con los requerimientos del cliente  segun normas y protocolos establecidos.','228106','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-9 220501033 02','Diseñar la arquitectura del software, mediante la interpretacion de las clases, objetos y mecanismos de colaboracion, utilizando herramientas tecnologicas de diseño, de acuerdo con las tendencias de las tecnologias de la informacion y la comunicacion.','228106','220501033','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-10 220501033 03','Construir el prototipo del sistema de informacion, a partir del analisis de las caracteristicas funcionales del sistema en relacion con facilidad de manejo, funcionalidad y experiencia del usuario, apoyado en software aplicado segun protocolos de diseño.','228106','220501033','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-11 220501033 04','Diseñar  la estructura de datos, a partir del modelo conceptual determinado en el analisis del sistema, utilizando herramientas tecnologicas de bases de datos, segun las normas y estandares establecidos.','228106','220501033','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-12 220501033 01','Diseñar  la arquitectura tecnologica  del sistema de informacion, mediante el reconocimiento de hardware y software, de acuerdo con la tecnologia disponible en el mercado, el informe de analisis levantado y el diagrama de distribucion.','228106','220501033','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-3 ','Leer textos muy breves y sencillos en ingles general y tecnico. (24020150103)','228106','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-1 (ETICA)','Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecucion de los procesos de aprendizaje.','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-2 (ETICA)','Generar procesos autonomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-3 (ETICA)','Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con vision prospectiva. (24020150004)','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT 2 ','Identificar formas gramaticales basicas en textos y documentos elementales escritos en ingles. (24020150202)','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-14 220501033 06','Elaborar el informe de diseño del sistema de informacion, de acuerdo con la seleccion de las herramientas, tanto de software como de hardware, requeridas para la solucion informatica','228106','220501033','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-15 220501007 01','Interpretar el informe tecnico de diseño, para determinar el plan de trabajo durante la fase de construccion del software, de acuerdo con las normas y protocolos establecidos en la empresa.','228106','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-16 220501007 02','Construir la base de datos, a partir del modelo de datos determinado en el diseño del sistema, utilizando sistemas de gestion de base de datos, segun los protocolos establecidos en la organizacion.','228106','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-17 220501007 03','Construir la interfaz de usuario, apoyado en la evaluacion del prototipo, determinando las entradas y salidas requeridas en el diseño y definiendo los lineamientos para la navegacion, de acuerdo con las necesidades del usuario.','228106','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-18 220501007 04','Realizar la codificacion de los modulos del sistema y el programa principal, a partir de la utilizacion del lenguaje de programacion seleccionado, de acuerdo con las especificaciones del diseño.','228106','220501007 ','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-4','Encontrar informacion especifica y predecible en escritos sencillos y cotidianos. (24020150104)','228106','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-1 (AMBIENTAL Y CULTURA FISICA)','Asumir responsablemente los criterios de preservacion y conservacion del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. (24020150006)','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-2 (AMBIENTAL Y CULTURA FISICA)','Generar habitos saludables en su estilo de vida para garantizar la prevencion de riesgos ocupacionales de acuerdo con el diagnostico de su condicion fisica individual y la naturaleza y complejidad de su desempeño laboral . (24020150007)','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-3 (AMBIENTAL Y CULTURA FISICA)','Aplicar tecnicas de cultura fisica para el mejoramiento de su expresion corporal, desempeño laboral segun la naturaleza y complejidad del area ocupacional. (24020150008)','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-4 (AMBIENTAL Y CULTURA FISICA)','Interactuar en los contextos Productivos y Sociales en funcion de los Principios y Valores Universales.  24020150001 ','228106','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT 3','Comprender una amplia variedad de frases y vocabulario  en ingles sobre temas de interes personal y temas tecnicos. (24020150203) ','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-19 220501007 05','Construir el programa de instalacion del aplicativo, utilizando las herramientas de desarrollo disponibles en el mercado, segun las caracteristicas de la arquitectura de la solucion.','228106','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-20 220501007 06','Elaborar el manual tecnico de la aplicacion, de acuerdo con la complejidad del aplicativo y segun normas y procedimientos establecidos por la empresa.','228106','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-21 220501007 07','Ejecutar y documentar las pruebas del software, aplicando tecnicas de ensayo-error, de acuerdo con el plan diseñado y los procedimientos establecidos por la empresa.','228106','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-23 220501034 02','Elaborar el informe administrativo, siguiendo los protocolos de la organizacion, basado en los planes de instalacion, respaldo y migracion del sistema de informacion, facilitando la operatividad y mantenimiento de la solucion informatica.','228106','220501034','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-24 220501034 03','Definir estrategias para la  validacion de manuales de usuario y de operacion,  respondiendo a las necesidades y satisfaccion del cliente, frente a la solucion informatica propuesta, segun politicas de la organizacion','228106','220501034','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-5','Encontrar vocabulario y expresiones de ingles tecnico en anuncios, folletos, paginas web, etc','228106','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-4','Comprender las ideas principales de textos complejos en ingles que tratan de temas tanto concretos como abstractos, incluso si son de caracter tecnico, siempre que esten dentro de su campo de especializacion. (24020150204)','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-25 220501034 04','Capacitar a los usuarios del sistema, sobre la estructuracion y el manejo del aplicativo,  de acuerdo con el plan establecido, el perfil de los usuarios, segun politicas de la organizacion.','228106','220501034','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-26 220501034 05','Elaborar informes tecnicos relacionados con la solucion informatica implantada, de acuerdo con las propuestas de alternativas aplicadas, teniendo en cuenta las tecnicas de comunicacion y segun normas y protocolos establecidos','228106','220501034','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-27 220501009 01','Interpretar el diagnostico de necesidades informaticas, para determinar las tecnologicas requeridas en el manejo de la informacion, de acuerdo con las normas y protocolos establecidos por la empresa.','228106','220501009','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-28 220501009 02','Definir estrategias para la elaboracion de terminos de referencia y procesos de evaluacion de proveedores, en la adquisicion de tecnologia, segun protocolos establecidos.','228106','220501009','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-29 220501009 03','Participar en los perfeccionamientos de contratos informaticos, estableciendo clausulas tecnicas, que respondan a las necesidades de los actores de la negociacion, de acuerdo con la ley de contratacion.','228106','220501009','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-30 220501009 04','Elaborar el informe sobre el cumplimiento de los terminos de referencia previstos en la negociacion, de acuerdo con la participacion de cada uno de los actores en relacion con la satisfaccion de los bienes informaticos contratados y recibidos, segun normas y protocolos de la organizacion.','228106','220501009','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-6','Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de informacion cotidiana y tecnica','228106','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT 5','Leer textos complejos y con un vocabulario mas especifico, en ingles general y tecnico. (24020150205)','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT 6','Buscar de manera sistematica informacion especifica y detallada en escritos en ingles, mas estructurados y con mayor contenido tecnico. (24020150206)','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-31 220501035 01','Identificar las caracteristicas de los procesos de desarrollo de software, frente al referente de calidad adoptado por la empresa, ajustandolos a los resultados de las mediciones, evaluaciones y recomendaciones realizadas','228106','220501035','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-32 220501035 02','Identificar los puntos criticos de control en los procesos de desarrollo de software, para establecer las acciones a seguir, garantizando el cumplimiento de los estandares de calidad, siguiendo los lineamientos establecidos por la organizacion','228106','220501035','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-33 220501035 03 ','Aplicar los estandares de calidad involucrados en los procesos de desarrollo de software, siguiendo el plan establecido para mantener la integridad de los productos  de trabajo definidos, segun las practicas de configuracion establecidas por la empresa','228106','220501035','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-34 220501035 04 ','Elaborar instrumentos e instructivos, requeridos por el aseguramiento de la calidad, para documentar y evaluar los procesos de desarrollo de software, de acuerdo con las normas y procedimientos establecidas por la empresa.','228106','220501035','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-35 220501035 05','Evaluar procesos y productos de desarrollo de software, documentar y concertar acciones a seguir, para garantizar el cumplimiento de las normas establecidas, de acuerdo con el plan definido y con los criterios de medicion, metricas y politicas determinados por la empresa','228106','220501035','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-36 220501035 06','Elaborar el informe final del proceso de gestion de calidad en el desarrollo de software, que consolide la informacion de las evidencias, hallazgos y novedades frente al seguimiento y control de los productos, segun normas internacionales y protocolos de la organizacion.','228106','220501035','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-7','Realizar intercambios sociales y practicos muy breves, con un vocabulario suficiente para hacer una exposicion o mantener una conversacion sencilla sobre temas tecnicos.','228106','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT 7','Encontrar y utilizar sin esfuerzo vocabulario y expresiones de ingles tecnico en articulos de revistas, libros especializados, paginas web, etc. (24020150207) ','228106','240201502','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-8','Relacionarse con hablantes nativos en un grado suficiente de fluidez y naturalidad, de modo que la comunicacion se realice sin esfuerzo por parte de los interlocutores. (24020150208)','228106','240201502','Version 102');

		--  learning_result : tps
        
INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE 1','INTERPRETAR EL DIAGRAMA RELACIONAL PARA IDENTIFICAR EL MODELO DE DATOS.','228120','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE 2','IDENTIFICAR CADA UNO DE LOS CONCEPTOS Y PRINCIPIOS QUE CONSTITUYE LA PROGRAMACIoN ORIENTADA A OBJETOS PARA INTERPRETAR EL DISEÑO.','228120','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE 3','DESCRIBIR QUE SON LOS MODIFICADORES PARA APLICARLOS A UN PROYECTO DE FORMACIoN','228120','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE 4','INTERPRETAR LOS DIAGRAMAS DE CASO DE USO, DE OBJETOS, DE ESTADOS, DE SECUENCIA, DE PAQUETES O COMPONENTES, DE DESPLIEGUE, DE COLABORACIoN SEGuN EL DISEÑO ENTREGADO.','228120','220501032','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 1 (Induccion)','Reconocer el rol de los participantes en el proceso formativo, el papel de los ambientes de aprendizaje y la metodologia de formacion, de acuerdo con la dinamica organizacional del SENA. 24020150010 ','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 2 (Induccion)','Concertar alternativas y acciones de formacion para el desarrollo de las competencias del programa formacion, con base en la politica institucional.  24020150014','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 3 (Induccion)','Gestionar la informacion de acuerdo con los procedimientos establecidos y con las tecnologias de la informacion y la comunicacion disponibles.  24020150012','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 4 (Induccion)','Identificar las oportunidades que el Sena ofrece en el marco de la formacion profesional de acuerdo con el contexto nacional e internacional. 24020150013','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 1 (Comunicacion)','24020150005  Desarrollar procesos comunicativos eficaces y asertivos dentro de criterios de racionalidad que posibiliten la convivencia, el establecimiento de acuerdos, la construccion colectiva del conocimiento y la resolucion de problemas de caracter productico y social. ','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 2 (Comunicacion)','24020150011 Asumir los deberes y derechos con base en las leyes y la normativa institucional en el marco de su proyecto de vida. ','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB 3 (Comunicacion)','24020150002 Asumir actitudes criticas, argumentativas y propositivas en funcion de la resolucion de problemas de caracter productivo y social.','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-1','Comprender frases y vocabulario habitual sobre temas de interes personal y temas tecnicos. (24020150101)','228120','240201501 ','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-2','Comprender la idea principal en avisos y mensajes breves, claros y sencillos en ingles tecnico. (24020150102)','228120','240201501 ','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-3','Leer textos muy breves y sencillos en ingles general y tecnico. (24020150103','228120','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-4','Encontrar informacion especifica y predecible en escritos sencillos y cotidianos. (24020150104)','228120','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-5','RELACIONAR LAS TABLAS CONSTRUIDAS PARA PRESENTAR LA INFORMACIoN SOLICITADA EN EL DISEÑO.','228120','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-6','CONSTRUIR EL MAPA DE NAVEGACIoN DE ACUERDO CON EL DISEÑO ENTREGADO PARA ORIENTAR AL USUARIO EN EL USO DEL APLICATIVO.','228120','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-7','CONSTRUIR LA MATRIZ CRUD EN EL LENGUAJE DE PROGRAMACIoN SELECCIONADO PARA VERIFICAR LA FUNCIONALIDAD DEL SISTEMA DE ACUERDO CON EL DISEÑO ENTREGADO.','228120','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-8','CONSTRUIR LAS TABLAS QUE HACEN PARTE DEL DISEÑO DEL DIAGRAMA RELACIONAL EN EL MOTOR DE BASE DE DATOS EMPLEANDO LAS CUATRO FORMAS DE NORMALIZACIoN.','228120','220501007','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-1 (ETICA)','Desarrollar permanentemente las habilidades psicomotrices y de pensamiento en la ejecucion de los procesos de aprendizaje.','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-2 (ETICA)','Generar procesos autonomos y de trabajo colaborativo permanentes, fortaleciendo el equilibrio de los componentes racionales y emocionales orientados hacia el Desarrollo Humano Integral.','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-3 (ETICA)','Redimensionar permanentemente su proyecto de vida de acuerdo con las circunstancias del contexto y con vision prospectiva. (24020150004)','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-1 (AMBIENTAL Y CULTURA FISICA)','Asumir responsablemente los criterios de preservacion y conservacion del medio ambiente y de desarrollo sostenible, en el ejercicio de su desempeño laboral y social. (24020150006)','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-2 (AMBIENTAL Y CULTURA FISICA)','Generar habitos saludables en su estilo de vida para garantizar la prevencion de riesgos ocupacionales de acuerdo con el diagnostico de su condicion fisica individual y la naturaleza y complejidad de su desempeño laboral . (24020150007)','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAB-4 (AMBIENTAL Y CULTURA FISICA)','Interactuar en los contextos Productivos y Sociales en funcion de los Principios y Valores Universales.  24020150001 ','228120','240201500','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-5','Encontrar vocabulario y expresiones de ingles tecnico en anuncios, folletos, paginas web, etc. (24020150105)','228120','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-6','Comunicarse en tareas sencillas y habituales que requieren un intercambio simple y directo de informacion cotidiana y tecnica. (24020150106)','228120','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAT-7','Realizar intercambios sociales y practicos muy breves, con un vocabulario suficiente para hacer una exposicion o mantener una conversacion sencilla sobre temas tecnicos. (24020150107)','228120','240201501','Version 102');

INSERT INTO joycd.learning_result(learning_result_code,description,Program_code,competence_code,version)
VALUES('RAE-22 220501034 01','Configurar el software de la aplicacion para cliente y servidor, mediante la utilizacion del hardware disponible,  ejecutandola en la plataforma tecnologica, segun normas y protocolos establecidos por la empresa.','228106','220501034','Version 102');

 -- status_group_number
 

INSERT INTO JOYCD.status_group_number(status_name,status)
VALUES('en formacion', true);

INSERT INTO JOYCD.status_group_number(status_name,status)
VALUES('aplazada', true);

INSERT INTO JOYCD.status_group_number(status_name,status)
VALUES('fusion',true);

INSERT INTO JOYCD.status_group_number(status_name,status)
VALUES('oferta cerrada',true);

-- working day

 select load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/1.jpg');
 select load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/2.jpg');
 select load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/3.jpg');
 
INSERT INTO joycd.working_day(initials,name,description,picture,status)
VALUES('D','Diurno','la jornada diurna tendra una disponibilidad de 6:00 am a 6:00 pm',load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/1.jpg'),true);

INSERT INTO joycd.working_day(initials,name,description,picture,status)
VALUES('N','nocturno','la jornada nocturna tendra una disponibilidad de 6:00 pm a 6:00 am',load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/2.jpg'),true);

INSERT INTO joycd.working_day(initials,name,description,picture,status)
VALUES('FS','fin de semana','la jornada de fin de semana tendra una disponibilidad los sabados,domingos y festivos',load_file('C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/3.jpg'),true);

-- role 

INSERT INTO joycd.role(id_role,description,status)
VALUES('administrador','el admisnistrador ingresara a la aplicacion, asimismo creara los componentes del horario',true);

INSERT INTO joycd.role(id_role,description,status)
VALUES('super-administrador','el super-admisnistrador ingresara a la aplicacion y creara los usuarios que podran logearse',true);

-- identification_card

INSERT INTO joycd.identification_card (id_identification_card_number,name,status)
 VALUES('CC','Cedula de ciudadania',true);

INSERT INTO joycd.identification_card (id_identification_card_number,name,status) 
VALUES('TI','Tarjeta de indentidad',true);

INSERT INTO joycd.identification_card (id_identification_card_number,name,status)
 VALUES('CE','Cedula de Extranjeria',true);

INSERT INTO joycd.identification_card (id_identification_card_number,name,status) 
VALUES('PS','Pasaporte',true);

INSERT INTO joycd.identification_card (id_identification_card_number,name,status) 
VALUES('DNI','Documento nacional de indentificacion',true);

INSERT INTO joycd.identification_card (id_identification_card_number,name,status) 
VALUES('NCS','Numero ciego SENA',true);

-- customer 

INSERT INTO joycd.customer(document_type,first_name,second_name,first_last_name,second_last_name,identification_card_number)
VALUES('8013833','Hernando','Enrique','Moreno','Moreno','CC');

INSERT INTO joycd.customer(document_type,first_name,second_name,first_last_name,second_last_name,identification_card_number)
VALUES('123456789','Wilder','','Meza','','CC');

INSERT INTO joycd.customer(document_type,first_name,second_name,first_last_name,second_last_name,identification_card_number)
VALUES('987654321','Justo','','Mena','','CC');

-- customer has role

INSERT INTO joycd.customer_has_role (person_document_type, identification_card_number, id_role) 
VALUES ('8013833', 'CC', 'super-administrador');

INSERT INTO joycd.customer_has_role (person_document_type, identification_card_number, id_role) 
VALUES ('8013833', 'CC', 'administrador');

-- user

INSERT INTO joycd.user(email,password,document_type,identification_card_number)
VALUES('hemoreno33@misena.edu.co','123456789','8013833','CC');

-- group number

INSERT INTO joycd.group_number(groups_number,start_date,finish_date,route,program_code,version_code,status_group_number)
VALUES('1349397','2017-01-25','2018-06-21','1-G','228106','Version 102','en formacion');

-- trimester

	-- trimestre 1 tecnico
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 1', 'D', 'Tecnico');
INSERT INTO joycd.trimester (trimester_name,working_day_initials, level_formation) VALUES ('Trimestre 1 ', 'N', 'Tecnico');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 1', 'FS', 'Tecnico');
	-- trimestre 1 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 1 ', 'D ', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 1', 'N  ', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 1', 'FS ', 'Tecnologo');
	-- trimestre 2 tecnico
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 2 ', 'D ', 'Tecnico ');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 2 ', 'N', 'Tecnico ');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 2 ', 'FS ', 'Tecnico ');
	-- trimestre 2 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 2 ', 'D ', 'Tecnologo ');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 2 ', 'N ', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 2 ', 'FS ', 'Tecnologo ');
	-- trimestre 3 tecnico 
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 3', 'N ', 'Tecnico ');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 3 ', 'FS', 'Tecnico ');
	-- trimestre 4 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 3 ', 'D', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 3 ', 'N ', 'Tecnologo ');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 3 ', 'FS ', 'Tecnologo ');
	-- trimestre 4 tecnico
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 4', 'N', 'Tecnico');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 4', 'FS', 'Tecnico');
	-- trimestre 4 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 4', 'D', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 4', 'N', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 4', 'FS', 'Tecnologo');
	-- trimestre 5 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 5', 'D', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 5', 'N', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 5', 'FS', 'Tecnologo');
	-- trimestre 6 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 6', 'D', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 6', 'N', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 6', 'FS', 'Tecnologo');
	-- trimester 7 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 7', 'N', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 7', 'FS', 'Tecnologo');
	-- trimester 8 tecnologo
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 8', 'N', 'Tecnologo');
INSERT INTO joycd.trimester (trimester_name,working_day_initials,level_formation) VALUES ('Trimestre 8', 'FS', 'Tecnologo');

-- speciality

INSERT INTO joycd.speciality (name_speciality, status) 
VALUES ('Teleinformatica', true);

INSERT INTO joycd.speciality (name_speciality, status) 
VALUES ('Telecomunicaciones ', true);

INSERT INTO joycd.speciality (name_speciality, status) 
VALUES ('Electricidad ', true);

INSERT INTO joycd.speciality (name_speciality, status) 
VALUES ('Electronica ', true);

INSERT INTO joycd.speciality (name_speciality, status) 
VALUES ('Promover ', true);

-- bonding
INSERT INTO joycd.bonding (type_bonding, hours, status)
 VALUES ('Tiempo Completo', '8', True);
INSERT INTO joycd.bonding (type_bonding, hours, status)
 VALUES ('Medio Tiempo ', '4', True );
 
 -- day

INSERT INTO joycd.day (name_day,status)
 VALUES ('Lunes',true);
 
INSERT INTO joycd.day(name_day, status) 
 VALUES ('Martes',True);
 
 INSERT INTO joycd.day(name_day,status)
VALUES('Miercoles ',True);

INSERT INTO joycd.day(name_day,status) 
 VALUES ('Jueves',True);
 
INSERT INTO joycd.day(name_day, status)
VALUES('Viernes',True);
 
INSERT INTO joycd.day(name_day,status)
 VALUES('Sabado',True);
 
INSERT INTO joycd.day (name_day,status)
 VALUES ('Domingo',True);
 
 -- headquarters
 
INSERT INTO joycd.headquarters (name_headquarters, direction, status) 
VALUES ('sede barrio colombia','Cl. 69 #20-36', true);

-- environment

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('100', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('103', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('200', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('201', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('202', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('300', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('301', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('302', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('303', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('305', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('307', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('400', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('401', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('402', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('405', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('407', 'ambiente con aproximadamente 20 computadores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('Auditorio', 'Salon con gran espacio ventanas amplias y sillas', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('sala de instructores', 'Salon para instructores', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('cafe libro', 'Sala de lectura del complejo', true, 'sede barrio colombia');

INSERT INTO joycd.environment (number_environment, description, status, headquarters_name) 
VALUES ('zona deportiva', 'Parque ubicado en los alrededores de la sede', true, 'sede barrio colombia');


-- modality 

INSERT INTO joycd.modality(name_modality, status) 
 VALUES ('Presencial',True);
 
INSERT INTO joycd.modality (name_modality,status)
VALUES ('Virtual',True);

-- actuality trimester

INSERT INTO joycd.actuality_trimester (actuality_trimester,date_start,date_finish) 
VALUES ('Trimestre 1' , '2017-01-25', '2017-04-05');

INSERT INTO joycd.actuality_trimester (actuality_trimester,date_start,date_finish) 
VALUES ('Trimestre 2' , '2017-04-05', '2017-06-21');

INSERT INTO joycd.actuality_trimester (actuality_trimester,date_start,date_finish) 
VALUES ('Trimestre 3' , '2017-07-17', '2017-09-23');

INSERT INTO joycd.actuality_trimester (actuality_trimester,date_start,date_finish) 
VALUES ('Trimestre 4' , '2017-09-10', '2017-12-10');

INSERT INTO joycd.actuality_trimester (actuality_trimester,date_start,date_finish) 
VALUES ('Trimestre 5' , '2018-01-25', '2018-04-05');

INSERT INTO joycd.actuality_trimester (actuality_trimester,date_start,date_finish) 
VALUES ('Trimestre 6' , '2018-04-05', '2018-06-21');

-- version_shedule

INSERT INTO joycd.version_schedule(version,status_version,actuality_trimester)
 VALUES('102', True,'Trimestre 1');
 
INSERT INTO joycd.version_schedule(version, status_version,actuality_trimester) 
VALUES ('102',True,'Trimestre 2');
 
INSERT INTO joycd.version_schedule(version, status_version, actuality_trimester)
 VALUES('102', True,'Trimestre 3');
 
INSERT INTO joycd.version_schedule(version, status_version, actuality_trimester)
 VALUES ('102',True,'Trimestre 4');
 
INSERT INTO joycd.version_schedule(version, status_version,actuality_trimester) 
 VALUES ('102',True,'Trimestre 5');
 
INSERT INTO joycd.version_schedule (version,status_version,actuality_trimester) 
VALUES ('102', True, 'Trimestre 6');

-- learing_result_has_activity

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-1 (Induccion)','240201500','228106','1','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-2 (Induccion)','240201500','228106','1','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-4 (Induccion)','240201500','228106','1','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-3 (Induccion)','240201500','228106','1','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-1','240201501 ','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-2','240201501','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-3','240201501','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-4','240201501','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-1 220501006-01','220501006','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-2 220501006-02 ','220501006','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-3 220501006-03','220501006','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-3 (Comunicacion)','240201500','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-1 (Comunicacion)','240201500','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-2 (Comunicacion)','240201500','228106','2','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-31 220501035 01','220501035','228106','3','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-27 220501009 01','220501009','228106','3','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-4 220501032 01','220501032','228106','3','analisis','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-7 220501032 04','220501032','228106','3','analisis','576887','Version 102');

-- planeacion 
INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-2 (ETICA)','240201500','228106','4','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-5 220501032 02','220501032','228106','4','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-6 220501032 03','220501032','228106','4','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-8 220501032 05','220501032','228106','4','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-32 220501035 02','220501035','228106','4','planeacion','576887','Version 102');
-- :V 5

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-9 220501033 02','220501033','228106','5','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-11 220501033 04','220501033','228106','5','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-10 220501033 03','220501033','228106','5','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-13 220501033 05','220501033','228106','5','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-34 220501035 04 ','220501035','228106','5','planeacion','576887','Version 102');


-- 6

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-5','240201501','228106','6','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-1 (ETICA)','240201500','228106','6','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-12 220501033 01','220501033','228106','6','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-14 220501033 06','220501033','228106','6','planeacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-28 220501009 02','220501009','228106','6','planeacion','576887','Version 102');

-- ejecucion 

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-2 (AMBIENTAL Y CULTURA FISICA)','240201500','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-1 (AMBIENTAL Y CULTURA FISICA)','240201500','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-4 (AMBIENTAL Y CULTURA FISICA)','240201500','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-3 (AMBIENTAL Y CULTURA FISICA)','240201500','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-6','240201501 ','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-15 220501007 01','220501007','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-16 220501007 02','220501007','228106','7','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-17 220501007 03','220501007','228106','7','ejecucion','576887','Version 102');

-- 8

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-18 220501007 04','220501007 ','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-19 220501007 05','220501007','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-33 220501035 03 ','220501035','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-7','240201501','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT 1','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT 2','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT 3','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-4','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT 5','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT 6','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT 7','240201502','228106','8','ejecucion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAT-8','240201502','228106','8','ejecucion','576887','Version 102');

-- evaluacion

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAB-3 (ETICA)','240201500','228106','9','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-21 220501007 07','220501007','228106','9','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-20 220501007 06','220501007','228106','9','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-22 220501034 01','220501034','228106','10','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-23 220501034 02 ','220501034','228106','10','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-25 220501034 04','220501034','228106','10','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-29 220501009 03','220501009','228106','10','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-30 220501009 04','220501009','228106','10','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-24 220501034 03','220501034','228106','11','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-26 220501034 05','220501034','228106','11','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-35 220501035 05','220501035','228106','11','evaluacion','576887','Version 102');

INSERT INTO joycd.learning_result_has_activity(learning_result_code,competence_code,program_code,id_activity,name_phase,project_code,version)
VALUES('RAE-36 220501035 06','220501035','228106','11','evaluacion','576887','Version 102');

-- grup_number_has_trimester

INSERT INTO joycd.group_number_has_trimester (groups_number, trimester_name, working_day_initials, level_formation) 
VALUES ('1349397', 'Trimestre 1', 'D', 'Tecnologo');
INSERT INTO joycd.group_number_has_trimester (groups_number, trimester_name, working_day_initials, level_formation) 
VALUES ('1349397', 'Trimestre 2', 'D', 'Tecnologo');
INSERT INTO joycd.group_number_has_trimester (groups_number, trimester_name, working_day_initials, level_formation) 
VALUES ('1349397', 'Trimestre 3', 'D', 'Tecnologo');
INSERT INTO joycd.group_number_has_trimester (groups_number, trimester_name, working_day_initials, level_formation) 
VALUES ('1349397', 'Trimestre 4', 'D', 'Tecnologo');
INSERT INTO joycd.group_number_has_trimester (groups_number, trimester_name, working_day_initials, level_formation) 
VALUES ('1349397', 'Trimestre 5', 'D', 'Tecnologo');
INSERT INTO joycd.group_number_has_trimester (groups_number, trimester_name, working_day_initials, level_formation) 
VALUES ('1349397', 'Trimestre 6', 'D', 'Tecnologo');

-- instructor
INSERT INTO joycd.instructor(document_type,identification_card,type_bonding,name_speciality)
VALUES('8013833','CC','tiempo completo','Teleinformatica');

INSERT INTO joycd.instructor(document_type,identification_card,type_bonding,name_speciality)
VALUES('123456789','CC','medio tiempo','promover');

INSERT INTO joycd.instructor(document_type,identification_card,type_bonding,name_speciality)
VALUES('987654321','CC','tiempo completo ','promover');


-- trimestre_has_learning_result

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 1','D','RAE-1 220501006-01 ','228106','220501006','Tecnologo', 'Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 1','D','RAE-2 220501006-02  ','228106','220501006','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 1','D','RAE-3 220501006-03','228106','220501006','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 1','D','RAE-4 220501032 01','228106','220501032','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 1','D','RAE-5 220501032 02','228106','220501032','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 1','D','RAE-6 220501032 03','228106','220501032','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 2','D','RAE-7 220501032 04','228106','220501032','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 2','D','RAE-8 220501032 05','228106','220501032','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 2','D','RAE-9 220501033 02','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 2','D','RAE-10 220501033 03','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 2','D','RAE-11 220501033 04','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 2','D','RAE-12 220501033 01','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 3','D','RAE-13 220501033 05','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 3','D','RAE-14 220501033 06','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 3','D','RAE-15 220501007 01','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 3','D','RAE-16 220501007 02','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 3','D','RAE-17 220501007 03','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 3','D','RAE-18 220501007 04','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 4','D','RAE-19 220501007 05','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 4','D','RAE-20 220501007 06','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 4','D','RAE-21 220501007 07','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 4','D','RAE-22 220501034 01','228106','220501034','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 4','D','RAE-23 220501034 02 ','228106','220501034','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 4','D','RAE-24 220501034 03','228106','220501034','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 5','D','RAE-25 220501034 04','228106','220501034','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 5','D','RAE-26 220501034 05','228106','220501034','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 5','D','RAE-27 220501009 01','228106','220501009','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 5','D','RAE-28 220501009 02','228106','220501009','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 5','D','RAE-29 220501009 03','228106','220501009','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 5','D','RAE-30 220501009 04','228106','220501009','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 6','D','RAE-31 220501035 01','228106','220501035','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 6','D','RAE-32 220501035 02','228106','220501035','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 6','D','RAE-33 220501035 03 ','228106','220501035','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 6','D','RAE-34 220501035 04 ','228106','220501035','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 6','D','RAE-35 220501035 05','228106','220501035','Tecnologo','Version 102');

INSERT INTO joycd.trimester_has_learning_result(trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('Trimestre 6','D','RAE-36 220501035 06','228106','220501035','Tecnologo','Version 102');


-- availability 

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','8013833','CC','Lunes','D');
 
INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','8013833','CC','Martes','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','8013833','CC','Miercoles','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','8013833','CC','Jueves','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','8013833','CC','Viernes','D');

-- educacion fisica

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','987654321','CC','Lunes','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','987654321','CC','Martes','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','987654321','CC','Miercoles ','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','987654321','CC','Jueves','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','987654321','CC','Viernes','D');

-- promover 

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Lunes','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Martes','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Miercoles ','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Jueves','D');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Viernes','D');


INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('18:00','22:00','123456789','CC','Lunes','N');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('18:00','22:00','123456789','CC','Martes','N');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('18:00','22:00','123456789','CC','Miercoles ','N');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('18:00','22:00','123456789','CC','Jueves','N');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('18:00','22:00','123456789','CC','Viernes','N');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Sabado','FS');

INSERT INTO joycd.availability(hour_start,hour_end,document_type,identification_card,name_day,working_day_initials)
VALUES('6:00','18:00','123456789','CC','Domingo','FS');


-- group_number_has_trimester_has_learingresult

INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 1','D','RAE-1 220501006-01 ','228106','220501006','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 1','D','RAE-2 220501006-02  ','228106','220501006','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 1','D','RAE-3 220501006-03','228106','220501006','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 1','D','RAE-4 220501032 01','228106','220501032','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 1','D','RAE-5 220501032 02','228106','220501032','Tecnologo','Version 102');

INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 1','D','RAE-6 220501032 03','228106','220501032','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 2','D','RAE-7 220501032 04','228106','220501032','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 2','D','RAE-8 220501032 05','228106','220501032','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 2','D','RAE-9 220501033 02','228106','220501033','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 2','D','RAE-10 220501033 03','228106','220501033','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 2','D','RAE-11 220501033 04','228106','220501033','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 2','D','RAE-12 220501033 01','228106','220501033','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 3','D','RAE-13 220501033 05','228106','220501033','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 3','D','RAE-14 220501033 06','228106','220501033','Tecnologo','Version 102');

INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 3','D','RAE-15 220501007 01','228106','220501007','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 3','D','RAE-16 220501007 02','228106','220501007','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 3','D','RAE-17 220501007 03','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 3','D','RAE-18 220501007 04','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 4','D','RAE-19 220501007 05','228106','220501007','Tecnologo','Version 102');

INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 4','D','RAE-20 220501007 06','228106','220501007','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 4','D','RAE-21 220501007 07','228106','220501007','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 4','D','RAE-22 220501034 01','228106','220501034','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 4','D','RAE-23 220501034 02 ','228106','220501034','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 4','D','RAE-24 220501034 03','228106','220501034','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 5','D','RAE-25 220501034 04','228106','220501034','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 5','D','RAE-26 220501034 05','228106','220501034','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 5','D','RAE-27 220501009 01','228106','220501009','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 5','D','RAE-28 220501009 02','228106','220501009','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 5','D','RAE-29 220501009 03','228106','220501009','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 5','D','RAE-30 220501009 04','228106','220501009','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 6','D','RAE-31 220501035 01','228106','220501035','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 6','D','RAE-32 220501035 02','228106','220501035','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 6','D','RAE-33 220501035 03 ','228106','220501035','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 6','D','RAE-34 220501035 04 ','228106','220501035','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 6','D','RAE-35 220501035 05','228106','220501035','Tecnologo','Version 102');


INSERT INTO joycd.group_number_has_trimester_has_learning_result(group_number,trimester_name,working_day_initials,learning_result_code,program_code,competence_code,level_formation,version)
VALUES('1349397','Trimestre 6','D','RAE-36 220501035 06','228106','220501035','Tecnologo','Version 102');


-- shedule

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('6:00','12:00','Presencial','2017/09/23','102','Trimestre 3','200','sede barrio colombia','Lunes','8013833','CC','1349397','Trimestre 3','D','Tecnologo');

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('6:00','12:00','Presencial','2017/09/23','102','Trimestre 3','200','sede barrio colombia','Martes','8013833','CC','1349397','Trimestre 3','D','Tecnologo');

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('6:00','12:00','Presencial','2017/09/23','102','Trimestre 3','200','sede barrio colombia','Miercoles','8013833','CC','1349397','Trimestre 3','D','Tecnologo');

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('6:00','12:00','Presencial','2017/09/23','102','Trimestre 3','200','sede barrio colombia','Jueves','8013833','CC','1349397','Trimestre 3','D','Tecnologo');

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('6:00','12:00','Presencial','2017/09/23','102','Trimestre 3','200','sede barrio colombia','Viernes','8013833','CC','1349397','Trimestre 3','D','Tecnologo');

-- promover

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('12:00','14:00','Presencial','2017/09/23','102','Trimestre 3','cafe libro','sede barrio colombia','Lunes','123456789','CC','1349397','Trimestre 3','D','Tecnologo');

-- educacion fisica

INSERT INTO joycd.schedule(hour_start,hour_end,name_modality,schedule_finish,version,version_actuality_trimester,number_environment,headquarters_name,name_day,document_type,identification_card_number,groups_number,trimester_name,working_day_initials,level_formation)
VALUES('14:00','16:00','Presencial','2017/09/23','102','Trimestre 3','zona deportiva','sede barrio colombia','Lunes','987654321','CC','1349397','Trimestre 3','D','Tecnologo');

