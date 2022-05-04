# language: es
@sprint:113
@issue:PBA-4325
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Descifrar la información del servicio devolución de dinero
  YO como* cliente
*Necesito* tener la opción de realizar la devolución exitosa del dinero
  PARA  enviar la información correcta

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-113
  Escenario: Realizar el cifrado de la información*
    Dado que  nos encontramos en el flujo de CDT
    Cuando  se llame el servicio de devolución de dinero PSE
    Entonces  se debe evidenciar la información refundDocType y refundDoc cifrados.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-113
  Escenario: Validar el flujo de pse*
    Dado que  estoy en el flujo de CDT y seleccioné la opción de fondeo por PSE
    Cuando  se llame al servicio de devolución de dinero PSE
    Entonces  me debe permitir continuar el flujo correctamente

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-113
  Escenario: Realizar el descifrado de la información*
    Dado que  nos encontramos en el flujo de CDT
    Cuando  se llame el servicio de devolución de dinero PSE 
    Entonces  el servicio debe retornar respuesta exitosa.
     #Realizar el descifrado de informacion transmitida hacia el punto de API /refund-money-pse-cdt/
     #Utilizando el mismo mecanismo de descifrado de informacion que se usa en enrollment. 
     #Nota: Tener cuidado no utilizar la llave de encripción de ATH.