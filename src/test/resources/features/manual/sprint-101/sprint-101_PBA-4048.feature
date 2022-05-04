# language: es
@sprint:101
@issue:PBA-4048
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Ajuste devolución de dinero cdt pse (front)

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-101
  Escenario: Campo cédula en formulario de devolución*
    Dado que  Estoy en la pantalla de PSE
    Cuando  Ingrese el número de cédula del dueño de la cuenta a la que se realizaría la devolución del dinero en caso que no se constituya el CDT
    Entonces  el campo debe enviarse en la solicitud del servicio “Refound money” en el cuerpo del mensaje en un campo adicional que se va a llamar “refound document”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-101
  Escenario: Activación botón continuar*
    Dado que  Estoy en la pantalla de PSE e ingrese los datos de devolución de dinero 
    Cuando  Ingrese los datos completos 
    Entonces  se debe activar el botón continuar