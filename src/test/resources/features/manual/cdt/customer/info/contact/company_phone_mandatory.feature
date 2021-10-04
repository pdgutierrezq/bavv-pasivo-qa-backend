# language: es
@sprint:89
@issue:PBA-3475
@app:CDT
@functionality:Cliente.Info.De_contacto
@screen:datos_personales
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Validaciones en datos de contacto-teléfono de la empresa
  YO como empleado
  QUIERO que se pida obligatoriamente el teléfono de la empresa
  PARA que tenga la información completa en CRM

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-89
  Escenario: Campo obligatorio teléfono de la empresa para empleado
    Dado que estoy en la pantalla de datos de contacto y soy empleado
    Cuando este en el campo teléfono de la empresa , no lo diligencie y pase a otro campo
    Entonces se mostrará el mensaje de error “Este campo es obligatorio.”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-89
  Escenario: Activación del botón continuar
    Dado que estoy en la pantalla de datos de contacto y soy empleado
    Y diligencie todos los campos completos y correctamente (incluyendo el teléfono de la empresa).
    Entonces se activará la opción para continuar.
