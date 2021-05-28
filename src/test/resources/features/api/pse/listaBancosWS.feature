# language: es
@Backend:Pse-CDT
@BackendCDT

@Sprint-54
@PBA-2029
@PBA-2029

Característica: Consumo de servicio de Lista banco PSE CDT
  YO COMO  Interfaz grafica de usuario
  NECESITO obtener el listado de bancos
  PARA realizar el proceso de Pse

  @pse
  @regresion
  Escenario: Validacion de esquema de ws get bank list
    Dado que se obtiene un usuario tipo "cliente actualizado"
    Cuando se llama al servicio pse get bank list
    Entonces se validará el esquema de la respuesta
