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

#Escenario 1 -  Check de autorización y activación de botón continuar
#
#Dado que el usuario esta en pantalla de Firma electrónica
#
#Cuando  de check en “Autorizo la firma de documentos”
#
#Entonces el botón continuar se activará
#
#Escenario 2 -  Descarga de PDF con documentos a firmar
#
#Dado que el usuario esta en pantalla de Firma electrónica.
#
#Cuando  de click en Ver Documentos
#
#Entonces se descargará un PDF de prueba.
#
#
#
#

#
#Escenario 5 -  Nombre dinamico
#
#Dado que el usuario esta en pantalla de Firma electrónica
#
#Cuando  cargue la pantalla
#
#Entonces se colocará el nombre de la persona que digitó en el formulario.
