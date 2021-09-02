# language: es
@sprint:89
@issue:PBA-3506
@app:CDA
@feature:insurance
@layer:backend
@priority:low
@regression:yes
@execution:manual
@automation:pending
Característica: Seguro de cuenta
  YO como cliente sin cuenta digital y sin seguro
  QUIERO adquirir el seguro cuando estoy en el proceso de abrir una cuenta digital
  PARA asegurar mi cuenta.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-89
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3506)
  @testrail-id:510058
  Escenario: Valor del seguro
    Dado que me encuentro en el la pantalla de seguro
    Cuando revise el detelle del seguro
    Entonces  el valor mensual del seguro debe ser de $14.800
