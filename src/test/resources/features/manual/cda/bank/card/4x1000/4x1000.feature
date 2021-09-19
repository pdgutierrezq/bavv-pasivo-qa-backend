# language: es
@sprint:91
@issue:PBA-3106
@app:CDA
@functionality:Cliente.Info.Tarjeta.4x1000
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Cuenta de ahorros exenta del de 4 x 1000
  YO como cliente en proceso de apertura de cuenta digital
  QUIERO tener la opción de habilitar/deshabilitar el beneficio de 4 x 1000
  PARA aprovechar el beneficio que ofrece el gobierno

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: Check de 4 x Mil en pantalla de tarjeta debito
    Dado que llegué a la pantalla de tarjeta debito
    Cuando cargue la pantalla
    Entonces aparecerá el check de 4 x mil con el siguiente texto “Quiero que mi cuenta de ahorros esté exenta del 4x1000. (Sólo puedes tener una cuenta exenta en el sector financiero). ¿Qué es?”.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: Popup de 4 x Mil en pantalla de tarjeta debito
    Dado que Estoy en la pantalla de tarjeta debito
    Cuando seleccione la opción para saber que es el 4 x mil
    Entonces se mostrará POP Up de que es 4 x mil de acuerdo a mock up “¿Qué es el 4x1000? Es un impuesto creado sobre los movimientos financieros en el que por cada $1000 pesos se pagan $4 pesos al Gobierno. Sólo se podrá marcar una cuenta de ahorros como exenta del 4x1000 en todo el sector financiero. Si tienes otra cuenta exenta con el 4x1000 en otro banco debes desmarcarla con ellos.”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: Cierre de Pop up de 4 x Mil
    Dado que Estoy en el POP up de 4 x mil
    Cuando seleccione la opción para cerrar o entendido del POP Up 4 x mil
    Entonces se deja al usuario en la pantalla de tarjeta debito

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: envío de flag cuando elegí 4 x Mil
    Dado que Estoy en la pantalla de firma y elegí 4 x mil
    Cuando se llame al websocket 2
    Entonces debo notificar en el campo GMF que elegí exención 4 x mil ( GMF=1)

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: envío de flag cuando no elegí 4 x Mil
    Dado que Estoy en la pantalla de firma y no elegí 4 x mil
    Cuando se llame al websocket 2
    Entonces debo notificar en el campo GMF que no elegí exención 4 x mil ( GMF=0)
