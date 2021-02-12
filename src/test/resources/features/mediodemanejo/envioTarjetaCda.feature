  # language: es
  @Frontend:DireccionEnvioTarjeta
  @Sprint-9
  @PBA-209

  @CDA
  @Sprint-60
  @PBA-2258

  Característica: Incluir campo barrio en pantalla de envío TD CDA
    Yo como usuario definiendo el lugar donde quiero que llegue mi TD
    Necesito un campo para ingresar el barrio
    Para que sea mas detallada la información de la dirección

    @regresion
    Escenario: Pre carga de información en campo barrio cliente actualizado
      Dado que se obtiene un usuario tipo "cliente actualizado"
      Cuando se cargue la pantalla de envio de tarjeta para cdt
      Entonces el sistema debe traer la dirección y ciudad de residencia que tiene en memoria proveniente de crm

    @regresion
    Escenario: Pre carga de información en campo barrio para no cliente o desactualizado
      Dado que se obtiene un usuario tipo "cliente no actualizado"
      Cuando se cargue la pantalla de envio de tarjeta para cdt
      Entonces el sistema debe traer la dirección y ciudad de residencia que tiene en memoria proveniente de datos de contacto

