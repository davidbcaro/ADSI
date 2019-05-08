use Datasafety;

 select IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario,ModeloEqui,SerialCargadorEqui,Observacion,MarcaEquipo_Equipo,TipoEquipo_Equipo
 from  Usuarios join Equipo on 
 Usuarios.IdUsuario  = Equipo.IdEqui
 
 select IdTipoUsuario,NombreTipoUsuario,IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario
 from  TipoUsuario join Usuarios on 
 TipoUsuario.IdTipoUsuario  = Usuarios.IdUsuario
 
  select IdTipoDocumento,NombreTipoDocumento,IdUsuario,N_identificacion,Primer_nombre,Segundo_nombre,Primer_Apellido,Segundo_Apellido,CorreoIns,Fecha_Act,Fecha_Inact,tipousuario_usuario,TipoDocumento_usuario
 from  TipoDocumento join Usuarios on 
 TipoDocumento.IdTipoDocumento  = Usuarios.IdUsuario
 
   select IdMarcaEquipo,NombreMarcaEquipo,ModeloEqui,TipoEquipo_Equipo,Observacion 
 from  MarcaEquipo join Equipo on 
 MarcaEquipo.IdMarcaEquipo  = Equipo.IdEqui
 
 select IdTipoEquipo,NombreTipoEquipo,ModeloEqui,MarcaEquipo_Equipo
 from  TipoEquipo join Equipo on 
 TipoEquipo.IdTipoEquipo  = Equipo.IdEqui
 
 select IdMovimiento,FechaEntradaMovimiento,FechaSalidaMovimiento,MarcaEquipo_Equipo,TipoEquipo_Equipo,ModeloEqui
 from  Movimiento left join Equipo on 
 Movimiento.IdMovimiento  = Equipo.IdEqui