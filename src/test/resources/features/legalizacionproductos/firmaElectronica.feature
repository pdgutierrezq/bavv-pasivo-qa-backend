  # language: es
  @Frontend:PantallaFirmaElectronica
  @Sprint-11
  @PBA-255
  @construction

  Característica: Pantalla de Firma electrónica
    YO COMO Usuario que ya definí que soy o no declarante
    NECESITO firmar los documentos de mi cuenta de ahorros
    PARA legalizar el proceso de apertura de cuenta

    Escenario: POP UP de que es firmar electrónicamente
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" cuenta cat "false" y canales "true"
      Y que el usuario esta en pantalla de firma electronica
      Cuando ingrese en la opcion ¿Que es?
      Entonces se desplegará lo que es firmar electrónicamente

    Escenario:  Redirección a Pantalla de tips de ahorro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" cuenta cat "false" y canales "true"
      Y que el usuario esta en pantalla de firma electronica
      Cuando Autorice la firma de documentos
      Y  seleccione la opcion continuar
      Entonces pasará a pantalla tips de ahorro

    Escenario:  Redirección a Pantalla de enrolamiento
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" cuenta cat "false" y canales "false"
      Y que el usuario esta en pantalla de firma electronica
      Cuando Autorice la firma de documentos
      Y  seleccione la opcion continuar
      Entonces pasará a pantalla de enrolamiento

    Escenario:  Redirección a Pantalla de tips de ahorro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Cuando que el usuario esta en pantalla de firma electronica
      Entonces Se validara la presencia del nombre ingresado en el formulario de identificacion
