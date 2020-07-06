  # language: es
  @Frontend:PantallaDeclarante
  @Sprint-10
  @PBA-254

  Característica: Pantalla con pregunta de no declarante
    YO COMO Usuario que ya definí la dirección de entrega de mi Tarjeta débito
    NECESITO seleccionar si soy o no declarante
    PARA guardar la información en el banco

    Escenario: Cierre de POP-UP con descripción de declarante
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y que el usuario esta en POP-UP de lo que es una persona declarante
      Cuando selecciona la opción cerrar o entendido
      Entonces se cierra el POP-UP quedando el cliente en la pantalla de pregunta declarante

    Escenario: Redirección a Pantalla de firma electrónica
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el usuario esta en pantalla pregunta de declarante
      Cuando selecciona la opcion continuar
      Entonces pasará a pantalla de firma electrónica
