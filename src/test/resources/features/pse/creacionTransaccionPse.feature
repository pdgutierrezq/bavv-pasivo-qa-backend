  # language: es
  @Frontend:creacionTransaccionPseCdt
  @Sprint-62
  @PBA-2349
  @CDTPENDING
  @regresionPending
  Característica: creacion transaccion PSE

    Yo como usuario definiendo desde donde voy a fondear mi CDT
    Necesito que se redirija al proceso de PSE
    Para fondear mi CDT

    Escenario: Llamar crear transacción de PSE exitosamente
      Dado que se obtiene un usuario tipo "cliente actualizado"
      Cuando se crea la transacción PSE de forma exitosa
      Entonces se envía al cliente a la URL de "PSE externa"

