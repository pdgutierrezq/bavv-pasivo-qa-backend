  # language: es
  @Backend:operacionesResumenCdt
  @BackendCDT

  @Sprint-72
  @PBA-2794

  @Sprint-73
  @PBA-2822
  @PBA-2825


  @regresion
  @qa

  Característica: Servicios web para operaciones sobre rsumen CDT

    Yo como usuario
    Necesito consultar los servicios resumen CDT
    Para guardar,obtener y eliminar informacion

    Escenario: Validar metodo guardar informacion
      Dado que se obtiene un usuario tipo "aleatorio"
      Cuando se guarda informacion en base de datos
      Entonces se lee la informacion del resumen para validar la coincidencia de datos

    Escenario: Validar metodo eliminar informacion
      Dado que se obtiene un usuario tipo "aleatorio"
      Cuando se guarda y eliminan datos del resumen CDT
      Entonces se valida que no existan datos en la base de datos

