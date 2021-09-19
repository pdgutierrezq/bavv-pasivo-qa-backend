# language: es
@Backend:operacionesResumenCdt
@sprint:73
@issue:PBA-2825
@app:CDT
@functionality:PSE.Transacción.Estado
@screen:fondeo_pse
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Servicios web para operaciones sobre resumen CDT
  YO como usuario
  QUIERO consultar los servicios resumen CDT
  PARA guardar,obtener y eliminar informacion

  Escenario: Validar metodo guardar informacion
    Dado que se obtiene un usuario tipo "aleatorio"
    Cuando se guarda informacion en base de datos
    Entonces se lee la informacion del resumen para validar la coincidencia de datos

  Escenario: Validar metodo eliminar informacion
    Dado que se obtiene un usuario tipo "aleatorio"
    Cuando se guarda y eliminan datos del resumen CDT
    Entonces se valida que no existan datos en la base de datos

