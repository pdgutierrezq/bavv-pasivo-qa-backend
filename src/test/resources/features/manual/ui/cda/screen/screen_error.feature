# language: es
@sprint:117
@issue:PBA-4905
@app:CDA
@functionality:Pantalla.Error
@layer:frontend
@priority:low
@execution:manual
@automation:pending
Característica: Pantalla error cuenta nomina
  Yo como negocio
  Necesito que se le indique al cliente que no lo pude atender por el flujo y cuál es el paso a seguir
  Para tener claridad en los procesos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  @regression:si
  Escenario: Error para Cuenta de Nómina con Convenio
    Dado que el cliente ingresó por el flujo de cuenta de nómina con convenio
    Cuando se genere la pantalla de error de cliente
    Entonces se debe mostrar la pantalla de error indicando que debe acercarse a una oficina con la carta laboral de acuerdo al mockup

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  @regression:si
  Escenario: Error para Cuenta Digital o Depósito
    Dado que el cliente ingresó por el flujo de cuenta digital / depósito
    Cuando se genere la pantalla de error de cliente
    Entonces se debe mostrar la pantalla de error indicando que debe acercarse a una oficina (funcionalidad actual)
