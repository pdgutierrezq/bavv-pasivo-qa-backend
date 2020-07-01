  # language: es
  @Frontend:DireccionEnvioTarjeta
  @Sprint-9
  @PBA-209
  @pendingEnsureData

  Característica: Pantalla de dirección de envío Tarjeta débito
    YO COMO usuario en pantalla de dirección de envío de tarjeta debito
    NECESITO definir dirección del usuario
    PARA recibir mi tarjeta débito

    Escenario: Cargue de Dirección y ciudad para el envío
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando se cargue la pantalla
      Entonces el sistema debe traer la dirección y ciudad de residencia que tiene en memoria

    Escenario: Opción de modificar dirección de envío y ciudad
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando el cliente "modifica" la direccion y continue
      Entonces saldrá el POP-UP de confirmación con la información ingresada

    Escenario: Confirmación de dirección exitosa
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Y el cliente "modifica" la direccion y continue
      Cuando "acepta" la nueva direccion en el POP-UP
      Entonces pasará a pregunta de no declarante

    Escenario: Modificar dirección de envío
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Y el cliente recuerda la direccion que se precarga de crm
      Y el cliente "modifica" la direccion y continue
      Cuando "no acepta" la nueva direccion en el POP-UP
      Entonces volverá a pantalla de Dirección de envío de tarjeta Débito con la información pre cargada en memoria que venia de CRM

    Escenario: Modificar dirección de envío
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando el cliente "no modifica" la direccion y continue
      Entonces pasará a pregunta de no declarante
