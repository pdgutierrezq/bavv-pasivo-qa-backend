# language: es
@sprint:60
@issue:PBA-2258
@app:CDA
@feature:Direccion_de_envio_tarjeta
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Incluir campo barrio en pantalla de envío TD CDA
  Yo como usuario definiendo el lugar donde quiero que llegue mi TD
  Necesito un campo para ingresar el barrio
  Para que sea mas detallada la información de la dirección

  Escenario: Pre carga de información en campo barrio cliente actualizado
    Dado que se obtiene un usuario tipo "cliente actualizado"
    Cuando se cargue la pantalla de envio de tarjeta para cda
    Entonces el sistema debe traer la dirección, barrio y ciudad de residencia que tiene en memoria proveniente de crm

  Escenario: Pre carga de información en campo barrio para no cliente o desactualizado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Cuando se cargue la pantalla de envio de tarjeta para cda
    Entonces el sistema debe traer la dirección, barrio y ciudad de residencia que tiene en memoria proveniente de datos de contacto

