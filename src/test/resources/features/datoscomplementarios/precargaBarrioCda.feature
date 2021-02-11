# language: es
@Frontend:CDA-precarga
@Sprint-59
@PBA-1153

@Back-CRM-Barrio
@PBA-2326

Característica: Incluir campo barrio en formulario datos de contacto CDA
  Yo como usuario definiendo el lugar donde quiero que llegue mi TD y mis datos de contacto
  Necesito un campo para ingresar el barrio
  Para que sea mas detallada la información de la dirección

  @CDA
  @regresion
  Escenario: Pre carga de información en campo barrio para cliente desactualizado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Cuando ingrese a la pantalla de datos de contacto en Cda.
    Entonces se pre cargará la información de barrio que tenga en CRM

