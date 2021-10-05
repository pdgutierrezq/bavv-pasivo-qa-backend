# language: es
@sprint:88
@issue:PBA-3371
@app:CDT
@functionality:PSE.Transaccion.Devolución
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Consulta del servicio de devolución del dinero
  YO como cliente que voy a fondear por PSE
  QUIERO que se comunique al banco los datos en donde se haría devolución de dinero
  PARA que sea mas sencillo y no tenga que desplazarme

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-88
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3371)
  Escenario: Consulta del servicio de devolucion de dinero
    Dado que estoy en la pantalla de PSE flujo
    Cuando seleccione la opción para continuar
    Entonces se llamará a los servicios de devolución de dinero, guardar retoma y crear transacción.
