  # language: es
  @Frontend:ValidacionPep
  @Sprint-8
  @PBA-13
  @ok

  Característica: Validación de cliente PEP
    YO COMO no cliente o cliente desactualizado del BAVV
    NECESITO que el banco me valide si soy PEP
    PARA pasar a selección de producto

    Esquema del escenario: Selección de que es o no un cliente PEP
      Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
      Y  el usuario esta en la pantalla de PEP
      Cuando selecciona que "<confirmacion>" es PEP
      Entonces la opcion continuar se activará.
      Ejemplos:
        | confirmacion |
        | si           |
        | no           |

    Escenario: Selección de que no es un cliente PEP
      Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
      Y  el usuario esta en la pantalla de PEP
      Y selecciona que "no" es PEP
      Cuando  ingrese en la opcion continuar
      Entonces  el usuario visualizara la pantalla de ofrecimiento de cuenta

    Escenario: Selección de que es un cliente PEP
      Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
      Y  el usuario esta en la pantalla de PEP
      Y selecciona que "si" es PEP
      Cuando  ingrese en la opcion continuar
      Entonces  el usuario no podrá continuar con el proceso dado que es un PEP mostrándole la pantalla de error

