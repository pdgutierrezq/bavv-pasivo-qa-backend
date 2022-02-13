# language: es
@sprint:111
@issue:PBA-4326
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Envío servicio devolución dinero pse cifrado
  YO como* cliente
*Necesito* tener la opción de realizar la devolución exitosa del dinero
  PARA  enviar la información correcta 

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-111
  Escenario: Realizar el cifrado de la información*
    Dado que  nos encontramos en el flujo de CDT 
    Cuando  se llame el servicio de devolución de dinero PSE
    Entonces  se debe evidenciar la información refundDocType y refundDoc cifrados.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-111
  Escenario: Validar el flujo de pse*
    Dado que  estoy en el flujo de CDT y seleccioné la opción de fondeo por PSE
    Cuando  se llame al servicio de devolución de dinero PSE 
    Entonces  me debe permitir continuar el flujo correctamente