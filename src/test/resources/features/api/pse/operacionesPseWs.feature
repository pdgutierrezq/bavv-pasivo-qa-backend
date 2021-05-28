  # language: es
  @Backend:creacionTransaccionPseCdt
  @BackendCDT

  @Sprint-55
  @PBA-2030
  @Sprint-56
  @PBA-2031
  @Sprint-57
  @PBA-2032

  @regresion
  Característica: Servicios web para operaciones PSE

    Yo como usuario
    Necesito consultar los servicios PSE
    Para fondear mi CDT

    Escenario: Validar operaciones PSE , Crear transacccion, validar estado y finalizar
      Dado que se obtiene un usuario tipo "aleatorio"
      Y crea un transaccion correctamente
      Cuando se valida el estado con operacion exitosa
      Entonces finaliza la transaccion y se confirma el exito de la operacion

