# language: es
@sprint:57
@issue:PBA-3371
@app:CDT
@functionality:PSE.Devolucion.Dinero
@screen:devolucion_pse
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Servicio de devolución de dinero
  YO Como Usuario en el proceso de PSE
  QUIERO que se comunique al banco los datos en donde se haría devolución de dinero
  PARA que sea mas sencillo y no tenga que desplazarme

  @testrail-id:516421
  Escenario: Llamado al servicio de devolución de dinero
    Dado que estoy en la pantalla de PSE flujo
    Cuando seleccione la opción para continuar
    Entonces llamará a los servicios de devolución de dinero, guardar retoma y crear transacción.

  @testrail-id:516422
  Escenario: Llamado exitoso del servicio de crear transaccion
    Dado que se llamó el servicio de devolución de dinero
    Cuando sea exitoso o fallido
    Entonces se llamará al servicio guardar retoma y crear transacción

