# language: es
@Frontend:Pse-CDT
@Sprint-57
@PBA-2083
@CDT

Característica: Pantalla de PSE en el flujo
  YO COMO  Cliente finalizando el flujo de CDT
  NECESITO que se me muestre la pantalla de PSE
  PARA fondear mi CDT

  @pse
  @regresion
  Escenario: Precarga de información en pantalla de PSE
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Y que llegúe a la pantalla de PSE
    Cuando cargue la pantalla
    Entonces se mostrará precargada la información del número del CDT y el monto a invertir

  @pse
  @regresion
  Escenario: Lista desplegable de bancos
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Y que llegúe a la pantalla de PSE
    Cuando se llama el servicio de PSE lista bancos con respuesta exitosa
    Entonces se cargarà el listado de bancos como opciones para la pregunta ¿De qué banco traerás tu plata?

