# language: es
@Backend:ValidarSeguro
@BackendCommon
@PBA-1432
@Sprint-38


Característica: Validacion de seguro
  YO COMO sistema
  NECESITO determinar si el cliente tiene o no seguro
  PARA ofrecerle el producto o no

  Escenario: Consumir servicio de insurance-validation
    Dado que se obtiene un usuario tipo "no cliente" para validar seguro
    Cuando se consulta si el usuario tiene seguro
    Entonces se validara que el usuario no tiene seguro


