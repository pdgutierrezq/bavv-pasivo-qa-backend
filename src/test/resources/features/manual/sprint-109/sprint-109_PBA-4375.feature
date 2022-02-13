# language: es
@sprint:109
@issue:PBA-4375
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Diferenciación cuenta de nómina digital
  YO como* cliente
*Necesito* que se envíe el indicador de cuenta nómina
  PARA  informar a Banco el producto que estoy aperturando

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ómina*
    Dado que  se está aperturando el producto de cuenta nómina
    Cuando  se llame el servicio de RPP1 
    Entonces  en el campo AuthInd se debe enviar el valor “true”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Á aperturando el producto de cuenta digital
    Cuando  se llame el servicio de RPP1 
    Entonces  en el campo AuthInd se debe enviar el valor “false”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Á aperturando el producto de cdt
    Cuando  se llame el servicio de RPP1 
    Entonces  en el campo AuthInd se debe enviar el valor “false” porque aún no está disponible la funcionalidad de retoma