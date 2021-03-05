# language: es
@Frontend:E2E-CDT
@PBA-1965
@Sprint-52
@PBA-2347

Característica: Creación CDT
  YO COMO  cliente
  NECESITO abrir CDT en linea
  PARA no desplazarme hasta una oficina

  @e2e
  @cdt
  @regresion
  Escenario: Creación CDT no enrolado
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Cuando el usuario realiza el flujo con rendimientos "al vencimiento"
    Entonces se muestra el resumen de la creación del CDT

  @e2e
    @cdt
    @regresion
  Esquema del escenario: Creación CDT
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo enrolado sin renovacion"
    Cuando el usuario realiza el flujo con rendimientos "<periodo>"
    Entonces se muestra el resumen de la creación del CDT
    Ejemplos:
      | periodo               |
      | al vencimiento        |
      | antes del vencimiento |
