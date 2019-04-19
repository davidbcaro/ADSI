

-- joins implicitos

 -- primer punto
 select 
 learning_result.learning_result_code,
 learning_result.Program_code
 from 
 joycd.learning_result,
 joycd.program
 where 
 learning_result.Program_code = program.program_code
 and program.program_code ='228106';
 
 -- segundo punto 
 select 
 competence.competence_code,
 competence.program_code
 from
 joycd.competence,
 joycd.program
 where 
 competence.program_code = program.program_code
 and program.program_code= '228106';
 
 -- tercer punto 
 select
 learning_result_has_activity.learning_result_code,
 learning_result_has_activity.name_phase,
 learning_result_has_activity.id_activity,
 program.program_code
 from 
 joycd.learning_result_has_activity,
 joycd.program
 where 
 learning_result_has_activity.program_code = program.program_code
 and program.program_code='228106';
 
  -- cuarto punto 
  select 
  environment.headquarters_name,
  environment.number_environment
  from
  joycd.environment,
  joycd.headquarters
  where 
  environment.headquarters_name = headquarters.name_headquarters
  and headquarters.name_headquarters='sede barrio colombia';
  
  -- quinto punto 
  
select 
trimester_has_learning_result.learning_result_code,
trimester_has_learning_result.trimester_name,
trimester_has_learning_result.program_code
from
joycd.trimester_has_learning_result,
joycd.program
where 
trimester_has_learning_result.program_code = program.program_code
and program.Program_code = '228106';
  
  -- sexto punto 
  select 
 schedule.hour_start,
 schedule.hour_end,
 schedule.number_environment,
 schedule.groups_number,
 schedule.name_day,
 schedule.version,
 schedule.headquarters_name,
 schedule.trimester_name
 from
 joycd.schedule,
 joycd.group_number
 where
 schedule.groups_number = group_number.groups_number
 and group_number.groups_number= '1349397';
 
 
 
 
   -- joins explicitos
 
  -- primer punto
 select 
 learning_result.learning_result_code,
 learning_result.Program_code
 from 
 joycd.learning_result
 join
 (joycd.program)
 on
 (learning_result.Program_code = program.program_code)
 where 
  program.program_code ='228106';
 
 -- segundo punto 
 select 
 competence.competence_code,
 competence.program_code
 from
 joycd.competence
 join
 (joycd.program)
 on
 (competence.program_code = program.program_code)
 where 
 program.program_code= '228106';
 
 -- tercer punto 
 select
 learning_result_has_activity.learning_result_code,
 learning_result_has_activity.name_phase,
 learning_result_has_activity.id_activity,
 program.program_code
 from 
 joycd.learning_result_has_activity
 join
 (joycd.program)
 on
 (learning_result_has_activity.program_code = program.program_code)
 where 
 program.program_code='228106';
 
  -- cuarto punto 
  select 
  environment.headquarters_name,
  environment.number_environment
  from
  joycd.environment
  join
  (joycd.headquarters)
  on(environment.headquarters_name = headquarters.name_headquarters)
  where 
  headquarters.name_headquarters='sede barrio colombia';
  
  -- quinto punto 
  
select 
trimester_has_learning_result.learning_result_code,
trimester_has_learning_result.trimester_name,
trimester_has_learning_result.program_code
from
joycd.trimester_has_learning_result
join
(joycd.program)
on(trimester_has_learning_result.program_code = program.program_code)
where 
program.Program_code = '228106';
  
  -- sexto punto 
  select 
 schedule.hour_start,
 schedule.hour_end,
 schedule.number_environment,
 schedule.groups_number,
 schedule.name_day,
 schedule.version,
 schedule.headquarters_name,
 schedule.trimester_name
 from
 joycd.schedule
 join 
 (joycd.group_number)
 on(schedule.groups_number = group_number.groups_number)
 where
 group_number.groups_number= '1349397';