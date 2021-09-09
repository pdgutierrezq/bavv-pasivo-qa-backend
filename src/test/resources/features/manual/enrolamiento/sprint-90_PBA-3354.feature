# language: es
@sprint:90
@issue:PBA-3354
@app:CDA
@feature:insurance
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
  @testrail-evidence:informes/Sprint_90/HU3354/enrollamiento/Escenario1
  @testrail-id:510875
  Escenario: Contraseña visible
    Dado que estoy en la pantalla de enrolamiento
    Cuando quiera ver la contraseña
    Entonces  el valor de la contraseña se podrá ver

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-90
  @testrail-evidence:informes/Sprint_90/HU3354/enrollamiento/Escenario2
  Escenario: Contraseña No visible
    Dado que estoy en la pantalla de enrolamiento
    Cuando quiera dejar oculta la contraseña
    Entonces  el valor de la contraseña no se podrá ver

