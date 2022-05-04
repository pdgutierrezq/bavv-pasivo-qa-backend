# language: es
@sprint:108
@issue:PBA-4155
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Cambios en diseño depósito 4 x mil
  YO  como cliente del banco AV Villas
*Necesito* poder abrir un depóstito digital
  PARA  utilizar mi producto

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-108
  Escenario: Pantalla de envío de tarjeta débito*
    Dado que estoy en la pantalla de envío de tarjeta débito y estoy abriendo un depósito digital
    Cuando  cargue la pantalla 
    Entonces  no me aparecerá la opción de exonerar el 4 x mil

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-108
  Escenario: Marcar el depósito 4x1000*
    Dado que estoy en la pantalla de envío de tarjeta débito y estoy abriendo un depósito digital
    Cuando  seleccione la opción para continuar
    Entonces  se guardará en memoria que el cliente no marcará el depósito con el 4 x mil

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-108
  Escenario: Envío en rpp2*
    Dado que se está llamando el websocket 2 y estoy abriendo un depósito digital
    Cuando  se llame el servicio de RPP2 
    Entonces  se llamará el servicio con el campo required GMF en 0

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-108
  Escenario: Pantalla oferta de producto*
    Dado que estoy en la pantalla de oferta de producto y estoy abriendo un depósito digital
    Cuando  cargue la pantalla 
    Entonces  no me aparecerá el pop up de depósito ver más

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-108
  Escenario: Pantalla envío de tarjeta débito cuenta digital*
    Dado que estoy en la pantalla de envío de tarjeta débito y estoy abriendo una cuenta digital 
    Cuando  cargue la pantalla 
    Entonces  me aparecerá el texto “Sólo puedes tener una cuenta exenta en el sector financiero” 
     # 