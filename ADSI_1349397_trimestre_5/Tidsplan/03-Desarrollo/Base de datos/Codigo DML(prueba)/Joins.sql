-- 1. Mostrar los resulados de aprendizaje del programa de formación ADSI
-- Implicito


SELECT 
	tp.id_code as Codigo_del_programa,
    tp.name as Nombre_programa,
    lr.id_code as Codigo_del_resultado_de_aprendizaje,
    lr.description as Descripcion
    
FROM
    tidsplan.learning_result lr,
    tidsplan.training_program tp
WHERE
    lr.program_code  = tp.id_code
    AND lr.program_code = '228106';
    
-- Explicito
    
   SELECT 
    tp.id_code as Codigo_del_programa,
    tp.name as Nombre_programa,
    lr.id_code as Codigo_del_resultado_de_aprendizaje,
    lr.description as Descripcion
    
FROM
    tidsplan.learning_result lr
        JOIN
    tidsplan.training_program tp ON ( lr.program_code  = tp.id_code)
WHERE
    lr.program_code = '228106';
    
    
-- 2. Mostrar las competencias de ADSI
-- implicito

SELECT 
    tp.id_code as Codigo_del_programa,
    tp.name as Nombre_programa,
	c.code as Codigo_de_la_competencia,
	c.description as Descripcion
    
FROM
    tidsplan.competition c,
    tidsplan.training_program tp
WHERE
    c.program_code  = tp.id_code
    AND c.program_code = '228106';
    
-- Explicito
    
   SELECT 
    tp.id_code as Codigo_del_programa,
    tp.name as Nombre_programa,
	c.code as Codigo_de_la_competencia,
	c.description as Descripcion
    
FROM
    tidsplan.competition c
        JOIN
    tidsplan.training_program tp ON (c.program_code  = tp.id_code)
WHERE
    c.program_code = '228106';
    
    
-- 3. Mostrar los resultados de aprendizaje con sus respectivas faces y actividades del proyecto formativo de adsi

-- implicito

SELECT 
    tp.id_code as Codigo_del_programa,
    tp.name as Nombre_programa,
	lr.id_code as Codigo_resultado_aprendizaje,
	lr.description as Descripcion_resultado_aprendizaje,
    a.id_activity as Codigo_actividad,
    a.name as Nombre_actividad
    

    
    
FROM
    tidsplan.learning_result_has_activity lrha,
    tidsplan.training_program tp,
    tidsplan.learning_result lr,
    tidsplan.activity a
WHERE
    tp.id_code  = lrha.program_code
    AND lrha.lr_code = lr.id_code
	AND lrha.id_activity = a.id_activity

    AND tp.id_code  = lr.program_code
	AND tp.id_code = '228106';
    
-- Explicito
    
   SELECT 
	tp.id_code as Codigo_del_programa,
    tp.name as Nombre_programa,
	lr.id_code as Codigo_resultado_aprendizaje,
	lr.description as Descripcion_resultado_aprendizaje,
    a.id_activity as Codigo_actividad,
    a.name as Nombre_actividad
    
FROM
    tidsplan.learning_result_has_activity lrha,
    tidsplan.learning_result lr

        JOIN
    (tidsplan.training_program tp, tidsplan.activity) a ON (tp.id_code  = lrha.program_code
    AND lrha.lr_code = lr.id_code
	AND lrha.id_activity = a.id_activity
	AND tp.id_code  = lr.program_code)
WHERE
	tp.id_code = '228106';

-- 4. Mostrar los ambiente de la sede barrio colombia

-- Implicito


SELECT 
	e.number_environment as Sede,
    h.name_headquartes as Ambiente
    
FROM
    tidsplan.headquartes h,
    tidsplan.environment e 
WHERE
	e.name_headquartes = h.name_headquartes
		AND h.name_headquartes='Barrio Colombia';
    
-- Explicito
    
   SELECT 
    e.number_environment as Sede,
    h.name_headquartes as Ambiente
    
FROM
    tidsplan.headquartes h
        JOIN
    tidsplan.environment e ON (	e.name_headquartes = h.name_headquartes)
WHERE
	h.name_headquartes='Barrio Colombia';
    
    
-- 5. Mostrar que resultados de aprendizaje que se ven en cada trimestre para ADSI diurno

-- Implicito
SELECT 
		qp.name_trimester,
        qp.workingday_initials,
        qp.lr_code,
        qp.program_code,
		lr.description
FROM
    tidsplan.learning_result lr,
    tidsplan.trimester tr,
    tidsplan.quarter_planning qp
WHERE
	tr.name_trimester = qp.name_trimester
        AND lr.id_code = qp.lr_code
        AND tr.workingday_initials = qp.workingday_initials
        AND qp.program_code= '228106';
    
-- Explicito
    
   SELECT 
    qp.name_trimester,
        qp.workingday_initials,
        qp.lr_code,
        qp.program_code,
		lr.description
    
FROM
    
    tidsplan.quarter_planning qp
        inner JOIN
    (tidsplan.learning_result lr, tidsplan.trimester tr) ON (	tr.name_trimester = qp.name_trimester AND lr.id_code = qp.lr_code AND tr.workingday_initials = qp.workingday_initials

)
    
WHERE
	qp.program_code= '228106';



-- 6. join de horarios para ver los datos sufientes 
-- implicito

	SELECT 
	sc.start_hour, 
    sc.end_hour, 
    sc.id_version, 
    sc.name_day, 
    sc.id_trimester_current,
    sc.name_modality, 
    sc.number_environment, 
    sc.name_headquartes, 
    sc.number_group, 
    sc.name_trimester,
    sc.working_day_initials, 
    sc.document_number, 
    sc.document
    
FROM
    tidsplan.schedule sc
    where 
    sc.number_group = '1349397';

    
    
-- Explicito
    
   SELECT 
    sc.start_hour, 
    sc.end_hour, 
    sc.id_version, 
    sc.name_day, 
    sc.id_trimester_current,
    sc.name_modality, 
    sc.number_environment, 
    sc.name_headquartes, 
    sc.number_group, 
    sc.name_trimester,
    sc.working_day_initials, 
    sc.document_number, 
    sc.document
    
FROM
    tidsplan.schedule sc
    
        JOIN
    tidsplan.group g ON ( sc.number_group  = g.number_group )
WHERE
    sc.number_group = '1349397';
    
        