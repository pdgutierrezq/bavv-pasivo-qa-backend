# language: es
@Backend:CondicionesCliente
@BackendCommon
@PBA-14
@Sprint-3
@Sprint-70

Característica: condiciones cliente
  YO COMO sistema
  NECESITO obtener informacion de las condicion es del cliente
  PARA direccionarlo al flujo correspondiente

  Escenario: Consumir servicio de condiciones cliente
    Dado que se obtiene un usuario para condiciones cliente de tipo "aleatorio"
    Cuando consumo el servicio rest de condiciones cliente
    Entonces el obtengo la informacion de las condiciones del cliente



