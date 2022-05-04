# language: es
@sprint:96
@issue:PBA-3579
@app:COMMONS
@functionality:Producto.Crear.WS.Nofitication
@layer:backend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Consumo del servicio de notifica apertura
  YO como usuario finalizando el flujo de CDA y CDT
  QUIERO que se llame el servicio de notifica apertura cuenta
  PARA realizar la actualización de la fecha sipla y el envío del mail de bienvenida
  Consumo del servicio NotificaAperturaCuenta desde el WS 2 en Node-js, posterior al consumo exitoso del Radicar producto pasivo 2.
  En caso de que sea fallido el consumo del servicio, continuar con el consumo de los demás servicios.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519034
  Escenario: Consumo del servicio de notifica apertura cuenta
    Dado que se llamó el servicio de RPP 2
    Cuando el llamado sea exitoso
    Entonces se llama el servicio de notifica apertura cuenta .

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519035
  Escenario: Notifica apertura cuenta fallido o exitoso
    Dado que se llamó el servicio de notifica apertura cuenta
    Cuando  el llamado sea exitoso o fallido
    Entonces  Se guarda la respuesta del servicio mas no se tiene en cuenta para continuar.

