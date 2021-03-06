  # language: es
  @Frontend:RedireccionPseCdt
  @Sprint-62
  @PBA-2346
  @CDT
  @regresion
  Característica: Redirección a pantalla de PSE

    YO COMO cliente o no cliente
    NECESITO llegar a la pantalla de PSE
    PARA iniciar el proceso de PSE o ir a resumen

    Escenario: Cliente enrolado redirección a tips
      Dado que se obtiene un usuario tipo "cliente actualizado con canales activos"
      Cuando el usuario selecciona fondeó por "Cuenta AV Villas"
      Y obtiene informacion de si esta enrolado
      Entonces se redirecciona al cliente a pantalla de "tips CDT"

    Escenario: Cliente enrolado redirección a PSE flujo
      Dado que se obtiene un usuario tipo "cliente actualizado con canales activos"
      Cuando el usuario selecciona fondeó por "Pse"
      Y obtiene informacion de si esta enrolado
      Entonces se redirecciona al cliente a pantalla de "PSE en el flujo"

    Escenario: Cliente no enrolado fallido redirección a resumen
      Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
      Cuando el usuario selecciona fondeó por "Cuenta AV Villas"
      Y falla el proceso de enrolamiento
      Entonces se redirecciona al cliente a pantalla de "resumen"
