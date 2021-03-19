# language: es
@Frontend:E2E-CDT
@Sprint-52
@PBA-1965
@Sprint-63
@PBA-2347

Característica: Creación CDT
  YO COMO  cliente
  NECESITO abrir CDT en linea
  PARA no desplazarme hasta una oficina

  @e2e
  @CDT
  @regresion
  Escenario: Creación CDT no enrolado
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Cuando el usuario realiza el flujo con rendimientos "al vencimiento"
    Entonces se muestra el resumen de la creación del CDT

  @e2e
    @CDT
    @regresion
  Esquema del escenario: Creación CDT
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo enrolado sin renovacion"
    Cuando el usuario realiza el flujo con rendimientos "<periodo>"
    Entonces se muestra el resumen de la creación del CDT
    Ejemplos:
      | periodo               |
      | al vencimiento        |
      | antes del vencimiento |
