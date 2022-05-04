# language: es
@sprint:114
@issue:PBA-4686
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Ajuste envío de indicador nómina digital
  YO como* cliente
*Necesito* que se envíe el indicador de cuenta nómina
  PARA  informar a Banco el producto que estoy aperturando

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-114
  Escenario: Ómina*
    Dado que  se está aperturando el producto de cuenta nómina
    Cuando  se llame el servicio de RPP1 Y RPP2
    Entonces  en el campo AuthInd se debe enviar el valor “true”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-114
  Escenario: Á aperturando el producto de cuenta digital
    Cuando  se llame el servicio de RPP1 Y RPP2
    Entonces  en el campo AuthInd se debe enviar el valor “false”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-114
  Escenario: (back)*
    Dado que  se está aperturando el producto de cdt con retoma
    Cuando  se llame el servicio de RPP1
    Entonces  en el campo AuthInd se debe enviar el valor “false” si el cliente continua con la retoma

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-114
  Escenario: Úa (back)*
    Dado que  se está aperturando el producto de cdt sin retoma o el cliente no continúa con retoma
    Cuando  se llame el servicio de RPP1
    Entonces  en el campo AuthInd se debe enviar el valor “false”
     #    Cuando el cliente desiste de la retoma o no tiene retoma