# language: es
@sprint:90
@issue:PBA-3354
@app:CDA
@functionality:insurance
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Funcionalidad icono de password
  YO como cliente no enrolado
  QUIERO tener la opción de ver mi contraseña
  PARA verificar mi contraseña.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-90
  @testrail-evidence:3475/E1
  @testrail-id:511069
  Escenario: Contraseña visible
    Dado que estoy en la pantalla de enrolamiento
    Cuando quiera ver la contraseña
    Entonces  el valor de la contraseña se podrá ver

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-90
  @testrail-evidence:3475/E2
  @testrail-id:511070
  Escenario: Contraseña NO visible
    Dado que estoy en la pantalla de enrolamiento
    Cuando quiera dejar oculta la contraseña
    Entonces  el valor de la contraseña no se podrá ver

