-- 1. Mostrar los resulados de aprendizaje del programa de formación ADSI
        
        
select 
learning_result.code,
 program.code_program
 from 
 cot.learning_result,
 cot.program
 where 
 learning_result.code_program = program.code_program
and program.code_program = '228106';


select 
learning_result.code,
 program.code_program
 from 
 cot.learning_result
 inner join
 (cot.program)
 on
 (learning_result.code_program = program.code_program)
 where 
 program.code_program = '228106';
 
 
 -- 2. Mostrar las competencias de ADSI
 
 select 
competence.code_competence,
 program.code_program,
 program.edition
 from 
 cot.competence,
 cot.program
 where 
 competence.code_program = program.code_program
 and program.code_program = '228106';
 
 
 
 select 
competence.code_competence,
 program.code_program,
 program.edition
 from 
 cot.competence
 inner join
 (cot.program)
 on
 ( competence.code_program = program.code_program)
 where 
  program.code_program = '228106';
 
 
 -- 3. Mostrar los resultados de aprendizaje con sus respectivas faces y actividades del proyecto formativo de adsi
 
  select
 learning_result_has_activity.code,
 learning_result_has_activity.id_activity,
 learning_result_has_activity.apn_phase,
 program.code_program
 from
 cot.learning_result_has_activity,
 cot.program
 where
 learning_result_has_activity.program_code = program.code_program
 and program.code_program ='228106';
 
 
 
 select
 learning_result_has_activity.code,
 learning_result_has_activity.id_activity,
 learning_result_has_activity.apn_phase,
 program.code_program
 from
 cot.learning_result_has_activity
 inner join
 (cot.program)
 on
 (learning_result_has_activity.program_code = program.code_program)
 where
 program.code_program ='228106';
 
 
 -- 4. Mostrar los ambiente de la sede barrio colombia
 
 select 
 environment.num_environment,
 headquaters.name_head
 from
 cot.environment,
 cot.headquaters
 where
 environment.num_environment = headquaters.num_environment
 and headquaters.name_head = 'barrio colombia';
 
 
 
 
 select 
 environment.num_environment,
 headquaters.name_head
 from
 cot.environment
 inner join
 (cot.headquaters)
 on
 (environment.num_environment = headquaters.num_environment)
 where
  headquaters.name_head = 'barrio colombia';
 
 
 -- 5. Mostrar que resultados de aprendizaje que se ven en cada trimestre para ADSI diurno
 
 select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result,
 cot.program
 where
 trimester_has_learning_result.program_code = program.code_program
 and program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '1';
 
 
 select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result
 inner join
 (cot.program)
 on
 ( trimester_has_learning_result.program_code = program.code_program)
 where
  program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '1';
 
 
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result,
 cot.program
 where
 trimester_has_learning_result.program_code = program.code_program
 and program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '2';
 
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result
 inner join
 (cot.program)
 on
 (trimester_has_learning_result.program_code = program.code_program)
 where
  program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '2';
 
 
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result,
 cot.program
 where
 trimester_has_learning_result.program_code = program.code_program
 and program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '3';
 
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result
 inner join
 (cot.program)
 on
 ( trimester_has_learning_result.program_code = program.code_program)
 where
 program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '3';
 
 
 
   select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result,
 cot.program
 where
 trimester_has_learning_result.program_code = program.code_program
 and program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '4';
 
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result
 inner join
 (cot.program)
 on
 (trimester_has_learning_result.program_code = program.code_program)
 where
  program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '4';
 
 
 
 select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result,
 cot.program
 where
 trimester_has_learning_result.program_code = program.code_program
  and program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '5';
 
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result
 inner join
 (cot.program)
 on
 ( trimester_has_learning_result.program_code = program.code_program)
 where
  program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '5';
 
 
 select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result,
 cot.program
 where
 trimester_has_learning_result.program_code = program.code_program
 and program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '6';
 
  select
 trimester_has_learning_result.lr_code,
 trimester_has_learning_result.t_wd_initials,
 trimester_has_learning_result.trimester_number,
 program.code_program
 from
 cot.trimester_has_learning_result
 inner join
 (cot.program)
 on
 (trimester_has_learning_result.program_code = program.code_program)
 where
 program.code_program ='228106'
 and trimester_has_learning_result.trimester_number = '6';
 
 -- 6. join de horarios para ver los datos sufientes 
 
 
 select
 timetable.type_document,
 timetable.id_num_document,
 timetable.name_modality,
 number_group.number_group,
 timetable.name_dai,
 timetable.num_environment,
 timetable.name_head
 from
 cot.timetable,
 cot.instructor,
 cot.number_group,
 cot.dayi,
 cot.environment
 where
 timetable.type_document = instructor.document
 and timetable.id_num_document = instructor.number_document
 and timetable.number_group = number_group.number_group
 and timetable.name_dai = dayi.name_dayi
 and timetable.num_environment = environment.num_environment
 and timetable.name_head = 'Barrio Colombia'
 and environment.num_environment = '300'
 and dayi.name_dayi in ('Lunes', 'Miercoles',  'Viernes')
 and instructor.document = 'CC'
 and instructor.number_document = '80013831'
 and timetable.name_modality = 'Presencial'
 and number_group.number_group = '1349397';


 select
 timetable.type_document,
 timetable.id_num_document,
 timetable.name_modality,
 number_group.number_group,
 timetable.name_dai,
 timetable.num_environment,
 timetable.name_head
 from
 cot.timetable 
 inner join
 (cot.instructor, cot.number_group, cot.dayi, cot.environment)
 on
 (timetable.type_document = instructor.document
 and timetable.id_num_document = instructor.number_document
 and timetable.number_group = number_group.number_group
 and timetable.name_dai = dayi.name_dayi
 and timetable.num_environment = environment.num_environment)
 where
 timetable.name_head = 'Barrio Colombia'
 and environment.num_environment = '300'
 and dayi.name_dayi in ('Lunes', 'Miercoles', 'Viernes')
 and instructor.document = 'CC'
 and instructor.number_document = '80013831'
 and timetable.name_modality = 'Presencial'
 and number_group.number_group = '1349397'

 
 

 
 
 
 
 
        