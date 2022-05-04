# language: es
@sprint:115
@issue:PBA-4525
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Enviar indicador de cuenta a back
  YO como* negocio
  QUIERO  que se identifiquen las cuentas de nómina
  PARA  poder hacerle seguimiento en power bi

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-115
  Escenario: Enviar indicador a back nómina*
    Dado que  el cliente ingresó a la URL de nómina
    Cuando  esté en la pantalla de identificación de usuario
    Entonces  el front le debe enviar al back un nuevo parámetro en el servicio de customer accounts para identificar el tipo de cuenta que se va a aperturar (cuenta de nómina).

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-115
  Escenario: Enviar indicador a back cuenta digital*
    Dado que  el cliente ingresó a la URL de cuenta digital 
    Cuando  esté en la pantalla de identificación de usuario
    Entonces  el front le debe enviar al back un nuevo parámetro en el servicio de customer accounts para identificar el tipo de cuenta que se va a aperturar (cuenta digital).