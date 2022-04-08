# language: es
@sprint:118
@issue:PBA-5028
@app:CDA
@functionality:Pantalla.DatosPersonales.Fecha
@screen:DatosPeronales
@layer:frontend
@priority:low
@regression:yes
@execution:manual
@automation:pending
Característica: Modificaciones de Calendario CDA
  Yo Como Usuario ingresando fecha de nacimiento y expedición de cédula
  Necesito que se incorpore una nueva forma de ingresarlas
  Para sea mas sencillo

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo Día en fecha de nacimiento
    Dado que el usuario esta en pantalla datos de personales
    Cuando entre al campo de día en fecha de nacimiento
    Entonces le permitirá ingresar valores numéricos del 1 al 31

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo Mes fecha de nacimiento
    Dado que el usuario esta en pantalla datos de personales
    Cuando entre al campo de mes en fecha de nacimiento
    Entonces se le desplegarán las siguientes opciones Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre y Diciembre

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo Año fecha de nacimiento
    Dado que el usuario esta en pantalla datos de personales
    Cuando entre al campo de Año en fecha de nacimiento
    Entonces le permitirá ingresar valores numéricos y máximo 4 dígitos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Mensaje de error  mes con 29 Días en fecha de nacimiento
    Dado que el usuario está en pantalla datos de personales
    Cuando se ingrese al campo de día de fecha de nacimiento 30 ó 31 días, se haya seleccionado febrero y el año sea bisiesto
    Entonces se le mostrará el mensaje  “Este mes tiene 29 días, ingresa una fecha válida.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Mensaje de error  mes con 28 Días en fecha de nacimiento
    Dado que el usuario está en pantalla datos de personales
    Cuando se ingrese al campo de día fecha de nacimiento 29, 30 o 31 días, se haya seleccionado febrero y el año no sea bisiesto
    Entonces se le mostrará el mensaje  “Este mes tiene 28 días, ingresa una fecha válida.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Mensaje de error  mes con 30 Días en fecha de nacimiento
    Dado que el usuario esta en pantalla datos de personales
    Cuando se ingrese al campo de día de fecha de nacimiento 31 días, y el mes sea Abril, Junio, Septiembre, Noviembre
    Entonces se le mostrará el mensaje  “Este mes tiene 30 días, ingresa una fecha válida.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo obligatorio fecha de nacimiento
    Dado que el usuario está en pantalla datos de personales
    Cuando entre al campo día, mes o año de fecha de nacimiento, no seleccione información en alguno (día, mes y año) y deje el campo
    Entonces le aparecerá un mensaje informando que “La fecha es obligatoria.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Validación de fecha de nacimiento menor a 18 años y mayor a 103 años
    Dado que estoy en en el campo fecha de nacimiento y ya diligencié día, mes y año
    Cuando  la Fecha de nacimiento sea menor a 18 años y mayor a 103 años
    Entonces se debe mostrar el error “Ingresa una fecha válida.“ y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Validación fecha de nacimiento futura
    Dado que estoy en en el campo fecha de nacimiento y ya diligencié día, mes y año
    Cuando  sea una fecha futura o del día actual
    Entonces  se debe mostrar el error “Una fecha actual o futura no es válida.“ y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo Día en fecha de expedición
    Dado que el usuario está en pantalla datos de personales
    Cuando entre al campo de día en fecha de expedición
    Entonces le permitirá ingresar valores numéricos del 1 al 31

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo Mes fecha de expedición
    Dado que el usuario está en pantalla datos de personales
    Cuando entre al campo de mes en fecha de expedición
    Entonces se le desplegarán las siguientes opciones Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre y Diciembre

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Campo Año fecha de expedición
    Dado que el usuario está en pantalla datos de personales
    Cuando entre al campo de Año en fecha de expedición
    Entonces le permitirá ingresar valores numéricos y máximo 4 dígitos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Mensaje de error  mes con 29 Días en fecha de expedición
    Dado que el usuario esta en pantalla datos de personales
    Cuando se ingrese al campo de día de fecha de expedición 30 o 31 días,  se haya seleccionado febrero y el año sea bisiesto
    Entonces se le mostrará el mensaje  “Este mes tiene 29 días, ingresa una fecha válida.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
  Escenario: Mensaje de error  mes con 28 Días en fecha de expedición
    Dado que el usuario esta en pantalla datos de personales
    Cuando se ingrese al campo de día fecha de expedición 29, 30 o 31 días,  se haya seleccionado febrero y el año no sea bisiesto
    Entonces se le mostrará el mensaje  “Este mes tiene 28 días, ingresa una fecha válida.”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
Escenario: Mensaje de error  mes con 30 Días en fecha de expedición
    Dado que el usuario esta en pantalla datos de personales
    Cuando se ingrese al campo de día de fecha de expedición 31 días, y el mes sea Abril, Junio, Septiembre, Noviembre
    Entonces se le mostrará el mensaje  “Este mes tiene 30 días, ingresa una fecha válida.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
    Escenario: Campo obligatorio fecha de expedición
    Dado que el usuario esta en pantalla datos de personales
    Cuando entre al campo día, mes o año de fecha de expedición, no seleccione información en alguno (día, mes y año) y deje el campo
    Entonces le aparecerá un mensaje informando que “La fecha es obligatoria.” y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
Escenario: Validación + 18 años
    Dado que estoy en en el campo fecha de expedición y ya diligencié día, mes y año
    Cuando  la fecha de expedición de la cédula sea menor a la fecha de nacimiento + 18 años
    Entonces se debe mostrar el error “Ingresa una fecha válida.“. y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
    Escenario: Validación fecha de expedición futura
    Dado que estoy en en el campo fecha de expedición y ya diligencié día, mes y año
    Cuando  sea una fecha futura o del día actual
    Entonces  se debe mostrar el error “Una fecha actual o futura no es válida.“. y será un bloqueante para la activación del botón continuar

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-118
    Escenario: Habilitar campos de fecha expedición
    Dado que estoy en la pantalla de datos personales
    Cuando  diligencié día, mes y año en el campo fecha de nacimiento y sean validas
    Entonces  se habilitan los campos para fecha de expedición
