# language: es
@Frontend:E2E-CDT

Característica: Creación CDT
  YO COMO  cliente
  NECESITO abrir CDT en linea
  PARA no desplazarme hasta una oficina

  @e2e
  @regresion
  Escenario: Creación CDT
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Cuando el usuario realiza el flujo
    Entonces se muestra el resumen de la creación del CDT

  @e2e
  @regresion
  Escenario: Creación CDT no enrolado
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo enrolado sin renovacion"
    Cuando el usuario realiza el flujo
    Entonces se muestra el resumen de la creación del CDT
