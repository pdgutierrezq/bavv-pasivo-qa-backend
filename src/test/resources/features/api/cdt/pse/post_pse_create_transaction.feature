# language: es
@sprint:57
@issue:PBA-2032
@app:CDT
@functionality:PSE.Transacción.Crear
@screen:fondeo_pse
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Servicios web para operaciones PSE
  YO como usuario
  QUIERO consultar los servicios PSE
  PARA fondear mi CDT

  Escenario: Validar operaciones PSE , Crear transacccion, validar estado y finalizar
    Dado que se obtiene un usuario tipo "aleatorio"
    Y crea un transaccion correctamente
    Cuando se valida el estado con operacion exitosa
    Entonces finaliza la transaccion y se confirma el exito de la operacion

