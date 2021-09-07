# language: es
@run
@sprint:72
@issue:PBA-2886
@app:CDT
@feature:Creacion_de_CDT
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Creación CDT
  YO COMO  cliente
  NECESITO abrir CDT en linea
  PARA no desplazarme hasta una oficina

  @testrail-id:510458
  Escenario: Creación CDT no enrolado
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Cuando el usuario realiza el flujo con rendimientos "al vencimiento"
    Entonces se muestra el resumen de la creación del CDT

  Esquema del escenario: Creación CDT <periodo>
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo enrolado sin renovacion"
    Cuando el usuario realiza el flujo con rendimientos "<periodo>"
    Entonces se muestra el resumen de la creación del CDT
    Ejemplos:
      | periodo               |
      | al vencimiento        |
      | antes del vencimiento |

  @testrail-id:510460
  Escenario: Creación CDT cliente actualizado
    Dado que se obtiene un usuario tipo "cliente actualizado"
    Cuando el usuario realiza el flujo abriendo una cuenta AV Villas
    Entonces se muestra el numero de cuenta que se abrió en pago de rendimientos y en sección de cuenta abierta
