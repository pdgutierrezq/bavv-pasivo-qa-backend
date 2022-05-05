# language: es
@sprint:120
@issue:PBA-4428
@app:CDA
@functionality:Landing
@layer:frontend
@priority:medium
@regression:no
@execution:manual
@automation:pending
Característica: Modificaciones Landing CDA Desktop
  Yo como cliente
  Necesito ver la nueva landing
  Para que sea más llamativa

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-120
  Escenario: Inicio flujo
    Dado que el cliente se encuentra iniciando el flujo
    Cuando llegue a la URL de inicio de cuenta
    Entonces se debe mostrar la nueva Landing (ver mockup)

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-120
  Escenario: Inicio flujo en comenzar
    Dado que el cliente está en la landing
    Cuando de clic en “comenzar”
    Entonces debe ser redirigido a la pantalla del formulario de identificación

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-120
  Escenario: Beneficios
    Dado que el cliente está en la landing
    Cuando le cargue la pantalla
    Entonces debe mostrar la imagen de las tarjetas (Ver mockup) y los slider que indican los beneficios del producto
