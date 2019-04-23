-- mostrar los resultados de arendizaje del programa de formacion Adsi----------------------------------------------------

-- forma explicita----------------------------------

select 
  
p.program_Code,
p.name,
lo.program_code,
lo.description

from wariosoft.learning_outcome lo inner join wariosoft.program p on (lo.program_code = p.program_Code and
lo.program_code='228106');

-- forma implicita-----------------------

select 
  
p.program_Code,
p.name,
lo.program_code,
lo.description

from wariosoft.learning_outcome lo, wariosoft.program p 
where
(lo.program_code = p.program_Code and
lo.program_code='228106');





-- mostrar las competencias de adsi-------------------------------------------------------------------------------------------------

-- forma explicita------------



select

c.program_code,
c.version,
p.program_Code,
c.description

from wariosoft.competition c inner join wariosoft. program p on (c.program_code=p.program_Code and
c.program_code='228106');

-- forma implicita------------------------

select

c.program_code,
c.version,
p.program_Code,
c.description

from wariosoft.competition c, wariosoft. program p 
where (c.program_code=p.program_Code and
c.program_code='228106');





-- mostrar los ambientes de la sede del barrio colombia----------------------------------------------------------------------

-- forma explicita------------

select 

e.number_environment, 
h.name_headquarters,
e.description

from wariosoft.environment e inner join war.headquarters h on (e.name_headquarters=h.name_headquarters );


-- forma implicita------------------------

select 

e.number_environment, 
h.name_headquarters,
e.description

from war.environment e, war.headquarters h

where(e.name_headquarters=h.name_headquarters);

-- Mostrar los resultados de aprendizaje con sus respectivas faces y actividades del proyecto formativo de adsi-------------------------

select 

lo.code,
loha.outcome_code,


lo.description,
ph.name_phase,
act.name_activity,
loha.id_activity,
act.id_activity,
loha.name_phase,
p.coding,
act.project_code




from war.learning_outcome lo, war.phase ph, war.activity act, war.learning_outcome_has_activity loha, war.project p

where (lo.code=loha.outcome_code and act.id_activity=loha.id_activity and ph.name_phase=loha.name_phase and p.coding=act.project_code and act.project_code='576887 v102' );



-- mostrar que resultados se ven en cada trimestre para adsi diurno---

select

lo.l_Outcome_Code,
lnt.l_Outcome_Code,
lo.description,
tr.name_Trimester,
lnt.name_Trimester,
tr.initials_Working_Day,
lnt.initials_Working_Day



from wariosoft.learning_outcome lo,wariosoft.trimester tr,wariosoft.learning_outcome_has_number_group_has_trimester lnt

where(lo.l_Outcome_Code=lnt.l_Outcome_Code and tr.name_Trimester=lnt.name_Trimester and
 tr.initials_Working_Day=lnt.initials_Working_Day and tr.initials_Working_Day='D');
 
 -- forma explicita
 
 select

lo.l_Outcome_Code,
lnt.l_Outcome_Code,
lo.description,
tr.name_Trimester,
lnt.name_Trimester,
tr.initials_Working_Day,
lnt.initials_Working_Day



from wariosoft.learning_outcome lo inner join wariosoft.trimester tr inner join wariosoft.learning_outcome_has_number_group_has_trimester lnt

on(lo.l_Outcome_Code=lnt.l_Outcome_Code and tr.name_Trimester=lnt.name_Trimester and
 tr.initials_Working_Day=lnt.initials_Working_Day and tr.initials_Working_Day='D');
 
 
 
 
 -- join de horarios para ver los datos sufientes ----------------------------------------
 
 select

s.start_time,
s.end_Time,
s.name_Trimester,
s.document_Number,
s.id_Current_Quarter,
s.id_Document,
s.id_Version,
s.initials_Working_Day,
s.name_Day,
s.name_Headquarters,
s.name_Modality,
s.name_Trimester,
s.number_Environment,
s.number_Group,
d.name_Day,
v.id_Current_Quarter,
v.id_Version,
e.name_Headquarters,
e.number_Environment,
m.name_Modality,
t.id_Document,
t.document_Number,
nt.initials_Working_Day,
nt.name_Trimester,
nt.number_Group


from wariosoft.schedule s,wariosoft.day d, wariosoft.version v, wariosoft.environment e, wariosoft.modality m,wariosoft.teacher t , wariosoft.number_group_has_trimester nt

where(s.name_Day=d.name_Day and
s.id_Current_Quarter=v.id_Current_Quarter and
s.id_Version=v.id_Version and
s.name_Headquarters=e.name_Headquarters and
s.number_Environment=e.number_Environment and
s.name_Modality=m.name_Modality and
s.id_Document=t.id_Document and 
s.document_Number=t.document_Number and
s.initials_Working_Day=nt.initials_Working_Day and
s.name_Trimester=nt.name_Trimester and
s.number_Group=nt.number_Group);

-- forma explicita ------------
 
select

s.start_time,
s.end_Time,
s.name_Trimester,
s.document_Number,
s.id_Current_Quarter,
s.id_Document,
s.id_Version,
s.initials_Working_Day,
s.name_Day,
s.name_Headquarters,
s.name_Modality,
s.name_Trimester,
s.number_Environment,
s.number_Group,
d.name_Day,
v.id_Current_Quarter,
v.id_Version,
e.name_Headquarters,
e.number_Environment,
m.name_Modality,
t.id_Document,
t.document_Number,
nt.initials_Working_Day,
nt.name_Trimester,
nt.number_Group


from wariosoft.schedule s inner join wariosoft.day d inner join wariosoft.version v inner join wariosoft.environment e inner join wariosoft.modality m inner join wariosoft.teacher t inner join wariosoft.number_group_has_trimester nt

on(s.name_Day=d.name_Day and
s.id_Current_Quarter=v.id_Current_Quarter and
s.id_Version=v.id_Version and
s.name_Headquarters=e.name_Headquarters and
s.number_Environment=e.number_Environment and
s.name_Modality=m.name_Modality and
s.id_Document=t.id_Document and 
s.document_Number=t.document_Number and
s.initials_Working_Day=nt.initials_Working_Day and
s.name_Trimester=nt.name_Trimester and
s.number_Group=nt.number_Group)

